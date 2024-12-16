jar包放在同一个目录下


D:\com>javac -classpath d:\com\javassist-3.20.0-GA.jar agent\Transformer.java agent\Agent.java
D:\com>jar cvfm ssit.jar MANIFEST.MF agent\Transformer.class agent\Agent.class

MANIFEST.MF
Manifest-Version: 1.0
Archiver-Version: Plexus Archiver
Build-Jdk: 1.8.0_102
Created-By: 1.8.0_131 (Oracle Corporation)
Premain-Class: javassit.Agent
Boot-Class-Path: javassist-3.20.0-GA.jar

D:\com>javac agent\TimeTest.java
D:\com>jar cvfm time.jar MANIFEST.MF agent\TimeTest.class

MANIFEST.MF
Manifest-Version: 1.0
Archiver-Version: Plexus Archiver
Main-Class: agent.TimeTest
Can-Redefine-Classes: true

D:\com>java -javaagent:ssit.jar=jimjian -jar time.jar