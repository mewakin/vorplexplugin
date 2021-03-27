package me.mewakin.tntshooter;

import me.mewakin.tntshooter.commands.TntshooterCommands;
import me.mewakin.tntshooter.commands.SpawnWandCommand;
import me.mewakin.tntshooter.events.WandEvents;
import me.mewakin.tntshooter.items.ItemManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        saveDefaultConfig();

        ItemManager.init();

        getCommand("spawnwand").setExecutor(new SpawnWandCommand());
        getCommand("tntshooter").setExecutor(new TntshooterCommands(this));
        getServer().getPluginManager().registerEvents(new WandEvents(this), this);
    }
}
