package soapbox.domain.locality;

import lombok.Data;

public @Data class State {
    private final String name;
    private final State state;
}
