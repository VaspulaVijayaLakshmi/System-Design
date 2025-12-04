package LLD_without_Design_Pattern.ParkingLot;

import java.util.Date;
import java.util.Map;

public class FeeStrategy {

    private final Map<SpotType, Double> feeMap = Map.of(
                    SpotType.CAR, 20.0,
                    SpotType.BIKE, 10.0
            );

    public double calculateFee(SpotType type, long entryTime){

        long exitTime = new Date().getTime();

        //convert milliseconds to hours as well
        long parkingDuration = (exitTime - entryTime)/(60*60*1000);

//        1 sec = 10^3 milliseconds
//        1hr = 60*60*10^3 milliseconds

        return  feeMap.get(type)*parkingDuration;

    }

}