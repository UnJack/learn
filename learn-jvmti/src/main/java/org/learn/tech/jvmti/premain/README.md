#mac premain compiler command:

#用到的java文件
    Transformer.java
    TransformerPremain.java
    TransformerTarget.java
    TransformerTargetMain.java
    #建议在执行的时候将每个java文件中的package包路径删除，避免创建路径带来的不便
#编译：
    javac Transformer.java TransformerTargetMain.java TransformerTarget.java TransformerPremain.java

#打包premain命令：
    jar -cvfm Premain.jar MANIFEST.MF TransformerTarget.class.2 Transformer.class TransformerPremain.class

    # premain 打包的MANIFEST.MF
        Manifest-Version: 1.0
        Premain-Class: TransformerPremain

#运行命令：
    java -javaagent:Premain.jar TransformerTargetMain
        
#注意：MANIFEST.MF 每个属性:后面需要一个空格.否则(invalid header field)
