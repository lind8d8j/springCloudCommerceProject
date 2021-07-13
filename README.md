# 工程简介
SpringCloud电商项目实战
技术栈：
eureka、feign、ribbon、hystrix、zuul、security、
spring cloud、spring boot、mybatis、spring MVC、thymeleaf

环境：
maven 3.6.2
mysql 5.5
idea 2019.3.5
springboot 2.3.7.RELEASE
spring cloud Hoxton.SR11

# 延伸阅读

1.先把两个sql文件导入数据库
2.把common模块安装到本地
3.修改两个provider的yml 数据库连接
4.先启动eureka-server -> user-provider -> user-consumer
 -> goods-provider -> goods-consumer -> gateway-service
