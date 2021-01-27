# graduation-process-management

* v1.0
```
component包下为原工具类，按单例组件设计  
entity直接当dao层  
修改application.yml/generatorConfig.xml数据源配置  
在Maven视图/plugins/mybatis-generator，运行mybatis-generator:generate生成model/mapper  
每次均创建model覆盖，但仅为新数据表创建mapper  

mybatis-plus全局雪花算法生成ID
注入乐观锁拦截器  
Jackson序列化时忽略空值属性  
```




