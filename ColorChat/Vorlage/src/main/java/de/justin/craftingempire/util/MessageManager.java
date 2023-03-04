package de.justin.craftingempire.util;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageManager {
    public static void sendStandardMessage(Player player, String message) {
        player.sendMessage(ChatColor.GOLD + "[Crafting Empire] " + ChatColor.GRAY + message);
        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,1,1);
    }

    public static void sendFalseMessage(Player player, String message) {
        player.sendMessage(ChatColor.GOLD + "[Crafting Empire] " + ChatColor.RED + message);
        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO,1,1);
    }

    public static void sendErrorMessage(Player player, String message) {
        player.sendMessage(ChatColor.RED + "[Crafting Empire] " + ChatColor.RED + message);
        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_DEATH,1,1);
    }

    public static void sendSenderFalseMessage(CommandSender sender, String message) {
        sender.sendMessage(ChatColor.GOLD + "[Crafting Empire] " + ChatColor.RED + message);
    }

    public static void sendSenderErrorMessage(CommandSender sender, String message) {
        sender.sendMessage(ChatColor.RED + "[Crafting Empire] " + ChatColor.RED + message);
    }

    public static void sendSenderStandardMessage(CommandSender sender, String message) {
        sender.sendMessage(ChatColor.GOLD + "[Crafting Empire] " + ChatColor.GRAY + message);
    }

    public static void sendCustomMessage(Player player, String message, ChatColor chatColor, Sound sound) {
        player.sendMessage(ChatColor.GOLD + "[Crafting Empire] " + chatColor + message);
        player.playSound(player.getLocation(), sound,1,1);
    }
}
