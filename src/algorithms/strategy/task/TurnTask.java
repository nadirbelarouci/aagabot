package algorithms.strategy.task;

import algorithms.strategy.Robot;
import characteristics.Parameters;

public class TurnTask extends AbstractTask {
    public TurnTask(TurnGoal goal) {
        super(goal);

    }

    @Override
    public Task copy() {
        return new TurnTask((TurnGoal) getGoal());
    }

    @Override
    public boolean execute(Robot robot) {

        TurnGoal goal = (TurnGoal) getGoal();
        double diff1 = goal.theta - robot.getTheta();

        if (diff1 < 0)
            diff1 = diff1 + 2 * Math.PI;


        if (diff1 < Math.PI) {
            robot.stepTurn(Parameters.Direction.RIGHT);
        } else {
            robot.stepTurn(Parameters.Direction.LEFT);

        }
        return robot.isSameDirection(goal.theta);

    }


}
