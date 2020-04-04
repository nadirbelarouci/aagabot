package algorithms.strategy.task;

import algorithms.strategy.Robot;

public class InfiniteMoveTask implements Task {

	@Override
	public boolean execute(Robot robot) {
		robot.move();
		return false;
	}

	@Override
	public Task copy() {
		return this;
	}
	

}
