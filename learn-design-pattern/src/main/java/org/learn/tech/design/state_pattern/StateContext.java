package org.learn.tech.design.state_pattern;

/**
 * User: jimjian
 * Date: 16-3-23 下午2:53
 */
public class StateContext {
    private State currentState;

    public StateContext(){
        currentState = new Poor();
    }

    public void changeState(State newState){
        this.currentState = newState;
    }

    public void saySomething(){
        this.currentState.saySomething(this);
    }
}