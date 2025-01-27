package cm.codenova.backeng.position.repository;

import cm.codenova.backeng.position.domaine.position.Position;
import cm.codenova.backeng.position.domaine.position.PositionRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PositionRepositoryImpl implements PositionRepository {
  private final   PositionSpringRepository positionSpringRepository;
    @Override
    public Position save(Position position) {
        return positionSpringRepository.save(position);
    }
}
