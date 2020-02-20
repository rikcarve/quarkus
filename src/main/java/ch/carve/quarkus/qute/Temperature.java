package ch.carve.quarkus.qute;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Temperature {
    String name;
    BigDecimal temperature;
    BigDecimal humidity;
}
