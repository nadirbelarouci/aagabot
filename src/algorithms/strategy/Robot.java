package algorithms.strategy;

import characteristics.IBrain;
import characteristics.IFrontSensorResult;
import characteristics.IRadarResult;
import characteristics.Parameters.Direction;

import java.util.ArrayList;

public class Robot {
    private static final double EPSILON = 0.09;
    private static final double POSITION_DIFF = 10;
    private final double speed;
    
    private int id;
    private double x;
    private double y;
    private double theta;
    private double fireTheta;
    private IBrain brain;

    public Robot(IBrain brain, double x, double y, double speed) {
        this.brain = brain;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }
    
    public Robot(IBrain brain, int id, double x, double y, double speed) {
    	this(brain, x, y, speed);
    	this.id = id;
    }

    public void sendLogMessage(String message) {
        brain.sendLogMessage(message);
    }

    public void moveBack() {
        brain.moveBack();
    }

    public void move() {
        brain.move();
        x += speed * Math.cos(getTheta());
        y += speed * Math.sin(getTheta());
        brain.sendLogMessage(x + " , " + y + " theta = " + theta);
    }

    public void stepTurn(Direction direction) {
        brain.stepTurn(direction);
        this.theta = getTheta();
        brain.sendLogMessage(x + " , " + y + " theta = " + theta);

    }

    public void broadcast(String message) {
        brain.broadcast(message);
    }

    public ArrayList<String> fetchAllMessages() {
        return brain.fetchAllMessages();
    }

    public IFrontSensorResult detectFront() {
        return brain.detectFront();
    }

    public ArrayList<IRadarResult> detectRadar() {
        return brain.detectRadar();
    }

    public double getHealth() {
        return brain.getHealth();
    }

    public boolean isSameDirection(double dir) {
        return Math.abs(theta - dir) < EPSILON;
    }

    public boolean isSameDirection(Robot robot) {
        return isSameDirection(robot.theta);
    }

    public int getId() {
    	return id;
    }
    
    public double getTheta() {
        double result = brain.getHeading();

        while (result < 0) result += 2 * Math.PI;
        while (result > 2 * Math.PI) result -= 2 * Math.PI;
        return result;
    }

    public boolean isSamePosition(int x, int y) {
        return Math.abs(this.x - x) < POSITION_DIFF && Math.abs(this.y - y) < POSITION_DIFF;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getSpeed() {
        return speed;
    }

    public void fire() {
        brain.fire(fireTheta);
    }

    public double getFireDirection() {
        return fireTheta;
    }

    public void setFireDirection(double fireTheta) {
        this.fireTheta = fireTheta;

    }


}
