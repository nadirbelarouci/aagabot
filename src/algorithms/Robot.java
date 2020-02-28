package algorithms;

import characteristics.IBrain;
import characteristics.Parameters;

public class Robot {

    private int id;
    private double theta;
    private double thetaTarget;
    private double x;
    private double y;
    private IBrain brain;
    private int state;

    public Robot(IBrain brain, int id) {
        this.brain = brain;
        this.id = id;
    }

    public void step() {
        System.out.println(theta + "-" + thetaTarget + " = " + Math.abs(theta - thetaTarget));
        double diff = theta - thetaTarget;
        if (Math.abs(diff) > 0.001) {
                turn(Parameters.Direction.RIGHT);

        }

    }

    public void move() {
        brain.move();
    }

    public void moveTo(int x, int y) {
        thetaTarget = Math.atan2(y, x);
    }

    public void turn(Parameters.Direction direction) {
        theta = myGetHeading();
        brain.stepTurn(direction);
    }

    private double myGetHeading() {
        double result = brain.getHeading();

        while (result < 0) result += 2 * Math.PI;
        while (result > 2 * Math.PI) result -= 2 * Math.PI;
        return result;
    }
}
