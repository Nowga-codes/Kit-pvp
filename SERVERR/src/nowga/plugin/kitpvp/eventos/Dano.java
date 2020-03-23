package nowga.plugin.kitpvp.eventos;


import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import nowga.plugin.kitpvp.conexao.MetodosWarps;
import nowga.plugin.kitpvp.kits.KITAPI;
import nowga.plugin.kitpvp.kits.KITS;
import nowga.plugin.kitpvp.kits.Magma;
import nowga.plugin.kitpvp.kits.Poseidon;
import nowga.plugin.kitpvp.kits.Urgal;
import nowga.plugin.kitpvp.warps.Warp1V1;
import nowga.plugin.kitpvp.warps.WarpAPI;
import nowga.plugin.kitpvp.warps.WarpKnock;

public class Dano implements Listener{

	 @EventHandler
		public static void cair(EntityDamageEvent e) {
		 
		 if(!(e.getEntity() instanceof Player))return;
			Player p = (Player) e.getEntity();
			
			if(WarpAPI.contadorKnock.contains(p.getName())) {
			if(e.getCause()== DamageCause.FALL) {
				e.setCancelled(true);
			return;
			}
			}
			
			Player pvitima= (Player) e.getEntity();
			Location spawn = new Location(e.getEntity().getWorld(), MetodosWarps.getWarpXYZ("spawn", "x"), MetodosWarps.getWarpXYZ("spawn", "y"), MetodosWarps.getWarpXYZ("spawn", "z"));
			
			if(e.getEntity().getLocation().distance(spawn)<= 100) {
				if(e.getCause()== DamageCause.FALL) {
				e.setCancelled(true);
				return;
				}
			}
			if(WarpAPI.contador1v1.contains(pvitima.getName())||WarpAPI.contador1v1.contains(pvitima.getName())) {
				if(!(Warp1V1.combate1v1.containsKey(pvitima))) {
					
					if(e.getCause()== DamageCause.FALL) {
					e.setCancelled(true);
					return;
					}
				}
			}
			
			
		}
	
	@EventHandler
	public void bater(EntityDamageByEntityEvent e) {
		
		
		if(!(e.getEntity() instanceof Player && e.getDamager()instanceof Player))return;
Player agressor= (Player) e.getDamager();
		
         Player vitima= (Player) e.getEntity();
      if(WarpAPI.contadorKnock.contains(vitima.getName())){
    	  WarpKnock.damageKnock(e);
    	  return;
      }

         if(KITAPI.containsKit(agressor, KITS.POSEIDON)|| KITAPI.containsKit(agressor, KITS.MAGMA)|| KITAPI.containsKit(agressor, KITS.URGAL)) {
        Magma.damage(e);
		Poseidon.damage(e);
		Urgal.damage(e);
         }else {
		
		if(agressor.getItemInHand().getType() == Material.STONE_SWORD) {
			
			e.setDamage(3);

		}
		}
	}
	
}
