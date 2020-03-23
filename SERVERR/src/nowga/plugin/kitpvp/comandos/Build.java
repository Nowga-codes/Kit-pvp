package nowga.plugin.kitpvp.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nowga.plugin.kitpvp.Permissions;

public class Build extends nowga.plugin.kitpvp.eventos.Build implements CommandExecutor{

           public static boolean status= true;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(!(sender instanceof Player))return true;
		if(cmd.getName().equalsIgnoreCase("build")) {
			Player p= (Player) sender;
			
			if(status== false) {
				
				p.sendMessage(prefix+"§cO plugin build não esta ativado!");
				return true;
			}
			if(p.hasPermission(Permissions.build)) {
				if(buildStats.contains(p.getName())) {
					p.sendMessage(prefix+ " §7Build off.");
					buildStats.remove(p.getName());
					
					
				}else {
					
					p.sendMessage(prefix+ " §7Build on.");
					buildStats.add(p.getName());
				}
			}else {
				
				p.sendMessage(Permissions.nopermission);
			}
			
		}
		return false;
	}
	
}
