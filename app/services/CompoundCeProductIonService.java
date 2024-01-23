package services;

import entities.CompoundCeProductIon;
import play.db.Database;

import javax.inject.Inject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class CompoundCeProductIonService {
    private final Database db;
    private final DatabaseExecutionContext dec;

    @Inject
    public CompoundCeProductIonService(Database db, DatabaseExecutionContext dec) {
        this.db = db;
        this.dec = dec;
    }

    public CompletionStage<CompoundCeProductIon> getCompoundCeProductIon(int id) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT * FROM compound_ce_product_ion WHERE ce_product_ion_id = ?");
                    statement.setInt(1, id);
                    ResultSet resultSet = statement.executeQuery();

                    if (resultSet.next()) {
                        return new CompoundCeProductIon(
                                resultSet.getInt("ce_product_ion_id"),
                                resultSet.getInt("ion_source_voltage"),
                                resultSet.getDouble("ce_product_ion_mz"),
                                resultSet.getDouble("ce_product_ion_intensity"),
                                resultSet.getString("ce_transformation_type"),
                                resultSet.getString("ce_product_ion_name"),
                                resultSet.getInt("ce_eff_mob_id"),
                                resultSet.getInt("compound_id_own"),
                                resultSet.getString("created"),
                                resultSet.getString("last_updated"));
                    }
                    return null;
                }), dec);
    }

    public CompletionStage<Boolean> addCompoundCeProductIon(CompoundCeProductIon compoundCeProductIon) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "INSERT INTO compound_ce_product_ion (ion_source_voltage, ce_product_ion_mz, ce_product_ion_intensity, " +
                                    "ce_transformation_type, ce_product_ion_name, ce_eff_mob_id, compound_id_own, created, last_updated) " +
                                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

                    statement.setInt(1, compoundCeProductIon.getIonSourceVoltage());
                    statement.setDouble(2, compoundCeProductIon.getCeProductIonMz());
                    statement.setDouble(3, compoundCeProductIon.getCeProductIonIntensity());
                    statement.setString(4, compoundCeProductIon.getCeTransformationType());
                    statement.setString(5, compoundCeProductIon.getCeProductIonName());
                    statement.setInt(6, compoundCeProductIon.getCeEffMobId());
                    statement.setInt(7, compoundCeProductIon.getCompoundIdOwn());
                    statement.setString(8, compoundCeProductIon.getCreated());
                    statement.setString(9, compoundCeProductIon.getLastUpdated());

                    int rowsInserted = statement.executeUpdate();
                    return rowsInserted > 0;
                }), dec);
    }

    public CompletionStage<Boolean> deleteCompoundCeProductIon(int id) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "DELETE FROM compound_ce_product_ion WHERE ce_product_ion_id = ?");
                    statement.setInt(1, id);
                    int rowsDeleted = statement.executeUpdate();
                    return rowsDeleted > 0;
                }), dec);
    }

    public CompletionStage<List<CompoundCeProductIon>> getAllCompoundCeProductIon() {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    List<CompoundCeProductIon> compoundCeProductIonList = new ArrayList<>();
                    ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM compound_ce_product_ion");
                    while (resultSet.next()) {
                        CompoundCeProductIon compoundCeProductIon = new CompoundCeProductIon(
                                resultSet.getInt("ce_product_ion_id"),
                                resultSet.getInt("ion_source_voltage"),
                                resultSet.getDouble("ce_product_ion_mz"),
                                resultSet.getDouble("ce_product_ion_intensity"),
                                resultSet.getString("ce_transformation_type"),
                                resultSet.getString("ce_product_ion_name"),
                                resultSet.getInt("ce_eff_mob_id"),
                                resultSet.getInt("compound_id_own"),
                                resultSet.getString("created"),
                                resultSet.getString("last_updated"));
                        compoundCeProductIonList.add(compoundCeProductIon);
                    }
                    return compoundCeProductIonList;
                }), dec);
    }

    public CompletionStage<Boolean> updateCompoundCeProductIon(CompoundCeProductIon compoundCeProductIon, int id) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "UPDATE compound_ce_product_ion SET ion_source_voltage = ?, ce_product_ion_mz = ?, " +
                                    "ce_product_ion_intensity = ?, ce_transformation_type = ?, ce_product_ion_name = ?, " +
                                    "ce_eff_mob_id = ?, compound_id_own = ?, created = ?, last_updated = ? " +
                                    "WHERE ce_product_ion_id = ?");

                    statement.setInt(1, compoundCeProductIon.getIonSourceVoltage());
                    statement.setDouble(2, compoundCeProductIon.getCeProductIonMz());
                    statement.setDouble(3, compoundCeProductIon.getCeProductIonIntensity());
                    statement.setString(4, compoundCeProductIon.getCeTransformationType());
                    statement.setString(5, compoundCeProductIon.getCeProductIonName());
                    statement.setInt(6, compoundCeProductIon.getCeEffMobId());
                    statement.setInt(7, compoundCeProductIon.getCompoundIdOwn());
                    statement.setString(8, compoundCeProductIon.getCreated());
                    statement.setString(9, compoundCeProductIon.getLastUpdated());
                    statement.setInt(10, id);

                    int rowsUpdated = statement.executeUpdate();
                    return rowsUpdated > 0;
                }), dec);
    }

    public CompletionStage<List<CompoundCeProductIon>> getCompoundCeProductIonInRange(int startId, int endId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    List<CompoundCeProductIon> compoundCeProductIonList = new ArrayList<>();
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT * FROM compound_ce_product_ion WHERE ce_product_ion_id BETWEEN ? AND ?");
                    statement.setInt(1, startId);
                    statement.setInt(2, endId);
                    ResultSet resultSet = statement.executeQuery();

                    while (resultSet.next()) {
                        CompoundCeProductIon compoundCeProductIon = new CompoundCeProductIon(
                                resultSet.getInt("ce_product_ion_id"),
                                resultSet.getInt("ion_source_voltage"),
                                resultSet.getDouble("ce_product_ion_mz"),
                                resultSet.getDouble("ce_product_ion_intensity"),
                                resultSet.getString("ce_transformation_type"),
                                resultSet.getString("ce_product_ion_name"),
                                resultSet.getInt("ce_eff_mob_id"),
                                resultSet.getInt("compound_id_own"),
                                resultSet.getString("created"),
                                resultSet.getString("last_updated"));
                        compoundCeProductIonList.add(compoundCeProductIon);
                    }
                    return compoundCeProductIonList;
                }), dec);
    }
}
