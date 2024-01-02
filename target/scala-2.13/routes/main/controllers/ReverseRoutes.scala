// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:9
  class ReverseEmployeeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def delete(id:Int): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "employees/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:9
    def listEmployees(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "employees")
    }
  
    // @LINE:12
    def update(): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "employees/")
    }
  
    // @LINE:10
    def retrieve(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "employees/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:11
    def create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "employees")
    }
  
  }

  // @LINE:16
  class ReverseCompoundController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:22
    def patchCompound(id:Int): Call = {
      
      Call("PATCH", _prefix + { _defaultPrefix } + "compounds/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:21
    def delete(id:Int): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "compounds/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:16
    def listCompounds(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "compounds")
    }
  
    // @LINE:17
    def listCompoundsInRange(startId:Int, endId:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "compounds/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("startId", startId)) + "-" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("endId", endId)))
    }
  
    // @LINE:20
    def update(): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "compounds/")
    }
  
    // @LINE:18
    def retrieve(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "compounds/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:19
    def create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "compounds")
    }
  
  }

  // @LINE:25
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:25
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
