package algorithms.strategy.task;

import algorithms.strategy.Robot;

public interface Task {

    boolean execute(Robot robot);

    Task copy();

}
