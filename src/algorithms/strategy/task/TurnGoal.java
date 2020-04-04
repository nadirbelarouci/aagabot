package algorithms.strategy.task;

public class TurnGoal implements Goal {
    public final double theta;

    public TurnGoal(double theta) {
    	double r = theta;
    	while(r < 0) r += 2 * Math.PI;
    	while(r > 2 * Math.PI) r -= 2 * Math.PI;
        this.theta = r;
    }

    public TurnGoal(double oX, double oY, double x, double y) {
        double result;
        result = Math.atan2(y - oY, x - oX);
        while (result < 0) result += 2 * Math.PI;
        while (result > 2 * Math.PI) result -= 2 * Math.PI;
        theta = result;
    }
}
