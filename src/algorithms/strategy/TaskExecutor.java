package algorithms.strategy;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class TaskExecutor implements Task {

    private Queue<Task> tasks = new LinkedList<>();

    public TaskExecutor() {

    }

    public TaskExecutor(Queue<Task> tasks) {
        this.tasks = Objects.requireNonNull(tasks);
    }

    public void add(Task task) {
        tasks.add(task);
    }

    public void addAll(Task... tasks) {
        for (Task task : tasks)
            add(task);

    }

    public boolean execute(Robot robot) {
        Task current = tasks.peek();
        if (current != null) {
            if (current.execute(robot)) {
                tasks.poll();
            }
            return false;
        }
        return true;

    }


}
