package entities;

public class CeExpPropMetadata {
    private int ceMsExpPropMetadataId;
    private int ceEffMobId;
    private double experimentalMz;
    private int ceIdentificationLevel;
    private int ceSampleType;
    private int capillaryLength;
    private int capillaryVoltage;
    private int bgeCompoundId;
    private double absoluteMT;
    private double relativeMT;
    private String commercial;
    private String  created;
    private String lastUpdated;

    // Default constructor
    public CeExpPropMetadata() {
        this.ceMsExpPropMetadataId = 0;
        this.ceEffMobId = 0;
        this.experimentalMz = 0.0;
        this.ceIdentificationLevel = 0;
        this.ceSampleType = 0;
        this.capillaryLength = 0;
        this.capillaryVoltage = 0;
        this.bgeCompoundId = 0;
        this.absoluteMT = 0.0;
        this.relativeMT = 0;
        this.commercial = "";
        this.created = "";
        this.lastUpdated = "";
    }

    // Constructor with all fields
    public CeExpPropMetadata(int ceMsExpPropMetadataId, int ceEffMobId, double experimentalMz,
                            int ceIdentificationLevel, int ceSampleType, int capillaryLength,
                            int capillaryVoltage, int bgeCompoundId, double absoluteMT,
                            double relativeMT, String commercial, String created,
                            String lastUpdated) {
        this.ceMsExpPropMetadataId = ceMsExpPropMetadataId;
        this.ceEffMobId = ceEffMobId;
        this.experimentalMz = experimentalMz;
        this.ceIdentificationLevel = ceIdentificationLevel;
        this.ceSampleType = ceSampleType;
        this.capillaryLength = capillaryLength;
        this.capillaryVoltage = capillaryVoltage;
        this.bgeCompoundId = bgeCompoundId;
        this.absoluteMT = absoluteMT;
        this.relativeMT = relativeMT;
        this.commercial = commercial;
        this.created = created;
        this.lastUpdated = lastUpdated;
    }

    public int getCeMsExpPropMetadataId() { return ceMsExpPropMetadataId; }
    public void setCeMsExpPropMetadataId(int ceMsExpPropMetadataId) { this.ceMsExpPropMetadataId = ceMsExpPropMetadataId; }
    public int getCeEffMobId() { return ceEffMobId; }
    public void setCeEffMobId(int ceEffMobId) { this.ceEffMobId = ceEffMobId; }
    public double getExperimentalMz() { return experimentalMz; }
    public void setExperimentalMz(double experimentalMz) { this.experimentalMz = experimentalMz; }
    public int getCeIdentificationLevel() { return ceIdentificationLevel; }
    public void setCeIdentificationLevel(int ceIdentificationLevel) { this.ceIdentificationLevel = ceIdentificationLevel; }
    public int getCeSampleType() { return ceSampleType; }
    public void setCeSampleType(int ceSampleType) { this.ceSampleType = ceSampleType; }
    public int getCapillaryLength() { return capillaryLength; }
    public void setCapillaryLength(int capillaryLength) { this.capillaryLength = capillaryLength; }
    public int getCapillaryVoltage() { return capillaryVoltage; }
    public void setCapillaryVoltage(int capillaryVoltage) { this.capillaryVoltage = capillaryVoltage; }
    public int getBgeCompoundId() { return bgeCompoundId; }
    public void setBgeCompoundId(int bgeCompoundId) { this.bgeCompoundId = bgeCompoundId; }
    public double getAbsoluteMT() { return absoluteMT; }
    public void setAbsoluteMT(double absoluteMT) { this.absoluteMT = absoluteMT; }
    public double getRelativeMT() { return relativeMT; }
    public void setRelativeMT(double relativeMT) { this.relativeMT = relativeMT; }
    public String getCommercial() { return commercial; }
    public void setCommercial(String commercial) { this.commercial = commercial; }
    public String getCreated() { return created; }
    public void setCreated(String created) { this.created = created; }
    public String getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(String lastUpdated) { this.lastUpdated = lastUpdated; }

    @Override
    public String toString() {
        return "CeExperimentalPropertiesMetadata{" +
                "ceMsExpPropMetadataId=" + ceMsExpPropMetadataId +
                ", ceEffMobId=" + ceEffMobId +
                ", experimentalMz=" + experimentalMz +
                ", ceIdentificationLevel=" + ceIdentificationLevel +
                ", ceSampleType=" + ceSampleType +
                ", capillaryLength=" + capillaryLength +
                ", capillaryVoltage=" + capillaryVoltage +
                ", bgeCompoundId=" + bgeCompoundId +
                ", absoluteMT=" + absoluteMT +
                ", relativeMT=" + relativeMT +
                ", commercial='" + commercial + '\'' +
                ", created=" + created +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
