package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import entities.CeExpPropMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.data.FormFactory;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.CeExpPropMetadataService;
import services.DatabaseExecutionContext;
import utils.ApplicationUtil;

import javax.inject.Inject;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class CeExpPropMetadataController extends Controller {
    private static final Logger logger = LoggerFactory.getLogger("controller");
    private final FormFactory formFactory;
    private final CeExpPropMetadataService cepm;
    private final HttpExecutionContext hec;
    private final DatabaseExecutionContext dec;

    @Inject
    public CeExpPropMetadataController(FormFactory formFactory, CeExpPropMetadataService cepm,
                                       HttpExecutionContext hec, DatabaseExecutionContext dec) {
        this.formFactory = formFactory;
        this.cepm = cepm;
        this.hec = hec;
        this.dec = dec;
    }

    public CompletionStage<Result> retrieve(int id) {
        logger.debug("In CeExpPropMetadataController.retrieve(), retrieve metadata with id: {}", id);
        return cepm.getCeExpPropMetadata(id).thenApplyAsync(ceExpPropMetadata -> {
            if (ceExpPropMetadata != null) {
                return ok(ApplicationUtil.createResponse(Json.toJson(ceExpPropMetadata), true));
            } else {
                return notFound("Ce Experimental Properties Metadata with id " + id + " not found");
            }
        }, hec.current());
    }

    public CompletionStage<Result> create(Http.Request request) {
        JsonNode json = request.body().asJson();
        if (json == null) {
            return CompletableFuture.completedFuture(
                    badRequest(ApplicationUtil.createResponse("Expecting JSON data", false)));
        }

        CeExpPropMetadata ceExpPropMetadata = Json.fromJson(json, CeExpPropMetadata.class);
        return cepm.addCeExpPropMetadata(ceExpPropMetadata).thenApplyAsync(result -> {
            if (result) {
                return created(ApplicationUtil.createResponse(Json.toJson(ceExpPropMetadata), true));
            } else {
                return internalServerError(ApplicationUtil.createResponse("Error creating Ce Experimental Properties Metadata", false));
            }
        }, hec.current());
    }

    public CompletionStage<Result> listCeExpPropMetadata() {
        logger.debug("Fetching all Ce Experimental Properties Metadata...");
        return cepm.getAllCeExpPropMetadata().thenApplyAsync(ceExpPropMetadataList -> {
            JsonNode jsonData = Json.toJson(ceExpPropMetadataList);
            logger.debug("Retrieved Ce Experimental Properties Metadata: {}", ceExpPropMetadataList.toString());
            return ok(ApplicationUtil.createResponse(jsonData, true));
        }, hec.current());
    }

    public CompletionStage<Result> delete(int id) {
        logger.debug("Attempting to delete Ce Experimental Properties Metadata with id: {}", id);
        return cepm.deleteCeExpPropMetadata(id).thenApplyAsync(result -> {
            if (result) {
                return ok(ApplicationUtil.createResponse("Ce Experimental Properties Metadata with id: " + id + " deleted", true));
            } else {
                return notFound(ApplicationUtil.createResponse("Ce Experimental Properties Metadata with id: " + id + " not found", false));
            }
        }, hec.current());
    }

    public CompletionStage<Result> update(Http.Request request, int id) {
        JsonNode json = request.body().asJson();
        if (json == null) {
            return CompletableFuture.completedFuture(
                    badRequest(ApplicationUtil.createResponse("Expecting JSON data", false)));
        }

        CeExpPropMetadata updatedCeExpPropMetadata = Json.fromJson(json, CeExpPropMetadata.class);
        return cepm.updateCeExpPropMetadata(updatedCeExpPropMetadata, id).thenApplyAsync(result -> {
            if (result) {
                return ok(ApplicationUtil.createResponse(Json.toJson(updatedCeExpPropMetadata), true));
            } else {

                return internalServerError(ApplicationUtil.createResponse("Error updating Ce Experimental Properties Metadata", false));
            }
        }, hec.current());
    }

    public CompletionStage<Result> listCeExpPropMetadataInRange(int startId, int endId) {
        logger.debug("Fetching Ce Experimental Properties Metadata in range from {} to {}", startId, endId);
        return cepm.getCeExpPropMetadataInRange(startId, endId).thenApplyAsync(ceExpPropMetadataList -> {
            JsonNode jsonData = Json.toJson(ceExpPropMetadataList);
            logger.debug("Retrieved Ce Experimental Properties Metadata in range: {}", ceExpPropMetadataList.toString());
            return ok(ApplicationUtil.createResponse(jsonData, true));
        }, hec.current());
    }

    public CompletionStage<Result> patchCeExpPropMetadata(Http.Request request, int id) {
        JsonNode json = request.body().asJson();
        if (json == null || json.isEmpty()) {
            return CompletableFuture.completedFuture(badRequest("Expecting non-empty JSON data"));
        }

        return cepm.getCeExpPropMetadata(id).thenComposeAsync(existingMetadata -> {
            if (existingMetadata == null) {
                return CompletableFuture.completedFuture(notFound("Ce Experimental Properties Metadata not found"));
            }

            Iterator<Map.Entry<String, JsonNode>> fields = json.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                String fieldName = entry.getKey();
                JsonNode fieldValue = entry.getValue();

                switch (fieldName) {
                    case "ceEffMobId":
                        existingMetadata.setCeEffMobId(fieldValue.asInt());
                        break;
                    case "experimentalMz":
                        existingMetadata.setExperimentalMz(fieldValue.asDouble());
                        break;
                    case "ceIdentificationLevel":
                        existingMetadata.setCeIdentificationLevel(fieldValue.asInt());
                        break;
                    case "ceSampleType":
                        existingMetadata.setCeSampleType(fieldValue.asInt());
                        break;
                    case "capillaryLength":
                        existingMetadata.setCapillaryLength(fieldValue.asInt());
                        break;
                    case "capillaryVoltage":
                        existingMetadata.setCapillaryVoltage(fieldValue.asInt());
                        break;
                    case "bgeCompoundId":
                        existingMetadata.setBgeCompoundId(fieldValue.asInt());
                        break;
                    case "absoluteMT":
                        existingMetadata.setAbsoluteMT(fieldValue.asDouble());
                        break;
                    case "relativeMT":
                        existingMetadata.setRelativeMT(fieldValue.asDouble());
                        break;
                    case "commercial":
                        existingMetadata.setCommercial(fieldValue.asText());
                        break;
                    case "created":
                        existingMetadata.setCreated(fieldValue.asText());
                        break;
                    case "lastUpdated":
                        existingMetadata.setLastUpdated(fieldValue.asText());
                        break;
                    default:
                        break;
                }
            }

            return cepm.updateCeExpPropMetadata(existingMetadata, id).thenApplyAsync(result -> {
                if (result) {
                    return ok(Json.toJson(existingMetadata));
                } else {
                    return internalServerError("Error updating Ce Experimental Properties Metadata");
                }
            }, hec.current());
        }, hec.current());
    }
}
