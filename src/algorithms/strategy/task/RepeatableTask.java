package algorithms.strategy.task;

import algorithms.strategy.Robot;

import java.util.Objects;

public class RepeatableTask implements Task {

    private Task task;

    public RepeatableTask(Task task) {
        this.task = Objects.requireNonNull(task);
    }

    @Override
    public boolean execute(Robot robot) {
        if (task.execute(robot))
            task = task.copy();
        return false;
    }

    @Override
    public Task copy() {
        return new RepeatableTask(task);
    }
}
