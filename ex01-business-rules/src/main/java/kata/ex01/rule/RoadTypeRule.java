package kata.ex01.rule;

import kata.ex01.model.HighwayDrive;
import kata.ex01.model.RoadType;

public class RoadTypeRule implements Rule {

  @Override
  public boolean isDiscount(HighwayDrive drive) {
    return drive.getRoadType() == RoadType.KENO_DO;
  }
}
