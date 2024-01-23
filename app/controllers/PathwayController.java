package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import entities.Pathway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.data.FormFactory;
import play.libs.Json;
import play.libs.concurrent.HttpExecution;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.PathwayService;
import services.DatabaseExecutionContext;
import utils.ApplicationUtil;

import javax.inject.Inject;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;

public class PathwayController extends Controller {

    private static final Logger logger = LoggerFactory.getLogger("controller");
    private final FormFactory formFactory;
    private final PathwayService pathwayService;
    private final HttpExecutionContext hec;
    private final DatabaseExecutionContext dec;

    @Inject
    public PathwayController(FormFactory formFactory, PathwayService pathwayService, HttpExecutionContext hec, DatabaseExecutionContext dec) {
        this.formFactory = formFactory;
        this.pathwayService = pathwayService;
        this.hec = hec;
        this.dec = dec;
    }

    public CompletionStage<Result> retrieve(int id) {
        Executor myEc = HttpExecution.fromThread(dec);
        logger.debug("In PathwayController.retrieve(), retrieve pathway with id: {}", id);

        return pathwayService.getPathway(id).thenApplyAsync(pathway ->
                        ok(ApplicationUtil.createResponse(Json.toJson(pathway), true)),
                hec.current());
    }

    public CompletionStage<Result> create(Http.Request request) {
        JsonNode json = request.body().asJson();

        if (json == null) {
            return CompletableFuture.completedFuture(
                    badRequest(ApplicationUtil.createResponse("Expecting JSON data", false))
            );
        }

        Pathway pathway = Json.fromJson(json, Pathway.class);
        return pathwayService.addPathway(pathway).thenApplyAsync(result -> {
            if (result) {
                return created(ApplicationUtil.createResponse(Json.toJson(pathway), true));
            } else {
                return internalServerError(ApplicationUtil.createResponse("Error creating pathway", false));
            }
        }, hec.current());
    }

    public CompletionStage<Result> listPathways() {
        logger.debug("Fetching all pathways...");
        return pathwayService.getAllPathways().thenApplyAsync(pathways -> {
            JsonNode jsonData = Json.toJson(pathways);
            logger.debug("Retrieved pathways: {}", pathways.toString());
            return ok(ApplicationUtil.createResponse(jsonData, true));
        }, hec.current());
    }

    public CompletionStage<Result> delete(int id) {
        logger.debug("Attempting to delete Ontology Term with id: {}", id);
        return pathwayService.deletePathway(id).thenApplyAsync(result -> {
            if (result) {
                return ok(ApplicationUtil.createResponse("Pathway with id: " + id + " deleted", true));
            } else {
                return notFound(ApplicationUtil.createResponse("Pathway with id: " + id + " not found", false));
            }
        }, hec.current());
    }

    public CompletionStage<Result> update(Http.Request request, int id) {
        JsonNode json = request.body().asJson();

        if (json == null) {
            return CompletableFuture.completedFuture(
                    badRequest(ApplicationUtil.createResponse("Expecting JSON data", false))
            );
        }

        Pathway pathway = Json.fromJson(json, Pathway.class);
        return pathwayService.updatePathway(pathway, id).thenApplyAsync(result -> {
            if (result) {
                return ok(ApplicationUtil.createResponse(Json.toJson(pathway), true));
            } else {
                return internalServerError(ApplicationUtil.createResponse("Error updating pathway", false));
            }
        }, hec.current());
    }

    public CompletionStage<Result> listPathwaysInRange(int startId, int endId) {
        logger.debug("Fetching pathways in range from {} to {}...", startId, endId);
        return pathwayService.getPathwaysInRange(startId, endId).thenApplyAsync(pathways -> {
            JsonNode jsonData = Json.toJson(pathways);
            logger.debug("Retrieved pathways in range: {}", pathways.toString());
            return ok(ApplicationUtil.createResponse(jsonData, true));
        }, hec.current());
    }

    public CompletionStage<Result> patchPathway(Http.Request request, int pathwayId) {
        JsonNode json = request.body().asJson();

        if (json == null || json.isEmpty()) {
            return CompletableFuture.completedFuture(
                    badRequest(ApplicationUtil.createResponse("Expecting non-empty JSON data", false))
            );
        }

        return pathwayService.getPathway(pathwayId).thenComposeAsync(existingPathway -> {
            if (existingPathway == null) {
                return CompletableFuture.completedFuture(notFound(ApplicationUtil.createResponse("Pathway not found", false)));
            }

            Iterator<Map.Entry<String, JsonNode>> fields = json.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                String fieldName = entry.getKey();
                JsonNode fieldValue = entry.getValue();

                switch (fieldName) {
                    case "pathwayMap":
                        existingPathway.setPathwayMap(fieldValue.asText());
                        break;
                    case "pathwayName":
                        existingPathway.setPathwayName(fieldValue.asText());
                        break;
                    case "created":
                        existingPathway.setCreated(fieldValue.asText());
                        break;
                    case "lastUpdated":
                        existingPathway.setLastUpdated(fieldValue.asText());
                        break;
                    default:
                        break;
                }
            }

            return pathwayService.updatePathway(existingPathway, existingPathway.getPathwayId()).thenApplyAsync(result -> {
                if (result) {
                    return ok(ApplicationUtil.createResponse(Json.toJson(existingPathway), true));
                } else {
                    return internalServerError(ApplicationUtil.createResponse("Error updating pathway", false));
                }
            }, hec.current());
        }, hec.current());
    }
}