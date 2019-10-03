package kata.ex01.discount;

import kata.ex01.model.HighwayDrive;
import kata.ex01.model.RouteType;
import kata.ex01.model.VehicleFamily;
import kata.ex01.util.HolidayUtils;

public class HolidaysDiscount {
    public long a (HighwayDrive drive) {
        // 休日割引
        if(HolidayUtils.isHoliday(drive.getEnteredAt().toLocalDate()) ||  HolidayUtils.isHoliday(drive.getExitedAt().toLocalDate())) {
            if (drive.getVehicleFamily() != VehicleFamily.OTHER && drive.getRouteType() == RouteType.RURAL) {
                return 30;
            }
        }

        return 0;
    }
}
