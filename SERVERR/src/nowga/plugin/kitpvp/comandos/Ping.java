package nowga.plugin.kitpvp.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Ping implements CommandExecutor{

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(!(sender instanceof Player))return true;
		if(cmd.getName().equalsIgnoreCase("ping")) {
			
			Player p= (Player)sender;
			
			
		
			if(args.length> 1) {
				p.sendMessage("§cUse:/ping <player>");
				return true;
			}
			
			
			if(args.length == 0) {
				   int playerping = ((CraftPlayer) p).getHandle().ping;
				p.sendMessage("§aPing§7: "+ playerping+"ms");
				return true;
			}
			
	if(args.length == 1) {
				
		String target= args[0];
		

			if(Bukkit.getOnlinePlayers().contains(target)) {
				
			Player targetp= Bukkit.getPlayerExact(args[0]);
			
			   int playerping = ((CraftPlayer) targetp).getHandle().ping;
			   
			   p.sendMessage("§aPing "+target+"§7: "+ playerping+"ms");
        
			}else {
				p.sendMessage("§cEsse jogador não esta online!");
			
		}
		
			}
			
			
		}
		return false;
	}
	
}
