package services;

import entities.CompoundClassyfireClassification;
import play.db.Database;

import javax.inject.Inject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class CompoundClassyfireService {
    private final Database db;
    private final DatabaseExecutionContext dec;

    @Inject
    public CompoundClassyfireService(Database db, DatabaseExecutionContext dec) {
        this.db = db;
        this.dec = dec;
    }

    public CompletionStage<CompoundClassyfireClassification> getCompoundClassyfire(int compoundId, String nodeId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT * FROM compound_classyfire_classification WHERE compound_id = ? AND node_id = ?");
                    statement.setInt(1, compoundId);
                    statement.setString(2, nodeId);
                    ResultSet resultSet = statement.executeQuery();

                    if (resultSet.next()) {
                        return new CompoundClassyfireClassification(
                                resultSet.getInt("compound_id"),
                                resultSet.getString("node_id"),
                                resultSet.getString("created"),
                                resultSet.getString("last_updated"));
                    }
                    return null;
                }), dec);
    }

    public CompletionStage<Boolean> addCompoundClassyfire(CompoundClassyfireClassification compoundClassyfire) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "INSERT INTO compound_classyfire_classification (compound_id, node_id, created, last_updated) " +
                                    "VALUES (?, ?, ?, ?)");

                    statement.setInt(1, compoundClassyfire.getCompoundId());
                    statement.setString(2, compoundClassyfire.getNodeId());
                    statement.setString(4, compoundClassyfire.getCreated());
                    statement.setString(5, compoundClassyfire.getLastUpdated());

                    int rowsInserted = statement.executeUpdate();
                    return rowsInserted > 0;
                }));
    }

    public CompletionStage<Boolean> deleteCompoundClassyfire(int compoundId, String nodeId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "DELETE FROM compound_classyfire_classification WHERE compound_id = ? AND node_id = ?");
                    statement.setInt(1, compoundId);
                    statement.setString(2, nodeId);
                    int rowsDeleted = statement.executeUpdate();
                    return rowsDeleted > 0;
                }));
    }

    public CompletionStage<List<CompoundClassyfireClassification>> getAllCompoundClassyfire() {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    List<CompoundClassyfireClassification> compoundClassyfireList = new ArrayList<>();
                    ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM compound_classyfire_classification");
                    while (resultSet.next()) {
                        CompoundClassyfireClassification compoundClassyfire = new CompoundClassyfireClassification(
                                resultSet.getInt("compound_id"),
                                resultSet.getString("node_id"),
                                resultSet.getString("created"),
                                resultSet.getString("last_updated"));
                        compoundClassyfireList.add(compoundClassyfire);
                    }
                    return compoundClassyfireList;
                }));
    }

    public CompletionStage<Boolean> updateCompoundClassyfire(CompoundClassyfireClassification compoundClassyfire, int compoundId, String nodeId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "UPDATE compound_classyfire_classification SET created = ?, last_updated = ? " +
                                    "WHERE compound_id = ? AND node_id = ?");

                    statement.setString(1, compoundClassyfire.getCreated());
                    statement.setString(2, compoundClassyfire.getLastUpdated());
                    statement.setInt(3, compoundId);
                    statement.setString(4, nodeId);

                    int rowsUpdated = statement.executeUpdate();
                    return rowsUpdated > 0;
                }));
    }

    public CompletionStage<List<CompoundClassyfireClassification>> getCompoundClassyfireInRange(int startCompoundId, int endCompoundId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    List<CompoundClassyfireClassification> compoundClassyfireList = new ArrayList<>();
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT * FROM compound_classyfire_classification WHERE compound_id BETWEEN ? AND ?");
                    statement.setInt(1, startCompoundId);
                    statement.setInt(2, endCompoundId);
                    ResultSet resultSet = statement.executeQuery();

                    while (resultSet.next()) {
                        CompoundClassyfireClassification compoundClassyfire = new CompoundClassyfireClassification(
                                resultSet.getInt("compound_id"),
                                resultSet.getString("node_id"),
                                resultSet.getString("created"),
                                resultSet.getString("last_updated"));
                        compoundClassyfireList.add(compoundClassyfire);
                    }
                    return compoundClassyfireList;
                }));
    }


    public CompletionStage<List<CompoundClassyfireClassification>> getCompoundClassyfireByCompoundId(int compoundId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    List<CompoundClassyfireClassification> compoundClassyfireList = new ArrayList<>();
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT * FROM compound_classyfire_classification WHERE compound_id = ?");
                    statement.setInt(1, compoundId);
                    ResultSet resultSet = statement.executeQuery();

                    while (resultSet.next()) {
                        CompoundClassyfireClassification compoundClassyfire = new CompoundClassyfireClassification(
                                resultSet.getInt("compound_id"),
                                resultSet.getString("node_id"),
                                resultSet.getString("created"),
                                resultSet.getString("last_updated"));
                        compoundClassyfireList.add(compoundClassyfire);
                    }
                    return compoundClassyfireList;
                }));
    }
}

