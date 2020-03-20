package algorithms.strategy.task;

import algorithms.strategy.Robot;
import characteristics.IRadarResult;

public class RadarDetectionTask implements Task {
    @Override
    public boolean execute(Robot robot) {
        robot.detectRadar().stream()
                .filter(result -> result.getObjectType() == IRadarResult.Types.OpponentMainBot
                || result.getObjectType() == IRadarResult.Types.OpponentSecondaryBot)
                .map(result -> IRadarResult.parse(result, robot))
                .forEach(robot::broadcast);
        return false;
    }


    @Override
    public Task copy() {
        return this;
    }
}
