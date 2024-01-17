package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import entities.Compound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.data.FormFactory;
import play.libs.Json;
import play.libs.concurrent.HttpExecution;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.CompoundService;
import services.DatabaseExecutionContext;
import utils.ApplicationUtil;

import javax.inject.Inject;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;

public class CompoundController extends Controller {

    private static final Logger logger = LoggerFactory.getLogger("controller");
    private final FormFactory formFactory;
    private final CompoundService cdb;
    private final HttpExecutionContext hec;
    private final DatabaseExecutionContext dec;

    @Inject
    public CompoundController(FormFactory formFactory, CompoundService compoundDBService, HttpExecutionContext hec, DatabaseExecutionContext dec){
        this.formFactory=formFactory;
        this.cdb =compoundDBService;
        this.hec=hec;
        this.dec=dec;
    }

    public CompletionStage<Result> retrieve(int id) {

        Executor myEc = HttpExecution.fromThread(dec);
        logger.debug("In CompoundController.retrieve(), retrieve compound with id: {}",id);

        return cdb.getCompound(id).thenApplyAsync(compound ->
                {
                    return ok(ApplicationUtil.createResponse(Json.toJson(compound), true));
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

        Compound compound = Json.fromJson(json, Compound.class);
        return cdb.addCompound(compound).thenApplyAsync(result -> {
            if (result) {
                return created(ApplicationUtil.createResponse(Json.toJson(compound), true));
            } else {
                return internalServerError(ApplicationUtil.createResponse("Error creating compound", false));
            }
        }, hec.current());
    }

    public CompletionStage<Result> listCompounds() {
        logger.debug("Fetching all compounds...");
        return cdb.getAllCompounds().thenApplyAsync(compounds -> {
            JsonNode jsonData = Json.toJson(compounds);
            logger.debug("Retrieved compounds: {}", compounds.toString());
            return ok(ApplicationUtil.createResponse(jsonData, true));
        }, hec.current());
    }

    public CompletionStage<Result> delete(int id) {
        logger.debug("In CompoundController.retrieve(), delete compound with id: {}", id);
        return cdb.deleteCompound(id).thenApplyAsync(result -> {
            if (result) {
                return ok(ApplicationUtil.createResponse("Compound with id: " + id + " deleted", true));
            } else {
                return notFound(ApplicationUtil.createResponse("Compound with id: " + id + " not found", false));
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

        Compound compound = Json.fromJson(json, Compound.class);
        return cdb.updateCompound(compound, id).thenApplyAsync(result -> {
            if (result) {
                return ok(ApplicationUtil.createResponse(Json.toJson(compound), true));
            } else {
                return internalServerError(ApplicationUtil.createResponse("Error updating compound", false));
            }
        }, hec.current());
    }


    public CompletionStage<Result> patchCompound(Http.Request request, int compoundId) {
        JsonNode json = request.body().asJson();

        if (json == null || json.isEmpty()) {
            return CompletableFuture.completedFuture(
                    badRequest(ApplicationUtil.createResponse("Expecting non-empty JSON data", false))
            );
        }

        return cdb.getCompound(compoundId).thenComposeAsync(existingCompound -> {
            if (existingCompound == null) {
                return CompletableFuture.completedFuture(notFound(ApplicationUtil.createResponse("Compound not found", false)));
            }

            Iterator<Map.Entry<String, JsonNode>> fields = json.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                String fieldName = entry.getKey();
                JsonNode fieldValue = entry.getValue();

                switch (fieldName) {
                    case "casId":
                        existingCompound.setCasId(fieldValue.asText());
                        break;
                    case "compoundName":
                        existingCompound.setCompoundName(fieldValue.asText());
                        break;
                    case "formula":
                        existingCompound.setFormula(fieldValue.asText());
                        break;
                    case "mass":
                        existingCompound.setMass(fieldValue.asDouble());
                        break;
                    case "chargeType":
                        existingCompound.setChargeType(fieldValue.asInt());
                        break;
                    case "chargeNumber":
                        existingCompound.setChargeNumber(fieldValue.asInt());
                        break;
                    case "formulaType":
                        existingCompound.setFormulaType(fieldValue.asText());
                        break;
                    case "compoundType":
                        existingCompound.setCompoundType(fieldValue.asInt());
                        break;
                    case "compoundStatus":
                        existingCompound.setCompoundStatus(fieldValue.asInt());
                        break;
                    case "created":
                        existingCompound.setCreated(fieldValue.asText());
                        break;
                    case "lastUpdated":
                        existingCompound.setLastUpdated(fieldValue.asText());
                        break;
                    case "formulaTypeInt":
                        existingCompound.setFormulaTypeInt(fieldValue.asInt());
                        break;
                    case "logP":
                        existingCompound.setLogP(fieldValue.asDouble());
                        break;
                    default:
                        break;
                }
            }

            return cdb.updateCompound(existingCompound, existingCompound.getCompoundId()).thenApplyAsync(result -> {
                if (result) {
                    return ok(ApplicationUtil.createResponse(Json.toJson(existingCompound), true));
                } else {
                    return internalServerError(ApplicationUtil.createResponse("Error updating compound", false));
                }
            }, hec.current());
        }, hec.current());
    }

    public CompletionStage<Result> listCompoundsInRange(int startId, int endId) {
        logger.debug("Fetching compounds in range from {} to {}...", startId, endId);
        return cdb.getCompoundsInRange(startId, endId).thenApplyAsync(compounds -> {
            JsonNode jsonData = Json.toJson(compounds);
            logger.debug("Retrieved compounds in range: {}", compounds.toString());
            return ok(ApplicationUtil.createResponse(jsonData, true));
        }, hec.current());
    }
}