package entities;

public class Msms {

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
    }

    public Msms(int msmsId, String hmdbId, int voltage, String voltageLevel, String instrumentType,
                int ionizationMode, int peakCount, int compoundId, int predicted, String created, String lastUpdated) {
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

    @Override
    public String toString() {
        return "Msms{" +
                "msmsId=" + msmsId +
                ", hmdbId='" + hmdbId + '\'' +
                ", voltage=" + voltage +
                ", voltageLevel='" + voltageLevel + '\'' +
                ", instrumentType='" + instrumentType + '\'' +
                ", ionizationMode=" + ionizationMode +
                ", peakCount=" + peakCount +
                ", compoundId=" + compoundId +
                ", predicted=" + predicted +
                ", created='" + created + '\'' +
                ", lastUpdated='" + lastUpdated + '\'' +
                '}';
    }
}
