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

        return cdb.getCompound(id).thenApplyAsync(compound -> {
            if (compound != null) {
                return ok(ApplicationUtil.createResponse(Json.toJson(compound), true));
            } else {
                return notFound(ApplicationUtil.createResponse("Compound not found", false));
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
                    case "smiles":
                        existingCompound.setSmiles(fieldValue.asText());
                        break;
                    case "createdIdentifier":
                        existingCompound.setCreatedIdentifier(fieldValue.asText());
                        break;
                    case "lastUpdatedIdentifier":
                        existingCompound.setLastUpdatedIdentifier(fieldValue.asText());
                        break;
                    case "agilent_id":
                        existingCompound.setAgilentId(fieldValue.asInt());
                        break;
                    case "createdAgilent":
                        existingCompound.setCreatedAgilent(fieldValue.asText());
                        break;
                    case "lastUpdatedAgilent":
                        existingCompound.setLastUpdatedAgilent(fieldValue.asText());
                        break;
                    case "chebiId":
                        existingCompound.setChebiId(fieldValue.asInt());
                        break;
                    case "createdChebi":
                        existingCompound.setCreatedChebi(fieldValue.asText());
                        break;
                    case "lastUpdatedChebi":
                        existingCompound.setLastUpdatedChebi(fieldValue.asText());
                        break;
                    case "mineID":
                        existingCompound.setMineID(fieldValue.asInt());
                        break;
                    case "mineFileID":
                        existingCompound.setMineFileID(fieldValue.asText());
                        break;
                    case "npLikeness":
                        existingCompound.setNpLikeness(fieldValue.asDouble());
                        break;
                    case "createdGen":
                        existingCompound.setCreatedGen(fieldValue.asText());
                        break;
                    case "lastUpdatedGen":
                        existingCompound.setLastUpdatedGen(fieldValue.asText());
                        break;
                    case "hmdbId":
                        existingCompound.setHmdbId(fieldValue.asInt());
                        break;
                    case "createdHmdb":
                        existingCompound.setCreatedHmdb(fieldValue.asText());
                        break;
                    case "lastUpdatedHmdb":
                        existingCompound.setLastUpdatedHmdb(fieldValue.asText());
                        break;
                    case "inHouseID":
                        existingCompound.setInHouseID(fieldValue.asInt());
                        break;
                    case "sourceData":
                        existingCompound.setSourceData(fieldValue.asText());
                        break;
                    case "description":
                        existingCompound.setDescription(fieldValue.asText());
                        break;
                    case "createdInHouse":
                        existingCompound.setCreatedInHouse(fieldValue.asText());
                        break;
                    case "lastUpdatedInHouse":
                        existingCompound.setLastUpdatedInHouse(fieldValue.asText());
                        break;
                    case "keggId":
                        existingCompound.setKeggId(fieldValue.asInt());
                        break;
                    case "createdKegg":
                        existingCompound.setCreatedKegg(fieldValue.asText());
                        break;
                    case "lastUpdatedKegg":
                        existingCompound.setLastUpdatedKegg(fieldValue.asText());
                        break;
                    case "lipidType":
                        existingCompound.setLipidType(fieldValue.asText());
                        break;
                    case "numChains":
                        existingCompound.setNumChains(fieldValue.asInt());
                        break;
                    case "numCarbons":
                        existingCompound.setNumCarbons(fieldValue.asInt());
                        break;
                    case "doubleBonds":
                        existingCompound.setDoubleBonds(fieldValue.asInt());
                        break;
                    case "createdLipid":
                        existingCompound.setCreatedLipid(fieldValue.asText());
                        break;
                    case "lastUpdatedLipid":
                        existingCompound.setLastUpdatedLipid(fieldValue.asText());
                        break;
                    case "lmId":
                        existingCompound.setLmId(fieldValue.asInt());
                        break;
                    case "createdLm":
                        existingCompound.setCreatedLm(fieldValue.asText());
                        break;
                    case "lastUpdatedLm":
                        existingCompound.setLastUpdatedLm(fieldValue.asText());
                        break;
                    case "category":
                        existingCompound.setCategory(fieldValue.asText());
                        break;
                    case "mainClass":
                        existingCompound.setMainClass(fieldValue.asText());
                        break;
                    case "subClass":
                        existingCompound.setSubClass(fieldValue.asText());
                        break;
                    case "classLevel4":
                        existingCompound.setClassLevel4(fieldValue.asText());
                        break;
                    case "createdLmClassification":
                        existingCompound.setCreatedLmClassification(fieldValue.asText());
                        break;
                    case "lastUpdatedLmClassification":
                        existingCompound.setLastUpdatedLmClassification(fieldValue.asText());
                        break;
                    case "pcId":
                        existingCompound.setPcId(fieldValue.asInt());
                        break;
                    case "createdPc":
                        existingCompound.setCreatedPc(fieldValue.asText());
                        break;
                    case "lastUpdatedPc":
                        existingCompound.setLastUpdatedPc(fieldValue.asText());
                        break;
                    case "reactionId":
                        existingCompound.setReactionId(fieldValue.asInt());
                        break;
                    case "createdReaction":
                        existingCompound.setCreatedReaction(fieldValue.asText());
                        break;
                    case "lastUpdatedReaction":
                        existingCompound.setLastUpdatedReaction(fieldValue.asText());
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