package org.dev.punsihgui;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.dev.punsihgui.Commands.Punish;
import org.dev.punsihgui.Listeners.MenuListener;
import org.dev.punsihgui.Listeners.PlayerClickEntityEvent;
import org.dev.punsihgui.MenuSystem.PlayerMenuUtility;

import java.util.HashMap;

public final class PunsihGUI extends JavaPlugin {
    private static PunsihGUI plugin;

    private static final HashMap<Player, PlayerMenuUtility> playerMenuUtilityMap = new HashMap<>();

    @Override
    public void onEnable() {

        plugin = this;

        getCommand("punish").setExecutor(new Punish());
        getCommand("pu").setExecutor(new Punish());

        getServer().getPluginManager().registerEvents(new MenuListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerClickEntityEvent(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static PlayerMenuUtility getPlayerMenuUtility(Player p) {
        PlayerMenuUtility playerMenuUtility;
        if (!(playerMenuUtilityMap.containsKey(p))) {
            playerMenuUtility = new PlayerMenuUtility(p);
            playerMenuUtilityMap.put(p, playerMenuUtility);

            return playerMenuUtility;
        } else {
            return playerMenuUtilityMap.get(p);
        }
    }

    public static PunsihGUI getPlugin() {
        return plugin;
    }

}
