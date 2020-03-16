package algorithms.strategy.task;

import algorithms.strategy.Robot;

import java.util.Random;

public class ExploreTask extends AbstractTask implements Task {
    private static Random random = new Random();
    private ZigZagTask zigZagTask;

    public ExploreTask() {
        super(generate());
        zigZagTask = new ZigZagTask((MoveGoal) getGoal());
    }

    private static MoveGoal generate() {
        return new MoveGoal(random.nextInt(3000), random.nextInt(2000));
    }

    @Override
    public boolean execute(Robot robot) {
        if (zigZagTask.execute(robot)) {
            zigZagTask = new ZigZagTask(generate());
        }

        return false;
    }

    @Override
    public Task copy() {
        return new ExploreTask();
    }
}
