package entities;

public class CompoundClassyfireClassification {
    private int compoundId;
    private String nodeId;
    private String created;
    private String lastUpdated;

    public CompoundClassyfireClassification() {
        this.compoundId = 0;
        this.nodeId = "";
        this.created = "";
        this.lastUpdated = "";
    }

    public CompoundClassyfireClassification(int compoundId, String nodeId, String created, String lastUpdated) {
        this.compoundId = compoundId;
        this.nodeId = nodeId;
        this.created = created;
        this.lastUpdated = lastUpdated;
    }

    public int getCompoundId() {
        return compoundId;
    }

    public void setCompoundId(int compoundId) {
        this.compoundId = compoundId;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
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
        return "CompoundClassyfireClassification{" +
                "compoundId=" + compoundId +
                ", nodeId='" + nodeId + '\'' +
                ", created='" + created + '\'' +
                ", lastUpdated='" + lastUpdated + '\'' +
                '}';
    }
}
