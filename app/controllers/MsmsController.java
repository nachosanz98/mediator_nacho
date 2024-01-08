package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import entities.Msms;
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
import services.MsmsService;
import utils.ApplicationUtil;

import javax.inject.Inject;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;

public class MsmsController extends Controller {

    private static final Logger logger = LoggerFactory.getLogger("controller");
    private final FormFactory formFactory;
    private final MsmsService msmsService;
    private final HttpExecutionContext hec;
    private final DatabaseExecutionContext dec;

    @Inject
    public MsmsController(FormFactory formFactory, MsmsService msmsService, HttpExecutionContext hec, DatabaseExecutionContext dec) {
        this.formFactory = formFactory;
        this.msmsService = msmsService;
        this.hec = hec;
        this.dec = dec;
    }

    public CompletionStage<Result> retrieve(int id) {
        Executor myEc = HttpExecution.fromThread(dec);
        logger.debug("In MsmsController.retrieve(), retrieve pathway with id: {}", id);
        return msmsService.getMsms(id).thenApplyAsync(msms -> {
            if (msms != null) {
                return ok(ApplicationUtil.createResponse(Json.toJson(msms), true));
            } else {
                return notFound(ApplicationUtil.createResponse("Msms not found", false));
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

        Msms msms = Json.fromJson(json, Msms.class);
        return msmsService.addMsms(msms).thenApplyAsync(result -> {
            if (result) {
                return created(ApplicationUtil.createResponse(Json.toJson(msms), true));
            } else {
                return internalServerError(ApplicationUtil.createResponse("Error creating Msms", false));
            }
        }, hec.current());
    }

    public CompletionStage<Result> listMsms() {
        logger.debug("Fetching all msms...");
        return msmsService.getAllMsms().thenApplyAsync(msmsList -> {
            JsonNode jsonData = Json.toJson(msmsList);
            logger.debug("Retrieved msms: {}", msmsList.toString());
            return ok(ApplicationUtil.createResponse(jsonData, true));
        }, hec.current());
    }

    public CompletionStage<Result> delete(int id) {
        logger.debug("In MsmsController.retrieve(), delete pathway with id: {}", id);
        return msmsService.deleteMsms(id).thenApplyAsync(result -> {
            if (result) {
                return ok(ApplicationUtil.createResponse("Msms with id: " + id + " deleted", true));
            } else {
                return notFound(ApplicationUtil.createResponse("Msms with id: " + id + " not found", false));
            }
        }, hec.current());
    }

    public CompletionStage<Result> update(Http.Request request) {
        JsonNode json = request.body().asJson();

        if (json == null) {
            return CompletableFuture.completedFuture(
                    badRequest(ApplicationUtil.createResponse("Expecting JSON data", false))
            );
        }

        Msms msms = Json.fromJson(json, Msms.class);
        return msmsService.updateMsms(msms).thenApplyAsync(result -> {
            if (result) {
                return ok(ApplicationUtil.createResponse(Json.toJson(msms), true));
            } else {
                return internalServerError(ApplicationUtil.createResponse("Error updating Msms", false));
            }
        }, hec.current());
    }

    public CompletionStage<Result> listMsmsInRange(int startId, int endId) {
        logger.debug("Fetching msms in range from {} to {}...", startId, endId);
        return msmsService.getMsmsInRange(startId, endId).thenApplyAsync(msmsList -> {
            JsonNode jsonData = Json.toJson(msmsList);
            logger.debug("Retrieved msms in range: {}", msmsList.toString());
            return ok(ApplicationUtil.createResponse(jsonData, true));
        }, hec.current());
    }

    public CompletionStage<Result> patchMsms(Http.Request request, int msmsId) {
        JsonNode json = request.body().asJson();

        if (json == null || json.isEmpty()) {
            return CompletableFuture.completedFuture(
                    badRequest(ApplicationUtil.createResponse("Expecting non-empty JSON data", false))
            );
        }

        return msmsService.getMsms(msmsId).thenComposeAsync(existingMsms -> {
            if (existingMsms == null) {
                return CompletableFuture.completedFuture(notFound(ApplicationUtil.createResponse("Msms not found", false)));
            }

            Iterator<Map.Entry<String, JsonNode>> fields = json.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                String fieldName = entry.getKey();
                JsonNode fieldValue = entry.getValue();

                switch (fieldName) {
                    case "hmdbId":
                        existingMsms.setHmdbId(fieldValue.asText());
                        break;
                    case "voltage":
                        existingMsms.setVoltage(fieldValue.asInt());
                        break;
                    case "voltageLevel":
                        existingMsms.setVoltageLevel(fieldValue.asText());
                        break;
                    case "instrumentType":
                        existingMsms.setInstrumentType(fieldValue.asText());
                        break;
                    case "ionizationMode":
                        existingMsms.setIonizationMode(fieldValue.asInt());
                        break;
                    case "peakCount":
                        existingMsms.setPeakCount(fieldValue.asInt());
                        break;
                    case "compoundId":
                        existingMsms.setCompoundId(fieldValue.asInt());
                        break;
                    case "predicted":
                        existingMsms.setPredicted(fieldValue.asInt());
                        break;
                    case "created":
                        existingMsms.setCreated(fieldValue.asText());
                        break;
                    case "lastUpdated":
                        existingMsms.setLastUpdated(fieldValue.asText());
                        break;
                    default:
                        break;
                }
            }

            return msmsService.updateMsms(existingMsms).thenApplyAsync(result -> {
                if (result) {
                    return ok(ApplicationUtil.createResponse(Json.toJson(existingMsms), true));
                } else {
                    return internalServerError(ApplicationUtil.createResponse("Error updating Msms", false));
                }
            }, hec.current());
        }, hec.current());
    }
}
