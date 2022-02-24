package com.wurthlac.elasticpath;

import okhttp3.OkHttpClient;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppAutoConfiguration
{
  @Bean
  RestTemplateCustomizer useOkHttpClient (final OkHttpClient okHttpClient)
  {
    return restTemplate -> restTemplate.setRequestFactory(new OkHttp3ClientHttpRequestFactory(okHttpClient));
  }

  @Bean
  RestTemplate getRestTemplate (final RestTemplateBuilder restTemplateBuilder)
  {
    return restTemplateBuilder.build();
  }
}
