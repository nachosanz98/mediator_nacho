package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import entities.CompoundOntologyTerms;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.data.FormFactory;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.CompoundOntologyService;
import services.DatabaseExecutionContext;
import utils.ApplicationUtil;

import javax.inject.Inject;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class CompoundOntologyController extends Controller {
    private static final Logger logger = LoggerFactory.getLogger("controller");
    private final FormFactory formFactory;
    private final CompoundOntologyService cos;
    private final HttpExecutionContext hec;
    private final DatabaseExecutionContext dec;

    @Inject
    public CompoundOntologyController(FormFactory formFactory, CompoundOntologyService cos,
                                   HttpExecutionContext hec, DatabaseExecutionContext dec) {
        this.formFactory = formFactory;
        this.cos = cos;
        this.hec = hec;
        this.dec = dec;
    }

    public CompletionStage<Result> retrieve(int compoundId, int ontologyTermId) {
        logger.debug("Retrieving CompoundOntology with compoundId: {} and ontologyTermId: {}", compoundId, ontologyTermId);
        return cos.getCompoundOntology(compoundId, ontologyTermId).thenApplyAsync(compoundOntology -> {
            if (compoundOntology != null) {
                return ok(Json.toJson(compoundOntology));
            } else {;
                return notFound("CompoundOntology with compoundId " + compoundId + " and ontologyTermId " + ontologyTermId + " not found");
            }
        }, hec.current());
    }

    public CompletionStage<Result> create(Http.Request request) {
        JsonNode json = request.body().asJson();
        if (json == null) {
            return CompletableFuture.completedFuture(badRequest("Expecting JSON data"));
        }

        CompoundOntologyTerms compoundOntology = Json.fromJson(json, CompoundOntologyTerms.class);
        return cos.addCompoundOntology(compoundOntology).thenApplyAsync(result -> {
            if (result) {
                return created(Json.toJson(compoundOntology));
            } else {
                return internalServerError("Error creating CompoundOntology");
            }
        }, hec.current());
    }

    public CompletionStage<Result> listCompoundOntology() {
        logger.debug("Fetching all CompoundOntologies...");
        return cos.getAllCompoundOntology().thenApplyAsync(compoundOntologyList -> {
            JsonNode jsonData = Json.toJson(compoundOntologyList);
            logger.debug("Retrieved CompoundOntologies: {}", compoundOntologyList);
            return ok(ApplicationUtil.createResponse(jsonData, true));
        }, hec.current());
    }

    public CompletionStage<Result> delete(int compoundId, int ontologyTermId) {
        logger.debug("Attempting to delete CompoundOntology with compoundId: {} and ontologyTermId: {}", compoundId, ontologyTermId);
        return cos.deleteCompoundOntology(compoundId, ontologyTermId).thenApplyAsync(result -> {
            if (result) {
                return ok(ApplicationUtil.createResponse("CompoundOntology deleted", true));
            } else {
                return notFound(ApplicationUtil.createResponse("CompoundOntology not found", false));
            }
        }, hec.current());
    }

    public CompletionStage<Result> update(Http.Request request, int compoundId, int ontologyTermId) {
        JsonNode json = request.body().asJson();
        if (json == null) {
            return CompletableFuture.completedFuture(badRequest("Expecting JSON data"));
        }

        CompoundOntologyTerms updatedCompoundOntology = Json.fromJson(json, CompoundOntologyTerms.class);
        return cos.updateCompoundOntology(updatedCompoundOntology, compoundId, ontologyTermId).thenApplyAsync(result -> {
            if (result) {
                return ok(ApplicationUtil.createResponse(Json.toJson(updatedCompoundOntology), true));
            } else {
                return internalServerError(ApplicationUtil.createResponse("Error updating CompoundOntology", false));
            }
        }, hec.current());
    }

    public CompletionStage<Result> listCompoundOntologyInRange(int startCompoundId, int endCompoundId) {
        logger.debug("Fetching CompoundOntologies in range from compoundId {} to {}", startCompoundId, endCompoundId);
        return cos.getCompoundOntologyInRange(startCompoundId, endCompoundId).thenApplyAsync(compoundOntologyList -> {
            JsonNode jsonData = Json.toJson(compoundOntologyList);
            logger.debug("Retrieved CompoundOntologies in range: {}", compoundOntologyList);
            return ok(jsonData);
        }, hec.current());
    }

    public CompletionStage<Result> patchCompoundOntology(Http.Request request, int compoundId, int ontologyTermId) {
        JsonNode json = request.body().asJson();
        if (json == null || json.isEmpty()) {
            return CompletableFuture.completedFuture(badRequest("Expecting non-empty JSON data"));
        }

        return cos.getCompoundOntology(compoundId, ontologyTermId).thenComposeAsync(existingCompoundOntology -> {
            if (existingCompoundOntology == null) {
                return CompletableFuture.completedFuture(notFound("CompoundOntology not found"));
            }

            Iterator<Map.Entry<String, JsonNode>> fields = json.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                String fieldName = entry.getKey();
                JsonNode fieldValue = entry.getValue();

                switch (fieldName) {
                    case "created":
                        existingCompoundOntology.setCreated(fieldValue.asText());
                        break;
                    case "lastUpdated":
                        existingCompoundOntology.setLastUpdated(fieldValue.asText());
                        break;
                    default:
                        break;
                }
            }

            return cos.updateCompoundOntology(existingCompoundOntology, compoundId, ontologyTermId).thenApplyAsync(result -> {
                if (result) {
                    return ok(Json.toJson(existingCompoundOntology));
                } else {
                    return internalServerError("Error updating CompoundOntology");
                }
            }, hec.current());
        }, hec.current());
    }

    public CompletionStage<Result> listCompoundOntologyByCompoundId(int compoundId) {
        logger.debug("Fetching all CompoundOntologies with compoundId: {} ...", compoundId);
        return cos.getCompoundOntologysByCompoundId(compoundId).thenApplyAsync(compoundOntologyList -> {
            JsonNode jsonData = Json.toJson(compoundOntologyList);
            logger.debug("Retrieved CompoundOntologies: {}", compoundOntologyList);
            return ok(ApplicationUtil.createResponse(jsonData, true));
        }, hec.current());
    }

}
