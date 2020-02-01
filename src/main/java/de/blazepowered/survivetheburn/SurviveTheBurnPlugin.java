package de.blazepowered.survivetheburn;

import com.google.common.io.MoreFiles;
import com.google.common.io.RecursiveDeleteOption;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public final class SurviveTheBurnPlugin extends JavaPlugin implements SurviveTheBurn {

    private final Map<Long, STBGame> gameMap = new HashMap<>();
    private World testWorld;

    @Override
    public void onEnable() {
        // Plugin startup logic

        this.testWorld = WorldCreator.name("TestWorld").generator(new ChunkGenerator() {
            @Override
            public @NotNull ChunkData generateChunkData(@NotNull World world, @NotNull Random random, int x, int z, @NotNull BiomeGrid biome) {
                return createChunkData(world);
            }
        }).generateStructures(false).createWorld();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        getServer().unloadWorld(this.testWorld, false);
        try {
            MoreFiles.deleteDirectoryContents(this.testWorld.getWorldFolder().toPath(), RecursiveDeleteOption.ALLOW_INSECURE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.testWorld.getWorldFolder().delete();
    }

    @Override
    public STBGame createGame(long id, String name) {
        STBGame game = new STBGame(name);
        STBGame put = this.gameMap.putIfAbsent(id, game);
        if (put != null) {
            throw new IllegalStateException("game already exists.");
        }
        return game;
    }

    @Override
    public STBGame getGame(long id) {
        return this.gameMap.get(id);
    }

    @Override
    public STBGame deleteGame(long id) {
        return this.gameMap.remove(id);
    }
}
