package org.example.factory;

import org.example.strategy.ParkingSpotAssignmentStrategy;
import org.example.strategy.ParkingSpotAssignmentStrategyType;
import org.example.strategy.RandomParkingSpotAssignmentStrategy;
import org.example.strategy.VIPParkingSpotAssignmentStrategy;

public class ParkingSpotAssignmentStrategyFactory{
    public static ParkingSpotAssignmentStrategy getParkingSpotStrategy(
            ParkingSpotAssignmentStrategyType strategyType){
        if(strategyType.equals(ParkingSpotAssignmentStrategyType.VIP)){
            return new VIPParkingSpotAssignmentStrategy();
        } else if (strategyType.equals(ParkingSpotAssignmentStrategyType.RANDOM)) {
            return new RandomParkingSpotAssignmentStrategy();
        }
        return null;
    }
}
