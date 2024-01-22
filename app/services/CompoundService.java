package services;

import entities.Compound;
import play.db.Database;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Singleton
public class CompoundService {
    private final Database db;
    private final DatabaseExecutionContext dec;

    @Inject
    public CompoundService(Database db, DatabaseExecutionContext dec) {
        this.db = db;
        this.dec = dec;
    }

    public CompletionStage<Compound> getCompound(int compoundId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT * FROM compounds WHERE compound_id = ?");
                    statement.setInt(1, compoundId);
                    ResultSet resultSet = statement.executeQuery();

                    if (resultSet.next()) {
                        Compound compound = new Compound();
                        compound.setCompoundId(resultSet.getInt("compound_id"));
                        compound.setCasId(resultSet.getString("cas_id"));
                        compound.setCompoundName(resultSet.getString("compound_name"));
                        compound.setFormula(resultSet.getString("formula"));
                        compound.setMass(resultSet.getDouble("mass"));
                        compound.setChargeType(resultSet.getInt("charge_type"));
                        compound.setChargeNumber(resultSet.getInt("charge_number"));
                        compound.setFormulaType(resultSet.getString("formula_type"));
                        compound.setCompoundType(resultSet.getInt("compound_type"));
                        compound.setCompoundStatus(resultSet.getInt("compound_status"));
                        compound.setCreated(resultSet.getString("created"));
                        compound.setLastUpdated(resultSet.getString("last_updated"));
                        compound.setFormulaTypeInt(resultSet.getInt("formula_type_int"));
                        compound.setLogP(resultSet.getDouble("logP"));
                        return compound;
                    }
                    return null;
                }), dec);
    }

    public CompletionStage<Boolean> addCompound(Compound compound) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "INSERT INTO compounds (cas_id, compound_name, formula, mass, charge_type, " +
                                    "charge_number, formula_type, compound_type, compound_status, created, last_updated, " +
                                    "formula_type_int, logP) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

                    statement.setString(1, compound.getCasId());
                    statement.setString(2, compound.getCompoundName());
                    statement.setString(3, compound.getFormula());
                    statement.setDouble(4, compound.getMass());
                    statement.setInt(5, compound.getChargeType());
                    statement.setInt(6, compound.getChargeNumber());
                    statement.setString(7, compound.getFormulaType());
                    statement.setInt(8, compound.getCompoundType());
                    statement.setInt(9, compound.getCompoundStatus());
                    statement.setString(10, compound.getCreated());
                    statement.setString(11, compound.getLastUpdated());
                    statement.setInt(12, compound.getFormulaTypeInt());
                    statement.setDouble(13, compound.getLogP());

                    int rowsInserted = statement.executeUpdate();

                    /* compound_agilent */
                    if (rowsInserted > 0 && !compound.getCreatedAgilent().isEmpty()) {
                        PreparedStatement agilentStatement = connection.prepareStatement(
                                "INSERT INTO compounds_agilent (agilent_id, created, last_updated) " +
                                        "VALUES (?, ?, ?)");
                        agilentStatement.setInt(1, compound.getAgilentId());
                        agilentStatement.setString(2, compound.getCreatedAgilent());
                        agilentStatement.setString(3, compound.getLastUpdatedAgilent());
                        int agilentRowsInserted = agilentStatement.executeUpdate();
                        if (agilentRowsInserted == 0) {
                            return false;
                        }
                    }

                    /* compound_chebi */
                    if (rowsInserted > 0 && !compound.getCreatedChebi().isEmpty()) {
                        PreparedStatement chebiStatement = connection.prepareStatement(
                                "INSERT INTO compounds_chebi (chebi_id, created, last_updated) " +
                                        "VALUES (?, ?, ?)");
                        chebiStatement.setInt(1, compound.getChebiId());
                        chebiStatement.setString(2, compound.getCreatedChebi());
                        chebiStatement.setString(3, compound.getLastUpdatedChebi());
                        int chebiRowsInserted = chebiStatement.executeUpdate();
                        if (chebiRowsInserted == 0) {
                            return false;
                        }
                    }

                    /* compound_gen */
                    if (rowsInserted > 0 && !compound.getCreatedGen().isEmpty()) {
                        PreparedStatement genStatement = connection.prepareStatement(
                                "INSERT INTO compounds_gen (MINE_id, MINE_file_id, compound_name, formula, mass, " +
                                        "charge_type, charge_number, np_likeness, formula_type, formula_type_int, " +
                                        "created, last_updated) " +
                                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                        genStatement.setInt(1, compound.getMineID());
                        genStatement.setString(2, compound.getMineFileID());
                        genStatement.setString(3, compound.getCompoundName());
                        genStatement.setString(4, compound.getFormula());
                        genStatement.setDouble(5, compound.getMass());
                        genStatement.setInt(6, compound.getChargeType());
                        genStatement.setInt(7, compound.getChargeNumber());
                        genStatement.setDouble(8, compound.getNpLikeness());
                        genStatement.setString(9, compound.getFormulaType());
                        genStatement.setInt(10, compound.getFormulaTypeInt());
                        genStatement.setString(11, compound.getCreatedGen());
                        genStatement.setString(12, compound.getLastUpdatedGen());
                        int genRowsInserted = genStatement.executeUpdate();
                        if (genRowsInserted == 0) {
                            return false;
                        }
                    }

                    /* compound_hmdb */
                    if (rowsInserted > 0 && !compound.getCreatedHmdb().isEmpty()) {
                        PreparedStatement hmdbStatement = connection.prepareStatement(
                                "INSERT INTO compounds_hmdb (hmdb_id, created, last_updated) " +
                                        "VALUES (?, ?, ?)");
                        hmdbStatement.setInt(1, compound.getHmdbId());
                        hmdbStatement.setString(2, compound.getCreatedHmdb());
                        hmdbStatement.setString(3, compound.getLastUpdatedHmdb());
                        int hmdbRowsInserted = hmdbStatement.executeUpdate();
                        if (hmdbRowsInserted == 0) {
                            return false;
                        }
                    }

                    /* compound_in_house */
                    if (rowsInserted > 0 && !compound.getCreatedInHouse().isEmpty()) {
                        PreparedStatement inhouseStatement = connection.prepareStatement(
                                "INSERT INTO compounds_in_house (in_house_id, source_data, description," +
                                        " created, last_updated) VALUES (?, ?, ?, ?, ?)");
                        inhouseStatement.setInt(1, compound.getInHouseID());
                        inhouseStatement.setString(2, compound.getSourceData());
                        inhouseStatement.setString(3, compound.getDescription());
                        inhouseStatement.setString(4, compound.getCreatedInHouse());
                        inhouseStatement.setString(5, compound.getLastUpdatedInHouse());
                        int inhouseRowsInserted = inhouseStatement.executeUpdate();
                        if (inhouseRowsInserted == 0) {
                            return false;
                        }
                    }

                    /* compound_kegg */
                    if (rowsInserted > 0 && !compound.getCreatedKegg().isEmpty()) {
                        PreparedStatement keggStatement = connection.prepareStatement(
                                "INSERT INTO compounds_kegg (kegg_id, created, last_updated) " +
                                        "VALUES (?, ?, ?)");
                        keggStatement.setInt(1, compound.getKeggId());
                        keggStatement.setString(2, compound.getCreatedKegg());
                        keggStatement.setString(3, compound.getLastUpdatedKegg());
                        int keggRowsInserted = keggStatement.executeUpdate();
                        if (keggRowsInserted == 0) {
                            return false;
                        }
                    }

                    /* compound_lipids_classification */
                    if (rowsInserted > 0 && !compound.getCreatedLipid().isEmpty()) {
                        PreparedStatement lipidStatement = connection.prepareStatement(
                                "INSERT INTO compounds_lipids_classification (lipid_type, num_chains, " +
                                        "number_carbons, double_bonds, created, last_updated) VALUES (?, ?, ?, ?, ?, ?)");
                        lipidStatement.setString(1, compound.getLipidType());
                        lipidStatement.setInt(2, compound.getNumChains());
                        lipidStatement.setInt(3, compound.getNumCarbons());
                        lipidStatement.setInt(4, compound.getDoubleBonds());
                        lipidStatement.setString(5, compound.getCreatedLipid());
                        lipidStatement.setString(6, compound.getLastUpdatedLipid());
                        int lipidRowsInserted = lipidStatement.executeUpdate();
                        if (lipidRowsInserted == 0) {
                            return false;
                        }
                    }

                    /* compound_lm */
                    if (rowsInserted > 0 && !compound.getCreatedLm().isEmpty()) {
                        PreparedStatement lmStatement = connection.prepareStatement(
                                "INSERT INTO compounds_lm (lm_id, created, last_updated) " +
                                        "VALUES (?, ?, ?)");
                        lmStatement.setInt(1, compound.getLmId());
                        lmStatement.setString(2, compound.getCreatedLm());
                        lmStatement.setString(3, compound.getLastUpdatedLm());
                        int lmRowsInserted = lmStatement.executeUpdate();
                        if (lmRowsInserted == 0) {
                            return false;
                        }
                    }

                    /* compound_lm_classification */
                    if (rowsInserted > 0 && !compound.getCreatedLmClassification().isEmpty()) {
                        PreparedStatement lmclasStatement = connection.prepareStatement(
                                "INSERT INTO compounds_lm_classification (category, main_class, " +
                                        "sub_class, class_level4, created, last_updated) VALUES (?, ?, ?, ?, ?, ?)");
                        lmclasStatement.setString(1, compound.getCategory());
                        lmclasStatement.setString(2, compound.getMainClass());
                        lmclasStatement.setString(3, compound.getSubClass());
                        lmclasStatement.setString(4, compound.getClassLevel4());
                        lmclasStatement.setString(5, compound.getCreatedLmClassification());
                        lmclasStatement.setString(6, compound.getLastUpdatedLmClassification());
                        int lmclasRowsInserted = lmclasStatement.executeUpdate();
                        if (lmclasRowsInserted == 0) {
                            return false;
                        }
                    }

                    /* compound_pc */
                    if (rowsInserted > 0 && !compound.getCreatedPc().isEmpty()) {
                        PreparedStatement pcStatement = connection.prepareStatement(
                                "INSERT INTO compounds_pc (pc_id, created, last_updated) " +
                                        "VALUES (?, ?, ?)");
                        pcStatement.setInt(1, compound.getPcId());
                        pcStatement.setString(2, compound.getCreatedPc());
                        pcStatement.setString(3, compound.getLastUpdatedPc());
                        int pcRowsInserted = pcStatement.executeUpdate();
                        if (pcRowsInserted == 0) {
                            return false;
                        }
                    }

                    /* compound_reactions_kegg */
                    if (rowsInserted > 0 && !compound.getCreatedReaction().isEmpty()) {
                        PreparedStatement reactionStatement = connection.prepareStatement(
                                "INSERT INTO compound_reactions_kegg (reaction_id, created, last_updated) " +
                                        "VALUES (?, ?, ?)");
                        reactionStatement.setInt(1, compound.getReactionId());
                        reactionStatement.setString(2, compound.getCreatedReaction());
                        reactionStatement.setString(3, compound.getLastUpdatedReaction());
                        int reactionRowsInserted = reactionStatement.executeUpdate();
                        if (reactionRowsInserted == 0) {
                            return false;
                        }
                    }

                    return rowsInserted > 0;
                }), dec);
    }

    public CompletionStage<Boolean> deleteCompound(int compoundId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "DELETE FROM compounds WHERE compound_id = ?");
                    statement.setInt(1, compoundId);
                    int rowsDeleted = statement.executeUpdate();
                    if (rowsDeleted > 0) {
                        PreparedStatement agilentStatement = connection.prepareStatement(
                                "DELETE FROM compounds_agilent WHERE compound_id = ?");
                        agilentStatement.setInt(1, compoundId);
                        agilentStatement.executeUpdate();

                        PreparedStatement chebiStatement = connection.prepareStatement(
                                "DELETE FROM compounds_chebi WHERE compound_id = ?");
                        chebiStatement.setInt(1, compoundId);
                        chebiStatement.executeUpdate();

                        PreparedStatement genStatement = connection.prepareStatement(
                                "DELETE FROM compounds_gen WHERE compound_id = ?");
                        genStatement.setInt(1, compoundId);
                        genStatement.executeUpdate();

                        PreparedStatement hmdbStatement = connection.prepareStatement(
                                "DELETE FROM compounds_hmdb WHERE compound_id = ?");
                        hmdbStatement.setInt(1, compoundId);
                        hmdbStatement.executeUpdate();

                        PreparedStatement inhouseStatement = connection.prepareStatement(
                                "DELETE FROM compounds_in_house WHERE compound_id = ?");
                        inhouseStatement.setInt(1, compoundId);
                        inhouseStatement.executeUpdate();

                        PreparedStatement keggStatement = connection.prepareStatement(
                                "DELETE FROM compounds_kegg WHERE compound_id = ?");
                        keggStatement.setInt(1, compoundId);
                        keggStatement.executeUpdate();

                        PreparedStatement lipidStatement = connection.prepareStatement(
                                "DELETE FROM compounds_lipids_classification WHERE compound_id = ?");
                        lipidStatement.setInt(1, compoundId);
                        lipidStatement.executeUpdate();

                        PreparedStatement lmStatement = connection.prepareStatement(
                                "DELETE FROM compounds_lm WHERE compound_id = ?");
                        lmStatement.setInt(1, compoundId);
                        lmStatement.executeUpdate();

                        PreparedStatement lmclasStatement = connection.prepareStatement(
                                "DELETE FROM compounds_lm_classification WHERE compound_id = ?");
                        lmclasStatement.setInt(1, compoundId);
                        lmclasStatement.executeUpdate();

                        PreparedStatement pcStatement = connection.prepareStatement(
                                "DELETE FROM compounds_pc WHERE compound_id = ?");
                        pcStatement.setInt(1, compoundId);
                        pcStatement.executeUpdate();

                        PreparedStatement reactionStatement = connection.prepareStatement(
                                "DELETE FROM compound_reactions_kegg WHERE compound_id = ?");
                        reactionStatement.setInt(1, compoundId);
                        reactionStatement.executeUpdate();
                    }
                    return rowsDeleted > 0;
                }), dec);
    }

    public CompletionStage<List<Compound>> getAllCompounds() {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM compounds");
                    List<Compound> compounds = new ArrayList<>();
                    while (resultSet.next()) {
                        Compound compound = new Compound();
                        compound.setCompoundId(resultSet.getInt("compound_id"));
                        compound.setCasId(resultSet.getString("cas_id"));
                        compound.setCompoundName(resultSet.getString("compound_name"));
                        compound.setFormula(resultSet.getString("formula"));
                        compound.setMass(resultSet.getDouble("mass"));
                        compound.setChargeType(resultSet.getInt("charge_type"));
                        compound.setChargeNumber(resultSet.getInt("charge_number"));
                        compound.setFormulaType(resultSet.getString("formula_type"));
                        compound.setCompoundType(resultSet.getInt("compound_type"));
                        compound.setCompoundStatus(resultSet.getInt("compound_status"));
                        compound.setCreated(resultSet.getString("created"));
                        compound.setLastUpdated(resultSet.getString("last_updated"));
                        compound.setFormulaTypeInt(resultSet.getInt("formula_type_int"));
                        compound.setLogP(resultSet.getDouble("logP"));
                        compounds.add(compound);
                    }
                    return compounds;
                }), dec);
    }

    public CompletionStage<Boolean> updateCompound(Compound compound, int id) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "UPDATE compounds SET cas_id = ?, compound_name = ?, formula = ?, mass = ?, " +
                                    "charge_type = ?, charge_number = ?, formula_type = ?, compound_type = ?, " +
                                    "compound_status = ?, created = ?, last_updated = ?, formula_type_int = ?, logP = ? " +
                                    "WHERE compound_id = ?");

                    statement.setString(1, compound.getCasId());
                    statement.setString(2, compound.getCompoundName());
                    statement.setString(3, compound.getFormula());
                    statement.setDouble(4, compound.getMass());
                    statement.setInt(5, compound.getChargeType());
                    statement.setInt(6, compound.getChargeNumber());
                    statement.setString(7, compound.getFormulaType());
                    statement.setInt(8, compound.getCompoundType());
                    statement.setInt(9, compound.getCompoundStatus());
                    statement.setString(10, compound.getCreated());
                    statement.setString(11, compound.getLastUpdated());
                    statement.setInt(12, compound.getFormulaTypeInt());
                    statement.setDouble(13, compound.getLogP());
                    statement.setInt(14, id);

                    int rowsUpdated = statement.executeUpdate();

                    if (rowsUpdated > 0 && !compound.getCreatedAgilent().isEmpty()) {
                        PreparedStatement agilentStatement = connection.prepareStatement(
                                "UPDATE compounds_agilent SET created = ?, last_updated = ? WHERE agilent_id = ?");
                        agilentStatement.setString(1, compound.getCreatedAgilent());
                        agilentStatement.setString(2, compound.getLastUpdatedAgilent());
                        agilentStatement.setInt(3, compound.getAgilentId());
                        int agilentRowsUpdated = agilentStatement.executeUpdate();
                        if (agilentRowsUpdated == 0) {
                            return false;
                        }
                    }

                    if (rowsUpdated > 0 && !compound.getCreatedChebi().isEmpty()) {
                        PreparedStatement chebiStatement = connection.prepareStatement(
                                "UPDATE compounds_chebi SET created = ?, last_updated = ? WHERE chebi_id = ?");
                        chebiStatement.setString(1, compound.getCreatedChebi());
                        chebiStatement.setString(2, compound.getLastUpdatedChebi());
                        chebiStatement.setInt(3, compound.getChebiId());
                        int chebiRowsUpdated = chebiStatement.executeUpdate();
                        if (chebiRowsUpdated == 0) {
                            return false;
                        }
                    }

                    if (rowsUpdated > 0 && !compound.getCreatedGen().isEmpty()) {
                        PreparedStatement genStatement = connection.prepareStatement(
                                "UPDATE compounds_gen SET compound_name = ?, formula = ?, mass = ?, charge_type = ?, " +
                                        "charge_number = ?, np_likeness = ?, formula_type = ?, formula_type_int = ?, " +
                                        "created = ?, last_updated = ? WHERE MINE_id = ?");
                        genStatement.setString(1, compound.getCompoundName());
                        genStatement.setString(2, compound.getFormula());
                        genStatement.setDouble(3, compound.getMass());
                        genStatement.setInt(4, compound.getChargeType());
                        genStatement.setInt(5, compound.getChargeNumber());
                        genStatement.setDouble(6, compound.getNpLikeness());
                        genStatement.setString(7, compound.getFormulaType());
                        genStatement.setInt(8, compound.getFormulaTypeInt());
                        genStatement.setString(9, compound.getCreatedGen());
                        genStatement.setString(10, compound.getLastUpdatedGen());
                        genStatement.setInt(11, compound.getMineID());
                        int genRowsUpdated = genStatement.executeUpdate();
                        if (genRowsUpdated == 0) {
                            return false;
                        }
                    }

                    if (rowsUpdated > 0 && !compound.getCreatedHmdb().isEmpty()) {
                        PreparedStatement hmdbStatement = connection.prepareStatement(
                                "UPDATE compounds_hmdb SET created = ?, last_updated = ? WHERE hmdb_id = ?");
                        hmdbStatement.setString(1, compound.getCreatedHmdb());
                        hmdbStatement.setString(2, compound.getLastUpdatedHmdb());
                        hmdbStatement.setInt(3, compound.getHmdbId());
                        int hmdbRowsUpdated = hmdbStatement.executeUpdate();
                        if (hmdbRowsUpdated == 0) {
                            return false;
                        }
                    }

                    if (rowsUpdated > 0 && !compound.getCreatedInHouse().isEmpty()) {
                        PreparedStatement inhouseStatement = connection.prepareStatement(
                                "UPDATE compounds_in_house SET source_data = ?, description = ?, created = ?, last_updated = ? WHERE in_house_id = ?");
                        inhouseStatement.setString(1, compound.getSourceData());
                        inhouseStatement.setString(2, compound.getDescription());
                        inhouseStatement.setString(3, compound.getCreatedInHouse());
                        inhouseStatement.setString(4, compound.getLastUpdatedInHouse());
                        inhouseStatement.setInt(5, compound.getInHouseID());
                        int inhouseRowsUpdated = inhouseStatement.executeUpdate();
                        if (inhouseRowsUpdated == 0) {
                            return false;
                        }
                    }

                    if (rowsUpdated > 0 && !compound.getCreatedKegg().isEmpty()) {
                        PreparedStatement keggStatement = connection.prepareStatement(
                                "UPDATE compounds_kegg SET created = ?, last_updated = ? WHERE kegg_id = ?");
                        keggStatement.setString(1, compound.getCreatedKegg());
                        keggStatement.setString(2, compound.getLastUpdatedKegg());
                        keggStatement.setInt(3, compound.getKeggId());
                        int keggRowsUpdated = keggStatement.executeUpdate();
                        if (keggRowsUpdated == 0) {
                            return false;
                        }
                    }

                    if (rowsUpdated > 0 && !compound.getCreatedLipid().isEmpty()) {
                        PreparedStatement lipidStatement = connection.prepareStatement(
                                "UPDATE compounds_lipids_classification SET num_chains = ?, number_carbons = ?, " +
                                        "double_bonds = ?, created = ?, last_updated = ? WHERE lipid_type = ?");
                        lipidStatement.setInt(1, compound.getNumChains());
                        lipidStatement.setInt(2, compound.getNumCarbons());
                        lipidStatement.setInt(3, compound.getDoubleBonds());
                        lipidStatement.setString(4, compound.getCreatedLipid());
                        lipidStatement.setString(5, compound.getLastUpdatedLipid());
                        lipidStatement.setString(6, compound.getLipidType());
                        int lipidRowsUpdated = lipidStatement.executeUpdate();
                        if (lipidRowsUpdated == 0) {
                            return false;
                        }
                    }

                    if (rowsUpdated > 0 && !compound.getCreatedLm().isEmpty()) {
                        PreparedStatement lmStatement = connection.prepareStatement(
                                "UPDATE compounds_lm SET created = ?, last_updated = ? WHERE lm_id = ?");
                        lmStatement.setString(1, compound.getCreatedLm());
                        lmStatement.setString(2, compound.getLastUpdatedLm());
                        lmStatement.setInt(3, compound.getLmId());
                        int lmRowsUpdated = lmStatement.executeUpdate();
                        if (lmRowsUpdated == 0) {
                            return false;
                        }
                    }

                    if (rowsUpdated > 0 && !compound.getCreatedLmClassification().isEmpty()) {
                        PreparedStatement lmclasStatement = connection.prepareStatement(
                                "UPDATE compounds_lm_classification SET main_class = ?, sub_class = ?, " +
                                        "class_level4 = ?, created = ?, last_updated = ? WHERE category = ?");
                        lmclasStatement.setString(1, compound.getMainClass());
                        lmclasStatement.setString(2, compound.getSubClass());
                        lmclasStatement.setString(3, compound.getClassLevel4());
                        lmclasStatement.setString(4, compound.getCreatedLmClassification());
                        lmclasStatement.setString(5, compound.getLastUpdatedLmClassification());
                        lmclasStatement.setString(6, compound.getCategory());
                        int lmclasRowsUpdated = lmclasStatement.executeUpdate();
                        if (lmclasRowsUpdated == 0) {
                            return false;
                        }
                    }

                    if (rowsUpdated > 0 && !compound.getCreatedPc().isEmpty()) {
                        PreparedStatement pcStatement = connection.prepareStatement(
                                "UPDATE compounds_pc SET created = ?, last_updated = ? WHERE pc_id = ?");
                        pcStatement.setString(1, compound.getCreatedPc());
                        pcStatement.setString(2, compound.getLastUpdatedPc());
                        pcStatement.setInt(3, compound.getPcId());
                        int pcRowsUpdated = pcStatement.executeUpdate();
                        if (pcRowsUpdated == 0) {
                            return false;
                        }
                    }

                    if (rowsUpdated > 0 && !compound.getCreatedReaction().isEmpty()) {
                        PreparedStatement reactionStatement = connection.prepareStatement(
                                "UPDATE compound_reactions_kegg SET created = ?, last_updated = ? WHERE reaction_id = ?");
                        reactionStatement.setString(1, compound.getCreatedReaction());
                        reactionStatement.setString(2, compound.getLastUpdatedReaction());
                        reactionStatement.setInt(3, compound.getReactionId());
                        int reactionRowsUpdated = reactionStatement.executeUpdate();
                        if (reactionRowsUpdated == 0) {
                            return false;
                        }
                    }

                    return rowsUpdated > 0;
                }), dec);
    }

    public CompletionStage<List<Compound>> getCompoundsInRange(int startId, int endId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT * FROM compounds WHERE compound_id BETWEEN ? AND ?");
                    statement.setInt(1, startId);
                    statement.setInt(2, endId);
                    ResultSet resultSet = statement.executeQuery();

                    List<Compound> compoundsInRange = new ArrayList<>();
                    while (resultSet.next()) {
                        Compound compound = new Compound();
                        compound.setCompoundId(resultSet.getInt("compound_id"));
                        compound.setCasId(resultSet.getString("cas_id"));
                        compound.setCompoundName(resultSet.getString("compound_name"));
                        compound.setFormula(resultSet.getString("formula"));
                        compound.setMass(resultSet.getDouble("mass"));
                        compound.setChargeType(resultSet.getInt("charge_type"));
                        compound.setChargeNumber(resultSet.getInt("charge_number"));
                        compound.setFormulaType(resultSet.getString("formula_type"));
                        compound.setCompoundType(resultSet.getInt("compound_type"));
                        compound.setCompoundStatus(resultSet.getInt("compound_status"));
                        compound.setCreated(resultSet.getString("created"));
                        compound.setLastUpdated(resultSet.getString("last_updated"));
                        compound.setFormulaTypeInt(resultSet.getInt("formula_type_int"));
                        compound.setLogP(resultSet.getDouble("logP"));
                        compoundsInRange.add(compound);
                    }
                    return compoundsInRange;
                }), dec);
    }
}