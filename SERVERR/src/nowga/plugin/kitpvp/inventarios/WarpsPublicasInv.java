package nowga.plugin.kitpvp.inventarios;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import nowga.plugin.kitpvp.warps.WarpAPI;

public class WarpsPublicasInv extends InvAPI{

	
	public static void inventario(Player p) {
		Inventory inv= Bukkit.createInventory(null, 4*9, "Warps");
		
		inv.setItem(11, itemWarp(Material.LAVA_BUCKET, "§6Lava Challenge", "§7Vá o mais longe que puder.",WarpAPI.contadorLava));
		inv.setItem(12, itemWarp(Material.GLASS, "§6Fps", "§7Para jogadores que não possuem um computador muito bom.",WarpAPI.contadorFps));
		inv.setItem(13, itemWarp(Material.BLAZE_ROD, "§61V1", "§7Entre em desafios com outros jogadores.",WarpAPI.contador1v1));
		inv.setItem(14, itemWarp(Material.POTION, "§6PotionPvP", "§7Batalhe com poções de regeneração.",WarpAPI.contadorPotion));
		inv.setItem(15, itemWarp(Material.STICK, "§6Knock", "§7Jogue seus inimigos para fora do ringue.",WarpAPI.contadorKnock));
		inv.setItem(22, item(Material.APPLE, "§6Sumo", "§cEm desenvolvimento!"));
		
		p.openInventory(inv);
			
	}
	
	
}
