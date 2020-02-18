package ch.carve.quarkus.qute;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {
    String name;
    BigDecimal price;

    public Item(BigDecimal bigDecimal, String string) {
        this.name = string;
        this.price = bigDecimal;
    }
}
