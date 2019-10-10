package kata.ex01.rule;

import kata.ex01.model.HighwayDrive;
import kata.ex01.util.HolidayUtils;

public class HolidaysRule implements Rule {

  @Override
  public boolean isDiscount(HighwayDrive drive) {
    return HolidayUtils.isHoliday(drive.getEnteredAt().toLocalDate()) || HolidayUtils.isHoliday(drive.getExitedAt().toLocalDate());
  }
}
