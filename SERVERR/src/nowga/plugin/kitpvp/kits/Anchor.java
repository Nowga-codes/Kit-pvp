package nowga.plugin.kitpvp.kits;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import nowga.plugin.kitpvp.Main;

public class Anchor implements Listener{

@EventHandler
	public void antiKnockback(EntityDamageByEntityEvent e) {
	
	if(!(e.getDamager() instanceof Player))return;
	if(!(e.getEntity() instanceof Player))return;
		Player agressor= (Player)e.getDamager();
	    Player vitima= (Player) e.getEntity();

	    
	    if(!(agressor instanceof Player || vitima instanceof Player)) return;
	    
	    if(KITAPI.containsKit(agressor, KITS.ANCHOR)) {
	    	
	    	new BukkitRunnable() {
	    		
	    		@Override
	    		public void run() {
	    			// TODO Auto-generated method stub
	    			 vitima.setVelocity(new Vector());
	    	
	    		}
	    	}.runTaskLater(Main.plugin, 1);    
	    	    }
	    
	    if(KITAPI.containsKit(vitima, KITS.ANCHOR)) {
	
	new BukkitRunnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			 vitima.setVelocity(new Vector());
	
		}
	}.runTaskLater(Main.plugin, 1);    
	    }
	}
	
}
