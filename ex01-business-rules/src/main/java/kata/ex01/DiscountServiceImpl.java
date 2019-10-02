package kata.ex01;

import kata.ex01.model.HighwayDrive;
import kata.ex01.model.RouteType;
import kata.ex01.model.VehicleFamily;
import kata.ex01.util.HolidayUtils;

/**
 * @author kawasima
 */
public class DiscountServiceImpl implements DiscountService {
    @Override
    public long calc(HighwayDrive drive) {

        // 休日~平日の朝夕割引パターンの場合日付を
        int exitedHour = drive.getExitedAt().getHour();
        if(drive.getEnteredAt().getDayOfMonth() != drive.getExitedAt().getDayOfMonth()) {
            exitedHour += 24;
        }

        // 休日~平日の朝夕割引パターン
        if(HolidayUtils.isHoliday(drive.getEnteredAt().toLocalDate()) || !HolidayUtils.isHoliday(drive.getExitedAt().toLocalDate())) {
            if(drive.getEnteredAt().getHour() > 20 && exitedHour >= 30){
                if (drive.getRouteType() == RouteType.RURAL) {
                    if (drive.getDriver().getCountPerMonth() >= 10) {
                        return 50;
                    } else if (drive.getDriver().getCountPerMonth() >= 5) {
                        return 30;
                    }
                }
            }
        }


        // 平日朝夕割引
        if(!HolidayUtils.isHoliday(drive.getEnteredAt().toLocalDate()) && !HolidayUtils.isHoliday(drive.getExitedAt().toLocalDate())) {
            if ((drive.getEnteredAt().getHour() > 20 && exitedHour >= 30) && (drive.getEnteredAt().getHour() <= 9 && drive.getExitedAt().getHour() >= 6) || (drive.getEnteredAt().getHour() <= 20 && drive.getExitedAt().getHour() >= 17)) {
                if (drive.getRouteType() == RouteType.RURAL) {
                    if (drive.getDriver().getCountPerMonth() >= 10) {
                        return 50;
                    } else if (drive.getDriver().getCountPerMonth() >= 5) {
                        return 30;
                    }
                }
            }
        }

        // 深夜割引
        if(drive.getExitedAt().getHour() <= 4) {
            return 30;
        }

        // 休日割引
        if(HolidayUtils.isHoliday(drive.getEnteredAt().toLocalDate()) ||  HolidayUtils.isHoliday(drive.getExitedAt().toLocalDate())) {
            if (drive.getVehicleFamily() != VehicleFamily.OTHER && drive.getRouteType() == RouteType.RURAL) {
                return 30;
            }
        }

        return 0;
    }
}
