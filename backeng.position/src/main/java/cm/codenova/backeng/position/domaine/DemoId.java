package cm.codenova.backeng.position.domaine;

import java.io.Serializable;
import java.util.UUID;
import lombok.Getter;

@Getter
public class DemoId implements Serializable {
  String value;

  public DemoId() {
    value = UUID.randomUUID().toString();
  }
}
