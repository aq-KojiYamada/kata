package kata.ex01.rule;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import kata.ex01.model.HighwayDrive;

public class WeekdayRule implements Rule {

  @Override
  public boolean isDiscount(HighwayDrive drive) {
    WeekdayMorningRule morningRule = new WeekdayMorningRule();
    WeekdayEveningRule eveningRule = new WeekdayEveningRule();

    return morningRule.isDiscount(drive) || eveningRule.isDiscount(drive);
  }

  boolean isRunningTargetHour(HighwayDrive drive, int startHour, int endHour) {
    LocalDate targetDate = drive.getEnteredAt().getHour() <= startHour ?
        drive.getEnteredAt().toLocalDate() :
        drive.getExitedAt().toLocalDate();

    LocalDateTime start = LocalDateTime.of(
        targetDate,
        LocalTime.of(startHour, 0)
    );

    LocalDateTime end = LocalDateTime.of(
        targetDate,
        LocalTime.of(endHour, 0)
    );

    return drive.getEnteredAt().isBefore(end) && drive.getExitedAt().isAfter(start);
  }
}
