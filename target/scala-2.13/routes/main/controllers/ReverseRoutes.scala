// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:115
  class ReverseCompoundChainController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:116
    def listCompoundChain(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "compoundChain/list")
    }
  
    // @LINE:117
    def listCompoundChainInRange(startId:Int, endId:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "compoundChain" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("startId", startId)), Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("endId", endId)))))
    }
  
    // @LINE:118
    def listCompoundChainByCompoundId(compoundId:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "compoundChain/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("compoundId", compoundId)))
    }
  
    // @LINE:122
    def patchCompoundChain(compoundId:Int, chainId:Int): Call = {
      
      Call("PATCH", _prefix + { _defaultPrefix } + "compoundChain/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("compoundId", compoundId)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("chainId", chainId)))
    }
  
    // @LINE:115
    def retrieve(compoundId:Int, chainId:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "compoundChain/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("compoundId", compoundId)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("chainId", chainId)))
    }
  
    // @LINE:120
    def update(compoundId:Int, chainId:Int): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "compoundChain/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("compoundId", compoundId)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("chainId", chainId)))
    }
  
    // @LINE:119
    def create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "compoundChain/")
    }
  
    // @LINE:121
    def delete(compoundId:Int, chainId:Int): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "compoundChain/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("compoundId", compoundId)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("chainId", chainId)))
    }
  
  }

  // @LINE:155
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:155
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
      
      Call("GET", _prefix + { _defaultPrefix } + "compounds/list")
    }
  
    // @LINE:20
    def update(id:Int): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "compounds/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:17
    def listCompoundsInRange(startId:Int, endId:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "compounds" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("startId", startId)), Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("endId", endId)))))
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

  // @LINE:70
  class ReverseClassyfireClassificationController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:75
    def delete(id:Int): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "classyfireclassification/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:74
    def update(id:Int): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "classyfireclassification/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:70
    def listClassyfireClassifications(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "classyfireclassification/list")
    }
  
    // @LINE:71
    def listClassyfireClassificationInRange(startId:Int, endId:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "classyfireclassification" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("startId", startId)), Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("endId", endId)))))
    }
  
    // @LINE:72
    def retrieve(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "classyfireclassification/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:76
    def patchClassyfireClassification(id:Int): Call = {
      
      Call("PATCH", _prefix + { _defaultPrefix } + "classyfireclassification/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:73
    def create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "classyfireclassification")
    }
  
  }

  // @LINE:25
  class ReversePathwayController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:25
    def listPathways(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "pathways/list")
    }
  
    // @LINE:30
    def delete(id:Int): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "pathways/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:29
    def update(id:Int): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "pathways/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:26
    def listPathwaysInRange(startId:Int, endId:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "pathways" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("startId", startId)), Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("endId", endId)))))
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
      
      Call("GET", _prefix + { _defaultPrefix } + "ceEffMob" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("startId", startId)), Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("endId", endId)))))
    }
  
    // @LINE:43
    def listCeEffMobs(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ceEffMob/list")
    }
  
    // @LINE:48
    def delete(id:Int): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "ceEffMob/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:47
    def update(id:Int): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "ceEffMob/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
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

  // @LINE:61
  class ReverseOntologyTermsController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:66
    def delete(id:Int): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "ontologyTerms/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:65
    def update(id:Int): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "ontologyTerms/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:61
    def listOntologyTerms(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ontologyTerms/list")
    }
  
    // @LINE:62
    def listOntologyTermsInRange(startId:Int, endId:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ontologyTerms" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("startId", startId)), Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("endId", endId)))))
    }
  
    // @LINE:63
    def retrieve(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ontologyTerms/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:67
    def patchOntologyTerms(id:Int): Call = {
      
      Call("PATCH", _prefix + { _defaultPrefix } + "ontologyTerms/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:64
    def create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "ontologyTerms")
    }
  
  }

  // @LINE:79
  class ReverseCeExperimentalPropertiesController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:79
    def listCeExperimentalProperties(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ceExpProps/list")
    }
  
    // @LINE:84
    def delete(id:Int): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "ceExpProps/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:83
    def update(id:Int): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "ceExpProps/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:85
    def patchCeExperimentalProperties(id:Int): Call = {
      
      Call("PATCH", _prefix + { _defaultPrefix } + "ceExpProps/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:81
    def retrieve(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ceExpProps/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:82
    def create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "ceExpProps")
    }
  
    // @LINE:80
    def listCeExperimentalPropertiesInRange(startId:Int, endId:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ceExpProps" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("startId", startId)), Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("endId", endId)))))
    }
  
  }

  // @LINE:125
  class ReverseCompoundClassyfireController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:127
    def listCompoundClassyfireInRange(startId:Int, endId:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "compoundClassyfire" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("startId", startId)), Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("endId", endId)))))
    }
  
    // @LINE:128
    def listCompoundClassyfireByCompoundId(compoundId:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "compoundClassyfire/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("compoundId", compoundId)))
    }
  
    // @LINE:125
    def retrieve(compoundId:Int, nodeId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "compoundClassyfire/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("compoundId", compoundId)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("nodeId", nodeId)))
    }
  
    // @LINE:131
    def delete(compoundId:Int, nodeId:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "compoundClassyfire/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("compoundId", compoundId)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("nodeId", nodeId)))
    }
  
    // @LINE:126
    def listCompoundClassyfire(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "compoundClassyfire/list")
    }
  
    // @LINE:130
    def update(compoundId:Int, nodeId:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "compoundClassyfire/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("compoundId", compoundId)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("nodeId", nodeId)))
    }
  
    // @LINE:129
    def create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "compoundClassyfire/")
    }
  
    // @LINE:132
    def patchCompoundClassyfire(compoundId:Int, nodeId:String): Call = {
      
      Call("PATCH", _prefix + { _defaultPrefix } + "compoundClassyfire/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("compoundId", compoundId)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("nodeId", nodeId)))
    }
  
  }

  // @LINE:106
  class ReverseCompoundCeProductIonController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:111
    def delete(id:Int): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "compoundCeProductIon/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:107
    def listCompoundCeProductIonInRange(startId:Int, endId:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "compoundCeProductIon" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("startId", startId)), Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("endId", endId)))))
    }
  
    // @LINE:110
    def update(id:Int): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "compoundCeProductIon/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:112
    def patchCompoundCeProductIon(id:Int): Call = {
      
      Call("PATCH", _prefix + { _defaultPrefix } + "compoundCeProductIon/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:108
    def retrieve(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "compoundCeProductIon/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:106
    def listCompoundCeProductIon(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "compoundCeProductIon/list")
    }
  
    // @LINE:109
    def create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "compoundCeProductIon")
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

  // @LINE:97
  class ReverseCeExpPropMetadataController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:97
    def listCeExpPropMetadata(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ceExpPropMetadata/list")
    }
  
    // @LINE:102
    def delete(id:Int): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "ceExpPropMetadata/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:101
    def update(id:Int): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "ceExpPropMetadata/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:103
    def patchCeExpPropMetadata(id:Int): Call = {
      
      Call("PATCH", _prefix + { _defaultPrefix } + "ceExpPropMetadata/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:99
    def retrieve(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ceExpPropMetadata/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:100
    def create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "ceExpPropMetadata")
    }
  
    // @LINE:98
    def listCeExpPropMetadataInRange(startId:Int, endId:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ceExpPropMetadata" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("startId", startId)), Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("endId", endId)))))
    }
  
  }

  // @LINE:135
  class ReverseCompoundOntologyController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:142
    def patchCompoundOntology(compoundId:Int, ontologyTermId:Int): Call = {
      
      Call("PATCH", _prefix + { _defaultPrefix } + "compoundOntology/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("compoundId", compoundId)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("ontologyTermId", ontologyTermId)))
    }
  
    // @LINE:135
    def retrieve(compoundId:Int, ontologyTermId:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "compoundOntology/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("compoundId", compoundId)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("ontologyTermId", ontologyTermId)))
    }
  
    // @LINE:140
    def update(compoundId:Int, ontologyTermId:Int): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "compoundOntology/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("compoundId", compoundId)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("ontologyTermId", ontologyTermId)))
    }
  
    // @LINE:137
    def listCompoundOntologyInRange(startId:Int, endId:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "compoundOntology" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("startId", startId)), Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("endId", endId)))))
    }
  
    // @LINE:136
    def listCompoundOntology(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "compoundOntology/list")
    }
  
    // @LINE:138
    def listCompoundOntologyByCompoundId(compoundId:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "compoundOntology/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("compoundId", compoundId)))
    }
  
    // @LINE:139
    def create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "compoundOntology/")
    }
  
    // @LINE:141
    def delete(compoundId:Int, ontologyTermId:Int): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "compoundOntology/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("compoundId", compoundId)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("ontologyTermId", ontologyTermId)))
    }
  
  }

  // @LINE:145
  class ReverseCompoundPathwaysController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:147
    def listCompoundPathwaysInRange(startId:Int, endId:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "compoundPathways" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("startId", startId)), Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("endId", endId)))))
    }
  
    // @LINE:145
    def retrieve(compoundId:Int, pathwayId:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "compoundPathways/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("compoundId", compoundId)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("pathwayId", pathwayId)))
    }
  
    // @LINE:152
    def patchCompoundPathways(compoundId:Int, pathwayId:Int): Call = {
      
      Call("PATCH", _prefix + { _defaultPrefix } + "compoundPathways/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("compoundId", compoundId)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("pathwayId", pathwayId)))
    }
  
    // @LINE:150
    def update(compoundId:Int, pathwayId:Int): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "compoundPathways/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("compoundId", compoundId)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("pathwayId", pathwayId)))
    }
  
    // @LINE:148
    def listCompoundPathwaysByCompoundId(compoundId:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "compoundPathways/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("compoundId", compoundId)))
    }
  
    // @LINE:146
    def listCompoundPathways(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "compoundPathways/list")
    }
  
    // @LINE:149
    def create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "compoundPathways/")
    }
  
    // @LINE:151
    def delete(compoundId:Int, pathwayId:Int): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "compoundPathways/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("compoundId", compoundId)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("pathwayId", pathwayId)))
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
      
      Call("GET", _prefix + { _defaultPrefix } + "msms" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("startId", startId)), Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("endId", endId)))))
    }
  
    // @LINE:38
    def update(id:Int): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "msms/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:34
    def listMsms(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "msms/list")
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
      
      Call("PUT", _prefix + { _defaultPrefix } + "chains/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:52
    def listChains(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "chains/list")
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
      
      Call("GET", _prefix + { _defaultPrefix } + "chains" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("startId", startId)), Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("endId", endId)))))
    }
  
  }

  // @LINE:88
  class ReverseCompoundCasController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:89
    def listCompoundCasInRange(startId:String, endId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "compoundCas" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("startId", startId)), Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("endId", endId)))))
    }
  
    // @LINE:90
    def retrieve(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "compoundCas/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:93
    def delete(id:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "compoundCas/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:92
    def update(id:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "compoundCas/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:94
    def patchCompoundCas(id:String): Call = {
      
      Call("PATCH", _prefix + { _defaultPrefix } + "compoundCas/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:88
    def listCompoundCas(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "compoundCas/list")
    }
  
    // @LINE:91
    def create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "compoundCas")
    }
  
  }


}
