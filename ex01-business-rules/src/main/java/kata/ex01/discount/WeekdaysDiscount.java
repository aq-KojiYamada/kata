package kata.ex01.discount;

import kata.ex01.model.HighwayDrive;
import kata.ex01.model.RouteType;
import kata.ex01.util.HolidayUtils;

import java.time.LocalTime;

public class WeekdaysDiscount {
    public long a (HighwayDrive drive) {
        long discountRate = 0;
        LocalTime startMorningTime = LocalTime.of(6, 0);
        LocalTime endMorningTime = LocalTime.of(9, 0);
        LocalTime startEveningTime = LocalTime.of(17, 0);
        LocalTime endEveningTime = LocalTime.of(20, 0);

        LocalTime enteredTime = drive.getEnteredAt().toLocalTime();
        LocalTime exitedTime = drive.getExitedAt().toLocalTime();

        // 休日~平日の朝夕割引パターン
        if(HolidayUtils.isHoliday(drive.getEnteredAt().toLocalDate()) && !HolidayUtils.isHoliday(drive.getExitedAt().toLocalDate())) {
            if(drive.getEnteredAt().getDayOfMonth() != drive.getExitedAt().getDayOfMonth() && exitedTime.compareTo(startMorningTime) >= 0){
                discountRate = Math.max(discountRate, weekdayMoringAndEveningDiscount(drive));
            }
        }

        // 平日~休日の朝夕割引パターン
        if(!HolidayUtils.isHoliday(drive.getEnteredAt().toLocalDate()) && HolidayUtils.isHoliday(drive.getExitedAt().toLocalDate())) {
            if((enteredTime.compareTo(endMorningTime) <= 0 && exitedTime.compareTo(startMorningTime) >= 0) || (enteredTime.compareTo(endEveningTime) <= 0 && exitedTime.compareTo(startEveningTime) >= 0)){
                discountRate = Math.max(discountRate, weekdayMoringAndEveningDiscount(drive));
            }
        }


        // 平日朝夕割引
        if(!HolidayUtils.isHoliday(drive.getEnteredAt().toLocalDate()) && !HolidayUtils.isHoliday(drive.getExitedAt().toLocalDate())) {
            if ((drive.getEnteredAt().getDayOfMonth() != drive.getExitedAt().getDayOfMonth() && exitedTime.compareTo(startMorningTime) >= 0) || ((enteredTime.compareTo(endMorningTime) <= 0 && exitedTime.compareTo(startMorningTime) >= 0) || (enteredTime.compareTo(endEveningTime) <= 0 && exitedTime.compareTo(startEveningTime) >= 0))) {
                discountRate = Math.max(discountRate, weekdayMoringAndEveningDiscount(drive));
            }
        }
        return discountRate;
    }

    private long weekdayMoringAndEveningDiscount (HighwayDrive drive) {
        if (drive.getRouteType() == RouteType.RURAL) {
            if (drive.getDriver().getCountPerMonth() >= 10) {
                return 50;
            } else if (drive.getDriver().getCountPerMonth() >= 5) {
                return 30;
            }
        }
        return 0;
    }
}
