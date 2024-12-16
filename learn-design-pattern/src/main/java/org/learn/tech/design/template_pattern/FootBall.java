package org.learn.tech.design.template_pattern;

public class FootBall extends Game {

    @Override
    protected void init() {
        System.out.println("init FootBall");
    }

    @Override
    protected void startPlay() {
        System.out.println("startPlay FootBall");
    }

    @Override
    protected void endPlay() {
        System.out.println("endPlay FootBall");
    }
}
