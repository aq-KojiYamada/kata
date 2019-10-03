package kata.ex01;

import kata.ex01.discount.HolidaysDiscount;
import kata.ex01.discount.MidnightDiscount;
import kata.ex01.discount.WeekdaysDiscount;
import kata.ex01.model.HighwayDrive;
import kata.ex01.model.RouteType;
import kata.ex01.model.VehicleFamily;
import kata.ex01.util.HolidayUtils;

import java.time.LocalTime;

/**
 * @author kawasima
 */
public class DiscountServiceImpl implements DiscountService {

    @Override
    public long calc(HighwayDrive drive) {

        WeekdaysDiscount weekdaysDiscount = new WeekdaysDiscount();
        HolidaysDiscount holidaysDiscount = new HolidaysDiscount();
        MidnightDiscount midnightDiscount = new MidnightDiscount();

        long discountRate = 0;

        discountRate = weekdaysDiscount.a(drive);

        discountRate = Math.max(discountRate, holidaysDiscount.a(drive));

        discountRate = Math.max(discountRate, midnightDiscount.a(drive));

        return discountRate;
    }
}
