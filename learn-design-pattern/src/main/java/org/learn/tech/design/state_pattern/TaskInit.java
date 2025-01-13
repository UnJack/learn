package org.learn.tech.design.state_pattern;

import org.learn.tech.design.state_pattern.enums.ActionType;

public class TaskInit implements State {

    @Override
    public void update(Task task, ActionType actionType) {
        if (actionType == ActionType.START) {
            task.setState(new TaskOngoing());
        }
    }
}
