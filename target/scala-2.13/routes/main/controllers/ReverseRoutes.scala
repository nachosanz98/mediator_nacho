// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:61
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:61
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
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
  
    // @LINE:20
    def update(id:Int): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "compounds/" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("id", id)))))
    }
  
    // @LINE:17
    def listCompoundsInRange(startId:Int, endId:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "compounds/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("startId", startId)) + "-" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("endId", endId)))
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
  class ReversePathwayController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:25
    def listPathways(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "pathways")
    }
  
    // @LINE:30
    def delete(id:Int): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "pathways/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:29
    def update(id:Int): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "pathways/" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("id", id)))))
    }
  
    // @LINE:26
    def listPathwaysInRange(startId:Int, endId:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "pathways/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("startId", startId)) + "-" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("endId", endId)))
    }
  
    // @LINE:31
    def patchPathway(id:Int): Call = {
      
      Call("PATCH", _prefix + { _defaultPrefix } + "pathways/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:27
    def retrieve(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "pathways/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:28
    def create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "pathways")
    }
  
  }

  // @LINE:43
  class ReverseCeEffMobController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:44
    def listCeEffMobsInRange(startId:Int, endId:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ceEffMob/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("startId", startId)) + "-" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("endId", endId)))
    }
  
    // @LINE:43
    def listCeEffMobs(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ceEffMob")
    }
  
    // @LINE:48
    def delete(id:Int): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "ceEffMob/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:47
    def update(id:Int): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "ceEffMob/" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("id", id)))))
    }
  
    // @LINE:49
    def patchCeEffMob(id:Int): Call = {
      
      Call("PATCH", _prefix + { _defaultPrefix } + "ceEffMob/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:45
    def retrieve(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ceEffMob/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:46
    def create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "ceEffMob")
    }
  
  }

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

  // @LINE:34
  class ReverseMsmsController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:39
    def delete(id:Int): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "msms/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:35
    def listMsmsInRange(startId:Int, endId:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "msms/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("startId", startId)) + "-" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("endId", endId)))
    }
  
    // @LINE:38
    def update(id:Int): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "msms/" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("id", id)))))
    }
  
    // @LINE:34
    def listMsms(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "msms")
    }
  
    // @LINE:40
    def patchMsms(id:Int): Call = {
      
      Call("PATCH", _prefix + { _defaultPrefix } + "msms/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:36
    def retrieve(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "msms/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:37
    def create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "msms")
    }
  
  }

  // @LINE:52
  class ReverseChainsController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:57
    def delete(id:Int): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "chains/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:56
    def update(id:Int): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "chains/" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("id", id)))))
    }
  
    // @LINE:52
    def listChains(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "chains")
    }
  
    // @LINE:54
    def retrieve(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "chains/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:58
    def patchChains(id:Int): Call = {
      
      Call("PATCH", _prefix + { _defaultPrefix } + "chains/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:55
    def create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "chains")
    }
  
    // @LINE:53
    def listChainsInRange(startId:Int, endId:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "chains/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("startId", startId)) + "-" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("endId", endId)))
    }
  
  }


}
