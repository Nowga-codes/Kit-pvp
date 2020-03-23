package nowga.plugin.kitpvp.kits;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import nowga.plugin.kitpvp.Main;

public class Viper extends KITAPI implements Listener{

	private static ArrayList<String> delay= new ArrayList<String>();
	
	@EventHandler
	public void onclick(EntityDamageByEntityEvent e) {
		
		if(!(e.getEntity() instanceof Player || e.getDamager() instanceof Player)) {
			return;
		}
	
		
		if(e.getEntity() instanceof Player && e.getDamager()instanceof Player) {
			if(KITAPI.containsKit((Player)e.getDamager(), KITS.VIPER)) {
		if(((Player) e.getDamager()).getItemInHand().getType()== Material.STONE_SWORD) {
			 Player vitima= (Player) e.getEntity();
			 Player agressor= (Player)e.getDamager();	
			 
			 if(delay.contains(vitima.getName())) {
				 return;
			 }
			 delay.add(vitima.getName());
			 delayRemove(vitima);
			 
			 Random r= new Random();
			 int a= r.nextInt(100);
			 
			 if(a <=50) {
		vitima.sendMessage(prefix + " §cVocê foi envenenado por "+agressor.getName());
		vitima.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 20*5, 0));
		
		agressor.sendMessage(prefix+" §c"+vitima.getName()+"§c foi envenenado!");
	}
		}
		}
		}
		
	
	}
	public void delayRemove(Player p) {
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				delay.remove(p.getName());
			}
		},20*10);
	}
	
}
