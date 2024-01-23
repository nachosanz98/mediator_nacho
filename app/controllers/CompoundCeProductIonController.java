package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import entities.CompoundCeProductIon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.data.FormFactory;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.CompoundCeProductIonService;
import services.DatabaseExecutionContext;
import utils.ApplicationUtil;

import javax.inject.Inject;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class CompoundCeProductIonController extends Controller {
    private static final Logger logger = LoggerFactory.getLogger("controller");
    private final FormFactory formFactory;
    private final CompoundCeProductIonService ccpi;
    private final HttpExecutionContext hec;
    private final DatabaseExecutionContext dec;

    @Inject
    public CompoundCeProductIonController(FormFactory formFactory, CompoundCeProductIonService ccpi,
                                       HttpExecutionContext hec, DatabaseExecutionContext dec) {
        this.formFactory = formFactory;
        this.ccpi = ccpi;
        this.hec = hec;
        this.dec = dec;
    }

    public CompletionStage<Result> retrieve(int id) {
        logger.debug("In CompoundCeProductIonController.retrieve(), retrieve ion with id: {}", id);
        return ccpi.getCompoundCeProductIon(id).thenApplyAsync(compoundCeProductIon -> {
            if (compoundCeProductIon != null) {
                return ok(ApplicationUtil.createResponse(Json.toJson(compoundCeProductIon), true));
            } else {
                return notFound(ApplicationUtil.createResponse("CompoundCeProductIon with id " + id + " not found", false));
            }
        }, hec.current());
    }

    public CompletionStage<Result> create(Http.Request request) {
        JsonNode json = request.body().asJson();
        if (json == null) {
            return CompletableFuture.completedFuture(
                    badRequest(ApplicationUtil.createResponse("Expecting JSON data", false)));
        }

        CompoundCeProductIon compoundCeProductIon = Json.fromJson(json, CompoundCeProductIon.class);
        return ccpi.addCompoundCeProductIon(compoundCeProductIon).thenApplyAsync(result -> {
            if (result) {
                return created(ApplicationUtil.createResponse(Json.toJson(compoundCeProductIon), true));
            } else {
                return internalServerError(
                        ApplicationUtil.createResponse("Error creating CompoundCeProductIon", false));
            }
        }, hec.current());
    }

    public CompletionStage<Result> listCompoundCeProductIon() {
        logger.debug("Fetching all CompoundCeProductIons...");
        return ccpi.getAllCompoundCeProductIon().thenApplyAsync(compoundCeProductIonList -> {
            JsonNode jsonData = Json.toJson(compoundCeProductIonList);
            logger.debug("Retrieved CompoundCeProductIons: {}", compoundCeProductIonList.toString());
            return ok(ApplicationUtil.createResponse(jsonData, true));
        }, hec.current());
    }

    public CompletionStage<Result> delete(int id) {
        logger.debug("Attempting to delete CompoundCeProductIon with id: {}", id);
        return ccpi.deleteCompoundCeProductIon(id).thenApplyAsync(result -> {
            if (result) {
                return ok(ApplicationUtil.createResponse("CompoundCeProductIon with id: " + id + " deleted", true));
            } else {
                return notFound(ApplicationUtil.createResponse("CompoundCeProductIon with id: " + id + " not found", false));
            }
        }, hec.current());
    }

    public CompletionStage<Result> update(Http.Request request, int id) {
        JsonNode json = request.body().asJson();
        if (json == null) {
            return CompletableFuture.completedFuture(badRequest(ApplicationUtil.createResponse("Expecting JSON data", false)));
        }

        CompoundCeProductIon updatedCompoundCeProductIon = Json.fromJson(json, CompoundCeProductIon.class);
        return ccpi.updateCompoundCeProductIon(updatedCompoundCeProductIon, id).thenApplyAsync(result -> {
            if (result) {
                return ok(ApplicationUtil.createResponse(Json.toJson(updatedCompoundCeProductIon), true));
            } else {
                return internalServerError(ApplicationUtil.createResponse("Error updating CompoundCeProductIon", false));
            }
        }, hec.current());
    }

    public CompletionStage<Result> listCompoundCeProductIonInRange(int startId, int endId) {
        logger.debug("Fetching CompoundCeProductIons in range from {} to {}", startId, endId);
        return ccpi.getCompoundCeProductIonInRange(startId, endId).thenApplyAsync(compoundCeProductIonList -> {
            JsonNode jsonData = Json.toJson(compoundCeProductIonList);
            logger.debug("Retrieved CompoundCeProductIons in range: {}", compoundCeProductIonList.toString());
            return ok(ApplicationUtil.createResponse(jsonData, true));
        }, hec.current());
    }

    public CompletionStage<Result> patchCompoundCeProductIon(Http.Request request, int id) {
        JsonNode json = request.body().asJson();
        if (json == null || json.isEmpty()) {
            return CompletableFuture.completedFuture(badRequest(ApplicationUtil.createResponse("Expecting non-empty JSON data", false)));
        }

        return ccpi.getCompoundCeProductIon(id).thenComposeAsync(existingIon -> {
            if (existingIon == null) {
                return CompletableFuture.completedFuture(notFound(ApplicationUtil.createResponse("CompoundCeProductIon not found", false)));
            }

            Iterator<Map.Entry<String, JsonNode>> fields = json.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                String fieldName = entry.getKey();
                JsonNode fieldValue = entry.getValue();

                switch (fieldName) {
                    case "ionSourceVoltage":
                        existingIon.setIonSourceVoltage(fieldValue.asInt());
                        break;
                    case "ceProductIonMz":
                        existingIon.setCeProductIonMz(fieldValue.asDouble());
                        break;
                    case "ceProductIonIntensity":
                        existingIon.setCeProductIonIntensity(fieldValue.asDouble());
                        break;
                    case "ceTransformationType":
                        existingIon.setCeTransformationType(fieldValue.asText());
                        break;
                    case "ceProductIonName":
                        existingIon.setCeProductIonName(fieldValue.asText());
                        break;
                    case "ceEffMobId":
                        existingIon.setCeEffMobId(fieldValue.asInt());
                        break;
                    case "compoundIdOwn":
                        existingIon.setCompoundIdOwn(fieldValue.asInt());
                        break;
                    case "created":
                        existingIon.setCreated(fieldValue.asText());
                        break;
                    case "lastUpdated":
                        existingIon.setLastUpdated(fieldValue.asText());
                        break;
                    default:
                        break;
                }
            }

            return ccpi.updateCompoundCeProductIon(existingIon, id).thenApplyAsync(result -> {
                if (result) {
                    return ok(ApplicationUtil.createResponse(Json.toJson(existingIon), true));
                } else {
                    return internalServerError(ApplicationUtil.createResponse("Error patching CompoundCeProductIon", false));
                }
            }, hec.current());
        }, hec.current());
    }
}
