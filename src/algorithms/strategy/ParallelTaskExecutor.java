package algorithms.strategy;

import java.util.LinkedList;
import java.util.Queue;

public class ParallelTaskExecutor implements Task {
    private Queue<Task> tasks = new LinkedList<>();

    public void add(Task task) {
        add(task);
    }

    @Override
    public boolean execute(Robot robot) {


        return false;
    }
}
