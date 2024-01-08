package entities;

public class CeEffMob {

    private int ceEffMobId;
    private int ceCompoundId;
    private int ceExpPropId;
    private int cembioId;
    private double effMobility;
    private String created;
    private String lastUpdated;

    public CeEffMob() {
        this.ceEffMobId = 0;
        this.ceCompoundId = 0;
        this.ceExpPropId = 0;
        this.cembioId = 0;
        this.effMobility = 0.0;
        this.created = "";
        this.lastUpdated = "";
    }

    public CeEffMob(int ceEffMobId, int ceCompoundId, int ceExpPropId, int cembioId, double effMobility, String created, String lastUpdated) {
        this.ceEffMobId = ceEffMobId;
        this.ceCompoundId = ceCompoundId;
        this.ceExpPropId = ceExpPropId;
        this.cembioId = cembioId;
        this.effMobility = effMobility;
        this.created = created;
        this.lastUpdated = lastUpdated;
    }

    public int getCeEffMobId() {
        return ceEffMobId;
    }

    public void setCeEffMobId(int ceEffMobId) {
        this.ceEffMobId = ceEffMobId;
    }

    public int getCeCompoundId() {
        return ceCompoundId;
    }

    public void setCeCompoundId(int ceCompoundId) {
        this.ceCompoundId = ceCompoundId;
    }

    public int getCeExpPropId() {
        return ceExpPropId;
    }

    public void setCeExpPropId(int ceExpPropId) {
        this.ceExpPropId = ceExpPropId;
    }

    public int getCembioId() {
        return cembioId;
    }

    public void setCembioId(int cembioId) {
        this.cembioId = cembioId;
    }

    public double getEffMobility() {
        return effMobility;
    }

    public void setEffMobility(double effMobility) {
        this.effMobility = effMobility;
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
        return "CeEffMob{" +
                "ceEffMobId=" + ceEffMobId +
                ", ceCompoundId=" + ceCompoundId +
                ", ceExpPropId=" + ceExpPropId +
                ", cembioId=" + cembioId +
                ", effMobility=" + effMobility +
                ", created='" + created + '\'' +
                ", lastUpdated='" + lastUpdated + '\'' +
                '}';
    }
}