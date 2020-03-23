package nowga.plugin.kitpvp.placas;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import nowga.plugin.kitpvp.Main;
import nowga.plugin.kitpvp.Manager;

public class SopaPlaca implements Listener{

	@EventHandler
	public void criarRecraft(SignChangeEvent e) {
		 if (e.getLine(0).contains("sopas")) {
			 e.setLine(0, "");
				e.setLine(1, Main.ServerName);
				e.setLine(2, "§eSopas");
				
			}
	}
	
	@EventHandler
	public void onPlaca(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		 if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			 if( e.getClickedBlock().getType() == Material.SIGN ||  e.getClickedBlock().getType() == Material.SIGN_POST || e.getClickedBlock().getType() == Material.WALL_SIGN) {
		 
			 Sign sign = (Sign)e.getClickedBlock().getState();
			 
			 if (sign.getLine(1).contains(Main.ServerName)&& (sign.getLine(2).contains("§eSopas"))) {

							ItemStack Sopa= Manager.createiItem(Material.MUSHROOM_SOUP, "§cSopinha");
				 
				 Inventory inv = Bukkit.createInventory(null, 6*9, "Sopas");
				 
			
				 for(int i=0; i<=53; i++) {
					 inv.setItem(i, Sopa);
				 }
				 
				 p.openInventory(inv);
				 
			 }
		 }
		}
	}
	

	
}
