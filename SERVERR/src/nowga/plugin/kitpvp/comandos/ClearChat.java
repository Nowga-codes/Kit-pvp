package nowga.plugin.kitpvp.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nowga.plugin.kitpvp.Permissions;

public class ClearChat implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] arg3) {
		if(!(sender instanceof Player))return true;
		if(cmd.getName().equalsIgnoreCase("cc")) {
			Player p= (Player) sender;
			
			if(p.hasPermission(Permissions.CLEARCHAT)) {
				
				for(Player all: Bukkit.getOnlinePlayers()) {
					for(int i=0; i<=100; i++) {
						
						all.sendMessage("");
					}
					all.sendMessage("§a Chat foi limpo por§7: "+p.getName()+". \n ");
				}
				
			}else {
				p.sendMessage(Permissions.nopermission);
			}
			
		}
		return false;
	}
	
}
