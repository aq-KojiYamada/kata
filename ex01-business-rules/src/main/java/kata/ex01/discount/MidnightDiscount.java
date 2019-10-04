package kata.ex01.discount;

import kata.ex01.model.HighwayDrive;

import java.time.LocalTime;

public class MidnightDiscount {
    public long a (HighwayDrive drive) {
        LocalTime enteredTime = drive.getEnteredAt().toLocalTime();
        LocalTime exitedTime = drive.getExitedAt().toLocalTime();

        // 深夜割引
        if(drive.getExitedAt().getHour() <= 4) {
            return 30;
        }

        return 0;
    }
}
