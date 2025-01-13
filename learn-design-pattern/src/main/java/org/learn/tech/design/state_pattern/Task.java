package org.learn.tech.design.state_pattern;

import lombok.Data;
import org.learn.tech.design.state_pattern.enums.ActionType;

@Data
public class Task {

    private String taskId;
    private State state = new TaskInit();

    public void update(ActionType actionType) {
        state.update(this, actionType);
    }
}
