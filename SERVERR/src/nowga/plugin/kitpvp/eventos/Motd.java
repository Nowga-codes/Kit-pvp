package nowga.plugin.kitpvp.eventos;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import nowga.plugin.kitpvp.Main;

public class Motd implements Listener{

	@EventHandler
	public void motd(ServerListPingEvent e) {
		
		e.setMaxPlayers(2020);
		
		if(Bukkit.getServer().hasWhitelist()) {
			
			e.setMotd("         §6§l -> "+Main.ServerName+" §fKIT PVP §7(1.8x) §6§l<- \n "+"     §cESTAMOS EM MANUTENÇÃO, VOLTAMOS LOGO...".toLowerCase());
			
			return;
		}
		
		Random r= new Random();
		int number= r.nextInt(3);
		
		if(number == 1) {
		e.setMotd("        §6§l -> "+Main.ServerName+" - §fKIT PVP §7(1.8x) §6§l<- \n §a§lADIQUIRA JÁ SEU VIP§f: http://bit.ly/thundermc");
	
		}else if(number == 2) {
			e.setMotd("        §6§l -> "+Main.ServerName+" - §fKIT PVP §7(1.8x) §6§l<- \n         §a§lVENHA SE DIVERTIR CONOSCO!");
		
			}else if(number == 0) {
			e.setMotd("        §6§l -> "+Main.ServerName+" - §fKIT PVP §7(1.8x) §6§l<- \n            §a§lSERVIDOR EM FASE BETA!");
		
			}else if(number == 3) {
				e.setMotd("        §6§l -> "+Main.ServerName+" - §fKIT PVP §7(1.8x) §6§l<- \n         §a§lDiscord do servidor§f: https://discord.gg/jJTH2cP");
				
					}
	}
	
}
