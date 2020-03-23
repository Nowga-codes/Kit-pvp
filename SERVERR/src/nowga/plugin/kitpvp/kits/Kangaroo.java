package nowga.plugin.kitpvp.kits;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import nowga.plugin.kitpvp.combate.Combate;

public class Kangaroo implements Listener{

	public static HashMap<String, Integer> limit= new HashMap<String, Integer>();
	
	@EventHandler
	public void clicar(PlayerInteractEvent e) {
		Player p= e.getPlayer();
	
		if(e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK
				||e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
			if(p.getItemInHand().getType() == Material.FIREWORK) {
				if(KITAPI.containsKit(p, KITS.KANGAROO)) {
				if(Combate.combate.containsKey(p)) {
					p.sendMessage(KITAPI.prefix+" §cVocê esta em combate!");
					e.setCancelled(true);
					return;
				}
				e.setCancelled(true);
	  if(p.isSneaking()) {
		 
		  if(limit.containsKey(p.getName())) {
		  if(limit.get(p.getName())== 2) {
			  return;
		  }
		  }
		  
		  
		  if(!(limit.containsKey(p.getName()))) {
			  limit.put(p.getName(), Integer.valueOf(1));
			  
			  Location loc = p.getLocation();
			  loc.setPitch(0.0F);
			  Vector jump = loc.getDirection();
			  jump.setY(0.4D);
			  jump.multiply(1.50D);
			  p.setVelocity(jump);
			  
		  }else {
			  limit.put(p.getName(), Integer.valueOf(2));
			  
			  Location loc = p.getLocation();
			  loc.setPitch(0.0F);
			  Vector jump = loc.getDirection();
			  jump.setY(0.4D);
			  jump.multiply(1.50D);
			  p.setVelocity(jump);
			  
		  }
		  
	  }else {
		  if(limit.containsKey(p.getName())) {
		  if(limit.get(p.getName())== 2) {
			  return;
		  }
		  }
		  
		  if(!(limit.containsKey(p.getName()))) {
			  limit.put(p.getName(), Integer.valueOf(1));
		  Location loc = p.getLocation();
		  loc.setPitch(0.0F);
		  Vector jump = loc.getDirection();
		  jump.setY(1.25D);
		  jump.multiply(0.80D);
		  p.setVelocity(jump);
		  
		  }else {
			  limit.put(p.getName(), Integer.valueOf(2));
			  Location loc = p.getLocation();
			  loc.setPitch(0.0F);
			  Vector jump = loc.getDirection();
			  jump.setY(1.25D);
			  jump.multiply(0.80D);
			  p.setVelocity(jump);
		  }
	  }
				
			
			}
		}
		}
	}
		
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p =e.getPlayer();
		
		if(KITAPI.containsKit(p, KITS.KANGAROO)) {
		  if(limit.containsKey(p.getName())) {
			  
			  
				 if(limit.get(p.getName())== 2) {
					 
					 if((p.isOnGround())) {
						 limit.remove(p.getName());

						 return;
					 }
					 
				 }
					 
					 return;
				 }
		}
		
	}
	@EventHandler
	public void aoCair(EntityDamageEvent e) {
		
		if(!(e.getEntity() instanceof Player)) {
		return;
		}
		Player p= (Player) e.getEntity();
		
		if(KITAPI.containsKit(p, KITS.KANGAROO)) {
			if(!(limit.containsKey(p.getName()))) {
				e.setCancelled(false);
				return;
			}
			  if(limit.get(p.getName())== 1 ||limit.get(p.getName())== 2) {
		if(e.getCause()== DamageCause.FALL) {
			e.setCancelled(true);
			p.damage(2);
		}
		}
		}
	}
	
}
