package nowga.plugin.kitpvp.kits;

import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class Stomper implements Listener{


	@EventHandler
	public void aoCair(EntityDamageEvent e) {
		

		if(!(e.getEntity() instanceof Player))return;
		if(!(KITAPI.containsKit((Player) e.getEntity(), KITS.STOMPER)))return;
		if(KITAPI.containsKit((Player)e.getEntity(), KITS.STOMPER)) {
		if(e.getEntity() instanceof Player && e.getCause()== DamageCause.FALL) {
			e.setCancelled(true);
		Player stomper = (Player) e.getEntity();
		
		if((stomper.getFallDistance()>= 10) && stomper.getFallDistance() <20){

			for(Entity alvos: stomper.getNearbyEntities(3, 3, 3)) {
				if(!(alvos instanceof Player))return;
                 Player alvo= (Player) alvos;
         		if(KITAPI.containsKit(alvo, KITS.ANTISTOMPER))return;
                   if(alvo.isSneaking())return;
                   
         		stomper.playSound(stomper.getLocation(), Sound.ANVIL_LAND, 1, 1);
                 alvo.damage(6);
                 
                 
			}
		}
		
		if((stomper.getFallDistance()>= 20)){
			stomper.damage(2);
			
			for(Entity alvos: stomper.getNearbyEntities(3, 3, 3)) {
				if(!(alvos instanceof Player))return;
                 Player alvo= (Player) alvos;
         		if(KITAPI.containsKit(alvo, KITS.ANTISTOMPER))return;
                   if(alvo.isSneaking())return;
                   
         		stomper.playSound(stomper.getLocation(), Sound.ANVIL_LAND, 1, 1);
                 alvo.damage(20);
                 
			}
			}
			
		}
		}
	}
	
}
