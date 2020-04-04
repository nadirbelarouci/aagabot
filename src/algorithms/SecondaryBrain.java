package algorithms;


import algorithms.strategy.Robot;
import algorithms.strategy.task.InfiniteMoveTask;
import algorithms.strategy.task.TaskExecutor;
import algorithms.strategy.task.TurnTask;
import characteristics.Parameters;
import robotsimulator.Brain;

public class SecondaryBrain extends Brain {
	
	private static int instancesCount = 0;
	
	
	private Robot robot;
	private TaskExecutor robotTasks = new TaskExecutor();
	private double exploreAngle = 5.93;
	
	private boolean alive = true;

	@Override
	public void activate() {
		switch(++instancesCount) {
			case 1 : {
				robot = new Robot(this,
								  1,
						  		  Parameters.teamASecondaryBot1InitX,
						  		  Parameters.teamASecondaryBot1InitY,
						  		  Parameters.teamASecondaryBotSpeed);
			} break;
			case 2 : {
				robot = new Robot(this,
								  2,
								  Parameters.teamASecondaryBot2InitX,
								  Parameters.teamASecondaryBot2InitY,
								  Parameters.teamASecondaryBotSpeed);
			} break;
		}
		robotTasks.addAll(new TurnTask(exploreAngle), 
						  new InfiniteMoveTask());
	}

	@Override
	public void step() {
		if(alive) {
			if(robot.getHealth() <= 0) {
				alive = false;
			}
			else {
				robotTasks.execute(robot);
			}
		}
		else {
			
		}
	}
}
