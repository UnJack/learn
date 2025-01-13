package org.learn.tech.design.state_pattern;

import org.learn.tech.design.state_pattern.enums.ActionType;

public class TaskOngoing implements State {

    private ActivityService activityService;
    private TaskManager taskManager;

    @Override
    public void update(Task task, ActionType actionType) {
        if (actionType == ActionType.ACHIEVE) {
            task.setState(new TaskFinished());
            activityService.notifyFinished(task);
            taskManager.release(task);
        } else if (actionType == ActionType.STOP) {
            task.setState(new TaskPaused());
        } else if (actionType == ActionType.EXPIRE) {
            task.setState(new TaskExpired());
        }
    }
}
