// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_17: controllers.HomeController,
  // @LINE:9
  EmployeeController_7: controllers.EmployeeController,
  // @LINE:16
  CompoundController_0: controllers.CompoundController,
  // @LINE:25
  PathwayController_18: controllers.PathwayController,
  // @LINE:34
  MsmsController_6: controllers.MsmsController,
  // @LINE:43
  CeEffMobController_10: controllers.CeEffMobController,
  // @LINE:52
  ChainsController_9: controllers.ChainsController,
  // @LINE:61
  OntologyTermsController_11: controllers.OntologyTermsController,
  // @LINE:70
  ClassyfireClassificationController_12: controllers.ClassyfireClassificationController,
  // @LINE:79
  CeExperimentalPropertiesController_2: controllers.CeExperimentalPropertiesController,
  // @LINE:88
  CompoundCasController_1: controllers.CompoundCasController,
  // @LINE:97
  CeExpPropMetadataController_3: controllers.CeExpPropMetadataController,
  // @LINE:106
  CompoundCeProductIonController_14: controllers.CompoundCeProductIonController,
  // @LINE:115
  CompoundChainController_5: controllers.CompoundChainController,
  // @LINE:125
  CompoundClassyfireController_13: controllers.CompoundClassyfireController,
  // @LINE:135
  CompoundOntologyController_4: controllers.CompoundOntologyController,
  // @LINE:145
  CompoundPathwaysController_8: controllers.CompoundPathwaysController,
  // @LINE:155
  CompoundsGenController_16: controllers.CompoundsGenController,
  // @LINE:164
  Assets_15: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_17: controllers.HomeController,
    // @LINE:9
    EmployeeController_7: controllers.EmployeeController,
    // @LINE:16
    CompoundController_0: controllers.CompoundController,
    // @LINE:25
    PathwayController_18: controllers.PathwayController,
    // @LINE:34
    MsmsController_6: controllers.MsmsController,
    // @LINE:43
    CeEffMobController_10: controllers.CeEffMobController,
    // @LINE:52
    ChainsController_9: controllers.ChainsController,
    // @LINE:61
    OntologyTermsController_11: controllers.OntologyTermsController,
    // @LINE:70
    ClassyfireClassificationController_12: controllers.ClassyfireClassificationController,
    // @LINE:79
    CeExperimentalPropertiesController_2: controllers.CeExperimentalPropertiesController,
    // @LINE:88
    CompoundCasController_1: controllers.CompoundCasController,
    // @LINE:97
    CeExpPropMetadataController_3: controllers.CeExpPropMetadataController,
    // @LINE:106
    CompoundCeProductIonController_14: controllers.CompoundCeProductIonController,
    // @LINE:115
    CompoundChainController_5: controllers.CompoundChainController,
    // @LINE:125
    CompoundClassyfireController_13: controllers.CompoundClassyfireController,
    // @LINE:135
    CompoundOntologyController_4: controllers.CompoundOntologyController,
    // @LINE:145
    CompoundPathwaysController_8: controllers.CompoundPathwaysController,
    // @LINE:155
    CompoundsGenController_16: controllers.CompoundsGenController,
    // @LINE:164
    Assets_15: controllers.Assets
  ) = this(errorHandler, HomeController_17, EmployeeController_7, CompoundController_0, PathwayController_18, MsmsController_6, CeEffMobController_10, ChainsController_9, OntologyTermsController_11, ClassyfireClassificationController_12, CeExperimentalPropertiesController_2, CompoundCasController_1, CeExpPropMetadataController_3, CompoundCeProductIonController_14, CompoundChainController_5, CompoundClassyfireController_13, CompoundOntologyController_4, CompoundPathwaysController_8, CompoundsGenController_16, Assets_15, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_17, EmployeeController_7, CompoundController_0, PathwayController_18, MsmsController_6, CeEffMobController_10, ChainsController_9, OntologyTermsController_11, ClassyfireClassificationController_12, CeExperimentalPropertiesController_2, CompoundCasController_1, CeExpPropMetadataController_3, CompoundCeProductIonController_14, CompoundChainController_5, CompoundClassyfireController_13, CompoundOntologyController_4, CompoundPathwaysController_8, CompoundsGenController_16, Assets_15, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """employees""", """controllers.EmployeeController.listEmployees()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """employees/""" + "$" + """id<[^/]+>""", """controllers.EmployeeController.retrieve(id:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """employees""", """controllers.EmployeeController.create(request:Request)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """employees/""", """controllers.EmployeeController.update(request:Request)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """employees/""" + "$" + """id<[^/]+>""", """controllers.EmployeeController.delete(id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compounds/list""", """controllers.CompoundController.listCompounds()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compounds""", """controllers.CompoundController.listCompoundsInRange(startId:Int, endId:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compounds/""" + "$" + """id<[^/]+>""", """controllers.CompoundController.retrieve(id:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compounds""", """controllers.CompoundController.create(request:Request)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compounds/""" + "$" + """id<[^/]+>""", """controllers.CompoundController.update(request:Request, id:Int)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compounds/""" + "$" + """id<[^/]+>""", """controllers.CompoundController.delete(id:Int)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compounds/""" + "$" + """id<[^/]+>""", """controllers.CompoundController.patchCompound(request:Request, id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """pathways/list""", """controllers.PathwayController.listPathways()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """pathways""", """controllers.PathwayController.listPathwaysInRange(startId:Int, endId:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """pathways/""" + "$" + """id<[^/]+>""", """controllers.PathwayController.retrieve(id:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """pathways""", """controllers.PathwayController.create(request:Request)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """pathways/""" + "$" + """id<[^/]+>""", """controllers.PathwayController.update(request:Request, id:Int)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """pathways/""" + "$" + """id<[^/]+>""", """controllers.PathwayController.delete(id:Int)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """pathways/""" + "$" + """id<[^/]+>""", """controllers.PathwayController.patchPathway(request:Request, id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """msms/list""", """controllers.MsmsController.listMsms()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """msms""", """controllers.MsmsController.listMsmsInRange(startId:Int, endId:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """msms/""" + "$" + """id<[^/]+>""", """controllers.MsmsController.retrieve(id:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """msms""", """controllers.MsmsController.create(request:Request)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """msms/""" + "$" + """id<[^/]+>""", """controllers.MsmsController.update(request:Request, id:Int)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """msms/""" + "$" + """id<[^/]+>""", """controllers.MsmsController.delete(id:Int)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """msms/""" + "$" + """id<[^/]+>""", """controllers.MsmsController.patchMsms(request:Request, id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ceEffMob/list""", """controllers.CeEffMobController.listCeEffMobs()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ceEffMob""", """controllers.CeEffMobController.listCeEffMobsInRange(startId:Int, endId:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ceEffMob/""" + "$" + """id<[^/]+>""", """controllers.CeEffMobController.retrieve(id:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ceEffMob""", """controllers.CeEffMobController.create(request:Request)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ceEffMob/""" + "$" + """id<[^/]+>""", """controllers.CeEffMobController.update(request:Request, id:Int)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ceEffMob/""" + "$" + """id<[^/]+>""", """controllers.CeEffMobController.delete(id:Int)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ceEffMob/""" + "$" + """id<[^/]+>""", """controllers.CeEffMobController.patchCeEffMob(request:Request, id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """chains/list""", """controllers.ChainsController.listChains()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """chains""", """controllers.ChainsController.listChainsInRange(startId:Int, endId:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """chains/""" + "$" + """id<[^/]+>""", """controllers.ChainsController.retrieve(id:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """chains""", """controllers.ChainsController.create(request:Request)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """chains/""" + "$" + """id<[^/]+>""", """controllers.ChainsController.update(request:Request, id:Int)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """chains/""" + "$" + """id<[^/]+>""", """controllers.ChainsController.delete(id:Int)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """chains/""" + "$" + """id<[^/]+>""", """controllers.ChainsController.patchChains(request:Request, id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ontologyTerms/list""", """controllers.OntologyTermsController.listOntologyTerms()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ontologyTerms""", """controllers.OntologyTermsController.listOntologyTermsInRange(startId:Int, endId:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ontologyTerms/""" + "$" + """id<[^/]+>""", """controllers.OntologyTermsController.retrieve(id:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ontologyTerms""", """controllers.OntologyTermsController.create(request:Request)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ontologyTerms/""" + "$" + """id<[^/]+>""", """controllers.OntologyTermsController.update(request:Request, id:Int)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ontologyTerms/""" + "$" + """id<[^/]+>""", """controllers.OntologyTermsController.delete(id:Int)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ontologyTerms/""" + "$" + """id<[^/]+>""", """controllers.OntologyTermsController.patchOntologyTerms(request:Request, id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """classyfireclassification/list""", """controllers.ClassyfireClassificationController.listClassyfireClassifications()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """classyfireclassification""", """controllers.ClassyfireClassificationController.listClassyfireClassificationInRange(startId:Int, endId:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """classyfireclassification/""" + "$" + """id<[^/]+>""", """controllers.ClassyfireClassificationController.retrieve(id:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """classyfireclassification""", """controllers.ClassyfireClassificationController.create(request:Request)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """classyfireclassification/""" + "$" + """id<[^/]+>""", """controllers.ClassyfireClassificationController.update(request:Request, id:Int)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """classyfireclassification/""" + "$" + """id<[^/]+>""", """controllers.ClassyfireClassificationController.delete(id:Int)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """classyfireclassification/""" + "$" + """id<[^/]+>""", """controllers.ClassyfireClassificationController.patchClassyfireClassification(request:Request, id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ceExpProps/list""", """controllers.CeExperimentalPropertiesController.listCeExperimentalProperties()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ceExpProps""", """controllers.CeExperimentalPropertiesController.listCeExperimentalPropertiesInRange(startId:Int, endId:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ceExpProps/""" + "$" + """id<[^/]+>""", """controllers.CeExperimentalPropertiesController.retrieve(id:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ceExpProps""", """controllers.CeExperimentalPropertiesController.create(request:Request)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ceExpProps/""" + "$" + """id<[^/]+>""", """controllers.CeExperimentalPropertiesController.update(request:Request, id:Int)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ceExpProps/""" + "$" + """id<[^/]+>""", """controllers.CeExperimentalPropertiesController.delete(id:Int)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ceExpProps/""" + "$" + """id<[^/]+>""", """controllers.CeExperimentalPropertiesController.patchCeExperimentalProperties(request:Request, id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundCas/list""", """controllers.CompoundCasController.listCompoundCas()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundCas""", """controllers.CompoundCasController.listCompoundCasInRange(startId:String, endId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundCas/""" + "$" + """id<[^/]+>""", """controllers.CompoundCasController.retrieve(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundCas""", """controllers.CompoundCasController.create(request:Request)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundCas/""" + "$" + """id<[^/]+>""", """controllers.CompoundCasController.update(request:Request, id:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundCas/""" + "$" + """id<[^/]+>""", """controllers.CompoundCasController.delete(id:String)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundCas/""" + "$" + """id<[^/]+>""", """controllers.CompoundCasController.patchCompoundCas(request:Request, id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ceExpPropMetadata/list""", """controllers.CeExpPropMetadataController.listCeExpPropMetadata()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ceExpPropMetadata""", """controllers.CeExpPropMetadataController.listCeExpPropMetadataInRange(startId:Int, endId:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ceExpPropMetadata/""" + "$" + """id<[^/]+>""", """controllers.CeExpPropMetadataController.retrieve(id:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ceExpPropMetadata""", """controllers.CeExpPropMetadataController.create(request:Request)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ceExpPropMetadata/""" + "$" + """id<[^/]+>""", """controllers.CeExpPropMetadataController.update(request:Request, id:Int)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ceExpPropMetadata/""" + "$" + """id<[^/]+>""", """controllers.CeExpPropMetadataController.delete(id:Int)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ceExpPropMetadata/""" + "$" + """id<[^/]+>""", """controllers.CeExpPropMetadataController.patchCeExpPropMetadata(request:Request, id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundCeProductIon/list""", """controllers.CompoundCeProductIonController.listCompoundCeProductIon()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundCeProductIon""", """controllers.CompoundCeProductIonController.listCompoundCeProductIonInRange(startId:Int, endId:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundCeProductIon/""" + "$" + """id<[^/]+>""", """controllers.CompoundCeProductIonController.retrieve(id:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundCeProductIon""", """controllers.CompoundCeProductIonController.create(request:Request)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundCeProductIon/""" + "$" + """id<[^/]+>""", """controllers.CompoundCeProductIonController.update(request:Request, id:Int)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundCeProductIon/""" + "$" + """id<[^/]+>""", """controllers.CompoundCeProductIonController.delete(id:Int)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundCeProductIon/""" + "$" + """id<[^/]+>""", """controllers.CompoundCeProductIonController.patchCompoundCeProductIon(request:Request, id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundChain/""" + "$" + """compoundId<[^/]+>/""" + "$" + """chainId<[^/]+>""", """controllers.CompoundChainController.retrieve(compoundId:Int, chainId:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundChain/list""", """controllers.CompoundChainController.listCompoundChain()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundChain""", """controllers.CompoundChainController.listCompoundChainInRange(startId:Int, endId:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundChain/""" + "$" + """compoundId<[^/]+>""", """controllers.CompoundChainController.listCompoundChainByCompoundId(compoundId:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundChain""", """controllers.CompoundChainController.create(request:Request)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundChain/""" + "$" + """compoundId<[^/]+>/""" + "$" + """chainId<[^/]+>""", """controllers.CompoundChainController.update(request:Request, compoundId:Int, chainId:Int)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundChain/""" + "$" + """compoundId<[^/]+>/""" + "$" + """chainId<[^/]+>""", """controllers.CompoundChainController.delete(compoundId:Int, chainId:Int)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundChain/""" + "$" + """compoundId<[^/]+>/""" + "$" + """chainId<[^/]+>""", """controllers.CompoundChainController.patchCompoundChain(request:Request, compoundId:Int, chainId:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundClassyfire/""" + "$" + """compoundId<[^/]+>/""" + "$" + """nodeId<[^/]+>""", """controllers.CompoundClassyfireController.retrieve(compoundId:Int, nodeId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundClassyfire/list""", """controllers.CompoundClassyfireController.listCompoundClassyfire()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundClassyfire""", """controllers.CompoundClassyfireController.listCompoundClassyfireInRange(startId:Int, endId:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundClassyfire/""" + "$" + """compoundId<[^/]+>""", """controllers.CompoundClassyfireController.listCompoundClassyfireByCompoundId(compoundId:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundClassyfire""", """controllers.CompoundClassyfireController.create(request:Request)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundClassyfire/""" + "$" + """compoundId<[^/]+>/""" + "$" + """nodeId<[^/]+>""", """controllers.CompoundClassyfireController.update(request:Request, compoundId:Int, nodeId:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundClassyfire/""" + "$" + """compoundId<[^/]+>/""" + "$" + """nodeId<[^/]+>""", """controllers.CompoundClassyfireController.delete(compoundId:Int, nodeId:String)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundClassyfire/""" + "$" + """compoundId<[^/]+>/""" + "$" + """nodeId<[^/]+>""", """controllers.CompoundClassyfireController.patchCompoundClassyfire(request:Request, compoundId:Int, nodeId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundOntology/""" + "$" + """compoundId<[^/]+>/""" + "$" + """ontologyTermId<[^/]+>""", """controllers.CompoundOntologyController.retrieve(compoundId:Int, ontologyTermId:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundOntology/list""", """controllers.CompoundOntologyController.listCompoundOntology()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundOntology""", """controllers.CompoundOntologyController.listCompoundOntologyInRange(startId:Int, endId:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundOntology/""" + "$" + """compoundId<[^/]+>""", """controllers.CompoundOntologyController.listCompoundOntologyByCompoundId(compoundId:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundOntology""", """controllers.CompoundOntologyController.create(request:Request)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundOntology/""" + "$" + """compoundId<[^/]+>/""" + "$" + """ontologyTermId<[^/]+>""", """controllers.CompoundOntologyController.update(request:Request, compoundId:Int, ontologyTermId:Int)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundOntology/""" + "$" + """compoundId<[^/]+>/""" + "$" + """ontologyTermId<[^/]+>""", """controllers.CompoundOntologyController.delete(compoundId:Int, ontologyTermId:Int)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundOntology/""" + "$" + """compoundId<[^/]+>/""" + "$" + """ontologyTermId<[^/]+>""", """controllers.CompoundOntologyController.patchCompoundOntology(request:Request, compoundId:Int, ontologyTermId:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundPathways/""" + "$" + """compoundId<[^/]+>/""" + "$" + """pathwayId<[^/]+>""", """controllers.CompoundPathwaysController.retrieve(compoundId:Int, pathwayId:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundPathways/list""", """controllers.CompoundPathwaysController.listCompoundPathways()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundPathways""", """controllers.CompoundPathwaysController.listCompoundPathwaysInRange(startId:Int, endId:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundPathways/""" + "$" + """compoundId<[^/]+>""", """controllers.CompoundPathwaysController.listCompoundPathwaysByCompoundId(compoundId:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundPathways""", """controllers.CompoundPathwaysController.create(request:Request)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundPathways/""" + "$" + """compoundId<[^/]+>/""" + "$" + """pathwayId<[^/]+>""", """controllers.CompoundPathwaysController.update(request:Request, compoundId:Int, pathwayId:Int)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundPathways/""" + "$" + """compoundId<[^/]+>/""" + "$" + """pathwayId<[^/]+>""", """controllers.CompoundPathwaysController.delete(compoundId:Int, pathwayId:Int)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundPathways/""" + "$" + """compoundId<[^/]+>/""" + "$" + """pathwayId<[^/]+>""", """controllers.CompoundPathwaysController.patchCompoundPathways(request:Request, compoundId:Int, pathwayId:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundsGen/list""", """controllers.CompoundsGenController.listCompoundsGen()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundsGen""", """controllers.CompoundsGenController.listCompoundsGenInRange(startId:Int, endId:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundsGen/""" + "$" + """id<[^/]+>""", """controllers.CompoundsGenController.retrieve(id:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundsGen""", """controllers.CompoundsGenController.create(request:Request)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundsGen/""" + "$" + """id<[^/]+>""", """controllers.CompoundsGenController.update(request:Request, id:Int)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundsGen/""" + "$" + """id<[^/]+>""", """controllers.CompoundsGenController.delete(id:Int)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compoundsGen/""" + "$" + """id<[^/]+>""", """controllers.CompoundsGenController.patchCompoundsGen(request:Request, id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_17.index(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_EmployeeController_listEmployees1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("employees")))
  )
  private[this] lazy val controllers_EmployeeController_listEmployees1_invoker = createInvoker(
    EmployeeController_7.listEmployees(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EmployeeController",
      "listEmployees",
      Nil,
      "GET",
      this.prefix + """employees""",
      """ APIs in EmployeeController""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_EmployeeController_retrieve2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("employees/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_EmployeeController_retrieve2_invoker = createInvoker(
    EmployeeController_7.retrieve(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EmployeeController",
      "retrieve",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """employees/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_EmployeeController_create3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("employees")))
  )
  private[this] lazy val controllers_EmployeeController_create3_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      EmployeeController_7.create(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EmployeeController",
      "create",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """employees""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_EmployeeController_update4_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("employees/")))
  )
  private[this] lazy val controllers_EmployeeController_update4_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      EmployeeController_7.update(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EmployeeController",
      "update",
      Seq(classOf[play.mvc.Http.Request]),
      "PUT",
      this.prefix + """employees/""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_EmployeeController_delete5_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("employees/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_EmployeeController_delete5_invoker = createInvoker(
    EmployeeController_7.delete(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EmployeeController",
      "delete",
      Seq(classOf[Int]),
      "DELETE",
      this.prefix + """employees/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_CompoundController_listCompounds6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compounds/list")))
  )
  private[this] lazy val controllers_CompoundController_listCompounds6_invoker = createInvoker(
    CompoundController_0.listCompounds(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundController",
      "listCompounds",
      Nil,
      "GET",
      this.prefix + """compounds/list""",
      """ APIs in CompoundController""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_CompoundController_listCompoundsInRange7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compounds")))
  )
  private[this] lazy val controllers_CompoundController_listCompoundsInRange7_invoker = createInvoker(
    CompoundController_0.listCompoundsInRange(fakeValue[Int], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundController",
      "listCompoundsInRange",
      Seq(classOf[Int], classOf[Int]),
      "GET",
      this.prefix + """compounds""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_CompoundController_retrieve8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compounds/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CompoundController_retrieve8_invoker = createInvoker(
    CompoundController_0.retrieve(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundController",
      "retrieve",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """compounds/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_CompoundController_create9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compounds")))
  )
  private[this] lazy val controllers_CompoundController_create9_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      CompoundController_0.create(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundController",
      "create",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """compounds""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_CompoundController_update10_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compounds/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CompoundController_update10_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      CompoundController_0.update(fakeValue[play.mvc.Http.Request], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundController",
      "update",
      Seq(classOf[play.mvc.Http.Request], classOf[Int]),
      "PUT",
      this.prefix + """compounds/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_CompoundController_delete11_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compounds/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CompoundController_delete11_invoker = createInvoker(
    CompoundController_0.delete(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundController",
      "delete",
      Seq(classOf[Int]),
      "DELETE",
      this.prefix + """compounds/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_CompoundController_patchCompound12_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compounds/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CompoundController_patchCompound12_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      CompoundController_0.patchCompound(fakeValue[play.mvc.Http.Request], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundController",
      "patchCompound",
      Seq(classOf[play.mvc.Http.Request], classOf[Int]),
      "PATCH",
      this.prefix + """compounds/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:25
  private[this] lazy val controllers_PathwayController_listPathways13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("pathways/list")))
  )
  private[this] lazy val controllers_PathwayController_listPathways13_invoker = createInvoker(
    PathwayController_18.listPathways(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PathwayController",
      "listPathways",
      Nil,
      "GET",
      this.prefix + """pathways/list""",
      """ APIs in PathwaysController""",
      Seq()
    )
  )

  // @LINE:26
  private[this] lazy val controllers_PathwayController_listPathwaysInRange14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("pathways")))
  )
  private[this] lazy val controllers_PathwayController_listPathwaysInRange14_invoker = createInvoker(
    PathwayController_18.listPathwaysInRange(fakeValue[Int], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PathwayController",
      "listPathwaysInRange",
      Seq(classOf[Int], classOf[Int]),
      "GET",
      this.prefix + """pathways""",
      """""",
      Seq()
    )
  )

  // @LINE:27
  private[this] lazy val controllers_PathwayController_retrieve15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("pathways/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PathwayController_retrieve15_invoker = createInvoker(
    PathwayController_18.retrieve(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PathwayController",
      "retrieve",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """pathways/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:28
  private[this] lazy val controllers_PathwayController_create16_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("pathways")))
  )
  private[this] lazy val controllers_PathwayController_create16_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      PathwayController_18.create(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PathwayController",
      "create",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """pathways""",
      """""",
      Seq()
    )
  )

  // @LINE:29
  private[this] lazy val controllers_PathwayController_update17_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("pathways/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PathwayController_update17_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      PathwayController_18.update(fakeValue[play.mvc.Http.Request], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PathwayController",
      "update",
      Seq(classOf[play.mvc.Http.Request], classOf[Int]),
      "PUT",
      this.prefix + """pathways/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:30
  private[this] lazy val controllers_PathwayController_delete18_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("pathways/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PathwayController_delete18_invoker = createInvoker(
    PathwayController_18.delete(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PathwayController",
      "delete",
      Seq(classOf[Int]),
      "DELETE",
      this.prefix + """pathways/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:31
  private[this] lazy val controllers_PathwayController_patchPathway19_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("pathways/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PathwayController_patchPathway19_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      PathwayController_18.patchPathway(fakeValue[play.mvc.Http.Request], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PathwayController",
      "patchPathway",
      Seq(classOf[play.mvc.Http.Request], classOf[Int]),
      "PATCH",
      this.prefix + """pathways/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:34
  private[this] lazy val controllers_MsmsController_listMsms20_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("msms/list")))
  )
  private[this] lazy val controllers_MsmsController_listMsms20_invoker = createInvoker(
    MsmsController_6.listMsms(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MsmsController",
      "listMsms",
      Nil,
      "GET",
      this.prefix + """msms/list""",
      """ APIs in MsmsController""",
      Seq()
    )
  )

  // @LINE:35
  private[this] lazy val controllers_MsmsController_listMsmsInRange21_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("msms")))
  )
  private[this] lazy val controllers_MsmsController_listMsmsInRange21_invoker = createInvoker(
    MsmsController_6.listMsmsInRange(fakeValue[Int], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MsmsController",
      "listMsmsInRange",
      Seq(classOf[Int], classOf[Int]),
      "GET",
      this.prefix + """msms""",
      """""",
      Seq()
    )
  )

  // @LINE:36
  private[this] lazy val controllers_MsmsController_retrieve22_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("msms/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_MsmsController_retrieve22_invoker = createInvoker(
    MsmsController_6.retrieve(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MsmsController",
      "retrieve",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """msms/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:37
  private[this] lazy val controllers_MsmsController_create23_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("msms")))
  )
  private[this] lazy val controllers_MsmsController_create23_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      MsmsController_6.create(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MsmsController",
      "create",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """msms""",
      """""",
      Seq()
    )
  )

  // @LINE:38
  private[this] lazy val controllers_MsmsController_update24_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("msms/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_MsmsController_update24_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      MsmsController_6.update(fakeValue[play.mvc.Http.Request], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MsmsController",
      "update",
      Seq(classOf[play.mvc.Http.Request], classOf[Int]),
      "PUT",
      this.prefix + """msms/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:39
  private[this] lazy val controllers_MsmsController_delete25_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("msms/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_MsmsController_delete25_invoker = createInvoker(
    MsmsController_6.delete(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MsmsController",
      "delete",
      Seq(classOf[Int]),
      "DELETE",
      this.prefix + """msms/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:40
  private[this] lazy val controllers_MsmsController_patchMsms26_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("msms/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_MsmsController_patchMsms26_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      MsmsController_6.patchMsms(fakeValue[play.mvc.Http.Request], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MsmsController",
      "patchMsms",
      Seq(classOf[play.mvc.Http.Request], classOf[Int]),
      "PATCH",
      this.prefix + """msms/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:43
  private[this] lazy val controllers_CeEffMobController_listCeEffMobs27_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ceEffMob/list")))
  )
  private[this] lazy val controllers_CeEffMobController_listCeEffMobs27_invoker = createInvoker(
    CeEffMobController_10.listCeEffMobs(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CeEffMobController",
      "listCeEffMobs",
      Nil,
      "GET",
      this.prefix + """ceEffMob/list""",
      """ APIs in CeEffMobController""",
      Seq()
    )
  )

  // @LINE:44
  private[this] lazy val controllers_CeEffMobController_listCeEffMobsInRange28_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ceEffMob")))
  )
  private[this] lazy val controllers_CeEffMobController_listCeEffMobsInRange28_invoker = createInvoker(
    CeEffMobController_10.listCeEffMobsInRange(fakeValue[Int], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CeEffMobController",
      "listCeEffMobsInRange",
      Seq(classOf[Int], classOf[Int]),
      "GET",
      this.prefix + """ceEffMob""",
      """""",
      Seq()
    )
  )

  // @LINE:45
  private[this] lazy val controllers_CeEffMobController_retrieve29_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ceEffMob/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CeEffMobController_retrieve29_invoker = createInvoker(
    CeEffMobController_10.retrieve(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CeEffMobController",
      "retrieve",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """ceEffMob/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:46
  private[this] lazy val controllers_CeEffMobController_create30_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ceEffMob")))
  )
  private[this] lazy val controllers_CeEffMobController_create30_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      CeEffMobController_10.create(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CeEffMobController",
      "create",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """ceEffMob""",
      """""",
      Seq()
    )
  )

  // @LINE:47
  private[this] lazy val controllers_CeEffMobController_update31_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ceEffMob/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CeEffMobController_update31_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      CeEffMobController_10.update(fakeValue[play.mvc.Http.Request], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CeEffMobController",
      "update",
      Seq(classOf[play.mvc.Http.Request], classOf[Int]),
      "PUT",
      this.prefix + """ceEffMob/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:48
  private[this] lazy val controllers_CeEffMobController_delete32_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ceEffMob/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CeEffMobController_delete32_invoker = createInvoker(
    CeEffMobController_10.delete(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CeEffMobController",
      "delete",
      Seq(classOf[Int]),
      "DELETE",
      this.prefix + """ceEffMob/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:49
  private[this] lazy val controllers_CeEffMobController_patchCeEffMob33_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ceEffMob/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CeEffMobController_patchCeEffMob33_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      CeEffMobController_10.patchCeEffMob(fakeValue[play.mvc.Http.Request], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CeEffMobController",
      "patchCeEffMob",
      Seq(classOf[play.mvc.Http.Request], classOf[Int]),
      "PATCH",
      this.prefix + """ceEffMob/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:52
  private[this] lazy val controllers_ChainsController_listChains34_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("chains/list")))
  )
  private[this] lazy val controllers_ChainsController_listChains34_invoker = createInvoker(
    ChainsController_9.listChains(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ChainsController",
      "listChains",
      Nil,
      "GET",
      this.prefix + """chains/list""",
      """ APIs in ChainsController""",
      Seq()
    )
  )

  // @LINE:53
  private[this] lazy val controllers_ChainsController_listChainsInRange35_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("chains")))
  )
  private[this] lazy val controllers_ChainsController_listChainsInRange35_invoker = createInvoker(
    ChainsController_9.listChainsInRange(fakeValue[Int], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ChainsController",
      "listChainsInRange",
      Seq(classOf[Int], classOf[Int]),
      "GET",
      this.prefix + """chains""",
      """""",
      Seq()
    )
  )

  // @LINE:54
  private[this] lazy val controllers_ChainsController_retrieve36_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("chains/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ChainsController_retrieve36_invoker = createInvoker(
    ChainsController_9.retrieve(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ChainsController",
      "retrieve",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """chains/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:55
  private[this] lazy val controllers_ChainsController_create37_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("chains")))
  )
  private[this] lazy val controllers_ChainsController_create37_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      ChainsController_9.create(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ChainsController",
      "create",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """chains""",
      """""",
      Seq()
    )
  )

  // @LINE:56
  private[this] lazy val controllers_ChainsController_update38_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("chains/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ChainsController_update38_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      ChainsController_9.update(fakeValue[play.mvc.Http.Request], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ChainsController",
      "update",
      Seq(classOf[play.mvc.Http.Request], classOf[Int]),
      "PUT",
      this.prefix + """chains/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:57
  private[this] lazy val controllers_ChainsController_delete39_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("chains/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ChainsController_delete39_invoker = createInvoker(
    ChainsController_9.delete(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ChainsController",
      "delete",
      Seq(classOf[Int]),
      "DELETE",
      this.prefix + """chains/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:58
  private[this] lazy val controllers_ChainsController_patchChains40_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("chains/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ChainsController_patchChains40_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      ChainsController_9.patchChains(fakeValue[play.mvc.Http.Request], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ChainsController",
      "patchChains",
      Seq(classOf[play.mvc.Http.Request], classOf[Int]),
      "PATCH",
      this.prefix + """chains/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:61
  private[this] lazy val controllers_OntologyTermsController_listOntologyTerms41_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ontologyTerms/list")))
  )
  private[this] lazy val controllers_OntologyTermsController_listOntologyTerms41_invoker = createInvoker(
    OntologyTermsController_11.listOntologyTerms(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OntologyTermsController",
      "listOntologyTerms",
      Nil,
      "GET",
      this.prefix + """ontologyTerms/list""",
      """ APIs in OntologyTermsController""",
      Seq()
    )
  )

  // @LINE:62
  private[this] lazy val controllers_OntologyTermsController_listOntologyTermsInRange42_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ontologyTerms")))
  )
  private[this] lazy val controllers_OntologyTermsController_listOntologyTermsInRange42_invoker = createInvoker(
    OntologyTermsController_11.listOntologyTermsInRange(fakeValue[Int], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OntologyTermsController",
      "listOntologyTermsInRange",
      Seq(classOf[Int], classOf[Int]),
      "GET",
      this.prefix + """ontologyTerms""",
      """""",
      Seq()
    )
  )

  // @LINE:63
  private[this] lazy val controllers_OntologyTermsController_retrieve43_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ontologyTerms/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_OntologyTermsController_retrieve43_invoker = createInvoker(
    OntologyTermsController_11.retrieve(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OntologyTermsController",
      "retrieve",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """ontologyTerms/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:64
  private[this] lazy val controllers_OntologyTermsController_create44_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ontologyTerms")))
  )
  private[this] lazy val controllers_OntologyTermsController_create44_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      OntologyTermsController_11.create(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OntologyTermsController",
      "create",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """ontologyTerms""",
      """""",
      Seq()
    )
  )

  // @LINE:65
  private[this] lazy val controllers_OntologyTermsController_update45_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ontologyTerms/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_OntologyTermsController_update45_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      OntologyTermsController_11.update(fakeValue[play.mvc.Http.Request], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OntologyTermsController",
      "update",
      Seq(classOf[play.mvc.Http.Request], classOf[Int]),
      "PUT",
      this.prefix + """ontologyTerms/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:66
  private[this] lazy val controllers_OntologyTermsController_delete46_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ontologyTerms/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_OntologyTermsController_delete46_invoker = createInvoker(
    OntologyTermsController_11.delete(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OntologyTermsController",
      "delete",
      Seq(classOf[Int]),
      "DELETE",
      this.prefix + """ontologyTerms/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:67
  private[this] lazy val controllers_OntologyTermsController_patchOntologyTerms47_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ontologyTerms/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_OntologyTermsController_patchOntologyTerms47_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      OntologyTermsController_11.patchOntologyTerms(fakeValue[play.mvc.Http.Request], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OntologyTermsController",
      "patchOntologyTerms",
      Seq(classOf[play.mvc.Http.Request], classOf[Int]),
      "PATCH",
      this.prefix + """ontologyTerms/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:70
  private[this] lazy val controllers_ClassyfireClassificationController_listClassyfireClassifications48_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("classyfireclassification/list")))
  )
  private[this] lazy val controllers_ClassyfireClassificationController_listClassyfireClassifications48_invoker = createInvoker(
    ClassyfireClassificationController_12.listClassyfireClassifications(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ClassyfireClassificationController",
      "listClassyfireClassifications",
      Nil,
      "GET",
      this.prefix + """classyfireclassification/list""",
      """ APIs in ClassyfireClassificationController""",
      Seq()
    )
  )

  // @LINE:71
  private[this] lazy val controllers_ClassyfireClassificationController_listClassyfireClassificationInRange49_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("classyfireclassification")))
  )
  private[this] lazy val controllers_ClassyfireClassificationController_listClassyfireClassificationInRange49_invoker = createInvoker(
    ClassyfireClassificationController_12.listClassyfireClassificationInRange(fakeValue[Int], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ClassyfireClassificationController",
      "listClassyfireClassificationInRange",
      Seq(classOf[Int], classOf[Int]),
      "GET",
      this.prefix + """classyfireclassification""",
      """""",
      Seq()
    )
  )

  // @LINE:72
  private[this] lazy val controllers_ClassyfireClassificationController_retrieve50_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("classyfireclassification/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ClassyfireClassificationController_retrieve50_invoker = createInvoker(
    ClassyfireClassificationController_12.retrieve(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ClassyfireClassificationController",
      "retrieve",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """classyfireclassification/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:73
  private[this] lazy val controllers_ClassyfireClassificationController_create51_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("classyfireclassification")))
  )
  private[this] lazy val controllers_ClassyfireClassificationController_create51_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      ClassyfireClassificationController_12.create(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ClassyfireClassificationController",
      "create",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """classyfireclassification""",
      """""",
      Seq()
    )
  )

  // @LINE:74
  private[this] lazy val controllers_ClassyfireClassificationController_update52_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("classyfireclassification/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ClassyfireClassificationController_update52_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      ClassyfireClassificationController_12.update(fakeValue[play.mvc.Http.Request], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ClassyfireClassificationController",
      "update",
      Seq(classOf[play.mvc.Http.Request], classOf[Int]),
      "PUT",
      this.prefix + """classyfireclassification/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:75
  private[this] lazy val controllers_ClassyfireClassificationController_delete53_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("classyfireclassification/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ClassyfireClassificationController_delete53_invoker = createInvoker(
    ClassyfireClassificationController_12.delete(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ClassyfireClassificationController",
      "delete",
      Seq(classOf[Int]),
      "DELETE",
      this.prefix + """classyfireclassification/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:76
  private[this] lazy val controllers_ClassyfireClassificationController_patchClassyfireClassification54_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("classyfireclassification/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ClassyfireClassificationController_patchClassyfireClassification54_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      ClassyfireClassificationController_12.patchClassyfireClassification(fakeValue[play.mvc.Http.Request], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ClassyfireClassificationController",
      "patchClassyfireClassification",
      Seq(classOf[play.mvc.Http.Request], classOf[Int]),
      "PATCH",
      this.prefix + """classyfireclassification/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:79
  private[this] lazy val controllers_CeExperimentalPropertiesController_listCeExperimentalProperties55_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ceExpProps/list")))
  )
  private[this] lazy val controllers_CeExperimentalPropertiesController_listCeExperimentalProperties55_invoker = createInvoker(
    CeExperimentalPropertiesController_2.listCeExperimentalProperties(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CeExperimentalPropertiesController",
      "listCeExperimentalProperties",
      Nil,
      "GET",
      this.prefix + """ceExpProps/list""",
      """ APIs in CeExperimentalPropertiesController""",
      Seq()
    )
  )

  // @LINE:80
  private[this] lazy val controllers_CeExperimentalPropertiesController_listCeExperimentalPropertiesInRange56_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ceExpProps")))
  )
  private[this] lazy val controllers_CeExperimentalPropertiesController_listCeExperimentalPropertiesInRange56_invoker = createInvoker(
    CeExperimentalPropertiesController_2.listCeExperimentalPropertiesInRange(fakeValue[Int], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CeExperimentalPropertiesController",
      "listCeExperimentalPropertiesInRange",
      Seq(classOf[Int], classOf[Int]),
      "GET",
      this.prefix + """ceExpProps""",
      """""",
      Seq()
    )
  )

  // @LINE:81
  private[this] lazy val controllers_CeExperimentalPropertiesController_retrieve57_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ceExpProps/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CeExperimentalPropertiesController_retrieve57_invoker = createInvoker(
    CeExperimentalPropertiesController_2.retrieve(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CeExperimentalPropertiesController",
      "retrieve",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """ceExpProps/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:82
  private[this] lazy val controllers_CeExperimentalPropertiesController_create58_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ceExpProps")))
  )
  private[this] lazy val controllers_CeExperimentalPropertiesController_create58_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      CeExperimentalPropertiesController_2.create(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CeExperimentalPropertiesController",
      "create",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """ceExpProps""",
      """""",
      Seq()
    )
  )

  // @LINE:83
  private[this] lazy val controllers_CeExperimentalPropertiesController_update59_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ceExpProps/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CeExperimentalPropertiesController_update59_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      CeExperimentalPropertiesController_2.update(fakeValue[play.mvc.Http.Request], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CeExperimentalPropertiesController",
      "update",
      Seq(classOf[play.mvc.Http.Request], classOf[Int]),
      "PUT",
      this.prefix + """ceExpProps/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:84
  private[this] lazy val controllers_CeExperimentalPropertiesController_delete60_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ceExpProps/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CeExperimentalPropertiesController_delete60_invoker = createInvoker(
    CeExperimentalPropertiesController_2.delete(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CeExperimentalPropertiesController",
      "delete",
      Seq(classOf[Int]),
      "DELETE",
      this.prefix + """ceExpProps/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:85
  private[this] lazy val controllers_CeExperimentalPropertiesController_patchCeExperimentalProperties61_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ceExpProps/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CeExperimentalPropertiesController_patchCeExperimentalProperties61_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      CeExperimentalPropertiesController_2.patchCeExperimentalProperties(fakeValue[play.mvc.Http.Request], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CeExperimentalPropertiesController",
      "patchCeExperimentalProperties",
      Seq(classOf[play.mvc.Http.Request], classOf[Int]),
      "PATCH",
      this.prefix + """ceExpProps/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:88
  private[this] lazy val controllers_CompoundCasController_listCompoundCas62_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundCas/list")))
  )
  private[this] lazy val controllers_CompoundCasController_listCompoundCas62_invoker = createInvoker(
    CompoundCasController_1.listCompoundCas(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundCasController",
      "listCompoundCas",
      Nil,
      "GET",
      this.prefix + """compoundCas/list""",
      """ APIs in CompoundCas""",
      Seq()
    )
  )

  // @LINE:89
  private[this] lazy val controllers_CompoundCasController_listCompoundCasInRange63_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundCas")))
  )
  private[this] lazy val controllers_CompoundCasController_listCompoundCasInRange63_invoker = createInvoker(
    CompoundCasController_1.listCompoundCasInRange(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundCasController",
      "listCompoundCasInRange",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """compoundCas""",
      """""",
      Seq()
    )
  )

  // @LINE:90
  private[this] lazy val controllers_CompoundCasController_retrieve64_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundCas/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CompoundCasController_retrieve64_invoker = createInvoker(
    CompoundCasController_1.retrieve(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundCasController",
      "retrieve",
      Seq(classOf[String]),
      "GET",
      this.prefix + """compoundCas/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:91
  private[this] lazy val controllers_CompoundCasController_create65_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundCas")))
  )
  private[this] lazy val controllers_CompoundCasController_create65_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      CompoundCasController_1.create(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundCasController",
      "create",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """compoundCas""",
      """""",
      Seq()
    )
  )

  // @LINE:92
  private[this] lazy val controllers_CompoundCasController_update66_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundCas/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CompoundCasController_update66_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      CompoundCasController_1.update(fakeValue[play.mvc.Http.Request], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundCasController",
      "update",
      Seq(classOf[play.mvc.Http.Request], classOf[String]),
      "PUT",
      this.prefix + """compoundCas/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:93
  private[this] lazy val controllers_CompoundCasController_delete67_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundCas/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CompoundCasController_delete67_invoker = createInvoker(
    CompoundCasController_1.delete(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundCasController",
      "delete",
      Seq(classOf[String]),
      "DELETE",
      this.prefix + """compoundCas/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:94
  private[this] lazy val controllers_CompoundCasController_patchCompoundCas68_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundCas/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CompoundCasController_patchCompoundCas68_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      CompoundCasController_1.patchCompoundCas(fakeValue[play.mvc.Http.Request], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundCasController",
      "patchCompoundCas",
      Seq(classOf[play.mvc.Http.Request], classOf[String]),
      "PATCH",
      this.prefix + """compoundCas/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:97
  private[this] lazy val controllers_CeExpPropMetadataController_listCeExpPropMetadata69_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ceExpPropMetadata/list")))
  )
  private[this] lazy val controllers_CeExpPropMetadataController_listCeExpPropMetadata69_invoker = createInvoker(
    CeExpPropMetadataController_3.listCeExpPropMetadata(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CeExpPropMetadataController",
      "listCeExpPropMetadata",
      Nil,
      "GET",
      this.prefix + """ceExpPropMetadata/list""",
      """ APIs in CeExpPropMetadataController""",
      Seq()
    )
  )

  // @LINE:98
  private[this] lazy val controllers_CeExpPropMetadataController_listCeExpPropMetadataInRange70_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ceExpPropMetadata")))
  )
  private[this] lazy val controllers_CeExpPropMetadataController_listCeExpPropMetadataInRange70_invoker = createInvoker(
    CeExpPropMetadataController_3.listCeExpPropMetadataInRange(fakeValue[Int], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CeExpPropMetadataController",
      "listCeExpPropMetadataInRange",
      Seq(classOf[Int], classOf[Int]),
      "GET",
      this.prefix + """ceExpPropMetadata""",
      """""",
      Seq()
    )
  )

  // @LINE:99
  private[this] lazy val controllers_CeExpPropMetadataController_retrieve71_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ceExpPropMetadata/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CeExpPropMetadataController_retrieve71_invoker = createInvoker(
    CeExpPropMetadataController_3.retrieve(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CeExpPropMetadataController",
      "retrieve",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """ceExpPropMetadata/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:100
  private[this] lazy val controllers_CeExpPropMetadataController_create72_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ceExpPropMetadata")))
  )
  private[this] lazy val controllers_CeExpPropMetadataController_create72_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      CeExpPropMetadataController_3.create(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CeExpPropMetadataController",
      "create",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """ceExpPropMetadata""",
      """""",
      Seq()
    )
  )

  // @LINE:101
  private[this] lazy val controllers_CeExpPropMetadataController_update73_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ceExpPropMetadata/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CeExpPropMetadataController_update73_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      CeExpPropMetadataController_3.update(fakeValue[play.mvc.Http.Request], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CeExpPropMetadataController",
      "update",
      Seq(classOf[play.mvc.Http.Request], classOf[Int]),
      "PUT",
      this.prefix + """ceExpPropMetadata/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:102
  private[this] lazy val controllers_CeExpPropMetadataController_delete74_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ceExpPropMetadata/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CeExpPropMetadataController_delete74_invoker = createInvoker(
    CeExpPropMetadataController_3.delete(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CeExpPropMetadataController",
      "delete",
      Seq(classOf[Int]),
      "DELETE",
      this.prefix + """ceExpPropMetadata/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:103
  private[this] lazy val controllers_CeExpPropMetadataController_patchCeExpPropMetadata75_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ceExpPropMetadata/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CeExpPropMetadataController_patchCeExpPropMetadata75_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      CeExpPropMetadataController_3.patchCeExpPropMetadata(fakeValue[play.mvc.Http.Request], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CeExpPropMetadataController",
      "patchCeExpPropMetadata",
      Seq(classOf[play.mvc.Http.Request], classOf[Int]),
      "PATCH",
      this.prefix + """ceExpPropMetadata/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:106
  private[this] lazy val controllers_CompoundCeProductIonController_listCompoundCeProductIon76_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundCeProductIon/list")))
  )
  private[this] lazy val controllers_CompoundCeProductIonController_listCompoundCeProductIon76_invoker = createInvoker(
    CompoundCeProductIonController_14.listCompoundCeProductIon(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundCeProductIonController",
      "listCompoundCeProductIon",
      Nil,
      "GET",
      this.prefix + """compoundCeProductIon/list""",
      """ APIs in CompoundCeProductIonController""",
      Seq()
    )
  )

  // @LINE:107
  private[this] lazy val controllers_CompoundCeProductIonController_listCompoundCeProductIonInRange77_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundCeProductIon")))
  )
  private[this] lazy val controllers_CompoundCeProductIonController_listCompoundCeProductIonInRange77_invoker = createInvoker(
    CompoundCeProductIonController_14.listCompoundCeProductIonInRange(fakeValue[Int], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundCeProductIonController",
      "listCompoundCeProductIonInRange",
      Seq(classOf[Int], classOf[Int]),
      "GET",
      this.prefix + """compoundCeProductIon""",
      """""",
      Seq()
    )
  )

  // @LINE:108
  private[this] lazy val controllers_CompoundCeProductIonController_retrieve78_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundCeProductIon/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CompoundCeProductIonController_retrieve78_invoker = createInvoker(
    CompoundCeProductIonController_14.retrieve(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundCeProductIonController",
      "retrieve",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """compoundCeProductIon/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:109
  private[this] lazy val controllers_CompoundCeProductIonController_create79_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundCeProductIon")))
  )
  private[this] lazy val controllers_CompoundCeProductIonController_create79_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      CompoundCeProductIonController_14.create(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundCeProductIonController",
      "create",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """compoundCeProductIon""",
      """""",
      Seq()
    )
  )

  // @LINE:110
  private[this] lazy val controllers_CompoundCeProductIonController_update80_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundCeProductIon/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CompoundCeProductIonController_update80_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      CompoundCeProductIonController_14.update(fakeValue[play.mvc.Http.Request], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundCeProductIonController",
      "update",
      Seq(classOf[play.mvc.Http.Request], classOf[Int]),
      "PUT",
      this.prefix + """compoundCeProductIon/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:111
  private[this] lazy val controllers_CompoundCeProductIonController_delete81_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundCeProductIon/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CompoundCeProductIonController_delete81_invoker = createInvoker(
    CompoundCeProductIonController_14.delete(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundCeProductIonController",
      "delete",
      Seq(classOf[Int]),
      "DELETE",
      this.prefix + """compoundCeProductIon/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:112
  private[this] lazy val controllers_CompoundCeProductIonController_patchCompoundCeProductIon82_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundCeProductIon/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CompoundCeProductIonController_patchCompoundCeProductIon82_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      CompoundCeProductIonController_14.patchCompoundCeProductIon(fakeValue[play.mvc.Http.Request], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundCeProductIonController",
      "patchCompoundCeProductIon",
      Seq(classOf[play.mvc.Http.Request], classOf[Int]),
      "PATCH",
      this.prefix + """compoundCeProductIon/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:115
  private[this] lazy val controllers_CompoundChainController_retrieve83_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundChain/"), DynamicPart("compoundId", """[^/]+""",true), StaticPart("/"), DynamicPart("chainId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CompoundChainController_retrieve83_invoker = createInvoker(
    CompoundChainController_5.retrieve(fakeValue[Int], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundChainController",
      "retrieve",
      Seq(classOf[Int], classOf[Int]),
      "GET",
      this.prefix + """compoundChain/""" + "$" + """compoundId<[^/]+>/""" + "$" + """chainId<[^/]+>""",
      """ APIs for CompoundChain""",
      Seq()
    )
  )

  // @LINE:116
  private[this] lazy val controllers_CompoundChainController_listCompoundChain84_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundChain/list")))
  )
  private[this] lazy val controllers_CompoundChainController_listCompoundChain84_invoker = createInvoker(
    CompoundChainController_5.listCompoundChain(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundChainController",
      "listCompoundChain",
      Nil,
      "GET",
      this.prefix + """compoundChain/list""",
      """""",
      Seq()
    )
  )

  // @LINE:117
  private[this] lazy val controllers_CompoundChainController_listCompoundChainInRange85_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundChain")))
  )
  private[this] lazy val controllers_CompoundChainController_listCompoundChainInRange85_invoker = createInvoker(
    CompoundChainController_5.listCompoundChainInRange(fakeValue[Int], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundChainController",
      "listCompoundChainInRange",
      Seq(classOf[Int], classOf[Int]),
      "GET",
      this.prefix + """compoundChain""",
      """""",
      Seq()
    )
  )

  // @LINE:118
  private[this] lazy val controllers_CompoundChainController_listCompoundChainByCompoundId86_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundChain/"), DynamicPart("compoundId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CompoundChainController_listCompoundChainByCompoundId86_invoker = createInvoker(
    CompoundChainController_5.listCompoundChainByCompoundId(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundChainController",
      "listCompoundChainByCompoundId",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """compoundChain/""" + "$" + """compoundId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:119
  private[this] lazy val controllers_CompoundChainController_create87_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundChain")))
  )
  private[this] lazy val controllers_CompoundChainController_create87_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      CompoundChainController_5.create(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundChainController",
      "create",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """compoundChain""",
      """""",
      Seq()
    )
  )

  // @LINE:120
  private[this] lazy val controllers_CompoundChainController_update88_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundChain/"), DynamicPart("compoundId", """[^/]+""",true), StaticPart("/"), DynamicPart("chainId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CompoundChainController_update88_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      CompoundChainController_5.update(fakeValue[play.mvc.Http.Request], fakeValue[Int], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundChainController",
      "update",
      Seq(classOf[play.mvc.Http.Request], classOf[Int], classOf[Int]),
      "PUT",
      this.prefix + """compoundChain/""" + "$" + """compoundId<[^/]+>/""" + "$" + """chainId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:121
  private[this] lazy val controllers_CompoundChainController_delete89_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundChain/"), DynamicPart("compoundId", """[^/]+""",true), StaticPart("/"), DynamicPart("chainId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CompoundChainController_delete89_invoker = createInvoker(
    CompoundChainController_5.delete(fakeValue[Int], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundChainController",
      "delete",
      Seq(classOf[Int], classOf[Int]),
      "DELETE",
      this.prefix + """compoundChain/""" + "$" + """compoundId<[^/]+>/""" + "$" + """chainId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:122
  private[this] lazy val controllers_CompoundChainController_patchCompoundChain90_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundChain/"), DynamicPart("compoundId", """[^/]+""",true), StaticPart("/"), DynamicPart("chainId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CompoundChainController_patchCompoundChain90_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      CompoundChainController_5.patchCompoundChain(fakeValue[play.mvc.Http.Request], fakeValue[Int], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundChainController",
      "patchCompoundChain",
      Seq(classOf[play.mvc.Http.Request], classOf[Int], classOf[Int]),
      "PATCH",
      this.prefix + """compoundChain/""" + "$" + """compoundId<[^/]+>/""" + "$" + """chainId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:125
  private[this] lazy val controllers_CompoundClassyfireController_retrieve91_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundClassyfire/"), DynamicPart("compoundId", """[^/]+""",true), StaticPart("/"), DynamicPart("nodeId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CompoundClassyfireController_retrieve91_invoker = createInvoker(
    CompoundClassyfireController_13.retrieve(fakeValue[Int], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundClassyfireController",
      "retrieve",
      Seq(classOf[Int], classOf[String]),
      "GET",
      this.prefix + """compoundClassyfire/""" + "$" + """compoundId<[^/]+>/""" + "$" + """nodeId<[^/]+>""",
      """ APIs for CompoundClassyfire""",
      Seq()
    )
  )

  // @LINE:126
  private[this] lazy val controllers_CompoundClassyfireController_listCompoundClassyfire92_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundClassyfire/list")))
  )
  private[this] lazy val controllers_CompoundClassyfireController_listCompoundClassyfire92_invoker = createInvoker(
    CompoundClassyfireController_13.listCompoundClassyfire(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundClassyfireController",
      "listCompoundClassyfire",
      Nil,
      "GET",
      this.prefix + """compoundClassyfire/list""",
      """""",
      Seq()
    )
  )

  // @LINE:127
  private[this] lazy val controllers_CompoundClassyfireController_listCompoundClassyfireInRange93_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundClassyfire")))
  )
  private[this] lazy val controllers_CompoundClassyfireController_listCompoundClassyfireInRange93_invoker = createInvoker(
    CompoundClassyfireController_13.listCompoundClassyfireInRange(fakeValue[Int], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundClassyfireController",
      "listCompoundClassyfireInRange",
      Seq(classOf[Int], classOf[Int]),
      "GET",
      this.prefix + """compoundClassyfire""",
      """""",
      Seq()
    )
  )

  // @LINE:128
  private[this] lazy val controllers_CompoundClassyfireController_listCompoundClassyfireByCompoundId94_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundClassyfire/"), DynamicPart("compoundId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CompoundClassyfireController_listCompoundClassyfireByCompoundId94_invoker = createInvoker(
    CompoundClassyfireController_13.listCompoundClassyfireByCompoundId(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundClassyfireController",
      "listCompoundClassyfireByCompoundId",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """compoundClassyfire/""" + "$" + """compoundId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:129
  private[this] lazy val controllers_CompoundClassyfireController_create95_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundClassyfire")))
  )
  private[this] lazy val controllers_CompoundClassyfireController_create95_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      CompoundClassyfireController_13.create(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundClassyfireController",
      "create",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """compoundClassyfire""",
      """""",
      Seq()
    )
  )

  // @LINE:130
  private[this] lazy val controllers_CompoundClassyfireController_update96_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundClassyfire/"), DynamicPart("compoundId", """[^/]+""",true), StaticPart("/"), DynamicPart("nodeId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CompoundClassyfireController_update96_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      CompoundClassyfireController_13.update(fakeValue[play.mvc.Http.Request], fakeValue[Int], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundClassyfireController",
      "update",
      Seq(classOf[play.mvc.Http.Request], classOf[Int], classOf[String]),
      "PUT",
      this.prefix + """compoundClassyfire/""" + "$" + """compoundId<[^/]+>/""" + "$" + """nodeId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:131
  private[this] lazy val controllers_CompoundClassyfireController_delete97_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundClassyfire/"), DynamicPart("compoundId", """[^/]+""",true), StaticPart("/"), DynamicPart("nodeId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CompoundClassyfireController_delete97_invoker = createInvoker(
    CompoundClassyfireController_13.delete(fakeValue[Int], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundClassyfireController",
      "delete",
      Seq(classOf[Int], classOf[String]),
      "DELETE",
      this.prefix + """compoundClassyfire/""" + "$" + """compoundId<[^/]+>/""" + "$" + """nodeId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:132
  private[this] lazy val controllers_CompoundClassyfireController_patchCompoundClassyfire98_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundClassyfire/"), DynamicPart("compoundId", """[^/]+""",true), StaticPart("/"), DynamicPart("nodeId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CompoundClassyfireController_patchCompoundClassyfire98_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      CompoundClassyfireController_13.patchCompoundClassyfire(fakeValue[play.mvc.Http.Request], fakeValue[Int], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundClassyfireController",
      "patchCompoundClassyfire",
      Seq(classOf[play.mvc.Http.Request], classOf[Int], classOf[String]),
      "PATCH",
      this.prefix + """compoundClassyfire/""" + "$" + """compoundId<[^/]+>/""" + "$" + """nodeId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:135
  private[this] lazy val controllers_CompoundOntologyController_retrieve99_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundOntology/"), DynamicPart("compoundId", """[^/]+""",true), StaticPart("/"), DynamicPart("ontologyTermId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CompoundOntologyController_retrieve99_invoker = createInvoker(
    CompoundOntologyController_4.retrieve(fakeValue[Int], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundOntologyController",
      "retrieve",
      Seq(classOf[Int], classOf[Int]),
      "GET",
      this.prefix + """compoundOntology/""" + "$" + """compoundId<[^/]+>/""" + "$" + """ontologyTermId<[^/]+>""",
      """ APIs for CompoundOntology""",
      Seq()
    )
  )

  // @LINE:136
  private[this] lazy val controllers_CompoundOntologyController_listCompoundOntology100_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundOntology/list")))
  )
  private[this] lazy val controllers_CompoundOntologyController_listCompoundOntology100_invoker = createInvoker(
    CompoundOntologyController_4.listCompoundOntology(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundOntologyController",
      "listCompoundOntology",
      Nil,
      "GET",
      this.prefix + """compoundOntology/list""",
      """""",
      Seq()
    )
  )

  // @LINE:137
  private[this] lazy val controllers_CompoundOntologyController_listCompoundOntologyInRange101_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundOntology")))
  )
  private[this] lazy val controllers_CompoundOntologyController_listCompoundOntologyInRange101_invoker = createInvoker(
    CompoundOntologyController_4.listCompoundOntologyInRange(fakeValue[Int], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundOntologyController",
      "listCompoundOntologyInRange",
      Seq(classOf[Int], classOf[Int]),
      "GET",
      this.prefix + """compoundOntology""",
      """""",
      Seq()
    )
  )

  // @LINE:138
  private[this] lazy val controllers_CompoundOntologyController_listCompoundOntologyByCompoundId102_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundOntology/"), DynamicPart("compoundId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CompoundOntologyController_listCompoundOntologyByCompoundId102_invoker = createInvoker(
    CompoundOntologyController_4.listCompoundOntologyByCompoundId(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundOntologyController",
      "listCompoundOntologyByCompoundId",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """compoundOntology/""" + "$" + """compoundId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:139
  private[this] lazy val controllers_CompoundOntologyController_create103_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundOntology")))
  )
  private[this] lazy val controllers_CompoundOntologyController_create103_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      CompoundOntologyController_4.create(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundOntologyController",
      "create",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """compoundOntology""",
      """""",
      Seq()
    )
  )

  // @LINE:140
  private[this] lazy val controllers_CompoundOntologyController_update104_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundOntology/"), DynamicPart("compoundId", """[^/]+""",true), StaticPart("/"), DynamicPart("ontologyTermId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CompoundOntologyController_update104_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      CompoundOntologyController_4.update(fakeValue[play.mvc.Http.Request], fakeValue[Int], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundOntologyController",
      "update",
      Seq(classOf[play.mvc.Http.Request], classOf[Int], classOf[Int]),
      "PUT",
      this.prefix + """compoundOntology/""" + "$" + """compoundId<[^/]+>/""" + "$" + """ontologyTermId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:141
  private[this] lazy val controllers_CompoundOntologyController_delete105_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundOntology/"), DynamicPart("compoundId", """[^/]+""",true), StaticPart("/"), DynamicPart("ontologyTermId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CompoundOntologyController_delete105_invoker = createInvoker(
    CompoundOntologyController_4.delete(fakeValue[Int], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundOntologyController",
      "delete",
      Seq(classOf[Int], classOf[Int]),
      "DELETE",
      this.prefix + """compoundOntology/""" + "$" + """compoundId<[^/]+>/""" + "$" + """ontologyTermId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:142
  private[this] lazy val controllers_CompoundOntologyController_patchCompoundOntology106_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundOntology/"), DynamicPart("compoundId", """[^/]+""",true), StaticPart("/"), DynamicPart("ontologyTermId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CompoundOntologyController_patchCompoundOntology106_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      CompoundOntologyController_4.patchCompoundOntology(fakeValue[play.mvc.Http.Request], fakeValue[Int], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundOntologyController",
      "patchCompoundOntology",
      Seq(classOf[play.mvc.Http.Request], classOf[Int], classOf[Int]),
      "PATCH",
      this.prefix + """compoundOntology/""" + "$" + """compoundId<[^/]+>/""" + "$" + """ontologyTermId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:145
  private[this] lazy val controllers_CompoundPathwaysController_retrieve107_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundPathways/"), DynamicPart("compoundId", """[^/]+""",true), StaticPart("/"), DynamicPart("pathwayId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CompoundPathwaysController_retrieve107_invoker = createInvoker(
    CompoundPathwaysController_8.retrieve(fakeValue[Int], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundPathwaysController",
      "retrieve",
      Seq(classOf[Int], classOf[Int]),
      "GET",
      this.prefix + """compoundPathways/""" + "$" + """compoundId<[^/]+>/""" + "$" + """pathwayId<[^/]+>""",
      """ APIs for CompoundPathways""",
      Seq()
    )
  )

  // @LINE:146
  private[this] lazy val controllers_CompoundPathwaysController_listCompoundPathways108_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundPathways/list")))
  )
  private[this] lazy val controllers_CompoundPathwaysController_listCompoundPathways108_invoker = createInvoker(
    CompoundPathwaysController_8.listCompoundPathways(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundPathwaysController",
      "listCompoundPathways",
      Nil,
      "GET",
      this.prefix + """compoundPathways/list""",
      """""",
      Seq()
    )
  )

  // @LINE:147
  private[this] lazy val controllers_CompoundPathwaysController_listCompoundPathwaysInRange109_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundPathways")))
  )
  private[this] lazy val controllers_CompoundPathwaysController_listCompoundPathwaysInRange109_invoker = createInvoker(
    CompoundPathwaysController_8.listCompoundPathwaysInRange(fakeValue[Int], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundPathwaysController",
      "listCompoundPathwaysInRange",
      Seq(classOf[Int], classOf[Int]),
      "GET",
      this.prefix + """compoundPathways""",
      """""",
      Seq()
    )
  )

  // @LINE:148
  private[this] lazy val controllers_CompoundPathwaysController_listCompoundPathwaysByCompoundId110_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundPathways/"), DynamicPart("compoundId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CompoundPathwaysController_listCompoundPathwaysByCompoundId110_invoker = createInvoker(
    CompoundPathwaysController_8.listCompoundPathwaysByCompoundId(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundPathwaysController",
      "listCompoundPathwaysByCompoundId",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """compoundPathways/""" + "$" + """compoundId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:149
  private[this] lazy val controllers_CompoundPathwaysController_create111_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundPathways")))
  )
  private[this] lazy val controllers_CompoundPathwaysController_create111_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      CompoundPathwaysController_8.create(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundPathwaysController",
      "create",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """compoundPathways""",
      """""",
      Seq()
    )
  )

  // @LINE:150
  private[this] lazy val controllers_CompoundPathwaysController_update112_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundPathways/"), DynamicPart("compoundId", """[^/]+""",true), StaticPart("/"), DynamicPart("pathwayId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CompoundPathwaysController_update112_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      CompoundPathwaysController_8.update(fakeValue[play.mvc.Http.Request], fakeValue[Int], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundPathwaysController",
      "update",
      Seq(classOf[play.mvc.Http.Request], classOf[Int], classOf[Int]),
      "PUT",
      this.prefix + """compoundPathways/""" + "$" + """compoundId<[^/]+>/""" + "$" + """pathwayId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:151
  private[this] lazy val controllers_CompoundPathwaysController_delete113_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundPathways/"), DynamicPart("compoundId", """[^/]+""",true), StaticPart("/"), DynamicPart("pathwayId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CompoundPathwaysController_delete113_invoker = createInvoker(
    CompoundPathwaysController_8.delete(fakeValue[Int], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundPathwaysController",
      "delete",
      Seq(classOf[Int], classOf[Int]),
      "DELETE",
      this.prefix + """compoundPathways/""" + "$" + """compoundId<[^/]+>/""" + "$" + """pathwayId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:152
  private[this] lazy val controllers_CompoundPathwaysController_patchCompoundPathways114_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundPathways/"), DynamicPart("compoundId", """[^/]+""",true), StaticPart("/"), DynamicPart("pathwayId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CompoundPathwaysController_patchCompoundPathways114_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      CompoundPathwaysController_8.patchCompoundPathways(fakeValue[play.mvc.Http.Request], fakeValue[Int], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundPathwaysController",
      "patchCompoundPathways",
      Seq(classOf[play.mvc.Http.Request], classOf[Int], classOf[Int]),
      "PATCH",
      this.prefix + """compoundPathways/""" + "$" + """compoundId<[^/]+>/""" + "$" + """pathwayId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:155
  private[this] lazy val controllers_CompoundsGenController_listCompoundsGen115_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundsGen/list")))
  )
  private[this] lazy val controllers_CompoundsGenController_listCompoundsGen115_invoker = createInvoker(
    CompoundsGenController_16.listCompoundsGen(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundsGenController",
      "listCompoundsGen",
      Nil,
      "GET",
      this.prefix + """compoundsGen/list""",
      """ APIs in CompoundGenController""",
      Seq()
    )
  )

  // @LINE:156
  private[this] lazy val controllers_CompoundsGenController_listCompoundsGenInRange116_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundsGen")))
  )
  private[this] lazy val controllers_CompoundsGenController_listCompoundsGenInRange116_invoker = createInvoker(
    CompoundsGenController_16.listCompoundsGenInRange(fakeValue[Int], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundsGenController",
      "listCompoundsGenInRange",
      Seq(classOf[Int], classOf[Int]),
      "GET",
      this.prefix + """compoundsGen""",
      """""",
      Seq()
    )
  )

  // @LINE:157
  private[this] lazy val controllers_CompoundsGenController_retrieve117_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundsGen/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CompoundsGenController_retrieve117_invoker = createInvoker(
    CompoundsGenController_16.retrieve(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundsGenController",
      "retrieve",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """compoundsGen/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:158
  private[this] lazy val controllers_CompoundsGenController_create118_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundsGen")))
  )
  private[this] lazy val controllers_CompoundsGenController_create118_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      CompoundsGenController_16.create(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundsGenController",
      "create",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """compoundsGen""",
      """""",
      Seq()
    )
  )

  // @LINE:159
  private[this] lazy val controllers_CompoundsGenController_update119_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundsGen/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CompoundsGenController_update119_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      CompoundsGenController_16.update(fakeValue[play.mvc.Http.Request], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundsGenController",
      "update",
      Seq(classOf[play.mvc.Http.Request], classOf[Int]),
      "PUT",
      this.prefix + """compoundsGen/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:160
  private[this] lazy val controllers_CompoundsGenController_delete120_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundsGen/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CompoundsGenController_delete120_invoker = createInvoker(
    CompoundsGenController_16.delete(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundsGenController",
      "delete",
      Seq(classOf[Int]),
      "DELETE",
      this.prefix + """compoundsGen/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:161
  private[this] lazy val controllers_CompoundsGenController_patchCompoundsGen121_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compoundsGen/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CompoundsGenController_patchCompoundsGen121_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      CompoundsGenController_16.patchCompoundsGen(fakeValue[play.mvc.Http.Request], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundsGenController",
      "patchCompoundsGen",
      Seq(classOf[play.mvc.Http.Request], classOf[Int]),
      "PATCH",
      this.prefix + """compoundsGen/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:164
  private[this] lazy val controllers_Assets_versioned122_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned122_invoker = createInvoker(
    Assets_15.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_17.index())
      }
  
    // @LINE:9
    case controllers_EmployeeController_listEmployees1_route(params@_) =>
      call { 
        controllers_EmployeeController_listEmployees1_invoker.call(EmployeeController_7.listEmployees())
      }
  
    // @LINE:10
    case controllers_EmployeeController_retrieve2_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_EmployeeController_retrieve2_invoker.call(EmployeeController_7.retrieve(id))
      }
  
    // @LINE:11
    case controllers_EmployeeController_create3_route(params@_) =>
      call { 
        controllers_EmployeeController_create3_invoker.call(
          req => EmployeeController_7.create(req))
      }
  
    // @LINE:12
    case controllers_EmployeeController_update4_route(params@_) =>
      call { 
        controllers_EmployeeController_update4_invoker.call(
          req => EmployeeController_7.update(req))
      }
  
    // @LINE:13
    case controllers_EmployeeController_delete5_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_EmployeeController_delete5_invoker.call(EmployeeController_7.delete(id))
      }
  
    // @LINE:16
    case controllers_CompoundController_listCompounds6_route(params@_) =>
      call { 
        controllers_CompoundController_listCompounds6_invoker.call(CompoundController_0.listCompounds())
      }
  
    // @LINE:17
    case controllers_CompoundController_listCompoundsInRange7_route(params@_) =>
      call(params.fromQuery[Int]("startId", None), params.fromQuery[Int]("endId", None)) { (startId, endId) =>
        controllers_CompoundController_listCompoundsInRange7_invoker.call(CompoundController_0.listCompoundsInRange(startId, endId))
      }
  
    // @LINE:18
    case controllers_CompoundController_retrieve8_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CompoundController_retrieve8_invoker.call(CompoundController_0.retrieve(id))
      }
  
    // @LINE:19
    case controllers_CompoundController_create9_route(params@_) =>
      call { 
        controllers_CompoundController_create9_invoker.call(
          req => CompoundController_0.create(req))
      }
  
    // @LINE:20
    case controllers_CompoundController_update10_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CompoundController_update10_invoker.call(
          req => CompoundController_0.update(req, id))
      }
  
    // @LINE:21
    case controllers_CompoundController_delete11_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CompoundController_delete11_invoker.call(CompoundController_0.delete(id))
      }
  
    // @LINE:22
    case controllers_CompoundController_patchCompound12_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CompoundController_patchCompound12_invoker.call(
          req => CompoundController_0.patchCompound(req, id))
      }
  
    // @LINE:25
    case controllers_PathwayController_listPathways13_route(params@_) =>
      call { 
        controllers_PathwayController_listPathways13_invoker.call(PathwayController_18.listPathways())
      }
  
    // @LINE:26
    case controllers_PathwayController_listPathwaysInRange14_route(params@_) =>
      call(params.fromQuery[Int]("startId", None), params.fromQuery[Int]("endId", None)) { (startId, endId) =>
        controllers_PathwayController_listPathwaysInRange14_invoker.call(PathwayController_18.listPathwaysInRange(startId, endId))
      }
  
    // @LINE:27
    case controllers_PathwayController_retrieve15_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_PathwayController_retrieve15_invoker.call(PathwayController_18.retrieve(id))
      }
  
    // @LINE:28
    case controllers_PathwayController_create16_route(params@_) =>
      call { 
        controllers_PathwayController_create16_invoker.call(
          req => PathwayController_18.create(req))
      }
  
    // @LINE:29
    case controllers_PathwayController_update17_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_PathwayController_update17_invoker.call(
          req => PathwayController_18.update(req, id))
      }
  
    // @LINE:30
    case controllers_PathwayController_delete18_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_PathwayController_delete18_invoker.call(PathwayController_18.delete(id))
      }
  
    // @LINE:31
    case controllers_PathwayController_patchPathway19_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_PathwayController_patchPathway19_invoker.call(
          req => PathwayController_18.patchPathway(req, id))
      }
  
    // @LINE:34
    case controllers_MsmsController_listMsms20_route(params@_) =>
      call { 
        controllers_MsmsController_listMsms20_invoker.call(MsmsController_6.listMsms())
      }
  
    // @LINE:35
    case controllers_MsmsController_listMsmsInRange21_route(params@_) =>
      call(params.fromQuery[Int]("startId", None), params.fromQuery[Int]("endId", None)) { (startId, endId) =>
        controllers_MsmsController_listMsmsInRange21_invoker.call(MsmsController_6.listMsmsInRange(startId, endId))
      }
  
    // @LINE:36
    case controllers_MsmsController_retrieve22_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_MsmsController_retrieve22_invoker.call(MsmsController_6.retrieve(id))
      }
  
    // @LINE:37
    case controllers_MsmsController_create23_route(params@_) =>
      call { 
        controllers_MsmsController_create23_invoker.call(
          req => MsmsController_6.create(req))
      }
  
    // @LINE:38
    case controllers_MsmsController_update24_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_MsmsController_update24_invoker.call(
          req => MsmsController_6.update(req, id))
      }
  
    // @LINE:39
    case controllers_MsmsController_delete25_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_MsmsController_delete25_invoker.call(MsmsController_6.delete(id))
      }
  
    // @LINE:40
    case controllers_MsmsController_patchMsms26_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_MsmsController_patchMsms26_invoker.call(
          req => MsmsController_6.patchMsms(req, id))
      }
  
    // @LINE:43
    case controllers_CeEffMobController_listCeEffMobs27_route(params@_) =>
      call { 
        controllers_CeEffMobController_listCeEffMobs27_invoker.call(CeEffMobController_10.listCeEffMobs())
      }
  
    // @LINE:44
    case controllers_CeEffMobController_listCeEffMobsInRange28_route(params@_) =>
      call(params.fromQuery[Int]("startId", None), params.fromQuery[Int]("endId", None)) { (startId, endId) =>
        controllers_CeEffMobController_listCeEffMobsInRange28_invoker.call(CeEffMobController_10.listCeEffMobsInRange(startId, endId))
      }
  
    // @LINE:45
    case controllers_CeEffMobController_retrieve29_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CeEffMobController_retrieve29_invoker.call(CeEffMobController_10.retrieve(id))
      }
  
    // @LINE:46
    case controllers_CeEffMobController_create30_route(params@_) =>
      call { 
        controllers_CeEffMobController_create30_invoker.call(
          req => CeEffMobController_10.create(req))
      }
  
    // @LINE:47
    case controllers_CeEffMobController_update31_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CeEffMobController_update31_invoker.call(
          req => CeEffMobController_10.update(req, id))
      }
  
    // @LINE:48
    case controllers_CeEffMobController_delete32_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CeEffMobController_delete32_invoker.call(CeEffMobController_10.delete(id))
      }
  
    // @LINE:49
    case controllers_CeEffMobController_patchCeEffMob33_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CeEffMobController_patchCeEffMob33_invoker.call(
          req => CeEffMobController_10.patchCeEffMob(req, id))
      }
  
    // @LINE:52
    case controllers_ChainsController_listChains34_route(params@_) =>
      call { 
        controllers_ChainsController_listChains34_invoker.call(ChainsController_9.listChains())
      }
  
    // @LINE:53
    case controllers_ChainsController_listChainsInRange35_route(params@_) =>
      call(params.fromQuery[Int]("startId", None), params.fromQuery[Int]("endId", None)) { (startId, endId) =>
        controllers_ChainsController_listChainsInRange35_invoker.call(ChainsController_9.listChainsInRange(startId, endId))
      }
  
    // @LINE:54
    case controllers_ChainsController_retrieve36_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_ChainsController_retrieve36_invoker.call(ChainsController_9.retrieve(id))
      }
  
    // @LINE:55
    case controllers_ChainsController_create37_route(params@_) =>
      call { 
        controllers_ChainsController_create37_invoker.call(
          req => ChainsController_9.create(req))
      }
  
    // @LINE:56
    case controllers_ChainsController_update38_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_ChainsController_update38_invoker.call(
          req => ChainsController_9.update(req, id))
      }
  
    // @LINE:57
    case controllers_ChainsController_delete39_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_ChainsController_delete39_invoker.call(ChainsController_9.delete(id))
      }
  
    // @LINE:58
    case controllers_ChainsController_patchChains40_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_ChainsController_patchChains40_invoker.call(
          req => ChainsController_9.patchChains(req, id))
      }
  
    // @LINE:61
    case controllers_OntologyTermsController_listOntologyTerms41_route(params@_) =>
      call { 
        controllers_OntologyTermsController_listOntologyTerms41_invoker.call(OntologyTermsController_11.listOntologyTerms())
      }
  
    // @LINE:62
    case controllers_OntologyTermsController_listOntologyTermsInRange42_route(params@_) =>
      call(params.fromQuery[Int]("startId", None), params.fromQuery[Int]("endId", None)) { (startId, endId) =>
        controllers_OntologyTermsController_listOntologyTermsInRange42_invoker.call(OntologyTermsController_11.listOntologyTermsInRange(startId, endId))
      }
  
    // @LINE:63
    case controllers_OntologyTermsController_retrieve43_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_OntologyTermsController_retrieve43_invoker.call(OntologyTermsController_11.retrieve(id))
      }
  
    // @LINE:64
    case controllers_OntologyTermsController_create44_route(params@_) =>
      call { 
        controllers_OntologyTermsController_create44_invoker.call(
          req => OntologyTermsController_11.create(req))
      }
  
    // @LINE:65
    case controllers_OntologyTermsController_update45_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_OntologyTermsController_update45_invoker.call(
          req => OntologyTermsController_11.update(req, id))
      }
  
    // @LINE:66
    case controllers_OntologyTermsController_delete46_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_OntologyTermsController_delete46_invoker.call(OntologyTermsController_11.delete(id))
      }
  
    // @LINE:67
    case controllers_OntologyTermsController_patchOntologyTerms47_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_OntologyTermsController_patchOntologyTerms47_invoker.call(
          req => OntologyTermsController_11.patchOntologyTerms(req, id))
      }
  
    // @LINE:70
    case controllers_ClassyfireClassificationController_listClassyfireClassifications48_route(params@_) =>
      call { 
        controllers_ClassyfireClassificationController_listClassyfireClassifications48_invoker.call(ClassyfireClassificationController_12.listClassyfireClassifications())
      }
  
    // @LINE:71
    case controllers_ClassyfireClassificationController_listClassyfireClassificationInRange49_route(params@_) =>
      call(params.fromQuery[Int]("startId", None), params.fromQuery[Int]("endId", None)) { (startId, endId) =>
        controllers_ClassyfireClassificationController_listClassyfireClassificationInRange49_invoker.call(ClassyfireClassificationController_12.listClassyfireClassificationInRange(startId, endId))
      }
  
    // @LINE:72
    case controllers_ClassyfireClassificationController_retrieve50_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_ClassyfireClassificationController_retrieve50_invoker.call(ClassyfireClassificationController_12.retrieve(id))
      }
  
    // @LINE:73
    case controllers_ClassyfireClassificationController_create51_route(params@_) =>
      call { 
        controllers_ClassyfireClassificationController_create51_invoker.call(
          req => ClassyfireClassificationController_12.create(req))
      }
  
    // @LINE:74
    case controllers_ClassyfireClassificationController_update52_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_ClassyfireClassificationController_update52_invoker.call(
          req => ClassyfireClassificationController_12.update(req, id))
      }
  
    // @LINE:75
    case controllers_ClassyfireClassificationController_delete53_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_ClassyfireClassificationController_delete53_invoker.call(ClassyfireClassificationController_12.delete(id))
      }
  
    // @LINE:76
    case controllers_ClassyfireClassificationController_patchClassyfireClassification54_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_ClassyfireClassificationController_patchClassyfireClassification54_invoker.call(
          req => ClassyfireClassificationController_12.patchClassyfireClassification(req, id))
      }
  
    // @LINE:79
    case controllers_CeExperimentalPropertiesController_listCeExperimentalProperties55_route(params@_) =>
      call { 
        controllers_CeExperimentalPropertiesController_listCeExperimentalProperties55_invoker.call(CeExperimentalPropertiesController_2.listCeExperimentalProperties())
      }
  
    // @LINE:80
    case controllers_CeExperimentalPropertiesController_listCeExperimentalPropertiesInRange56_route(params@_) =>
      call(params.fromQuery[Int]("startId", None), params.fromQuery[Int]("endId", None)) { (startId, endId) =>
        controllers_CeExperimentalPropertiesController_listCeExperimentalPropertiesInRange56_invoker.call(CeExperimentalPropertiesController_2.listCeExperimentalPropertiesInRange(startId, endId))
      }
  
    // @LINE:81
    case controllers_CeExperimentalPropertiesController_retrieve57_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CeExperimentalPropertiesController_retrieve57_invoker.call(CeExperimentalPropertiesController_2.retrieve(id))
      }
  
    // @LINE:82
    case controllers_CeExperimentalPropertiesController_create58_route(params@_) =>
      call { 
        controllers_CeExperimentalPropertiesController_create58_invoker.call(
          req => CeExperimentalPropertiesController_2.create(req))
      }
  
    // @LINE:83
    case controllers_CeExperimentalPropertiesController_update59_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CeExperimentalPropertiesController_update59_invoker.call(
          req => CeExperimentalPropertiesController_2.update(req, id))
      }
  
    // @LINE:84
    case controllers_CeExperimentalPropertiesController_delete60_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CeExperimentalPropertiesController_delete60_invoker.call(CeExperimentalPropertiesController_2.delete(id))
      }
  
    // @LINE:85
    case controllers_CeExperimentalPropertiesController_patchCeExperimentalProperties61_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CeExperimentalPropertiesController_patchCeExperimentalProperties61_invoker.call(
          req => CeExperimentalPropertiesController_2.patchCeExperimentalProperties(req, id))
      }
  
    // @LINE:88
    case controllers_CompoundCasController_listCompoundCas62_route(params@_) =>
      call { 
        controllers_CompoundCasController_listCompoundCas62_invoker.call(CompoundCasController_1.listCompoundCas())
      }
  
    // @LINE:89
    case controllers_CompoundCasController_listCompoundCasInRange63_route(params@_) =>
      call(params.fromQuery[String]("startId", None), params.fromQuery[String]("endId", None)) { (startId, endId) =>
        controllers_CompoundCasController_listCompoundCasInRange63_invoker.call(CompoundCasController_1.listCompoundCasInRange(startId, endId))
      }
  
    // @LINE:90
    case controllers_CompoundCasController_retrieve64_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_CompoundCasController_retrieve64_invoker.call(CompoundCasController_1.retrieve(id))
      }
  
    // @LINE:91
    case controllers_CompoundCasController_create65_route(params@_) =>
      call { 
        controllers_CompoundCasController_create65_invoker.call(
          req => CompoundCasController_1.create(req))
      }
  
    // @LINE:92
    case controllers_CompoundCasController_update66_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_CompoundCasController_update66_invoker.call(
          req => CompoundCasController_1.update(req, id))
      }
  
    // @LINE:93
    case controllers_CompoundCasController_delete67_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_CompoundCasController_delete67_invoker.call(CompoundCasController_1.delete(id))
      }
  
    // @LINE:94
    case controllers_CompoundCasController_patchCompoundCas68_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_CompoundCasController_patchCompoundCas68_invoker.call(
          req => CompoundCasController_1.patchCompoundCas(req, id))
      }
  
    // @LINE:97
    case controllers_CeExpPropMetadataController_listCeExpPropMetadata69_route(params@_) =>
      call { 
        controllers_CeExpPropMetadataController_listCeExpPropMetadata69_invoker.call(CeExpPropMetadataController_3.listCeExpPropMetadata())
      }
  
    // @LINE:98
    case controllers_CeExpPropMetadataController_listCeExpPropMetadataInRange70_route(params@_) =>
      call(params.fromQuery[Int]("startId", None), params.fromQuery[Int]("endId", None)) { (startId, endId) =>
        controllers_CeExpPropMetadataController_listCeExpPropMetadataInRange70_invoker.call(CeExpPropMetadataController_3.listCeExpPropMetadataInRange(startId, endId))
      }
  
    // @LINE:99
    case controllers_CeExpPropMetadataController_retrieve71_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CeExpPropMetadataController_retrieve71_invoker.call(CeExpPropMetadataController_3.retrieve(id))
      }
  
    // @LINE:100
    case controllers_CeExpPropMetadataController_create72_route(params@_) =>
      call { 
        controllers_CeExpPropMetadataController_create72_invoker.call(
          req => CeExpPropMetadataController_3.create(req))
      }
  
    // @LINE:101
    case controllers_CeExpPropMetadataController_update73_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CeExpPropMetadataController_update73_invoker.call(
          req => CeExpPropMetadataController_3.update(req, id))
      }
  
    // @LINE:102
    case controllers_CeExpPropMetadataController_delete74_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CeExpPropMetadataController_delete74_invoker.call(CeExpPropMetadataController_3.delete(id))
      }
  
    // @LINE:103
    case controllers_CeExpPropMetadataController_patchCeExpPropMetadata75_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CeExpPropMetadataController_patchCeExpPropMetadata75_invoker.call(
          req => CeExpPropMetadataController_3.patchCeExpPropMetadata(req, id))
      }
  
    // @LINE:106
    case controllers_CompoundCeProductIonController_listCompoundCeProductIon76_route(params@_) =>
      call { 
        controllers_CompoundCeProductIonController_listCompoundCeProductIon76_invoker.call(CompoundCeProductIonController_14.listCompoundCeProductIon())
      }
  
    // @LINE:107
    case controllers_CompoundCeProductIonController_listCompoundCeProductIonInRange77_route(params@_) =>
      call(params.fromQuery[Int]("startId", None), params.fromQuery[Int]("endId", None)) { (startId, endId) =>
        controllers_CompoundCeProductIonController_listCompoundCeProductIonInRange77_invoker.call(CompoundCeProductIonController_14.listCompoundCeProductIonInRange(startId, endId))
      }
  
    // @LINE:108
    case controllers_CompoundCeProductIonController_retrieve78_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CompoundCeProductIonController_retrieve78_invoker.call(CompoundCeProductIonController_14.retrieve(id))
      }
  
    // @LINE:109
    case controllers_CompoundCeProductIonController_create79_route(params@_) =>
      call { 
        controllers_CompoundCeProductIonController_create79_invoker.call(
          req => CompoundCeProductIonController_14.create(req))
      }
  
    // @LINE:110
    case controllers_CompoundCeProductIonController_update80_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CompoundCeProductIonController_update80_invoker.call(
          req => CompoundCeProductIonController_14.update(req, id))
      }
  
    // @LINE:111
    case controllers_CompoundCeProductIonController_delete81_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CompoundCeProductIonController_delete81_invoker.call(CompoundCeProductIonController_14.delete(id))
      }
  
    // @LINE:112
    case controllers_CompoundCeProductIonController_patchCompoundCeProductIon82_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CompoundCeProductIonController_patchCompoundCeProductIon82_invoker.call(
          req => CompoundCeProductIonController_14.patchCompoundCeProductIon(req, id))
      }
  
    // @LINE:115
    case controllers_CompoundChainController_retrieve83_route(params@_) =>
      call(params.fromPath[Int]("compoundId", None), params.fromPath[Int]("chainId", None)) { (compoundId, chainId) =>
        controllers_CompoundChainController_retrieve83_invoker.call(CompoundChainController_5.retrieve(compoundId, chainId))
      }
  
    // @LINE:116
    case controllers_CompoundChainController_listCompoundChain84_route(params@_) =>
      call { 
        controllers_CompoundChainController_listCompoundChain84_invoker.call(CompoundChainController_5.listCompoundChain())
      }
  
    // @LINE:117
    case controllers_CompoundChainController_listCompoundChainInRange85_route(params@_) =>
      call(params.fromQuery[Int]("startId", None), params.fromQuery[Int]("endId", None)) { (startId, endId) =>
        controllers_CompoundChainController_listCompoundChainInRange85_invoker.call(CompoundChainController_5.listCompoundChainInRange(startId, endId))
      }
  
    // @LINE:118
    case controllers_CompoundChainController_listCompoundChainByCompoundId86_route(params@_) =>
      call(params.fromPath[Int]("compoundId", None)) { (compoundId) =>
        controllers_CompoundChainController_listCompoundChainByCompoundId86_invoker.call(CompoundChainController_5.listCompoundChainByCompoundId(compoundId))
      }
  
    // @LINE:119
    case controllers_CompoundChainController_create87_route(params@_) =>
      call { 
        controllers_CompoundChainController_create87_invoker.call(
          req => CompoundChainController_5.create(req))
      }
  
    // @LINE:120
    case controllers_CompoundChainController_update88_route(params@_) =>
      call(params.fromPath[Int]("compoundId", None), params.fromPath[Int]("chainId", None)) { (compoundId, chainId) =>
        controllers_CompoundChainController_update88_invoker.call(
          req => CompoundChainController_5.update(req, compoundId, chainId))
      }
  
    // @LINE:121
    case controllers_CompoundChainController_delete89_route(params@_) =>
      call(params.fromPath[Int]("compoundId", None), params.fromPath[Int]("chainId", None)) { (compoundId, chainId) =>
        controllers_CompoundChainController_delete89_invoker.call(CompoundChainController_5.delete(compoundId, chainId))
      }
  
    // @LINE:122
    case controllers_CompoundChainController_patchCompoundChain90_route(params@_) =>
      call(params.fromPath[Int]("compoundId", None), params.fromPath[Int]("chainId", None)) { (compoundId, chainId) =>
        controllers_CompoundChainController_patchCompoundChain90_invoker.call(
          req => CompoundChainController_5.patchCompoundChain(req, compoundId, chainId))
      }
  
    // @LINE:125
    case controllers_CompoundClassyfireController_retrieve91_route(params@_) =>
      call(params.fromPath[Int]("compoundId", None), params.fromPath[String]("nodeId", None)) { (compoundId, nodeId) =>
        controllers_CompoundClassyfireController_retrieve91_invoker.call(CompoundClassyfireController_13.retrieve(compoundId, nodeId))
      }
  
    // @LINE:126
    case controllers_CompoundClassyfireController_listCompoundClassyfire92_route(params@_) =>
      call { 
        controllers_CompoundClassyfireController_listCompoundClassyfire92_invoker.call(CompoundClassyfireController_13.listCompoundClassyfire())
      }
  
    // @LINE:127
    case controllers_CompoundClassyfireController_listCompoundClassyfireInRange93_route(params@_) =>
      call(params.fromQuery[Int]("startId", None), params.fromQuery[Int]("endId", None)) { (startId, endId) =>
        controllers_CompoundClassyfireController_listCompoundClassyfireInRange93_invoker.call(CompoundClassyfireController_13.listCompoundClassyfireInRange(startId, endId))
      }
  
    // @LINE:128
    case controllers_CompoundClassyfireController_listCompoundClassyfireByCompoundId94_route(params@_) =>
      call(params.fromPath[Int]("compoundId", None)) { (compoundId) =>
        controllers_CompoundClassyfireController_listCompoundClassyfireByCompoundId94_invoker.call(CompoundClassyfireController_13.listCompoundClassyfireByCompoundId(compoundId))
      }
  
    // @LINE:129
    case controllers_CompoundClassyfireController_create95_route(params@_) =>
      call { 
        controllers_CompoundClassyfireController_create95_invoker.call(
          req => CompoundClassyfireController_13.create(req))
      }
  
    // @LINE:130
    case controllers_CompoundClassyfireController_update96_route(params@_) =>
      call(params.fromPath[Int]("compoundId", None), params.fromPath[String]("nodeId", None)) { (compoundId, nodeId) =>
        controllers_CompoundClassyfireController_update96_invoker.call(
          req => CompoundClassyfireController_13.update(req, compoundId, nodeId))
      }
  
    // @LINE:131
    case controllers_CompoundClassyfireController_delete97_route(params@_) =>
      call(params.fromPath[Int]("compoundId", None), params.fromPath[String]("nodeId", None)) { (compoundId, nodeId) =>
        controllers_CompoundClassyfireController_delete97_invoker.call(CompoundClassyfireController_13.delete(compoundId, nodeId))
      }
  
    // @LINE:132
    case controllers_CompoundClassyfireController_patchCompoundClassyfire98_route(params@_) =>
      call(params.fromPath[Int]("compoundId", None), params.fromPath[String]("nodeId", None)) { (compoundId, nodeId) =>
        controllers_CompoundClassyfireController_patchCompoundClassyfire98_invoker.call(
          req => CompoundClassyfireController_13.patchCompoundClassyfire(req, compoundId, nodeId))
      }
  
    // @LINE:135
    case controllers_CompoundOntologyController_retrieve99_route(params@_) =>
      call(params.fromPath[Int]("compoundId", None), params.fromPath[Int]("ontologyTermId", None)) { (compoundId, ontologyTermId) =>
        controllers_CompoundOntologyController_retrieve99_invoker.call(CompoundOntologyController_4.retrieve(compoundId, ontologyTermId))
      }
  
    // @LINE:136
    case controllers_CompoundOntologyController_listCompoundOntology100_route(params@_) =>
      call { 
        controllers_CompoundOntologyController_listCompoundOntology100_invoker.call(CompoundOntologyController_4.listCompoundOntology())
      }
  
    // @LINE:137
    case controllers_CompoundOntologyController_listCompoundOntologyInRange101_route(params@_) =>
      call(params.fromQuery[Int]("startId", None), params.fromQuery[Int]("endId", None)) { (startId, endId) =>
        controllers_CompoundOntologyController_listCompoundOntologyInRange101_invoker.call(CompoundOntologyController_4.listCompoundOntologyInRange(startId, endId))
      }
  
    // @LINE:138
    case controllers_CompoundOntologyController_listCompoundOntologyByCompoundId102_route(params@_) =>
      call(params.fromPath[Int]("compoundId", None)) { (compoundId) =>
        controllers_CompoundOntologyController_listCompoundOntologyByCompoundId102_invoker.call(CompoundOntologyController_4.listCompoundOntologyByCompoundId(compoundId))
      }
  
    // @LINE:139
    case controllers_CompoundOntologyController_create103_route(params@_) =>
      call { 
        controllers_CompoundOntologyController_create103_invoker.call(
          req => CompoundOntologyController_4.create(req))
      }
  
    // @LINE:140
    case controllers_CompoundOntologyController_update104_route(params@_) =>
      call(params.fromPath[Int]("compoundId", None), params.fromPath[Int]("ontologyTermId", None)) { (compoundId, ontologyTermId) =>
        controllers_CompoundOntologyController_update104_invoker.call(
          req => CompoundOntologyController_4.update(req, compoundId, ontologyTermId))
      }
  
    // @LINE:141
    case controllers_CompoundOntologyController_delete105_route(params@_) =>
      call(params.fromPath[Int]("compoundId", None), params.fromPath[Int]("ontologyTermId", None)) { (compoundId, ontologyTermId) =>
        controllers_CompoundOntologyController_delete105_invoker.call(CompoundOntologyController_4.delete(compoundId, ontologyTermId))
      }
  
    // @LINE:142
    case controllers_CompoundOntologyController_patchCompoundOntology106_route(params@_) =>
      call(params.fromPath[Int]("compoundId", None), params.fromPath[Int]("ontologyTermId", None)) { (compoundId, ontologyTermId) =>
        controllers_CompoundOntologyController_patchCompoundOntology106_invoker.call(
          req => CompoundOntologyController_4.patchCompoundOntology(req, compoundId, ontologyTermId))
      }
  
    // @LINE:145
    case controllers_CompoundPathwaysController_retrieve107_route(params@_) =>
      call(params.fromPath[Int]("compoundId", None), params.fromPath[Int]("pathwayId", None)) { (compoundId, pathwayId) =>
        controllers_CompoundPathwaysController_retrieve107_invoker.call(CompoundPathwaysController_8.retrieve(compoundId, pathwayId))
      }
  
    // @LINE:146
    case controllers_CompoundPathwaysController_listCompoundPathways108_route(params@_) =>
      call { 
        controllers_CompoundPathwaysController_listCompoundPathways108_invoker.call(CompoundPathwaysController_8.listCompoundPathways())
      }
  
    // @LINE:147
    case controllers_CompoundPathwaysController_listCompoundPathwaysInRange109_route(params@_) =>
      call(params.fromQuery[Int]("startId", None), params.fromQuery[Int]("endId", None)) { (startId, endId) =>
        controllers_CompoundPathwaysController_listCompoundPathwaysInRange109_invoker.call(CompoundPathwaysController_8.listCompoundPathwaysInRange(startId, endId))
      }
  
    // @LINE:148
    case controllers_CompoundPathwaysController_listCompoundPathwaysByCompoundId110_route(params@_) =>
      call(params.fromPath[Int]("compoundId", None)) { (compoundId) =>
        controllers_CompoundPathwaysController_listCompoundPathwaysByCompoundId110_invoker.call(CompoundPathwaysController_8.listCompoundPathwaysByCompoundId(compoundId))
      }
  
    // @LINE:149
    case controllers_CompoundPathwaysController_create111_route(params@_) =>
      call { 
        controllers_CompoundPathwaysController_create111_invoker.call(
          req => CompoundPathwaysController_8.create(req))
      }
  
    // @LINE:150
    case controllers_CompoundPathwaysController_update112_route(params@_) =>
      call(params.fromPath[Int]("compoundId", None), params.fromPath[Int]("pathwayId", None)) { (compoundId, pathwayId) =>
        controllers_CompoundPathwaysController_update112_invoker.call(
          req => CompoundPathwaysController_8.update(req, compoundId, pathwayId))
      }
  
    // @LINE:151
    case controllers_CompoundPathwaysController_delete113_route(params@_) =>
      call(params.fromPath[Int]("compoundId", None), params.fromPath[Int]("pathwayId", None)) { (compoundId, pathwayId) =>
        controllers_CompoundPathwaysController_delete113_invoker.call(CompoundPathwaysController_8.delete(compoundId, pathwayId))
      }
  
    // @LINE:152
    case controllers_CompoundPathwaysController_patchCompoundPathways114_route(params@_) =>
      call(params.fromPath[Int]("compoundId", None), params.fromPath[Int]("pathwayId", None)) { (compoundId, pathwayId) =>
        controllers_CompoundPathwaysController_patchCompoundPathways114_invoker.call(
          req => CompoundPathwaysController_8.patchCompoundPathways(req, compoundId, pathwayId))
      }
  
    // @LINE:155
    case controllers_CompoundsGenController_listCompoundsGen115_route(params@_) =>
      call { 
        controllers_CompoundsGenController_listCompoundsGen115_invoker.call(CompoundsGenController_16.listCompoundsGen())
      }
  
    // @LINE:156
    case controllers_CompoundsGenController_listCompoundsGenInRange116_route(params@_) =>
      call(params.fromQuery[Int]("startId", None), params.fromQuery[Int]("endId", None)) { (startId, endId) =>
        controllers_CompoundsGenController_listCompoundsGenInRange116_invoker.call(CompoundsGenController_16.listCompoundsGenInRange(startId, endId))
      }
  
    // @LINE:157
    case controllers_CompoundsGenController_retrieve117_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CompoundsGenController_retrieve117_invoker.call(CompoundsGenController_16.retrieve(id))
      }
  
    // @LINE:158
    case controllers_CompoundsGenController_create118_route(params@_) =>
      call { 
        controllers_CompoundsGenController_create118_invoker.call(
          req => CompoundsGenController_16.create(req))
      }
  
    // @LINE:159
    case controllers_CompoundsGenController_update119_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CompoundsGenController_update119_invoker.call(
          req => CompoundsGenController_16.update(req, id))
      }
  
    // @LINE:160
    case controllers_CompoundsGenController_delete120_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CompoundsGenController_delete120_invoker.call(CompoundsGenController_16.delete(id))
      }
  
    // @LINE:161
    case controllers_CompoundsGenController_patchCompoundsGen121_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CompoundsGenController_patchCompoundsGen121_invoker.call(
          req => CompoundsGenController_16.patchCompoundsGen(req, id))
      }
  
    // @LINE:164
    case controllers_Assets_versioned122_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned122_invoker.call(Assets_15.versioned(path, file))
      }
  }
}
