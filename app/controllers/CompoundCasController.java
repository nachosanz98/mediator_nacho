package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import entities.CompoundCas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.data.FormFactory;
import play.libs.Json;
import play.libs.concurrent.HttpExecution;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.CompoundCasService;
import services.DatabaseExecutionContext;
import utils.ApplicationUtil;

import javax.inject.Inject;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;

public class CompoundCasController extends Controller {

    private static final Logger logger = LoggerFactory.getLogger("controller");
    private final FormFactory formFactory;
    private final CompoundCasService compoundCasService;
    private final HttpExecutionContext hec;

    private final DatabaseExecutionContext dec;

    @Inject
    public CompoundCasController(FormFactory formFactory, CompoundCasService compoundCasService, HttpExecutionContext hec, DatabaseExecutionContext dec) {
        this.formFactory = formFactory;
        this.compoundCasService = compoundCasService;
        this.hec = hec;
        this.dec = dec;
    }

    public CompletionStage<Result> retrieve(String casId) {
        Executor myEc = HttpExecution.fromThread(hec.current());
        return compoundCasService.getCompoundCas(casId).thenApplyAsync(compoundCas -> {
            if (compoundCas != null) {
                return ok(ApplicationUtil.createResponse(Json.toJson(compoundCas), true));
            } else {
                return notFound(ApplicationUtil.createResponse("CompoundCas not found", false));
            }
        }, myEc);
    }

    public CompletionStage<Result> create(Http.Request request) {
        JsonNode json = request.body().asJson();

        if (json == null) {
            return CompletableFuture.completedFuture(
                    badRequest(ApplicationUtil.createResponse("Expecting JSON data", false))
            );
        }

        CompoundCas compoundCas = Json.fromJson(json, CompoundCas.class);
        return compoundCasService.addCompoundCas(compoundCas).thenApplyAsync(createdCompoundCas -> {
            JsonNode createdJson = Json.toJson(createdCompoundCas);
            return created(createdJson);
        }, hec.current());
    }

    public CompletionStage<Result> listCompoundCas() {
        logger.debug("Fetching all Ce Experimental Properties...");
        return compoundCasService.getAllCompoundCas().thenApplyAsync(compoundCasList -> {
            JsonNode jsonData = Json.toJson(compoundCasList);
            logger.debug("Retrieved Ce Experimental Properties: {}", compoundCasList.toString());
            return ok(ApplicationUtil.createResponse(jsonData, true));
        }, hec.current());
    }

    public CompletionStage<Result> update(Http.Request request, String casId) {
        JsonNode json = request.body().asJson();
        CompoundCas compoundCas = Json.fromJson(json, CompoundCas.class);

        if (compoundCas != null) {
            return compoundCasService.updateCompoundCas(compoundCas, casId).thenApplyAsync(result -> {
                if (result) {
                    return ok(ApplicationUtil.createResponse(Json.toJson(compoundCas), true));
                } else {
                    return notFound(ApplicationUtil.createResponse("CompoundCas not found", false));
                }
            }, hec.current());
        } else {
            return CompletableFuture.completedFuture(badRequest(ApplicationUtil.createResponse("Invalid JSON data", false)));
        }
    }

    public CompletionStage<Result> delete(String casId) {
        logger.debug("Attempting to delete CompoundCas with id: {}", casId);
        return compoundCasService.deleteCompoundCas(casId).thenApplyAsync(result -> {
            if (result) {
                return ok("CompoundCas deleted successfully");
            } else {
                return notFound("CompoundCas not found");
            }
        }, hec.current());
    }

    public CompletionStage<Result> listCompoundCasInRange(String startId, String endId) {
        logger.debug("Fetching all Compounds Cas...");
        return compoundCasService.getCompoundCasInRange(startId, endId).thenApplyAsync(compoundCasList -> {
            JsonNode jsonData = Json.toJson(compoundCasList);
            logger.debug("Retrieved Compounds Cas: {}", compoundCasList.toString());
            return ok(ApplicationUtil.createResponse(jsonData, true));
        }, hec.current());
    }

    public CompletionStage<Result> patchCompoundCas(Http.Request request, String casId) {
        JsonNode json = request.body().asJson();

        if (json == null || json.isEmpty()) {
            return CompletableFuture.completedFuture(
                    badRequest(ApplicationUtil.createResponse("Expecting non-empty JSON data", false))
            );
        }

        return compoundCasService.getCompoundCas(casId).thenComposeAsync(existingCompoundCas -> {
            if (existingCompoundCas == null) {
                return CompletableFuture.completedFuture(notFound(ApplicationUtil.createResponse("CompoundCas not found", false)));
            }

            Iterator<Map.Entry<String, JsonNode>> fields = json.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                String fieldName = entry.getKey();
                JsonNode fieldValue = entry.getValue();

                switch (fieldName) {
                    case "formula":
                        existingCompoundCas.setFormula(fieldValue.asText());
                        break;
                    case "mass":
                        existingCompoundCas.setMass(fieldValue.asDouble());
                        break;
                    case "inchi":
                        existingCompoundCas.setInchi(fieldValue.asText());
                        break;
                    case "inchiKey":
                        existingCompoundCas.setInchiKey(fieldValue.asText());
                        break;
                    case "created":
                        existingCompoundCas.setCreated(fieldValue.asText());
                        break;
                    case "lastUpdated":
                        existingCompoundCas.setLastUpdated(fieldValue.asText());
                        break;
                    default:
                        break;
                }
            }

            return compoundCasService.updateCompoundCas(existingCompoundCas, casId).thenApplyAsync(result -> {
                if (result) {
                    return ok(ApplicationUtil.createResponse(Json.toJson(existingCompoundCas), true));
                } else {
                    return internalServerError(ApplicationUtil.createResponse("Error updating CompoundCas", false));
                }
            }, hec.current());
        }, hec.current());
    }
}