package org.dev.punsihgui.MenuSystem.Menus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.dev.punsihgui.MenuSystem.Menu;
import org.dev.punsihgui.MenuSystem.Menus.punishScreens.Ban;
import org.dev.punsihgui.MenuSystem.PlayerMenuUtility;
import org.dev.punsihgui.PunsihGUI;

import java.util.Objects;

public class PunishPicker extends Menu {
    public PunishPicker(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Punish " + playerMenuUtility.getPlayerToPunish().getDisplayName();
    }

    @Override
    public int getSlots() {
        return 27;
    }

    @Override
    public void handleMenu(InventoryClickEvent e) {

        if(Objects.equals(e.getCurrentItem().getType(), Material.WRITABLE_BOOK)) {
            if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Ban")){

                //BAN

                e.getWhoClicked().closeInventory();
                new Ban(PunsihGUI.getPlayerMenuUtility((Player) e.getWhoClicked())).open();

            } else if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Kick")){

                //KICK

                e.getWhoClicked().closeInventory();
                e.getWhoClicked().sendMessage(ChatColor.RED + "Player " + playerMenuUtility.getPlayerToPunish().getDisplayName() + " kicked for " + playerMenuUtility.getReason());

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kick " + playerMenuUtility.getPlayerToPunish().getDisplayName() + " " + playerMenuUtility.getReason());

            } else if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Mute")){

                //MUTE

                e.getWhoClicked().closeInventory();
                e.getWhoClicked().sendMessage(ChatColor.RED + "Player " + playerMenuUtility.getPlayerToPunish().getDisplayName() + " muted for " + playerMenuUtility.getReason());

            } else if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Warn")){

                //WARN
                e.getWhoClicked().closeInventory();
                e.getWhoClicked().sendMessage(ChatColor.RED + "Player " + playerMenuUtility.getPlayerToPunish().getDisplayName() + " warned for " + playerMenuUtility.getReason());

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "warn " + playerMenuUtility.getPlayerToPunish().getDisplayName() + " " + playerMenuUtility.getReason());

            }
        }
    }

    @Override
    public void setMenuItems() {
        ItemStack test = new ItemStack(Material.WRITABLE_BOOK, 1);
        ItemMeta test_meta = test.getItemMeta();
        assert test_meta != null;
        test_meta.setDisplayName(ChatColor.DARK_RED + "Ban");

        ItemStack test2 = new ItemStack(Material.WRITABLE_BOOK, 1);
        ItemMeta test_meta2 = test2.getItemMeta();
        assert test_meta2 != null;
        test_meta2.setDisplayName(ChatColor.DARK_RED + "Kick");

        ItemStack test3 = new ItemStack(Material.WRITABLE_BOOK, 1);
        ItemMeta test_meta3 = test3.getItemMeta();
        assert test_meta3 != null;
        test_meta3.setDisplayName(ChatColor.DARK_RED + "Mute");


        ItemStack test4 = new ItemStack(Material.WRITABLE_BOOK, 1);
        ItemMeta test_meta4 = test4.getItemMeta();
        assert test_meta4 != null;
        test_meta4.setDisplayName(ChatColor.DARK_RED + "Warn");

        ItemStack not = new ItemStack(Material.BARRIER, 1);
        ItemMeta not_meta = not.getItemMeta();
        assert not_meta != null;
        not_meta.setDisplayName(ChatColor.DARK_RED + "You Can't Mute");


        test.setItemMeta(test_meta);
        test2.setItemMeta(test_meta2);
        test3.setItemMeta(test_meta3);
        test4.setItemMeta(test_meta4);
        not.setItemMeta(not_meta);

        inventory.setItem(10, test);
        inventory.setItem(12, test2);

        if(playerMenuUtility.getMuteable()){
            inventory.setItem(14, test3);
        } else {
            inventory.setItem(14, not);
        }

        inventory.setItem(16, test4);

        setFillerGlass();
    }
}
