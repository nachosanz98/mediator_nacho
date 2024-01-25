package services;

import entities.Compound;
import play.db.Database;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
                    "SELECT c.*, " +
                        "ci.inchi, ci.inchi_key, ci.smiles, ci.created as createdIdentifier, ci.last_updated as lastUpdatedIdentifier, " +
                        "ca.agilent_id, ca.created as createdAgilent, ca.last_updated as lastUpdatedAgilent, " +
                        "ch.chebi_id, ch.created as createdChebi, ch.last_updated as lastUpdatedChebi, " +
                        "chm.hmdb_id, chm.created as createdHmdb, chm.last_updated as lastUpdatedHmdb, " +
                        "cih.in_house_id, cih.source_data, cih.description, cih.created as createdInHouse, cih.last_updated as lastUpdatedInHouse, " +
                        "ck.kegg_id, ck.created as createdKegg, ck.last_updated as lastUpdatedKegg, " +
                        "cl.lipid_type, cl.num_chains, cl.number_carbons, cl.double_bonds, cl.created as createdLipid, cl.last_updated as lastUpdatedLipid, " +
                        "clm.lm_id, clm.created as createdLm, clm.last_updated as lastUpdatedLm, " +
                        "clmc.category, clmc.main_class, clmc.sub_class, clmc.class_level4, clmc.created as createdLmClassification, " +
                            "clmc.last_updated as lastUpdatedLmClassification, " +
                        "cp.pc_id, cp.created as createdPc, cp.last_updated as lastUpdatedPc, " +
                        "crk.reaction_id, crk.created as createdReaction, crk.last_updated as lastUpdatedReaction " +
                        "FROM compounds c " +
                        "LEFT JOIN compound_identifiers ci ON c.compound_id = ci.compound_id " +
                        "LEFT JOIN compounds_agilent ca ON c.compound_id = ca.compound_id " +
                        "LEFT JOIN compounds_chebi ch ON c.compound_id = ch.compound_id " +
                        "LEFT JOIN compounds_hmdb chm ON c.compound_id = chm.compound_id " +
                        "LEFT JOIN compounds_in_house cih ON c.compound_id = cih.compound_id " +
                        "LEFT JOIN compounds_kegg ck ON c.compound_id = ck.compound_id " +
                        "LEFT JOIN compounds_lipids_classification cl ON c.compound_id = cl.compound_id " +
                        "LEFT JOIN compounds_lm clm ON c.compound_id = clm.compound_id " +
                        "LEFT JOIN compounds_lm_classification clmc ON c.compound_id = clmc.compound_id " +
                        "LEFT JOIN compounds_pc cp ON c.compound_id = cp.compound_id " +
                        "LEFT JOIN compounds_reactions_kegg crk ON c.compound_id = crk.compound_id " +
                        "WHERE c.compound_id = ?");
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

                        /*compound_identifiers*/
                        compound.setInchi(resultSet.getString("inchi"));
                        compound.setInchiKey(resultSet.getString("inchi_key"));
                        compound.setSmiles(resultSet.getString("smiles"));
                        compound.setCreatedIdentifier(resultSet.getString("createdIdentifier"));
                        compound.setLastUpdatedIdentifier(resultSet.getString("lastUpdatedIdentifier"));

                        /*compounds_agilent*/
                        compound.setAgilentId(resultSet.getInt("agilent_id"));
                        compound.setCreatedAgilent(resultSet.getString("createdAgilent"));
                        compound.setLastUpdatedAgilent(resultSet.getString("lastUpdatedAgilent"));

                        /*compounds_chebi*/
                        compound.setChebiId(resultSet.getInt("chebi_id"));
                        compound.setCreatedChebi(resultSet.getString("createdChebi"));
                        compound.setLastUpdatedChebi(resultSet.getString("lastUpdatedChebi"));

                        /*compounds_hmdb*/
                        compound.setHmdbId(resultSet.getString("hmdb_id"));
                        compound.setCreatedHmdb(resultSet.getString("createdHmdb"));
                        compound.setLastUpdatedHmdb(resultSet.getString("lastUpdatedHmdb"));

                        /*compounds_in_house*/
                        compound.setInHouseID(resultSet.getInt("in_house_id"));
                        compound.setSourceData(resultSet.getString("source_data"));
                        compound.setDescription(resultSet.getString("description"));
                        compound.setCreatedInHouse(resultSet.getString("createdInHouse"));
                        compound.setLastUpdatedInHouse(resultSet.getString("lastUpdatedInHouse"));

                        /*compounds_kegg*/
                        compound.setKeggId(resultSet.getString("kegg_id"));
                        compound.setCreatedKegg(resultSet.getString("createdKegg"));
                        compound.setLastUpdatedKegg(resultSet.getString("lastUpdatedKegg"));

                        /*compounds_lipids_classification*/
                        compound.setLipidType(resultSet.getString("lipid_type"));
                        compound.setNumChains(resultSet.getInt("num_chains"));
                        compound.setNumCarbons(resultSet.getInt("number_carbons"));
                        compound.setDoubleBonds(resultSet.getInt("double_bonds"));
                        compound.setCreatedLipid(resultSet.getString("createdLipid"));
                        compound.setLastUpdatedLipid(resultSet.getString("lastUpdatedLipid"));

                        /*compounds_lm*/
                        compound.setLmId(resultSet.getString("lm_id"));
                        compound.setCreatedLm(resultSet.getString("createdLm"));
                        compound.setLastUpdatedLm(resultSet.getString("lastUpdatedLm"));

                        /*compounds_lm_classification*/
                        compound.setCategory(resultSet.getString("category"));
                        compound.setMainClass(resultSet.getString("main_class"));
                        compound.setSubClass(resultSet.getString("sub_class"));
                        compound.setClassLevel4(resultSet.getString("class_level4"));
                        compound.setCreatedLmClassification(resultSet.getString("createdLmClassification"));
                        compound.setLastUpdatedLmClassification(resultSet.getString("lastUpdatedLmClassification"));

                        /*compounds_pc*/
                        compound.setPcId(resultSet.getInt("pc_id"));
                        compound.setCreatedPc(resultSet.getString("createdPc"));
                        compound.setLastUpdatedPc(resultSet.getString("lastUpdatedPc"));

                        /*compounds_reactions_kegg*/
                        compound.setReactionId(resultSet.getString("reaction_id"));
                        compound.setCreatedReaction(resultSet.getString("createdReaction"));
                        compound.setLastUpdatedReaction(resultSet.getString("lastUpdatedReaction"));
                        return compound;
                    }
                    return null;
                }), dec);
    }

    public CompletionStage<Boolean> addCompound(Compound compound) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    int generatedCompoundId = -1;
                    PreparedStatement statement = connection.prepareStatement(
                            "INSERT INTO compounds (cas_id, compound_name, formula, mass, charge_type, " +
                                    "charge_number, formula_type, compound_type, compound_status, created, last_updated, " +
                                    "formula_type_int, logP) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                                        Statement.RETURN_GENERATED_KEYS);

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

                    ResultSet rs = statement.getGeneratedKeys();
                    if (rs.next()) {
                        generatedCompoundId = rs.getInt(1);
                    }

                    /* compound_identifiers */
                    if (rowsInserted > 0 && !compound.getCreatedIdentifier().isEmpty() && compound.getCreatedIdentifier() != null) {
                        PreparedStatement identStatement = connection.prepareStatement(
                                "INSERT INTO compound_identifiers (compound_id, inchi, inchi_key, smiles, created, last_updated) " +
                                        "VALUES (?, ?, ?, ?, ?, ?)");
                        identStatement.setInt(1, generatedCompoundId);
                        identStatement.setString(2, compound.getInchi());
                        identStatement.setString(3, compound.getInchiKey());
                        identStatement.setString(4, compound.getSmiles());
                        identStatement.setString(5, compound.getCreatedIdentifier());
                        identStatement.setString(6, compound.getLastUpdatedIdentifier());
                        int identRowsInserted = identStatement.executeUpdate();
                        if (identRowsInserted == 0) {
                            return false;
                        }
                    }

                    /* compounds_agilent */
                    if (rowsInserted > 0 && !compound.getCreatedAgilent().isEmpty() && compound.getCreatedAgilent() != null) {
                        PreparedStatement agilentStatement = connection.prepareStatement(
                                "INSERT INTO compounds_agilent (compound_id, agilent_id, created, last_updated) " +
                                        "VALUES (?, ?, ?, ?)");
                        agilentStatement.setInt(1, generatedCompoundId);
                        agilentStatement.setInt(2, compound.getAgilentId());
                        agilentStatement.setString(3, compound.getCreatedAgilent());
                        agilentStatement.setString(4, compound.getLastUpdatedAgilent());
                        int agilentRowsInserted = agilentStatement.executeUpdate();
                        if (agilentRowsInserted == 0) {
                            return false;
                        }
                    }

                    /* compounds_chebi */
                    if (rowsInserted > 0 && !compound.getCreatedChebi().isEmpty() && compound.getCreatedChebi() != null) {
                        PreparedStatement chebiStatement = connection.prepareStatement(
                                "INSERT INTO compounds_chebi (compound_id, chebi_id, created, last_updated) " +
                                        "VALUES (?, ?, ?, ?)");
                        chebiStatement.setInt(1, generatedCompoundId);
                        chebiStatement.setInt(2, compound.getChebiId());
                        chebiStatement.setString(3, compound.getCreatedChebi());
                        chebiStatement.setString(4, compound.getLastUpdatedChebi());
                        int chebiRowsInserted = chebiStatement.executeUpdate();
                        if (chebiRowsInserted == 0) {
                            return false;
                        }
                    }

                    /* compounds_hmdb */
                    if (rowsInserted > 0 && !compound.getCreatedHmdb().isEmpty() && compound.getCreatedHmdb() != null) {
                        PreparedStatement hmdbStatement = connection.prepareStatement(
                                "INSERT INTO compounds_hmdb (compound_id, hmdb_id, created, last_updated) " +
                                        "VALUES (?, ?, ?, ?)");
                        hmdbStatement.setInt(1, generatedCompoundId);
                        hmdbStatement.setString(2, compound.getHmdbId());
                        hmdbStatement.setString(3, compound.getCreatedHmdb());
                        hmdbStatement.setString(4, compound.getLastUpdatedHmdb());
                        int hmdbRowsInserted = hmdbStatement.executeUpdate();
                        if (hmdbRowsInserted == 0) {
                            return false;
                        }
                    }

                    /* compounds_in_house */
                    if (rowsInserted > 0 && !compound.getCreatedInHouse().isEmpty() && compound.getCreatedInHouse() != null) {
                        PreparedStatement inhouseStatement = connection.prepareStatement(
                                "INSERT INTO compounds_in_house (compound_id, in_house_id, source_data, description," +
                                        " created, last_updated) VALUES (?, ?, ?, ?, ?, ?)");
                        inhouseStatement.setInt(1, generatedCompoundId);
                        inhouseStatement.setInt(2, compound.getInHouseID());
                        inhouseStatement.setString(3, compound.getSourceData());
                        inhouseStatement.setString(4, compound.getDescription());
                        inhouseStatement.setString(5, compound.getCreatedInHouse());
                        inhouseStatement.setString(6, compound.getLastUpdatedInHouse());
                        int inhouseRowsInserted = inhouseStatement.executeUpdate();
                        if (inhouseRowsInserted == 0) {
                            return false;
                        }
                    }

                    /* compounds_kegg */
                    if (rowsInserted > 0 && !compound.getCreatedKegg().isEmpty() && compound.getCreatedKegg() != null) {
                        PreparedStatement keggStatement = connection.prepareStatement(
                                "INSERT INTO compounds_kegg (compound_id, kegg_id, created, last_updated) " +
                                        "VALUES (?, ?, ?, ?)");
                        keggStatement.setInt(1, generatedCompoundId);
                        keggStatement.setString(2, compound.getKeggId());
                        keggStatement.setString(3, compound.getCreatedKegg());
                        keggStatement.setString(4, compound.getLastUpdatedKegg());
                        int keggRowsInserted = keggStatement.executeUpdate();
                        if (keggRowsInserted == 0) {
                            return false;
                        }
                    }

                    /* compound_lipids_classification */
                    if (rowsInserted > 0 && !compound.getCreatedLipid().isEmpty() && compound.getCreatedLipid() != null) {
                        PreparedStatement lipidStatement = connection.prepareStatement(
                                "INSERT INTO compounds_lipids_classification (compound_id, lipid_type, num_chains, " +
                                        "number_carbons, double_bonds, created, last_updated) VALUES (?, ?, ?, ?, ?, ?, ?)");
                        lipidStatement.setInt(1, generatedCompoundId);
                        lipidStatement.setString(2, compound.getLipidType());
                        lipidStatement.setInt(3, compound.getNumChains());
                        lipidStatement.setInt(4, compound.getNumCarbons());
                        lipidStatement.setInt(5, compound.getDoubleBonds());
                        lipidStatement.setString(6, compound.getCreatedLipid());
                        lipidStatement.setString(7, compound.getLastUpdatedLipid());
                        int lipidRowsInserted = lipidStatement.executeUpdate();
                        if (lipidRowsInserted == 0) {
                            return false;
                        }
                    }

                    /* compound_lm */
                    if (rowsInserted > 0 && !compound.getCreatedLm().isEmpty() && compound.getCreatedLm() != null) {
                        PreparedStatement lmStatement = connection.prepareStatement(
                                "INSERT INTO compounds_lm (compound_id, lm_id, created, last_updated) " +
                                        "VALUES (?, ?, ?, ?)");
                        lmStatement.setInt(1, generatedCompoundId);
                        lmStatement.setString(2, compound.getLmId());
                        lmStatement.setString(3, compound.getCreatedLm());
                        lmStatement.setString(4, compound.getLastUpdatedLm());
                        int lmRowsInserted = lmStatement.executeUpdate();
                        if (lmRowsInserted == 0) {
                            return false;
                        }
                    }

                    /* compound_lm_classification */
                    if (rowsInserted > 0 && !compound.getCreatedLmClassification().isEmpty() && compound.getCreatedLmClassification() != null) {
                        PreparedStatement lmclasStatement = connection.prepareStatement(
                                "INSERT INTO compounds_lm_classification (compound_id, category, main_class, " +
                                        "sub_class, class_level4, created, last_updated) VALUES (?, ?, ?, ?, ?, ?, ?)");
                        lmclasStatement.setInt(1, generatedCompoundId);
                        lmclasStatement.setString(2, compound.getCategory());
                        lmclasStatement.setString(3, compound.getMainClass());
                        lmclasStatement.setString(4, compound.getSubClass());
                        lmclasStatement.setString(5, compound.getClassLevel4());
                        lmclasStatement.setString(6, compound.getCreatedLmClassification());
                        lmclasStatement.setString(7, compound.getLastUpdatedLmClassification());
                        int lmclasRowsInserted = lmclasStatement.executeUpdate();
                        if (lmclasRowsInserted == 0) {
                            return false;
                        }
                    }

                    /* compound_pc */
                    if (rowsInserted > 0 && !compound.getCreatedPc().isEmpty() && compound.getCreatedPc() != null) {
                        PreparedStatement pcStatement = connection.prepareStatement(
                                "INSERT INTO compounds_pc (compound_id, pc_id, created, last_updated) " +
                                        "VALUES (?, ?, ?, ?)");
                        pcStatement.setInt(1, generatedCompoundId);
                        pcStatement.setInt(2, compound.getPcId());
                        pcStatement.setString(3, compound.getCreatedPc());
                        pcStatement.setString(4, compound.getLastUpdatedPc());
                        int pcRowsInserted = pcStatement.executeUpdate();
                        if (pcRowsInserted == 0) {
                            return false;
                        }
                    }

                    /* compounds_reactions_kegg */
                    if (rowsInserted > 0 && !compound.getCreatedReaction().isEmpty() && compound.getCreatedReaction() != null) {
                        PreparedStatement reactionStatement = connection.prepareStatement(
                                "INSERT INTO compounds_reactions_kegg (compound_id, reaction_id, created, last_updated) " +
                                        "VALUES (?, ?, ?, ?)");
                        reactionStatement.setInt(1, generatedCompoundId);
                        reactionStatement.setString(2, compound.getReactionId());
                        reactionStatement.setString(3, compound.getCreatedReaction());
                        reactionStatement.setString(4, compound.getLastUpdatedReaction());
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
                        PreparedStatement identStatement = connection.prepareStatement(
                                "DELETE FROM compound_identifiers WHERE compound_id = ?");
                        identStatement.setInt(1, compoundId);
                        identStatement.executeUpdate();

                        PreparedStatement agilentStatement = connection.prepareStatement(
                                "DELETE FROM compounds_agilent WHERE compound_id = ?");
                        agilentStatement.setInt(1, compoundId);
                        agilentStatement.executeUpdate();

                        PreparedStatement chebiStatement = connection.prepareStatement(
                                "DELETE FROM compounds_chebi WHERE compound_id = ?");
                        chebiStatement.setInt(1, compoundId);
                        chebiStatement.executeUpdate();

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
                                "DELETE FROM compounds_reactions_kegg WHERE compound_id = ?");
                        reactionStatement.setInt(1, compoundId);
                        reactionStatement.executeUpdate();
                    }
                    return rowsDeleted > 0;
                }), dec);
    }

    public CompletionStage<List<Compound>> getAllCompounds() {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                        "SELECT c.*, " +
                        "ci.inchi, ci.inchi_key, ci.smiles, ci.created as createdIdentifier, ci.last_updated as lastUpdatedIdentifier, " +
                        "ca.agilent_id, ca.created as createdAgilent, ca.last_updated as lastUpdatedAgilent, " +
                        "ch.chebi_id, ch.created as createdChebi, ch.last_updated as lastUpdatedChebi, " +
                        "chm.hmdb_id, chm.created as createdHmdb, chm.last_updated as lastUpdatedHmdb, " +
                        "cih.in_house_id, cih.source_data, cih.description, cih.created as createdInHouse, cih.last_updated as lastUpdatedInHouse, " +
                        "ck.kegg_id, ck.created as createdKegg, ck.last_updated as lastUpdatedKegg, " +
                        "cl.lipid_type, cl.num_chains, cl.number_carbons, cl.double_bonds, cl.created as createdLipid, cl.last_updated as lastUpdatedLipid, " +
                        "clm.lm_id, clm.created as createdLm, clm.last_updated as lastUpdatedLm, " +
                        "clmc.category, clmc.main_class, clmc.sub_class, clmc.class_level4, clmc.created as createdLmClassification, " +
                        "clmc.last_updated as lastUpdatedLmClassification, " +
                        "cp.pc_id, cp.created as createdPc, cp.last_updated as lastUpdatedPc, " +
                        "crk.reaction_id, crk.created as createdReaction, crk.last_updated as lastUpdatedReaction " +
                        "FROM compounds c " +
                        "LEFT JOIN compound_identifiers ci ON c.compound_id = ci.compound_id " +
                        "LEFT JOIN compounds_agilent ca ON c.compound_id = ca.compound_id " +
                        "LEFT JOIN compounds_chebi ch ON c.compound_id = ch.compound_id " +
                        "LEFT JOIN compounds_hmdb chm ON c.compound_id = chm.compound_id " +
                        "LEFT JOIN compounds_in_house cih ON c.compound_id = cih.compound_id " +
                        "LEFT JOIN compounds_kegg ck ON c.compound_id = ck.compound_id " +
                        "LEFT JOIN compounds_lipids_classification cl ON c.compound_id = cl.compound_id " +
                        "LEFT JOIN compounds_lm clm ON c.compound_id = clm.compound_id " +
                        "LEFT JOIN compounds_lm_classification clmc ON c.compound_id = clmc.compound_id " +
                        "LEFT JOIN compounds_pc cp ON c.compound_id = cp.compound_id " +
                        "LEFT JOIN compounds_reactions_kegg crk ON c.compound_id = crk.compound_id");
                    ResultSet resultSet = statement.executeQuery();

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

                        /*compound_identifiers*/
                        compound.setInchi(resultSet.getString("inchi"));
                        compound.setInchiKey(resultSet.getString("inchi_key"));
                        compound.setSmiles(resultSet.getString("smiles"));
                        compound.setCreatedIdentifier(resultSet.getString("createdIdentifier"));
                        compound.setLastUpdatedIdentifier(resultSet.getString("lastUpdatedIdentifier"));

                        /*compounds_agilent*/
                        compound.setAgilentId(resultSet.getInt("agilent_id"));
                        compound.setCreatedAgilent(resultSet.getString("createdAgilent"));
                        compound.setLastUpdatedAgilent(resultSet.getString("lastUpdatedAgilent"));

                        /*compounds_chebi*/
                        compound.setChebiId(resultSet.getInt("chebi_id"));
                        compound.setCreatedChebi(resultSet.getString("createdChebi"));
                        compound.setLastUpdatedChebi(resultSet.getString("lastUpdatedChebi"));

                        /*compounds_hmdb*/
                        compound.setHmdbId(resultSet.getString("hmdb_id"));
                        compound.setCreatedHmdb(resultSet.getString("createdHmdb"));
                        compound.setLastUpdatedHmdb(resultSet.getString("lastUpdatedHmdb"));

                        /*compounds_in_house*/
                        compound.setInHouseID(resultSet.getInt("in_house_id"));
                        compound.setSourceData(resultSet.getString("source_data"));
                        compound.setDescription(resultSet.getString("description"));
                        compound.setCreatedInHouse(resultSet.getString("createdInHouse"));
                        compound.setLastUpdatedInHouse(resultSet.getString("lastUpdatedInHouse"));

                        /*compounds_kegg*/
                        compound.setKeggId(resultSet.getString("kegg_id"));
                        compound.setCreatedKegg(resultSet.getString("createdKegg"));
                        compound.setLastUpdatedKegg(resultSet.getString("lastUpdatedKegg"));

                        /*compounds_lipids_classification*/
                        compound.setLipidType(resultSet.getString("lipid_type"));
                        compound.setNumChains(resultSet.getInt("num_chains"));
                        compound.setNumCarbons(resultSet.getInt("number_carbons"));
                        compound.setDoubleBonds(resultSet.getInt("double_bonds"));
                        compound.setCreatedLipid(resultSet.getString("createdLipid"));
                        compound.setLastUpdatedLipid(resultSet.getString("lastUpdatedLipid"));

                        /*compounds_lm*/
                        compound.setLmId(resultSet.getString("lm_id"));
                        compound.setCreatedLm(resultSet.getString("createdLm"));
                        compound.setLastUpdatedLm(resultSet.getString("lastUpdatedLm"));

                        /*compounds_lm_classification*/
                        compound.setCategory(resultSet.getString("category"));
                        compound.setMainClass(resultSet.getString("main_class"));
                        compound.setSubClass(resultSet.getString("sub_class"));
                        compound.setClassLevel4(resultSet.getString("class_level4"));
                        compound.setCreatedLmClassification(resultSet.getString("createdLmClassification"));
                        compound.setLastUpdatedLmClassification(resultSet.getString("lastUpdatedLmClassification"));

                        /*compounds_pc*/
                        compound.setPcId(resultSet.getInt("pc_id"));
                        compound.setCreatedPc(resultSet.getString("createdPc"));
                        compound.setLastUpdatedPc(resultSet.getString("lastUpdatedPc"));

                        /*compounds_reactions_kegg*/
                        compound.setReactionId(resultSet.getString("reaction_id"));
                        compound.setCreatedReaction(resultSet.getString("createdReaction"));
                        compound.setLastUpdatedReaction(resultSet.getString("lastUpdatedReaction"));

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

                    if (compound.getLastUpdatedIdentifier() != null && !compound.getLastUpdatedIdentifier().isEmpty()) {
                        PreparedStatement identStatement = connection.prepareStatement(
                                "UPDATE compound_identifiers SET inchi = ?, inchi_key = ?, smiles = ?, created = ?, last_updated = ? " +
                                        "WHERE compound_id = ?");
                        identStatement.setString(1, compound.getInchi());
                        identStatement.setString(2, compound.getInchiKey());
                        identStatement.setString(3, compound.getSmiles());
                        identStatement.setString(4, compound.getCreatedIdentifier());
                        identStatement.setString(5, compound.getLastUpdatedIdentifier());
                        identStatement.setInt(6, id);
                        int identRowsInserted = identStatement.executeUpdate();
                        if (identRowsInserted == 0) {
                            return false;
                        }
                    }

                    if (compound.getLastUpdatedAgilent() != null && !compound.getLastUpdatedAgilent().isEmpty()) {
                        PreparedStatement agilentStatement = connection.prepareStatement(
                                "UPDATE compounds_agilent SET agilent_id = ?, created = ?, last_updated = ? WHERE compound_id = ?");
                        agilentStatement.setInt(1, compound.getAgilentId());
                        agilentStatement.setString(2, compound.getCreatedAgilent());
                        agilentStatement.setString(3, compound.getLastUpdatedAgilent());
                        agilentStatement.setInt(4, id);
                        int agilentRowsUpdated = agilentStatement.executeUpdate();
                        if (agilentRowsUpdated == 0) {
                            return false;
                        }
                    }

                    if (compound.getLastUpdatedChebi() != null && !compound.getLastUpdatedChebi().isEmpty()) {
                        PreparedStatement chebiStatement = connection.prepareStatement(
                                "UPDATE compounds_chebi SET chebi_id = ?, created = ?, last_updated = ? WHERE compound_id = ?");
                        chebiStatement.setInt(1, compound.getChebiId());
                        chebiStatement.setString(2, compound.getCreatedChebi());
                        chebiStatement.setString(3, compound.getLastUpdatedChebi());
                        chebiStatement.setInt(4, id);
                        int chebiRowsUpdated = chebiStatement.executeUpdate();
                        if (chebiRowsUpdated == 0) {
                            return false;
                        }
                    }

                    if (compound.getLastUpdatedHmdb() != null && !compound.getLastUpdatedHmdb().isEmpty()) {
                        PreparedStatement hmdbStatement = connection.prepareStatement(
                                "UPDATE compounds_hmdb SET hmdb_id = ?, created = ?, last_updated = ? WHERE compound_id = ?");
                        hmdbStatement.setString(1, compound.getHmdbId());
                        hmdbStatement.setString(2, compound.getCreatedHmdb());
                        hmdbStatement.setString(3, compound.getLastUpdatedHmdb());
                        hmdbStatement.setInt(4, id);
                        int hmdbRowsUpdated = hmdbStatement.executeUpdate();
                        if (hmdbRowsUpdated == 0) {
                            return false;
                        }
                    }

                    if (compound.getLastUpdatedInHouse() != null && !compound.getLastUpdatedInHouse().isEmpty()) {
                        PreparedStatement inhouseStatement = connection.prepareStatement(
                                "UPDATE compounds_in_house SET in_house_id = ?, source_data = ?, description = ?, created = ?, last_updated = ? WHERE compound_id = ?");
                        inhouseStatement.setInt(1, compound.getInHouseID());
                        inhouseStatement.setString(2, compound.getSourceData());
                        inhouseStatement.setString(3, compound.getDescription());
                        inhouseStatement.setString(4, compound.getCreatedInHouse());
                        inhouseStatement.setString(5, compound.getLastUpdatedInHouse());
                        inhouseStatement.setInt(6, id);
                        int inhouseRowsUpdated = inhouseStatement.executeUpdate();
                        if (inhouseRowsUpdated == 0) {
                            return false;
                        }
                    }

                    if (compound.getLastUpdatedKegg() != null && !compound.getLastUpdatedKegg().isEmpty()) {
                        PreparedStatement keggStatement = connection.prepareStatement(
                                "UPDATE compounds_kegg SET kegg_id = ?, created = ?, last_updated = ? WHERE compound_id = ?");
                        keggStatement.setString(1, compound.getKeggId());
                        keggStatement.setString(2, compound.getCreatedKegg());
                        keggStatement.setString(3, compound.getLastUpdatedKegg());
                        keggStatement.setInt(4, id);
                        int keggRowsUpdated = keggStatement.executeUpdate();
                        if (keggRowsUpdated == 0) {
                            return false;
                        }
                    }

                    if (compound.getLastUpdatedLipid() != null && !compound.getLastUpdatedLipid().isEmpty()) {
                        PreparedStatement lipidStatement = connection.prepareStatement(
                                "UPDATE compounds_lipids_classification SET lipid_type = ?, num_chains = ?, number_carbons = ?, " +
                                        "double_bonds = ?, created = ?, last_updated = ? WHERE compound_id = ?");
                        lipidStatement.setString(1, compound.getLipidType());
                        lipidStatement.setInt(2, compound.getNumChains());
                        lipidStatement.setInt(3, compound.getNumCarbons());
                        lipidStatement.setInt(4, compound.getDoubleBonds());
                        lipidStatement.setString(5, compound.getCreatedLipid());
                        lipidStatement.setString(6, compound.getLastUpdatedLipid());
                        lipidStatement.setInt(7, id);
                        int lipidRowsUpdated = lipidStatement.executeUpdate();
                        if (lipidRowsUpdated == 0) {
                            return false;
                        }
                    }

                    if (compound.getLastUpdatedLm() != null && !compound.getLastUpdatedLm().isEmpty()) {
                        PreparedStatement lmStatement = connection.prepareStatement(
                                "UPDATE compounds_lm SET lm_id = ?, created = ?, last_updated = ? WHERE compound_id = ?");
                        lmStatement.setString(1, compound.getLmId());
                        lmStatement.setString(2, compound.getCreatedLm());
                        lmStatement.setString(3, compound.getLastUpdatedLm());
                        lmStatement.setInt(4, id);
                        int lmRowsUpdated = lmStatement.executeUpdate();
                        if (lmRowsUpdated == 0) {
                            return false;
                        }
                    }

                    if (compound.getLastUpdatedLmClassification() != null && !compound.getLastUpdatedLmClassification().isEmpty()) {
                        PreparedStatement lmclasStatement = connection.prepareStatement(
                                "UPDATE compounds_lm_classification SET category = ?, main_class = ?, sub_class = ?, " +
                                        "class_level4 = ?, created = ?, last_updated = ? WHERE compound_id = ?");
                        lmclasStatement.setString(1, compound.getCategory());
                        lmclasStatement.setString(2, compound.getMainClass());
                        lmclasStatement.setString(3, compound.getSubClass());
                        lmclasStatement.setString(4, compound.getClassLevel4());
                        lmclasStatement.setString(5, compound.getCreatedLmClassification());
                        lmclasStatement.setString(6, compound.getLastUpdatedLmClassification());
                        lmclasStatement.setInt(7, id);
                        int lmclasRowsUpdated = lmclasStatement.executeUpdate();
                        if (lmclasRowsUpdated == 0) {
                            return false;
                        }
                    }

                    if (compound.getLastUpdatedPc() != null && !compound.getLastUpdatedPc().isEmpty()) {
                        PreparedStatement pcStatement = connection.prepareStatement(
                                "UPDATE compounds_pc SET pc_id = ?, created = ?, last_updated = ? WHERE compound_id = ?");
                        pcStatement.setInt(1, compound.getPcId());
                        pcStatement.setString(2, compound.getCreatedPc());
                        pcStatement.setString(3, compound.getLastUpdatedPc());
                        pcStatement.setInt(4, id);
                        int pcRowsUpdated = pcStatement.executeUpdate();
                        if (pcRowsUpdated == 0) {
                            return false;
                        }
                    }

                    if (compound.getLastUpdatedReaction() != null && !compound.getLastUpdatedReaction().isEmpty()) {
                        PreparedStatement reactionStatement = connection.prepareStatement(
                                "UPDATE compounds_reactions_kegg SET created = ?, last_updated = ? WHERE compound_id = ? and reaction_id = ?");
                        reactionStatement.setString(1, compound.getCreatedReaction());
                        reactionStatement.setString(2, compound.getLastUpdatedReaction());
                        reactionStatement.setInt(3, id);
                        reactionStatement.setString(4, compound.getReactionId());
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
                            "SELECT c.*, " +
                            "ci.inchi, ci.inchi_key, ci.smiles, ci.created as createdIdentifier, ci.last_updated as lastUpdatedIdentifier, " +
                            "ca.agilent_id, ca.created as createdAgilent, ca.last_updated as lastUpdatedAgilent, " +
                            "ch.chebi_id, ch.created as createdChebi, ch.last_updated as lastUpdatedChebi, " +
                            "chm.hmdb_id, chm.created as createdHmdb, chm.last_updated as lastUpdatedHmdb, " +
                            "cih.in_house_id, cih.source_data, cih.description, cih.created as createdInHouse, cih.last_updated as lastUpdatedInHouse, " +
                            "ck.kegg_id, ck.created as createdKegg, ck.last_updated as lastUpdatedKegg, " +
                            "cl.lipid_type, cl.num_chains, cl.number_carbons, cl.double_bonds, cl.created as createdLipid, cl.last_updated as lastUpdatedLipid, " +
                            "clm.lm_id, clm.created as createdLm, clm.last_updated as lastUpdatedLm, " +
                            "clmc.category, clmc.main_class, clmc.sub_class, clmc.class_level4, clmc.created as createdLmClassification, " +
                            "clmc.last_updated as lastUpdatedLmClassification, " +
                            "cp.pc_id, cp.created as createdPc, cp.last_updated as lastUpdatedPc, " +
                            "crk.reaction_id, crk.created as createdReaction, crk.last_updated as lastUpdatedReaction " +
                            "FROM compounds c " +
                            "LEFT JOIN compound_identifiers ci ON c.compound_id = ci.compound_id " +
                            "LEFT JOIN compounds_agilent ca ON c.compound_id = ca.compound_id " +
                            "LEFT JOIN compounds_chebi ch ON c.compound_id = ch.compound_id " +
                            "LEFT JOIN compounds_hmdb chm ON c.compound_id = chm.compound_id " +
                            "LEFT JOIN compounds_in_house cih ON c.compound_id = cih.compound_id " +
                            "LEFT JOIN compounds_kegg ck ON c.compound_id = ck.compound_id " +
                            "LEFT JOIN compounds_lipids_classification cl ON c.compound_id = cl.compound_id " +
                            "LEFT JOIN compounds_lm clm ON c.compound_id = clm.compound_id " +
                            "LEFT JOIN compounds_lm_classification clmc ON c.compound_id = clmc.compound_id " +
                            "LEFT JOIN compounds_pc cp ON c.compound_id = cp.compound_id " +
                            "LEFT JOIN compounds_reactions_kegg crk ON c.compound_id = crk.compound_id " +
                                    "WHERE c.compound_id BETWEEN ? AND ?");
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

                        /*compound_identifiers*/
                        compound.setInchi(resultSet.getString("inchi"));
                        compound.setInchiKey(resultSet.getString("inchi_key"));
                        compound.setSmiles(resultSet.getString("smiles"));
                        compound.setCreatedIdentifier(resultSet.getString("createdIdentifier"));
                        compound.setLastUpdatedIdentifier(resultSet.getString("lastUpdatedIdentifier"));

                        /*compounds_agilent*/
                        compound.setAgilentId(resultSet.getInt("agilent_id"));
                        compound.setCreatedAgilent(resultSet.getString("createdAgilent"));
                        compound.setLastUpdatedAgilent(resultSet.getString("lastUpdatedAgilent"));

                        /*compounds_chebi*/
                        compound.setChebiId(resultSet.getInt("chebi_id"));
                        compound.setCreatedChebi(resultSet.getString("createdChebi"));
                        compound.setLastUpdatedChebi(resultSet.getString("lastUpdatedChebi"));

                        /*compounds_hmdb*/
                        compound.setHmdbId(resultSet.getString("hmdb_id"));
                        compound.setCreatedHmdb(resultSet.getString("createdHmdb"));
                        compound.setLastUpdatedHmdb(resultSet.getString("lastUpdatedHmdb"));

                        /*compounds_in_house*/
                        compound.setInHouseID(resultSet.getInt("in_house_id"));
                        compound.setSourceData(resultSet.getString("source_data"));
                        compound.setDescription(resultSet.getString("description"));
                        compound.setCreatedInHouse(resultSet.getString("createdInHouse"));
                        compound.setLastUpdatedInHouse(resultSet.getString("lastUpdatedInHouse"));

                        /*compounds_kegg*/
                        compound.setKeggId(resultSet.getString("kegg_id"));
                        compound.setCreatedKegg(resultSet.getString("createdKegg"));
                        compound.setLastUpdatedKegg(resultSet.getString("lastUpdatedKegg"));

                        /*compounds_lipids_classification*/
                        compound.setLipidType(resultSet.getString("lipid_type"));
                        compound.setNumChains(resultSet.getInt("num_chains"));
                        compound.setNumCarbons(resultSet.getInt("number_carbons"));
                        compound.setDoubleBonds(resultSet.getInt("double_bonds"));
                        compound.setCreatedLipid(resultSet.getString("createdLipid"));
                        compound.setLastUpdatedLipid(resultSet.getString("lastUpdatedLipid"));

                        /*compounds_lm*/
                        compound.setLmId(resultSet.getString("lm_id"));
                        compound.setCreatedLm(resultSet.getString("createdLm"));
                        compound.setLastUpdatedLm(resultSet.getString("lastUpdatedLm"));

                        /*compounds_lm_classification*/
                        compound.setCategory(resultSet.getString("category"));
                        compound.setMainClass(resultSet.getString("main_class"));
                        compound.setSubClass(resultSet.getString("sub_class"));
                        compound.setClassLevel4(resultSet.getString("class_level4"));
                        compound.setCreatedLmClassification(resultSet.getString("createdLmClassification"));
                        compound.setLastUpdatedLmClassification(resultSet.getString("lastUpdatedLmClassification"));

                        /*compounds_pc*/
                        compound.setPcId(resultSet.getInt("pc_id"));
                        compound.setCreatedPc(resultSet.getString("createdPc"));
                        compound.setLastUpdatedPc(resultSet.getString("lastUpdatedPc"));

                        /*compounds_reactions_kegg*/
                        compound.setReactionId(resultSet.getString("reaction_id"));
                        compound.setCreatedReaction(resultSet.getString("createdReaction"));
                        compound.setLastUpdatedReaction(resultSet.getString("lastUpdatedReaction"));

                        compoundsInRange.add(compound);
                    }
                    return compoundsInRange;
                }), dec);
    }
}