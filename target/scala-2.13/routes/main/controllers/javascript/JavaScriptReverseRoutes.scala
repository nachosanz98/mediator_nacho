// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:61
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:61
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:16
  class ReverseCompoundController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:22
    def patchCompound: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundController.patchCompound",
      """
        function(id0) {
          return _wA({method:"PATCH", url:"""" + _prefix + { _defaultPrefix } + """" + "compounds/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:21
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundController.delete",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "compounds/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:16
    def listCompounds: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundController.listCompounds",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compounds"})
        }
      """
    )
  
    // @LINE:20
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundController.update",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "compounds/" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("id", id0)])})
        }
      """
    )
  
    // @LINE:17
    def listCompoundsInRange: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundController.listCompoundsInRange",
      """
        function(startId0,endId1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compounds/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("startId", startId0)) + "-" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("endId", endId1))})
        }
      """
    )
  
    // @LINE:18
    def retrieve: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundController.retrieve",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compounds/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:19
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compounds"})
        }
      """
    )
  
  }

  // @LINE:25
  class ReversePathwayController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:25
    def listPathways: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PathwayController.listPathways",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pathways"})
        }
      """
    )
  
    // @LINE:30
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PathwayController.delete",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "pathways/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:29
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PathwayController.update",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "pathways/" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("id", id0)])})
        }
      """
    )
  
    // @LINE:26
    def listPathwaysInRange: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PathwayController.listPathwaysInRange",
      """
        function(startId0,endId1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pathways/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("startId", startId0)) + "-" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("endId", endId1))})
        }
      """
    )
  
    // @LINE:31
    def patchPathway: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PathwayController.patchPathway",
      """
        function(id0) {
          return _wA({method:"PATCH", url:"""" + _prefix + { _defaultPrefix } + """" + "pathways/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:27
    def retrieve: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PathwayController.retrieve",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pathways/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:28
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PathwayController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "pathways"})
        }
      """
    )
  
  }

  // @LINE:43
  class ReverseCeEffMobController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:44
    def listCeEffMobsInRange: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CeEffMobController.listCeEffMobsInRange",
      """
        function(startId0,endId1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ceEffMob/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("startId", startId0)) + "-" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("endId", endId1))})
        }
      """
    )
  
    // @LINE:43
    def listCeEffMobs: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CeEffMobController.listCeEffMobs",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ceEffMob"})
        }
      """
    )
  
    // @LINE:48
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CeEffMobController.delete",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "ceEffMob/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:47
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CeEffMobController.update",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "ceEffMob/" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("id", id0)])})
        }
      """
    )
  
    // @LINE:49
    def patchCeEffMob: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CeEffMobController.patchCeEffMob",
      """
        function(id0) {
          return _wA({method:"PATCH", url:"""" + _prefix + { _defaultPrefix } + """" + "ceEffMob/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:45
    def retrieve: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CeEffMobController.retrieve",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ceEffMob/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:46
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CeEffMobController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ceEffMob"})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:9
  class ReverseEmployeeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EmployeeController.delete",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "employees/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:9
    def listEmployees: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EmployeeController.listEmployees",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "employees"})
        }
      """
    )
  
    // @LINE:12
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EmployeeController.update",
      """
        function() {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "employees/"})
        }
      """
    )
  
    // @LINE:10
    def retrieve: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EmployeeController.retrieve",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "employees/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:11
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EmployeeController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "employees"})
        }
      """
    )
  
  }

  // @LINE:34
  class ReverseMsmsController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:39
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MsmsController.delete",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "msms/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:35
    def listMsmsInRange: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MsmsController.listMsmsInRange",
      """
        function(startId0,endId1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "msms/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("startId", startId0)) + "-" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("endId", endId1))})
        }
      """
    )
  
    // @LINE:38
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MsmsController.update",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "msms/" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("id", id0)])})
        }
      """
    )
  
    // @LINE:34
    def listMsms: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MsmsController.listMsms",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "msms"})
        }
      """
    )
  
    // @LINE:40
    def patchMsms: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MsmsController.patchMsms",
      """
        function(id0) {
          return _wA({method:"PATCH", url:"""" + _prefix + { _defaultPrefix } + """" + "msms/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:36
    def retrieve: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MsmsController.retrieve",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "msms/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:37
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MsmsController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "msms"})
        }
      """
    )
  
  }

  // @LINE:52
  class ReverseChainsController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:57
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ChainsController.delete",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "chains/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:56
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ChainsController.update",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "chains/" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("id", id0)])})
        }
      """
    )
  
    // @LINE:52
    def listChains: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ChainsController.listChains",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "chains"})
        }
      """
    )
  
    // @LINE:54
    def retrieve: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ChainsController.retrieve",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "chains/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:58
    def patchChains: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ChainsController.patchChains",
      """
        function(id0) {
          return _wA({method:"PATCH", url:"""" + _prefix + { _defaultPrefix } + """" + "chains/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:55
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ChainsController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "chains"})
        }
      """
    )
  
    // @LINE:53
    def listChainsInRange: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ChainsController.listChainsInRange",
      """
        function(startId0,endId1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "chains/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("startId", startId0)) + "-" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("endId", endId1))})
        }
      """
    )
  
  }


}
