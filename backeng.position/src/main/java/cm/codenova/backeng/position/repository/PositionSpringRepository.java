package cm.codenova.backeng.position.repository;

import cm.codenova.backeng.position.domaine.Demo;
import cm.codenova.backeng.position.domaine.DemoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionSpringRepository extends JpaRepository<Demo, DemoId> {}
