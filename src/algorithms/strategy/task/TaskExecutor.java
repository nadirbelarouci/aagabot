package algorithms.strategy.task;

import algorithms.strategy.Robot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskExecutor implements Task {
	
	// Queue of tasks
    private List<Task> tasks = new ArrayList<>();
    // current task to execute
    private Task current = null;
    
    public boolean isEmpty() {
    	return tasks.isEmpty();
    }

    public void add(Task task) {
        tasks.add(task);
    }

    public void addAll(Task... tasks) {
    	this.tasks.addAll(Arrays.asList(tasks));
    }
    
    public void clear() {
    	this.current = null;
    	this.tasks.clear();
    }
    
    public void update(Task...tasks) {
    	clear();
    	addAll(tasks);
    }
    
    public void update(Task task) {
    	clear();
    	add(task);
    }

    public boolean execute(Robot robot) {
    	if(current == null && !tasks.isEmpty()) {
    		current = tasks.get(0);
    	}
    	if(current != null) {
			var accomplished = current.execute(robot);
			if(accomplished) {
				current = null;
				tasks.remove(0);
			}
    	}
    	return current == null && tasks.isEmpty();
    }

    @Override
    public Task copy() {
        TaskExecutor executor = new TaskExecutor();
        executor.tasks = tasks;
        return executor;
    }
}
