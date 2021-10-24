package spaceX;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public class Capsule {
    //Attributes
    private int reuse_count;
    private Number water_landings;
    private Number land_landings;
    private String last_update;
    @JsonIgnore
    private UUID launches;
    private String serial;
    private String status;
    private String type;
    private String id;


    //Setters and Getters
    public int getReuse_count() {
        return reuse_count;
    }

    public void setReuse_count(int reuse_count) {
        this.reuse_count = reuse_count;
    }

    public Number getWater_landings() {
        return water_landings;
    }

    public void setWater_landings(Number water_landings) {
        this.water_landings = water_landings;
    }

    public Number getLand_landings() {
        return land_landings;
    }

    public void setLand_landings(Number land_landings) {
        this.land_landings = land_landings;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    public UUID getLaunches() {
        return launches;
    }

    public void setLaunches(UUID launches) {
        this.launches = launches;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    //To String


    @Override
    public String toString() {
        return "Capsules{" +
                "reuse_count=" + reuse_count +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
