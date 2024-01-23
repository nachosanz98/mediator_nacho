package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import entities.CompoundClassyfireClassification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.data.FormFactory;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.CompoundClassyfireService;
import services.DatabaseExecutionContext;
import utils.ApplicationUtil;

import javax.inject.Inject;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class CompoundClassyfireController extends Controller {
    private static final Logger logger = LoggerFactory.getLogger("controller");
    private final FormFactory formFactory;
    private final CompoundClassyfireService ccs;
    private final HttpExecutionContext hec;
    private final DatabaseExecutionContext dec;

    @Inject
    public CompoundClassyfireController(FormFactory formFactory, CompoundClassyfireService ccs,
                                        HttpExecutionContext hec, DatabaseExecutionContext dec) {
        this.formFactory = formFactory;
        this.ccs = ccs;
        this.hec = hec;
        this.dec = dec;
    }

    public CompletionStage<Result> retrieve(int compoundId, String nodeId) {
        logger.debug("Retrieving compoundClassyfire with compoundId: {} and nodeId: {}", compoundId, nodeId);
        return ccs.getCompoundClassyfire(compoundId, nodeId).thenApplyAsync(compoundClassyfire -> {
            if (compoundClassyfire != null) {
                return ok(Json.toJson(compoundClassyfire));
            } else {;
                return notFound("CompoundClassyfire with compoundId " + compoundId + " and nodeId " + nodeId + " not found");
            }
        }, hec.current());
    }

    public CompletionStage<Result> create(Http.Request request) {
        JsonNode json = request.body().asJson();
        if (json == null) {
            return CompletableFuture.completedFuture(badRequest("Expecting JSON data"));
        }

        CompoundClassyfireClassification compoundClassyfire = Json.fromJson(json, CompoundClassyfireClassification.class);
        return ccs.addCompoundClassyfire(compoundClassyfire).thenApplyAsync(result -> {
            if (result) {
                return created(Json.toJson(compoundClassyfire));
            } else {
                return internalServerError("Error creating compoundClassyfire");
            }
        }, hec.current());
    }

    public CompletionStage<Result> listCompoundClassyfire() {
        logger.debug("Fetching all CompoundClassyfires...");
        return ccs.getAllCompoundClassyfire().thenApplyAsync(compoundClassyfireList -> {
            JsonNode jsonData = Json.toJson(compoundClassyfireList);
            logger.debug("Retrieved CompoundClassyfires: {}", compoundClassyfireList);
            return ok(ApplicationUtil.createResponse(jsonData, true));
        }, hec.current());
    }

    public CompletionStage<Result> delete(int compoundId, String nodeId) {
        logger.debug("Attempting to delete compoundClassyfire with compoundId: {} and nodeId: {}", compoundId, nodeId);
        return ccs.deleteCompoundClassyfire(compoundId, nodeId).thenApplyAsync(result -> {
            if (result) {
                return ok(ApplicationUtil.createResponse("compoundClassyfire deleted", true));
            } else {
                return notFound(ApplicationUtil.createResponse("compoundClassyfire not found", false));
            }
        }, hec.current());
    }

    public CompletionStage<Result> update(Http.Request request, int compoundId, String nodeId) {
        JsonNode json = request.body().asJson();
        if (json == null) {
            return CompletableFuture.completedFuture(badRequest("Expecting JSON data"));
        }

        CompoundClassyfireClassification updatedCompoundClassyfire = Json.fromJson(json, CompoundClassyfireClassification.class);
        return ccs.updateCompoundClassyfire(updatedCompoundClassyfire, compoundId, nodeId).thenApplyAsync(result -> {
            if (result) {
                return ok(ApplicationUtil.createResponse(Json.toJson(updatedCompoundClassyfire), true));
            } else {
                return internalServerError(ApplicationUtil.createResponse("Error updating compoundClassyfire", false));
            }
        }, hec.current());
    }

    public CompletionStage<Result> listCompoundClassyfireInRange(int startCompoundId, int endCompoundId) {
        logger.debug("Fetching CompoundClassyfires in range from compoundId {} to {}", startCompoundId, endCompoundId);
        return ccs.getCompoundClassyfireInRange(startCompoundId, endCompoundId).thenApplyAsync(compoundClassyfireList -> {
            JsonNode jsonData = Json.toJson(compoundClassyfireList);
            logger.debug("Retrieved CompoundClassyfires in range: {}", compoundClassyfireList);
            return ok(jsonData);
        }, hec.current());
    }

    public CompletionStage<Result> patchCompoundClassyfire(Http.Request request, int compoundId, String nodeId) {
        JsonNode json = request.body().asJson();
        if (json == null || json.isEmpty()) {
            return CompletableFuture.completedFuture(badRequest("Expecting non-empty JSON data"));
        }

        return ccs.getCompoundClassyfire(compoundId, nodeId).thenComposeAsync(existingcompoundClassyfire -> {
            if (existingcompoundClassyfire == null) {
                return CompletableFuture.completedFuture(notFound("CompoundClassyfire not found"));
            }

            Iterator<Map.Entry<String, JsonNode>> fields = json.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                String fieldName = entry.getKey();
                JsonNode fieldValue = entry.getValue();

                switch (fieldName) {
                    case "created":
                        existingcompoundClassyfire.setCreated(fieldValue.asText());
                        break;
                    case "lastUpdated":
                        existingcompoundClassyfire.setLastUpdated(fieldValue.asText());
                        break;
                    default:
                        break;
                }
            }

            return ccs.updateCompoundClassyfire(existingcompoundClassyfire, compoundId, nodeId).thenApplyAsync(result -> {
                if (result) {
                    return ok(Json.toJson(existingcompoundClassyfire));
                } else {
                    return internalServerError("Error updating CompoundClassyfire");
                }
            }, hec.current());
        }, hec.current());
    }

    public CompletionStage<Result> listCompoundClassyfireByCompoundId(int compoundId) {
        logger.debug("Fetching all CompoundClassyfires with compoundId: {} ...", compoundId);
        return ccs.getCompoundClassyfireByCompoundId(compoundId).thenApplyAsync(compoundClassyfireList -> {
            JsonNode jsonData = Json.toJson(compoundClassyfireList);
            logger.debug("Retrieved CompoundClassyfires: {}", compoundClassyfireList);
            return ok(ApplicationUtil.createResponse(jsonData, true));
        }, hec.current());
    }
}