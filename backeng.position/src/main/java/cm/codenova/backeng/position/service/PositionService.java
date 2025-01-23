package cm.codenova.backeng.position.service;

import cm.codenova.backeng.position.demo.dto.PositionDTO;
import cm.codenova.backeng.position.domaine.position.FactoryPosition;
import cm.codenova.backeng.position.service.mapper.MapperPosition;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PositionService {
    private final FactoryPosition factoryPosition;
    private final MapperPosition mapperPosition;

    @Transactional
    public UUID createPosition(PositionDTO positionDTO) {
        return factoryPosition.create(mapperPosition.mapToPosition(positionDTO));
    }
}
