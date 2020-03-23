package nowga.plugin.kitpvp.punir;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nowga.plugin.kitpvp.Permissions;
import nowga.plugin.kitpvp.conexao.MotodosPunir;

public class UnbanIP extends BanAPI implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(cmd.getName().equalsIgnoreCase("unbanip")) {
			Player p= (Player)sender;
			
			if(p.hasPermission(Permissions.BANIP)) {
				if(args.length != 1) {
					p.sendMessage(prefix+ "§cUse /unbanip <ip>");
					return true;
				}
				if(args.length == 1) {
					
					String ip= args[0];
					
					if(MotodosPunir.hasBannedIP(ip)) {
						MotodosPunir.UnbanIP(ip);
				
							p.sendMessage(prefix+ "§aIp §7"+ ip+" §aFoi desbanido!");
							Bukkit.getConsoleSender().sendMessage(" \n          "+prefix+ "§aIp §7"+ ip+" §aFoi desbanido por §7"+ p.getName()+". \n ");
						
						
					}else {
						p.sendMessage(prefix+"§cEsse jogador não esta banido!");
					}
					
				}
					
					
					
					
			}else {
				p.sendMessage(Permissions.nopermission);
			}
			
		}
		return false;
	}
	
}
