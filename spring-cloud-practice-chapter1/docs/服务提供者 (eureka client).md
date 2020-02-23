# 服务提供者 (eureka client)

- 学习资源地址：https://www.fangzhipeng.com/springcloud/2017/06/01/sc01-eureka.html

1、当client向server注册时，它会提供一些元数据，例如主机和端口，URL，主页等。Eureka server 从每个client实例接收心跳消息。 如果心跳超时，则通常将该实例从注册server中删除。

2、通过注解@EnableEurekaClient 表明自己是一个eurekaclient.
```
@SpringBootApplication
@EnableEurekaClient
@RestController
public class ScServiceHiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScServiceHiApplication.class, args);
    }


    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "chenlw") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }
}

```
仅仅@EnableEurekaClient是不够的，还需要在配置文件中注明自己的服务注册中心的地址，application.yml配置文件如下：
```
eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/
server:
  port: 8762
spring:
  application:
    name: service-hi
```
需要指明spring.application.name,这个很重要，这在以后的服务与服务之间相互调用一般都是根据这个name 。

3、http://localhost:8762/hi?name=chenlw

