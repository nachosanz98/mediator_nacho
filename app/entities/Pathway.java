package entities;

public class Pathway {
    private int pathwayId;
    private String pathwayMap;
    private String pathwayName;
    private String created;
    private String lastUpdated;

    public Pathway() {
        this.pathwayId = 0;
        this.pathwayMap = "";
        this.pathwayName = "";
        this.created = "";
        this.lastUpdated = "";
    }

    public Pathway(int pathwayId, String pathwayMap, String pathwayName, String created, String lastUpdated) {
        this.pathwayId = pathwayId;
        this.pathwayMap = pathwayMap;
        this.pathwayName = pathwayName;
        this.created = created;
        this.lastUpdated = lastUpdated;
    }

    public int getPathwayId() {
        return pathwayId;
    }

    public void setPathwayId(int pathwayId) {
        this.pathwayId = pathwayId;
    }

    public String getPathwayMap() {
        return pathwayMap;
    }

    public void setPathwayMap(String pathwayMap) {
        this.pathwayMap = pathwayMap;
    }

    public String getPathwayName() {
        return pathwayName;
    }

    public void setPathwayName(String pathwayName) {
        this.pathwayName = pathwayName;
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
        return "Pathway{" +
                "pathwayId=" + pathwayId +
                ", pathwayMap='" + pathwayMap + '\'' +
                ", pathwayName='" + pathwayName + '\'' +
                ", created='" + created + '\'' +
                ", lastUpdated='" + lastUpdated + '\'' +
                '}';
    }
}