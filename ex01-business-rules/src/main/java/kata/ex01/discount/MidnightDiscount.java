package kata.ex01.discount;

import kata.ex01.model.HighwayDrive;

import kata.ex01.rule.Rule;

public class MidnightDiscount {

    private Rule[] rules;

    public MidnightDiscount(Rule... rules) {
        this.rules = rules;
    }

    public long getRate(HighwayDrive drive) {
        for (Rule rule : rules) {
            if (!rule.isDiscount(drive)) {
                return 0;
            }
        }
        return 30;
    }
}
