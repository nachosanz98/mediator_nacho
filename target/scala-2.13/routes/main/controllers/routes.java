// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseCompoundController CompoundController = new controllers.ReverseCompoundController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReversePathwayController PathwayController = new controllers.ReversePathwayController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseEmployeeController EmployeeController = new controllers.ReverseEmployeeController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseMsmsController MsmsController = new controllers.ReverseMsmsController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseCompoundController CompoundController = new controllers.javascript.ReverseCompoundController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReversePathwayController PathwayController = new controllers.javascript.ReversePathwayController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseEmployeeController EmployeeController = new controllers.javascript.ReverseEmployeeController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseMsmsController MsmsController = new controllers.javascript.ReverseMsmsController(RoutesPrefix.byNamePrefix());
  }

}
