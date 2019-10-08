package kata.ex01.rule;

import kata.ex01.model.HighwayDrive;

public class WeekdayMorningRule extends WeekdayRule {

  private static final int DISCOUNT_START_HOUR = 6;
  private static final int DISCOUNT_END_HOUR = 9;

  @Override
  public boolean isDiscount(HighwayDrive drive) {
    return isRunningTargetHour(drive, DISCOUNT_START_HOUR, DISCOUNT_END_HOUR);
  }
}
