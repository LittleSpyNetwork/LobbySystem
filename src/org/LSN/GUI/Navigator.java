package org.LSN.GUI;

import org.LSN.Main.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class Navigator implements Listener {
	@EventHandler
	public void interact(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType().equals(Material.COMPASS)
				&& p.getItemInHand().getItemMeta().getDisplayName().contains("Navigator")) {
			Inventory Inv = Bukkit.createInventory((InventoryHolder) p, 54, "§b§lNavigator");
			p.openInventory(Inv);
			for (int i = 0; i < Inv.getSize(); i++)
				Inv.setItem(i, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 15, " "));
			Inv.setItem(0, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
			Inv.setItem(1, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
			Inv.setItem(7, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
			Inv.setItem(8, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
			Inv.setItem(9, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
			Inv.setItem(17, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
			Inv.setItem(21, Utils.createItem(Material.IRON_PICKAXE, 1, 0, "§6CityBuild"));
			Inv.setItem(22, Utils.createItem(Material.GOLDEN_APPLE, 1, 0, "§6Spawn"));
			Inv.setItem(23, Utils.createItem(Material.GRASS, 1, 0, "§2FreeBuild"));
			Inv.setItem(36, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
			Inv.setItem(44, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
			Inv.setItem(45, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
			Inv.setItem(46, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
			Inv.setItem(49, Utils.createItem(Material.BARRIER, 1, 0, "§cInventar schließen"));
			Inv.setItem(52, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
			Inv.setItem(53, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
		}
	}

	@EventHandler
	public void warpMenu(InventoryClickEvent e) {
		HumanEntity p = e.getWhoClicked();
		if (e.getInventory().getTitle().contains("Men")) {
			if (e.getSlot() == 21) {
				Location loc = new Location(Bukkit.getWorld("lobyy"), 139.5D, 132D, 577.5D);
				p.teleport(loc);
				p.closeInventory();
			}
			if (e.getSlot() == 22) {
				Location loc = new Location(Bukkit.getWorld("lobyy"), 139.5D, 133D, 635.5D);
				p.teleport(loc);
				p.closeInventory();
			}
			if (e.getSlot() == 23) {
				Location loc = new Location(Bukkit.getWorld("lobyy"), 197.5D, 132D, 635.5D);
				loc.setYaw(90.0F);
				p.teleport(loc);
				p.closeInventory();
			}
			if (e.getSlot() == 49)
				p.closeInventory();
			e.setCancelled(true);
		}
	}

}