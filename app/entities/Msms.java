package entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Msms {

    @JsonProperty("msms_id")
    private int msmsId;
    private String hmdbId;
    private int voltage;
    private String voltageLevel;
    private String instrumentType;
    private int ionizationMode;
    private int peakCount;
    private int compoundId;
    private int predicted;
    private String created;
    private String lastUpdated;

    /*msms_peaks*/
    private int peakId;
    private double intensity;
    private double mz;
    private String createdPeak;
    private String lastUpdatedPeak;

    /*msms_reference*/
    private int referenceId;
    private String pubmedId;
    private String refText;
    private String createdRef;
    private String lastUpdatedRef;


    public Msms() {
        this.msmsId = 0;
        this.hmdbId = "";
        this.voltage = 0;
        this.voltageLevel = "";
        this.instrumentType = "";
        this.ionizationMode = 0;
        this.peakCount = 0;
        this.compoundId = 0;
        this.predicted = 0;
        this.created = "";
        this.lastUpdated = "";
        this.peakId = 0;
        this.intensity = 0.0;
        this.mz = 0.0;
        this.createdPeak = "";
        this.lastUpdatedPeak = "";
        this.referenceId = 0;
        this.pubmedId = "";
        this.refText = "";
        this.createdRef = "";
        this.lastUpdatedRef = "";
    }

    public Msms(int msmsId, String hmdbId, int voltage, String voltageLevel, String instrumentType,
                int ionizationMode, int peakCount, int compoundId, int predicted, String created, String lastUpdated,
                int peakId, double intensity, double mz, String createdPeak, String lastUpdatedPeak, int referenceId,
                String pubmedId, String refText, String createdRef, String lastUpdatedRef) {
        this.msmsId = msmsId;
        this.hmdbId = hmdbId;
        this.voltage = voltage;
        this.voltageLevel = voltageLevel;
        this.instrumentType = instrumentType;
        this.ionizationMode = ionizationMode;
        this.peakCount = peakCount;
        this.compoundId = compoundId;
        this.predicted = predicted;
        this.created = created;
        this.lastUpdated = lastUpdated;
        this.peakId = peakId;
        this.intensity = intensity;
        this.mz = mz;
        this.createdPeak = createdPeak;
        this.lastUpdatedPeak = lastUpdatedPeak;
        this.referenceId = referenceId;
        this.pubmedId = pubmedId;
        this.refText = refText;
        this.createdRef = createdRef;
        this.lastUpdatedRef = lastUpdatedRef;
    }

    public int getMsmsId() {
        return msmsId;
    }

    public void setMsmsId(int msmsId) {
        this.msmsId = msmsId;
    }

    public String getHmdbId() {
        return hmdbId;
    }

    public void setHmdbId(String hmdbId) {
        this.hmdbId = hmdbId;
    }

    public int getVoltage() {
        return voltage;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }

    public String getVoltageLevel() {
        return voltageLevel;
    }

    public void setVoltageLevel(String voltageLevel) {
        this.voltageLevel = voltageLevel;
    }

    public String getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(String instrumentType) {
        this.instrumentType = instrumentType;
    }

    public int getIonizationMode() {
        return ionizationMode;
    }

    public void setIonizationMode(int ionizationMode) {
        this.ionizationMode = ionizationMode;
    }

    public int getPeakCount() {
        return peakCount;
    }

    public void setPeakCount(int peakCount) {
        this.peakCount = peakCount;
    }

    public int getCompoundId() {
        return compoundId;
    }

    public void setCompoundId(int compoundId) {
        this.compoundId = compoundId;
    }

    public int getPredicted() {
        return predicted;
    }

    public void setPredicted(int predicted) {
        this.predicted = predicted;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public int getPeakId() {
        return peakId;
    }

    public void setPeakId(int peakId) {
        this.peakId = peakId;
    }
    public double getIntensity(){return intensity;}
    public void setIntensity(double intensity){this.intensity = intensity;}
    public double getMz() {
        return mz;
    }

    public void setMz(double mz) {
        this.mz = mz;
    }

    public String getCreatedPeak() {
        return createdPeak;
    }

    public void setCreatedPeak(String createdPeak) {
        this.createdPeak = createdPeak;
    }

    public String getLastUpdatedPeak() {
        return lastUpdatedPeak;
    }

    public void setLastUpdatedPeak(String lastUpdatedPeak) {
        this.lastUpdatedPeak = lastUpdatedPeak;
    }

    public int getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(int referenceId) {
        this.referenceId = referenceId;
    }

    public String getPubmedId() {
        return pubmedId;
    }

    public void setPubmedId(String pubmedId) {
        this.pubmedId = pubmedId;
    }

    public String getRefText() {
        return refText;
    }

    public void setRefText(String refText) {
        this.refText = refText;
    }

    public String getCreatedRef() {
        return createdRef;
    }

    public void setCreatedRef(String createdRef) {
        this.createdRef = createdRef;
    }

    public String getLastUpdatedRef() {
        return lastUpdatedRef;
    }

    public void setLastUpdatedRef(String lastUpdatedRef) {
        this.lastUpdatedRef = lastUpdatedRef;
    }

    @Override
    public String toString() {
        return "Msms{" +
                "msmsId=" + msmsId + '\'' +
                ", hmdbId='" + hmdbId + '\'' +
                ", voltage=" + voltage + '\'' +
                ", voltageLevel='" + voltageLevel + '\'' +
                ", instrumentType='" + instrumentType + '\'' +
                ", ionizationMode=" + ionizationMode +
                ", peakCount=" + peakCount + '\'' +
                ", compoundId=" + compoundId + '\'' +
                ", predicted=" + predicted + '\'' +
                ", created='" + created + '\'' +
                ", lastUpdated='" + lastUpdated + '\'' +
                ", peakId=" + peakId + '\'' +
                ", intensity=" + intensity + '\'' +
                ", mz=" + mz + '\'' +
                ", createdPeak='" + createdPeak + '\'' +
                ", lastUpdatedPeak='" + lastUpdatedPeak + '\'' +
                ", referenceId=" + referenceId + '\'' +
                ", pubmedId='" + pubmedId + '\'' +
                ", refText='" + refText + '\'' +
                ", createdRef='" + createdRef + '\'' +
                ", lastUpdatedRef='" + lastUpdatedRef +
                '}';
    }

}
