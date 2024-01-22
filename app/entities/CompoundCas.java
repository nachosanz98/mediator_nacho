package entities;

public class CompoundCas {
    private String casId;
    private String formula;
    private double mass;
    private String inchi;
    private String inchiKey;
    private String created;
    private String lastUpdated;

    public CompoundCas(){
        this.casId = "";
        this.formula = "";
        this.mass = 0.0;
        this.inchi = "";
        this.inchiKey = "";
        this.created = "";
        this.lastUpdated = "";
    }

    public CompoundCas(String casId, String formula, double mass, String inchi, String inchiKey, String created, String lastUpdated) {
        this.casId = casId;
        this.formula = formula;
        this.mass = mass;
        this.inchi = inchi;
        this.inchiKey = inchiKey;
        this.created = created;
        this.lastUpdated = lastUpdated;
    }

    public String getCasId() {
        return casId;
    }

    public void setCasId(String casId) {
        this.casId = casId;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public String getInchi() {
        return inchi;
    }
    public void setInchi(String inchi) {
        this.inchi = inchi;
    }

    public String getInchiKey() {
        return inchiKey;
    }

    public void setInchiKey(String inchiKey) {
        this.inchiKey = inchiKey;
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
        return "CompoundCas{" +
                ", casId='" + casId + '\'' +
                ", formula='" + formula + '\'' +
                ", mass=" + mass +
                ", inchi='" + inchi + '\'' +
                ", inchiKey='" + inchiKey + '\'' +
                ", createdCas='" + created + '\'' +
                ", lastUpdatedCas='" + lastUpdated +
                '}';
    }
}
