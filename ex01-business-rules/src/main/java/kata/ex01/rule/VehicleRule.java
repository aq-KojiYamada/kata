package kata.ex01.rule;

import java.util.Arrays;
import java.util.List;
import kata.ex01.model.HighwayDrive;
import kata.ex01.model.VehicleFamily;

public class VehicleRule implements Rule {

  @Override
  public boolean isDiscount(HighwayDrive drive) {
    List<VehicleFamily> discountTarget = Arrays.asList(
        VehicleFamily.STANDARD, VehicleFamily.MINI, VehicleFamily.MOTORCYCLE
    );

    return discountTarget.contains(drive.getVehicleFamily());
  }
}
