package algorithms.strategy.task;

public class MoveGoal implements Goal {
    public final int x, y;

    public MoveGoal(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public MoveGoal(double v, double v1) {
        x = (int) v;
        y = (int) v1;
    }
}
