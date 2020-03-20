package algorithms.strategy.task;

import algorithms.strategy.Robot;
import characteristics.IRadarResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RadarReceptionTask implements Task {
    private List<MoveGoal> messages = new ArrayList<>();

    @Override
    public boolean execute(Robot robot) {
        messages = robot.fetchAllMessages()
                .stream()
                .map(IRadarResult::parse)
                .collect(Collectors.toList());

        return messages.size() > 0;
    }

    public List<MoveGoal> getMessages() {
        return messages;
    }

    @Override
    public Task copy() {
        return null;
    }


}

