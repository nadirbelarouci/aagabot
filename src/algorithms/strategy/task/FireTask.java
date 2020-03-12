package algorithms.strategy.task;

import algorithms.strategy.Robot;

public class FireTask extends AbstractTask {
    public FireTask() {
        super(null);
    }

    @Override
    public boolean execute(Robot robot) {
        robot.fire();
        return true;
    }

    @Override
    public Task copy() {
        return this;
    }
}
