package org.LSN.GUI;

import org.LSN.Main.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
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
			Inv.setItem(36, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
			Inv.setItem(44, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
			Inv.setItem(45, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
			Inv.setItem(46, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
			Inv.setItem(52, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
			Inv.setItem(53, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
		}
	}
}