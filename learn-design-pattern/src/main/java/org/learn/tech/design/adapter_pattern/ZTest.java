package org.learn.tech.design.adapter_pattern;

/**
 * 适配器模式</br>
 * {@link java.util.Arrays#asList(Object[])}</br>
 */
public class ZTest {
    public static void main(String[] args) {

        RoundHole roundHole = new RoundHole(5);
        RoundPeg roundPeg = new RoundPeg(5);
        if (roundHole.fits(roundPeg)) {
            System.out.println("Round peg r5 fits round hole r5.");
        }

        SquarePeg squarePeg = new SquarePeg(2);
        SquarePegAdapter adapter = new SquarePegAdapter(squarePeg);

        if (roundHole.fits(adapter)) {
            System.out.println("Square peg w10 fits round hole r5.");
        }
    }
}