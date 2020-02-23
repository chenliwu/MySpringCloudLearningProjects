# 服务注册中心-Eureka

1、启动一个服务注册中心，只需要一个注解@EnableEurekaServer，这个注解需要在springboot工程的启动application类上加：
```
@SpringBootApplication
@EnableEurekaServer
public class ScEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScEurekaServerApplication.class, args);
    }

}

```

2、eureka是一个高可用的组件，它没有后端缓存，每一个实例注册之后需要向注册中心发送心跳（因此可以在内存中完成），在默认情况下eureka server也是一个eureka client ,必须要指定一个 server。eureka server的配置文件appication.yml：
```
server:
  port: 8761

eureka:
  instance:
    hostname: localhost
  client:
    registerWithEureka: false
    fetchRegistry: false
    serviceUrl:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/

spring:
  application:
    name: eureka-server
```

通过eureka.client.registerWithEureka：false和fetchRegistry：false来表明自己是一个eureka server.


3、eureka server 是有界面的，启动工程,打开浏览器访问： http://localhost:8761

