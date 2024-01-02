package services;

import entities.Msms;
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
public class MsmsService {
    private final Database db;
    private final DatabaseExecutionContext dec;

    @Inject
    public MsmsService(Database db, DatabaseExecutionContext dec) {
        this.db = db;
        this.dec = dec;
    }

    public CompletionStage<Msms> getMsms(int msmsId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT * FROM msms WHERE msms_id = ?");
                    statement.setInt(1, msmsId);
                    ResultSet resultSet = statement.executeQuery();

                    if (resultSet.next()) {
                        Msms msms = new Msms();
                        msms.setMsmsId(resultSet.getInt("msms_id"));
                        msms.setHmdbId(resultSet.getString("hmdb_id"));
                        msms.setVoltage(resultSet.getInt("voltage"));
                        msms.setVoltageLevel(resultSet.getString("voltage_level"));
                        msms.setInstrumentType(resultSet.getString("instrument_type"));
                        msms.setIonizationMode(resultSet.getInt("ionization_mode"));
                        msms.setPeakCount(resultSet.getInt("peak_count"));
                        msms.setCompoundId(resultSet.getInt("compound_id"));
                        msms.setPredicted(resultSet.getInt("predicted"));
                        msms.setCreated(resultSet.getString("created"));
                        msms.setLastUpdated(resultSet.getString("last_updated"));
                        return msms;
                    }
                    return null;
                }), dec);
    }

    public CompletionStage<Boolean> addMsms(Msms msms) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "INSERT INTO msms (hmdb_id, voltage, voltage_level, instrument_type, ionization_mode, " +
                                    "peak_count, compound_id, predicted, created, last_updated) " +
                                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

                    statement.setString(1, msms.getHmdbId());
                    statement.setInt(2, msms.getVoltage());
                    statement.setString(3, msms.getVoltageLevel());
                    statement.setString(4, msms.getInstrumentType());
                    statement.setInt(5, msms.getIonizationMode());
                    statement.setInt(6, msms.getPeakCount());
                    statement.setInt(7, msms.getCompoundId());
                    statement.setInt(8, msms.getPredicted());
                    statement.setString(9, msms.getCreated());
                    statement.setString(10, msms.getLastUpdated());

                    int rowsInserted = statement.executeUpdate();
                    return rowsInserted > 0;
                }), dec);
    }

    public CompletionStage<Boolean> deleteMsms(int msmsId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "DELETE FROM msms WHERE msms_id = ?");
                    statement.setInt(1, msmsId);
                    int rowsDeleted = statement.executeUpdate();
                    return rowsDeleted > 0;
                }), dec);
    }

    public CompletionStage<List<Msms>> getAllMsms() {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM msms");
                    List<Msms> msmsList = new ArrayList<>();
                    while (resultSet.next()) {
                        Msms msms = new Msms();
                        msms.setMsmsId(resultSet.getInt("msms_id"));
                        msms.setHmdbId(resultSet.getString("hmdb_id"));
                        msms.setVoltage(resultSet.getInt("voltage"));
                        msms.setVoltageLevel(resultSet.getString("voltage_level"));
                        msms.setInstrumentType(resultSet.getString("instrument_type"));
                        msms.setIonizationMode(resultSet.getInt("ionization_mode"));
                        msms.setPeakCount(resultSet.getInt("peak_count"));
                        msms.setCompoundId(resultSet.getInt("compound_id"));
                        msms.setPredicted(resultSet.getInt("predicted"));
                        msms.setCreated(resultSet.getString("created"));
                        msms.setLastUpdated(resultSet.getString("last_updated"));
                        msmsList.add(msms);
                    }
                    return msmsList;
                }), dec);
    }

    public CompletionStage<Boolean> updateMsms(Msms msms) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "UPDATE msms SET hmdb_id = ?, voltage = ?, voltage_level = ?, instrument_type = ?, " +
                                    "ionization_mode = ?, peak_count = ?, compound_id = ?, predicted = ?, " +
                                    "created = ?, last_updated = ? WHERE msms_id = ?");

                    statement.setString(1, msms.getHmdbId());
                    statement.setInt(2, msms.getVoltage());
                    statement.setString(3, msms.getVoltageLevel());
                    statement.setString(4, msms.getInstrumentType());
                    statement.setInt(5, msms.getIonizationMode());
                    statement.setInt(6, msms.getPeakCount());
                    statement.setInt(7, msms.getCompoundId());
                    statement.setInt(8, msms.getPredicted());
                    statement.setString(9, msms.getCreated());
                    statement.setString(10, msms.getLastUpdated());
                    statement.setInt(11, msms.getMsmsId());

                    int rowsUpdated = statement.executeUpdate();
                    return rowsUpdated > 0;
                }), dec);
    }

    public CompletionStage<List<Msms>> getMsmsInRange(int startId, int endId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT * FROM msms WHERE msms_id BETWEEN ? AND ?");
                    statement.setInt(1, startId);
                    statement.setInt(2, endId);
                    ResultSet resultSet = statement.executeQuery();

                    List<Msms> msmsInRange = new ArrayList<>();
                    while (resultSet.next()) {
                        Msms msms = new Msms();
                        msms.setMsmsId(resultSet.getInt("msms_id"));
                        msms.setHmdbId(resultSet.getString("hmdb_id"));
                        msms.setVoltage(resultSet.getInt("voltage"));
                        msms.setVoltageLevel(resultSet.getString("voltage_level"));
                        msms.setInstrumentType(resultSet.getString("instrument_type"));
                        msms.setIonizationMode(resultSet.getInt("ionization_mode"));
                        msms.setPeakCount(resultSet.getInt("peak_count"));
                        msms.setCompoundId(resultSet.getInt("compound_id"));
                        msms.setPredicted(resultSet.getInt("predicted"));
                        msms.setCreated(resultSet.getString("created"));
                        msms.setLastUpdated(resultSet.getString("last_updated"));
                        msmsInRange.add(msms);
                    }
                    return msmsInRange;
                }), dec);
    }
}