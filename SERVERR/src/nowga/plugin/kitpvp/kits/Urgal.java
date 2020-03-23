package nowga.plugin.kitpvp.kits;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import nowga.plugin.kitpvp.Main;

public class Urgal extends KITAPI implements Listener {

	public static ArrayList<String> delay= new ArrayList<String>();
	public static ArrayList<Player> strength= new ArrayList<Player>();
	
	@EventHandler
	public void clicar(PlayerInteractEvent e) {
		Player p= e.getPlayer();
	
		if(containsKit(p, KITS.URGAL)) {
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(p.getItemInHand().getType() == Material.REDSTONE) {
				
				if(!(delay.contains(p.getName()))){
					delay.add(p.getName());
					addStrength(p);
					p.sendMessage(prefix+"§7Você esta mais forte por 5 segundos.");
					
					new BukkitRunnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							delay.remove(p.getName());
							p.sendMessage(prefix+"§aJá pode usar o kit novamente!");
						}
					}.runTaskLater(Main.plugin, 20*15);
				}else {
					p.sendMessage(prefix+"§cAguarde um pouco para usar o kit!");
				}
				
				
			}
			
		}
		}
	}
	public static void addStrength(Player p) {
		strength.add(p);
		new BukkitRunnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
                strength.remove(p);
			
			}
		}.runTaskLater(Main.plugin, 20*5);
	}
	public static void damage(EntityDamageByEntityEvent e) {
		
		Player agressor= (Player) e.getDamager();
				
				if(KITAPI.containsKit(agressor, KITS.URGAL)) {
					if(strength.contains(agressor)) {
						
						if(agressor.getItemInHand().getType() == Material.STONE_SWORD) {
							
							e.setDamage(6);
					
						}
					return;
					}
				}
				
				}
	
}
