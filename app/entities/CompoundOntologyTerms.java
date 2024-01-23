package entities;

public class CompoundOntologyTerms {
    private int compoundId;
    private int ontologyTermId;
    private String created;
    private String lastUpdated;

    // Default constructor
    public CompoundOntologyTerms() {
    }

    // Constructor with parameters
    public CompoundOntologyTerms(int compoundId, int ontologyTermId, String created, String lastUpdated) {
        this.compoundId = compoundId;
        this.ontologyTermId = ontologyTermId;
        this.created = created;
        this.lastUpdated = lastUpdated;
    }

    // Getter and Setter methods
    public int getCompoundId() {
        return compoundId;
    }

    public void setCompoundId(int compoundId) {
        this.compoundId = compoundId;
    }

    public int getOntologyTermId() {
        return ontologyTermId;
    }

    public void setOntologyTermId(int ontologyTermId) {
        this.ontologyTermId = ontologyTermId;
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

    // toString method
    @Override
    public String toString() {
        return "CompoundOntologyTerm{" +
                "compoundId=" + compoundId +
                ", ontologyTermId=" + ontologyTermId +
                ", created='" + created + '\'' +
                ", lastUpdated='" + lastUpdated + '\'' +
                '}';
    }
}
