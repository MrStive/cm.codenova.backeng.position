package cm.codenova.backeng.position.domaine.position;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;
@Embeddable
@Setter
public class PositionId implements Serializable {
    private String value;
    public PositionId() {
        value = UUID.randomUUID().toString();
    }
    public UUID toUUID() {
        return UUID.fromString(value);
    }
}
