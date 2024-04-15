package org.dev.punsihgui.MenuSystem.Menus;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.dev.punsihgui.MenuSystem.PaginatedMenu;
import org.dev.punsihgui.MenuSystem.PlayerMenuUtility;
import org.dev.punsihgui.PunsihGUI;

import java.util.ArrayList;
import java.util.Objects;

public class ReasonPicker extends PaginatedMenu {
    public ReasonPicker(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    private ArrayList<String> Reasons = new ArrayList<String>();

    private void setupReasons(){
        this.Reasons.add("#1 Use Hacks Or Mods");
        this.Reasons.add("#2 Wearing In The Chat");
    }

    @Override
    public String getMenuName() {
        return "Punish " + playerMenuUtility.getPlayerToPunish().getDisplayName();
    }

    @Override
    public int getSlots() {
        return 54;
    }

    @Override
    public void handleMenu(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();

        if (e.getCurrentItem().getType().equals(Material.PAPER)) {

            PlayerMenuUtility playerMenuUtility = PunsihGUI.getPlayerMenuUtility(p);
            playerMenuUtility.setReason(Objects.requireNonNull(e.getCurrentItem().getItemMeta()).getDisplayName().toString());

            if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_RED + "#2 Wearing In The Chat")){
                playerMenuUtility.setMuteable(true);
            }

            new PunishPicker(PunsihGUI.getPlayerMenuUtility((Player) e.getWhoClicked())).open();

        }
        else if (e.getCurrentItem().getType().equals(Material.BARRIER)) {
            p.closeInventory();
        }
        else if(e.getCurrentItem().getType().equals(Material.DARK_OAK_BUTTON)){

            if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Left")){

                if (page == 0){
                    p.sendMessage(ChatColor.GRAY + "You are already on the first page.");
                }
                else{
                    page = page - 1;
                    super.open();
                }

            }
            else if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Right")){

                if (!((index + 1) >= this.Reasons.size())){
                    page = page + 1;
                    super.open();
                }else{
                    p.sendMessage(ChatColor.GRAY + "You are on the last page.");
                }

            }
        }
    }

    @Override
    public void setMenuItems() {

        addMenuBorder();
        setupReasons();

        if(this.Reasons != null) {
            for(int i = 0; i < getMaxItemsPerPage(); i++) {
                index = getMaxItemsPerPage() * page + i;
                if(index >= this.Reasons.size()) break;
                if (this.Reasons.get(index) != null){

                    ItemStack test = new ItemStack(Material.PAPER, 1);
                    ItemMeta test_meta = test.getItemMeta();

                    assert test_meta != null;
                    test_meta.setDisplayName(ChatColor.DARK_RED + this.Reasons.get(index));
                    test.setItemMeta(test_meta);

                    inventory.addItem(test);
                }
            }
        }

    }
}
