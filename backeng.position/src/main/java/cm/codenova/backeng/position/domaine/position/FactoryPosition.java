package cm.codenova.backeng.position.domaine.position;

import java.util.UUID;

public interface FactoryPosition {
    UUID create(Position position);
}
