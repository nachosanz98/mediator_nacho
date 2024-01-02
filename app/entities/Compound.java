package entities;

public class Compound {

    private int compoundId;
    private String casId;
    private String compoundName;
    private String formula;
    private double mass;
    private int chargeType;
    private int chargeNumber;
    private String formulaType;
    private int compoundType;
    private int compoundStatus;
    private String created;
    private String lastUpdated;
    private int formulaTypeInt;
    private Double logP;

    public Compound() {
        this.compoundId = 0;
        this.casId = "";
        this.compoundName = "";
        this.formula = "";
        this.mass = 0.0;
        this.chargeType = 0;
        this.chargeNumber = 0;
        this.formulaType = "";
        this.compoundType = 0;
        this.compoundStatus = 0;
        this.created = "";
        this.lastUpdated = "";
        this.formulaTypeInt = 0;
        this.logP = 0.0;
    }

    public Compound(int compoundId, String casId, String compoundName, String formula, double mass, int chargeType,
                    int chargeNumber, String formulaType, int compoundType, int compoundStatus, String created,
                    String lastUpdated, int formulaTypeInt, Double logP) {
        this.compoundId = compoundId;
        this.casId = casId;
        this.compoundName = compoundName;
        this.formula = formula;
        this.mass = mass;
        this.chargeType = chargeType;
        this.chargeNumber = chargeNumber;
        this.formulaType = formulaType;
        this.compoundType = compoundType;
        this.compoundStatus = compoundStatus;
        this.created = created;
        this.lastUpdated = lastUpdated;
        this.formulaTypeInt = formulaTypeInt;
        this.logP = logP;
    }


    public int getCompoundId() {
        return compoundId;
    }

    public void setCompoundId(int compoundId) {
        this.compoundId = compoundId;
    }

    public String getCasId() {
        return casId;
    }

    public void setCasId(String casId) {
        this.casId = casId;
    }

    public String getCompoundName() {
        return compoundName;
    }

    public void setCompoundName(String compoundName) {
        this.compoundName = compoundName;
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

    public int getChargeType() {
        return chargeType;
    }

    public void setChargeType(int chargeType) {
        this.chargeType = chargeType;
    }

    public int getChargeNumber() {
        return chargeNumber;
    }

    public void setChargeNumber(int chargeNumber) {
        this.chargeNumber = chargeNumber;
    }

    public String getFormulaType() {
        return formulaType;
    }

    public void setFormulaType(String formulaType) {
        this.formulaType = formulaType;
    }

    public int getCompoundType() {
        return compoundType;
    }

    public void setCompoundType(int compoundType) {
        this.compoundType = compoundType;
    }

    public int getCompoundStatus() {
        return compoundStatus;
    }

    public void setCompoundStatus(int compoundStatus) {
        this.compoundStatus = compoundStatus;
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

    public int getFormulaTypeInt() {
        return formulaTypeInt;
    }

    public void setFormulaTypeInt(int formulaTypeInt) {
        this.formulaTypeInt = formulaTypeInt;
    }

    public Double getLogP() {
        return logP;
    }

    public void setLogP(Double logP) {
        this.logP = logP;
    }

    @Override
    public String toString() {
        return "Compound{" +
                "compoundId=" + compoundId +
                ", casId='" + casId + '\'' +
                ", compoundName='" + compoundName + '\'' +
                ", formula='" + formula + '\'' +
                ", mass=" + mass +
                ", chargeType=" + chargeType +
                ", chargeNumber=" + chargeNumber +
                ", formulaType='" + formulaType + '\'' +
                ", compoundType=" + compoundType +
                ", compoundStatus=" + compoundStatus +
                ", created=" + created +
                ", lastUpdated=" + lastUpdated +
                ", formulaTypeInt=" + formulaTypeInt +
                ", logP=" + logP +
                '}';
    }
}