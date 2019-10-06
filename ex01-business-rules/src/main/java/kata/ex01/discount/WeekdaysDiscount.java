package kata.ex01.discount;

import kata.ex01.model.HighwayDrive;
import kata.ex01.rule.Rule;

public class WeekdaysDiscount {

  private Rule[] rules;

  public WeekdaysDiscount(Rule... rules) {
    this.rules = rules;
  }

  public long getRate(HighwayDrive drive) {
    for (Rule rule : rules) {
      if (!rule.isDiscount(drive)) {
        return 0;
      }
    }

    int countPerMonth = drive.getDriver().getCountPerMonth();

    if (countPerMonth >= 10) {
      return 50;
    }

    if (countPerMonth >= 5) {
      return 30;
    }

    return 0;
  }
}
