package org.dev.punsihgui.MenuSystem.Menus.punishScreens;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.dev.punsihgui.MenuSystem.Menu;
import org.dev.punsihgui.MenuSystem.PlayerMenuUtility;

import java.util.Objects;

public class Ban extends Menu {
    public Ban(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Ban " + playerMenuUtility.getPlayerToPunish().getDisplayName();
    }

    @Override
    public int getSlots() {
        return 27;
    }

    @Override
    public void handleMenu(InventoryClickEvent e) {

        if(Objects.equals(e.getCurrentItem().getType(), Material.BOOK)) {
            if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("1 Day Ban")){

                e.getWhoClicked().closeInventory();
                e.getWhoClicked().sendMessage(ChatColor.RED + "Player " + playerMenuUtility.getPlayerToPunish().getDisplayName() + " is 1 day banned for " + playerMenuUtility.getReason());

            } else if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("7 Days Ban")){

                e.getWhoClicked().closeInventory();
                e.getWhoClicked().sendMessage(ChatColor.RED + "Player " + playerMenuUtility.getPlayerToPunish().getDisplayName() + " is 7 days banned for " + playerMenuUtility.getReason());

            } else if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("30 Days Ban")){

                e.getWhoClicked().closeInventory();
                e.getWhoClicked().sendMessage(ChatColor.RED + "Player " + playerMenuUtility.getPlayerToPunish().getDisplayName() + " is 30 days banned for " + playerMenuUtility.getReason());

            } else if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Permanent Ban")){

                e.getWhoClicked().closeInventory();
                e.getWhoClicked().sendMessage(ChatColor.RED + "Player " + playerMenuUtility.getPlayerToPunish().getDisplayName() + " is permanent Banned for " + playerMenuUtility.getReason());

            }
        }
    }

    @Override
    public void setMenuItems() {

        ItemStack test = new ItemStack(Material.BOOK, 1);
        ItemMeta test_meta = test.getItemMeta();
        assert test_meta != null;
        test_meta.setDisplayName(ChatColor.DARK_RED + "1 Day Ban");

        ItemStack test2 = new ItemStack(Material.BOOK, 1);
        ItemMeta test_meta2 = test2.getItemMeta();
        assert test_meta2 != null;
        test_meta2.setDisplayName(ChatColor.DARK_RED + "7 Days Ban");

        ItemStack test3 = new ItemStack(Material.BOOK, 1);
        ItemMeta test_meta3 = test3.getItemMeta();
        assert test_meta3 != null;
        test_meta3.setDisplayName(ChatColor.DARK_RED + "30 Days Ban");

        ItemStack test4 = new ItemStack(Material.BOOK, 1);
        ItemMeta test_meta4 = test4.getItemMeta();
        assert test_meta4 != null;
        test_meta4.setDisplayName(ChatColor.DARK_RED + "Permanent Ban");


        test.setItemMeta(test_meta);
        test2.setItemMeta(test_meta2);
        test3.setItemMeta(test_meta3);
        test4.setItemMeta(test_meta4);

        inventory.setItem(10, test);
        inventory.setItem(12, test2);
        inventory.setItem(14, test3);
        inventory.setItem(16, test4);

        setFillerGlass();

    }
}
