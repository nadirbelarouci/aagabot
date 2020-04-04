package algorithms.strategy.task;

import algorithms.strategy.Robot;

public class MoveToTask extends AbstractTask {

    private TaskExecutor executor;

    public MoveToTask(MoveGoal goal) {
        super(goal);
    }
    
    public MoveToTask(double distX, double distY) {
    	super(new MoveGoal(distX, distY));
    }

    @Override
    public Task copy() {
        return new MoveToTask((MoveGoal) getGoal());
    }

    private void initialize(Robot robot) {
        executor = new TaskExecutor();
        MoveGoal goal = (MoveGoal) getGoal();
        executor.add(new TurnTask(new TurnGoal(robot.getX(), robot.getY(), goal.x, goal.y)));
        executor.add(new SimpleMoveTask(goal, robot.getX(), robot.getY()));
    }

    @Override
    public boolean execute(Robot robot) {
        if (executor == null) {
            initialize(robot);
        }
        return executor.execute(robot);
    }


    private static class SimpleMoveTask extends AbstractTask {
        private double distance;

        public SimpleMoveTask(MoveGoal goal, double ox, double oy) {
            super(goal);
            MoveGoal g = goal;
            distance = Math.sqrt(Math.pow(g.x - ox, 2) + Math.pow(g.y - oy, 2));
        }

        @Override
        public boolean execute(Robot robot) {
            robot.move();
            distance -= robot.getSpeed();
            return distance < 20;
        }

        @Override
        public Task copy() {
            throw new UnsupportedOperationException();
        }
    }
}
