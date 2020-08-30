package work.garaku.code.example.spring_cloud_stream_firsttime;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Map;

@SpringBootApplication
@EnableBinding(Barista.class)
@AllArgsConstructor
public class ProcessorApp {
  private final Barista barista;

  public static void main(String[] args) {
    SpringApplication.run(ProcessorApp.class, args);
  }

  @StreamListener("orders")
  public void receive(Map<String, Object> message) {
    System.out.println(message);
    barista.coldDrinks().send(MessageBuilder.withPayload(message).build());
  }
}
