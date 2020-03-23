package nowga.plugin.kitpvp.kits;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerLeashEntityEvent;

import net.minecraft.server.v1_8_R3.Block;

public class Grappler implements Listener{

	
	@EventHandler
	public void grappler(PlayerLeashEntityEvent e) {
		Player p= e.getPlayer();
		
		Block b= (Block) e.getLeashHolder();
		
		if(b == null) return;
		
		p.teleport(e.getLeashHolder().getLocation());
		
	}
}
