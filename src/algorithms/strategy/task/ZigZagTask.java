package algorithms.strategy.task;

import algorithms.strategy.Robot;

public class ZigZagTask extends AbstractTask {
    private TaskExecutor executor;


    public ZigZagTask(MoveGoal goal) {
        super(goal);
    }

    @Override
    public Task copy() {
        return new ZigZagTask((MoveGoal) getGoal());
    }

    private void initialize(Robot robot) {
        executor = new TaskExecutor();
        MoveGoal goal = (MoveGoal) getGoal();
        int N = 5;
        int x1 = (int) robot.getX();
        int x2 = goal.x;
        int y1 = (int) robot.getY();
        int y2 = goal.y;
        int w = 100;
        double inv = 0.25 / (double) N;
        double dx = (x2 - x1) * inv,
                dy = (y2 - y1) * inv;

        // perpendicular direction
        double inv2 = w / Math.sqrt(dx * dx + dy * dy);
        double px = dy * inv2,
                py = -dx * inv2;

        // loop
        double x = x1, y = y1;
        for (int i = 0; i < N; i++) {
            executor.add(new MoveToTask(new MoveGoal(x + dx + px, y + dy + py)));
            executor.add(new MoveToTask(new MoveGoal(x + 3.0 * dx - px, y + 3.0 * dy - py)));
            executor.add(new MoveToTask(new MoveGoal(x + 4.0 * dx, y + 4.0 * dy)));
            x += 4.0 * dx;
            y += 4.0 * dy;
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
