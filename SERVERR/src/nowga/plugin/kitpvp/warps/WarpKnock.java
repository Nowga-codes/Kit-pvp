package nowga.plugin.kitpvp.warps;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class WarpKnock {
	
	public static void damageKnock(EntityDamageByEntityEvent e) {
		Player p= (Player) e.getEntity();
		
		if(WarpAPI.contadorKnock.contains(p.getName())) {
			
			e.setDamage(0);
		}
		
	}
	
}
