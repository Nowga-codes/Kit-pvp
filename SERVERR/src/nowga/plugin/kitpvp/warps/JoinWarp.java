package nowga.plugin.kitpvp.warps;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import nowga.plugin.kitpvp.Manager;
import nowga.plugin.kitpvp.conexao.MetodosWarps;
import nowga.plugin.kitpvp.kits.KITAPI;
import nowga.plugin.kitpvp.kits.KITS;

public class JoinWarp implements Listener{

	@EventHandler
	public void selecionar(InventoryClickEvent e) {
		Player p= (Player) e.getWhoClicked();
	
		if(e.getCurrentItem()== null)return;
		if(e.getInventory().getName().equalsIgnoreCase("Warps")) {
			e.setCancelled(true);
			if(e.getCurrentItem().getType()== Material.GLASS) {
			if(e.getClick().isLeftClick()) {
				
				if(!(MetodosWarps.containsWarp("fps"))) {
					p.sendMessage("§cArena fps não esta setada!");
					p.closeInventory();
					return;
				}
				p.closeInventory();
				p.sendMessage(KITAPI.prefix+" §7Você esta na warp fps, boa sorte ;)");
				Manager.sopas(p);
				p.getInventory().setArmorContents(null);
				p.getInventory().setItem(0, Manager.createiItem(Material.STONE_SWORD, "§aEspada"));
				WarpAPI.removeWarps(p);
				WarpAPI.contadorFps.add(p.getName());
			
				MetodosWarps.teleportWarpName(p, "fps");
				
			}
			}
			if(e.getCurrentItem().getType()== Material.LAVA_BUCKET) {
				if(e.getClick().isLeftClick()) {
					
					if(!(MetodosWarps.containsWarp("lava"))) {
						p.sendMessage("§cLava challenge não esta setada!");
						p.closeInventory();
						return;
					}
					p.closeInventory();
					p.sendMessage(KITAPI.prefix+" §7Você esta na warp Lava challenge, boa sorte ;)");
					Manager.sopas(p);
					p.getInventory().setArmorContents(null);
					WarpAPI.removeWarps(p);
		             WarpAPI.contadorLava.add(p.getName());
		             
						
		             MetodosWarps.teleportWarpName(p, "lava");
					
				}
				}
			if(e.getCurrentItem().getType()== Material.BLAZE_ROD) {
				if(e.getClick().isLeftClick()) {
					
					if(!(MetodosWarps.containsWarp("1v1"))) {
						p.sendMessage("§cArena 1v1 não esta setada!");
						p.closeInventory();
						return;
					}
					p.closeInventory();
					p.sendMessage(KITAPI.prefix+" §7Você esta na warp 1v1, boa sorte ;)");
					p.getInventory().setArmorContents(null);
					WarpAPI.removeWarps(p);
		             WarpAPI.contador1v1.add(p.getName());
		             WarpAPI.hotBar1v1(p);
						
		             MetodosWarps.teleportWarpName(p, "1v1");
				
				}
				}
			if(e.getCurrentItem().getType()== Material.POTION) {
				if(e.getClick().isLeftClick()) {
					
					if(!(MetodosWarps.containsWarp("potionpvp"))) {
						p.sendMessage("§cArena PotionPvP não esta setada!");
						p.closeInventory();
						
						return;
					}
					p.closeInventory();
					p.sendMessage(KITAPI.prefix+" §7Você esta na warp Potion PvP, boa sorte ;)");
					p.getInventory().setArmorContents(null);
					WarpAPI.removeWarps(p);
		             WarpAPI.contadorPotion.add(p.getName());
						
		             MetodosWarps.teleportWarpName(p, "potionpvp");
				
				}
				}
			if(e.getCurrentItem().getType()== Material.STICK) {
				if(e.getClick().isLeftClick()) {
					
					if(!(MetodosWarps.containsWarp("knock"))) {
						p.sendMessage("§cArena Knock não esta setada!");
						p.closeInventory();
						
						return;
					}
					p.closeInventory();
					p.sendMessage(KITAPI.prefix+" §7Você esta na warp Knock, boa sorte ;)");
					p.getInventory().setArmorContents(null);
					p.setHealth(p.getMaxHealth());
					WarpAPI.removeWarps(p);
		             WarpAPI.contadorKnock.add(p.getName());
		             
		            ItemStack palito = Manager.createiItemEnchantment(Material.STICK, "§aKnockBack", Enchantment.KNOCKBACK, 1);
						
		            p.getInventory().clear();
		            p.getInventory().setItem(0, palito);
		            p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 99*99*99, 2));
		             MetodosWarps.teleportWarpName(p, "knock");
				
				}
				}
		}
	}
}
