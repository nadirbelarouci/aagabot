package algorithms.strategy.task;

public abstract class AbstractTask implements Task {
    private Goal goal;

    public AbstractTask(Goal goal) {
        this.goal = goal;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }
}
