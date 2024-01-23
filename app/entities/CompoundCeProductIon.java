package entities;

public class CompoundCeProductIon {
    private int ceProductIonId;
    private int ionSourceVoltage;
    private double ceProductIonMz;
    private double ceProductIonIntensity;
    private String ceTransformationType;
    private String ceProductIonName;
    private int ceEffMobId;
    private int compoundIdOwn;
    private String created;
    private String lastUpdated;

    public CompoundCeProductIon() {
        this.ceProductIonId = 0;
        this.ionSourceVoltage = 0;
        this.ceProductIonMz = 0.0;
        this.ceProductIonIntensity = 0.0;
        this.ceTransformationType = "";
        this.ceProductIonName = "";
        this.ceEffMobId = 0;
        this.compoundIdOwn = 0;
        this.created = "";
        this.lastUpdated = "";
    }

    public CompoundCeProductIon(int ceProductIonId, int ionSourceVoltage, double ceProductIonMz,
                                double ceProductIonIntensity, String ceTransformationType,
                                String ceProductIonName, int ceEffMobId, int compoundIdOwn,
                                String created, String lastUpdated) {
        this.ceProductIonId = ceProductIonId;
        this.ionSourceVoltage = ionSourceVoltage;
        this.ceProductIonMz = ceProductIonMz;
        this.ceProductIonIntensity = ceProductIonIntensity;
        this.ceTransformationType = ceTransformationType;
        this.ceProductIonName = ceProductIonName;
        this.ceEffMobId = ceEffMobId;
        this.compoundIdOwn = compoundIdOwn;
        this.created = created;
        this.lastUpdated = lastUpdated;
    }

    public int getCeProductIonId() { return ceProductIonId; }
    public void setCeProductIonId(int ceProductIonId) { this.ceProductIonId = ceProductIonId; }
    public int getIonSourceVoltage() { return ionSourceVoltage; }
    public void setIonSourceVoltage(int ionSourceVoltage) { this.ionSourceVoltage = ionSourceVoltage; }
    public double getCeProductIonMz() { return ceProductIonMz; }
    public void setCeProductIonMz(double ceProductIonMz) { this.ceProductIonMz = ceProductIonMz; }
    public double getCeProductIonIntensity() { return ceProductIonIntensity; }
    public void setCeProductIonIntensity(double ceProductIonIntensity) { this.ceProductIonIntensity = ceProductIonIntensity; }
    public String getCeTransformationType() { return ceTransformationType; }

    public void setCeTransformationType(String ceTransformationType) { this.ceTransformationType = ceTransformationType; }
    public String getCeProductIonName() { return ceProductIonName; }
    public void setCeProductIonName(String ceProductIonName) { this.ceProductIonName = ceProductIonName; }
    public int getCeEffMobId() { return ceEffMobId; }
    public void setCeEffMobId(int ceEffMobId) { this.ceEffMobId = ceEffMobId; }
    public int getCompoundIdOwn() { return compoundIdOwn; }
    public void setCompoundIdOwn(int compoundIdOwn) { this.compoundIdOwn = compoundIdOwn; }
    public String getCreated() { return created; }
    public void setCreated(String created) { this.created = created; }
    public String getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(String lastUpdated) { this.lastUpdated = lastUpdated; }

    @Override
    public String toString() {
        return "CompoundCeProductIon{" +
                "ceProductIonId=" + ceProductIonId +
                ", ionSourceVoltage=" + ionSourceVoltage +
                ", ceProductIonMz=" + ceProductIonMz +
                ", ceProductIonIntensity=" + ceProductIonIntensity +
                ", ceTransformationType='" + ceTransformationType + '\'' +
                ", ceProductIonName='" + ceProductIonName + '\'' +
                ", ceEffMobId=" + ceEffMobId +
                ", compoundIdOwn=" + compoundIdOwn +
                ", created='" + created + '\'' +
                ", lastUpdated='" + lastUpdated + '\'' +
                '}';
    }
}
