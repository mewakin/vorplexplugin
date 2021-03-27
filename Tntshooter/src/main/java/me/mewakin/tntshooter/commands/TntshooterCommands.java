package me.mewakin.tntshooter.commands;

import me.mewakin.tntshooter.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TntshooterCommands implements CommandExecutor {
    private Main plugin;

    public TntshooterCommands(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "Invalid use of command! Usage: /command [arg(s)]");
            return true;
        }
        if (args.length > 0 && args[0].equalsIgnoreCase("reload")) {
            if (!sender.hasPermission("tntshooter.reloadconfig")) {
                sender.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
                return true;
            }
            plugin.reloadConfig();
            for (String i : plugin.getConfig().getStringList("reload.message")) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', i));
            }
            return true;
        }
        sender.sendMessage(ChatColor.RED + "Invalid use of command! Usage: /command [arg(s)]");
        return true;
    }
}
