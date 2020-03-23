package nowga.plugin.kitpvp.eventos;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;


import nowga.plugin.kitpvp.conexao.MetodosWarps;
import nowga.plugin.kitpvp.warps.Warp1V1;
import nowga.plugin.kitpvp.warps.WarpAPI;

public class PvpProtection implements Listener{

	
	
	@EventHandler
	public void damage(EntityDamageByEntityEvent e) {
		
	   if(!(e.getEntity()instanceof Player))return;
		if(!(e.getDamager() instanceof Player)) return;
		
		Player p= (Player) e.getDamager();
		Player target= (Player) e.getEntity();
		if(WarpAPI.contador1v1.contains(p.getName())||WarpAPI.contador1v1.contains(target.getName())) {
			if(!(Warp1V1.combate1v1.containsKey(p) || Warp1V1.combate1v1.containsKey(target))) {
				
				e.setCancelled(true);
				return;
			}
		}

		Location spawn = new Location(p.getWorld(), MetodosWarps.getWarpXYZ("spawn", "x"), MetodosWarps.getWarpXYZ("spawn", "y"), MetodosWarps.getWarpXYZ("spawn", "z"));
		if(p.getLocation().distance(spawn)<= 100) {
			e.setCancelled(true);
			
			return;
		}
		
	}
	
}
