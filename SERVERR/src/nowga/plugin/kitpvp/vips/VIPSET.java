package nowga.plugin.kitpvp.vips;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.connorlinfoot.titleapi.TitleAPI;

import nowga.plugin.kitpvp.Permissions;

public class VIPSET extends VipAPI implements CommandExecutor{


	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(!(sender instanceof Player))return true;
		if(cmd.getName().equalsIgnoreCase("vipset")) {
			
			Player p= (Player)sender;
			if(p.isOp()) {
			if(args.length != 2) {
				p.sendMessage("§cUse: /vipset <player> <vip>");
				return true;
			}
			String target= args[0];
			if(args[1].equalsIgnoreCase("beta")) {
				
				
				
				
				
				
			}
			
			}else {
				p.sendMessage("§cApenas ops podem executar essa ação!");
			}
		}
		return false;
	}
	
}
