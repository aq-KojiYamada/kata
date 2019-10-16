package kata.ex01.discount;

import kata.ex01.model.HighwayDrive;
import kata.ex01.rule.Rule;

public class KenoDoDiscount {

  private Rule[] rules;

  public KenoDoDiscount(Rule... rules) {
    this.rules = rules;
  }

  public long getRate(HighwayDrive drive) {
    for (Rule rule : rules) {
      if (!rule.isDiscount(drive)) {
        return 0;
      }
    }
    return 20;
  }
}
