package nowga.plugin.kitpvp.comandos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import nowga.plugin.kitpvp.Manager;



public class youtuber implements CommandExecutor{

	private ItemStack item(Material i,String name, String views) {
		
		ItemStack item= new ItemStack(i);
		ItemMeta itemM= item.getItemMeta();
		itemM.setDisplayName(name);
		ArrayList<String>lore= new ArrayList<String>();
		lore.add("");
		lore.add("§fRequesitos:");
		lore.add("");
		lore.add(" "+views+" §7Visualizações.");
		lore.add("");
		itemM.setLore(lore);
		item.setItemMeta(itemM);
		return item;
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] arg3) {
		if(!(sender instanceof Player))return true;
		if(cmd.getName().equalsIgnoreCase("yt")|| cmd.getName().equalsIgnoreCase("youtuber")) {
			
			Player p= (Player)sender;
			
			Inventory inv = Bukkit.createInventory(null, 2*9, "TAGS");
			
			
		   ItemStack vidroLaranja = Manager.createitemID(160, 1, "");
		   ItemStack vidro = Manager.createitemID(160, 0, "");
			
		   ItemStack info= new ItemStack(Material.PAPER);
			ItemMeta infom= info.getItemMeta();
			infom.setDisplayName("§eInformações");
			ArrayList<String> lore= new ArrayList<String>();
			lore.add("");
			lore.add(" §aClique para obter informações");
			infom.setLore(lore);
			info.setItemMeta(infom);
		   
			p.openInventory(inv);
			inv.setItem(0, vidroLaranja);
			inv.setItem(1, vidro);
			inv.setItem(2, item(Material.IRON_INGOT, "§f§lPRO", "§f30"));
			inv.setItem(4, item(Material.GOLD_INGOT, "§3§lYT", "§3100"));
			inv.setItem(13, info);
			inv.setItem(6, item(Material.DIAMOND, "§b§lYT+", "§b200"));
			
			inv.setItem(7, vidro);
			inv.setItem(8, vidroLaranja);
			
			inv.setItem(9, vidroLaranja);
			inv.setItem(10, vidro);
			inv.setItem(11, vidro);
			
			inv.setItem(15, vidro);
			inv.setItem(16, vidro);
			inv.setItem(17, vidroLaranja);
			
		}
		return false;
	}
	
}
