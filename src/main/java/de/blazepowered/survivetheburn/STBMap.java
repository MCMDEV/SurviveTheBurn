package de.blazepowered.survivetheburn;

import org.bukkit.util.Vector;

public class STBMap {

    private final String name;
    private STBRegion region;
    private Vector deltaSpawnLocation;

    public STBMap(String name, STBRegion region, Vector deltaSpawnLocation) {
        this.name = name;
        this.region = region;
        this.deltaSpawnLocation = deltaSpawnLocation;
    }

    public String getName() {
        return name;
    }

    public STBRegion getRegion() {
        return region;
    }

    public void setRegion(STBRegion region) {
        this.region = region;
    }

    public Vector getDeltaSpawnLocation() {
        return deltaSpawnLocation;
    }

    public void setDeltaSpawnLocation(Vector deltaSpawnLocation) {
        this.deltaSpawnLocation = deltaSpawnLocation;
    }
}
