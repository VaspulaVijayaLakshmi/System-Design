package models;

import java.util.UUID;

public class Theater {

    String theaterId;
    String name;

    public Theater(String name) {
        this.theaterId = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(String theaterId) {
        this.theaterId = theaterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
