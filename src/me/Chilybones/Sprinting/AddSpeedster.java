package me.Chilybones.Sprinting;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class AddSpeedster  extends Main implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("speedster")) {
			if(args[0].equalsIgnoreCase("add")) {
				
			}
		}
		return true;
	}

}
