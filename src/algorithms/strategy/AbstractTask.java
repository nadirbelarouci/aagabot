package algorithms.strategy;

public abstract class AbstractTask implements Task {
    private Goal goal;

    public AbstractTask(Goal goal) {
        this.goal = goal;
    }

    public Goal getGoal() {
        return goal;
    }

}
