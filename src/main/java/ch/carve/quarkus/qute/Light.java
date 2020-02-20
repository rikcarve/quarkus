package ch.carve.quarkus.qute;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Light {

    public enum Switch {
        ON,
        OFF
    }

    private String name;
    private Switch status;
}
