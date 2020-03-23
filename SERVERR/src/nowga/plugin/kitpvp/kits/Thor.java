package nowga.plugin.kitpvp.kits;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import nowga.plugin.kitpvp.Main;

public class Thor extends KITAPI implements Listener{

	public static ArrayList<String> cooldown= new ArrayList<String>();
	public static HashMap<String, Location> replace= new HashMap<String, Location>();
	public static Material bloco,bloco1,bloco2,bloco3,bloco4,bloco5,bloco6;
	
	@EventHandler
	public void aocliclar(PlayerInteractEvent e) {
		Player p= e.getPlayer();
	
		
		if(containsKit(p, KITS.THOR)) {
		if(e.getAction()== Action.RIGHT_CLICK_BLOCK) {
			if(p.getItemInHand().getType()== Material.WOOD_AXE) {
				
				
				if(cooldown.contains(p.getName())) {
					p.sendMessage(prefix+" §cEspere um pouco para usar!");
				}else {
				Block target = e.getClickedBlock();
				
			
				  LightningStrike loc = target.getWorld().strikeLightning(target.getLocation());
	
				  
				   double X= loc.getLocation().getX();
					  double Y= loc.getLocation().getY();
					  double Z= loc.getLocation().getZ();
							 
					  //Blocos destruidos
					  bloco= loc.getLocation().getBlock().getType();
					  Location locbloco1= new Location(p.getWorld(), X+1, Y, Z); 
					  Location locbloco2= new Location(p.getWorld(), X+2, Y, Z); 
					  Location locbloco3= new Location(p.getWorld(), X-1, Y, Z); 
					  Location locbloco4= new Location(p.getWorld(), X-2, Y, Z); 
					  Location locbloco5= new Location(p.getWorld(), X, Y-1, Z); 
					  Location locbloco6= new Location(p.getWorld(), X, Y+2, Z); 
					  Location locbloco7= new Location(p.getWorld(), X, Y, Z+1); 
					  Location locbloco8= new Location(p.getWorld(), X, Y, Z+2); 
					  Location locbloco9= new Location(p.getWorld(), X, Y, Z-1); 
					  Location locbloco10= new Location(p.getWorld(), X, Y, Z-2); 
					  Location locbloco11= new Location(p.getWorld(), X-1, Y, Z+1); 
					  Location locbloco12= new Location(p.getWorld(), X-2, Y, Z-1);
					  
					  Material bloco1 = locbloco1.getBlock().getType();
					  Material bloco2 = locbloco2.getBlock().getType();
					  Material bloco3 = locbloco3.getBlock().getType();
					  Material bloco4 = locbloco4.getBlock().getType();
					  Material bloco5 = locbloco5.getBlock().getType();
					  Material bloco6 = locbloco6.getBlock().getType();
					  Material bloco7 = locbloco7.getBlock().getType();
					  Material bloco8 = locbloco8.getBlock().getType();
					  Material bloco9 = locbloco9.getBlock().getType();
					  Material bloco10 = locbloco10.getBlock().getType();
					  Material bloco11 = locbloco10.getBlock().getType();
					  Material bloco12 = locbloco10.getBlock().getType();
				   
				   
				   
				  loc.getLocation().getBlock().setType(Material.AIR);;
				  locbloco1.getBlock().setType(Material.AIR);
				  locbloco2.getBlock().setType(Material.AIR);
				  locbloco3.getBlock().setType(Material.AIR);
				  locbloco4.getBlock().setType(Material.AIR);
				  locbloco5.getBlock().setType(Material.AIR);
				  locbloco6.getBlock().setType(Material.AIR);
				  locbloco7.getBlock().setType(Material.AIR);
				  locbloco8.getBlock().setType(Material.AIR);
				  locbloco9.getBlock().setType(Material.AIR);
				  locbloco10.getBlock().setType(Material.AIR);
				  locbloco11.getBlock().setType(Material.AIR);
				  locbloco12.getBlock().setType(Material.AIR);
				  
				  
				
				  target.getWorld().strikeLightning(target.getLocation());
				  target.getWorld().strikeLightning(target.getLocation());
				  target.getWorld().spawnEntity(target.getLocation(), EntityType.LIGHTNING);
				  
				
				  
				  
			   p.sendMessage(prefix +" §cVocê podera usar novamente em 10 segundos.");
			   cooldown.add(p.getName());
			   delay(p);
			   
			   replace.put(p.getName(), loc.getLocation());
			 
			   
			   new BukkitRunnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					loc.getLocation().getBlock().setType(bloco);
					locbloco1.getBlock().setType(bloco1);
					locbloco2.getBlock().setType(bloco2);
					locbloco3.getBlock().setType(bloco3);
					locbloco4.getBlock().setType(bloco4);
					locbloco5.getBlock().setType(bloco5);
					locbloco6.getBlock().setType(bloco6);
					locbloco7.getBlock().setType(bloco7);
					locbloco8.getBlock().setType(bloco8);
					locbloco9.getBlock().setType(bloco9);
					locbloco10.getBlock().setType(bloco10);
					locbloco11.getBlock().setType(bloco11);
					locbloco12.getBlock().setType(bloco12);
				}
			}.runTaskLater(Main.plugin, 20*5);
			  
			  
			   
				
				}
			}
		}
		}
	}
	private static void delay(Player p) {
		
		new BukkitRunnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				cooldown.remove(p.getName());
				p.sendMessage(prefix+" §7Você ja pode usar o kit!");
			}
		}.runTaskLater(Main.plugin, 20*15);
	}
	
}
