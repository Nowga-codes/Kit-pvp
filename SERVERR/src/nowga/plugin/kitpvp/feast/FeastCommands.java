package nowga.plugin.kitpvp.feast;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nowga.plugin.kitpvp.Config;

public class FeastCommands implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(!(sender instanceof Player))return true;
		if(cmd.getName().equalsIgnoreCase("setfeast")) {
			
			Player p= (Player)sender;
			
			if(args.length == 2) {
				if(args[0].equals("bau")) {
					
					//são 10 baus no total
					int numerobau= Integer.parseInt(args[1]);
					
					if(p.getItemOnCursor().getType() == Material.CHEST) {
						
				
						
					}else {
						p.sendMessage("§cMire para o bau que deseja setar.");
					}
					
				}
			}
			
			
		}
		return false;
	}
	
}
