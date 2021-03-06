package org.LSN.GUI;

import java.util.ArrayList;
import org.LSN.Main.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class Gadgets implements Listener {
	public static ArrayList<Player> eh = new ArrayList<>();
	public static ArrayList<Player> speed = new ArrayList<>();
	public static ArrayList<Player> fly = new ArrayList<>();
	public static ArrayList<Player> jp = new ArrayList<>();
	public static ArrayList<Player> dj = new ArrayList<>();

	@EventHandler
	public void interact(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType().equals(Material.CHEST)
				&& p.getItemInHand().getItemMeta().getDisplayName().contains("§6§lGadgets")) {
			Inventory Inv = Bukkit.createInventory((InventoryHolder) p, 45, "");
			for (int i = 0; i < Inv.getSize(); i++)
				Inv.setItem(i, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 15, " "));
			Inv.setItem(0, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
			Inv.setItem(1, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
			Inv.setItem(7, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
			Inv.setItem(8, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
			Inv.setItem(9, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
			Inv.setItem(17, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
			Inv.setItem(27, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
			Inv.setItem(35, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
			Inv.setItem(36, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
			Inv.setItem(37, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
			Inv.setItem(43, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
			Inv.setItem(44, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, " "));
			Inv.setItem(22, Utils.createItem(Material.FISHING_ROD, 1, 0, "§5§lEnterhaken"));
			Inv.setItem(23, Utils.createItem(Material.FEATHER, 1, 0, "§b§lFliegen"));
			Inv.setItem(21, Utils.createItem(Material.IRON_PLATE, 1, 0, "§a§lJumpPads"));
			Inv.setItem(40, Utils.createItem(Material.BARRIER, 1, 0, "§cInventar schließen"));
			p.openInventory(Inv);
		}
	}

	@EventHandler
	public void clickEvent(InventoryClickEvent e) {
		Player p = null;
		if (e.getWhoClicked() instanceof Player)
			p = (Player) e.getWhoClicked();
		if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§cInventar schließen")) {
			p.getOpenInventory().close();
		} else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§5§lEnterhaken")) {
			if (eh.contains(p)) {
				p.sendMessage(String.valueOf(Utils.prefix) + "§5Enterhaken §cdeaktiviert");
				eh.remove(p);
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);
				p.getInventory().setItem(3, Utils.createItem(Material.BLAZE_ROD, 1, 0, "§6§lPlayerhider"));
				p.getInventory().setItem(5, Utils.createItem(Material.CHEST, 1, 0, "§6§lGadgets"));
				p.closeInventory();
			} else {
				eh.add(p);
				p.sendMessage(String.valueOf(Utils.prefix) + "§5Enterhaken §aaktiviert");
				p.getInventory().setItem(2, Utils.createItem(Material.FISHING_ROD, 1, 0, "§5§lEnterhaken"));
				p.closeInventory();
			}
		} else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§b§lFliegen")) {
			if (fly.contains(p)) {
				p.setAllowFlight(false);
				p.setFlying(false);
				fly.remove(p);
				p.sendMessage(String.valueOf(Utils.prefix) + "§bFliegen §cdeaktiviert");
				p.closeInventory();
			} else {
				p.setAllowFlight(true);
				p.setFlying(true);
				fly.add(p);
				p.sendMessage(String.valueOf(Utils.prefix) + "§bFliegen §aaktiviert");
				p.closeInventory();
			}
		} else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a§lJumpPads")) {
			if (jp.contains(p)) {
				jp.remove(p);
				p.closeInventory();
				p.sendMessage(String.valueOf(Utils.prefix) + "§aJumpPads §cdeaktiviert");
			} else {
				jp.add(p);
				p.closeInventory();
				p.sendMessage(String.valueOf(Utils.prefix) + "§aJumpPads §aaktiviert");
			}
		} else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a§lDoubleJump")) {
			if (dj.contains(p)) {
				dj.remove(p);
				p.closeInventory();
				p.sendMessage(String.valueOf(Utils.prefix) + "§aDoubleJump §cdeaktiviert!");
			} else {
				dj.add(p);
				p.closeInventory();
				p.sendMessage(String.valueOf(Utils.prefix) + "§aDoubleJump §aaktiviert!");
			}
		}
		e.setCancelled(true);
	}
}
