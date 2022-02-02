package org.LSN.Main;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Utils implements Listener {
	public static ItemStack createItem(Material mat, int anzahl, int shortid, String Name) {
		short s = (short) shortid;
		ItemStack i = new ItemStack(mat, anzahl, s);
		ItemMeta meta = i.getItemMeta();
		meta.setDisplayName(Name);
		i.setItemMeta(meta);
		return i;
	}

	@EventHandler
	public void onHunger(FoodLevelChangeEvent e) {
		e.setCancelled(true);
		e.setFoodLevel(20);
	}

	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		if (e.getEntity() instanceof org.bukkit.entity.Player)
			e.setCancelled(true);
	}

	@EventHandler
	public void onWeatherChange(WeatherChangeEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public void onDrag(InventoryDragEvent e) {
		e.setCancelled(true);
	}

	public static String prefix = "§c§lLobby ";
}
