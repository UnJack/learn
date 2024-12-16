package org.learn.tech.design.template_pattern;

public abstract class Game {

    public final void pay() {
        init();
        startPlay();
        endPlay();
    }

    protected abstract void init();

    protected abstract void startPlay();

    protected abstract void endPlay();
}
