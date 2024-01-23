package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import entities.ClassyfireClassificationDictionary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.data.FormFactory;
import play.libs.Json;
import play.libs.concurrent.HttpExecution;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.ClassyfireClassificationService;
import services.DatabaseExecutionContext;
import utils.ApplicationUtil;

import javax.inject.Inject;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;

public class ClassyfireClassificationController extends Controller {
    private static final Logger logger = LoggerFactory.getLogger("controller");
    private final FormFactory formFactory;
    private final ClassyfireClassificationService classyfireClassificationService;
    private final HttpExecutionContext hec;
    private final DatabaseExecutionContext dec;

    @Inject
    public ClassyfireClassificationController(FormFactory formFactory, ClassyfireClassificationService classyfireClassificationService,
                                              HttpExecutionContext hec, DatabaseExecutionContext dec) {
        this.formFactory = formFactory;
        this.classyfireClassificationService = classyfireClassificationService;
        this.hec = hec;
        this.dec = dec;
    }

    public CompletionStage<Result> retrieve(int id) {
        Executor myEc = HttpExecution.fromThread(dec);
        logger.debug("In ClassyfireClassificationController.retrieve(), retrieve pathway with id: {}", id);
        return classyfireClassificationService.getClassyfireClassification(id).thenApplyAsync(classyfireClassificationDictionary -> {
            if (classyfireClassificationDictionary != null) {
                return ok(ApplicationUtil.createResponse(Json.toJson(classyfireClassificationDictionary), true));
            } else {
                return notFound(ApplicationUtil.createResponse("Classyfire Classification not found", false));
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

        ClassyfireClassificationDictionary classyfireClassificationDictionary = Json.fromJson(json, ClassyfireClassificationDictionary.class);
        return classyfireClassificationService.addClassyfireClassification(classyfireClassificationDictionary).thenApplyAsync(result -> {
            if (result) {
                return created(ApplicationUtil.createResponse(Json.toJson(classyfireClassificationDictionary), true));
            } else {
                return internalServerError(ApplicationUtil.createResponse("Error creating Ontology Term", false));
            }
        }, hec.current());
    }

    public CompletionStage<Result> listClassyfireClassifications() {
        logger.debug("Fetching all Classyfire Classifications...");
        return classyfireClassificationService.getAllClassyfireClassifications().thenApplyAsync(classyfireClassificationList -> {
            JsonNode jsonData = Json.toJson(classyfireClassificationList);
            return ok(ApplicationUtil.createResponse(jsonData, true));
        }, hec.current());
    }

    public CompletionStage<Result> delete(int id) {
        logger.debug("Attempting to delete Classyfire Classification with id: {}", id);
        return classyfireClassificationService.deleteClassyfireClassification(id).thenApplyAsync(result -> {
            if (result) {
                return ok(ApplicationUtil.createResponse("Classyfire Classification with id: " + id + " deleted", true));
            } else {
                return notFound(ApplicationUtil.createResponse("Classyfire Classification with id: " + id + " not found", false));
            }
        }, hec.current());
    }

    public CompletionStage<Result> update(Http.Request request, int id) {
        JsonNode json = request.body().asJson();
        if (json == null) {
            return CompletableFuture.completedFuture(badRequest(ApplicationUtil.createResponse("Expecting JSON data", false)));
        }
        ClassyfireClassificationDictionary classyfireClassificationDictionary = Json.fromJson(json, ClassyfireClassificationDictionary.class);
        return classyfireClassificationService.updateClassyfireClassification(classyfireClassificationDictionary, id).thenApplyAsync(result -> {
            if (result) {
                return ok(ApplicationUtil.createResponse(Json.toJson(classyfireClassificationDictionary), true));
            } else {
                return internalServerError(ApplicationUtil.createResponse("Error updating Classyfire Classification ", false));
            }
        }, hec.current());
    }

    public CompletionStage<Result> listClassyfireClassificationInRange(int startId, int endId) {
        logger.debug("Fetching Classyfire Classification in range from {} to {}...", startId, endId);
        return classyfireClassificationService.getClassyfireClassificationInRange(startId, endId).thenApplyAsync(classyfireClassificationList -> {
            JsonNode jsonData = Json.toJson(classyfireClassificationList);
            logger.debug("Retrieved Classyfire Classification in range: {}", classyfireClassificationList.toString());
            return ok(ApplicationUtil.createResponse(jsonData, true));
        }, hec.current());
    }

    public CompletionStage<Result> patchClassyfireClassification(Http.Request request, int id) {
        JsonNode json = request.body().asJson();
        if (json == null || json.isEmpty()) {
            return CompletableFuture.completedFuture(badRequest(ApplicationUtil.createResponse("Expecting non-empty JSON data", false)));
        }

        return classyfireClassificationService.getClassyfireClassification(id).thenComposeAsync(existingClassyfireClassificationDictionary -> {
            if (existingClassyfireClassificationDictionary == null) {
                return CompletableFuture.completedFuture(notFound(ApplicationUtil.createResponse("Classyfire Classification not found", false)));
            }

            Iterator<Map.Entry<String, JsonNode>> fields = json.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                String fieldName = entry.getKey();
                JsonNode fieldValue = entry.getValue();

                switch (fieldName) {
                    case "node_id":
                        existingClassyfireClassificationDictionary.setNodeId(fieldValue.asText());
                        break;
                    case "node_name":
                        existingClassyfireClassificationDictionary.setNodeName(fieldValue.asText());
                        break;
                    case "created":
                        existingClassyfireClassificationDictionary.setCreated(fieldValue.asText());
                        break;
                    case "lastUpdated":
                        existingClassyfireClassificationDictionary.setLastUpdated(fieldValue.asText());
                        break;
                }
            }

            return classyfireClassificationService.updateClassyfireClassification(existingClassyfireClassificationDictionary, id).thenApplyAsync(result -> {
                if (result) {
                    return ok(ApplicationUtil.createResponse(Json.toJson(existingClassyfireClassificationDictionary), true));
                } else {
                    return internalServerError(ApplicationUtil.createResponse("Error updating Classyfire Classification", false));
                }
            }, hec.current());
        }, hec.current());
    }
}
