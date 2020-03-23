package nowga.plugin.kitpvp.kits;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

public class FisherMan implements Listener{


	
	@EventHandler
	public void fisher(PlayerFishEvent e) {
		
		Player p= e.getPlayer();
        if(KITAPI.containsKit(p, KITS.FISHERMAN)) {
        	if(e.getCaught()== null)return;
        	if(!(e.getCaught() instanceof Player))return;
        	
        	Player target= (Player)e.getCaught();
        	
        	target.teleport(p.getLocation());
        	
        	target.sendMessage("§6§lFisherman: §7Você foi puxado por §6"+ p.getName()+"§7.");
        	
        }

	
	}
}
