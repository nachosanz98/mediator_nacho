// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

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
  
    // @LINE:17
    def listCompoundsInRange: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundController.listCompoundsInRange",
      """
        function(startId0,endId1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compounds/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("startId", startId0)) + "-" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("endId", endId1))})
        }
      """
    )
  
    // @LINE:20
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundController.update",
      """
        function() {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "compounds/"})
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
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:25
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
