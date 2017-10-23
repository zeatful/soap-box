package soapbox.domain.locality;

import lombok.Data;

public @Data class County {
    private final String name;
    private final State state;
}
