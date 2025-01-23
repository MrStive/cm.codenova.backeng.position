package cm.codenova.backeng.position.domaine.position;

import lombok.RequiredArgsConstructor;

import java.util.UUID;
@RequiredArgsConstructor
public class FactoryPositionImpl implements FactoryPosition {
    private final PositionRepository positionRepository;
    @Override
    public UUID create(Position position) {
         return positionRepository.save(position).getId().toUUID();
    }
}
