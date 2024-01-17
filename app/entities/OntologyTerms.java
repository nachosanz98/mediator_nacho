package entities;

public class OntologyTerms {

    private int ontologyTermId;
    private String term;
    private String definition;
    private String externalId;
    private String externalSource;
    private String ontologyComment;
    private String curator;
    private int parentId;
    private int ontologyLevel;
    private String created;
    private String lastUpdated;

    /* ontology_synonyms */
    private String OntologySynonym;
    private String createdSynonym;
    private String lastUpdatedSynonym;


    public OntologyTerms() {
        this.ontologyTermId = 0;
        this.term = "";
        this.definition = "";
        this.externalId = "";
        this.externalSource = "";
        this.ontologyComment = "";
        this.curator = "";
        this.parentId = 0;
        this.ontologyLevel = 0;
        this.created = "";
        this.lastUpdated = "";
    }

    public OntologyTerms(int ontologyTermId, String term, String definition, String externalId, String externalSource,
                         String ontologyComment, String curator, int parentId, int ontologyLevel, String created,
                         String lastUpdated) {
        this.ontologyTermId = ontologyTermId;
        this.term = term;
        this.definition = definition;
        this.externalId = externalId;
        this.externalSource = externalSource;
        this.ontologyComment = ontologyComment;
        this.curator = curator;
        this.parentId = parentId;
        this.ontologyLevel = ontologyLevel;
        this.created = created;
        this.lastUpdated = lastUpdated;
    }

    public int getOntologyTermId() {
        return ontologyTermId;
    }

    public void setOntologyTermId(int ontologyTermId) {
        this.ontologyTermId = ontologyTermId;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getExternalSource() {
        return externalSource;
    }

    public void setExternalSource(String externalSource) {
        this.externalSource = externalSource;
    }

    public String getOntologyComment() {
        return ontologyComment;
    }

    public void setOntologyComment(String ontologyComment) {
        this.ontologyComment = ontologyComment;
    }

    public String getCurator() {
        return curator;
    }

    public void setCurator(String curator) {
        this.curator = curator;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getOntologyLevel() {
        return ontologyLevel;
    }

    public void setOntologyLevel(int ontologyLevel) {
        this.ontologyLevel = ontologyLevel;
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
    public String getOntologySynonym() {
        return OntologySynonym;
    }

    public void setOntologySynonym(String ontologySynonym) {
        OntologySynonym = ontologySynonym;
    }

    public String getCreatedSynonym() {
        return createdSynonym;
    }

    public void setCreatedSynonym(String createdSynonym) {
        this.createdSynonym = createdSynonym;
    }

    public String getLastUpdatedSynonym() {
        return lastUpdatedSynonym;
    }

    public void setLastUpdatedSynonym(String lastUpdatedSynonym) {
        this.lastUpdatedSynonym = lastUpdatedSynonym;
    }


        @Override
    public String toString() {
        return "OntologyTerms{" +
                "ontologyTermId=" + ontologyTermId +
                ", term='" + term + '\'' +
                ", definition='" + definition + '\'' +
                ", externalId='" + externalId + '\'' +
                ", externalSource='" + externalSource + '\'' +
                ", ontologyComment='" + ontologyComment + '\'' +
                ", curator='" + curator + '\'' +
                ", parentId=" + parentId +
                ", ontologyLevel=" + ontologyLevel +
                ", created='" + created + '\'' +
                ", lastUpdated='" + lastUpdated + '\'' +
                '}';
    }
}