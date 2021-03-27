package me.mewakin.tntshooter.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.WitherSkull;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {
    public static ItemStack wand;

    public static void init() {
        createWand();
    }

    private static void createWand() {
        ItemStack item = new ItemStack(Material.WITHER_ROSE, 1);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§0§lWither Wand");

        List<String> lore = new ArrayList<>();
        lore.add("§7A powerful wand created in ");
        lore.add("§7the depths of the nether.");
        lore.add("§7It's terrifying wither skull ");
        lore.add("§7shooting attribute made it one of");
        lore.add("§7the most sought after items to exist!");
        meta.setLore(lore);

        item.setItemMeta(meta);

        wand = item;
    }
}
