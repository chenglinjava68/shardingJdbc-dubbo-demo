# shardingJdbc-dubbo-demo
基于dubbo、当当网sharding-Jdbc、mybatis-plus的分库分表Demo

##分库分表配置说明
  * db.properties中配置数据源链接（与spring/spring-jdbc.xml中一一对应，如有添加请一同修改该文件）
  * spring-jdbc.xml 中除了配置上述数据源以外，需要配置分库、分表策略。其中**DbAlgorithm**、**TbAlgorithm**中定义规则
  ```xml
  <rdb:strategy id="dbStrategy" sharding-columns="id" algorithm-class="com.reapal.config.DbAlgorithm"/>

    <rdb:strategy id="idStrategy" sharding-columns="id" algorithm-class="com.reapal.config.TbAlgorithm"/>

    <rdb:data-source id="shardingDataSource">
        <rdb:sharding-rule data-sources="rbb_0,rbb_1,rbb_2,rbb_3">
            <rdb:table-rules>
                <rdb:table-rule logic-table="user" actual-tables="user_${0..1}"
                                database-strategy="dbStrategy" table-strategy="idStrategy"/>
            </rdb:table-rules>
        </rdb:sharding-rule>
    </rdb:data-source>
  ```
