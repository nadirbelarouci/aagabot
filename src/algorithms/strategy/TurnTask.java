package algorithms.strategy;

import static characteristics.Parameters.Direction.LEFT;
import static characteristics.Parameters.Direction.RIGHT;

public class TurnTask extends AbstractTask  {
    public TurnTask(TurnGoal goal) {
        super(goal);

    }

    @Override
    public boolean execute(Robot robot) {

        TurnGoal goal = (TurnGoal) getGoal();

        if (goal.theta < Math.PI)
            robot.stepTurn(RIGHT);
        else
            robot.stepTurn(LEFT);

        return robot.isSameDirection(goal.theta);

    }


}
