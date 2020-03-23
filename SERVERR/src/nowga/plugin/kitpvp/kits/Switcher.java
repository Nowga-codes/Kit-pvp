package nowga.plugin.kitpvp.kits;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import nowga.plugin.kitpvp.Main;

public class Switcher implements Listener{

	public static HashMap<Player, Location> loc= new HashMap<Player, Location>();
	
	
	//Bolinha infinita
	@EventHandler
	public void onClick(PlayerInteractEvent e) { 
		Player p= e.getPlayer();
		
		if(KITAPI.containsKit(p, KITS.SWHITCHER)) {
		if(e.getAction()== Action.RIGHT_CLICK_AIR || e.getAction()== Action.RIGHT_CLICK_BLOCK) {
			if(p.getItemInHand().getType()== Material.SNOW_BALL) {
		
				new BukkitRunnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
					
						p.getInventory().setItem(1, new ItemStack(Material.SNOW_BALL));
						
					}
				}.runTaskLater(Main.plugin, 1);
				
			}
		}
		}
	}
	
	@EventHandler
	public void switcher(EntityDamageByEntityEvent e) {
		
		if(!(e.getEntity() instanceof Player))return;
		if(!(e.getDamager() instanceof Snowball))return;
		Snowball ball= (Snowball) e.getDamager();
	Player	alvo = (Player) e.getEntity();
		
		Player atirador= (Player) ball.getShooter();
		
		if(KITAPI.containsKit(atirador, KITS.SWHITCHER)) {
		if(e.getDamager() instanceof Snowball) {
			if(alvo == null)return;
			if(alvo instanceof Player) {
				
				loc.put(atirador, atirador.getLocation());
				atirador.teleport(alvo.getLocation());
				

			
						// TODO Auto-generated method stub
						alvo.teleport(loc.get(atirador));
						loc.remove(atirador);
				
				
			}
		}
		}
	}
	
}
