package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import entities.CompoundPathways;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.data.FormFactory;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Http;
import play.mvc.Result;
import services.CompoundPathwaysService;
import services.DatabaseExecutionContext;
import utils.ApplicationUtil;

import javax.inject.Inject;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static play.mvc.Results.*;

public class CompoundPathwaysController {
    private static final Logger logger = LoggerFactory.getLogger("controller");
    private final FormFactory formFactory;
    private final CompoundPathwaysService cps;
    private final HttpExecutionContext hec;
    private final DatabaseExecutionContext dec;

    @Inject
    public CompoundPathwaysController(FormFactory formFactory, CompoundPathwaysService cps,
                                      HttpExecutionContext hec, DatabaseExecutionContext dec) {
        this.formFactory = formFactory;
        this.cps = cps;
        this.hec = hec;
        this.dec = dec;
    }

    public CompletionStage<Result> retrieve(int compoundId, int pathwayId) {
        logger.debug("Retrieving CompoundPathways with compoundId: {} and pathwayId: {}", compoundId, pathwayId);
        return cps.getCompoundPathways(compoundId, pathwayId).thenApplyAsync(compoundPathway -> {
            if (compoundPathway != null) {
                return ok(Json.toJson(compoundPathway));
            } else {;
                return notFound("CompoundPathways with compoundId " + compoundId + " and pathwayId " + pathwayId + " not found");
            }
        }, hec.current());
    }

    public CompletionStage<Result> create(Http.Request request) {
        JsonNode json = request.body().asJson();
        if (json == null) {
            return CompletableFuture.completedFuture(badRequest("Expecting JSON data"));
        }

        CompoundPathways compoundPathway = Json.fromJson(json, CompoundPathways.class);
        return cps.addCompoundPathways(compoundPathway).thenApplyAsync(result -> {
            if (result) {
                return created(Json.toJson(compoundPathway));
            } else {
                return internalServerError("Error creating CompoundPathways");
            }
        }, hec.current());
    }

    public CompletionStage<Result> listCompoundPathways() {
        logger.debug("Fetching all CompoundOntologies...");
        return cps.getAllCompoundPathways().thenApplyAsync(compoundPathwayList -> {
            JsonNode jsonData = Json.toJson(compoundPathwayList);
            logger.debug("Retrieved CompoundOntologies: {}", compoundPathwayList);
            return ok(ApplicationUtil.createResponse(jsonData, true));
        }, hec.current());
    }

    public CompletionStage<Result> delete(int compoundId, int pathwayId) {
        logger.debug("Attempting to delete CompoundPathways with compoundId: {} and pathwayId: {}", compoundId, pathwayId);
        return cps.deleteCompoundPathways(compoundId, pathwayId).thenApplyAsync(result -> {
            if (result) {
                return ok(ApplicationUtil.createResponse("CompoundPathways deleted", true));
            } else {
                return notFound(ApplicationUtil.createResponse("CompoundPathways not found", false));
            }
        }, hec.current());
    }

    public CompletionStage<Result> update(Http.Request request, int compoundId, int pathwayId) {
        JsonNode json = request.body().asJson();
        if (json == null) {
            return CompletableFuture.completedFuture(badRequest("Expecting JSON data"));
        }

        CompoundPathways updatedCompoundPathways = Json.fromJson(json, CompoundPathways.class);
        return cps.updateCompoundPathways(updatedCompoundPathways, compoundId, pathwayId).thenApplyAsync(result -> {
            if (result) {
                return ok(ApplicationUtil.createResponse(Json.toJson(updatedCompoundPathways), true));
            } else {
                return internalServerError(ApplicationUtil.createResponse("Error updating CompoundPathways", false));
            }
        }, hec.current());
    }

    public CompletionStage<Result> listCompoundPathwaysInRange(int startCompoundId, int endCompoundId) {
        logger.debug("Fetching CompoundOntologies in range from compoundId {} to {}", startCompoundId, endCompoundId);
        return cps.getCompoundPathwaysInRange(startCompoundId, endCompoundId).thenApplyAsync(compoundPathwayList -> {
            JsonNode jsonData = Json.toJson(compoundPathwayList);
            logger.debug("Retrieved CompoundOntologies in range: {}", compoundPathwayList);
            return ok(jsonData);
        }, hec.current());
    }

    public CompletionStage<Result> patchCompoundPathways(Http.Request request, int compoundId, int pathwayId) {
        JsonNode json = request.body().asJson();
        if (json == null || json.isEmpty()) {
            return CompletableFuture.completedFuture(badRequest("Expecting non-empty JSON data"));
        }

        return cps.getCompoundPathways(compoundId, pathwayId).thenComposeAsync(existingCompoundPathways -> {
            if (existingCompoundPathways == null) {
                return CompletableFuture.completedFuture(notFound("CompoundPathways not found"));
            }

            Iterator<Map.Entry<String, JsonNode>> fields = json.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                String fieldName = entry.getKey();
                JsonNode fieldValue = entry.getValue();

                switch (fieldName) {
                    case "created":
                        existingCompoundPathways.setCreated(fieldValue.asText());
                        break;
                    case "lastUpdated":
                        existingCompoundPathways.setLastUpdated(fieldValue.asText());
                        break;
                    default:
                        break;
                }
            }

            return cps.updateCompoundPathways(existingCompoundPathways, compoundId, pathwayId).thenApplyAsync(result -> {
                if (result) {
                    return ok(Json.toJson(existingCompoundPathways));
                } else {
                    return internalServerError("Error updating CompoundPathways");
                }
            }, hec.current());
        }, hec.current());
    }

    public CompletionStage<Result> listCompoundPathwaysByCompoundId(int compoundId) {
        logger.debug("Fetching all CompoundOntologies with compoundId: {} ...", compoundId);
        return cps.getCompoundPathwaysByCompoundId(compoundId).thenApplyAsync(compoundPathwayList -> {
            JsonNode jsonData = Json.toJson(compoundPathwayList);
            logger.debug("Retrieved CompoundOntologies: {}", compoundPathwayList);
            return ok(ApplicationUtil.createResponse(jsonData, true));
        }, hec.current());
    }

}
