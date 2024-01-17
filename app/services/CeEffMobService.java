package services;

import entities.CeEffMob;
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
public class CeEffMobService {
    private final Database db;
    private final DatabaseExecutionContext dec;

    @Inject
    public CeEffMobService(Database db, DatabaseExecutionContext dec) {
        this.db = db;
        this.dec = dec;
    }

    public CompletionStage<CeEffMob> getCeEffMob(int ceEffMobId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT * FROM ce_eff_mob WHERE ce_eff_mob_id = ?");
                    statement.setInt(1, ceEffMobId);
                    ResultSet resultSet = statement.executeQuery();

                    if (resultSet.next()) {
                        CeEffMob ceEffMob = new CeEffMob();
                        ceEffMob.setCeEffMobId(resultSet.getInt("ce_eff_mob_id"));
                        ceEffMob.setCeCompoundId(resultSet.getInt("ce_compound_id"));
                        ceEffMob.setCeExpPropId(resultSet.getInt("ce_exp_prop_id"));
                        ceEffMob.setCembioId(resultSet.getInt("cembio_id"));
                        ceEffMob.setEffMobility(resultSet.getDouble("eff_mobility"));
                        ceEffMob.setCreated(resultSet.getString("created"));
                        ceEffMob.setLastUpdated(resultSet.getString("last_updated"));
                        return ceEffMob;
                    }
                    return null;
                }), dec);
    }

    public CompletionStage<Boolean> addCeEffMob(CeEffMob ceEffMob) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "INSERT INTO ce_eff_mob (ce_compound_id, ce_exp_prop_id, cembio_id, eff_mobility, " +
                                    "created, last_updated) VALUES (?, ?, ?, ?, ?, ?)");

                    statement.setInt(1, ceEffMob.getCeCompoundId());
                    statement.setInt(2, ceEffMob.getCeExpPropId());
                    statement.setInt(3, ceEffMob.getCembioId());
                    statement.setDouble(4, ceEffMob.getEffMobility());
                    statement.setString(5, ceEffMob.getCreated());
                    statement.setString(6, ceEffMob.getLastUpdated());

                    int rowsInserted = statement.executeUpdate();
                    return rowsInserted > 0;
                }), dec);
    }

    public CompletionStage<Boolean> deleteCeEffMob(int ceEffMobId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "DELETE FROM ce_eff_mob WHERE ce_eff_mob_id = ?");
                    statement.setInt(1, ceEffMobId);
                    int rowsDeleted = statement.executeUpdate();
                    return rowsDeleted > 0;
                }), dec);
    }

    public CompletionStage<List<CeEffMob>> getAllCeEffMobs() {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM ce_eff_mob");
                    List<CeEffMob> ceEffMobs = new ArrayList<>();
                    while (resultSet.next()) {
                        CeEffMob ceEffMob = new CeEffMob();
                        ceEffMob.setCeEffMobId(resultSet.getInt("ce_eff_mob_id"));
                        ceEffMob.setCeCompoundId(resultSet.getInt("ce_compound_id"));
                        ceEffMob.setCeExpPropId(resultSet.getInt("ce_exp_prop_id"));
                        ceEffMob.setCembioId(resultSet.getInt("cembio_id"));
                        ceEffMob.setEffMobility(resultSet.getDouble("eff_mobility"));
                        ceEffMob.setCreated(resultSet.getString("created"));
                        ceEffMob.setLastUpdated(resultSet.getString("last_updated"));
                        ceEffMobs.add(ceEffMob);
                    }
                    return ceEffMobs;
                }), dec);
    }

    public CompletionStage<Boolean> updateCeEffMob(CeEffMob ceEffMob, int id) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "UPDATE ce_eff_mob SET ce_compound_id = ?, ce_exp_prop_id = ?, cembio_id = ?, " +
                                    "eff_mobility = ?, created = ?, last_updated = ? WHERE ce_eff_mob_id = ?");

                    statement.setInt(1, ceEffMob.getCeCompoundId());
                    statement.setInt(2, ceEffMob.getCeExpPropId());
                    statement.setInt(3, ceEffMob.getCembioId());
                    statement.setDouble(4, ceEffMob.getEffMobility());
                    statement.setString(5, ceEffMob.getCreated());
                    statement.setString(6, ceEffMob.getLastUpdated());
                    statement.setInt(7, id);

                    int rowsUpdated = statement.executeUpdate();
                    return rowsUpdated > 0;
                }), dec);
    }

    public CompletionStage<List<CeEffMob>> getCeEffMobInRange(int startId, int endId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT * FROM ce_eff_mob WHERE ce_eff_mob_id BETWEEN ? AND ?");
                    statement.setInt(1, startId);
                    statement.setInt(2, endId);
                    ResultSet resultSet = statement.executeQuery();

                    List<CeEffMob> ceEffMobsInRange = new ArrayList<>();
                    while (resultSet.next()) {
                        CeEffMob ceEffMob = new CeEffMob();
                        ceEffMob.setCeEffMobId(resultSet.getInt("ce_eff_mob_id"));
                        ceEffMob.setCeCompoundId(resultSet.getInt("ce_compound_id"));
                        ceEffMob.setCeExpPropId(resultSet.getInt("ce_exp_prop_id"));
                        ceEffMob.setCembioId(resultSet.getInt("cembio_id"));
                        ceEffMob.setEffMobility(resultSet.getDouble("eff_mobility"));
                        ceEffMob.setCreated(resultSet.getString("created"));
                        ceEffMob.setLastUpdated(resultSet.getString("last_updated"));
                        ceEffMobsInRange.add(ceEffMob);
                    }
                    return ceEffMobsInRange;
                }), dec);
    }
}
