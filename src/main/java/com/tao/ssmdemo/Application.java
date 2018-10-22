package com.tao.ssmdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement  //开启事务管理
////@MapperScan("com.tao.ssmdemo.dao") //与dao层的@mapper二选一即可
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
