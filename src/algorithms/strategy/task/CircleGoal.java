package algorithms.strategy.task;

public class CircleGoal implements Goal {
    public final int r;
    public final int x, y;

    public CircleGoal(int r, int x, int y) {
        this.r = r;
        this.x = x;
        this.y = y;
    }
}
