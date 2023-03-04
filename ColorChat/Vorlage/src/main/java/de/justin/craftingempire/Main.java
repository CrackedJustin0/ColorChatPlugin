package de.justin.craftingempire;
import de.justin.craftingempire.Listener.ChatListener;
import de.justin.craftingempire.util.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private Config general;
    private static Main plugin;

    @Override
    public void onEnable() {
        plugin = this;
        general = new Config("general.yml", getDataFolder());
        PluginManager pluginManager = Bukkit.getPluginManager();
        ItemManager.loadItems();
        RecipeManager.recipes();
        pluginManager.registerEvents(new ChatListener(), this);
    }

    @Override
    public void onDisable() {

    }
    public Config getGeneral() {return general;}
    public static Main getPlugin() {
        return plugin;
    }
}
