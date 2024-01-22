package services;

import entities.OntologyTerms;
import play.db.Database;

import javax.inject.Inject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class OntologyTermsService {
    private final Database db;
    private final DatabaseExecutionContext dec;

    @Inject
    public OntologyTermsService(Database db, DatabaseExecutionContext dec) {
        this.db = db;
        this.dec = dec;
    }

    public CompletionStage<OntologyTerms> getOntologyTerms(int ontologyTermId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT * FROM ontology_terms WHERE ontology_term_id = ?");
                    statement.setInt(1, ontologyTermId);
                    ResultSet resultSet = statement.executeQuery();

                    if (resultSet.next()) {
                        OntologyTerms ontologyTerm = new OntologyTerms();
                        ontologyTerm.setOntologyTermId(resultSet.getInt("ontology_term_id"));
                        ontologyTerm.setTerm(resultSet.getString("term"));
                        ontologyTerm.setDefinition(resultSet.getString("definition"));
                        ontologyTerm.setExternalId(resultSet.getString("external_id"));
                        ontologyTerm.setExternalSource(resultSet.getString("external_source"));
                        ontologyTerm.setOntologyComment(resultSet.getString("ontology_comment"));
                        ontologyTerm.setCurator(resultSet.getString("curator"));
                        ontologyTerm.setParentId(resultSet.getInt("parent_id"));
                        ontologyTerm.setOntologyLevel(resultSet.getInt("ontology_level"));
                        ontologyTerm.setCreated(resultSet.getString("created"));
                        ontologyTerm.setLastUpdated(resultSet.getString("last_updated"));
                        return ontologyTerm;
                    }
                    return null;
                }), dec);
    }

    public CompletionStage<Boolean> addOntologyTerms(OntologyTerms ontologyTerm) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "INSERT INTO ontology_terms (term, definition, external_id, external_source, " +
                                    "ontology_comment, curator, parent_id, ontology_level, created, last_updated) " +
                                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

                    statement.setString(1, ontologyTerm.getTerm());
                    statement.setString(2, ontologyTerm.getDefinition());
                    statement.setString(3, ontologyTerm.getExternalId());
                    statement.setString(4, ontologyTerm.getExternalSource());
                    statement.setString(5, ontologyTerm.getOntologyComment());
                    statement.setString(6, ontologyTerm.getCurator());
                    statement.setInt(7, ontologyTerm.getParentId());
                    statement.setInt(8, ontologyTerm.getOntologyLevel());
                    statement.setString(9, ontologyTerm.getCreated());
                    statement.setString(10, ontologyTerm.getLastUpdated());

                    int rowsInserted = statement.executeUpdate();
                    return rowsInserted > 0;
                }), dec);
    }

    public CompletionStage<Boolean> deleteOntologyTerms(int ontologyTermId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "DELETE FROM ontology_terms WHERE ontology_term_id = ?");
                    statement.setInt(1, ontologyTermId);
                    int rowsDeleted = statement.executeUpdate();
                    return rowsDeleted > 0;
                }), dec);
    }

    public CompletionStage<List<OntologyTerms>> getAllOntologyTerms() {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM ontology_terms");
                    List<OntologyTerms> ontologyTermsList = new ArrayList<>();
                    while (resultSet.next()) {
                        OntologyTerms ontologyTerm = new OntologyTerms();
                        ontologyTerm.setOntologyTermId(resultSet.getInt("ontology_term_id"));
                        ontologyTerm.setTerm(resultSet.getString("term"));
                        ontologyTerm.setDefinition(resultSet.getString("definition"));
                        ontologyTerm.setExternalId(resultSet.getString("external_id"));
                        ontologyTerm.setExternalSource(resultSet.getString("external_source"));
                        ontologyTerm.setOntologyComment(resultSet.getString("ontology_comment"));
                        ontologyTerm.setCurator(resultSet.getString("curator"));
                        ontologyTerm.setParentId(resultSet.getInt("parent_id"));
                        ontologyTerm.setOntologyLevel(resultSet.getInt("ontology_level"));
                        ontologyTerm.setCreated(resultSet.getString("created"));
                        ontologyTerm.setLastUpdated(resultSet.getString("last_updated"));
                        ontologyTermsList.add(ontologyTerm);
                    }
                    return ontologyTermsList;
                }), dec);
    }

    public CompletionStage<Boolean> updateOntologyTerms(OntologyTerms ontologyTerm, int id) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "UPDATE ontology_terms SET term = ?, definition = ?, external_id = ?, " +
                                    "external_source = ?, ontology_comment = ?, curator = ?, parent_id = ?, " +
                                    "ontology_level = ?, created = ?, last_updated = ? WHERE ontology_term_id = ?");

                    statement.setString(1, ontologyTerm.getTerm());
                    statement.setString(2, ontologyTerm.getDefinition());
                    statement.setString(3, ontologyTerm.getExternalId());
                    statement.setString(4, ontologyTerm.getExternalSource());
                    statement.setString(5, ontologyTerm.getOntologyComment());
                    statement.setString(6, ontologyTerm.getCurator());
                    statement.setInt(7, ontologyTerm.getParentId());
                    statement.setInt(8, ontologyTerm.getOntologyLevel());
                    statement.setString(9, ontologyTerm.getCreated());
                    statement.setString(10, ontologyTerm.getLastUpdated());
                    statement.setInt(11, id);

                    int rowsUpdated = statement.executeUpdate();
                    return rowsUpdated > 0;
                }), dec);
    }

    public CompletionStage<List<OntologyTerms>> getOntologyTermsInRange(int startId, int endId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT * FROM ontology_terms WHERE ontology_term_id BETWEEN ? AND ?");
                    statement.setInt(1, startId);
                    statement.setInt(2, endId);
                    ResultSet resultSet = statement.executeQuery();

                    List<OntologyTerms> ontologyTermsInRange = new ArrayList<>();
                    while (resultSet.next()) {
                        OntologyTerms ontologyTerm = new OntologyTerms();
                        ontologyTerm.setOntologyTermId(resultSet.getInt("ontology_term_id"));
                        ontologyTerm.setTerm(resultSet.getString("term"));
                        ontologyTerm.setDefinition(resultSet.getString("definition"));
                        ontologyTerm.setExternalId(resultSet.getString("external_id"));
                        ontologyTerm.setExternalSource(resultSet.getString("external_source"));
                        ontologyTerm.setOntologyComment(resultSet.getString("ontology_comment"));
                        ontologyTerm.setCurator(resultSet.getString("curator"));
                        ontologyTerm.setParentId(resultSet.getInt("parent_id"));
                        ontologyTerm.setOntologyLevel(resultSet.getInt("ontology_level"));
                        ontologyTerm.setCreated(resultSet.getString("created"));
                        ontologyTerm.setLastUpdated(resultSet.getString("last_updated"));
                        ontologyTermsInRange.add(ontologyTerm);
                    }
                    return ontologyTermsInRange;
                }), dec);
    }
}
