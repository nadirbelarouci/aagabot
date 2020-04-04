package algorithms.strategy.task;

import static java.lang.Math.PI;

import algorithms.strategy.Robot;
import characteristics.Parameters.Direction;

public class TurnTask extends AbstractTask {
	
	private Direction turnDirection = null;
    
	public TurnTask(TurnGoal goal) {
        super(goal);
    }
	
	public TurnTask(Double destination) {
		super(new TurnGoal(destination));
	}
	
	public TurnTask(PolarDirection direction) {
		this(direction.getValue());
	}

    @Override
    public Task copy() {
        return new TurnTask((TurnGoal) getGoal());
    }
    
    private void init(Robot robot) {
    	double destination = ((TurnGoal) getGoal()).theta;
    	double diff = destination - robot.getTheta();
		if(diff < 0) {
			diff = diff + 2 * PI;
		}
		if(diff < PI) {
			turnDirection = Direction.RIGHT;
		}
		else {
			turnDirection = Direction.LEFT;
		}
    }

    @Override
    public boolean execute(Robot robot) {
    	double destination = ((TurnGoal) getGoal()).theta;
    	if(turnDirection == null) {
    		init(robot);
    	}
    	if(robot.isSameDirection(destination)) {
    		return true;
    	}
    	robot.stepTurn(turnDirection);
    	return false;
    }
    
	public enum PolarDirection {
		North(3 * PI / 2),
		South(PI / 2),
		West(PI),
		EAST(0);
		
		private double value;
		
		private PolarDirection(double value) {
			this.value = value;
		}
		
		public double getValue() {
			return value;
		}
		
	}

}
