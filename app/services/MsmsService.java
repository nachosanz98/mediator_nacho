package services;

import entities.Msms;
import play.db.Database;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
                            "SELECT m.*, " +
                                    "mp.peak_id, mp.intensity, mp.mz, mp.created as createdPeak, mp.last_updated as lastUpdatedPeak, " +
                                    "mr.reference_id, mr.pubmed_id, mr.ref_text, mr.created as createdRef, mr.last_updated as lastUpdatedRef " +
                                    "FROM msms m " +
                                    "LEFT JOIN msms_peaks mp ON m.msms_id = mp.msms_id " +
                                    "LEFT JOIN msms_reference mr ON m.msms_id = mr.msms_id " +
                                    "WHERE m.msms_id = ?");
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

                        /*msms_peaks*/
                        msms.setPeakId(resultSet.getInt("peak_id"));
                        msms.setIntensity(resultSet.getDouble("intensity"));
                        msms.setMz(resultSet.getDouble("mz"));
                        msms.setCreatedPeak(resultSet.getString("createdPeak"));
                        msms.setLastUpdatedPeak(resultSet.getString("lastUpdatedPeak"));

                        /*msms_reference*/
                        msms.setReferenceId(resultSet.getInt("reference_id"));
                        msms.setPubmedId(resultSet.getString("pubmed_id"));
                        msms.setRefText(resultSet.getString("ref_text"));
                        msms.setCreatedRef(resultSet.getString("createdRef"));
                        msms.setLastUpdatedRef(resultSet.getString("lastUpdatedRef"));

                        return msms;
                    }
                    return null;
                }), dec);
    }

    public CompletionStage<Boolean> addMsms(Msms msms) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "INSERT INTO msms (msms_id, hmdb_id, voltage, voltage_level, instrument_type, ionization_mode, " +
                                    "peak_count, compound_id, predicted, created, last_updated) " +
                                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

                    statement.setInt(1, msms.getMsmsId());
                    statement.setString(2, msms.getHmdbId());
                    statement.setInt(3, msms.getVoltage());
                    statement.setString(4, msms.getVoltageLevel());
                    statement.setString(5, msms.getInstrumentType());
                    statement.setInt(6, msms.getIonizationMode());
                    statement.setInt(7, msms.getPeakCount());
                    statement.setInt(8, msms.getCompoundId());
                    statement.setInt(9, msms.getPredicted());
                    statement.setString(10, msms.getCreated());
                    statement.setString(11, msms.getLastUpdated());
                    System.out.println("Valor de msms_id: " + msms.getMsmsId());

                    int rowsInserted = statement.executeUpdate();

                    /* msms_peaks*/
                    if (rowsInserted > 0 && !msms.getCreatedPeak().isEmpty()) {
                        PreparedStatement peakStatement = connection.prepareStatement(
                                "INSERT INTO msms_peaks (peak_id, intensity, mz, msms_id, created, last_updated) " +
                                        "VALUES (?, ?, ?, ?, ?, ?)");
                        peakStatement.setInt(1, msms.getPeakId());
                        peakStatement.setDouble(2, msms.getIntensity());
                        peakStatement.setDouble(3, msms.getMz());
                        peakStatement.setInt(4, msms.getMsmsId());
                        peakStatement.setString(5, msms.getCreatedPeak());
                        peakStatement.setString(6, msms.getLastUpdatedPeak());
                        int peakRowsInserted = peakStatement.executeUpdate();
                        if (peakRowsInserted == 0) {
                            return false;
                        }
                    }

                    /* msms_reference*/
                    if (rowsInserted > 0 && !msms.getCreatedRef().isEmpty()) {
                        PreparedStatement refStatement = connection.prepareStatement(
                                "INSERT INTO msms_reference (reference_id, pubmed_id, ref_text, msms_id, created, last_updated) " +
                                        "VALUES (?, ?, ?, ?, ?, ?)");
                        refStatement.setInt(1, msms.getReferenceId());
                        refStatement.setString(2, msms.getPubmedId());
                        refStatement.setString(3, msms.getRefText());
                        refStatement.setInt(4, msms.getMsmsId());
                        refStatement.setString(5, msms.getCreatedRef());
                        refStatement.setString(6, msms.getLastUpdatedRef());
                        int refRowsInserted = refStatement.executeUpdate();
                        if (refRowsInserted == 0) {
                            return false;
                        }
                    }

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

                    if (rowsDeleted > 0) {
                        PreparedStatement peakStatement = connection.prepareStatement(
                                "DELETE FROM msms_peaks WHERE msms_id = ?");
                        peakStatement.setInt(1, msmsId);
                        peakStatement.executeUpdate();

                        PreparedStatement refStatement = connection.prepareStatement(
                                "DELETE FROM msms_reference WHERE msms_id = ?");
                        refStatement.setInt(1, msmsId);
                        refStatement.executeUpdate();
                    }

                    return rowsDeleted > 0;
                }), dec);
    }

    public CompletionStage<List<Msms>> getAllMsms() {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT m.*, " +
                                    "mp.peak_id, mp.intensity, mp.mz, mp.created as createdPeak, mp.last_updated as lastUpdatedPeak, " +
                                    "mr.reference_id, mr.pubmed_id, mr.ref_text, mr.created as createdRef, mr.last_updated as lastUpdatedRef " +
                                    "FROM msms m " +
                                    "LEFT JOIN msms_peaks mp ON m.msms_id = mp.msms_id " +
                                    "LEFT JOIN msms_reference mr ON m.msms_id = mr.msms_id");

                    ResultSet resultSet = statement.executeQuery();
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

                        /*msms_peaks*/
                        msms.setPeakId(resultSet.getInt("peak_id"));
                        msms.setIntensity(resultSet.getDouble("intensity"));
                        msms.setMz(resultSet.getDouble("mz"));
                        msms.setCreatedPeak(resultSet.getString("createdPeak"));
                        msms.setLastUpdatedPeak(resultSet.getString("lastUpdatedPeak"));

                        /*msms_reference*/
                        msms.setReferenceId(resultSet.getInt("reference_id"));
                        msms.setPubmedId(resultSet.getString("pubmed_id"));
                        msms.setRefText(resultSet.getString("ref_text"));
                        msms.setCreatedRef(resultSet.getString("createdRef"));
                        msms.setLastUpdatedRef(resultSet.getString("lastUpdatedRef"));

                        msmsList.add(msms);
                    }
                    return msmsList;
                }), dec);
    }

    public CompletionStage<Boolean> updateMsms(Msms msms, int id) {
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
                    statement.setInt(11, id);

                    int rowsUpdated = statement.executeUpdate();

                    if (msms.getLastUpdatedRef() != null && !msms.getLastUpdatedRef().isEmpty()) {
                        PreparedStatement refStatement = connection.prepareStatement(
                                "UPDATE msms_reference SET reference_id = ?, pubmed_id = ?, ref_text = ?, created = ?," +
                                        " last_updated = ? WHERE msms_id = ?");
                        refStatement.setInt(1, msms.getReferenceId());
                        refStatement.setString(2, msms.getPubmedId());
                        refStatement.setString(3, msms.getRefText());
                        refStatement.setString(4, msms.getCreatedRef());
                        refStatement.setString(5, msms.getLastUpdatedRef());
                        refStatement.setInt(6, id);
                        int refRowsInserted = refStatement.executeUpdate();
                        if (refRowsInserted == 0) {
                            return false;
                        }
                    }

                    if (msms.getLastUpdatedPeak() != null && !msms.getLastUpdatedPeak().isEmpty()) {
                        PreparedStatement peakStatement = connection.prepareStatement(
                                "UPDATE msms_peaks SET peak_id= ?, intensity = ?, mz = ?, created = ?, last_updated = ? " +
                                        "WHERE msms_id = ?");
                        peakStatement.setInt(1, msms.getPeakId());
                        peakStatement.setDouble(2, msms.getIntensity());
                        peakStatement.setDouble(3, msms.getMz());
                        peakStatement.setString(4, msms.getCreatedPeak());
                        peakStatement.setString(5, msms.getLastUpdatedPeak());
                        peakStatement.setInt(6, id);
                        int peakRowsInserted = peakStatement.executeUpdate();
                        if (peakRowsInserted == 0) {
                            return false;
                        }
                    }
                    
                    
                    return rowsUpdated > 0;
                }), dec);
    }

    public CompletionStage<List<Msms>> getMsmsInRange(int startId, int endId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                        "SELECT m.*, " +
                                "mp.peak_id, mp.intensity, mp.mz, mp.created as createdPeak, mp.last_updated as lastUpdatedPeak, " +
                                "mr.reference_id, mr.pubmed_id, mr.ref_text, mr.created as createdRef, mr.last_updated as lastUpdatedRef " +
                                "FROM msms m " +
                                "LEFT JOIN msms_peaks mp ON m.msms_id = mp.msms_id " +
                                "LEFT JOIN msms_reference mr ON m.msms_id = mr.msms_id " +
                                "WHERE msms_id BETWEEN ? AND ?");
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

                        /*msms_peaks*/
                        msms.setPeakId(resultSet.getInt("peak_id"));
                        msms.setIntensity(resultSet.getDouble("intensity"));
                        msms.setMz(resultSet.getDouble("mz"));
                        msms.setCreatedPeak(resultSet.getString("createdPeak"));
                        msms.setLastUpdatedPeak(resultSet.getString("lastUpdatedPeak"));

                        /*msms_reference*/
                        msms.setReferenceId(resultSet.getInt("reference_id"));
                        msms.setPubmedId(resultSet.getString("pubmed_id"));
                        msms.setRefText(resultSet.getString("ref_text"));
                        msms.setCreatedRef(resultSet.getString("createdRef"));
                        msms.setLastUpdatedRef(resultSet.getString("lastUpdatedRef"));

                        msmsInRange.add(msms);
                    }
                    return msmsInRange;
                }), dec);
    }
}