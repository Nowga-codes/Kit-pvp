package nowga.plugin.kitpvp.eventos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

import nowga.plugin.kitpvp.Main;
import nowga.plugin.kitpvp.Permissions;


public class Admin extends nowga.plugin.kitpvp.comandos.Admin implements Listener{

	static BukkitTask task;
	public static ArrayList<Player> autosoup= new ArrayList<Player>();
	public static ArrayList<Player> ff= new ArrayList<Player>();
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void clickPlayer(PlayerInteractAtEntityEvent e) {
		Player p= e.getPlayer();
		
		if(nowga.plugin.kitpvp.comandos.Admin.adminMode.contains(p)) {

	if(!(e.getRightClicked() instanceof Player))return;
		//nofall
			Player target= (Player) e.getRightClicked();
			
		if(p.getItemInHand().getType()== Material.FEATHER) {

			Vector loc = target.getVelocity();
			
			
		target.setVelocity(new Vector(loc.getX(), loc.getY() + 1.3, loc.getZ()));

		}
		if(p.getItemInHand().getTypeId()== 101) {
	
			Location loc = target.getLocation();
			
			Location loc1= new Location(target.getWorld(), loc.getX(), loc.getY()+13, loc.getZ());
			Location loc2= new Location(target.getWorld(), loc.getX(), loc.getY()+12, loc.getZ()+1);
			Location loc3= new Location(target.getWorld(), loc.getX(), loc.getY()+12, loc.getZ()-1);
			Location loc4= new Location(target.getWorld(), loc.getX()+1, loc.getY()+12, loc.getZ());
			Location loc5= new Location(target.getWorld(), loc.getX()-1, loc.getY()+12, loc.getZ());
			
			Location loc6= new Location(target.getWorld(), loc.getX(), loc.getY()+10, loc.getZ()+1);
			Location loc7= new Location(target.getWorld(), loc.getX(), loc.getY()+10, loc.getZ()-1);
			Location loc8= new Location(target.getWorld(), loc.getX()+1, loc.getY()+10, loc.getZ());
			Location loc9= new Location(target.getWorld(), loc.getX()-1, loc.getY()+10, loc.getZ());
			Location loc10= new Location(target.getWorld(), loc.getX(), loc.getY()+9, loc.getZ());
			
		
			
		    target.getWorld().getBlockAt(loc1).setType(Material.BEDROCK);     target.getWorld().getBlockAt(loc6).setType(Material.BEDROCK);     
		    target.getWorld().getBlockAt(loc2).setType(Material.BEDROCK);       target.getWorld().getBlockAt(loc7).setType(Material.BEDROCK);     
		    target.getWorld().getBlockAt(loc3).setType(Material.BEDROCK);       target.getWorld().getBlockAt(loc8).setType(Material.BEDROCK);     
		    target.getWorld().getBlockAt(loc4).setType(Material.BEDROCK);       target.getWorld().getBlockAt(loc9).setType(Material.BEDROCK);     
		    target.getWorld().getBlockAt(loc5).setType(Material.BEDROCK);       target.getWorld().getBlockAt(loc10).setType(Material.BEDROCK);     
			
		    
		    target.teleport(new Location(target.getWorld(), loc.getX(), loc.getY()+11, loc.getZ()));
			
		}
		if(p.getItemInHand().getType()== Material.MUSHROOM_SOUP) {

			
			Inventory inv= Bukkit.createInventory(null, InventoryType.PLAYER);
			autosoup.add(p);
			p.openInventory(inv);
			
			
			task = new BukkitRunnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					if(!(autosoup.contains(p))) {
						task.cancel();
					}
				
					inv.setContents(target.getInventory().getContents());
				}
			}.runTaskTimerAsynchronously(Main.plugin, 0, 5);
			
		}
		
		}
		}
	
	
	@EventHandler
	public void closeInv(InventoryCloseEvent e) {
		Player p= (Player) e.getPlayer();
		if(autosoup.contains(p)) {
			autosoup.remove(p);
		}
	}
	@EventHandler
	public void playerClick(PlayerInteractEvent e) {
		Player p= e.getPlayer();
		
		if(nowga.plugin.kitpvp.comandos.Admin.adminMode.contains(p)) {
		if(e.getAction()== Action.RIGHT_CLICK_AIR || e.getAction()== Action.RIGHT_CLICK_BLOCK) {
			if(p.getItemInHand().getType() == Material.REDSTONE_TORCH_ON) {

				
				e.setCancelled(true);
				p.getInventory().clear();
				
				p.sendMessage(prefix+"§7Você saiu do modo admin!");
				adminMode.remove(p);
				
				for(Player pls: Bukkit.getOnlinePlayers()) {
					
					pls.showPlayer(p);
					
				}
				
				new BukkitRunnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						p.getInventory().setContents(itensInv.get(p));
						itensInv.remove(p);
					}
				}.runTaskLater(Main.plugin, 10);
				
			}
			
	if(p.getItemInHand().getType()== Material.BLAZE_ROD) {
			
		if((ff.contains(p))) {
			p.sendMessage("§cClique devagar!!!");
			return;
		}
		
				p.setGameMode(GameMode.SURVIVAL);
                for(Player pls: Bukkit.getOnlinePlayers()) {
                
                	
                	pls.showPlayer(p);
                	
                     ff.add(p);
                     
                	  new BukkitRunnable() {
      					
      					@Override
      					public void run() {
      						// TODO Auto-generated method stub
      						
      						if(pls.hasPermission(Permissions.ADMINMODEVER)) {
          						
      							ff.remove(p);
       
          						p.setGameMode(GameMode.CREATIVE);
          						
      							pls.showPlayer(p);
      							
      							return;
      						}
      						
      						ff.remove(p);
      						pls.hidePlayer(p);
      						p.setGameMode(GameMode.CREATIVE);
      						
      						
      					}
      				}.runTaskLater(Main.plugin, 15);
                
                }
				
			}
			
			}
		}
		
	}
	
}
