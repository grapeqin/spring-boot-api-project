##脚手架项目SpringBoot-mybatis
- druid-springboot 集成
- mybatis-spring-boot集成
 - mybatis-spring-boot 使用手册，请参考https://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/

- tk.mybatis集成
 - 通过MapperScannerConfigurer来设置basePackage
 - model 主键要加上@Id注解

##注意事项
jdbc.url 中需要注意的配置项
- zeroDateTimeBehavior 主要解决mysql数据库中date为0000-00-00时类型转换报错
- serverTimezone 设置返回数据的时区

##参考
- https://mybatis.io/