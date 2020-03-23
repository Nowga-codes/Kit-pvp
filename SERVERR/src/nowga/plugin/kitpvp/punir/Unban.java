package nowga.plugin.kitpvp.punir;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nowga.plugin.kitpvp.Permissions;
import nowga.plugin.kitpvp.conexao.MotodosPunir;

public class Unban extends BanAPI implements CommandExecutor{

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(cmd.getName().equalsIgnoreCase("unban")) {
			Player p= (Player)sender;
			
			if(p.hasPermission(Permissions.BAN)) {
				if(args.length != 1) {
					p.sendMessage(prefix+ "§cUse /unban <Player>");
					return true;
				}
				if(args.length == 1) {
					
					Player target= Bukkit.getPlayerExact(args[0]);
					OfflinePlayer offPlayer = Bukkit.getOfflinePlayer(args[0]);
					
					
					//se o player estiver offline
					if(!(offPlayer.isOnline())){
						
						if(MotodosPunir.hasBanned(offPlayer.getUniqueId().toString())) {
							MotodosPunir.Unban(offPlayer.getUniqueId().toString());
							for(Player pls: Bukkit.getOnlinePlayers()) {
								pls.sendMessage(" \n §7"+offPlayer.getName()+" §cfoi desbanido por §7"+p.getName()+". \n ");
							}
							
						}else {
							p.sendMessage(prefix+"§cEsse jogador não esta banido!");
						}
						return true;
					}
					
					
					
					//se o player estiver online
					if(MotodosPunir.hasBanned(target.getUniqueId().toString())) {
						MotodosPunir.Unban(target.getUniqueId().toString());
						for(Player pls: Bukkit.getOnlinePlayers()) {
							pls.sendMessage(" \n §7"+target.getName()+" §cfoi desbanido por §7"+p.getName()+". \n ");
						}
						
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
