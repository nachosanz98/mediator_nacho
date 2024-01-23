package services;

import entities.CeExpPropMetadata;
import play.db.Database;

import javax.inject.Inject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class CeExpPropMetadataService {
    private final Database db;
    private final DatabaseExecutionContext dec;

    @Inject
    public CeExpPropMetadataService(Database db, DatabaseExecutionContext dec) {
        this.db = db;
        this.dec = dec;
    }

    public CompletionStage<CeExpPropMetadata> getCeExpPropMetadata(int id) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT * FROM ce_experimental_properties_metadata WHERE ce_ms_exp_prop_metadata_id = ?");
                    statement.setInt(1, id);
                    ResultSet resultSet = statement.executeQuery();

                    if (resultSet.next()) {
                        return new CeExpPropMetadata(
                                resultSet.getInt("ce_ms_exp_prop_metadata_id"),
                                resultSet.getInt("ce_eff_mob_id"),
                                resultSet.getDouble("experimental_mz"),
                                resultSet.getInt("ce_identification_level"),
                                resultSet.getInt("ce_sample_type"),
                                resultSet.getInt("capillary_length"),
                                resultSet.getInt("capillary_voltage"),
                                resultSet.getInt("bge_compound_id"),
                                resultSet.getDouble("absolute_MT"),
                                resultSet.getDouble("relative_MT"),
                                resultSet.getString("commercial"),
                                resultSet.getString("created"),
                                resultSet.getString("last_updated"));
                    }
                    return null;
                }), dec);
    }

    public CompletionStage<Boolean> addCeExpPropMetadata(CeExpPropMetadata ceExpPropMetadata) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "INSERT INTO ce_experimental_properties_metadata (ce_eff_mob_id, experimental_mz, " +
                                    "ce_identification_level, ce_sample_type, capillary_length, capillary_voltage, " +
                                    "bge_compound_id, absolute_MT, relative_MT, commercial, created, last_updated) " +
                                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

                    statement.setInt(1, ceExpPropMetadata.getCeEffMobId());
                    statement.setDouble(2, ceExpPropMetadata.getExperimentalMz());
                    statement.setInt(3, ceExpPropMetadata.getCeIdentificationLevel());
                    statement.setInt(4, ceExpPropMetadata.getCeSampleType());
                    statement.setInt(5, ceExpPropMetadata.getCapillaryLength());
                    statement.setInt(6, ceExpPropMetadata.getCapillaryVoltage());
                    statement.setInt(7, ceExpPropMetadata.getBgeCompoundId());
                    statement.setDouble(8, ceExpPropMetadata.getAbsoluteMT());
                    statement.setDouble(9, ceExpPropMetadata.getRelativeMT());
                    statement.setString(10, ceExpPropMetadata.getCommercial());
                    statement.setString(11, ceExpPropMetadata.getCreated());
                    statement.setString(12, ceExpPropMetadata.getLastUpdated());

                    int rowsInserted = statement.executeUpdate();
                    return rowsInserted > 0;
                }), dec);
    }

    public CompletionStage<Boolean> deleteCeExpPropMetadata(int id) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "DELETE FROM ce_experimental_properties_metadata WHERE ce_ms_exp_prop_metadata_id = ?");
                    statement.setInt(1, id);
                    int rowsDeleted = statement.executeUpdate();
                    return rowsDeleted > 0;
                }), dec);
    }

    public CompletionStage<List<CeExpPropMetadata>> getAllCeExpPropMetadata() {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    List<CeExpPropMetadata> ceExpPropMetadataList = new ArrayList<>();
                    ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM ce_experimental_properties_metadata");
                    while (resultSet.next()) {
                        CeExpPropMetadata ceExpPropMetadata = new CeExpPropMetadata(
                                resultSet.getInt("ce_ms_exp_prop_metadata_id"),
                                resultSet.getInt("ce_eff_mob_id"),
                                resultSet.getDouble("experimental_mz"),
                                resultSet.getInt("ce_identification_level"),
                                resultSet.getInt("ce_sample_type"),
                                resultSet.getInt("capillary_length"),
                                resultSet.getInt("capillary_voltage"),
                                resultSet.getInt("bge_compound_id"),
                                resultSet.getDouble("absolute_MT"),
                                resultSet.getDouble("relative_MT"),
                                resultSet.getString("commercial"),
                                resultSet.getString("created"),
                                resultSet.getString("last_updated"));
                        ceExpPropMetadataList.add(ceExpPropMetadata);
                    }
                    return ceExpPropMetadataList;
                }), dec);
    }

    public CompletionStage<Boolean> updateCeExpPropMetadata(CeExpPropMetadata ceExpPropMetadata, int id) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "UPDATE ce_experimental_properties_metadata SET ce_eff_mob_id = ?, experimental_mz = ?, " +
                                    "ce_identification_level = ?, ce_sample_type = ?, capillary_length = ?, capillary_voltage = ?, " +
                                    "bge_compound_id = ?, absolute_MT = ?, relative_MT = ?, commercial = ?, created = ?, last_updated = ? " +
                                    "WHERE ce_ms_exp_prop_metadata_id = ?");

                    statement.setInt(1, ceExpPropMetadata.getCeEffMobId());
                    statement.setDouble(2, ceExpPropMetadata.getExperimentalMz());
                    statement.setInt(3, ceExpPropMetadata.getCeIdentificationLevel());
                    statement.setInt(4, ceExpPropMetadata.getCeSampleType());
                    statement.setInt(5, ceExpPropMetadata.getCapillaryLength());
                    statement.setInt(6, ceExpPropMetadata.getCapillaryVoltage());
                    statement.setInt(7, ceExpPropMetadata.getBgeCompoundId());
                    statement.setDouble(8, ceExpPropMetadata.getAbsoluteMT());
                    statement.setDouble(9, ceExpPropMetadata.getRelativeMT());
                    statement.setString(10, ceExpPropMetadata.getCommercial());
                    statement.setString(11, ceExpPropMetadata.getCreated());
                    statement.setString(12, ceExpPropMetadata.getLastUpdated());
                    statement.setInt(13, id);

                    int rowsUpdated = statement.executeUpdate();
                    return rowsUpdated > 0;
                }), dec);
    }

    public CompletionStage<List<CeExpPropMetadata>> getCeExpPropMetadataInRange(int startId, int endId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    List<CeExpPropMetadata> ceExpPropMetadataList = new ArrayList<>();
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT * FROM ce_experimental_properties_metadata WHERE ce_ms_exp_prop_metadata_id BETWEEN ? AND ?");
                    statement.setInt(1, startId);
                    statement.setInt(2, endId);
                    ResultSet resultSet = statement.executeQuery();

                    while (resultSet.next()) {
                        CeExpPropMetadata ceExpPropMetadata = new CeExpPropMetadata(
                                resultSet.getInt("ce_ms_exp_prop_metadata_id"),
                                resultSet.getInt("ce_eff_mob_id"),
                                resultSet.getDouble("experimental_mz"),
                                resultSet.getInt("ce_identification_level"),
                                resultSet.getInt("ce_sample_type"),
                                resultSet.getInt("capillary_length"),
                                resultSet.getInt("capillary_voltage"),
                                resultSet.getInt("bge_compound_id"),
                                resultSet.getDouble("absolute_MT"),
                                resultSet.getDouble("relative_MT"),
                                resultSet.getString("commercial"),
                                resultSet.getString("created"),
                                resultSet.getString("last_updated"));
                        ceExpPropMetadataList.add(ceExpPropMetadata);
                    }
                    return ceExpPropMetadataList;
                }), dec);
    }
}
