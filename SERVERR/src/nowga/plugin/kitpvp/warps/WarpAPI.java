package nowga.plugin.kitpvp.warps;

import java.util.ArrayList;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import nowga.plugin.kitpvp.Manager;

public class WarpAPI {

	public static ArrayList<String> contadorFps= new ArrayList<String>();
	public static ArrayList<String> contadorLava= new ArrayList<String>();
	public static ArrayList<String> contador1v1= new ArrayList<String>();
	public static ArrayList<String> contadorPotion= new ArrayList<String>();
	public static ArrayList<String> contadorKnock= new ArrayList<String>();
	public static ArrayList<String> contadorSumo= new ArrayList<String>();
	
	
	public static void removeWarps(Player p) {
		
		if(contadorFps.contains(p.getName())) {
			contadorFps.remove(p.getName());
		}
		if(contadorLava.contains(p.getName())) {
			contadorLava.remove(p.getName());
		}
		if(contador1v1.contains(p.getName())) {
			contador1v1.remove(p.getName());
		}
		if(contadorPotion.contains(p.getName())) {
			contadorPotion.remove(p.getName());
		}
		if(contadorKnock.contains(p.getName())) {
			contadorKnock.remove(p.getName());
		}
		if(contadorSumo.contains(p.getName())) {
			contadorSumo.remove(p.getName());
		}
		
	}
	
	public static void hotBar1v1(Player p) {
		
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
		p.setGameMode(GameMode.SURVIVAL);
		
		ItemStack info= new ItemStack(Material.SKULL_ITEM);
	    SkullMeta infom= (SkullMeta) info.getItemMeta();
		infom.setOwner(p.getName());
		infom.setDisplayName("§eInformações");
		info.setItemMeta(infom);
	    
	    
        p.getInventory().setItem(2,Manager.createiItem(Material.BLAZE_ROD, "§6Desafiar"));
        p.getInventory().setItem(6, Manager.createitemID(351, 8, "§aDesafio rapido"));
        p.getInventory().setItem(4, info);
	}
	
}
