package nowga.plugin.kitpvp.inventarios;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import nowga.plugin.kitpvp.Manager;

public class ClicarHotBar implements Listener {

	@EventHandler
	public void invKits(PlayerInteractEvent e) {

	
		if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if (e.getPlayer().getItemInHand().getType()==Material.CHEST) {

				InvKitsAtuais.inventario(e.getPlayer());
			}
			if (e.getPlayer().getItemInHand().getType()==Material.PAPER) {
				WarpsPublicasInv.inventario(e.getPlayer());
			}
			if (e.getPlayer().getItemInHand().getType()==Material.EMERALD) {
				InvLojaKits.inventario(e.getPlayer());
			} 
		}
	}
	
}
