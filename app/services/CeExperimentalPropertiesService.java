package services;

import entities.CeExperimentalProperties;
import play.db.Database;

import javax.inject.Inject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class CeExperimentalPropertiesService {
    private final Database db;
    private final DatabaseExecutionContext dec;

    @Inject
    public CeExperimentalPropertiesService(Database db, DatabaseExecutionContext dec) {
        this.db = db;
        this.dec = dec;
    }

    public CompletionStage<CeExperimentalProperties> getCeExperimentalProperty(int id) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT * FROM ce_experimental_properties WHERE ce_exp_prop_id = ?");
                    statement.setInt(1, id);
                    ResultSet resultSet = statement.executeQuery();

                    if (resultSet.next()) {
                        return new CeExperimentalProperties(
                                resultSet.getInt("ce_exp_prop_id"),
                                resultSet.getInt("buffer"),
                                resultSet.getInt("temperature"),
                                resultSet.getInt("ionization_mode"),
                                resultSet.getInt("polarity"),
                                resultSet.getString("created"),
                                resultSet.getString("last_updated"));
                    }
                    return null;
                }), dec);
    }

    public CompletionStage<Boolean> addCeExperimentalProperty(CeExperimentalProperties ceExpProp) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "INSERT INTO ce_experimental_properties (buffer, temperature, ionization_mode, " +
                                    "polarity, created, last_updated) VALUES (?, ?, ?, ?, ?, ?)");

                    statement.setInt(1, ceExpProp.getBuffer());
                    statement.setInt(2, ceExpProp.getTemperature());
                    statement.setInt(3, ceExpProp.getIonizationMode());
                    statement.setInt(4, ceExpProp.getPolarity());
                    statement.setString(5, ceExpProp.getCreated());
                    statement.setString(6, ceExpProp.getLastUpdated());

                    int rowsInserted = statement.executeUpdate();
                    return rowsInserted > 0;
                }), dec);
    }

    public CompletionStage<Boolean> deleteCeExperimentalProperty(int id) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "DELETE FROM ce_experimental_properties WHERE ce_exp_prop_id = ?");
                    statement.setInt(1, id);
                    int rowsDeleted = statement.executeUpdate();
                    return rowsDeleted > 0;
                }), dec);
    }

    public CompletionStage<List<CeExperimentalProperties>> getAllCeExperimentalProperties() {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    List<CeExperimentalProperties> ceExpPropList = new ArrayList<>();
                    ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM ce_experimental_properties");
                    while (resultSet.next()) {
                        CeExperimentalProperties ceExpProp = new CeExperimentalProperties(
                                resultSet.getInt("ce_exp_prop_id"),
                                resultSet.getInt("buffer"),
                                resultSet.getInt("temperature"),
                                resultSet.getInt("ionization_mode"),
                                resultSet.getInt("polarity"),
                                resultSet.getString("created"),
                                resultSet.getString("last_updated"));
                        ceExpPropList.add(ceExpProp);
                    }
                    return ceExpPropList;
                }), dec);
    }

    public CompletionStage<Boolean> updateCeExperimentalProperty(CeExperimentalProperties ceExpProp, int id) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "UPDATE ce_experimental_properties SET buffer = ?, temperature = ?, ionization_mode = ?, " +
                                    "polarity = ?, created = ?, last_updated = ? WHERE ce_exp_prop_id = ?");

                    statement.setInt(1, ceExpProp.getBuffer());
                    statement.setInt(2, ceExpProp.getTemperature());
                    statement.setInt(3, ceExpProp.getIonizationMode());
                    statement.setInt(4, ceExpProp.getPolarity());
                    statement.setString(5, ceExpProp.getCreated());
                    statement.setString(6, ceExpProp.getLastUpdated());
                    statement.setInt(7, id);

                    int rowsUpdated = statement.executeUpdate();
                    return rowsUpdated > 0;
                }), dec);
    }

    public CompletionStage<List<CeExperimentalProperties>> getCeExperimentalPropertiesInRange(int startId, int endId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    List<CeExperimentalProperties> ceExpPropList = new ArrayList<>();
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT * FROM ce_experimental_properties WHERE ce_exp_prop_id BETWEEN ? AND ?");
                    statement.setInt(1, startId);
                    statement.setInt(2, endId);
                    ResultSet resultSet = statement.executeQuery();

                    while (resultSet.next()) {
                        CeExperimentalProperties ceExpProp = new CeExperimentalProperties(
                                resultSet.getInt("ce_exp_prop_id"),
                                resultSet.getInt("buffer"),
                                resultSet.getInt("temperature"),
                                resultSet.getInt("ionization_mode"),
                                resultSet.getInt("polarity"),
                                resultSet.getString("created"),
                                resultSet.getString("last_updated"));
                        ceExpPropList.add(ceExpProp);
                    }
                    return ceExpPropList;
                }), dec);
    }
}
