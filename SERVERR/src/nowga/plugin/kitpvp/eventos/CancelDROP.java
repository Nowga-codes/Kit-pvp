package nowga.plugin.kitpvp.eventos;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.scheduler.BukkitRunnable;

import nowga.plugin.kitpvp.Main;
import nowga.plugin.kitpvp.kits.KITAPI;

public class CancelDROP implements Listener{
	
	

	@EventHandler
	public void playerDrop(PlayerDropItemEvent e) {
		Player p= e.getPlayer();
		
	
		e.setCancelled(false);
		
		 if(KITAPI.containsKit(p)) {
			if(!(e.getItemDrop().getItemStack().getType()== Material.BOWL || e.getItemDrop().getItemStack().getType()== Material.MUSHROOM_SOUP)){
				e.setCancelled(true);
				
			}else {
				new BukkitRunnable() {
					
					@SuppressWarnings("deprecation")
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						  for(Player pls:Bukkit.getOnlinePlayers()) {
							  if(pls.getLocation().distance(e.getItemDrop().getLocation())<=10) {
					pls.playEffect(e.getItemDrop().getLocation(), Effect.SMOKE, 1);	
							  }
						  }
						e.getItemDrop().remove();
							
						
					}
				}.runTaskLater(Main.plugin, 40);
			}
		}else {
			if(e.getItemDrop().getItemStack().getType()== Material.EMERALD || e.getItemDrop().getItemStack().getType()== Material.PAPER|| e.getItemDrop().getItemStack().getType()== Material.CHEST){
				e.setCancelled(true);
				return;
			}else {
new BukkitRunnable() {
					
					@SuppressWarnings("deprecation")
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						for(Player pls:Bukkit.getOnlinePlayers()) {
							  if(pls.getLocation().distance(e.getItemDrop().getLocation())<=10) {
					pls.playEffect(e.getItemDrop().getLocation(), Effect.SMOKE, 1);	
							  }
						  }
						
						e.getItemDrop().remove();
							
						
					}
				}.runTaskLater(Main.plugin, 40);
			
			}
		}
		
	
		
	
	
}
}
