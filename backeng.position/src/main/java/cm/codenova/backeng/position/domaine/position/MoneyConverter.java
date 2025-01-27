package cm.codenova.backeng.position.domaine.position;

import jakarta.persistence.Converter;
import org.apache.commons.lang3.StringUtils;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import java.util.Optional;

import jakarta.persistence.AttributeConverter;

@Converter(
        autoApply = true
)
public class MoneyConverter  implements AttributeConverter<MonetaryAmount, String> {
    public MoneyConverter() {
    }

    public String convertToDatabaseColumn(MonetaryAmount attribute) {
        return Optional.ofNullable(attribute).map((value) -> {
            return String.join(";", value.getCurrency().getCurrencyCode(), "" + value.getNumber().doubleValue());
        }).orElse(null);
    }

    public MonetaryAmount convertToEntityAttribute(String dbData) {
        if (StringUtils.isEmpty(dbData)) {
            return null;
        } else {
            String[] split = dbData.split(";");

            try {
                return Monetary.getDefaultAmountFactory().setCurrency(split[0]).setNumber(Double.parseDouble(split[1])).create();
            } catch (Throwable var4) {
                throw new IllegalArgumentException("'%s' is an illegal argument for Money object creation".formatted(dbData), var4);
            }
        }
    }
}