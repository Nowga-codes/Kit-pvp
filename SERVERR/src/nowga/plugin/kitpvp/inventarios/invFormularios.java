package nowga.plugin.kitpvp.inventarios;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import nowga.plugin.kitpvp.comandos.Formularios;

public class invFormularios implements Listener{

	@EventHandler
	public void selecionar(InventoryClickEvent e) {
		Player p= (Player) e.getWhoClicked();
	
		if(e.getCurrentItem()== null)return;
		if(e.getInventory().getName().equalsIgnoreCase("FORMULARIOS")) {
			e.setCancelled(true);
			if(e.getCurrentItem().isSimilar(Formularios.Builder)) {
			if(e.getClick().isLeftClick()) {
				
				p.closeInventory();
				p.sendMessage(" \n §aLink formulario para Builder§7: https://docs.google.com/forms/d/e/1FAIpQLScS0jeXciIDfWkVPDy9hFdJsWDbhcnohiCyw5MFYb5nYDRN5Q/formResponse \n "
						+ " \n §2Obs§a: Não fique perguntando se ja avaliaram seu formulario, com isso você já perde pontos. \n ");
				
			}
			}
			if(e.getCurrentItem().isSimilar(Formularios.Trial)) {
				if(e.getClick().isLeftClick()) {
					
					p.closeInventory();
					p.sendMessage(" \n §aLink formulario para Trial-Moderador§7: https://docs.google.com/forms/d/e/1FAIpQLScS0jeXciIDfWkVPDy9hFdJsWDbhcnohiCyw5MFYb5nYDRN5Q/formResponse \n "
							+ " \n §2Obs§a: Não fique perguntando se ja avaliaram seu formulario, com isso você já perde pontos. \n ");
					
				}
				}
		}
			}
	
}
