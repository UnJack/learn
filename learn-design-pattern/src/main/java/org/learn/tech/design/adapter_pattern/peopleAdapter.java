package org.learn.tech.design.adapter_pattern;

public class peopleAdapter implements eat {
    people people;

    public peopleAdapter(people people) {
        this.people = people;
    }

    @Override
    public void dinner() {
        people.lunch();
    }
}
