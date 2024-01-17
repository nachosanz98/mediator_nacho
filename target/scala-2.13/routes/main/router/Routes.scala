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
  HomeController_6: controllers.HomeController,
  // @LINE:9
  EmployeeController_2: controllers.EmployeeController,
  // @LINE:16
  CompoundController_0: controllers.CompoundController,
  // @LINE:25
  PathwayController_7: controllers.PathwayController,
  // @LINE:34
  MsmsController_1: controllers.MsmsController,
  // @LINE:43
  CeEffMobController_4: controllers.CeEffMobController,
  // @LINE:52
  ChainsController_3: controllers.ChainsController,
  // @LINE:61
  Assets_5: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_6: controllers.HomeController,
    // @LINE:9
    EmployeeController_2: controllers.EmployeeController,
    // @LINE:16
    CompoundController_0: controllers.CompoundController,
    // @LINE:25
    PathwayController_7: controllers.PathwayController,
    // @LINE:34
    MsmsController_1: controllers.MsmsController,
    // @LINE:43
    CeEffMobController_4: controllers.CeEffMobController,
    // @LINE:52
    ChainsController_3: controllers.ChainsController,
    // @LINE:61
    Assets_5: controllers.Assets
  ) = this(errorHandler, HomeController_6, EmployeeController_2, CompoundController_0, PathwayController_7, MsmsController_1, CeEffMobController_4, ChainsController_3, Assets_5, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_6, EmployeeController_2, CompoundController_0, PathwayController_7, MsmsController_1, CeEffMobController_4, ChainsController_3, Assets_5, prefix)
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
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compounds""", """controllers.CompoundController.listCompounds()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compounds/""" + "$" + """startId<[^/]+>-""" + "$" + """endId<[^/]+>""", """controllers.CompoundController.listCompoundsInRange(startId:Int, endId:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compounds/""" + "$" + """id<[^/]+>""", """controllers.CompoundController.retrieve(id:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compounds""", """controllers.CompoundController.create(request:Request)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compounds/""", """controllers.CompoundController.update(request:Request, id:Int)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compounds/""" + "$" + """id<[^/]+>""", """controllers.CompoundController.delete(id:Int)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compounds/""" + "$" + """id<[^/]+>""", """controllers.CompoundController.patchCompound(request:Request, id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """pathways""", """controllers.PathwayController.listPathways()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """pathways/""" + "$" + """startId<[^/]+>-""" + "$" + """endId<[^/]+>""", """controllers.PathwayController.listPathwaysInRange(startId:Int, endId:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """pathways/""" + "$" + """id<[^/]+>""", """controllers.PathwayController.retrieve(id:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """pathways""", """controllers.PathwayController.create(request:Request)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """pathways/""", """controllers.PathwayController.update(request:Request, id:Int)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """pathways/""" + "$" + """id<[^/]+>""", """controllers.PathwayController.delete(id:Int)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """pathways/""" + "$" + """id<[^/]+>""", """controllers.PathwayController.patchPathway(request:Request, id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """msms""", """controllers.MsmsController.listMsms()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """msms/""" + "$" + """startId<[^/]+>-""" + "$" + """endId<[^/]+>""", """controllers.MsmsController.listMsmsInRange(startId:Int, endId:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """msms/""" + "$" + """id<[^/]+>""", """controllers.MsmsController.retrieve(id:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """msms""", """controllers.MsmsController.create(request:Request)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """msms/""", """controllers.MsmsController.update(request:Request, id:Int)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """msms/""" + "$" + """id<[^/]+>""", """controllers.MsmsController.delete(id:Int)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """msms/""" + "$" + """id<[^/]+>""", """controllers.MsmsController.patchMsms(request:Request, id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ceEffMob""", """controllers.CeEffMobController.listCeEffMobs()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ceEffMob/""" + "$" + """startId<[^/]+>-""" + "$" + """endId<[^/]+>""", """controllers.CeEffMobController.listCeEffMobsInRange(startId:Int, endId:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ceEffMob/""" + "$" + """id<[^/]+>""", """controllers.CeEffMobController.retrieve(id:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ceEffMob""", """controllers.CeEffMobController.create(request:Request)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ceEffMob/""", """controllers.CeEffMobController.update(request:Request, id:Int)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ceEffMob/""" + "$" + """id<[^/]+>""", """controllers.CeEffMobController.delete(id:Int)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ceEffMob/""" + "$" + """id<[^/]+>""", """controllers.CeEffMobController.patchCeEffMob(request:Request, id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """chains""", """controllers.ChainsController.listChains()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """chains/""" + "$" + """startId<[^/]+>-""" + "$" + """endId<[^/]+>""", """controllers.ChainsController.listChainsInRange(startId:Int, endId:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """chains/""" + "$" + """id<[^/]+>""", """controllers.ChainsController.retrieve(id:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """chains""", """controllers.ChainsController.create(request:Request)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """chains/""", """controllers.ChainsController.update(request:Request, id:Int)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """chains/""" + "$" + """id<[^/]+>""", """controllers.ChainsController.delete(id:Int)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """chains/""" + "$" + """id<[^/]+>""", """controllers.ChainsController.patchChains(request:Request, id:Int)"""),
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
    HomeController_6.index(),
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
    EmployeeController_2.listEmployees(),
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
    EmployeeController_2.retrieve(fakeValue[Int]),
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
      EmployeeController_2.create(fakeValue[play.mvc.Http.Request]),
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
      EmployeeController_2.update(fakeValue[play.mvc.Http.Request]),
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
    EmployeeController_2.delete(fakeValue[Int]),
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
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compounds")))
  )
  private[this] lazy val controllers_CompoundController_listCompounds6_invoker = createInvoker(
    CompoundController_0.listCompounds(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundController",
      "listCompounds",
      Nil,
      "GET",
      this.prefix + """compounds""",
      """ APIs in CompoundController""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_CompoundController_listCompoundsInRange7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compounds/"), DynamicPart("startId", """[^/]+""",true), StaticPart("-"), DynamicPart("endId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CompoundController_listCompoundsInRange7_invoker = createInvoker(
    CompoundController_0.listCompoundsInRange(fakeValue[Int], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundController",
      "listCompoundsInRange",
      Seq(classOf[Int], classOf[Int]),
      "GET",
      this.prefix + """compounds/""" + "$" + """startId<[^/]+>-""" + "$" + """endId<[^/]+>""",
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
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("compounds/")))
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
      this.prefix + """compounds/""",
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
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("pathways")))
  )
  private[this] lazy val controllers_PathwayController_listPathways13_invoker = createInvoker(
    PathwayController_7.listPathways(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PathwayController",
      "listPathways",
      Nil,
      "GET",
      this.prefix + """pathways""",
      """ APIs in Pathways""",
      Seq()
    )
  )

  // @LINE:26
  private[this] lazy val controllers_PathwayController_listPathwaysInRange14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("pathways/"), DynamicPart("startId", """[^/]+""",true), StaticPart("-"), DynamicPart("endId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PathwayController_listPathwaysInRange14_invoker = createInvoker(
    PathwayController_7.listPathwaysInRange(fakeValue[Int], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PathwayController",
      "listPathwaysInRange",
      Seq(classOf[Int], classOf[Int]),
      "GET",
      this.prefix + """pathways/""" + "$" + """startId<[^/]+>-""" + "$" + """endId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:27
  private[this] lazy val controllers_PathwayController_retrieve15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("pathways/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PathwayController_retrieve15_invoker = createInvoker(
    PathwayController_7.retrieve(fakeValue[Int]),
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
      PathwayController_7.create(fakeValue[play.mvc.Http.Request]),
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
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("pathways/")))
  )
  private[this] lazy val controllers_PathwayController_update17_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      PathwayController_7.update(fakeValue[play.mvc.Http.Request], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PathwayController",
      "update",
      Seq(classOf[play.mvc.Http.Request], classOf[Int]),
      "PUT",
      this.prefix + """pathways/""",
      """""",
      Seq()
    )
  )

  // @LINE:30
  private[this] lazy val controllers_PathwayController_delete18_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("pathways/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PathwayController_delete18_invoker = createInvoker(
    PathwayController_7.delete(fakeValue[Int]),
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
      PathwayController_7.patchPathway(fakeValue[play.mvc.Http.Request], fakeValue[Int]),
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
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("msms")))
  )
  private[this] lazy val controllers_MsmsController_listMsms20_invoker = createInvoker(
    MsmsController_1.listMsms(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MsmsController",
      "listMsms",
      Nil,
      "GET",
      this.prefix + """msms""",
      """ APIs in MsmsController""",
      Seq()
    )
  )

  // @LINE:35
  private[this] lazy val controllers_MsmsController_listMsmsInRange21_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("msms/"), DynamicPart("startId", """[^/]+""",true), StaticPart("-"), DynamicPart("endId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_MsmsController_listMsmsInRange21_invoker = createInvoker(
    MsmsController_1.listMsmsInRange(fakeValue[Int], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MsmsController",
      "listMsmsInRange",
      Seq(classOf[Int], classOf[Int]),
      "GET",
      this.prefix + """msms/""" + "$" + """startId<[^/]+>-""" + "$" + """endId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:36
  private[this] lazy val controllers_MsmsController_retrieve22_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("msms/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_MsmsController_retrieve22_invoker = createInvoker(
    MsmsController_1.retrieve(fakeValue[Int]),
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
      MsmsController_1.create(fakeValue[play.mvc.Http.Request]),
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
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("msms/")))
  )
  private[this] lazy val controllers_MsmsController_update24_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      MsmsController_1.update(fakeValue[play.mvc.Http.Request], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MsmsController",
      "update",
      Seq(classOf[play.mvc.Http.Request], classOf[Int]),
      "PUT",
      this.prefix + """msms/""",
      """""",
      Seq()
    )
  )

  // @LINE:39
  private[this] lazy val controllers_MsmsController_delete25_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("msms/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_MsmsController_delete25_invoker = createInvoker(
    MsmsController_1.delete(fakeValue[Int]),
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
      MsmsController_1.patchMsms(fakeValue[play.mvc.Http.Request], fakeValue[Int]),
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
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ceEffMob")))
  )
  private[this] lazy val controllers_CeEffMobController_listCeEffMobs27_invoker = createInvoker(
    CeEffMobController_4.listCeEffMobs(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CeEffMobController",
      "listCeEffMobs",
      Nil,
      "GET",
      this.prefix + """ceEffMob""",
      """ APIs in CeEffMobController""",
      Seq()
    )
  )

  // @LINE:44
  private[this] lazy val controllers_CeEffMobController_listCeEffMobsInRange28_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ceEffMob/"), DynamicPart("startId", """[^/]+""",true), StaticPart("-"), DynamicPart("endId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CeEffMobController_listCeEffMobsInRange28_invoker = createInvoker(
    CeEffMobController_4.listCeEffMobsInRange(fakeValue[Int], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CeEffMobController",
      "listCeEffMobsInRange",
      Seq(classOf[Int], classOf[Int]),
      "GET",
      this.prefix + """ceEffMob/""" + "$" + """startId<[^/]+>-""" + "$" + """endId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:45
  private[this] lazy val controllers_CeEffMobController_retrieve29_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ceEffMob/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CeEffMobController_retrieve29_invoker = createInvoker(
    CeEffMobController_4.retrieve(fakeValue[Int]),
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
      CeEffMobController_4.create(fakeValue[play.mvc.Http.Request]),
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
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ceEffMob/")))
  )
  private[this] lazy val controllers_CeEffMobController_update31_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      CeEffMobController_4.update(fakeValue[play.mvc.Http.Request], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CeEffMobController",
      "update",
      Seq(classOf[play.mvc.Http.Request], classOf[Int]),
      "PUT",
      this.prefix + """ceEffMob/""",
      """""",
      Seq()
    )
  )

  // @LINE:48
  private[this] lazy val controllers_CeEffMobController_delete32_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ceEffMob/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CeEffMobController_delete32_invoker = createInvoker(
    CeEffMobController_4.delete(fakeValue[Int]),
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
      CeEffMobController_4.patchCeEffMob(fakeValue[play.mvc.Http.Request], fakeValue[Int]),
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
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("chains")))
  )
  private[this] lazy val controllers_ChainsController_listChains34_invoker = createInvoker(
    ChainsController_3.listChains(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ChainsController",
      "listChains",
      Nil,
      "GET",
      this.prefix + """chains""",
      """ APIs in ChainsController""",
      Seq()
    )
  )

  // @LINE:53
  private[this] lazy val controllers_ChainsController_listChainsInRange35_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("chains/"), DynamicPart("startId", """[^/]+""",true), StaticPart("-"), DynamicPart("endId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ChainsController_listChainsInRange35_invoker = createInvoker(
    ChainsController_3.listChainsInRange(fakeValue[Int], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ChainsController",
      "listChainsInRange",
      Seq(classOf[Int], classOf[Int]),
      "GET",
      this.prefix + """chains/""" + "$" + """startId<[^/]+>-""" + "$" + """endId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:54
  private[this] lazy val controllers_ChainsController_retrieve36_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("chains/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ChainsController_retrieve36_invoker = createInvoker(
    ChainsController_3.retrieve(fakeValue[Int]),
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
      ChainsController_3.create(fakeValue[play.mvc.Http.Request]),
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
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("chains/")))
  )
  private[this] lazy val controllers_ChainsController_update38_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      ChainsController_3.update(fakeValue[play.mvc.Http.Request], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ChainsController",
      "update",
      Seq(classOf[play.mvc.Http.Request], classOf[Int]),
      "PUT",
      this.prefix + """chains/""",
      """""",
      Seq()
    )
  )

  // @LINE:57
  private[this] lazy val controllers_ChainsController_delete39_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("chains/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ChainsController_delete39_invoker = createInvoker(
    ChainsController_3.delete(fakeValue[Int]),
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
      ChainsController_3.patchChains(fakeValue[play.mvc.Http.Request], fakeValue[Int]),
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
  private[this] lazy val controllers_Assets_versioned41_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned41_invoker = createInvoker(
    Assets_5.versioned(fakeValue[String], fakeValue[Asset]),
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
        controllers_HomeController_index0_invoker.call(HomeController_6.index())
      }
  
    // @LINE:9
    case controllers_EmployeeController_listEmployees1_route(params@_) =>
      call { 
        controllers_EmployeeController_listEmployees1_invoker.call(EmployeeController_2.listEmployees())
      }
  
    // @LINE:10
    case controllers_EmployeeController_retrieve2_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_EmployeeController_retrieve2_invoker.call(EmployeeController_2.retrieve(id))
      }
  
    // @LINE:11
    case controllers_EmployeeController_create3_route(params@_) =>
      call { 
        controllers_EmployeeController_create3_invoker.call(
          req => EmployeeController_2.create(req))
      }
  
    // @LINE:12
    case controllers_EmployeeController_update4_route(params@_) =>
      call { 
        controllers_EmployeeController_update4_invoker.call(
          req => EmployeeController_2.update(req))
      }
  
    // @LINE:13
    case controllers_EmployeeController_delete5_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_EmployeeController_delete5_invoker.call(EmployeeController_2.delete(id))
      }
  
    // @LINE:16
    case controllers_CompoundController_listCompounds6_route(params@_) =>
      call { 
        controllers_CompoundController_listCompounds6_invoker.call(CompoundController_0.listCompounds())
      }
  
    // @LINE:17
    case controllers_CompoundController_listCompoundsInRange7_route(params@_) =>
      call(params.fromPath[Int]("startId", None), params.fromPath[Int]("endId", None)) { (startId, endId) =>
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
      call(params.fromQuery[Int]("id", None)) { (id) =>
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
        controllers_PathwayController_listPathways13_invoker.call(PathwayController_7.listPathways())
      }
  
    // @LINE:26
    case controllers_PathwayController_listPathwaysInRange14_route(params@_) =>
      call(params.fromPath[Int]("startId", None), params.fromPath[Int]("endId", None)) { (startId, endId) =>
        controllers_PathwayController_listPathwaysInRange14_invoker.call(PathwayController_7.listPathwaysInRange(startId, endId))
      }
  
    // @LINE:27
    case controllers_PathwayController_retrieve15_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_PathwayController_retrieve15_invoker.call(PathwayController_7.retrieve(id))
      }
  
    // @LINE:28
    case controllers_PathwayController_create16_route(params@_) =>
      call { 
        controllers_PathwayController_create16_invoker.call(
          req => PathwayController_7.create(req))
      }
  
    // @LINE:29
    case controllers_PathwayController_update17_route(params@_) =>
      call(params.fromQuery[Int]("id", None)) { (id) =>
        controllers_PathwayController_update17_invoker.call(
          req => PathwayController_7.update(req, id))
      }
  
    // @LINE:30
    case controllers_PathwayController_delete18_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_PathwayController_delete18_invoker.call(PathwayController_7.delete(id))
      }
  
    // @LINE:31
    case controllers_PathwayController_patchPathway19_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_PathwayController_patchPathway19_invoker.call(
          req => PathwayController_7.patchPathway(req, id))
      }
  
    // @LINE:34
    case controllers_MsmsController_listMsms20_route(params@_) =>
      call { 
        controllers_MsmsController_listMsms20_invoker.call(MsmsController_1.listMsms())
      }
  
    // @LINE:35
    case controllers_MsmsController_listMsmsInRange21_route(params@_) =>
      call(params.fromPath[Int]("startId", None), params.fromPath[Int]("endId", None)) { (startId, endId) =>
        controllers_MsmsController_listMsmsInRange21_invoker.call(MsmsController_1.listMsmsInRange(startId, endId))
      }
  
    // @LINE:36
    case controllers_MsmsController_retrieve22_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_MsmsController_retrieve22_invoker.call(MsmsController_1.retrieve(id))
      }
  
    // @LINE:37
    case controllers_MsmsController_create23_route(params@_) =>
      call { 
        controllers_MsmsController_create23_invoker.call(
          req => MsmsController_1.create(req))
      }
  
    // @LINE:38
    case controllers_MsmsController_update24_route(params@_) =>
      call(params.fromQuery[Int]("id", None)) { (id) =>
        controllers_MsmsController_update24_invoker.call(
          req => MsmsController_1.update(req, id))
      }
  
    // @LINE:39
    case controllers_MsmsController_delete25_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_MsmsController_delete25_invoker.call(MsmsController_1.delete(id))
      }
  
    // @LINE:40
    case controllers_MsmsController_patchMsms26_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_MsmsController_patchMsms26_invoker.call(
          req => MsmsController_1.patchMsms(req, id))
      }
  
    // @LINE:43
    case controllers_CeEffMobController_listCeEffMobs27_route(params@_) =>
      call { 
        controllers_CeEffMobController_listCeEffMobs27_invoker.call(CeEffMobController_4.listCeEffMobs())
      }
  
    // @LINE:44
    case controllers_CeEffMobController_listCeEffMobsInRange28_route(params@_) =>
      call(params.fromPath[Int]("startId", None), params.fromPath[Int]("endId", None)) { (startId, endId) =>
        controllers_CeEffMobController_listCeEffMobsInRange28_invoker.call(CeEffMobController_4.listCeEffMobsInRange(startId, endId))
      }
  
    // @LINE:45
    case controllers_CeEffMobController_retrieve29_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CeEffMobController_retrieve29_invoker.call(CeEffMobController_4.retrieve(id))
      }
  
    // @LINE:46
    case controllers_CeEffMobController_create30_route(params@_) =>
      call { 
        controllers_CeEffMobController_create30_invoker.call(
          req => CeEffMobController_4.create(req))
      }
  
    // @LINE:47
    case controllers_CeEffMobController_update31_route(params@_) =>
      call(params.fromQuery[Int]("id", None)) { (id) =>
        controllers_CeEffMobController_update31_invoker.call(
          req => CeEffMobController_4.update(req, id))
      }
  
    // @LINE:48
    case controllers_CeEffMobController_delete32_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CeEffMobController_delete32_invoker.call(CeEffMobController_4.delete(id))
      }
  
    // @LINE:49
    case controllers_CeEffMobController_patchCeEffMob33_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CeEffMobController_patchCeEffMob33_invoker.call(
          req => CeEffMobController_4.patchCeEffMob(req, id))
      }
  
    // @LINE:52
    case controllers_ChainsController_listChains34_route(params@_) =>
      call { 
        controllers_ChainsController_listChains34_invoker.call(ChainsController_3.listChains())
      }
  
    // @LINE:53
    case controllers_ChainsController_listChainsInRange35_route(params@_) =>
      call(params.fromPath[Int]("startId", None), params.fromPath[Int]("endId", None)) { (startId, endId) =>
        controllers_ChainsController_listChainsInRange35_invoker.call(ChainsController_3.listChainsInRange(startId, endId))
      }
  
    // @LINE:54
    case controllers_ChainsController_retrieve36_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_ChainsController_retrieve36_invoker.call(ChainsController_3.retrieve(id))
      }
  
    // @LINE:55
    case controllers_ChainsController_create37_route(params@_) =>
      call { 
        controllers_ChainsController_create37_invoker.call(
          req => ChainsController_3.create(req))
      }
  
    // @LINE:56
    case controllers_ChainsController_update38_route(params@_) =>
      call(params.fromQuery[Int]("id", None)) { (id) =>
        controllers_ChainsController_update38_invoker.call(
          req => ChainsController_3.update(req, id))
      }
  
    // @LINE:57
    case controllers_ChainsController_delete39_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_ChainsController_delete39_invoker.call(ChainsController_3.delete(id))
      }
  
    // @LINE:58
    case controllers_ChainsController_patchChains40_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_ChainsController_patchChains40_invoker.call(
          req => ChainsController_3.patchChains(req, id))
      }
  
    // @LINE:61
    case controllers_Assets_versioned41_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned41_invoker.call(Assets_5.versioned(path, file))
      }
  }
}
