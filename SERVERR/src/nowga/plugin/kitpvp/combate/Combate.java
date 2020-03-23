package nowga.plugin.kitpvp.combate;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

import nowga.plugin.kitpvp.Main;
import nowga.plugin.kitpvp.comandos.Admin;
import nowga.plugin.kitpvp.conexao.MetodosWarps;
import nowga.plugin.kitpvp.eventos.PvpProtection;
import nowga.plugin.kitpvp.warps.Warp1V1;
import nowga.plugin.kitpvp.warps.WarpAPI;

public class Combate extends PvpProtection implements Listener{

	public static String prefix= "§c§lCOMBATE:";
	public static HashMap<Player, Player> combate= new HashMap<Player, Player>();
	public static ArrayList<String> renovarCombate= new ArrayList<String>();
    BukkitTask taskAgressor, taskVitima;
	
	
	@EventHandler
	public void aoHitar(EntityDamageByEntityEvent e) {
		
		if(!(e.getEntity() instanceof Player))return;
		if(!(e.getDamager() instanceof Player))return;
		
		Location spawn = new Location(e.getEntity().getWorld(), MetodosWarps.getWarpXYZ("spawn", "x"), MetodosWarps.getWarpXYZ("spawn", "y"), MetodosWarps.getWarpXYZ("spawn", "z"));
		if(e.getEntity().getLocation().distance(spawn)<= 100) {
			
			
			return;
		}
		Player pvitima= (Player) e.getEntity();
		if(WarpAPI.contador1v1.contains(pvitima.getName())||WarpAPI.contador1v1.contains(pvitima.getName())) {
			if(!(Warp1V1.combate1v1.containsKey(pvitima) || Warp1V1.combate1v1.containsKey((Player)e.getDamager()))) {
				return;
			
			}
		}
		
		if(e.getEntity() instanceof Player && e.getDamager()instanceof Player) {
			 Player vitima = (Player) e.getEntity();
				Player agressor= (Player) e.getDamager();
				
				
				if(Admin.adminMode.contains(agressor))return;
			if(combate.containsKey(vitima)) {
				taskVitima.cancel();
				combate.remove(vitima);
				combate.put(vitima, agressor);
				removeCOmbateVitima(vitima);
				
			}else {
				combate.remove(vitima);
				combate.put(vitima, agressor);
				removeCOmbateVitima(vitima);
				vitima.sendMessage(prefix+" §7Você entrou em combate com §c"+agressor.getName());
				
			}
			if(combate.containsKey(agressor)) {
				taskAgressor.cancel();
				combate.remove(agressor);
				combate.put(agressor, vitima);
				removeCOmbateAgressor(agressor);
				
		
			}else {
				combate.put(agressor, vitima);
				removeCOmbateAgressor(agressor);
				agressor.sendMessage(prefix+" §7Você entrou em combate com §c"+vitima.getName());
			}
		}
		
	}
	
	private void removeCOmbateAgressor(Player p) {
		
		taskAgressor= new BukkitRunnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
		
					p.sendMessage(prefix+" §7Você não esta mais em combate!");
					combate.remove(p);
				
			}
		}.runTaskLater(Main.plugin, 20*10);
		
	}
private void removeCOmbateVitima(Player p) {
		
		taskVitima= new BukkitRunnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
		
					p.sendMessage(prefix+" §7Você não esta mais em combate!");
					combate.remove(p);
				
			}
		}.runTaskLater(Main.plugin, 20*10);
		
	}

	public static void commandBlock(AsyncPlayerChatEvent e) {
		Player p= e.getPlayer();
		
		if(e.getMessage().contains("/")) {
			p.sendMessage(prefix+" §7Impossivel usar comandos em batalha!");
		}
	}
	public static void aoSair(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		
		for(Player players: Bukkit.getOnlinePlayers()) {
			players.sendMessage(prefix+" §c"+ p.getName()+" §7Desconectou em combate!");
		}
		
	}
	
}
