package nowga.plugin.kitpvp.punir;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nowga.plugin.kitpvp.Permissions;
import nowga.plugin.kitpvp.conexao.MotodosPunir;

public class Ban extends BanAPI implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
           if(!(sender instanceof Player))return true;
           if(cmd.getName().equalsIgnoreCase("ban")) {
        	   Player p= (Player)sender;
        	        	   
        	   if(p.hasPermission(Permissions.BAN)) {
        	   if(args.length !=3) {
        		p.sendMessage(prefix+ "§cUse /ban <player> <motivo> <prova>");
        		   return true;
        	   }
        	   
        	   
        	   if(args.length==3) {
        	   Player banido = Bukkit.getPlayerExact(args[0]);
        	   String motivo= args[1];
        	   String prova= args[2];
        	   
        	   
        	   //se o player estiver offline
        		@SuppressWarnings("deprecation")
				OfflinePlayer offPlayer = Bukkit.getOfflinePlayer(args[0]);
    			if(!(offPlayer.isOnline())) {
    				 if(MotodosPunir.hasBanned(offPlayer.getUniqueId().toString())) {
    					   p.sendMessage(prefix+"§cEsse jogador ja esta banido!");
    				 }else {
    					  MotodosPunir.setBanned(offPlayer.getUniqueId().toString(), offPlayer.getName(), p.getName(), motivo, prova);
    					  
    					  for(Player pls: Bukkit.getOnlinePlayers()) {
    							
    							pls.sendMessage(" \n §7"+ offPlayer.getName()+" §cfoi banido permanentemente. \n "
    									+ "§cAutor da punição:§7 " +p.getName()+
    									" \n §cMotivo:§7 "+ motivo
    									+"\n §cProva:§7 "+ prova + " \n ");
    						}
       	        
    				 }
    				 return true;
    			}
    			
    			
    			
    			
    			
    			  //se o player estiver online
        	   if(MotodosPunir.hasBanned(banido.getUniqueId().toString())) {
        		   p.sendMessage(prefix+"§cEsse jogador ja esta banido!");
        		  
        	    }else {
        	    	
        	    	
        	   //se não estiver banido
        	   MotodosPunir.setBanned(banido.getUniqueId().toString(), banido.getName(), p.getName(), motivo, prova);
        	   broadcastBanned(banido);
        	    }
        	   for(Player players: Bukkit.getOnlinePlayers()) {
        		   if(players.getName().equals(banido.getName())) {
        			   msgBanned(players);
        		   }
        	   }
        	   
        	   }
        	   }else {
                    p.sendMessage(Permissions.nopermission);
        	   }
           }
		return false;
	}
	
}
