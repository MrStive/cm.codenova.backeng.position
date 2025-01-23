package cm.codenova.backeng.position.domaine.position;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.money.MonetaryAmount;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Position {
    @EmbeddedId
    @Builder.Default
    @AttributeOverride(name = "value", column = @Column(name = "c_id"))
    private PositionId id = new PositionId();
    @Column(name = "c_name")
    private String name;
    @Column(name = "c_cost_per_hour")
    @Convert(converter = MoneyConverter.class)
    private MonetaryAmount costPerHour;
    @Column(name = "c_status")
    @Enumerated(EnumType.STRING)
    private Status status;
    @Embedded
    private Address address;
}
