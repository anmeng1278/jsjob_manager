package cn.com.jsj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.com.jsj.dao")
public class JsjobManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsjobManagerApplication.class, args);
    }
}
