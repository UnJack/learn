package org.learn.tech.design.state_pattern;

/**
 * User: jimjian
 * Date: 16-3-23 下午2:54
 */
public class Poor implements State{
    @Override
    public void saySomething(StateContext sc) {
        System.out.println("I'm poor currently, and spend much time working.");
        sc.changeState(new Rich());
    }
}