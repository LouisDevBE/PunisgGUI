package org.dev.punsihgui.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.dev.punsihgui.MenuSystem.Menus.ReasonPicker;
import org.dev.punsihgui.PunsihGUI;

public class Punish implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {

            Player p = (Player) commandSender;

            // Controleer of er ten minste één argument is meegegeven met het commando
            if (strings.length > 0) {
                Player target = PunsihGUI.getPlugin().getServer().getPlayer(strings[0]); // Gebruik strings[0] voor het eerste argument
                if(target != null){
                    if(p.hasPermission("swampmc.punish") || p.isOp()){
                        PunsihGUI.getPlayerMenuUtility(p).setPlayerToPunish(target);
                        new ReasonPicker(PunsihGUI.getPlayerMenuUtility(p)).open();
                    } else {
                        p.sendMessage(ChatColor.RED + "You don't have permissions to execute this command.");
                    }
                } else {
                    p.sendMessage(ChatColor.RED + "Player not found!");
                }
            } else {
                // Geen argumenten meegegeven, stuur een foutmelding
                p.sendMessage(ChatColor.RED + "Usage: /punish <playerName>");
            }
        }

        return true;
    }
}
