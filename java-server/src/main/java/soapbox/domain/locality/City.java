package soapbox.domain.locality;

import lombok.Data;

public @Data class City {
    private final String name;
    private final State state;
}
