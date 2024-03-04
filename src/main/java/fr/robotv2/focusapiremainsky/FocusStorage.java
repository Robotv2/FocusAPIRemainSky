package fr.robotv2.focusapiremainsky;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class FocusStorage {

    private final Map<UUID, BukkitTask> tasks;

    public FocusStorage() {
        this.tasks = new HashMap<>();
    }

    public boolean isFocus(UUID playerId) {
        return tasks.containsKey(playerId);
    }

    public void startFocus(Player player, Location location) {
        stopFocus(player); // stop if the player is focus.
        final BukkitTask task = FocusTask.runFor(player, location);
        tasks.put(player.getUniqueId(), task);
    }

    public void stopFocus(Player player) {
        if(isFocus(player.getUniqueId())) {
            tasks.remove(player.getUniqueId()).cancel();
        }
    }
}
