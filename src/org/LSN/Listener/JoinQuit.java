package org.LSN.Listener;

import org.LSN.Main.Utils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinQuit implements Listener {
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.setJoinMessage("§8[§a+§8] §8" + p.getDisplayName());
		p.setGameMode(GameMode.ADVENTURE);
		p.getInventory().clear();
		p.getInventory().setItem(3, Utils.createItem(Material.BLAZE_ROD, 1, 0, "§6§lPlayerhider"));
//		p.getInventory().setItem(4, Utils.createItem(Material.COMPASS, 1, 0, "§6§lNavigator"));
		p.getInventory().setItem(5, Utils.createItem(Material.CHEST, 1, 0, "§6§lGadgets"));
		Location loc = new Location(Bukkit.getWorld("lobbymap"), 139.5D, 133D, 635.5D);
		p.teleport(loc);
		loc.setYaw(-180.0F);
		p.setHealth(20.0D);
		p.setFoodLevel(20);
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		e.setQuitMessage("§8[§c-§8] §8" + p.getDisplayName());
	}
}
