package me.Chilybones.Sprinting;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	FileConfiguration config = this.getConfig();
	
	public void onEnable() {
		config.addDefault("enableSpeedster", true);
		config.options().copyDefaults(true);
		saveConfig();
		
		if(config.getBoolean("enableSpeedster")) {
			getServer().getPluginManager().registerEvents(new SprintEvent(), this);
		}
		
	}
	
	public void onDisable() {
		
	}

}
