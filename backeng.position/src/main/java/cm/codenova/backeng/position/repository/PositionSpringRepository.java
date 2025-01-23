package cm.codenova.backeng.position.repository;

import cm.codenova.backeng.position.domaine.position.Position;
import cm.codenova.backeng.position.domaine.position.PositionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionSpringRepository extends JpaRepository<Position, PositionId> {}
