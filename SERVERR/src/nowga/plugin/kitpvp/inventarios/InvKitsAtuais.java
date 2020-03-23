package nowga.plugin.kitpvp.inventarios;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import nowga.plugin.kitpvp.Main;
import nowga.plugin.kitpvp.Permissions;
import nowga.plugin.kitpvp.conexao.MetodosKITS;
import nowga.plugin.kitpvp.kits.KITAPI;

public class InvKitsAtuais extends InvAPI{

	public static void inventario(Player p) {
	Inventory inv= Bukkit.createInventory(null, 6*9, "Kits");
	
		for(int i= 0; i< 54; i ++) {
			inv.setItem(i, itemID(160, 11, Main.ServerName, ""));
		}
		
		inv.setItem(11, kitPvP);
		inv.setItem(12, kitViper);
		inv.setItem(13, kitKangaroo);
		inv.setItem(14, kitSnail);
		inv.setItem(15, kitThor);
		inv.setItem(20, kitSwitcher);
	
		
		inv.setItem(49, item(Material.PAPER, "          §e§lDADOS", "§aPlayers na arena PvP:§7 "+ KITAPI.contadorArena.size()));
		inv.setItem(19, itemID(106, 0, Main.ServerName, ""));
		inv.setItem(25, itemID(106, 0, Main.ServerName, ""));
		inv.setItem(28, itemID(106, 0, Main.ServerName, ""));
		inv.setItem(34, itemID(106, 0, Main.ServerName, ""));
		inv.setItem(21, new ItemStack(Material.AIR));
		inv.setItem(22, new ItemStack(Material.AIR));
		inv.setItem(23, new ItemStack(Material.AIR));
		inv.setItem(24, new ItemStack(Material.AIR));
		inv.setItem(29, new ItemStack(Material.AIR));
		inv.setItem(30, new ItemStack(Material.AIR));
		inv.setItem(31, new ItemStack(Material.AIR));
		inv.setItem(32, new ItemStack(Material.AIR));
		inv.setItem(33, new ItemStack(Material.AIR));
		inv.setItem(38, new ItemStack(Material.AIR));
		inv.setItem(39, new ItemStack(Material.AIR));
		inv.setItem(40, new ItemStack(Material.AIR));
		inv.setItem(41, new ItemStack(Material.AIR));
		inv.setItem(42, new ItemStack(Material.AIR));
		
		if(MetodosKITS.containsKIT(p, "Anchor")) {inv.addItem(kitAnchor);}
		if(MetodosKITS.containsKIT(p, "Stomper")) { inv.addItem(kitStomper);}
		if(MetodosKITS.containsKIT(p, "AntiStomper")) { inv.addItem(kitAntiStomper);}
		if(MetodosKITS.containsKIT(p, "Fisherman")) { inv.addItem(kitFisherman);}
		if(MetodosKITS.containsKIT(p, "Grappler")) { inv.addItem(kitGrappler);}
		if(MetodosKITS.containsKIT(p, "Poseidon")) { inv.addItem(kitPoseidon);}
		if(MetodosKITS.containsKIT(p, "Urgal")) { inv.addItem(kitUrgal);}
		if(MetodosKITS.containsKIT(p, "QuickDropper")) { inv.addItem(kitQuickDropper);}
		if(MetodosKITS.containsKIT(p, "Magma")) {inv.addItem(kitMagma);}
		if(MetodosKITS.containsKIT(p, "Gladiator")) { inv.addItem(kitGladiator);}
		
		p.openInventory(inv);
	}
	
}
