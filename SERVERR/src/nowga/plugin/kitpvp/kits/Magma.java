package nowga.plugin.kitpvp.kits;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class Magma implements Listener{

	public static void damage(EntityDamageByEntityEvent e) {
		
Player agressor= (Player) e.getDamager();
		
		if(KITAPI.containsKit(agressor, KITS.MAGMA)) {
			if(agressor.getLocation().getBlock().getType() == Material.STATIONARY_LAVA) {

				Random r= new Random();
				int number= r.nextInt(8);
				
				if(agressor.getItemInHand().getType() == Material.STONE_SWORD) {
					
					e.setDamage(6);
				
				agressor.sendMessage("§"+number+"FUncionando! ");
				
				}
			return;
			}
		}
		
		}
	
	
}