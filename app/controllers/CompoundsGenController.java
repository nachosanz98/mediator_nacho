package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import entities.CompoundsGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.data.FormFactory;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Http;
import play.mvc.Result;
import services.CompoundsGenService;
import services.DatabaseExecutionContext;
import utils.ApplicationUtil;

import javax.inject.Inject;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static play.mvc.Results.*;

public class CompoundsGenController {
    private static final Logger logger = LoggerFactory.getLogger("controller");
    private final FormFactory formFactory;
    private final CompoundsGenService cgs;
    private final HttpExecutionContext hec;
    private final DatabaseExecutionContext dec;

    @Inject
    public CompoundsGenController(FormFactory formFactory, CompoundsGenService cgs, HttpExecutionContext hec, DatabaseExecutionContext dec) {
        this.formFactory = formFactory;
        this.cgs = cgs;
        this.hec = hec;
        this.dec = dec;
    }

    public CompletionStage<Result> retrieve(int id) {
        logger.debug("In CompoundsGenController.retrieve(), retrieve CompoundsGen with id: {}", id);
        return cgs.getCompoundsGen(id).thenApplyAsync(compoundsGen ->
                {
                    return ok(ApplicationUtil.createResponse(Json.toJson(compoundsGen), true));
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

        CompoundsGen compoundsGen = Json.fromJson(json, CompoundsGen.class);
        return cgs.addCompoundsGen(compoundsGen).thenApplyAsync(result -> {
            if (result) {
                return created(ApplicationUtil.createResponse(Json.toJson(compoundsGen), true));
            } else {
                return internalServerError(ApplicationUtil.createResponse("Error creating CompoundsGen", false));
            }
        }, hec.current());
    }

    public CompletionStage<Result> listCompoundsGen() {
        logger.debug("Fetching all CompoundsGen...");
        return cgs.getAllCompoundsGen().thenApplyAsync(compoundsGenList -> {
            JsonNode jsonData = Json.toJson(compoundsGenList);
            logger.debug("Retrieved CompoundsGen: {}", compoundsGenList.toString());
            return ok(ApplicationUtil.createResponse(jsonData, true));
        }, hec.current());
    }

    public CompletionStage<Result> delete(int id) {
        logger.debug("Attempting to delete CompoundsGen with id: {}", id);
        return cgs.deleteCompoundsGen(id).thenApplyAsync(result -> {
            if (result) {
                return ok(ApplicationUtil.createResponse("CompoundsGen with id: " + id + " deleted", true));
            } else {
                return notFound(ApplicationUtil.createResponse("CompoundsGen with id: " + id + " not found", false));
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

        CompoundsGen compoundsGen = Json.fromJson(json, CompoundsGen.class);
        return cgs.updateCompoundsGen(compoundsGen, id).thenApplyAsync(result -> {
            if (result) {
                return ok(ApplicationUtil.createResponse(Json.toJson(compoundsGen), true));
            } else {
                return internalServerError(ApplicationUtil.createResponse("Error updating CompoundsGen", false));
            }
        }, hec.current());
    }

    public CompletionStage<Result> listCompoundsGenInRange(int startId, int endId) {
        logger.debug("Fetching CompoundsGen in range from {} to {}...", startId, endId);
        return cgs.getCompoundsGenInRange(startId, endId).thenApplyAsync(compoundsGenList -> {
            JsonNode jsonData = Json.toJson(compoundsGenList);
            logger.debug("Retrieved CompoundsGen in range: {}", compoundsGenList.toString());
            return ok(ApplicationUtil.createResponse(jsonData, true));
        }, hec.current());
    }

    public CompletionStage<Result> patchCompoundsGen(Http.Request request, int compoundsGenId) {
        JsonNode json = request.body().asJson();

        if (json == null || json.isEmpty()) {
            return CompletableFuture.completedFuture(
                    badRequest(ApplicationUtil.createResponse("Expecting non-empty JSON data", false))
            );
        }

        return cgs.getCompoundsGen(compoundsGenId).thenComposeAsync(existingCompoundsGen -> {
            if (existingCompoundsGen == null) {
                return CompletableFuture.completedFuture(notFound(ApplicationUtil.createResponse("CompoundsGen not found", false)));
            }

            Iterator<Map.Entry<String, JsonNode>> fields = json.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                String fieldName = entry.getKey();
                JsonNode fieldValue = entry.getValue();

                switch (fieldName) {

                    case "mineID":
                        existingCompoundsGen.setMineId(fieldValue.asText());
                        break;
                    case "mineFileID":
                        existingCompoundsGen.setMineFileId(fieldValue.asText());
                        break;
                    case "formula":
                        existingCompoundsGen.setFormula(fieldValue.asText());
                        break;
                    case "mass":
                        existingCompoundsGen.setMass(fieldValue.asDouble());
                        break;
                    case "charge_type":
                        existingCompoundsGen.setChargeType(fieldValue.asInt());
                        break;
                    case "charge_number":
                        existingCompoundsGen.setChargeNumber(fieldValue.asInt());
                        break;
                    case "npLikeness":
                        existingCompoundsGen.setNpLikeness(fieldValue.asDouble());
                        break;
                    case "formula_type":
                        existingCompoundsGen.setFormulaType(fieldValue.asText());
                        break;
                    case "formula_type_int":
                        existingCompoundsGen.setFormulaTypeInt(fieldValue.asInt());
                        break;
                    case "created":
                        existingCompoundsGen.setCreated(fieldValue.asText());
                        break;
                    case "lastUpdated":
                        existingCompoundsGen.setLastUpdated(fieldValue.asText());
                        break;
                    case "inchi":
                        existingCompoundsGen.setInchi(fieldValue.asText());
                    case "inchi_key":
                        existingCompoundsGen.setInchiKey(fieldValue.asText());
                    case "smiles":
                        existingCompoundsGen.setSmiles(fieldValue.asText());
                        break;
                    case "createdIdentifier":
                        existingCompoundsGen.setCreatedIden(fieldValue.asText());
                        break;
                    case "lastUpdatedIdentifier":
                        existingCompoundsGen.setLastUpdatedIden(fieldValue.asText());
                        break;
                    default:
                        break;
                }
            }

            return cgs.updateCompoundsGen(existingCompoundsGen, existingCompoundsGen.getCompoundId()).thenApplyAsync(result -> {
                if (result) {
                    return ok(ApplicationUtil.createResponse(Json.toJson(existingCompoundsGen), true));
                } else {
                    return internalServerError(ApplicationUtil.createResponse("Error updating Chain", false));
                }
            }, hec.current());
        }, hec.current());
    }
}
