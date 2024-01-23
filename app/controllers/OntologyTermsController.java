package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import entities.OntologyTerms;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.data.FormFactory;
import play.libs.Json;
import play.libs.concurrent.HttpExecution;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.DatabaseExecutionContext;
import services.OntologyTermsService;
import utils.ApplicationUtil;

import javax.inject.Inject;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;

public class OntologyTermsController extends Controller {

    private static final Logger logger = LoggerFactory.getLogger("controller");
    private final FormFactory formFactory;
    private final OntologyTermsService ontologyTermsService;
    private final HttpExecutionContext hec;
    private final DatabaseExecutionContext dec;

    @Inject
    public OntologyTermsController(FormFactory formFactory, OntologyTermsService ontologyTermsService, HttpExecutionContext hec, DatabaseExecutionContext dec) {
        this.formFactory = formFactory;
        this.ontologyTermsService = ontologyTermsService;
        this.hec = hec;
        this.dec = dec;
    }

    public CompletionStage<Result> retrieve(int id) {
        Executor myEc = HttpExecution.fromThread(dec);
        logger.debug("In OntologyTermsController.retrieve(), retrieve pathway with id: {}", id);
        return ontologyTermsService.getOntologyTerms(id).thenApplyAsync(ontologyTerms -> {
            if (ontologyTerms != null) {
                return ok(ApplicationUtil.createResponse(Json.toJson(ontologyTerms), true));
            } else {
                return notFound(ApplicationUtil.createResponse("Ontology Term not found", false));
            }
        }, hec.current());
    }

    public CompletionStage<Result> create(Http.Request request) {
        JsonNode json = request.body().asJson();

        if (json == null) {
            return CompletableFuture.completedFuture(
                    badRequest(ApplicationUtil.createResponse("Expecting JSON data", false))
            );
        }

        OntologyTerms ontologyTerm = Json.fromJson(json, OntologyTerms.class);
        return ontologyTermsService.addOntologyTerms(ontologyTerm).thenApplyAsync(result -> {
            if (result) {
                return created(ApplicationUtil.createResponse(Json.toJson(ontologyTerm), true));
            } else {
                return internalServerError(ApplicationUtil.createResponse("Error creating Ontology Term", false));
            }
        }, hec.current());
    }

    public CompletionStage<Result> listOntologyTerms() {
        logger.debug("Fetching all Ontology Terms...");
        return ontologyTermsService.getAllOntologyTerms().thenApplyAsync(ontologyTermsList -> {
            JsonNode jsonData = Json.toJson(ontologyTermsList);
            return ok(ApplicationUtil.createResponse(jsonData, true));
        }, hec.current());
    }

    public CompletionStage<Result> delete(int id) {
        logger.debug("Attempting to delete Ontology Term with id: {}", id);
        return ontologyTermsService.deleteOntologyTerms(id).thenApplyAsync(result -> {
            if (result) {
                return ok(ApplicationUtil.createResponse("Ontology Term with id: " + id + " deleted", true));
            } else {
                return notFound(ApplicationUtil.createResponse("Ontology Term with id: " + id + " not found", false));
            }
        }, hec.current());
    }

    public CompletionStage<Result> update(Http.Request request, int id) {
        JsonNode json = request.body().asJson();
        if (json == null) {
            return CompletableFuture.completedFuture(badRequest(ApplicationUtil.createResponse("Expecting JSON data", false)));
        }
        OntologyTerms ontologyTerm = Json.fromJson(json, OntologyTerms.class);
        return ontologyTermsService.updateOntologyTerms(ontologyTerm, id).thenApplyAsync(result -> {
            if (result) {
                return ok(ApplicationUtil.createResponse(Json.toJson(ontologyTerm), true));
            } else {
                return internalServerError(ApplicationUtil.createResponse("Error updating Ontology Term", false));
            }
        }, hec.current());
    }

    public CompletionStage<Result> listOntologyTermsInRange(int startId, int endId) {
        logger.debug("Fetching Ontology Terms in range from {} to {}...", startId, endId);
        return ontologyTermsService.getOntologyTermsInRange(startId, endId).thenApplyAsync(ontologyTermsList -> {
            JsonNode jsonData = Json.toJson(ontologyTermsList);
            logger.debug("Retrieved Ontology Terms in range: {}", ontologyTermsList.toString());
            return ok(ApplicationUtil.createResponse(jsonData, true));
        }, hec.current());
    }

    public CompletionStage<Result> patchOntologyTerms(Http.Request request, int ontologyTermId) {
        JsonNode json = request.body().asJson();

        if (json == null || json.isEmpty()) {
            return CompletableFuture.completedFuture(
                    badRequest(ApplicationUtil.createResponse("Expecting non-empty JSON data", false))
            );
        }

        return ontologyTermsService.getOntologyTerms(ontologyTermId).thenComposeAsync(existingOntologyTerm -> {
            if (existingOntologyTerm == null) {
                return CompletableFuture.completedFuture(notFound(ApplicationUtil.createResponse("Ontology Term not found", false)));
            }

            Iterator<Map.Entry<String, JsonNode>> fields = json.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                String fieldName = entry.getKey();
                JsonNode fieldValue = entry.getValue();

                switch (fieldName) {
                    case "term":
                        existingOntologyTerm.setTerm(fieldValue.asText());
                        break;
                    case "definition":
                        existingOntologyTerm.setDefinition(fieldValue.asText());
                        break;
                    case "externalId":
                        existingOntologyTerm.setExternalId(fieldValue.asText());
                        break;
                    case "externalSource":
                        existingOntologyTerm.setExternalSource(fieldValue.asText());
                        break;
                    case "ontologyComment":
                        existingOntologyTerm.setOntologyComment(fieldValue.asText());
                        break;
                    case "curator":
                        existingOntologyTerm.setCurator(fieldValue.asText());
                        break;
                    case "parentId":
                        existingOntologyTerm.setParentId(fieldValue.asInt());
                        break;
                    case "ontologyLevel":
                        existingOntologyTerm.setOntologyLevel(fieldValue.asInt());
                        break;
                    case "created":
                        existingOntologyTerm.setCreated(fieldValue.asText());
                        break;
                    case "lastUpdated":
                        existingOntologyTerm.setLastUpdated(fieldValue.asText());
                        break;
                }
            }

            return ontologyTermsService.updateOntologyTerms(existingOntologyTerm, existingOntologyTerm.getOntologyTermId()).thenApplyAsync(result -> {
                if (result) {
                    return ok(ApplicationUtil.createResponse(Json.toJson(existingOntologyTerm), true));
                } else {
                    return internalServerError(ApplicationUtil.createResponse("Error updating Ontology Term", false));
                }
            }, hec.current());
        }, hec.current());
    }
}

