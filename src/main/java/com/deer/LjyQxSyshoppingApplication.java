package com.deer;

import com.deer.ljy.config.CORSInterceptor;
import com.deer.ljy.config.CasConfig;
import com.deer.ljy.config.GlobalCorsConfig;
import com.deer.ljy.config.SpringShiroConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = "com.deer")
@MapperScan(value = {"com.deer.ljy.mapper","com.deer.qx.mapper"})
@Import(value = {SpringShiroConfig.class, GlobalCorsConfig.class})

//扫描es包
public class LjyQxSyshoppingApplication {

    public static void main(String[] args) {
        SpringApplication.run(LjyQxSyshoppingApplication.class, args);
    }

}
