package org.dev.punsihgui.Utils;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.entity.Player;
import org.dev.punsihgui.PunsihGUI;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class SendLitebansBungeeCommand {

    public void sendBungeeCommand(Player player, String command, PunsihGUI instance) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Forward"); // Het subchannel
        out.writeUTF("ALL"); // De server waarop het commando moet worden uitgevoerd, "ALL" voor alle servers
        out.writeUTF("MyPluginSubChannel"); // Een custom subchannel voor jouw plugin

        // Bericht dat je wilt versturen
        ByteArrayOutputStream msgBytes = new ByteArrayOutputStream();
        DataOutputStream msgOut = new DataOutputStream(msgBytes);
        try {
            msgOut.writeUTF(command);
        } catch (IOException e) {
            e.printStackTrace();
        }

        out.writeShort(msgBytes.toByteArray().length);
        out.write(msgBytes.toByteArray());

        player.sendPluginMessage(instance, "BungeeCord", out.toByteArray());
    }

}
