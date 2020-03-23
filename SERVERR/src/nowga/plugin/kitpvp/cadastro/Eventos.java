package nowga.plugin.kitpvp.cadastro;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import com.connorlinfoot.titleapi.TitleAPI;

import nowga.plugin.kitpvp.Main;
import nowga.plugin.kitpvp.conexao.MetodosLogin;
import nowga.plugin.kitpvp.conexao.MetodosWarps;

public class Eventos {
     
	public static boolean status= true;
	public static String prefix= "§c§lLOGIN";
    public static ArrayList<String> unlogged= new ArrayList<String>();

	
	@SuppressWarnings("deprecation")
	public static void playerjoinLogin(Player p) {
		
           unlogged.add(p.getName());
		
		if(status == false) {

			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					Login.autenticado(p);
					p.sendMessage(" \n"+prefix+" §7Sistema de login esta desativado! \n ");
				}
			},20);
			
			
		}else {
		if(MetodosLogin.containsPlayers(p)) {
		TitleAPI.sendFullTitle(p, 10, 20*15, 10, Main.ServerName, "§fUse /login senha");
		p.sendMessage(prefix+ " §7Use /login senha.");
		}else {
			TitleAPI.sendFullTitle(p, 10, 20*15, 10, Main.ServerName, "§fUse /register senha senha");
			p.sendMessage(prefix+ " §7Use /register senha senha.");
		}
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(unlogged.contains(p.getName())) {
					p.kickPlayer("§cDemorou demais!");
				}
			}
		},20*20);
		}
		/*/
		 * 	TitleAPI.sendTabTitle(p,  Main.ServerName+"\n" , "\n §6Housemc.virtus.host");
	TitleAPI.sendFullTitle(p, 10, 40, 10, Main.ServerName, "§fBem-vindo!");
		 */
		
	}
	public static void move(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		
		if(MetodosWarps.containsWarp("spawn")) {
		Location spawn = new Location(p.getWorld(),  MetodosWarps.getWarpXYZ("spawn", "x"),  MetodosWarps.getWarpXYZ("spawn", "y"),  MetodosWarps.getWarpXYZ("spawn", "z"));
		
		if(unlogged.contains(p.getName())) {
		if(p.getLocation().distance(spawn)>3) {
			p.teleport(spawn);
		}
		}
		}
	}
	public static void commandUnlogged(PlayerCommandPreprocessEvent e) {
		Player p= e.getPlayer();
		
		if(unlogged.contains(p.getName())) {
		if(e.getMessage().contains("/login")||e.getMessage().contains("/register")) {
			e.setCancelled(false);
		}else {
			e.setCancelled(true);
			p.sendMessage("§cLogue-se primeiro!");
			return;
		}
		}
		
	}
	public static void chatUnlogged(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		
		
		if(unlogged.contains(p.getName())) {
		e.setCancelled(true);	
		p.sendMessage(prefix+" §cLogue-se primeiro!");
		return;
		}
	}
	
	public void click(PlayerInteractEvent e) {
		Player p= e.getPlayer();
		
		if(unlogged.contains(p.getName())) {
			if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				e.setCancelled(true);
			}
		}
	}
}
