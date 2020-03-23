package nowga.plugin.kitpvp.eventos;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import nowga.plugin.kitpvp.Main;
import nowga.plugin.kitpvp.Manager;
import nowga.plugin.kitpvp.kits.KITAPI;
import nowga.plugin.kitpvp.kits.KITS;


public class Sopa implements Listener{

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onSopa(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Damageable hp = p;
		
		ItemStack pote =Manager.createiItem(Material.BOWL, "§7Pote");
		ItemMeta potem = pote.getItemMeta();
		if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK) && 
				(p.getItemInHand().getType() == Material.MUSHROOM_SOUP)) {
			if (p.getItemInHand().getType() == Material.MUSHROOM_SOUP) {
				if (hp.getHealth() != hp.getMaxHealth()) {
					
					//Dropar sopa Kit QUICKDROPPER
					if(KITAPI.containsKit(p, KITS.QUICKDROPPER)) {
						p.setHealth((hp.getHealth() + 7.0D > hp.getMaxHealth()) ? hp.getMaxHealth() : (hp.getHealth() + 7.0D));
						p.getInventory().setItemInHand(new ItemStack(Material.getMaterial(0)));
						droparSopa(p);
						
					}else {
					p.setHealth((hp.getHealth() + 7.0D > hp.getMaxHealth()) ? hp.getMaxHealth() : (hp.getHealth() + 7.0D));
					p.getItemInHand().setType(Material.BOWL);
					p.getItemInHand().setItemMeta(potem);
					}
				}else if (p.getFoodLevel() < 20) {
					
					//Dropar sopa Kit QUICKDROPPER
					if(KITAPI.containsKit(p, KITS.QUICKDROPPER)) {
						p.setFoodLevel(p.getFoodLevel() + 7);
					
						p.getInventory().remove(1);
						droparSopa(p);
						p.getInventory().setItemInHand(new ItemStack(Material.getMaterial(0)));
					}else {
					p.setFoodLevel(p.getFoodLevel() + 7);
					p.getItemInHand().setType(Material.BOWL);
					p.getItemInHand().setItemMeta(potem);
				
					}
					}
		
			}
			
		}
	}
	public static void droparSopa(Player p) {
		
		double x = p.getLocation().getX()+ 1;
		double y = p.getLocation().getY() +2;
		double z = p.getLocation().getZ();
		Location loc= new Location(p.getWorld(), x, y, z);
		 Item drop = Bukkit.getWorld("world").dropItem(loc, new ItemStack(Material.BOWL));
		 new BukkitRunnable() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(Player players: Bukkit.getOnlinePlayers()) {
					if(players.getLocation().distance(drop.getLocation() )<=10) {
				players.playEffect(drop.getLocation(), Effect.SMOKE, 1);
					}
				}
           
				
			}
		}.runTaskLater(Main.plugin, 40);
	}
	@EventHandler
	public void fome(FoodLevelChangeEvent e) {
		e.setCancelled(true);
	}
	
}
