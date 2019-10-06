package kata.ex01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kata.ex01.discount.HolidaysDiscount;
import kata.ex01.discount.MidnightDiscount;
import kata.ex01.discount.WeekdaysDiscount;
import kata.ex01.model.HighwayDrive;
import kata.ex01.model.RouteType;
import kata.ex01.model.VehicleFamily;
import kata.ex01.rule.RouteTypeRule;
import kata.ex01.rule.VehicleRule;
import kata.ex01.rule.WeekdayRule;
import kata.ex01.util.HolidayUtils;

import java.time.LocalTime;

/**
 * @author kawasima
 */
public class DiscountServiceImpl implements DiscountService {

  @Override
  public long calc(HighwayDrive drive) {
    List<Long> discountRateList = new ArrayList<>();

    WeekdaysDiscount weekdaysDiscount = new WeekdaysDiscount(
        new WeekdayRule(),
        new VehicleRule(),
        new RouteTypeRule()
    );

    discountRateList.add(weekdaysDiscount.getRate(drive));

    return Collections.max(discountRateList);

//        HolidaysDiscount holidaysDiscount = new HolidaysDiscount();
//        MidnightDiscount midnightDiscount = new MidnightDiscount();
//
//        long discountRate = 0;
//
//        discountRate = Math.max(discountRate, holidaysDiscount.a(drive));
//
//        discountRate = Math.max(discountRate, midnightDiscount.a(drive));
//
//        return discountRate;
  }
}
