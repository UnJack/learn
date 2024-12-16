package org.learn.tech.jvmti.premain;

import java.lang.instrument.Instrumentation;

public class TransformerPremain {
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("agentArgs = " + agentArgs);
        inst.addTransformer(new Transformer());
    }
}
