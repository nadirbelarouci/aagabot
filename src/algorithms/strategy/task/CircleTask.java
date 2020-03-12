package algorithms.strategy.task;

import algorithms.strategy.Robot;

import static java.lang.Math.*;

public class CircleTask extends AbstractTask {
    private TaskExecutor executor;


    public CircleTask(CircleGoal goal) {
        super(goal);
    }

    @Override
    public Task copy() {
        return new CircleTask((CircleGoal) getGoal());
    }

    private void initialize() {
        executor = new TaskExecutor();
        CircleGoal goal = (CircleGoal) getGoal();
        double i, angle, x1, y1;
        for (i = 0; i < 360; i += (360 / 36)) {
            angle = i;
            x1 = goal.r * cos(angle * PI / 180);
            y1 = goal.r * sin(angle * PI / 180);
            executor.add(new MoveToTask(new MoveGoal(goal.x + x1, goal.y + y1)));
        }


    }

    @Override
    public boolean execute(Robot robot) {
        if (executor == null) {
            initialize();
        }
        return executor.execute(robot);
    }
}
