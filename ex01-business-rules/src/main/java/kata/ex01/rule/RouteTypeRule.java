package kata.ex01.rule;

import kata.ex01.model.HighwayDrive;
import kata.ex01.model.RouteType;

public class RouteTypeRule implements Rule {

  @Override
  public boolean isDiscount(HighwayDrive drive) {
    return drive.getRouteType() == RouteType.RURAL;
  }
}
