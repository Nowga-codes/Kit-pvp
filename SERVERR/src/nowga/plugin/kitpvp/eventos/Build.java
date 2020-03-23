package nowga.plugin.kitpvp.eventos;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class Build implements Listener{

	public static ArrayList<String> buildStats= new ArrayList<String>();
	public static String prefix= "§e§lBUILD:";
	
	@EventHandler
	public void quebrarblocos(BlockBreakEvent e) {
		Player p= e.getPlayer();
		
		if(nowga.plugin.kitpvp.comandos.Build.status== false)return;
		if(!(buildStats.contains(p.getName()))) {
			e.setCancelled(true);
			p.sendMessage(prefix+" §7Você não pode destruir aqui!");
		}
		
	}
	@EventHandler
	public void colocarBlocos(BlockPlaceEvent e) {
		Player p= e.getPlayer();
	
		if(nowga.plugin.kitpvp.comandos.Build.status== false)return;
		if(!(buildStats.contains(p.getName()))) {
			e.setCancelled(true);
			p.sendMessage(prefix+" §7Você não pode construir aqui!");
		}
	}
	
}
