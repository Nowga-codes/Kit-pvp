package nowga.plugin.kitpvp.punir;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import nowga.plugin.kitpvp.Main;
import nowga.plugin.kitpvp.Permissions;
import nowga.plugin.kitpvp.conexao.MetodosMySql;

public class GetIP extends BanAPI implements CommandExecutor{
     
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {

		 if(!(sender instanceof Player))return true;
	     if(cmd.getName().equalsIgnoreCase("ip")) {
	  	   Player p= (Player)sender;
	  	   
	  	   if(p.hasPermission(Permissions.IP)) {
	  	   if(args.length !=1) {
	  		p.sendMessage(prefix+ "§cUse /ip <player>");
	  	   
	  		   return true;
	  	   }
	  	   

	  	   Player target= Bukkit.getPlayerExact(args[0]);
	  	   @SuppressWarnings("deprecation")
		OfflinePlayer offPlayer= Bukkit.getOfflinePlayer(args[0]);
			
		if(!(offPlayer.isOnline())){
			
			if(MetodosMySql.containsPlayerOFF(offPlayer)) {
		  		   String ip = MetodosMySql.getIPOff(offPlayer);
		  		   p.sendMessage(prefix+"§cIp do jogador §7"+ offPlayer.getName()+": "+ ip );
		  	   }else {
		  		   p.sendMessage("§c§lERRO: §cEsse player não consta no banco de dados.");
		  	   }
			
			
			return true;
		}
				
				 if(MetodosMySql.containsPlayers(target)) {
			  		   String ip = MetodosMySql.getIP(target);
			  		   p.sendMessage(prefix+"§cIp do jogador §7"+ target.getName()+": "+ ip );
			  	   }else {
			  		   p.sendMessage("§c§lERRO: §cEsse player não consta no banco de dados.");
			  	   }
					
	  	   
	  	   
	  	   }
	     
	     return false;

}
		return false;
	}
	
}
