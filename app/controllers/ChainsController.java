package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import entities.Chains;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.data.FormFactory;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.ChainsService;
import services.DatabaseExecutionContext;
import utils.ApplicationUtil;

import javax.inject.Inject;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class ChainsController extends Controller {

    private static final Logger logger = LoggerFactory.getLogger("controller");
    private final FormFactory formFactory;
    private final ChainsService chs;
    private final HttpExecutionContext hec;
    private final DatabaseExecutionContext dec;

    @Inject
    public ChainsController(FormFactory formFactory, ChainsService chs, HttpExecutionContext hec, DatabaseExecutionContext dec) {
        this.formFactory = formFactory;
        this.chs = chs;
        this.hec = hec;
        this.dec = dec;
    }

    public CompletionStage<Result> retrieve(int id) {
        logger.debug("In ChainController.retrieve(), retrieve Chain with id: {}", id);
        return chs.getChains(id).thenApplyAsync(chains ->
                {
                    return ok(ApplicationUtil.createResponse(Json.toJson(chains), true));
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

        Chains chains = Json.fromJson(json, Chains.class);
        return chs.addChains(chains).thenApplyAsync(result -> {
            if (result) {
                return created(ApplicationUtil.createResponse(Json.toJson(chains), true));
            } else {
                return internalServerError(ApplicationUtil.createResponse("Error creating Chains", false));
            }
        }, hec.current());
    }

    public CompletionStage<Result> listChains() {
        logger.debug("Fetching all Chains...");
        return chs.getAllChains().thenApplyAsync(chainsList -> {
            JsonNode jsonData = Json.toJson(chainsList);
            logger.debug("Retrieved Chains: {}", chainsList.toString());
            return ok(ApplicationUtil.createResponse(jsonData, true));
        }, hec.current());
    }

    public CompletionStage<Result> delete(int id) {
        logger.debug("Attempting to delete Chains with id: {}", id);
        return chs.deleteChains(id).thenApplyAsync(result -> {
            if (result) {
                return ok(ApplicationUtil.createResponse("Chains with id: " + id + " deleted", true));
            } else {
                return notFound(ApplicationUtil.createResponse("Chains with id: " + id + " not found", false));
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

        Chains chains = Json.fromJson(json, Chains.class);
        return chs.updateChains(chains, id).thenApplyAsync(result -> {
            if (result) {
                return ok(ApplicationUtil.createResponse(Json.toJson(chains), true));
            } else {
                return internalServerError(ApplicationUtil.createResponse("Error updating Chains", false));
            }
        }, hec.current());
    }

    public CompletionStage<Result> listChainsInRange(int startId, int endId) {
        logger.debug("Fetching Chains in range from {} to {}...", startId, endId);
        return chs.getChainsInRange(startId, endId).thenApplyAsync(chainsList -> {
            JsonNode jsonData = Json.toJson(chainsList);
            logger.debug("Retrieved Chains in range: {}", chainsList.toString());
            return ok(ApplicationUtil.createResponse(jsonData, true));
        }, hec.current());
    }

    public CompletionStage<Result> patchChains(Http.Request request, int chainsId) {
        JsonNode json = request.body().asJson();

        if (json == null || json.isEmpty()) {
            return CompletableFuture.completedFuture(
                    badRequest(ApplicationUtil.createResponse("Expecting non-empty JSON data", false))
            );
        }

        return chs.getChains(chainsId).thenComposeAsync(existingChains -> {
            if (existingChains == null) {
                return CompletableFuture.completedFuture(notFound(ApplicationUtil.createResponse("Chains not found", false)));
            }

            Iterator<Map.Entry<String, JsonNode>> fields = json.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                String fieldName = entry.getKey();
                JsonNode fieldValue = entry.getValue();

                switch (fieldName) {
                    case "numCarbons":
                        existingChains.setNumCarbons(fieldValue.asInt());
                        break;
                    case "doubleBonds":
                        existingChains.setDoubleBonds(fieldValue.asInt());
                        break;
                    case "oxidation":
                        existingChains.setOxidation(fieldValue.asText());
                        break;
                    case "mass":
                        existingChains.setMass(fieldValue.asDouble());
                        break;
                    case "formula":
                        existingChains.setFormula(fieldValue.asText());
                        break;
                    case "created":
                        existingChains.setCreated(fieldValue.asText());
                        break;
                    case "lastUpdated":
                        existingChains.setLastUpdated(fieldValue.asText());
                        break;
                    default:
                        break;
                }
            }

            return chs.updateChains(existingChains, existingChains.getChainsId()).thenApplyAsync(result -> {
                if (result) {
                    return ok(ApplicationUtil.createResponse(Json.toJson(existingChains), true));
                } else {
                    return internalServerError(ApplicationUtil.createResponse("Error updating Chain", false));
                }
            }, hec.current());
        }, hec.current());
    }
}