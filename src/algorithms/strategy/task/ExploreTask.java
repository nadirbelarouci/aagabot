package algorithms.strategy.task;

import algorithms.strategy.Robot;

import java.util.Random;

public class ExploreTask implements Task {
    private static Random random = new Random();
    private ZigZagTask zigZagTask;

    public ExploreTask() {
    }

    private static int random(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        return random.nextInt((max - min) + 1) + min;
    }

    private static MoveGoal generate(Robot robot) {
        int x = robot.getX() < 1500 ? random(1500, 3000) : random(0, 1500);
        int y = robot.getY() < 1000 ? random(1000, 2000) : random(0, 1000);
        return new MoveGoal(x,y);

    }

    @Override
    public boolean execute(Robot robot) {

        if (zigZagTask == null || zigZagTask.execute(robot)) {
            zigZagTask = new ZigZagTask(generate(robot));
        }

        return false;
    }

    @Override
    public Task copy() {
        return new ExploreTask();
    }
}
