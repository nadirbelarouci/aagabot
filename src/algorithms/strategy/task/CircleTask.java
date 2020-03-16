package algorithms.strategy.task;

import algorithms.strategy.Robot;

import static java.lang.Math.*;

public class CircleTask extends AbstractTask {
    private TaskExecutor executor;


    public CircleTask(CircleGoal goal) {
        super(goal);
    }

    public MoveGoal getCircleLineIntersectionPoint(MoveGoal robot, CircleGoal circle) {
        double vX = robot.x - circle.x;
        double vY = robot.y - circle.y;
        double magV = sqrt(vX * vX + vY * vY);
        double aX = circle.x + vX / magV * circle.r;
        double aY = circle.y + vY / magV * circle.r;
        return new MoveGoal(aX, aY);

    }

    @Override
    public Task copy() {
        return new CircleTask((CircleGoal) getGoal());
    }

    private void initialize(Robot robot) {
        executor = new TaskExecutor();
        CircleGoal goal = (CircleGoal) getGoal();
        double i, angle, x, y;
        MoveGoal start = getCircleLineIntersectionPoint(new MoveGoal(robot.getX(), robot.getY()), goal);

        angle = Math.acos((start.x - goal.x) / (double) goal.r) * 180 / PI;
        for (i = angle; i < angle + 360; i += 10) {

            x = goal.r * cos(i * PI / 180) + goal.x;
            y = goal.r * sin(i * PI / 180) + goal.y;

            executor.add(new MoveToTask(new MoveGoal(x, y)));
        }
    }

    @Override
    public boolean execute(Robot robot) {
        if (executor == null) {
            initialize(robot);
        }
        return executor.execute(robot);
    }
}
