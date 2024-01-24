package services;

import entities.CompoundsGen;
import play.db.Database;

import javax.inject.Inject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class CompoundsGenService {
    private final Database db;
    private final DatabaseExecutionContext dec;

    @Inject
    public CompoundsGenService(Database db, DatabaseExecutionContext dec) {
        this.db = db;
        this.dec = dec;
    }

    public CompletionStage<CompoundsGen> getCompoundsGen(int compoundId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT * FROM compounds_gen WHERE compound_id = ?");
                    statement.setInt(1, compoundId);
                    ResultSet resultSet = statement.executeQuery();

                    if (resultSet.next()) {
                        CompoundsGen compound = new CompoundsGen();
                        compound.setMineId(resultSet.getString("MINE_id"));
                        compound.setMineFileId(resultSet.getString("MINE_file_id"));
                        compound.setCompoundName(resultSet.getString("compound_name"));
                        compound.setFormula(resultSet.getString("formula"));
                        compound.setMass(resultSet.getDouble("mass"));
                        compound.setChargeType(resultSet.getInt("charge_type"));
                        compound.setChargeNumber(resultSet.getInt("charge_number"));
                        compound.setNpLikeness(resultSet.getDouble("np_likeness"));
                        compound.setFormulaType(resultSet.getString("formula_type"));
                        compound.setFormulaTypeInt(resultSet.getInt("formula_type_int"));
                        compound.setCreated(resultSet.getString("created"));
                        compound.setLastUpdated(resultSet.getString("last_updated"));
                        return compound;                    }
                    return null;
                }), dec);
    }

    public CompletionStage<Boolean> addCompoundsGen(CompoundsGen compound) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "INSERT INTO compounds_gen (MINE_id, MINE_file_id, compound_name, formula, mass, " +
                                    "charge_type, charge_number, np_likeness, formula_type, formula_type_int, " +
                                    "created, last_updated) " +
                                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                    statement.setString(1, compound.getMineId());
                    statement.setString(2, compound.getMineFileId());
                    statement.setString(3, compound.getCompoundName());
                    statement.setString(4, compound.getFormula());
                    statement.setDouble(5, compound.getMass());
                    statement.setInt(6, compound.getChargeType());
                    statement.setInt(7, compound.getChargeNumber());
                    statement.setDouble(8, compound.getNpLikeness());
                    statement.setString(9, compound.getFormulaType());
                    statement.setInt(10, compound.getFormulaTypeInt());
                    statement.setString(11, compound.getCreated());
                    statement.setString(12, compound.getLastUpdated());
                        

                    int rowsInserted = statement.executeUpdate();
                    return rowsInserted > 0;
                }), dec);
    }

    public CompletionStage<Boolean> deleteCompoundsGen(int compoundId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "DELETE FROM compounds_gen WHERE compound_id = ?");
                    statement.setInt(1, compoundId);
                    statement.executeUpdate();
                    int rowsDeleted = statement.executeUpdate();
                    return rowsDeleted > 0;
                }), dec);
    }

    public CompletionStage<List<CompoundsGen>> getAllCompoundsGen() {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM compounds_gen");
                    List<CompoundsGen> compoundsList = new ArrayList<>();
                    while (resultSet.next()) {
                        CompoundsGen compound = new CompoundsGen();
                        compound.setMineId(resultSet.getString("MINE_id"));
                        compound.setMineFileId(resultSet.getString("MINE_file_id"));
                        compound.setCompoundName(resultSet.getString("compound_name"));
                        compound.setFormula(resultSet.getString("formula"));
                        compound.setMass(resultSet.getDouble("mass"));
                        compound.setChargeType(resultSet.getInt("charge_type"));
                        compound.setChargeNumber(resultSet.getInt("charge_number"));
                        compound.setNpLikeness(resultSet.getDouble("np_likeness"));
                        compound.setFormulaType(resultSet.getString("formula_type"));
                        compound.setFormulaTypeInt(resultSet.getInt("formula_type_int"));
                        compound.setCreated(resultSet.getString("created"));
                        compound.setLastUpdated(resultSet.getString("last_updated"));
                    }
                    return compoundsList;
                }), dec);
    }

    public CompletionStage<Boolean> updateCompoundsGen(CompoundsGen compound, int id) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                        PreparedStatement statement = connection.prepareStatement(
                                "UPDATE compounds_gen SET MINE_id = ?, compound_name = ?, formula = ?, mass = ?, charge_type = ?, " +
                                        "charge_number = ?, np_likeness = ?, formula_type = ?, formula_type_int = ?, " +
                                        "created = ?, last_updated = ? WHERE compound_id = ?");
                        statement.setString(1, compound.getMineId());
                        statement.setString(2, compound.getCompoundName());
                        statement.setString(3, compound.getFormula());
                        statement.setDouble(4, compound.getMass());
                        statement.setInt(5, compound.getChargeType());
                        statement.setInt(6, compound.getChargeNumber());
                        statement.setDouble(7, compound.getNpLikeness());
                        statement.setString(8, compound.getFormulaType());
                        statement.setInt(9, compound.getFormulaTypeInt());
                        statement.setString(10, compound.getCreated());
                        statement.setString(11, compound.getLastUpdated());
                        statement.setInt(12, id);
                    int rowsUpdated = statement.executeUpdate();
                    return rowsUpdated > 0;
                }), dec);
    }

    public CompletionStage<List<CompoundsGen>> getCompoundsGenInRange(int startId, int endId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT * FROM chains WHERE compound_id BETWEEN ? AND ?");
                    statement.setInt(1, startId);
                    statement.setInt(2, endId);
                    ResultSet resultSet = statement.executeQuery();

                    List<CompoundsGen> compoundInRange = new ArrayList<>();
                    while (resultSet.next()) {
                        CompoundsGen compound = new CompoundsGen();
                        compound.setMineId(resultSet.getString("MINE_id"));
                        compound.setMineFileId(resultSet.getString("MINE_file_id"));
                        compound.setCompoundName(resultSet.getString("compound_name"));
                        compound.setFormula(resultSet.getString("formula"));
                        compound.setMass(resultSet.getDouble("mass"));
                        compound.setChargeType(resultSet.getInt("charge_type"));
                        compound.setChargeNumber(resultSet.getInt("charge_number"));
                        compound.setNpLikeness(resultSet.getDouble("np_likeness"));
                        compound.setFormulaType(resultSet.getString("formula_type"));
                        compound.setFormulaTypeInt(resultSet.getInt("formula_type_int"));
                        compound.setCreated(resultSet.getString("created"));
                        compound.setLastUpdated(resultSet.getString("last_updated"));
                        compoundInRange.add(compound);
                    }
                    return compoundInRange;
                }), dec);
    }
}
