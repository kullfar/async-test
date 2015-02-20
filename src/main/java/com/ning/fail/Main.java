package com.ning.fail;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import java.util.concurrent.ExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Main {

  private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

  public static final void main(final String... args) throws InterruptedException, ExecutionException {
    final AsyncHttpClientConfig config = new AsyncHttpClientConfig.Builder()
            .setMaxConnections(6)
            .setMaxConnectionsPerHost(3)
            .build();
    try (AsyncHttpClient client = new AsyncHttpClient(config)) {
      LOGGER.info("first request");
      client.prepareGet("https://connect.mail.ru").execute().get();
      LOGGER.info("sleep");
      Thread.sleep(5000);
      LOGGER.info("second request");
      client.prepareGet("https://connect.mail.ru").execute().get();
      LOGGER.info("sleep");
      Thread.sleep(5000);
      LOGGER.info("third request");
      client.prepareGet("https://connect.mail.ru").execute().get();
      LOGGER.info("sleep");
      Thread.sleep(5000);
      LOGGER.info("forth request");
      client.prepareGet("https://connect.mail.ru").execute().get();
    }
  }
}
