package services;

import entities.CompoundChain;
import play.db.Database;

import javax.inject.Inject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class CompoundChainService {
    private final Database db;
    private final DatabaseExecutionContext dec;

    @Inject
    public CompoundChainService(Database db, DatabaseExecutionContext dec) {
        this.db = db;
        this.dec = dec;
    }

    public CompletionStage<CompoundChain> getCompoundChain(int compoundId, int chainId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT * FROM compound_chain WHERE compound_id = ? AND chain_id = ?");
                    statement.setInt(1, compoundId);
                    statement.setInt(2, chainId);
                    ResultSet resultSet = statement.executeQuery();

                    if (resultSet.next()) {
                        return new CompoundChain(
                                resultSet.getInt("compound_id"),
                                resultSet.getInt("chain_id"),
                                resultSet.getInt("number_chains"),
                                resultSet.getString("created"),
                                resultSet.getString("last_updated"));
                    }
                    return null;
                }), dec);
    }

    public CompletionStage<Boolean> addCompoundChain(CompoundChain compoundChain) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "INSERT INTO compound_chain (compound_id, chain_id, number_chains, created, last_updated) VALUES (?, ?, ?, ?, ?)");

                    statement.setInt(1, compoundChain.getCompoundId());
                    statement.setInt(2, compoundChain.getChainId());
                    statement.setInt(3, compoundChain.getNumberChains());
                    statement.setString(4, compoundChain.getCreated());
                    statement.setString(5, compoundChain.getLastUpdated());

                    int rowsInserted = statement.executeUpdate();
                    return rowsInserted > 0;
                }));
    }

    public CompletionStage<Boolean> deleteCompoundChain(int compoundId, int chainId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "DELETE FROM compound_chain WHERE compound_id = ? AND chain_id = ?");
                    statement.setInt(1, compoundId);
                    statement.setInt(2, chainId);
                    int rowsDeleted = statement.executeUpdate();
                    return rowsDeleted > 0;
                }));
    }

    public CompletionStage<List<CompoundChain>> getAllCompoundChain() {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    List<CompoundChain> compoundChainList = new ArrayList<>();
                    ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM compound_chain");
                    while (resultSet.next()) {
                        CompoundChain compoundChain = new CompoundChain(
                                resultSet.getInt("compound_id"),
                                resultSet.getInt("chain_id"),
                                resultSet.getInt("number_chains"),
                                resultSet.getString("created"),
                                resultSet.getString("last_updated"));
                        compoundChainList.add(compoundChain);
                    }
                    return compoundChainList;
                }));
    }

    public CompletionStage<Boolean> updateCompoundChain(CompoundChain compoundChain, int compoundId, int chainId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "UPDATE compound_chain SET number_chains = ?, created = ?, last_updated = ? " +
                                    "WHERE compound_id = ? AND chain_id = ?");

                    statement.setInt(1, compoundChain.getNumberChains());
                    statement.setString(2, compoundChain.getCreated());
                    statement.setString(3, compoundChain.getLastUpdated());
                    statement.setInt(4, compoundId);
                    statement.setInt(5, chainId);

                    int rowsUpdated = statement.executeUpdate();
                    return rowsUpdated > 0;
                }));
    }

    public CompletionStage<List<CompoundChain>> getCompoundChainInRange(int startCompoundId, int endCompoundId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    List<CompoundChain> compoundChainList = new ArrayList<>();
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT * FROM compound_chain WHERE compound_id BETWEEN ? AND ?");
                    statement.setInt(1, startCompoundId);
                    statement.setInt(2, endCompoundId);
                    ResultSet resultSet = statement.executeQuery();

                    while (resultSet.next()) {
                        CompoundChain compoundChain = new CompoundChain(
                                resultSet.getInt("compound_id"),
                                resultSet.getInt("chain_id"),
                                resultSet.getInt("number_chains"),
                                resultSet.getString("created"),
                                resultSet.getString("last_updated"));
                        compoundChainList.add(compoundChain);
                    }
                    return compoundChainList;
                }));
    }


    public CompletionStage<List<CompoundChain>> getCompoundChainsByCompoundId(int compoundId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    List<CompoundChain> compoundChainList = new ArrayList<>();
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT * FROM compound_chain WHERE compound_id = ?");
                    statement.setInt(1, compoundId);
                    ResultSet resultSet = statement.executeQuery();

                    while (resultSet.next()) {
                        CompoundChain compoundChain = new CompoundChain(
                                resultSet.getInt("compound_id"),
                                resultSet.getInt("chain_id"),
                                resultSet.getInt("number_chains"),
                                resultSet.getString("created"),
                                resultSet.getString("last_updated"));
                        compoundChainList.add(compoundChain);
                    }
                    return compoundChainList;
                }));
    }
}
