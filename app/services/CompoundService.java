package services;

import entities.Compound;
import play.db.Database;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Singleton
public class CompoundService {
    private final Database db;
    private final DatabaseExecutionContext dec;

    @Inject
    public CompoundService(Database db, DatabaseExecutionContext dec) {
        this.db = db;
        this.dec = dec;
    }

    public CompletionStage<Compound> getCompound(int compoundId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT * FROM compounds WHERE compound_id = ?");
                    statement.setInt(1, compoundId);
                    ResultSet resultSet = statement.executeQuery();

                    if (resultSet.next()) {
                        Compound compound = new Compound();
                        compound.setCompoundId(resultSet.getInt("compound_id"));
                        compound.setCasId(resultSet.getString("cas_id"));
                        compound.setCompoundName(resultSet.getString("compound_name"));
                        compound.setFormula(resultSet.getString("formula"));
                        compound.setMass(resultSet.getDouble("mass"));
                        compound.setChargeType(resultSet.getInt("charge_type"));
                        compound.setChargeNumber(resultSet.getInt("charge_number"));
                        compound.setFormulaType(resultSet.getString("formula_type"));
                        compound.setCompoundType(resultSet.getInt("compound_type"));
                        compound.setCompoundStatus(resultSet.getInt("compound_status"));
                        compound.setCreated(resultSet.getString("created"));
                        compound.setLastUpdated(resultSet.getString("last_updated"));
                        compound.setFormulaTypeInt(resultSet.getInt("formula_type_int"));
                        compound.setLogP(resultSet.getDouble("logP"));
                        return compound;
                    }
                    return null;
                }), dec);
    }

    public CompletionStage<Boolean> addCompound(Compound compound) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "INSERT INTO compounds (cas_id, compound_name, formula, mass, charge_type, " +
                                    "charge_number, formula_type, compound_type, compound_status, created, last_updated, " +
                                    "formula_type_int, logP) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

                    statement.setString(1, compound.getCasId());
                    statement.setString(2, compound.getCompoundName());
                    statement.setString(3, compound.getFormula());
                    statement.setDouble(4, compound.getMass());
                    statement.setInt(5, compound.getChargeType());
                    statement.setInt(6, compound.getChargeNumber());
                    statement.setString(7, compound.getFormulaType());
                    statement.setInt(8, compound.getCompoundType());
                    statement.setInt(9, compound.getCompoundStatus());
                    statement.setString(10, compound.getCreated());
                    statement.setString(11, compound.getLastUpdated());
                    statement.setInt(12, compound.getFormulaTypeInt());
                    statement.setDouble(13, compound.getLogP());

                    int rowsInserted = statement.executeUpdate();
                    return rowsInserted > 0;
                }), dec);
    }

    public CompletionStage<Boolean> deleteCompound(int compoundId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "DELETE FROM compounds WHERE compound_id = ?");
                    statement.setInt(1, compoundId);
                    int rowsDeleted = statement.executeUpdate();
                    return rowsDeleted > 0;
                }), dec);
    }

    public CompletionStage<List<Compound>> getAllCompounds() {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM compounds");
                    List<Compound> compounds = new ArrayList<>();
                    while (resultSet.next()) {
                        Compound compound = new Compound();
                        compound.setCompoundId(resultSet.getInt("compound_id"));
                        compound.setCasId(resultSet.getString("cas_id"));
                        compound.setCompoundName(resultSet.getString("compound_name"));
                        compound.setFormula(resultSet.getString("formula"));
                        compound.setMass(resultSet.getDouble("mass"));
                        compound.setChargeType(resultSet.getInt("charge_type"));
                        compound.setChargeNumber(resultSet.getInt("charge_number"));
                        compound.setFormulaType(resultSet.getString("formula_type"));
                        compound.setCompoundType(resultSet.getInt("compound_type"));
                        compound.setCompoundStatus(resultSet.getInt("compound_status"));
                        compound.setCreated(resultSet.getString("created"));
                        compound.setLastUpdated(resultSet.getString("last_updated"));
                        compound.setFormulaTypeInt(resultSet.getInt("formula_type_int"));
                        compound.setLogP(resultSet.getDouble("logP"));
                        compounds.add(compound);
                    }
                    return compounds;
                }), dec);
    }

    public CompletionStage<Boolean> updateCompound(Compound compound) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "UPDATE compounds SET cas_id = ?, compound_name = ?, formula = ?, mass = ?, " +
                                    "charge_type = ?, charge_number = ?, formula_type = ?, compound_type = ?, " +
                                    "compound_status = ?, created = ?, last_updated = ?, formula_type_int = ?, logP = ? " +
                                    "WHERE compound_id = ?");

                    statement.setString(1, compound.getCasId());
                    statement.setString(2, compound.getCompoundName());
                    statement.setString(3, compound.getFormula());
                    statement.setDouble(4, compound.getMass());
                    statement.setInt(5, compound.getChargeType());
                    statement.setInt(6, compound.getChargeNumber());
                    statement.setString(7, compound.getFormulaType());
                    statement.setInt(8, compound.getCompoundType());
                    statement.setInt(9, compound.getCompoundStatus());
                    statement.setString(10, compound.getCreated());
                    statement.setString(11, compound.getLastUpdated());
                    statement.setInt(12, compound.getFormulaTypeInt());
                    statement.setDouble(13, compound.getLogP());
                    statement.setInt(14, compound.getCompoundId());

                    int rowsUpdated = statement.executeUpdate();
                    return rowsUpdated > 0;
                }), dec);
    }

    public CompletionStage<List<Compound>> getCompoundsInRange(int startId, int endId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT * FROM compounds WHERE compound_id BETWEEN ? AND ?");
                    statement.setInt(1, startId);
                    statement.setInt(2, endId);
                    ResultSet resultSet = statement.executeQuery();

                    List<Compound> compoundsInRange = new ArrayList<>();
                    while (resultSet.next()) {
                        Compound compound = new Compound();
                        compound.setCompoundId(resultSet.getInt("compound_id"));
                        compound.setCasId(resultSet.getString("cas_id"));
                        compound.setCompoundName(resultSet.getString("compound_name"));
                        compound.setFormula(resultSet.getString("formula"));
                        compound.setMass(resultSet.getDouble("mass"));
                        compound.setChargeType(resultSet.getInt("charge_type"));
                        compound.setChargeNumber(resultSet.getInt("charge_number"));
                        compound.setFormulaType(resultSet.getString("formula_type"));
                        compound.setCompoundType(resultSet.getInt("compound_type"));
                        compound.setCompoundStatus(resultSet.getInt("compound_status"));
                        compound.setCreated(resultSet.getString("created"));
                        compound.setLastUpdated(resultSet.getString("last_updated"));
                        compound.setFormulaTypeInt(resultSet.getInt("formula_type_int"));
                        compound.setLogP(resultSet.getDouble("logP"));
                        compoundsInRange.add(compound);
                    }
                    return compoundsInRange;
                }), dec);
    }
}