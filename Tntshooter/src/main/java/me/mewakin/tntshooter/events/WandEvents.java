package me.mewakin.tntshooter.events;

import me.mewakin.tntshooter.Main;
import me.mewakin.tntshooter.items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;


public class WandEvents implements Listener {
    private Main plugin;
    Map<String, Long> cooldowns = new HashMap<>();

    public WandEvents(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
                && e.getItem().getItemMeta().equals(ItemManager.wand.getItemMeta()) && p.hasPermission("tntshooter.usewand")) {
            e.setCancelled(true);

            if (cooldowns.containsKey(p.getName())) {
                if (cooldowns.get(p.getName()) > System.currentTimeMillis()) {
                    long timeleft = (cooldowns.get(p.getName()) - System.currentTimeMillis()) / 1000;
                    p.sendMessage(ChatColor.GOLD + "Ability will be ready in " + (timeleft + 1) + " second(s)!");

                    return;
                }
            }
            cooldowns.put(p.getName(), System.currentTimeMillis() + plugin.getConfig().getInt("cooldown"));

            Location loc = p.getLocation();

            Entity f = loc.getWorld().spawnEntity(loc.add(loc.getDirection().getX(), 1.2, loc.getDirection().getZ()), EntityType.WITHER_SKULL);
            f.setVelocity(loc.getDirection().multiply(plugin.getConfig().getInt("speed")));
        }
    }
}
