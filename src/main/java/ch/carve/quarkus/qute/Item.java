package ch.carve.quarkus.qute;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NonNull;

@Data
public class Item {
    @NonNull
    BigDecimal price;
    @NonNull
    String name;
}
