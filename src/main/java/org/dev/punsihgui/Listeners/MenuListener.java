package org.dev.punsihgui.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.InventoryHolder;
import org.dev.punsihgui.MenuSystem.Menu;
import org.dev.punsihgui.PunsihGUI;

public class MenuListener implements Listener {
    @EventHandler
    public void onMenuClick(InventoryClickEvent e){

        InventoryHolder holder = e.getInventory().getHolder();
        if (holder instanceof Menu) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
                return;
            }

            Menu menu = (Menu) holder;
            menu.handleMenu(e);
        }
    }

    @EventHandler
    public void  onCloseInventory(InventoryCloseEvent e){
        PunsihGUI.getPlayerMenuUtility((Player) e.getPlayer()).setMuteable(false);


    }


}
