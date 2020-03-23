package nowga.plugin.kitpvp.punir;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import nowga.plugin.kitpvp.Main;
import nowga.plugin.kitpvp.conexao.MotodosPunir;

public class BanAPI {

	public static String prefix= "§c§lPUNIR: ";
	
	public static void broadcastBanned(Player p) {
		String motivo = MotodosPunir.getDados(p.getUniqueId().toString(), "motivo");
		String prova = MotodosPunir.getDados(p.getUniqueId().toString(), "prova");
		String autorBan = MotodosPunir.getDados(p.getUniqueId().toString(), "autor");
		
		for(Player pls: Bukkit.getOnlinePlayers()) {
			
			pls.sendMessage(" \n §7"+ p.getName()+" §cfoi banido permanentemente. \n "
					+ "§cAutor da punição:§7 " +autorBan+
					" \n §cMotivo: §7"+ motivo
					+"\n §cProva: §7"+ prova + " \n ");
		}
		}

	
	public static void msgBanned(Player p){
		String motivo = MotodosPunir.getDados(p.getUniqueId().toString(), "motivo");
		String prova = MotodosPunir.getDados(p.getUniqueId().toString(), "prova");
		String autorBan = MotodosPunir.getDados(p.getUniqueId().toString(), "autor");
		
		if(MotodosPunir.hasBanned(p.getUniqueId().toString())) {
			new BukkitRunnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					p.kickPlayer(Main.ServerName+" \n     §cEssa conta foi banida permanentemente. \n "+
					"§cAutor do punimento:§7 "+ autorBan+
							 " \n §cMotivo: §7"+ motivo+
							" \n §cProva: §7"+prova+
							" \n §cFoi banido injustamente? reivindique em nosso grupo do discord:");
				}
			}.runTaskLater(Main.plugin, 1);
		}
		
	}
	public static void msgBannedIp(Player p){
		
		String ip= p.getAddress().getHostString();
		
		String motivo = MotodosPunir.getDadosIP(ip, "motivo");
		String prova = MotodosPunir.getDadosIP(ip, "prova");
		String autorBan = MotodosPunir.getDadosIP(ip, "autor");
		
		if(MotodosPunir.hasBannedIP(ip)) {
			new BukkitRunnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					p.kickPlayer(Main.ServerName+" \n     §cEsse ip foi banido permanentemente. \n "+
					"§cAutor do punimento:§7 "+ autorBan+
							 " \n §cMotivo: §7"+ motivo+
							" \n §cProva: §7"+prova+
							" \n §cFoi banido injustamente? reivindique em nosso grupo do discord:");
				}
			}.runTaskLater(Main.plugin, 1);
		}
		
	}
	
}
