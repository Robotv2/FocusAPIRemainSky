package fr.robotv2.focusapiremainsky;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public final class FocusAPIRemainSky {

    private final static FocusStorage FOCUS_STORAGE = new FocusStorage();

    private FocusAPIRemainSky() {
        throw new AssertionError();
    }

    public static boolean isFocus(Player player) {
        return FOCUS_STORAGE.isFocus(player.getUniqueId());
    }

    public static void startFocus(Player player, Location location) {
        FOCUS_STORAGE.startFocus(player, location);
    }

    public static void stopFocus(Player player) {
        FOCUS_STORAGE.stopFocus(player);
    }
}
