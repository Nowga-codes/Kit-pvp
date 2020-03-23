package nowga.plugin.kitpvp.comandos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import nowga.plugin.kitpvp.Manager;

public class Formularios implements CommandExecutor{

	private static ItemStack item(int id,int durability,String name) {
		
		@SuppressWarnings("deprecation")
		ItemStack item= new ItemStack(id,1,(short)durability);
		ItemMeta itemM= item.getItemMeta();
		itemM.setDisplayName(name);
		ArrayList<String>lore= new ArrayList<String>();
		lore.add("");
		lore.add(" §aClique para obter o link.");
		lore.add("");
		itemM.setLore(lore);
		item.setItemMeta(itemM);
		return item;
		
	}
	public static ItemStack Builder= item(35, 0, "§f§lBUILDER");;
	public static ItemStack Trial= item(35, 3, "§9§lTRIAL");
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] arg3) {
		if(!(sender instanceof Player))return true;
		if(cmd.getName().equalsIgnoreCase("aplicar")) {
			
			Player p= (Player)sender;
			
			Inventory inv = Bukkit.createInventory(null, 1*9, "FORMULARIOS");
			
			
		   ItemStack vidroLaranja = Manager.createitemID(160, 1, "");
		   ItemStack vidro = Manager.createitemID(160, 0, "");
			
			p.openInventory(inv);
			inv.setItem(0, vidroLaranja);
			inv.setItem(1, vidro);
			inv.setItem(2, vidro);
			
			
			inv.setItem(3, Builder);
			inv.setItem(5, Trial);
			
			inv.setItem(6, vidro);	
			inv.setItem(7, vidro);
			inv.setItem(8, vidroLaranja);
			
		}
		return false;
	}
	
}
