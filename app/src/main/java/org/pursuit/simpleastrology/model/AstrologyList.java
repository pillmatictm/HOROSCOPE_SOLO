package org.pursuit.simpleastrology.model;

import java.util.List;

public class AstrologyList {
    public List<Astrology> message;

    public AstrologyList(List<Astrology> message) {
        this.message = message;
    }

    public List<Astrology> getMessage() {
        return message;
    }
}
