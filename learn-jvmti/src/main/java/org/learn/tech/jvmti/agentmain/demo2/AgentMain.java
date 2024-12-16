package org.learn.tech.jvmti.agentmain.demo2;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
/**
 * @create by jimjian on 2017/11/14 11:09
 **/
public class AgentMain {
    public static void agentmain(String agentArgs, Instrumentation inst) {
        inst.addTransformer(new Transformer(), true);
        try {
            inst.retransformClasses(TransformerTarget.class);
        } catch (UnmodifiableClassException e) {
            e.printStackTrace();
        }
        System.out.println("[AgentMain] Done!");
    }
}