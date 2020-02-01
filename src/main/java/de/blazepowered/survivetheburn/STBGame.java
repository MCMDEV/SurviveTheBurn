package de.blazepowered.survivetheburn;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class STBGame {

    private final String name;
    private List<Player> playerList = new ArrayList<>();

    public STBGame(@NotNull String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
