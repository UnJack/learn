#mac agentmain compiler command:

#用到的java文件
    AgentAfterMain.java
    Transformer.java
    #建议在执行的时候将每个java文件中的package包路径删除，避免创建路径带来的不便
#编译：
    javac AgentAfterMain.java

#打包agentmain命令：
    jar -cvfm AgentAfterMain.jar MANIFEST.MF AgentAfterMain\$1.class AgentAfterMain.class 
    
    # agentmain 打包的MANIFEST.MF
        Manifest-Version: 1.0
        Agent-Class: AgentAfterMain

#注意：MANIFEST.MF 每个属性:后面需要一个空格.否则(invalid header field)