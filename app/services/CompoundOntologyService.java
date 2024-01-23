package services;

import entities.CompoundOntologyTerms;
import play.db.Database;

import javax.inject.Inject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class CompoundOntologyService {
    private final Database db;
    private final DatabaseExecutionContext dec;

    @Inject
    public CompoundOntologyService(Database db, DatabaseExecutionContext dec) {
        this.db = db;
        this.dec = dec;
    }

    public CompletionStage<CompoundOntologyTerms> getCompoundOntology(int compoundId, int ontologyTermId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT * FROM compound_chain WHERE compound_id = ? AND ontology_term_id = ?");
                    statement.setInt(1, compoundId);
                    statement.setInt(2, ontologyTermId);
                    ResultSet resultSet = statement.executeQuery();

                    if (resultSet.next()) {
                        return new CompoundOntologyTerms(
                                resultSet.getInt("compound_id"),
                                resultSet.getInt("ontology_term_id"),
                                resultSet.getString("created"),
                                resultSet.getString("last_updated"));
                    }
                    return null;
                }), dec);
    }

    public CompletionStage<Boolean> addCompoundOntology(CompoundOntologyTerms CompoundOntology) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "INSERT INTO compound_chain (compound_id, ontology_term_id, created, last_updated) VALUES (?, ?, ?, ?)");

                    statement.setInt(1, CompoundOntology.getCompoundId());
                    statement.setInt(2, CompoundOntology.getOntologyTermId());
                    statement.setString(3, CompoundOntology.getCreated());
                    statement.setString(4, CompoundOntology.getLastUpdated());

                    int rowsInserted = statement.executeUpdate();
                    return rowsInserted > 0;
                }));
    }

    public CompletionStage<Boolean> deleteCompoundOntology(int compoundId, int ontologyTermId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "DELETE FROM compound_chain WHERE compound_id = ? AND ontology_term_id = ?");
                    statement.setInt(1, compoundId);
                    statement.setInt(2, ontologyTermId);
                    int rowsDeleted = statement.executeUpdate();
                    return rowsDeleted > 0;
                }));
    }

    public CompletionStage<List<CompoundOntologyTerms>> getAllCompoundOntology() {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    List<CompoundOntologyTerms> CompoundOntologyList = new ArrayList<>();
                    ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM compound_chain");
                    while (resultSet.next()) {
                        CompoundOntologyTerms CompoundOntology = new CompoundOntologyTerms(
                                resultSet.getInt("compound_id"),
                                resultSet.getInt("ontology_term_id"),
                                resultSet.getString("created"),
                                resultSet.getString("last_updated"));
                        CompoundOntologyList.add(CompoundOntology);
                    }
                    return CompoundOntologyList;
                }));
    }

    public CompletionStage<Boolean> updateCompoundOntology(CompoundOntologyTerms CompoundOntology, int compoundId, int ontologyTermId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    PreparedStatement statement = connection.prepareStatement(
                            "UPDATE compound_chain SET created = ?, last_updated = ? " +
                                    "WHERE compound_id = ? AND ontology_term_id = ?");

                    statement.setString(1, CompoundOntology.getCreated());
                    statement.setString(2, CompoundOntology.getLastUpdated());
                    statement.setInt(3, compoundId);
                    statement.setInt(4, ontologyTermId);

                    int rowsUpdated = statement.executeUpdate();
                    return rowsUpdated > 0;
                }));
    }

    public CompletionStage<List<CompoundOntologyTerms>> getCompoundOntologyInRange(int startCompoundId, int endCompoundId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    List<CompoundOntologyTerms> compoundOntologyList = new ArrayList<>();
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT * FROM compound_chain WHERE compound_id BETWEEN ? AND ?");
                    statement.setInt(1, startCompoundId);
                    statement.setInt(2, endCompoundId);
                    ResultSet resultSet = statement.executeQuery();

                    while (resultSet.next()) {
                        CompoundOntologyTerms CompoundOntology = new CompoundOntologyTerms(
                                resultSet.getInt("compound_id"),
                                resultSet.getInt("ontology_term_id"),
                                resultSet.getString("created"),
                                resultSet.getString("last_updated"));
                        compoundOntologyList.add(CompoundOntology);
                    }
                    return compoundOntologyList;
                }));
    }


    public CompletionStage<List<CompoundOntologyTerms>> getCompoundOntologysByCompoundId(int compoundId) {
        return CompletableFuture.supplyAsync(() ->
                db.withConnection(connection -> {
                    List<CompoundOntologyTerms> compoundOntologyList = new ArrayList<>();
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT * FROM compound_chain WHERE compound_id = ?");
                    statement.setInt(1, compoundId);
                    ResultSet resultSet = statement.executeQuery();

                    while (resultSet.next()) {
                        CompoundOntologyTerms CompoundOntology = new CompoundOntologyTerms(
                                resultSet.getInt("compound_id"),
                                resultSet.getInt("ontology_term_id"),
                                resultSet.getString("created"),
                                resultSet.getString("last_updated"));
                        compoundOntologyList.add(CompoundOntology);
                    }
                    return compoundOntologyList;
                }));
    }
}

