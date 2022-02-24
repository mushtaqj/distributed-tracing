package com.wurthlac.elasticpath;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class ElasticPathApplication
{
  public static void main (String[] args)
  {
    SpringApplication.run(ElasticPathApplication.class, args);
  }

}
