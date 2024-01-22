package services;

import entities.CompoundCas;
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
public class CompoundCasService {
    private final Database db;
    private final DatabaseExecutionContext dec;

    @Inject
    public CompoundCasService(Database db, DatabaseExecutionContext dec) {
        this.db = db;
        this.dec = dec;
    }

    public CompletionStage<CompoundCas> getCompoundCas(String casId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT * FROM compounds_cas WHERE cas_id = ?");
                    statement.setString(1, casId);
                    ResultSet resultSet = statement.executeQuery();

                    if (resultSet.next()) {
                        CompoundCas compoundCas = new CompoundCas();
                        compoundCas.setCasId(resultSet.getString("cas_id"));
                        compoundCas.setFormula(resultSet.getString("formula"));
                        compoundCas.setMass(resultSet.getDouble("mass"));
                        compoundCas.setInchi(resultSet.getString("inchi"));
                        compoundCas.setInchiKey(resultSet.getString("inchi_key"));
                        compoundCas.setCreated(resultSet.getString("created"));
                        compoundCas.setLastUpdated(resultSet.getString("last_updated"));
                        return compoundCas;
                    }
                    return null;
                }), dec);
    }

    public CompletionStage<Boolean> addCompoundCas(CompoundCas compoundCas) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "INSERT INTO compounds_cas (cas_id, formula, mass, inchi, inchi_key, created, last_updated) " +
                                    "VALUES (?, ?, ?, ?, ?, ?, ?)");

                    statement.setString(1, compoundCas.getCasId());
                    statement.setString(2, compoundCas.getFormula());
                    statement.setDouble(3, compoundCas.getMass());
                    statement.setString(4, compoundCas.getInchi());
                    statement.setString(5, compoundCas.getInchiKey());
                    statement.setString(6, compoundCas.getCreated());
                    statement.setString(7, compoundCas.getLastUpdated());

                    int rowsInserted = statement.executeUpdate();
                    return rowsInserted > 0;
                }), dec);
    }

    public CompletionStage<Boolean> deleteCompoundCas(String casId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "DELETE FROM compounds_cas WHERE cas_id = ?");
                    statement.setString(1, casId);
                    int rowsDeleted = statement.executeUpdate();
                    return rowsDeleted > 0;
                }), dec);
    }

    public CompletionStage<List<CompoundCas>> getAllCompoundCas() {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM compounds_cas");
                    List<CompoundCas> compoundCasList = new ArrayList<>();
                    while (resultSet.next()) {
                        CompoundCas compoundCas = new CompoundCas();
                        compoundCas.setCasId(resultSet.getString("cas_id"));
                        compoundCas.setFormula(resultSet.getString("formula"));
                        compoundCas.setMass(resultSet.getDouble("mass"));
                        compoundCas.setInchi(resultSet.getString("inchi"));
                        compoundCas.setInchiKey(resultSet.getString("inchi_key"));
                        compoundCas.setCreated(resultSet.getString("created"));
                        compoundCas.setLastUpdated(resultSet.getString("last_updated"));
                        compoundCasList.add(compoundCas);
                    }
                    return compoundCasList;
                }), dec);
    }

    public CompletionStage<Boolean> updateCompoundCas(CompoundCas compoundCas, String casId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "UPDATE compounds_cas SET formula = ?, mass = ?, inchi = ?, inchi_key = ?, " +
                                    "created = ?, last_updated = ? WHERE cas_id = ?");

                    statement.setString(1, compoundCas.getFormula());
                    statement.setDouble(2, compoundCas.getMass());
                    statement.setString(3, compoundCas.getInchi());
                    statement.setString(4, compoundCas.getInchiKey());
                    statement.setString(5, compoundCas.getCreated());
                    statement.setString(6, compoundCas.getLastUpdated());
                    statement.setString(7, casId);

                    int rowsUpdated = statement.executeUpdate();
                    return rowsUpdated > 0;
                }), dec);
    }

    public CompletionStage<List<CompoundCas>> getCompoundCasInRange(int startId, int endId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT * FROM compounds_cas WHERE cas_id BETWEEN ? AND ?");
                    statement.setInt(1, startId);
                    statement.setInt(2, endId);
                    ResultSet resultSet = statement.executeQuery();

                    List<CompoundCas> compoundCasInRange = new ArrayList<>();
                    while (resultSet.next()) {
                        CompoundCas compoundCas = new CompoundCas();
                        compoundCas.setCasId(resultSet.getString("cas_id"));
                        compoundCas.setFormula(resultSet.getString("formula"));
                        compoundCas.setMass(resultSet.getDouble("mass"));
                        compoundCas.setInchi(resultSet.getString("inchi"));
                        compoundCas.setInchiKey(resultSet.getString("inchi_key"));
                        compoundCas.setCreated(resultSet.getString("created"));
                        compoundCas.setLastUpdated(resultSet.getString("last_updated"));
                        compoundCasInRange.add(compoundCas);
                    }
                    return compoundCasInRange;
                }), dec);
    }
}