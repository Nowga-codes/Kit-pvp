package nowga.plugin.kitpvp.eventos;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import nowga.plugin.kitpvp.Main;

public class AntiRelog {

	public static ArrayList<String> relog= new ArrayList<String>();
	
	public static void onJoinRelog(PlayerJoinEvent e) {
		Player p= e.getPlayer();
		
		if(relog.contains(p.getName())) {
			
			e.setJoinMessage(null);
			new BukkitRunnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					p.kickPlayer("§aAguarde um pouco para relogar!");
				}
			}.runTaskLater(Main.plugin, 12);
			return;
		}
		
	}
	public static void onQuitRelog(PlayerQuitEvent e) {
		Player p= e.getPlayer();
		
		if(relog.contains(p.getName())) {
			e.setQuitMessage(null);
			return;
		}
		relog.add(p.getName());
		
		new BukkitRunnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				relog.remove(p.getName());
			}
		}.runTaskLater(Main.plugin, 20*10);
		
	}
	
}
