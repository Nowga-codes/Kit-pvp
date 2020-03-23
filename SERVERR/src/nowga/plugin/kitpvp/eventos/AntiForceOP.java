package nowga.plugin.kitpvp.eventos;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import nowga.plugin.kitpvp.Main;

public class AntiForceOP implements Listener{

	static boolean status= true; 
	
	@EventHandler
	public void onJoinAntiForceOP(PlayerJoinEvent e) {
		Player p= e.getPlayer();
		
		if(status == false)return;
		if(p.isOp()) {
			if(!(p.getName().equals("Nowga") ||p.getName().equals("RyderPvP") || p.getName().equals("Rasen"))) {
				
				new BukkitRunnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						p.sendMessage("§cSeu OP foi retirado!");
						Bukkit.getConsoleSender().getServer().dispatchCommand(Bukkit.getConsoleSender(), "deop "+p.getName());
					}
				}.runTaskLater(Main.plugin, 15);
			}
		}
		
		
	}

	@EventHandler
	public void aoDarComando(PlayerCommandPreprocessEvent e) {
		Player p= e.getPlayer();
		
		if(p.isOp()) {
			if(!(p.getName().equals("Nowga") ||p.getName().equals("RyderPvP") || p.getName().equals("Rasen"))) {
				
				if(e.getMessage().contains("/")) {
			e.setCancelled(true);
			Bukkit.getConsoleSender().getServer().dispatchCommand(Bukkit.getConsoleSender(), "deop "+p.getName());
				p.sendMessage("§cOp retirado, Você não tem permissão para ser OP!");
				
				}
			}
			
			}
		
	}
	
}
