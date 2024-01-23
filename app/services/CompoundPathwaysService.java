package services;

import entities.CompoundPathways;
import play.db.Database;

import javax.inject.Inject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class CompoundPathwaysService {
    private final Database db;
    private final DatabaseExecutionContext dec;

    @Inject
    public CompoundPathwaysService(Database db, DatabaseExecutionContext dec) {
        this.db = db;
        this.dec = dec;
    }

    public CompletionStage<CompoundPathways> getCompoundPathways(int compoundId, int pathwayId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT * FROM compound_pathways WHERE compound_id = ? AND pathway_id = ?");
                    statement.setInt(1, compoundId);
                    statement.setInt(2, pathwayId);
                    ResultSet resultSet = statement.executeQuery();

                    if (resultSet.next()) {
                        return new CompoundPathways(
                                resultSet.getInt("compound_id"),
                                resultSet.getInt("pathway_id"),
                                resultSet.getString("created"),
                                resultSet.getString("last_updated"));
                    }
                    return null;
                }), dec);
    }

    public CompletionStage<Boolean> addCompoundPathways(CompoundPathways compoundPathway) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "INSERT INTO compound_pathways (compound_id, pathway_id, created, last_updated) VALUES (?, ?, ?, ?)");

                    statement.setInt(1, compoundPathway.getCompoundId());
                    statement.setInt(2, compoundPathway.getPathwayId());
                    statement.setString(3, compoundPathway.getCreated());
                    statement.setString(4, compoundPathway.getLastUpdated());

                    int rowsInserted = statement.executeUpdate();
                    return rowsInserted > 0;
                }));
    }

    public CompletionStage<Boolean> deleteCompoundPathways(int compoundId, int pathwayId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "DELETE FROM compound_pathways WHERE compound_id = ? AND pathway_id = ?");
                    statement.setInt(1, compoundId);
                    statement.setInt(2, pathwayId);
                    int rowsDeleted = statement.executeUpdate();
                    return rowsDeleted > 0;
                }));
    }

    public CompletionStage<List<CompoundPathways>> getAllCompoundPathways() {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    List<CompoundPathways> compoundPathwayList = new ArrayList<>();
                    ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM compound_pathways");
                    while (resultSet.next()) {
                        CompoundPathways CompoundPathway = new CompoundPathways(
                                resultSet.getInt("compound_id"),
                                resultSet.getInt("pathway_id"),
                                resultSet.getString("created"),
                                resultSet.getString("last_updated"));
                        compoundPathwayList.add(CompoundPathway);
                    }
                    return compoundPathwayList;
                }));
    }

    public CompletionStage<Boolean> updateCompoundPathways(CompoundPathways compoundPathway, int compoundId, int pathwayId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "UPDATE compound_pathways SET created = ?, last_updated = ? " +
                                    "WHERE compound_id = ? AND pathway_id = ?");

                    statement.setString(1, compoundPathway.getCreated());
                    statement.setString(2, compoundPathway.getLastUpdated());
                    statement.setInt(3, compoundId);
                    statement.setInt(4, pathwayId);

                    int rowsUpdated = statement.executeUpdate();
                    return rowsUpdated > 0;
                }));
    }

    public CompletionStage<List<CompoundPathways>> getCompoundPathwaysInRange(int startCompoundId, int endCompoundId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    List<CompoundPathways> compoundPathwaysList = new ArrayList<>();
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT * FROM compound_pathways WHERE compound_id BETWEEN ? AND ?");
                    statement.setInt(1, startCompoundId);
                    statement.setInt(2, endCompoundId);
                    ResultSet resultSet = statement.executeQuery();

                    while (resultSet.next()) {
                        CompoundPathways compoundPathway = new CompoundPathways(
                                resultSet.getInt("compound_id"),
                                resultSet.getInt("pathway_id"),
                                resultSet.getString("created"),
                                resultSet.getString("last_updated"));
                        compoundPathwaysList.add(compoundPathway);
                    }
                    return compoundPathwaysList;
                }));
    }


    public CompletionStage<List<CompoundPathways>> getCompoundPathwaysByCompoundId(int compoundId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    List<CompoundPathways> compoundPathwaysList = new ArrayList<>();
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT * FROM compound_pathways WHERE compound_id = ?");
                    statement.setInt(1, compoundId);
                    ResultSet resultSet = statement.executeQuery();

                    while (resultSet.next()) {
                        CompoundPathways compoundPathway = new CompoundPathways(
                                resultSet.getInt("compound_id"),
                                resultSet.getInt("pathway_id"),
                                resultSet.getString("created"),
                                resultSet.getString("last_updated"));
                        compoundPathwaysList.add(compoundPathway);
                    }
                    return compoundPathwaysList;
                }));
    }

}
