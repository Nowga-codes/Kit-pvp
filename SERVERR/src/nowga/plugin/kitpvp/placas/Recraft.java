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


public class Recraft implements Listener{

	@EventHandler
	public void criarRecraft(SignChangeEvent e) {
		 if (e.getLine(0).contains("recraft")) {
			 e.setLine(0, "");
				e.setLine(1, Main.ServerName);
				e.setLine(2, "§eRecraft");
				
			}
	}
	
	@EventHandler
	public void onPlaca(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		 if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			 if( e.getClickedBlock().getType() == Material.SIGN ||  e.getClickedBlock().getType() == Material.SIGN_POST || e.getClickedBlock().getType() == Material.WALL_SIGN) {
		 
			 Sign sign = (Sign)e.getClickedBlock().getState();
			 
			 if (sign.getLine(1).contains(Main.ServerName)&& (sign.getLine(2).contains("§eRecraft"))) {
				 
				 ItemStack cogumeloMarrom= Manager.createiItem(Material.BROWN_MUSHROOM,64, "§6Cogumelo marrom");
					ItemStack cogumeloVermelho= Manager.createiItem(Material.RED_MUSHROOM,64, "§cCogumelo vermelho");
							ItemStack Pote= Manager.createiItem(Material.BOWL,64, "§7Pote");
				 
				 Inventory inv = Bukkit.createInventory(null, 3*9, "Recraft");
				 
				 for(int i=0; i<=8; i++) {
					 inv.setItem(i, cogumeloMarrom);
				 }
				 for(int i=9; i<=17; i++) {
					 inv.setItem(i, cogumeloVermelho);
				 }
				 for(int i=18; i<=26; i++) {
					 inv.setItem(i, Pote);
				 }
				 
				 p.openInventory(inv);
				 
			 }
		 }
		}
	}
	
}
