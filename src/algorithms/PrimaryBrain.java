package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import characteristics.IRadarResult.Types;
import algorithms.strategy.Robot;
import algorithms.strategy.task.ExploreTask;
import algorithms.strategy.task.InfiniteMoveTask;
import algorithms.strategy.task.TaskExecutor;
import algorithms.strategy.task.TurnTask;
import characteristics.IFrontSensorResult;
import characteristics.IRadarResult;
import characteristics.Parameters;
import robotsimulator.Brain;

public class PrimaryBrain extends Brain {
	
	private static int instances = 0;
	
	private Robot robot;
	private TaskExecutor robotTasks = new TaskExecutor();
	
	private boolean warState = false;
	private boolean exploreFireState = false;
	
	@Override
	public void activate() {
		switch(++instances) {
			case 1: {
				robot = new Robot(this,
						  1,
						  Parameters.teamAMainBot1InitX,
						  Parameters.teamAMainBot1InitY, 
						  Parameters.teamAMainBotSpeed);
				robotTasks.addAll(new TurnTask(5.90),
								  new InfiniteMoveTask());
			} break;
			case 2: {
				robot = new Robot(this,
						  2,
						  Parameters.teamAMainBot2InitX,
						  Parameters.teamAMainBot2InitY, 
						  Parameters.teamAMainBotSpeed);
				robotTasks.addAll(new TurnTask(6.0),
								  new InfiniteMoveTask());
			} break;
			case 3: {
				robot = new Robot(this,
						  3,
						  Parameters.teamAMainBot3InitX,
						  Parameters.teamAMainBot3InitY, 
						  Parameters.teamAMainBotSpeed);
				robotTasks.addAll(new TurnTask(6.03),
								  new InfiniteMoveTask());
			} break;
		}
		
	}

	@Override
	public void step() {
		var enemies = detectEnemies(Types.OpponentMainBot);
		
		if(!warState && !exploreFireState) {
			if(enemies.isEmpty()) {
				if(robot.detectFront().getObjectType() == IFrontSensorResult.Types.WALL || 
						robot.detectFront().getObjectType() == IFrontSensorResult.Types.Wreck) {
					exploreFireState = true;
					robotTasks.update(new ExploreTask());
				}
				robotTasks.execute(robot);
			}
			else {
				warState = true;
			}
		}
		
		if(warState) {
			if(enemies.isEmpty()) {
				warState = false;
				robotTasks.execute(robot);
			}
			else {
				robot.setFireDirection(enemies.get(0).getDirection());
				robot.fire();
			}
		}
		
		if(exploreFireState) {
			if(!enemies.isEmpty()) {
				robot.setFireDirection(enemies.get(0).getDirection());
				robot.fire();
			}
			else {
				if(!enemies.isEmpty()) {
					robot.setFireDirection(enemies.get(0).getDirection());
					robot.fire();
				}
				else {
					robotTasks.execute(robot);
				}
			}
		}
		
	}
	
    private List<Detection> detectEnemies(IRadarResult.Types typePriority) {
		List<Detection> detectedEnemies = new ArrayList<>();
		var scan = robot.detectRadar();
		scan.forEach(d -> {
			if(d.getObjectType() == IRadarResult.Types.OpponentMainBot || 
					d.getObjectType() == IRadarResult.Types.OpponentSecondaryBot) {
				var detection = new Detection(d.getObjectDirection(),
											  d.getObjectDistance(),
											  d.getObjectType());
				detectedEnemies.add(detection);
			}
		});
		Collections.sort(detectedEnemies);
		return detectedEnemies;
    }
    
    private class Detection implements Comparable<Detection>{
    	private Double direction;
    	private Double distance;
    	private IRadarResult.Types type;
    	private IRadarResult.Types priorityType;
    	
    	public Detection(double direction, double distance, IRadarResult.Types type) {
    		this.direction = direction;
    		this.distance = distance;
    		this.type = type;
    	}
    	
    	public Double getDirection() {
    		return direction;
    	}
    	
    	public Double getDistance() {
    		return distance;
    	}
    	
    	public IRadarResult.Types getType() {
    		return type;
    	}
    	
    	@Override
    	public int compareTo(Detection other) {
    		if(type == priorityType && other.type != priorityType) {
    			return -1;
    		}
    		if(type != priorityType && other.type == priorityType) {
    			return 1;
    		}
    		
    		return direction.compareTo(other.direction);
    	}
    } 
}
