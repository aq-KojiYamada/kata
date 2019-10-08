package kata.ex01.rule;

import kata.ex01.model.HighwayDrive;

public class WeekdayEveningRule extends WeekdayRule {

  private static final int DISCOUNT_START_HOUR = 17;
  private static final int DISCOUNT_END_HOUR = 20;

  @Override
  public boolean isDiscount(HighwayDrive drive) {
    return isRunningTargetHour(drive, DISCOUNT_START_HOUR, DISCOUNT_END_HOUR);
  }
}
