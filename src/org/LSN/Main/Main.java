package org.LSN.Main;

import org.LSN.GUI.Gadgets;
import org.LSN.GUI.PlayerHider;
import org.LSN.Gadgets.Enterhaken;
import org.LSN.Gadgets.JumpPads;
import org.LSN.Listener.JoinQuit;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	public void onEnable() {
		System.out.println("System aktiviert!");
		init();
	}

	public void onDisable() {
		System.out.println("System deaktiviert!");
	}

	private void init() {
		Bukkit.getPluginManager().registerEvents((Listener) new JoinQuit(), (Plugin) this);
		Bukkit.getPluginManager().registerEvents((Listener) new JumpPads(), (Plugin) this);
		Bukkit.getPluginManager().registerEvents(new Utils(), (Plugin) this);
		Bukkit.getPluginManager().registerEvents((Listener) new Gadgets(), (Plugin) this);
		Bukkit.getPluginManager().registerEvents((Listener) new Enterhaken(), (Plugin) this);
		Bukkit.getPluginManager().registerEvents((Listener) new PlayerHider(), (Plugin) this);
		Bukkit.getPluginManager().registerEvents((Listener) new JumpPads(), (Plugin) this);
	}
}
