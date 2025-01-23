package cm.codenova.backeng.position.service;

import cm.codenova.backeng.position.domaine.position.FactoryPosition;
import cm.codenova.backeng.position.domaine.position.FactoryPositionImpl;
import cm.codenova.backeng.position.domaine.position.PositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class PositionBeans {
    @Bean
    public FactoryPosition factoryPosition(PositionRepository positionRepository) {
        return new FactoryPositionImpl(positionRepository);
    }

    @Bean
    public PositionRepository positionRepository(PositionRepository positionRepository) {
        return new FactoryPositionImpl(positionRepository);
    }
}
