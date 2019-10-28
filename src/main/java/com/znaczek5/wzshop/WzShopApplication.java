package com.znaczek5.wzshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    Random gen = new Random();
    List<String> sqlStatements = new ArrayList<>();

    StringBuilder sb = new StringBuilder();

    String d = LocalDateTime.now().toString();
    sb.append("insert into category(id, name, slug, parent_id, created_date, created_by) values ");
    List<String> li = new ArrayList<>();
    li.add(String.format("(1, 'Dom', 'dom', null, '%s', 'znaczek')", d));
    li.add(String.format("(2, 'Meble', 'meble', 1, '%s', 'znaczek')", d));
    li.add(String.format("(3, 'Acesoria', 'akcesoria', 1, '%s', 'znaczek')", d));
    li.add(String.format("(4, 'Elektronika', 'elektronika', null, '%s', 'znaczek')", d));
    li.add(String.format("(5, 'Komputery', 'komputery', 4, '%s', 'znaczek')", d));
    li.add(String.format("(6, 'Telewizory', 'telewizory', 4, '%s', 'znaczek')", d));
    li.add(String.format("(7, 'Telefony', 'telefony', 4, '%s', 'znaczek')", d));
    li.add(String.format("(8, 'Samsung', 'samsung', 7, '%s', 'znaczek')", d));
    li.add(String.format("(9, 'Nokia', 'nokia', 7, '%s', 'znaczek')", d));
    li.add(String.format("(10, 'Apple', 'apple', 7, '%s', 'znaczek')", d));
    li.add(String.format("(11, 'Krzesło', 'krzeslo', 2, '%s', 'znaczek')", d));
    li.add(String.format("(12, 'Stół', 'stol', 2, '%s', 'znaczek')", d));
    li.add(String.format("(13, 'Klamka', 'klamka', 3, '%s', 'znaczek')", d));
    li.add(String.format("(14, 'Okno', 'okno', 3, '%s', 'znaczek')", d));
    sb.append(String.join(", ", li));
    sb.append(';');

    Integer[] catIds = new Integer[]{5, 6, 8, 9, 10, 11, 12, 13, 14};

    sb.append("insert into product(name, description, price, category_id, created_date, created_by) values ");
    li = new ArrayList<>();
    for (int i = 1; i < 200; i += 1) {
      LocalDateTime date = LocalDateTime.now().minusDays(i);
      li.add(
        String.format("('Product %s','Product %s desc', %d, %d,'%s', '%s')",
          i,
          i,
          gen.nextInt(10000),
          catIds[gen.nextInt(catIds.length - 1)],
          date.toString(),
          "znaczek"
        )
      );
    }
    sb.append(String.join(", ", li));

    sqlStatements.add(sb.toString());
    sqlStatements.forEach(sql -> {
      jdbcTemplate.execute(sql);
    });
  }

}
