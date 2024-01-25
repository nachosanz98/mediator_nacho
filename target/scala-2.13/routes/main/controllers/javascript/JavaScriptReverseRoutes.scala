// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:115
  class ReverseCompoundChainController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:116
    def listCompoundChain: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundChainController.listCompoundChain",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundChain/list"})
        }
      """
    )
  
    // @LINE:117
    def listCompoundChainInRange: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundChainController.listCompoundChainInRange",
      """
        function(startId0,endId1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundChain" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("startId", startId0), (""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("endId", endId1)])})
        }
      """
    )
  
    // @LINE:118
    def listCompoundChainByCompoundId: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundChainController.listCompoundChainByCompoundId",
      """
        function(compoundId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundChain/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("compoundId", compoundId0))})
        }
      """
    )
  
    // @LINE:122
    def patchCompoundChain: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundChainController.patchCompoundChain",
      """
        function(compoundId0,chainId1) {
          return _wA({method:"PATCH", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundChain/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("compoundId", compoundId0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("chainId", chainId1))})
        }
      """
    )
  
    // @LINE:115
    def retrieve: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundChainController.retrieve",
      """
        function(compoundId0,chainId1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundChain/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("compoundId", compoundId0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("chainId", chainId1))})
        }
      """
    )
  
    // @LINE:120
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundChainController.update",
      """
        function(compoundId0,chainId1) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundChain/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("compoundId", compoundId0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("chainId", chainId1))})
        }
      """
    )
  
    // @LINE:119
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundChainController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundChain"})
        }
      """
    )
  
    // @LINE:121
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundChainController.delete",
      """
        function(compoundId0,chainId1) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundChain/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("compoundId", compoundId0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("chainId", chainId1))})
        }
      """
    )
  
  }

  // @LINE:164
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:164
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
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compounds/list"})
        }
      """
    )
  
    // @LINE:20
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundController.update",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "compounds/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:17
    def listCompoundsInRange: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundController.listCompoundsInRange",
      """
        function(startId0,endId1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compounds" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("startId", startId0), (""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("endId", endId1)])})
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

  // @LINE:70
  class ReverseClassyfireClassificationController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:75
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ClassyfireClassificationController.delete",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "classyfireclassification/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:74
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ClassyfireClassificationController.update",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "classyfireclassification/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:70
    def listClassyfireClassifications: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ClassyfireClassificationController.listClassyfireClassifications",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "classyfireclassification/list"})
        }
      """
    )
  
    // @LINE:71
    def listClassyfireClassificationInRange: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ClassyfireClassificationController.listClassyfireClassificationInRange",
      """
        function(startId0,endId1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "classyfireclassification" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("startId", startId0), (""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("endId", endId1)])})
        }
      """
    )
  
    // @LINE:72
    def retrieve: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ClassyfireClassificationController.retrieve",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "classyfireclassification/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:76
    def patchClassyfireClassification: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ClassyfireClassificationController.patchClassyfireClassification",
      """
        function(id0) {
          return _wA({method:"PATCH", url:"""" + _prefix + { _defaultPrefix } + """" + "classyfireclassification/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:73
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ClassyfireClassificationController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "classyfireclassification"})
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
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pathways/list"})
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
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "pathways/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:26
    def listPathwaysInRange: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PathwayController.listPathwaysInRange",
      """
        function(startId0,endId1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pathways" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("startId", startId0), (""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("endId", endId1)])})
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
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ceEffMob" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("startId", startId0), (""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("endId", endId1)])})
        }
      """
    )
  
    // @LINE:43
    def listCeEffMobs: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CeEffMobController.listCeEffMobs",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ceEffMob/list"})
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
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "ceEffMob/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
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

  // @LINE:155
  class ReverseCompoundsGenController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:161
    def patchCompoundsGen: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundsGenController.patchCompoundsGen",
      """
        function(id0) {
          return _wA({method:"PATCH", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundsGen/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:155
    def listCompoundsGen: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundsGenController.listCompoundsGen",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundsGen/list"})
        }
      """
    )
  
    // @LINE:160
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundsGenController.delete",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundsGen/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:159
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundsGenController.update",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundsGen/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:157
    def retrieve: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundsGenController.retrieve",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundsGen/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:156
    def listCompoundsGenInRange: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundsGenController.listCompoundsGenInRange",
      """
        function(startId0,endId1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundsGen" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("startId", startId0), (""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("endId", endId1)])})
        }
      """
    )
  
    // @LINE:158
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundsGenController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundsGen"})
        }
      """
    )
  
  }

  // @LINE:61
  class ReverseOntologyTermsController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:66
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OntologyTermsController.delete",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "ontologyTerms/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:65
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OntologyTermsController.update",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "ontologyTerms/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:61
    def listOntologyTerms: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OntologyTermsController.listOntologyTerms",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ontologyTerms/list"})
        }
      """
    )
  
    // @LINE:62
    def listOntologyTermsInRange: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OntologyTermsController.listOntologyTermsInRange",
      """
        function(startId0,endId1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ontologyTerms" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("startId", startId0), (""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("endId", endId1)])})
        }
      """
    )
  
    // @LINE:63
    def retrieve: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OntologyTermsController.retrieve",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ontologyTerms/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:67
    def patchOntologyTerms: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OntologyTermsController.patchOntologyTerms",
      """
        function(id0) {
          return _wA({method:"PATCH", url:"""" + _prefix + { _defaultPrefix } + """" + "ontologyTerms/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:64
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OntologyTermsController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ontologyTerms"})
        }
      """
    )
  
  }

  // @LINE:79
  class ReverseCeExperimentalPropertiesController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:79
    def listCeExperimentalProperties: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CeExperimentalPropertiesController.listCeExperimentalProperties",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ceExpProps/list"})
        }
      """
    )
  
    // @LINE:84
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CeExperimentalPropertiesController.delete",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "ceExpProps/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:83
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CeExperimentalPropertiesController.update",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "ceExpProps/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:85
    def patchCeExperimentalProperties: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CeExperimentalPropertiesController.patchCeExperimentalProperties",
      """
        function(id0) {
          return _wA({method:"PATCH", url:"""" + _prefix + { _defaultPrefix } + """" + "ceExpProps/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:81
    def retrieve: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CeExperimentalPropertiesController.retrieve",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ceExpProps/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:82
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CeExperimentalPropertiesController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ceExpProps"})
        }
      """
    )
  
    // @LINE:80
    def listCeExperimentalPropertiesInRange: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CeExperimentalPropertiesController.listCeExperimentalPropertiesInRange",
      """
        function(startId0,endId1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ceExpProps" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("startId", startId0), (""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("endId", endId1)])})
        }
      """
    )
  
  }

  // @LINE:125
  class ReverseCompoundClassyfireController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:127
    def listCompoundClassyfireInRange: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundClassyfireController.listCompoundClassyfireInRange",
      """
        function(startId0,endId1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundClassyfire" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("startId", startId0), (""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("endId", endId1)])})
        }
      """
    )
  
    // @LINE:128
    def listCompoundClassyfireByCompoundId: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundClassyfireController.listCompoundClassyfireByCompoundId",
      """
        function(compoundId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundClassyfire/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("compoundId", compoundId0))})
        }
      """
    )
  
    // @LINE:125
    def retrieve: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundClassyfireController.retrieve",
      """
        function(compoundId0,nodeId1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundClassyfire/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("compoundId", compoundId0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("nodeId", nodeId1))})
        }
      """
    )
  
    // @LINE:131
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundClassyfireController.delete",
      """
        function(compoundId0,nodeId1) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundClassyfire/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("compoundId", compoundId0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("nodeId", nodeId1))})
        }
      """
    )
  
    // @LINE:126
    def listCompoundClassyfire: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundClassyfireController.listCompoundClassyfire",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundClassyfire/list"})
        }
      """
    )
  
    // @LINE:130
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundClassyfireController.update",
      """
        function(compoundId0,nodeId1) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundClassyfire/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("compoundId", compoundId0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("nodeId", nodeId1))})
        }
      """
    )
  
    // @LINE:129
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundClassyfireController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundClassyfire"})
        }
      """
    )
  
    // @LINE:132
    def patchCompoundClassyfire: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundClassyfireController.patchCompoundClassyfire",
      """
        function(compoundId0,nodeId1) {
          return _wA({method:"PATCH", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundClassyfire/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("compoundId", compoundId0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("nodeId", nodeId1))})
        }
      """
    )
  
  }

  // @LINE:106
  class ReverseCompoundCeProductIonController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:111
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundCeProductIonController.delete",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundCeProductIon/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:107
    def listCompoundCeProductIonInRange: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundCeProductIonController.listCompoundCeProductIonInRange",
      """
        function(startId0,endId1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundCeProductIon" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("startId", startId0), (""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("endId", endId1)])})
        }
      """
    )
  
    // @LINE:110
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundCeProductIonController.update",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundCeProductIon/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:112
    def patchCompoundCeProductIon: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundCeProductIonController.patchCompoundCeProductIon",
      """
        function(id0) {
          return _wA({method:"PATCH", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundCeProductIon/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:108
    def retrieve: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundCeProductIonController.retrieve",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundCeProductIon/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:106
    def listCompoundCeProductIon: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundCeProductIonController.listCompoundCeProductIon",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundCeProductIon/list"})
        }
      """
    )
  
    // @LINE:109
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundCeProductIonController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundCeProductIon"})
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

  // @LINE:97
  class ReverseCeExpPropMetadataController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:97
    def listCeExpPropMetadata: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CeExpPropMetadataController.listCeExpPropMetadata",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ceExpPropMetadata/list"})
        }
      """
    )
  
    // @LINE:102
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CeExpPropMetadataController.delete",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "ceExpPropMetadata/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:101
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CeExpPropMetadataController.update",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "ceExpPropMetadata/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:103
    def patchCeExpPropMetadata: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CeExpPropMetadataController.patchCeExpPropMetadata",
      """
        function(id0) {
          return _wA({method:"PATCH", url:"""" + _prefix + { _defaultPrefix } + """" + "ceExpPropMetadata/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:99
    def retrieve: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CeExpPropMetadataController.retrieve",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ceExpPropMetadata/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:100
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CeExpPropMetadataController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ceExpPropMetadata"})
        }
      """
    )
  
    // @LINE:98
    def listCeExpPropMetadataInRange: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CeExpPropMetadataController.listCeExpPropMetadataInRange",
      """
        function(startId0,endId1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ceExpPropMetadata" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("startId", startId0), (""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("endId", endId1)])})
        }
      """
    )
  
  }

  // @LINE:135
  class ReverseCompoundOntologyController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:142
    def patchCompoundOntology: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundOntologyController.patchCompoundOntology",
      """
        function(compoundId0,ontologyTermId1) {
          return _wA({method:"PATCH", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundOntology/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("compoundId", compoundId0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("ontologyTermId", ontologyTermId1))})
        }
      """
    )
  
    // @LINE:135
    def retrieve: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundOntologyController.retrieve",
      """
        function(compoundId0,ontologyTermId1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundOntology/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("compoundId", compoundId0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("ontologyTermId", ontologyTermId1))})
        }
      """
    )
  
    // @LINE:140
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundOntologyController.update",
      """
        function(compoundId0,ontologyTermId1) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundOntology/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("compoundId", compoundId0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("ontologyTermId", ontologyTermId1))})
        }
      """
    )
  
    // @LINE:137
    def listCompoundOntologyInRange: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundOntologyController.listCompoundOntologyInRange",
      """
        function(startId0,endId1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundOntology" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("startId", startId0), (""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("endId", endId1)])})
        }
      """
    )
  
    // @LINE:136
    def listCompoundOntology: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundOntologyController.listCompoundOntology",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundOntology/list"})
        }
      """
    )
  
    // @LINE:138
    def listCompoundOntologyByCompoundId: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundOntologyController.listCompoundOntologyByCompoundId",
      """
        function(compoundId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundOntology/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("compoundId", compoundId0))})
        }
      """
    )
  
    // @LINE:139
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundOntologyController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundOntology"})
        }
      """
    )
  
    // @LINE:141
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundOntologyController.delete",
      """
        function(compoundId0,ontologyTermId1) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundOntology/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("compoundId", compoundId0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("ontologyTermId", ontologyTermId1))})
        }
      """
    )
  
  }

  // @LINE:145
  class ReverseCompoundPathwaysController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:147
    def listCompoundPathwaysInRange: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundPathwaysController.listCompoundPathwaysInRange",
      """
        function(startId0,endId1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundPathways" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("startId", startId0), (""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("endId", endId1)])})
        }
      """
    )
  
    // @LINE:145
    def retrieve: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundPathwaysController.retrieve",
      """
        function(compoundId0,pathwayId1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundPathways/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("compoundId", compoundId0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("pathwayId", pathwayId1))})
        }
      """
    )
  
    // @LINE:152
    def patchCompoundPathways: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundPathwaysController.patchCompoundPathways",
      """
        function(compoundId0,pathwayId1) {
          return _wA({method:"PATCH", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundPathways/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("compoundId", compoundId0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("pathwayId", pathwayId1))})
        }
      """
    )
  
    // @LINE:150
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundPathwaysController.update",
      """
        function(compoundId0,pathwayId1) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundPathways/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("compoundId", compoundId0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("pathwayId", pathwayId1))})
        }
      """
    )
  
    // @LINE:148
    def listCompoundPathwaysByCompoundId: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundPathwaysController.listCompoundPathwaysByCompoundId",
      """
        function(compoundId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundPathways/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("compoundId", compoundId0))})
        }
      """
    )
  
    // @LINE:146
    def listCompoundPathways: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundPathwaysController.listCompoundPathways",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundPathways/list"})
        }
      """
    )
  
    // @LINE:149
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundPathwaysController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundPathways"})
        }
      """
    )
  
    // @LINE:151
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundPathwaysController.delete",
      """
        function(compoundId0,pathwayId1) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundPathways/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("compoundId", compoundId0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("pathwayId", pathwayId1))})
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
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "msms" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("startId", startId0), (""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("endId", endId1)])})
        }
      """
    )
  
    // @LINE:38
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MsmsController.update",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "msms/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:34
    def listMsms: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MsmsController.listMsms",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "msms/list"})
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
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "chains/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:52
    def listChains: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ChainsController.listChains",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "chains/list"})
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
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "chains" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("startId", startId0), (""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("endId", endId1)])})
        }
      """
    )
  
  }

  // @LINE:88
  class ReverseCompoundCasController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:89
    def listCompoundCasInRange: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundCasController.listCompoundCasInRange",
      """
        function(startId0,endId1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundCas" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("startId", startId0), (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("endId", endId1)])})
        }
      """
    )
  
    // @LINE:90
    def retrieve: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundCasController.retrieve",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundCas/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:93
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundCasController.delete",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundCas/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:92
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundCasController.update",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundCas/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:94
    def patchCompoundCas: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundCasController.patchCompoundCas",
      """
        function(id0) {
          return _wA({method:"PATCH", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundCas/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:88
    def listCompoundCas: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundCasController.listCompoundCas",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundCas/list"})
        }
      """
    )
  
    // @LINE:91
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompoundCasController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compoundCas"})
        }
      """
    )
  
  }


}
