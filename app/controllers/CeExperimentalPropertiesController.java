package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import entities.CeExperimentalProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.data.FormFactory;
import play.libs.Json;
import play.libs.concurrent.HttpExecution;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Http;
import play.mvc.Result;
import services.CeExperimentalPropertiesService;
import services.DatabaseExecutionContext;
import utils.ApplicationUtil;

import javax.inject.Inject;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;

import static play.mvc.Results.*;

public class CeExperimentalPropertiesController {
    private static final Logger logger = LoggerFactory.getLogger("controller");
    private final FormFactory formFactory;
    private final CeExperimentalPropertiesService cep;
    private final HttpExecutionContext hec;
    private final DatabaseExecutionContext dec;

    @Inject
    public CeExperimentalPropertiesController(FormFactory formFactory, CeExperimentalPropertiesService cep,
                                              HttpExecutionContext hec, DatabaseExecutionContext dec) {
        this.formFactory = formFactory;
        this.cep = cep;
        this.hec = hec;
        this.dec = dec;
    }

    public CompletionStage<Result> retrieve(int id) {
        Executor myEc = HttpExecution.fromThread(dec);
        logger.debug("In CeExperimentalPropertiesController.retrieve(), retrieve pathway with id: {}", id);
        return cep.getCeExperimentalProperty(id).thenApplyAsync(ceExpProp -> {
            if (ceExpProp != null) {
                return ok(ApplicationUtil.createResponse(Json.toJson(ceExpProp), true));
            } else {
                return notFound("Ce Experimental Property with id " + id + " not found");
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

        CeExperimentalProperties ceExpProps = Json.fromJson(json, CeExperimentalProperties.class);
        return cep.addCeExperimentalProperty(ceExpProps).thenApplyAsync(result -> {
            if (result != null) {
                return created(ApplicationUtil.createResponse(Json.toJson(ceExpProps), true));
            } else {
                return internalServerError(ApplicationUtil.createResponse("Error creating Ce Experimental Property", false));
            }
        }, hec.current());
    }

    public CompletionStage<Result> listCeExperimentalProperties() {
        logger.debug("Fetching all Ce Experimental Properties...");
        return cep.getAllCeExperimentalProperties().thenApplyAsync(ceExpPropsList -> {
            JsonNode jsonData = Json.toJson(ceExpPropsList);
            logger.debug("Retrieved Ce Experimental Properties: {}", ceExpPropsList.toString());
            return ok(ApplicationUtil.createResponse(jsonData, true));
        }, hec.current());
    }

    public CompletionStage<Result> delete(int id) {
        return cep.deleteCeExperimentalProperty(id).thenApplyAsync(result -> {
            if (result) {
                return ok(ApplicationUtil.createResponse("Ce Experimental Property with id: " + id + " deleted", true));
            } else {
                return notFound(ApplicationUtil.createResponse("Ce Experimental Property with id: " + id + " not found", false));
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

        CeExperimentalProperties updatedCeExpProp = Json.fromJson(json, CeExperimentalProperties.class);
        return cep.updateCeExperimentalProperty(updatedCeExpProp, id).thenApplyAsync(result -> {
            if (result) {
                return ok(ApplicationUtil.createResponse(Json.toJson(updatedCeExpProp), true));
            } else {
                return internalServerError(ApplicationUtil.createResponse("Error updating Ce Experimental Property", false));
            }
        }, hec.current());
    }

    public CompletionStage<Result> listCeExperimentalPropertiesInRange(int startId, int endId) {
        logger.debug("Fetching Ce Experimental Properties in range from {} to {}...", startId, endId);
        return cep.getCeExperimentalPropertiesInRange(startId, endId).thenApplyAsync(ceExpPropsList -> {
            JsonNode jsonData = Json.toJson(ceExpPropsList);
            logger.debug("Retrieved Ce Experimental Properties in range: {}", ceExpPropsList.toString());
            return ok(ApplicationUtil.createResponse(jsonData, true));
        }, hec.current());
    }

    public CompletionStage<Result> patchCeExperimentalProperties(Http.Request request, int id) {
        JsonNode json = request.body().asJson();
        if (json == null || json.isEmpty()) {
            return CompletableFuture.completedFuture(
                    badRequest("Expecting non-empty JSON data")
            );
        }

        return cep.getCeExperimentalProperty(id).thenComposeAsync(existingCeExpProp -> {
            if (existingCeExpProp == null) {
                return CompletableFuture.completedFuture(notFound("Ce Experimental Property not found"));
            }

            Iterator<Map.Entry<String, JsonNode>> fields = json.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                String fieldName = entry.getKey();
                JsonNode fieldValue = entry.getValue();

                switch (fieldName) {
                    case "buffer":
                        existingCeExpProp.setBuffer(fieldValue.asInt());
                        break;
                    case "temperature":
                        existingCeExpProp.setTemperature(fieldValue.asInt());
                        break;
                    case "ionizationMode":
                        existingCeExpProp.setIonizationMode(fieldValue.asInt());
                        break;
                    case "polarity":
                        existingCeExpProp.setPolarity(fieldValue.asInt());
                        break;
                    case "created":
                        existingCeExpProp.setCreated(fieldValue.asText());
                        break;
                    case "lastUpdated":
                        existingCeExpProp.setLastUpdated(fieldValue.asText());
                        break;
                    default:
                        break;
                }
            }

            return cep.updateCeExperimentalProperty(existingCeExpProp, id).thenApplyAsync(result -> {
                if (result) {
                    return ok(ApplicationUtil.createResponse(Json.toJson(existingCeExpProp), true));
                } else {
                    return internalServerError(ApplicationUtil.createResponse("Error updating Ce Experimental Property", false));
                }
            }, hec.current());
        }, hec.current());
    }
}
