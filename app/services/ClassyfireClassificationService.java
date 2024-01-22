package services;

import entities.ClassyfireClassificationDictionary;
import play.db.Database;

import javax.inject.Inject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class ClassyfireClassificationService {
    private final Database db;
    private final DatabaseExecutionContext dec;

    @Inject
    public ClassyfireClassificationService(Database db, DatabaseExecutionContext dec) {
        this.db = db;
        this.dec = dec;
    }

    public CompletionStage<ClassyfireClassificationDictionary> getClassyfireClassification(int id) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT * FROM classyfire_classification_dictionary WHERE classyfire_id = ?");
                    statement.setInt(1, id);
                    ResultSet resultSet = statement.executeQuery();

                    if (resultSet.next()) {
                        ClassyfireClassificationDictionary classyfireClassificationDictionary = new ClassyfireClassificationDictionary();
                        classyfireClassificationDictionary.setClassyfireId(resultSet.getInt("classyfire_id"));
                        classyfireClassificationDictionary.setNodeId(resultSet.getString("node_id"));
                        classyfireClassificationDictionary.setNodeName(resultSet.getString("node_name"));
                        classyfireClassificationDictionary.setCreatedDictionary(resultSet.getString("created"));
                        classyfireClassificationDictionary.setLastUpdatedDictionary(resultSet.getString("last_updated"));
                        return classyfireClassificationDictionary;
                    }
                    return null;
                }), dec);
    }

    public CompletionStage<Boolean> addClassyfireClassification(ClassyfireClassificationDictionary classification) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "INSERT INTO classyfire_classification_dictionary (classyfire_id, node_id, node_name, created, last_updated) " +
                                    "VALUES (?, ?, ?, ?, ?)");

                    statement.setInt(1, classification.getClassyfireId());
                    statement.setString(2, classification.getNodeId());
                    statement.setString(3, classification.getNodeName());
                    statement.setString(4, classification.getCreatedDictionary());
                    statement.setString(5, classification.getLastUpdatedDictionary());

                    int rowsInserted = statement.executeUpdate();
                    return rowsInserted > 0;
                }), dec);
    }

    public CompletionStage<Boolean> deleteClassyfireClassification(int classyfireId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "DELETE FROM classyfire_classification_dictionary WHERE classyfire_id = ?");
                    statement.setInt(1, classyfireId);
                    int rowsDeleted = statement.executeUpdate();
                    return rowsDeleted > 0;
                }), dec);
    }

    public CompletionStage<List<ClassyfireClassificationDictionary>> getAllClassyfireClassifications() {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM classyfire_classification_dictionary");
                    List<ClassyfireClassificationDictionary> classyfireClassificationDictionaries = new ArrayList<>();
                    while (resultSet.next()) {
                        ClassyfireClassificationDictionary classyfireClassificationDictionary = new ClassyfireClassificationDictionary();
                        classyfireClassificationDictionary.setClassyfireId(resultSet.getInt("classyfire_id"));
                        classyfireClassificationDictionary.setNodeId(resultSet.getString("node_id"));
                        classyfireClassificationDictionary.setNodeName(resultSet.getString("node_name"));
                        classyfireClassificationDictionary.setCreatedDictionary(resultSet.getString("created"));
                        classyfireClassificationDictionary.setLastUpdatedDictionary(resultSet.getString("last_updated"));


                        classyfireClassificationDictionaries.add(classyfireClassificationDictionary);
                    }
                    return classyfireClassificationDictionaries;
                }), dec);
    }

    public CompletionStage<Boolean> updateClassyfireClassification(ClassyfireClassificationDictionary classyfireClassificationDictionary, int id) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "UPDATE classyfire_classification_dictionary SET node_id = ?, node_name = ?, created = ?, " +
                                    "last_updated = ? WHERE classyfire_id = ?");

                    statement.setString(1, classyfireClassificationDictionary.getNodeId());
                    statement.setString(2, classyfireClassificationDictionary.getNodeName());
                    statement.setString(3, classyfireClassificationDictionary.getCreatedDictionary());
                    statement.setString(4, classyfireClassificationDictionary.getLastUpdatedDictionary());
                    statement.setInt(5, classyfireClassificationDictionary.getClassyfireId());

                    int rowsUpdated = statement.executeUpdate();
                    return rowsUpdated > 0;
                }), dec);
    }

    public CompletionStage<List<ClassyfireClassificationDictionary>> getClassyfireClassificationInRange(int startId, int endId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT * FROM classyfire_classification_dictionary WHERE classyfire_id >= ? AND classyfire_id <= ?");
                    statement.setInt(1, startId);
                    statement.setInt(2, endId);
                    ResultSet resultSet = statement.executeQuery();

                    List<ClassyfireClassificationDictionary> classyfireClassificationsInRangeDictionary = new ArrayList<>();
                    while (resultSet.next()) {
                        ClassyfireClassificationDictionary classyfireClassificationDictionary = new ClassyfireClassificationDictionary();
                        classyfireClassificationDictionary.setClassyfireId(resultSet.getInt("classyfire_id"));
                        classyfireClassificationDictionary.setNodeId(resultSet.getString("node_id"));
                        classyfireClassificationDictionary.setNodeName(resultSet.getString("node_name"));
                        classyfireClassificationDictionary.setCreatedDictionary(resultSet.getString("created"));
                        classyfireClassificationDictionary.setLastUpdatedDictionary(resultSet.getString("last_updated"));

                        classyfireClassificationsInRangeDictionary.add(classyfireClassificationDictionary);
                    }
                    return classyfireClassificationsInRangeDictionary;
                }), dec);
    }
}
