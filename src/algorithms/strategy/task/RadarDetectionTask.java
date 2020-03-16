package algorithms.strategy.task;

import algorithms.strategy.Robot;
import characteristics.IRadarResult;

public class RadarDetectionTask implements Task {
    @Override
    public boolean execute(Robot robot) {
        robot.detectRadar().stream()
                .map(IRadarResult::parse)
                .forEach(robot::broadcast);
        return false;
    }


    @Override
    public Task copy() {
        return this;
    }
}
