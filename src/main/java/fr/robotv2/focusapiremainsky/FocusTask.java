package fr.robotv2.focusapiremainsky;

import io.papermc.paper.entity.LookAnchor;
import io.papermc.paper.math.Position;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.UUID;

public class FocusTask extends BukkitRunnable {

    private final UUID playerId;
    private final Location location;

    public static BukkitTask runFor(Player player, Location location) {
        return new FocusTask(player, location).runTaskTimer(
                JavaPlugin.getProvidingPlugin(FocusAPIRemainSky.class),
                20L,
                20L
        );
    }

    public FocusTask(Player player, Location location) {
        this.playerId = player.getUniqueId();
        this.location = location;
    }

    @Override
    public void run() {

        final Player player;

        if(playerId == null ||
                (player = Bukkit.getPlayer(playerId)) == null || !player.isOnline()) {
            cancel();
            return;
        }

        player.lookAt(
                Position.block(location),
                LookAnchor.EYES
        );
    }
}
