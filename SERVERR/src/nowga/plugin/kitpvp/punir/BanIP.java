package nowga.plugin.kitpvp.punir;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import nowga.plugin.kitpvp.Main;
import nowga.plugin.kitpvp.Permissions;
import nowga.plugin.kitpvp.conexao.MotodosPunir;

public class BanIP extends BanAPI implements CommandExecutor{

	BukkitTask task;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
           if(!(sender instanceof Player))return true;
           if(cmd.getName().equalsIgnoreCase("banip")) {
        	   Player p= (Player)sender;
        	   
        	   if(p.hasPermission(Permissions.BANIP)) {
        	   if(args.length !=3) {
        		p.sendMessage(prefix+ "§cUse /banip <ip> <motivo> <prova>");
        		   return true;
        	   }
        	   String ip= args[0];
        	   String motivo= args[1];
        	   String prova= args[2];
        	   
        	   if(MotodosPunir.hasBannedIP(ip)) {
        		   p.sendMessage(prefix+"§cEsse ip ja esta banido!");
        		  
        	    }else {
        	    	
        	    	 MotodosPunir.setBannedIP(ip, p.getName(), motivo, prova);
       
        	    	 
        	    	 Bukkit.broadcastMessage(" \n §ao ip de §7"+ip+" §afoi banido. \n");
        	    	 
							
							for(Player all: Bukkit.getOnlinePlayers()) {
	        	    			
								
								if(all.getAddress().getHostString().equals(ip)) {
									
									Bukkit.broadcastMessage(" \n §co ip de §7"+all.getName()+"§c foi banido. \n "
	    									+ "§cAutor da punição:§7 " +p.getName()+
	    									" \n §cMotivo:§7 "+ motivo
	    									+"\n §cProva:§7 "+ prova + " \n ");
									
									new BukkitRunnable() {
										
										@Override
										public void run() {
											// TODO Auto-generated method stub
											all.kickPlayer(Main.ServerName+" \n     §cEsse Ip foi banido permanentemente. \n "+
													"§cAutor do punimento:§7 "+ p.getName()+
															 " \n §cMotivo: §7"+ motivo+
															" \n §cProva: §7"+prova+
															" \n §cFoi banido injustamente? reivindique em nosso grupo do discord:");
		
										}
									}.runTaskLater(Main.plugin, 10);
									
									
								}
	        					
	        				}
							
						
			
        	    
        			
        	    	
        	    	/*/
        	    	 *  MotodosPunir.setBannedIP(ip, p.getName(), motivo, prova);
        	   broadcastBanned(p);
        	    
        	   for(Player players: Bukkit.getOnlinePlayers()) {
        		   if(players.getAddress().getHostString().equals(ip)) {
        			   msgBannedIp(players);
        		   
        	   }
        	   
        	   }
        	    	 */
        	   //se não estiver banido
        	    }
        	 
        	   }else {
        		   p.sendMessage(Permissions.nopermission);
        	   }
           }
           return false;
	}
	
}
