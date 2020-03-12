package algorithms.strategy.task;

import algorithms.strategy.Robot;

import java.util.ArrayList;
import java.util.List;

public class TaskExecutor implements Task {

    private List<Task> tasks = new ArrayList<>();
    private int index = 0;

    public TaskExecutor() {

    }

    public void add(Task task) {
        tasks.add(task);
    }

    public void addAll(Task... tasks) {
        for (Task task : tasks)
            add(task);

    }

    public boolean execute(Robot robot) {
        if (index < tasks.size()) {
            Task current = tasks.get(index);
            if (current != null) {
                if (current.execute(robot)) {
                    index++;
                }
                return false;
            }
        }
        return true;
    }

    @Override
    public Task copy() {
        TaskExecutor executor = new TaskExecutor();
        executor.tasks = tasks;
        return executor;
    }
}
