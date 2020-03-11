package algorithms.strategy;

public class FireTask extends AbstractTask {
    public FireTask() {
        super(null);
    }

    @Override
    public boolean execute(Robot robot) {
        robot.fire();
        return true;
    }
}
