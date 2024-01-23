package entities;

public class CompoundPathways {
    private int compoundId;
    private int pathwayId;
    private String created;
    private String lastUpdated;

    public CompoundPathways() {
        this.compoundId = 0;
        this.pathwayId = 0;
        this.created = "";
        this.lastUpdated = "";
    }

    public CompoundPathways(int compoundId, int pathwayId, String created, String lastUpdated) {
        this.compoundId = compoundId;
        this.pathwayId = pathwayId;
        this.created = created;
        this.lastUpdated = lastUpdated;
    }

    public int getCompoundId() {
        return compoundId;
    }
    public void setCompoundId(int compoundId) {
        this.compoundId = compoundId;
    }
    public int getPathwayId() {
        return pathwayId;
    }

    public void setPathwayId(int pathwayId) {
        this.pathwayId = pathwayId;
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
        return "CompoundsPathways{" +
                "compoundId=" + compoundId +
                ", pathwayId=" + pathwayId +
                ", created='" + created + '\'' +
                ", lastUpdated='" + lastUpdated + '\'' +
                '}';
    }
}
