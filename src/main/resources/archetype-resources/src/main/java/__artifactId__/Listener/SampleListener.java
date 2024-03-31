#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import ${package}.${artifactId}.${mainClass};

public class SampleListener implements Listener {

    @EventHandler
    public void onSampleEvent(PlayerJoinEvent e) {
        ${mainClass}.getInstance().getLogger().info("Player " + e.getPlayer().getName() + " joined the game!");
    }
}
