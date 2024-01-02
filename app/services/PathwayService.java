package services;

import entities.Pathway;
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
public class PathwayService {
    private final Database db;
    private final DatabaseExecutionContext dec;

    @Inject
    public PathwayService(Database db, DatabaseExecutionContext dec) {
        this.db = db;
        this.dec = dec;
    }

    public CompletionStage<Pathway> getPathway(int pathwayId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT * FROM pathways WHERE pathway_id = ?");
                    statement.setInt(1, pathwayId);
                    ResultSet resultSet = statement.executeQuery();

                    if (resultSet.next()) {
                        Pathway pathway = new Pathway();
                        pathway.setPathwayId(resultSet.getInt("pathway_id"));
                        pathway.setPathwayMap(resultSet.getString("pathway_map"));
                        pathway.setPathwayName(resultSet.getString("pathway_name"));
                        pathway.setCreated(resultSet.getString("created"));
                        pathway.setLastUpdated(resultSet.getString("last_updated"));
                        return pathway;
                    }
                    return null;
                }), dec);
    }

    public CompletionStage<Boolean> addPathway(Pathway pathway) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "INSERT INTO pathways (pathway_map, pathway_name, created, last_updated) VALUES (?, ?, ?, ?)");

                    statement.setString(1, pathway.getPathwayMap());
                    statement.setString(2, pathway.getPathwayName());
                    statement.setString(3, pathway.getCreated());
                    statement.setString(4, pathway.getLastUpdated());

                    int rowsInserted = statement.executeUpdate();
                    return rowsInserted > 0;
                }), dec);
    }

    public CompletionStage<Boolean> deletePathway(int pathwayId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "DELETE FROM pathways WHERE pathway_id = ?");
                    statement.setInt(1, pathwayId);
                    int rowsDeleted = statement.executeUpdate();
                    return rowsDeleted > 0;
                }), dec);
    }

    public CompletionStage<List<Pathway>> getAllPathways() {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM pathways");
                    List<Pathway> pathways = new ArrayList<>();
                    while (resultSet.next()) {
                        Pathway pathway = new Pathway();
                        pathway.setPathwayId(resultSet.getInt("pathway_id"));
                        pathway.setPathwayMap(resultSet.getString("pathway_map"));
                        pathway.setPathwayName(resultSet.getString("pathway_name"));
                        pathway.setCreated(resultSet.getString("created"));
                        pathway.setLastUpdated(resultSet.getString("last_updated"));
                        pathways.add(pathway);
                    }
                    return pathways;
                }), dec);
    }

    public CompletionStage<Boolean> updatePathway(Pathway pathway) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "UPDATE pathways SET pathway_map = ?, pathway_name = ?, created = ?, last_updated = ? " +
                                    "WHERE pathway_id = ?");

                    statement.setString(1, pathway.getPathwayMap());
                    statement.setString(2, pathway.getPathwayName());
                    statement.setString(3, pathway.getCreated());
                    statement.setString(4, pathway.getLastUpdated());
                    statement.setInt(5, pathway.getPathwayId());

                    int rowsUpdated = statement.executeUpdate();
                    return rowsUpdated > 0;
                }), dec);
    }

    public CompletionStage<List<Pathway>> getPathwaysInRange(int startId, int endId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT * FROM pathways WHERE pathway_id BETWEEN ? AND ?");
                    statement.setInt(1, startId);
                    statement.setInt(2, endId);
                    ResultSet resultSet = statement.executeQuery();

                    List<Pathway> pathwaysInRange = new ArrayList<>();
                    while (resultSet.next()) {
                        Pathway pathway = new Pathway();
                        pathway.setPathwayId(resultSet.getInt("pathway_id"));
                        pathway.setPathwayMap(resultSet.getString("pathway_map"));
                        pathway.setPathwayName(resultSet.getString("pathway_name"));
                        pathway.setCreated(resultSet.getString("created"));
                        pathway.setLastUpdated(resultSet.getString("last_updated"));
                        pathwaysInRange.add(pathway);
                    }
                    return pathwaysInRange;
                }), dec);
    }
}