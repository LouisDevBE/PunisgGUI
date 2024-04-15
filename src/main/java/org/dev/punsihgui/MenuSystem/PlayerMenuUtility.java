package org.dev.punsihgui.MenuSystem;

import org.bukkit.entity.Player;

public class PlayerMenuUtility {

    private final Player owner;
    private Player playerToPunish;
    private String reason;
    private Boolean isMuteable = false;

    public PlayerMenuUtility(Player p) {
        this.owner = p;
    }

    public Player getOwner() {
        return owner;
    }

    public Player getPlayerToPunish() {
        return playerToPunish;
    }

    public String getReason(){
        return reason;
    }

    public void setPlayerToPunish(Player playerToKill) {
        this.playerToPunish = playerToKill;
    }

    public void setReason(String reason){
        this.reason = reason;
    }

    public Boolean getMuteable() {
        return isMuteable;
    }

    public void setMuteable(Boolean muteable) {
        isMuteable = muteable;
    }
}

