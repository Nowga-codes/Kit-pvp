package nowga.plugin.kitpvp.inventarios;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class invYT implements Listener{
	
	@EventHandler
	public void selecionar(InventoryClickEvent e) {
		Player p= (Player) e.getWhoClicked();
	
		if(e.getCurrentItem()== null)return;
		if(e.getInventory().getName().equalsIgnoreCase("TAGS")) {
			e.setCancelled(true);
			if(e.getCurrentItem().getType()== Material.PAPER) {
			if(e.getClick().isLeftClick()) {
				
				p.closeInventory();
				p.sendMessage(" \n §ePara ativar sua tag siga as instruções: \n "
						+ " \n §aPasso 1§7: Poste um video do servidor no seu canal do yotube. \n "
						+ "§aPasso 2§7: Coloque o ip do servidor e link do discord na descrição. \n "
						+ "§aPasso 3§7: Aguarde o seu video pegar as vizualizações exigida pela tag que você deseja. \n "
						+ "§aPasso 4§7: Mande mensagem no discord no canal #Youtubers-Ativar solicitando sua tag. \n "
						+ "§aPRONTO! Dentro de 24 horas sua tag vai estar sendo ativada por algum admin/dono. \n "
						+ " \n §aDiscord§7: https://discord.gg/jJTH2cP \n ");
				
			}
			}
		}
			}
	

}
