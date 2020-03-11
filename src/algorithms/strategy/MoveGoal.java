package algorithms.strategy;

public class MoveGoal implements Goal {
    public final int x, y;

    public MoveGoal(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
