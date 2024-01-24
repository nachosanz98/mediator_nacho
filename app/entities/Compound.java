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

    /* compound_identifiers */
    private String inchi;
    private String inchiKey;
    private String smiles;
    private String createdIdentifier;
    private String lastUpdatedIdentifier;

    /* compound_agilent */
    private int agilent_id;
    private String createdAgilent;
    private String lastUpdatedAgilent;

    /* compound_chebi */
    private int chebiId;
    private String createdChebi;
    private String lastUpdatedChebi;

    /* compound_hmdb */
    private String hmdbId;
    private String createdHmdb;
    private String lastUpdatedHmdb;

    /* compound_in_house */
    private int inHouseID;
    private String sourceData;
    private String description;
    private String createdInHouse;
    private String lastUpdatedInHouse;

    /* compound_kegg */
    private String keggId;
    private String createdKegg;
    private String lastUpdatedKegg;

    /* compound_lipids_classification */
    private String lipidType;
    private Integer numChains;
    private Integer numCarbons;
    private Integer doubleBonds;
    private String createdLipid;
    private String lastUpdatedLipid;

    /* compound_lm */
    private String lmId;
    private String createdLm;
    private String lastUpdatedLm;

    /* compound_lm_classification */
    private String category;
    private String mainClass;
    private String subClass;
    private String classLevel4;
    private String createdLmClassification;
    private String lastUpdatedLmClassification;

    /* compound_pc */
    private int pcId;
    private String createdPc;
    private String lastUpdatedPc;

    /* compound_reactions_kegg */
    private String reactionId;
    private String createdReaction;
    private String lastUpdatedReaction;



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
        this.inchi = "";
        this.inchiKey = "";
        this.smiles = "";
        this.createdIdentifier = "";
        this.lastUpdatedIdentifier = "";
        this.agilent_id = 0;
        this.createdAgilent = "";
        this.lastUpdatedAgilent = "";
        this.chebiId = 0;
        this.createdChebi = "";
        this.lastUpdatedChebi = "";
        this.hmdbId = "";
        this.createdHmdb = "";
        this.lastUpdatedHmdb = "";
        this.inHouseID = 0;
        this.sourceData = "";
        this.description = "";
        this.createdInHouse = "";
        this.lastUpdatedInHouse = "";
        this.keggId = "";
        this.createdKegg = "";
        this.lastUpdatedKegg = "";
        this.lipidType = "";
        this.numChains = 0;
        this.numCarbons = 0;
        this.doubleBonds = 0;
        this.createdLipid = "";
        this.lastUpdatedLipid = "";
        this.lmId = "";
        this.createdLm = "";
        this.lastUpdatedLm = "";
        this.category = "";
        this.mainClass = "";
        this.subClass = "";
        this.classLevel4 = "";
        this.createdLmClassification = "";
        this.lastUpdatedLmClassification = "";
        this.pcId = 0;
        this.createdPc = "";
        this.lastUpdatedPc = "";
        this.reactionId = "";
        this.createdReaction = "";
        this.lastUpdatedReaction = "";
    }

    public Compound(int compoundId, String casId, String compoundName, String formula, double mass, int chargeType,
                    int chargeNumber, String formulaType, int compoundType, int compoundStatus, String created,
                    String lastUpdated, int formulaTypeInt, Double logP,
                    String smiles, String createdIdentifier, String lastUpdatedIdentifier,
                    int agilent_id, String createdAgilent, String lastUpdatedAgilent,
                    int chebiId, String createdChebi, String lastUpdatedChebi,
                    String hmdbId, String createdHmdb, String lastUpdatedHmdb,
                    int inHouseID, String sourceData, String description, String createdInHouse, String lastUpdatedInHouse,
                    String keggId, String createdKegg, String lastUpdatedKegg,
                    String lipidType, Integer numChains, Integer numCarbons, Integer doubleBonds, String createdLipid, String lastUpdatedLipid,
                    String lmId, String createdLm, String lastUpdatedLm,
                    String category, String mainClass, String subClass, String classLevel4, String createdLmClassification, String lastUpdatedLmClassification,
                    int pcId, String createdPc, String lastUpdatedPc,
                    String reactionId, String createdReaction, String lastUpdatedReaction) {
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
        this.inchi = inchi;
        this.inchiKey = inchiKey;
        this.smiles = smiles;
        this.createdIdentifier = createdIdentifier;
        this.lastUpdatedIdentifier = lastUpdatedIdentifier;
        this.agilent_id = agilent_id;
        this.createdAgilent = createdAgilent;
        this.lastUpdatedAgilent = lastUpdatedAgilent;
        this.chebiId = chebiId;
        this.createdChebi = createdChebi;
        this.lastUpdatedChebi = lastUpdatedChebi;
        this.hmdbId = hmdbId;
        this.createdHmdb = createdHmdb;
        this.lastUpdatedHmdb = lastUpdatedHmdb;
        this.inHouseID = inHouseID;
        this.sourceData = sourceData;
        this.description = description;
        this.createdInHouse = createdInHouse;
        this.lastUpdatedInHouse = lastUpdatedInHouse;
        this.keggId = keggId;
        this.createdKegg = createdKegg;
        this.lastUpdatedKegg = lastUpdatedKegg;
        this.lipidType = lipidType;
        this.numChains = numChains;
        this.numCarbons = numCarbons;
        this.doubleBonds = doubleBonds;
        this.createdLipid = createdLipid;
        this.lastUpdatedLipid = lastUpdatedLipid;
        this.lmId = lmId;
        this.createdLm = createdLm;
        this.lastUpdatedLm = lastUpdatedLm;
        this.category = category;
        this.mainClass = mainClass;
        this.subClass = subClass;
        this.classLevel4 = classLevel4;
        this.createdLmClassification = createdLmClassification;
        this.lastUpdatedLmClassification = lastUpdatedLmClassification;
        this.pcId = pcId;
        this.createdPc = createdPc;
        this.lastUpdatedPc = lastUpdatedPc;
        this.reactionId = reactionId;
        this.createdReaction = createdReaction;
        this.lastUpdatedReaction = lastUpdatedReaction;
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
    public String getSmiles() {
        return smiles;
    }

    public void setSmiles(String smiles) {
        this.smiles = smiles;
    }

    public String getCreatedIdentifier() {
        return createdIdentifier;
    }

    public void setCreatedIdentifier(String createdIdentifier) {
        this.createdIdentifier = createdIdentifier;
    }

    public String getLastUpdatedIdentifier() {
        return lastUpdatedIdentifier;
    }

    public void setLastUpdatedIdentifier(String lastUpdatedIdentifier) {
        this.lastUpdatedIdentifier = lastUpdatedIdentifier;
    }

    public int getAgilentId() {
        return agilent_id;
    }

    public void setAgilentId(int agilent_id) {
        this.agilent_id = agilent_id;
    }

    public String getCreatedAgilent() {
        return createdAgilent;
    }

    public void setCreatedAgilent(String createdAgilent) {
        this.createdAgilent = createdAgilent;
    }

    public String getLastUpdatedAgilent() {
        return lastUpdatedAgilent;
    }

    public void setLastUpdatedAgilent(String lastUpdatedAgilent) {
        this.lastUpdatedAgilent = lastUpdatedAgilent;
    }

    public int getChebiId() {
        return chebiId;
    }

    public void setChebiId(int chebiId) {
        this.chebiId = chebiId;
    }

    public String getCreatedChebi() {
        return createdChebi;
    }

    public void setCreatedChebi(String createdChebi) {
        this.createdChebi = createdChebi;
    }

    public String getLastUpdatedChebi() {
        return lastUpdatedChebi;
    }

    public void setLastUpdatedChebi(String lastUpdatedChebi) {
        this.lastUpdatedChebi = lastUpdatedChebi;
    }

    public String getHmdbId() {
        return hmdbId;
    }

    public void setHmdbId(String hmdbId) {
        this.hmdbId = hmdbId;
    }

    public String getCreatedHmdb() {
        return createdHmdb;
    }

    public void setCreatedHmdb(String createdHmdb) {
        this.createdHmdb = createdHmdb;
    }

    public String getLastUpdatedHmdb() {
        return lastUpdatedHmdb;
    }

    public void setLastUpdatedHmdb(String lastUpdatedHmdb) {
        this.lastUpdatedHmdb = lastUpdatedHmdb;
    }

    public int getInHouseID() {
        return inHouseID;
    }

    public void setInHouseID(int inHouseID) {
        this.inHouseID = inHouseID;
    }

    public String getSourceData() {
        return sourceData;
    }

    public void setSourceData(String sourceData) {
        this.sourceData = sourceData;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedInHouse() {
        return createdInHouse;
    }

    public void setCreatedInHouse(String createdInHouse) {
        this.createdInHouse = createdInHouse;
    }

    public String getLastUpdatedInHouse() {
        return lastUpdatedInHouse;
    }

    public void setLastUpdatedInHouse(String lastUpdatedInHouse) {
        this.lastUpdatedInHouse = lastUpdatedInHouse;
    }

    public String getKeggId() {
        return keggId;
    }

    public void setKeggId(String keggId) {
        this.keggId = keggId;
    }

    public String getCreatedKegg() {
        return createdKegg;
    }

    public void setCreatedKegg(String createdKegg) {
        this.createdKegg = createdKegg;
    }

    public String getLastUpdatedKegg() {
        return lastUpdatedKegg;
    }

    public void setLastUpdatedKegg(String lastUpdatedKegg) {
        this.lastUpdatedKegg = lastUpdatedKegg;
    }

    public String getLipidType() {
        return lipidType;
    }

    public void setLipidType(String lipidType) {
        this.lipidType = lipidType;
    }

    public Integer getNumChains() {
        return numChains;
    }

    public void setNumChains(Integer numChains) {
        this.numChains = numChains;
    }

    public Integer getNumCarbons() {
        return numCarbons;
    }

    public void setNumCarbons(Integer numCarbons) {
        this.numCarbons = numCarbons;
    }

    public Integer getDoubleBonds() {
        return doubleBonds;
    }

    public void setDoubleBonds(Integer doubleBonds) {
        this.doubleBonds = doubleBonds;
    }

    public String getCreatedLipid() {
        return createdLipid;
    }

    public void setCreatedLipid(String createdLipid) {
        this.createdLipid = createdLipid;
    }

    public String getLastUpdatedLipid() {
        return lastUpdatedLipid;
    }

    public void setLastUpdatedLipid(String lastUpdatedLipid) {
        this.lastUpdatedLipid = lastUpdatedLipid;
    }

    public String getLmId() {
        return lmId;
    }

    public void setLmId(String lmId) {
        this.lmId = lmId;
    }

    public String getCreatedLm() {
        return createdLm;
    }

    public void setCreatedLm(String createdLm) {
        this.createdLm = createdLm;
    }

    public String getLastUpdatedLm() {
        return lastUpdatedLm;
    }

    public void setLastUpdatedLm(String lastUpdatedLm) {
        this.lastUpdatedLm = lastUpdatedLm;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMainClass() {
        return mainClass;
    }

    public void setMainClass(String mainClass) {
        this.mainClass = mainClass;
    }

    public String getSubClass() {
        return subClass;
    }

    public void setSubClass(String subClass) {
        this.subClass = subClass;
    }

    public String getClassLevel4() {
        return classLevel4;
    }

    public void setClassLevel4(String classLevel4) {
        this.classLevel4 = classLevel4;
    }

    public String getCreatedLmClassification() {
        return createdLmClassification;
    }

    public void setCreatedLmClassification(String createdLmClassification) {
        this.createdLmClassification = createdLmClassification;
    }

    public String getLastUpdatedLmClassification() {
        return lastUpdatedLmClassification;
    }

    public void setLastUpdatedLmClassification(String lastUpdatedLmClassification) {
        this.lastUpdatedLmClassification = lastUpdatedLmClassification;
    }

    public int getPcId() {
        return pcId;
    }

    public void setPcId(int pcId) {
        this.pcId = pcId;
    }

    public String getCreatedPc() {
        return createdPc;
    }

    public void setCreatedPc(String createdPc) {
        this.createdPc = createdPc;
    }

    public String getLastUpdatedPc() {
        return lastUpdatedPc;
    }

    public void setLastUpdatedPc(String lastUpdatedPc) {
        this.lastUpdatedPc = lastUpdatedPc;
    }

    public String getReactionId() {
        return reactionId;
    }

    public void setReactionId(String reactionId) {
        this.reactionId = reactionId;
    }

    public String getCreatedReaction() {
        return createdReaction;
    }

    public void setCreatedReaction(String createdReaction) {
        this.createdReaction = createdReaction;
    }
    public String getLastUpdatedReaction() {
        return lastUpdatedReaction;
    }

    public void setLastUpdatedReaction(String lastUpdatedReaction) {
        this.lastUpdatedReaction = lastUpdatedReaction;
    }

    @Override
    public String toString() {
        return "Compound{" +
                "compoundId=" + compoundId + '\'' +
                ", casId='" + casId + '\'' +
                ", compoundName='" + compoundName + '\'' +
                ", formula='" + formula + '\'' +
                ", mass=" + mass + '\'' +
                ", chargeType=" + chargeType + '\'' +
                ", chargeNumber=" + chargeNumber + '\'' +
                ", formulaType='" + formulaType + '\'' +
                ", compoundType=" + compoundType + '\'' +
                ", compoundStatus=" + compoundStatus + '\'' +
                ", created='" + created + '\'' +
                ", lastUpdated='" + lastUpdated + '\'' +
                ", formulaTypeInt=" + formulaTypeInt + '\'' +
                ", logP=" + logP + '\'' +
                ", inchi='" + inchi + '\'' +
                ", inchi_key='" + inchiKey + '\'' +
                ", smiles='" + smiles + '\'' +
                ", createdIdentifier='" + createdIdentifier + '\'' +
                ", lastUpdatedIdentifier='" + lastUpdatedIdentifier + '\'' +
                ", agilent_id=" + agilent_id + '\'' +
                ", createdAgilent='" + createdAgilent + '\'' +
                ", lastUpdatedAgilent='" + lastUpdatedAgilent + '\'' +
                ", chebiId=" + chebiId + '\'' +
                ", createdChebi='" + createdChebi + '\'' +
                ", lastUpdatedChebi='" + lastUpdatedChebi + '\'' +
                ", hmdbId=" + hmdbId + '\'' +
                ", createdHmdb='" + createdHmdb + '\'' +
                ", lastUpdatedHmdb='" + lastUpdatedHmdb + '\'' +
                ", inHouseID=" + inHouseID + '\'' +
                ", sourceData='" + sourceData + '\'' +
                ", description='" + description + '\'' +
                ", createdInHouse='" + createdInHouse + '\'' +
                ", lastUpdatedInHouse='" + lastUpdatedInHouse + '\'' +
                ", keggId=" + keggId + '\'' +
                ", createdKegg='" + createdKegg + '\'' +
                ", lastUpdatedKegg='" + lastUpdatedKegg + '\'' +
                ", lipidType='" + lipidType + '\'' +
                ", numChains=" + numChains + '\'' +
                ", numCarbons=" + numCarbons + '\'' +
                ", doubleBonds=" + doubleBonds + '\'' +
                ", createdLipid='" + createdLipid + '\'' +
                ", lastUpdatedLipid='" + lastUpdatedLipid + '\'' +
                ", lmId=" + lmId + '\'' +
                ", createdLm='" + createdLm + '\'' +
                ", lastUpdatedLm='" + lastUpdatedLm + '\'' +
                ", category='" + category + '\'' +
                ", mainClass='" + mainClass + '\'' +
                ", subClass='" + subClass + '\'' +
                ", classLevel4='" + classLevel4 + '\'' +
                ", createdLmClassification='" + createdLmClassification + '\'' +
                ", lastUpdatedLmClassification='" + lastUpdatedLmClassification + '\'' +
                ", pcId=" + pcId + '\'' +
                ", createdPc='" + createdPc + '\'' +
                ", lastUpdatedPc='" + lastUpdatedPc + '\'' +
                ", reactionId=" + reactionId + '\'' +
                ", createdReaction='" + createdReaction + '\'' +
                ", lastUpdatedReaction='" + lastUpdatedReaction +
                '}';
    }
}