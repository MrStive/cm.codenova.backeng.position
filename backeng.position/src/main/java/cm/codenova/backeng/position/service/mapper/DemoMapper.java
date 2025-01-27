package cm.codenova.backeng.position.service.mapper;

import cm.codenova.backeng.position.demo.dto.DemoDTO;
import cm.codenova.backeng.position.domaine.Demo;
import org.mapstruct.BeanMapping;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface DemoMapper {
  @BeanMapping(ignoreByDefault = true)
  @Mapping(source = "name", target = "name")
  @Mapping(source = "demoId.value", target = "id")
  DemoDTO mapToDemoDTO(Demo demo);
}
