package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import entities.CeEffMob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.data.FormFactory;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.CeEffMobService;
import services.DatabaseExecutionContext;
import utils.ApplicationUtil;

import javax.inject.Inject;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class CeEffMobController extends Controller {

    private static final Logger logger = LoggerFactory.getLogger("controller");
    private final FormFactory formFactory;
    private final CeEffMobService cems;
    private final HttpExecutionContext hec;
    private final DatabaseExecutionContext dec;

    @Inject
    public CeEffMobController(FormFactory formFactory, CeEffMobService ceEffMobService, HttpExecutionContext hec, DatabaseExecutionContext dec) {
        this.formFactory = formFactory;
        this.cems = ceEffMobService;
        this.hec = hec;
        this.dec = dec;
    }

    public CompletionStage<Result> retrieve(int id) {
        logger.debug("In CeEffMobController.retrieve(), retrieve CeEffMob with id: {}", id);
        return cems.getCeEffMob(id).thenApplyAsync(ceEffMob ->
                {
                    return ok(ApplicationUtil.createResponse(Json.toJson(ceEffMob), true));
                }
                , hec.current());
    }

    public CompletionStage<Result> create(Http.Request request) {
        JsonNode json = request.body().asJson();

        if (json == null) {
            return CompletableFuture.completedFuture(
                    badRequest(ApplicationUtil.createResponse("Expecting JSON data", false))
            );
        }

        CeEffMob ceEffMob = Json.fromJson(json, CeEffMob.class);
        return cems.addCeEffMob(ceEffMob).thenApplyAsync(result -> {
            if (result) {
                return created(ApplicationUtil.createResponse(Json.toJson(ceEffMob), true));
            } else {
                return internalServerError(ApplicationUtil.createResponse("Error creating CeEffMob", false));
            }
        }, hec.current());
    }

    public CompletionStage<Result> listCeEffMobs() {
        logger.debug("Fetching all CeEffMobs...");
        return cems.getAllCeEffMobs().thenApplyAsync(ceEffMobs -> {
            JsonNode jsonData = Json.toJson(ceEffMobs);
            logger.debug("Retrieved CeEffMob: {}", ceEffMobs.toString());
            return ok(ApplicationUtil.createResponse(jsonData, true));
        }, hec.current());
    }

    public CompletionStage<Result> delete(int id) {
        logger.debug("In CeEffMob.retrieve(), delete pathway with id: {}", id);
        return cems.deleteCeEffMob(id).thenApplyAsync(result -> {
            if (result) {
                return ok(ApplicationUtil.createResponse("CeEffMob with id: " + id + " deleted", true));
            } else {
                return notFound(ApplicationUtil.createResponse("CeEffMob with id: " + id + " not found", false));
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

        CeEffMob ceEffMob = Json.fromJson(json, CeEffMob.class);
        return cems.updateCeEffMob(ceEffMob, id).thenApplyAsync(result -> {
            if (result) {
                return ok(ApplicationUtil.createResponse(Json.toJson(ceEffMob), true));
            } else {
                return internalServerError(ApplicationUtil.createResponse("Error updating CeEffMob", false));
            }
        }, hec.current());
    }

    public CompletionStage<Result> listCeEffMobsInRange(int startId, int endId) {
        logger.debug("Fetching CeEffMob in range from {} to {}...", startId, endId);
        return cems.getCeEffMobInRange(startId, endId).thenApplyAsync(CeEffMobs -> {
            JsonNode jsonData = Json.toJson(CeEffMobs);
            logger.debug("Retrieved CeEffMob in range: {}", CeEffMobs.toString());
            return ok(ApplicationUtil.createResponse(jsonData, true));
        }, hec.current());
    }

    public CompletionStage<Result> patchCeEffMob(Http.Request request, int ceEffMobId) {
        JsonNode json = request.body().asJson();

        if (json == null || json.isEmpty()) {
            return CompletableFuture.completedFuture(
                    badRequest(ApplicationUtil.createResponse("Expecting non-empty JSON data", false))
            );
        }

        return cems.getCeEffMob(ceEffMobId).thenComposeAsync(existingCeEffMob -> {
            if (existingCeEffMob == null) {
                return CompletableFuture.completedFuture(notFound(ApplicationUtil.createResponse("CeEffMob not found", false)));
            }

            Iterator<Map.Entry<String, JsonNode>> fields = json.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                String fieldName = entry.getKey();
                JsonNode fieldValue = entry.getValue();

                switch (fieldName) {
                    case "ceCompoundId":
                        existingCeEffMob.setCeCompoundId(fieldValue.asInt());
                        break;
                    case "ceExpPropId":
                        existingCeEffMob.setCeExpPropId(fieldValue.asInt());
                        break;
                    case "cembioId":
                        existingCeEffMob.setCembioId(fieldValue.asInt());
                        break;
                    case "effMobility":
                        existingCeEffMob.setEffMobility(fieldValue.asDouble());
                        break;
                    case "created":
                        existingCeEffMob.setCreated(fieldValue.asText());
                        break;
                    case "lastUpdated":
                        existingCeEffMob.setLastUpdated(fieldValue.asText());
                        break;
                    default:
                        break;
                }
            }

            return cems.updateCeEffMob(existingCeEffMob, existingCeEffMob.getCeEffMobId()).thenApplyAsync(result -> {
                if (result) {
                    return ok(ApplicationUtil.createResponse(Json.toJson(existingCeEffMob), true));
                } else {
                    return internalServerError(ApplicationUtil.createResponse("Error updating CeEffMob", false));
                }
            }, hec.current());
        }, hec.current());
    }
}