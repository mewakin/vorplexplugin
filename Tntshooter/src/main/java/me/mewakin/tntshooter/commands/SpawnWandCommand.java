package me.mewakin.tntshooter.commands;

import me.mewakin.tntshooter.items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnWandCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players may use this command!");
            return true;
        }
        Player p = (Player) sender;
        if (!(p.hasPermission("tntshooter.spawnwand"))) {
            p.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
            return true;
        }
        p.sendMessage(ChatColor.GOLD + "A great power is felt in your presence!");
        p.getInventory().addItem(ItemManager.wand);
        return true;
    }
}
