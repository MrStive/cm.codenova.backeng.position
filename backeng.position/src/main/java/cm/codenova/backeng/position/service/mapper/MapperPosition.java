package cm.codenova.backeng.position.service.mapper;

import cm.codenova.backeng.position.demo.dto.AddressDTO;
import cm.codenova.backeng.position.demo.dto.MoneyDTO;
import cm.codenova.backeng.position.demo.dto.PositionDTO;
import cm.codenova.backeng.position.domaine.position.Address;
import cm.codenova.backeng.position.domaine.position.Position;
import org.javamoney.moneta.Money;
import org.mapstruct.BeanMapping;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import javax.money.MonetaryAmount;
import java.math.BigDecimal;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MapperPosition {
    @BeanMapping(ignoreByDefault = true)
    @Mapping(source = "id", target = "id.value")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "costPerHour", target = "costPerHour")
    @Mapping(source = "address", target = "address")
    Position mapToPosition(PositionDTO positionDTO);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(source = "city", target = "city")
    @Mapping(source = "country", target = "country")
    @Mapping(source = "district", target = "district")
    Address mapToPosition(AddressDTO addressDTO);


    default MonetaryAmount mapToPosition(MoneyDTO moneyDTO){
        return Money.of(BigDecimal.valueOf(moneyDTO.getValue().doubleValue()), moneyDTO.getCurrency());
    }



}