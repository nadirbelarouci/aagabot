package algorithms.strategy.task;

public class MoveGoal implements Goal {
    public final int x, y;
    public final double fireTheta;

    public MoveGoal(int x, int y) {
        this.x = x;
        this.y = y;
        fireTheta = 0;
    }

    public MoveGoal(double v, double v1) {
        x = (int) v;
        y = (int) v1;
        fireTheta = 0;
    }

    public MoveGoal(double x, double y, double fireTheta) {
        this.x = (int) x;
        this.y = (int) y;
        this.fireTheta = fireTheta;
    }

    @Override
    public String toString() {
        return String.format("[%d,%d,%f]", x, y, fireTheta);
    }
}
