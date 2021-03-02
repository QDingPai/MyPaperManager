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

* todo日志
```
-----------------------------------
2020-3-2

更新了一批接口

-----------------------------------
2020-2-8

完成三个接口

patch /api/director/teachers/{uid}/role
patch /api/director/teachers/{uid}/info
put /api/director/teachers/{uid}/password

拦截器关闭

-----------------------------------

```




