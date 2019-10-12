package com.znaczek5.wzshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
@SpringBootApplication
public class WzShopApplication {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public static void main(String[] args) {
    SpringApplication.run(WzShopApplication.class, args);
  }

  @PostConstruct
  private void initDb() {
    String sqlStatements[] = {
      "insert into product(name, description, created_date) values " +
      "('Product 1','Product 1 desc', '2012-09-17 18:47:52.069'), " +
      "('Product 2','Product 2 desc', '2012-09-17 18:47:52.069'), " +
      "('Product 3','Product 3 desc', '2012-09-17 18:47:52.069'), " +
      "('Product 4','Product 4 desc', '2012-09-17 18:47:52.069'), " +
      "('Product 5','Product 5 desc', '2012-09-17 18:47:52.069')"
    };

    Arrays.asList(sqlStatements).forEach(sql -> {
      jdbcTemplate.execute(sql);
    });
  }

}
