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
  HomeController_0: controllers.HomeController,
  // @LINE:9
  EmployeeController_1: controllers.EmployeeController,
  // @LINE:16
  CompoundController_2: controllers.CompoundController,
  // @LINE:25
  Assets_3: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_0: controllers.HomeController,
    // @LINE:9
    EmployeeController_1: controllers.EmployeeController,
    // @LINE:16
    CompoundController_2: controllers.CompoundController,
    // @LINE:25
    Assets_3: controllers.Assets
  ) = this(errorHandler, HomeController_0, EmployeeController_1, CompoundController_2, Assets_3, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, EmployeeController_1, CompoundController_2, Assets_3, prefix)
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
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compounds/""", """controllers.CompoundController.update(request:Request)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compounds/""" + "$" + """id<[^/]+>""", """controllers.CompoundController.delete(id:Int)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """compounds/""" + "$" + """id<[^/]+>""", """controllers.CompoundController.patchCompound(request:Request, id:Int)"""),
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
    HomeController_0.index(),
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
    EmployeeController_1.listEmployees(),
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
    EmployeeController_1.retrieve(fakeValue[Int]),
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
      EmployeeController_1.create(fakeValue[play.mvc.Http.Request]),
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
      EmployeeController_1.update(fakeValue[play.mvc.Http.Request]),
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
    EmployeeController_1.delete(fakeValue[Int]),
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
    CompoundController_2.listCompounds(),
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
    CompoundController_2.listCompoundsInRange(fakeValue[Int], fakeValue[Int]),
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
    CompoundController_2.retrieve(fakeValue[Int]),
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
      CompoundController_2.create(fakeValue[play.mvc.Http.Request]),
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
      CompoundController_2.update(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompoundController",
      "update",
      Seq(classOf[play.mvc.Http.Request]),
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
    CompoundController_2.delete(fakeValue[Int]),
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
      CompoundController_2.patchCompound(fakeValue[play.mvc.Http.Request], fakeValue[Int]),
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
  private[this] lazy val controllers_Assets_versioned13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned13_invoker = createInvoker(
    Assets_3.versioned(fakeValue[String], fakeValue[Asset]),
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
        controllers_HomeController_index0_invoker.call(HomeController_0.index())
      }
  
    // @LINE:9
    case controllers_EmployeeController_listEmployees1_route(params@_) =>
      call { 
        controllers_EmployeeController_listEmployees1_invoker.call(EmployeeController_1.listEmployees())
      }
  
    // @LINE:10
    case controllers_EmployeeController_retrieve2_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_EmployeeController_retrieve2_invoker.call(EmployeeController_1.retrieve(id))
      }
  
    // @LINE:11
    case controllers_EmployeeController_create3_route(params@_) =>
      call { 
        controllers_EmployeeController_create3_invoker.call(
          req => EmployeeController_1.create(req))
      }
  
    // @LINE:12
    case controllers_EmployeeController_update4_route(params@_) =>
      call { 
        controllers_EmployeeController_update4_invoker.call(
          req => EmployeeController_1.update(req))
      }
  
    // @LINE:13
    case controllers_EmployeeController_delete5_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_EmployeeController_delete5_invoker.call(EmployeeController_1.delete(id))
      }
  
    // @LINE:16
    case controllers_CompoundController_listCompounds6_route(params@_) =>
      call { 
        controllers_CompoundController_listCompounds6_invoker.call(CompoundController_2.listCompounds())
      }
  
    // @LINE:17
    case controllers_CompoundController_listCompoundsInRange7_route(params@_) =>
      call(params.fromPath[Int]("startId", None), params.fromPath[Int]("endId", None)) { (startId, endId) =>
        controllers_CompoundController_listCompoundsInRange7_invoker.call(CompoundController_2.listCompoundsInRange(startId, endId))
      }
  
    // @LINE:18
    case controllers_CompoundController_retrieve8_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CompoundController_retrieve8_invoker.call(CompoundController_2.retrieve(id))
      }
  
    // @LINE:19
    case controllers_CompoundController_create9_route(params@_) =>
      call { 
        controllers_CompoundController_create9_invoker.call(
          req => CompoundController_2.create(req))
      }
  
    // @LINE:20
    case controllers_CompoundController_update10_route(params@_) =>
      call { 
        controllers_CompoundController_update10_invoker.call(
          req => CompoundController_2.update(req))
      }
  
    // @LINE:21
    case controllers_CompoundController_delete11_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CompoundController_delete11_invoker.call(CompoundController_2.delete(id))
      }
  
    // @LINE:22
    case controllers_CompoundController_patchCompound12_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CompoundController_patchCompound12_invoker.call(
          req => CompoundController_2.patchCompound(req, id))
      }
  
    // @LINE:25
    case controllers_Assets_versioned13_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned13_invoker.call(Assets_3.versioned(path, file))
      }
  }
}
