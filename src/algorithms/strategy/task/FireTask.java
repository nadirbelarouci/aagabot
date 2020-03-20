package algorithms.strategy.task;

import algorithms.strategy.Robot;
import characteristics.Parameters;

public class FireTask extends AbstractTask {
    private int latency = Parameters.bulletFiringLatency;
    private Task task;

    public FireTask() {
        super(null);

    }

    public void setTask(Task task) {
        if (this.task == null)
            this.task = task;
    }

    @Override
    public boolean execute(Robot robot) {
        latency--;
        if (latency < 0) {
            robot.fire();
        } else {
            latency = Parameters.bulletFiringLatency;
            task.execute(robot);
        }
        return true;
    }

    @Override
    public Task copy() {
        return this;
    }
}
