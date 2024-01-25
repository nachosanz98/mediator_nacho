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
                            "SELECT c.*, " +
                                    "cl.node_id, cl.kingdom, cl.super_class, cl.main_class, cl.sub_class, cl.direct_parent," +
                                    "cl.level_7, cl.level_8, cl.level_9, cl.level_10, cl.level_11, cl.created as createdClassyfire, " +
                                    "cl.last_updated as lastUpdatedClassyfire " +
                                    "FROM classyfire_classification_dictionary c " +
                                    "LEFT JOIN classyfire_classification cl ON c.node_id = cl.node_id " +
                                    "WHERE c.classyfire_id = ?");
                    statement.setInt(1, id);
                    ResultSet resultSet = statement.executeQuery();

                    if (resultSet.next()) {
                        ClassyfireClassificationDictionary classyfireClassificationDictionary = new ClassyfireClassificationDictionary();
                        classyfireClassificationDictionary.setClassyfireId(resultSet.getInt("classyfire_id"));
                        classyfireClassificationDictionary.setNodeId(resultSet.getString("node_id"));
                        classyfireClassificationDictionary.setNodeName(resultSet.getString("node_name"));
                        classyfireClassificationDictionary.setCreatedDictionary(resultSet.getString("created"));
                        classyfireClassificationDictionary.setLastUpdatedDictionary(resultSet.getString("last_updated"));
                        
                        /*classyfire_classification_dictionary*/
                        classyfireClassificationDictionary.setKingdom(resultSet.getString("kingdom"));
                        classyfireClassificationDictionary.setSuperClass(resultSet.getString("super_class"));
                        classyfireClassificationDictionary.setMainClass(resultSet.getString("main_class"));
                        classyfireClassificationDictionary.setSubClass(resultSet.getString("sub_class"));
                        classyfireClassificationDictionary.setDirectParent(resultSet.getString("direct_parent"));
                        classyfireClassificationDictionary.setLevel7(resultSet.getString("level_7"));
                        classyfireClassificationDictionary.setLevel8(resultSet.getString("level_8"));
                        classyfireClassificationDictionary.setLevel9(resultSet.getString("level_9"));
                        classyfireClassificationDictionary.setLevel10(resultSet.getString("level_10"));
                        classyfireClassificationDictionary.setLevel11(resultSet.getString("level_11"));
                        classyfireClassificationDictionary.setCreated(resultSet.getString("createdClassyfire"));
                        classyfireClassificationDictionary.setLastUpdated(resultSet.getString("lastUpdatedClassyfire"));
                        
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

                    /* classyfire_classification_dictionary */
                    if (rowsInserted > 0 && !classification.getCreated().isEmpty()) {
                        PreparedStatement classyStatement = connection.prepareStatement(
                                "INSERT INTO classyfire_classification (node_id, kingdom, super_class, main_class, sub_class, " +
                                        "direct_parent, level_7, level_8, level_9, level_10, level_11, created, last_updated) " +
                                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                        classyStatement.setString(1, classification.getNodeId());
                        classyStatement.setString(2, classification.getKingdom());
                        classyStatement.setString(3, classification.getSuperClass());
                        classyStatement.setString(4, classification.getMainClass());
                        classyStatement.setString(5, classification.getSubClass());
                        classyStatement.setString(6, classification.getDirectParent());
                        classyStatement.setString(7, classification.getLevel7());
                        classyStatement.setString(8, classification.getLevel8());
                        classyStatement.setString(9, classification.getLevel9());
                        classyStatement.setString(10, classification.getLevel10());
                        classyStatement.setString(11, classification.getLevel11());
                        classyStatement.setString(12, classification.getCreated());
                        classyStatement.setString(13, classification.getLastUpdated());
                        int classyRowsInserted = classyStatement.executeUpdate();
                        if (classyRowsInserted == 0) {
                            return false;
                        }
                    }
                    return rowsInserted > 0;
                }), dec);
    }

    public CompletionStage<Boolean> deleteClassyfireClassification(int classyfireId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement firstStatement = connection.prepareStatement(
                            "SELECT * FROM classyfire_classification_dictionary WHERE classyfire_id = ?");
                    firstStatement.setInt(1, classyfireId);
                    ResultSet resultSet = firstStatement.executeQuery();
                    String nodeId = "";
                    if (resultSet.next()){
                        ClassyfireClassificationDictionary classyfireClassificationDictionary = new ClassyfireClassificationDictionary();
                        classyfireClassificationDictionary.setNodeId(resultSet.getString("node_id"));
                        nodeId = classyfireClassificationDictionary.getNodeId();
                    }

                    PreparedStatement secondStatement = connection.prepareStatement(
                            "DELETE FROM classyfire_classification_dictionary WHERE classyfire_id = ?");
                    secondStatement.setInt(1, classyfireId);

                    int rowsDeleted = secondStatement.executeUpdate();
                    if (rowsDeleted > 0) {
                        PreparedStatement classyStatement = connection.prepareStatement(
                                "DELETE FROM classyfire_classification WHERE node_id = ?");
                        classyStatement.setString(1, nodeId);
                        classyStatement.executeUpdate();
                    }
                    return rowsDeleted > 0;
                }), dec);
    }

    public CompletionStage<List<ClassyfireClassificationDictionary>> getAllClassyfireClassifications() {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT c.*, " +
                                    "cl.node_id, cl.kingdom, cl.super_class, cl.main_class, cl.sub_class, cl.direct_parent," +
                                    "cl.level_7, cl.level_8, cl.level_9, cl.level_10, cl.level_11, cl.created as createdClassyfire, " +
                                    "cl.last_updated as lastUpdatedClassyfire " +
                                    "FROM classyfire_classification_dictionary c " +
                                    "LEFT JOIN classyfire_classification cl ON c.node_id = cl.node_id");

                    ResultSet resultSet = statement.executeQuery();
                    List<ClassyfireClassificationDictionary> classyfireClassificationDictionaries = new ArrayList<>();

                    while (resultSet.next()) {
                        ClassyfireClassificationDictionary classyfireClassificationDictionary = new ClassyfireClassificationDictionary();
                        classyfireClassificationDictionary.setClassyfireId(resultSet.getInt("classyfire_id"));
                        classyfireClassificationDictionary.setNodeId(resultSet.getString("node_id"));
                        classyfireClassificationDictionary.setNodeName(resultSet.getString("node_name"));
                        classyfireClassificationDictionary.setCreatedDictionary(resultSet.getString("created"));
                        classyfireClassificationDictionary.setLastUpdatedDictionary(resultSet.getString("last_updated"));

                        /*classyfire_classification_dictionary*/
                        classyfireClassificationDictionary.setKingdom(resultSet.getString("kingdom"));
                        classyfireClassificationDictionary.setSuperClass(resultSet.getString("super_class"));
                        classyfireClassificationDictionary.setMainClass(resultSet.getString("main_class"));
                        classyfireClassificationDictionary.setSubClass(resultSet.getString("sub_class"));
                        classyfireClassificationDictionary.setDirectParent(resultSet.getString("direct_parent"));
                        classyfireClassificationDictionary.setLevel7(resultSet.getString("level_7"));
                        classyfireClassificationDictionary.setLevel8(resultSet.getString("level_8"));
                        classyfireClassificationDictionary.setLevel9(resultSet.getString("level_9"));
                        classyfireClassificationDictionary.setLevel10(resultSet.getString("level_10"));
                        classyfireClassificationDictionary.setLevel11(resultSet.getString("level_11"));
                        classyfireClassificationDictionary.setCreated(resultSet.getString("createdClassyfire"));
                        classyfireClassificationDictionary.setLastUpdated(resultSet.getString("lastUpdatedClassyfire"));

                        classyfireClassificationDictionaries.add(classyfireClassificationDictionary);
                    }
                    return classyfireClassificationDictionaries;
                }), dec);
    }

    public CompletionStage<Boolean> updateClassyfireClassification(ClassyfireClassificationDictionary classyfireClassificationDictionary, int id) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "UPDATE classyfire_classification_dictionary SET node_name = ?, created = ?, " +
                                    "last_updated = ? WHERE classyfire_id = ?");

                    statement.setString(1, classyfireClassificationDictionary.getNodeName());
                    statement.setString(2, classyfireClassificationDictionary.getCreatedDictionary());
                    statement.setString(3, classyfireClassificationDictionary.getLastUpdatedDictionary());
                    statement.setInt(4, id);

                    int rowsUpdated = statement.executeUpdate();

                    /* classyfire_classification_dictionary */
                    if (classyfireClassificationDictionary.getLastUpdated() != null && !classyfireClassificationDictionary.getLastUpdated().isEmpty()) {
                        PreparedStatement classyStatement = connection.prepareStatement(
                                "UPDATE classyfire_classification SET kingdom = ?, super_class = ?, main_class = ?," +
                                        " sub_class = ?, direct_parent = ?, level_7 = ?, level_8 = ?, level_9 = ?, " +
                                        "level_10 = ?, level_11 = ?, created = ?, last_updated = ? ");

                        classyStatement.setString(1, classyfireClassificationDictionary.getKingdom());
                        classyStatement.setString(2, classyfireClassificationDictionary.getSuperClass());
                        classyStatement.setString(3, classyfireClassificationDictionary.getMainClass());
                        classyStatement.setString(4, classyfireClassificationDictionary.getSubClass());
                        classyStatement.setString(5, classyfireClassificationDictionary.getDirectParent());
                        classyStatement.setString(6, classyfireClassificationDictionary.getLevel7());
                        classyStatement.setString(7, classyfireClassificationDictionary.getLevel8());
                        classyStatement.setString(8, classyfireClassificationDictionary.getLevel9());
                        classyStatement.setString(9, classyfireClassificationDictionary.getLevel10());
                        classyStatement.setString(10, classyfireClassificationDictionary.getLevel11());
                        classyStatement.setString(11, classyfireClassificationDictionary.getCreated());
                        classyStatement.setString(12, classyfireClassificationDictionary.getLastUpdated());
                        int classyRowsInserted = classyStatement.executeUpdate();
                        if (classyRowsInserted == 0) {
                            return false;
                        }
                    }
                    return rowsUpdated > 0;
                }), dec);
    }

    public CompletionStage<List<ClassyfireClassificationDictionary>> getClassyfireClassificationInRange(int startId, int endId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT c.*, " +
                                    "cl.node_id, cl.kingdom, cl.super_class, cl.main_class, cl.sub_class, cl.direct_parent," +
                                    "cl.level_7, cl.level_8, cl.level_9, cl.level_10, cl.level_11, cl.created as createdClassyfire, " +
                                    "cl.last_updated as lastUpdatedClassyfire " +
                                    "FROM classyfire_classification_dictionary c " +
                                    "LEFT JOIN classyfire_classification cl ON c.node_id = cl.node_id " +
                                    "WHERE c.classyfire_id BETWEEN ? AND ?");
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

                        /*classyfire_classification_dictionary*/
                        classyfireClassificationDictionary.setKingdom(resultSet.getString("kingdom"));
                        classyfireClassificationDictionary.setSuperClass(resultSet.getString("super_class"));
                        classyfireClassificationDictionary.setMainClass(resultSet.getString("main_class"));
                        classyfireClassificationDictionary.setSubClass(resultSet.getString("sub_class"));
                        classyfireClassificationDictionary.setDirectParent(resultSet.getString("direct_parent"));
                        classyfireClassificationDictionary.setLevel7(resultSet.getString("level_7"));
                        classyfireClassificationDictionary.setLevel8(resultSet.getString("level_8"));
                        classyfireClassificationDictionary.setLevel9(resultSet.getString("level_9"));
                        classyfireClassificationDictionary.setLevel10(resultSet.getString("level_10"));
                        classyfireClassificationDictionary.setLevel11(resultSet.getString("level_11"));
                        classyfireClassificationDictionary.setCreated(resultSet.getString("createdClassyfire"));
                        classyfireClassificationDictionary.setLastUpdated(resultSet.getString("lastUpdatedClassyfire"));

                        classyfireClassificationsInRangeDictionary.add(classyfireClassificationDictionary);
                    }
                    return classyfireClassificationsInRangeDictionary;
                }), dec);
    }
}
