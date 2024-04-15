package org.dev.punsihgui.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.dev.punsihgui.MenuSystem.Menus.ReasonPicker;
import org.dev.punsihgui.PunsihGUI;

public class PlayerClickEntityEvent implements Listener {

    @EventHandler
    public void onPlayerInteractWithPlayer(PlayerInteractEntityEvent event) {
        if (event.getPlayer().isSneaking()) {
            if (event.getRightClicked() instanceof Player) {
                Player clickedPlayer = (Player) event.getRightClicked();
                Player player = event.getPlayer();

                if(player.hasPermission("swampmc.punish") || player.isOp()){
                    PunsihGUI.getPlayerMenuUtility(player).setPlayerToPunish(clickedPlayer);
                    new ReasonPicker(PunsihGUI.getPlayerMenuUtility(player)).open();
                } else {
                    player.sendMessage(ChatColor.RED + "You don't have permissions to execute this command.");
                }

            }
        }
    }
}
