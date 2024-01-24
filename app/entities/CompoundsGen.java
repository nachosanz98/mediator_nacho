package entities;

public class CompoundsGen {
    private int compoundId;
    private String mineId;
    private String mineFileId;
    private String compoundName;
    private String formula;
    private double mass;
    private int chargeType;
    private int chargeNumber;
    private double npLikeness;
    private String formulaType;
    private int formulaTypeInt;
    private String created;
    private String lastUpdated;

    public CompoundsGen() {
        this.compoundId = 0;
        this.mineId = "";
        this.mineFileId = "";
        this.compoundName = "";
        this.formula = "";
        this.mass = 0.0;
        this.chargeType = 0;
        this.chargeNumber = 0;
        this.npLikeness = 0.0;
        this.formulaType = "";
        this.formulaTypeInt = 0;
        this.created = "";
        this.lastUpdated = "";
    }

    public CompoundsGen(int compoundId, String mineId, String mineFileId, String compoundName, String formula, double mass,
                       int chargeType, int chargeNumber, double npLikeness, String formulaType, int formulaTypeInt,
                       String created, String lastUpdated) {
        this.compoundId = compoundId;
        this.mineId = mineId;
        this.mineFileId = mineFileId;
        this.compoundName = compoundName;
        this.formula = formula;
        this.mass = mass;
        this.chargeType = chargeType;
        this.chargeNumber = chargeNumber;
        this.npLikeness = npLikeness;
        this.formulaType = formulaType;
        this.formulaTypeInt = formulaTypeInt;
        this.created = created;
        this.lastUpdated = lastUpdated;
    }

    public int getCompoundId() {
        return compoundId;
    }

    public void setCompoundId(int compoundId) {
        this.compoundId = compoundId;
    }

    public String getMineId() {
        return mineId;
    }

    public void setMineId(String mineId) {
        this.mineId = mineId;
    }

    public String getMineFileId() {
        return mineFileId;
    }

    public void setMineFileId(String mineFileId) {
        this.mineFileId = mineFileId;
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

    public double getNpLikeness() {
        return npLikeness;
    }

    public void setNpLikeness(double npLikeness) {
        this.npLikeness = npLikeness;
    }

    public String getFormulaType() {
        return formulaType;
    }

    public void setFormulaType(String formulaType) {
        this.formulaType = formulaType;
    }

    public int getFormulaTypeInt() {
        return formulaTypeInt;
    }

    public void setFormulaTypeInt(int formulaTypeInt) {
        this.formulaTypeInt = formulaTypeInt;
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
        return "CompoundGen{" +
                "compoundId=" + compoundId +
                ", mineId='" + mineId + '\'' +
                ", mineFileId='" + mineFileId + '\'' +
                ", compoundName='" + compoundName + '\'' +
                ", formula='" + formula + '\'' +
                ", mass=" + mass +
                ", chargeType=" + chargeType +
                ", chargeNumber=" + chargeNumber +
                ", npLikeness=" + npLikeness +
                ", formulaType='" + formulaType + '\'' +
                ", formulaTypeInt=" + formulaTypeInt +
                ", created=" + created +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
