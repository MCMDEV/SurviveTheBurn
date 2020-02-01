package de.blazepowered.survivetheburn;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;

public class STBRegion {

    private World world;
    private Vector minimalPosition, maximalPosition;

    public STBRegion(World world, Vector minimalPosition, Vector maximalPosition) {
        this.world = world;
        this.minimalPosition = minimalPosition;
        this.maximalPosition = maximalPosition;
    }

    public boolean isInRegion(Location location) {
        return location.getWorld() == world && isInRegion(location.toVector());
    }

    public boolean isInRegion(Vector vector) {
        return vector.isInAABB(minimalPosition, maximalPosition);
    }

    public boolean isInRegion(int x, int y, int z) {
        return isInRegion(new Vector(x, y, z));
    }

    public Vector getMinimalPosition() {
        return minimalPosition;
    }

    public void setMinimalPosition(Vector minimalPosition) {
        this.minimalPosition = minimalPosition;
    }

    public Vector getMaximalPosition() {
        return maximalPosition;
    }

    public void setMaximalPosition(Vector maximalPosition) {
        this.maximalPosition = maximalPosition;
    }
}
