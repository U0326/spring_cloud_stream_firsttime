package work.garaku.code.example.spring_cloud_stream_firsttime;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Barista {
  @Input("orders")
  MessageChannel orders();
  @Output("coldDrinks")
  MessageChannel coldDrinks();
}
