package kata.ex01.rule;

import kata.ex01.model.HighwayDrive;

public class MidnightRule extends WeekdayRule {

  private static final int DISCOUNT_START_HOUR = 0;
  private static final int DISCOUNT_END_HOUR = 4;

  @Override
  public boolean isDiscount(HighwayDrive drive) {
    return isRunningTargetHour(drive, DISCOUNT_START_HOUR, DISCOUNT_END_HOUR);
  }
}
