package nowga.plugin.kitpvp.inventarios;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import nowga.plugin.kitpvp.Main;
import nowga.plugin.kitpvp.conexao.MetodosKITS;

public class InvLojaKits extends InvAPI{
	
	

	
	public static void inventario(Player p) {
		Inventory inv= Bukkit.createInventory(null, 6*9, "Loja");
		
			for(int i= 0; i< 54; i ++) {
				inv.setItem(i, itemID(160, 11, Main.ServerName, ""));
			}
			if(MetodosKITS.containsKIT(p, "Anchor")) {inv.setItem(11, kitAnchorCOMPRADOLOJA);}else {inv.setItem(11, kitAnchorLOJA);}
			if(MetodosKITS.containsKIT(p, "Stomper")) {inv.setItem(12, kitStomperCOMPRADOLOJA);}else {inv.setItem(12, kitStomperLOJA);}
			if(MetodosKITS.containsKIT(p, "AntiStomper")) {inv.setItem(13, kitAntiStomperCOMPRADOLOJA);}else {inv.setItem(13, kitAntiStomperLOJA);}
			if(MetodosKITS.containsKIT(p, "Fisherman")) {inv.setItem(14, kitFishermanCOMPRADOLOJA);}else {inv.setItem(14, kitFishermanLOJA);}
			if(MetodosKITS.containsKIT(p, "Grappler")) {inv.setItem(15, kitGrapplerCOMPRADOLOJA);}else {inv.setItem(15, kitGrapplerLOJA);}
			if(MetodosKITS.containsKIT(p, "Poseidon")) {inv.setItem(20, kitPoseidonCOMPRADOLOJA);}else {inv.setItem(20, kitPoseidonLOJA);}
			if(MetodosKITS.containsKIT(p, "Urgal")) {inv.setItem(21, kitUrgalCOMPRADOLOJA);}else {inv.setItem(21, kitUrgalLOJA);}
			if(MetodosKITS.containsKIT(p, "QuickDropper")) {inv.setItem(22, kitQuickDropperCOMPRADOLOJA);}else {inv.setItem(22, kitQuickDropperLOJA);}
			if(MetodosKITS.containsKIT(p, "Magma")) {inv.setItem(23, kitMagmaCOMPRADOLOJA);}else {inv.setItem(23, kitMagmaLOJA);}
			if(MetodosKITS.containsKIT(p, "Gladiator")) {inv.setItem(24, kitGladiatorCOMPRADOLOJA);}else {inv.setItem(24, kitGladiatorLOJA);}

		
		    ItemStack info= new ItemStack(Material.PAPER);
		    ItemMeta infom= info.getItemMeta();
		    infom.setDisplayName("§e Informações");
		    ArrayList<String>lore= new ArrayList<String>();
		    lore.add("");
		    lore.add("§aVips tem desconto em todos os kits da loja:");
		    lore.add("");
		    lore.add("§4§LBETA§7: 15%");
		    lore.add("§5§lLIGHT§7: 25% ");
		    lore.add("§d§lALPHA§7: 50% ");
		    infom.setLore(lore);
		    info.setItemMeta(infom);
		
	       inv.setItem(40, info);
			inv.setItem(19, itemID(106, 0, Main.ServerName, ""));
			inv.setItem(25, itemID(106, 0, Main.ServerName, ""));
			inv.setItem(28, itemID(106, 0, Main.ServerName, ""));
			inv.setItem(34, itemID(106, 0, Main.ServerName, ""));
			inv.setItem(29, new ItemStack(Material.AIR));
			inv.setItem(30, new ItemStack(Material.AIR));
			inv.setItem(31, new ItemStack(Material.AIR));
			inv.setItem(32, new ItemStack(Material.AIR));
			inv.setItem(33, new ItemStack(Material.AIR));
			inv.setItem(38, new ItemStack(Material.AIR));
			inv.setItem(39, new ItemStack(Material.AIR));

			inv.setItem(41, new ItemStack(Material.AIR));
			inv.setItem(42, new ItemStack(Material.AIR));
			
		
			
			p.openInventory(inv);
		}
		
	
}
