package kata.ex01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kata.ex01.discount.HolidaysDiscount;
import kata.ex01.discount.KenoDoDiscount;
import kata.ex01.discount.MidnightDiscount;
import kata.ex01.discount.WeekdaysDiscount;
import kata.ex01.model.HighwayDrive;
import kata.ex01.rule.*;

/**
 * @author kawasima
 */
public class DiscountServiceImpl implements DiscountService {

  @Override
  public long calc(HighwayDrive drive) {
    List<Long> discountRateList = new ArrayList<>();

    WeekdaysDiscount weekdaysDiscount = new WeekdaysDiscount(
        new WeekdayRule(),
        new RouteTypeRule()
    );

    discountRateList.add(weekdaysDiscount.getRate(drive));

    HolidaysDiscount holidaysDiscount = new HolidaysDiscount(
        new HolidaysRule(),
        new VehicleRule(),
        new RouteTypeRule()
    );

    discountRateList.add(holidaysDiscount.getRate(drive));

    MidnightDiscount midnightDiscount = new MidnightDiscount(
        new MidnightRule()
    );

    discountRateList.add(midnightDiscount.getRate(drive));

    KenoDoDiscount kenoDoDiscount = new KenoDoDiscount(
            new RoadTypeRule()
    );

    discountRateList.add(kenoDoDiscount.getRate(drive));

    return Collections.max(discountRateList);
  }
}
