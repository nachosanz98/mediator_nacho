package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import entities.CompoundChain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.data.FormFactory;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.CompoundChainService;
import services.DatabaseExecutionContext;
import utils.ApplicationUtil;

import javax.inject.Inject;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class CompoundChainController extends Controller {
    private static final Logger logger = LoggerFactory.getLogger("controller");
    private final FormFactory formFactory;
    private final CompoundChainService ccs;
    private final HttpExecutionContext hec;
    private final DatabaseExecutionContext dec;

    @Inject
    public CompoundChainController(FormFactory formFactory, CompoundChainService ccs,
                                   HttpExecutionContext hec, DatabaseExecutionContext dec) {
        this.formFactory = formFactory;
        this.ccs = ccs;
        this.hec = hec;
        this.dec = dec;
    }

    public CompletionStage<Result> retrieve(int compoundId, int chainId) {
        logger.debug("Retrieving CompoundChain with compoundId: {} and chainId: {}", compoundId, chainId);
        return ccs.getCompoundChain(compoundId, chainId).thenApplyAsync(compoundChain -> {
            if (compoundChain != null) {
                return ok(Json.toJson(compoundChain));
            } else {;
                return notFound("CompoundChain with compoundId " + compoundId + " and chainId " + chainId + " not found");
            }
        }, hec.current());
    }

    public CompletionStage<Result> create(Http.Request request) {
        JsonNode json = request.body().asJson();
        if (json == null) {
            return CompletableFuture.completedFuture(badRequest("Expecting JSON data"));
        }

        CompoundChain compoundChain = Json.fromJson(json, CompoundChain.class);
        return ccs.addCompoundChain(compoundChain).thenApplyAsync(result -> {
            if (result) {
                return created(Json.toJson(compoundChain));
            } else {
                return internalServerError("Error creating CompoundChain");
            }
        }, hec.current());
    }

    public CompletionStage<Result> listCompoundChain() {
        logger.debug("Fetching all CompoundChains...");
        return ccs.getAllCompoundChain().thenApplyAsync(compoundChainList -> {
            JsonNode jsonData = Json.toJson(compoundChainList);
            logger.debug("Retrieved CompoundChains: {}", compoundChainList);
            return ok(ApplicationUtil.createResponse(jsonData, true));
        }, hec.current());
    }

    public CompletionStage<Result> delete(int compoundId, int chainId) {
        logger.debug("Attempting to delete CompoundChain with compoundId: {} and chainId: {}", compoundId, chainId);
        return ccs.deleteCompoundChain(compoundId, chainId).thenApplyAsync(result -> {
            if (result) {
                return ok(ApplicationUtil.createResponse("CompoundChain deleted", true));
            } else {
                return notFound(ApplicationUtil.createResponse("CompoundChain not found", false));
            }
        }, hec.current());
    }

    public CompletionStage<Result> update(Http.Request request, int compoundId, int chainId) {
        JsonNode json = request.body().asJson();
        if (json == null) {
            return CompletableFuture.completedFuture(badRequest("Expecting JSON data"));
        }

        CompoundChain updatedCompoundChain = Json.fromJson(json, CompoundChain.class);
        return ccs.updateCompoundChain(updatedCompoundChain, compoundId, chainId).thenApplyAsync(result -> {
            if (result) {
                return ok(ApplicationUtil.createResponse(Json.toJson(updatedCompoundChain), true));
            } else {
                return internalServerError(ApplicationUtil.createResponse("Error updating CompoundChain", false));
            }
        }, hec.current());
    }

    public CompletionStage<Result> listCompoundChainInRange(int startCompoundId, int endCompoundId) {
        logger.debug("Fetching CompoundChains in range from compoundId {} to {}", startCompoundId, endCompoundId);
        return ccs.getCompoundChainInRange(startCompoundId, endCompoundId).thenApplyAsync(compoundChainList -> {
            JsonNode jsonData = Json.toJson(compoundChainList);
            logger.debug("Retrieved CompoundChains in range: {}", compoundChainList);
            return ok(jsonData);
        }, hec.current());
    }

    public CompletionStage<Result> patchCompoundChain(Http.Request request, int compoundId, int chainId) {
        JsonNode json = request.body().asJson();
        if (json == null || json.isEmpty()) {
            return CompletableFuture.completedFuture(badRequest("Expecting non-empty JSON data"));
        }

        return ccs.getCompoundChain(compoundId, chainId).thenComposeAsync(existingCompoundChain -> {
            if (existingCompoundChain == null) {
                return CompletableFuture.completedFuture(notFound("CompoundChain not found"));
            }

            Iterator<Map.Entry<String, JsonNode>> fields = json.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                String fieldName = entry.getKey();
                JsonNode fieldValue = entry.getValue();

                switch (fieldName) {
                    case "numberChains":
                        existingCompoundChain.setNumberChains(fieldValue.asInt());
                        break;
                    case "created":
                        existingCompoundChain.setCreated(fieldValue.asText());
                        break;
                    case "lastUpdated":
                        existingCompoundChain.setLastUpdated(fieldValue.asText());
                        break;
                    default:
                        break;
                }
            }

            return ccs.updateCompoundChain(existingCompoundChain, compoundId, chainId).thenApplyAsync(result -> {
                if (result) {
                    return ok(Json.toJson(existingCompoundChain));
                } else {
                    return internalServerError("Error updating CompoundChain");
                }
            }, hec.current());
        }, hec.current());
    }

    public CompletionStage<Result> listCompoundChainByCompoundId(int compoundId) {
        logger.debug("Fetching all CompoundChains with compoundId: {} ...", compoundId);
        return ccs.getCompoundChainsByCompoundId(compoundId).thenApplyAsync(compoundChainList -> {
            JsonNode jsonData = Json.toJson(compoundChainList);
            logger.debug("Retrieved CompoundChains: {}", compoundChainList);
            return ok(ApplicationUtil.createResponse(jsonData, true));
        }, hec.current());
    }
}
