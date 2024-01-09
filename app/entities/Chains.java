package entities;

public class Chains {

    private int chainsId;
    private int numCarbons;
    private int doubleBonds;
    private String oxidation;
    private double mass;
    private String formula;
    private String created;
    private String lastUpdated;

    public Chains() {
        this.chainsId = 0;
        this.numCarbons = 0;
        this.doubleBonds = 0;
        this.oxidation = "";
        this.mass = 0.0;
        this.formula = "";
        this.created = "";
        this.lastUpdated = "";
    }

    public Chains(int chainsId, int numCarbons, int doubleBonds, String oxidation, double mass, String formula, String created, String lastUpdated) {
        this.chainsId = chainsId;
        this.numCarbons = numCarbons;
        this.doubleBonds = doubleBonds;
        this.oxidation = oxidation;
        this.mass = mass;
        this.formula = formula;
        this.created = created;
        this.lastUpdated = lastUpdated;
    }

    // Getters y setters
    public int getChainsId() {
        return chainsId;
    }

    public void setChainsId(int chainsId) {
        this.chainsId = chainsId;
    }

    public int getNumCarbons() {
        return numCarbons;
    }

    public void setNumCarbons(int numCarbons) {
        this.numCarbons = numCarbons;
    }

    public int getDoubleBonds() {
        return doubleBonds;
    }

    public void setDoubleBonds(int doubleBonds) {
        this.doubleBonds = doubleBonds;
    }

    public String getOxidation() {
        return oxidation;
    }

    public void setOxidation(String oxidation) {
        this.oxidation = oxidation;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
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
        return "Chains{" +
                "chainsId=" + chainsId +
                ", numCarbons=" + numCarbons +
                ", doubleBonds=" + doubleBonds +
                ", oxidation='" + oxidation + '\'' +
                ", mass=" + mass +
                ", formula='" + formula + '\'' +
                ", created='" + created + '\'' +
                ", lastUpdated='" + lastUpdated + '\'' +
                '}';
    }
}

