package nowga.plugin.kitpvp.loja;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.material.MaterialData;

import nowga.plugin.kitpvp.conexao.MetodosKITS;
import nowga.plugin.kitpvp.conexao.MetodosMySql;

public class ComprarKit implements Listener{

	public static boolean containsCoins(Player p, int quantia) {
		if(MetodosMySql.getStatus(p, "coins")>= quantia) {
			return true;
		}
		return false;
	}


	@SuppressWarnings("deprecation")
	@EventHandler
	public void onClickInv(InventoryClickEvent e) {
		Player p= (Player) e.getWhoClicked();
		
		if(e.getInventory().getName().equalsIgnoreCase("Loja")) {
			
		e.setCancelled(true);
		
		if(e.getCurrentItem()== null)return;
	
		//pegar o preço e nome do item, para facilitar o pl de compra
	if(e.getClick().isLeftClick()) {
		if(!(e.getCurrentItem().getTypeId() == 145 ||e.getCurrentItem().getTypeId() == 309||e.getCurrentItem().getTypeId() ==313
				||e.getCurrentItem().getTypeId() ==346||e.getCurrentItem().getTypeId() ==420||e.getCurrentItem().getTypeId() ==326
				||e.getCurrentItem().getTypeId() ==331||e.getCurrentItem().getTypeId() ==281||e.getCurrentItem().getTypeId() ==327
				||e.getCurrentItem().getTypeId() ==101))return;
		if(!(e.getCurrentItem().getItemMeta().getLore().get(3).contains("Preço"))) {
			String inputName= e.getCurrentItem().getItemMeta().getDisplayName();
			String[] splitName = inputName.split("KIT:§7 ");

			String kitName = splitName[1];
			
			if(MetodosKITS.containsKIT(p, kitName)){
					p.closeInventory();
					p.sendMessage("§cVocê ja possui esse kit!");
					return;
				}
			return;
		}
		String inputPreco= e.getCurrentItem().getItemMeta().getLore().get(3);
		String[] splitPreco = inputPreco.split("Preço: §a");

		String preco = splitPreco[1];
		
		String inputName= e.getCurrentItem().getItemMeta().getDisplayName();
		String[] splitName = inputName.split("KIT:§7 ");

		String kitName = splitName[1];
		

		if(containsCoins(p, Integer.parseInt(preco))) {
		
		    int calculo= Integer.parseInt(preco)*15;
		    int desconto= calculo/100;
		    
		    int calculo25= Integer.parseInt(preco)*25;
		    int desconto25= calculo/100;
		    
		    int calculo50= Integer.parseInt(preco)*50;
		    int desconto50= calculo/100;
			
			/*/
			 * if(p,isVIP){
			 * 
			 * }
			 */
			
          MetodosKITS.comprarKIT(p, kitName);
		
			p.closeInventory();
			p.sendMessage("§a§lKIT§7: Kit "+kitName+ " comprado com sucesso!");
			p.sendMessage("§7Preço: §6"+preco+" Coins.");
	
		}else {
			p.sendMessage("§a§lKIT§7: Você não tem dinheiro o suficiente!");
			p.closeInventory();
		}
			
		}
		}
		
	}
	
}
