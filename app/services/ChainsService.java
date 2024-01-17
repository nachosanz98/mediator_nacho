package services;

import entities.Chains;
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
public class ChainsService {
    private final Database db;
    private final DatabaseExecutionContext dec;

    @Inject
    public ChainsService(Database db, DatabaseExecutionContext dec) {
        this.db = db;
        this.dec = dec;
    }

    public CompletionStage<Chains> getChains(int chainsId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT * FROM chains WHERE chain_id = ?");
                    statement.setInt(1, chainsId);
                    ResultSet resultSet = statement.executeQuery();

                    if (resultSet.next()) {
                        Chains chains = new Chains();
                        chains.setChainsId(resultSet.getInt("chain_id"));
                        chains.setNumCarbons(resultSet.getInt("num_carbons"));
                        chains.setDoubleBonds(resultSet.getInt("double_bonds"));
                        chains.setOxidation(resultSet.getString("oxidation"));
                        chains.setMass(resultSet.getDouble("mass"));
                        chains.setFormula(resultSet.getString("formula"));
                        chains.setCreated(resultSet.getString("created"));
                        chains.setLastUpdated(resultSet.getString("last_updated"));
                        return chains;                    }
                    return null;
                }), dec);
    }

    public CompletionStage<Boolean> addChains(Chains chains) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "INSERT INTO chains (num_carbons, double_bonds, oxidation, mass, formula, created, " +
                                    "last_updated) VALUES (?, ?, ?, ?, ?, ?, ?)");

                    statement.setInt(1, chains.getNumCarbons());
                    statement.setInt(2, chains.getDoubleBonds());
                    statement.setString(3, chains.getOxidation());
                    statement.setDouble(4, chains.getMass());
                    statement.setString(5, chains.getFormula());
                    statement.setString(6, chains.getCreated());
                    statement.setString(7, chains.getLastUpdated());

                    int rowsInserted = statement.executeUpdate();
                    return rowsInserted > 0;
                }), dec);
    }

    public CompletionStage<Boolean> deleteChains(int chainId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "DELETE FROM chains WHERE chain_id = ?");
                    statement.setInt(1, chainId);
                    int rowsDeleted = statement.executeUpdate();
                    return rowsDeleted > 0;
                }), dec);
    }

    public CompletionStage<List<Chains>> getAllChains() {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM chains");
                    List<Chains> chainsList = new ArrayList<>();
                    while (resultSet.next()) {
                        Chains chains = new Chains();
                        chains.setChainsId(resultSet.getInt("chain_id"));
                        chains.setNumCarbons(resultSet.getInt("num_carbons"));
                        chains.setDoubleBonds(resultSet.getInt("double_bonds"));
                        chains.setOxidation(resultSet.getString("oxidation"));
                        chains.setMass(resultSet.getDouble("mass"));
                        chains.setFormula(resultSet.getString("formula"));
                        chains.setCreated(resultSet.getString("created"));
                        chains.setLastUpdated(resultSet.getString("last_updated"));
                        chainsList.add(chains);
                    }
                    return chainsList;
                }), dec);
    }

    public CompletionStage<Boolean> updateChains(Chains chains, int id) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "UPDATE chains SET num_carbons = ?, double_bonds = ?, oxidation = ?, " +
                                    "mass = ?, formula = ?, created = ?, last_updated = ? WHERE chain_id = ?");

                    statement.setInt(1, chains.getNumCarbons());
                    statement.setInt(2, chains.getDoubleBonds());
                    statement.setString(3, chains.getOxidation());
                    statement.setDouble(4, chains.getMass());
                    statement.setString(5, chains.getFormula());
                    statement.setString(6, chains.getCreated());
                    statement.setString(7, chains.getLastUpdated());
                    statement.setInt(8, id);

                    int rowsUpdated = statement.executeUpdate();
                    return rowsUpdated > 0;
                }), dec);
    }

    public CompletionStage<List<Chains>> getChainsInRange(int startId, int endId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT * FROM chains WHERE chain_id BETWEEN ? AND ?");
                    statement.setInt(1, startId);
                    statement.setInt(2, endId);
                    ResultSet resultSet = statement.executeQuery();

                    List<Chains> chainsInRange = new ArrayList<>();
                    while (resultSet.next()) {
                        Chains chains = new Chains();
                        chains.setChainsId(resultSet.getInt("chain_id"));
                        chains.setNumCarbons(resultSet.getInt("num_carbons"));
                        chains.setDoubleBonds(resultSet.getInt("double_bonds"));
                        chains.setOxidation(resultSet.getString("oxidation"));
                        chains.setMass(resultSet.getDouble("mass"));
                        chains.setFormula(resultSet.getString("formula"));
                        chains.setCreated(resultSet.getString("created"));
                        chains.setLastUpdated(resultSet.getString("last_updated"));
                        chainsInRange.add(chains);
                    }
                    return chainsInRange;
                }), dec);
    }
}
