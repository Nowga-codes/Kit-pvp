package nowga.plugin.kitpvp.kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import nowga.plugin.kitpvp.Manager;
import nowga.plugin.kitpvp.conexao.MetodosWarps;

public class SelecionarKit implements Listener{

	
	@EventHandler
	public void selecionar(InventoryClickEvent e) {
		Player p= (Player) e.getWhoClicked();
	
		if(e.getCurrentItem()== null)return;
		if(e.getInventory().getName().equalsIgnoreCase("Kits")) {
			if(e.getCurrentItem().getType()== Material.STONE_SWORD) {
			if(e.getClick().isLeftClick()) {
				
				p.closeInventory();
				p.sendMessage(KITAPI.prefix+" §7Kit pvp selecionado, boa sorte ;)");
				Manager.sopas(p);
				p.getInventory().setArmorContents(null);
				p.getInventory().setItem(0, Manager.createiItem(Material.STONE_SWORD, "§aEspada"));
				KITAPI.setKit(p, KITS.PvP);	
				KITAPI.contadorArena.add(p.getName());
				Manager.teleportArena(p);
			}
			}
			if(e.getCurrentItem().getType()== Material.FIREWORK) {
				if(e.getClick().isLeftClick()) {
					
					p.closeInventory();
					p.sendMessage(KITAPI.prefix+" §7Kit Kangaroo selecionado, boa sorte ;)");
					Manager.sopas(p);
					p.getInventory().setArmorContents(null);
					p.getInventory().setItem(0, Manager.createiItem(Material.STONE_SWORD, "§aEspada"));
					p.getInventory().setItem(1, Manager.createiItem(Material.FIREWORK, "§aFoguete"));
					KITAPI.setKit(p, KITS.KANGAROO);
					KITAPI.contadorArena.add(p.getName());
		           	Manager.teleportArena(p);
					
				}
					
				}
			if(e.getCurrentItem().getType()== Material.WOOD_AXE) {
				if(e.getClick().isLeftClick()) {
					
					p.closeInventory();
					p.sendMessage(KITAPI.prefix+" §7Kit Thor selecionado, boa sorte ;)");
					Manager.sopas(p);
					p.getInventory().setArmorContents(null);
					p.getInventory().setItem(0, Manager.createiItem(Material.STONE_SWORD, "§aEspada"));
					p.getInventory().setItem(1, Manager.createiItem(Material.WOOD_AXE, "§aMjolnir"));
					KITAPI.setKit(p, KITS.THOR);
					KITAPI.contadorArena.add(p.getName());
					Manager.teleportArena(p);
					
				}
					
				}
			if(e.getCurrentItem().getType()== Material.SPIDER_EYE) {
				if(e.getClick().isLeftClick()) {
					
					p.closeInventory();
					p.sendMessage(KITAPI.prefix+" §7Kit Viper selecionado, boa sorte ;)");
					Manager.sopas(p);
					p.getInventory().setArmorContents(null);
					p.getInventory().setItem(0, Manager.createiItem(Material.STONE_SWORD, "§aEspada"));
					KITAPI.setKit(p, KITS.VIPER);
					KITAPI.contadorArena.add(p.getName());
					Manager.teleportArena(p);
				}
					
				}
			if(e.getCurrentItem().getType()== Material.SOUL_SAND) {
				if(e.getClick().isLeftClick()) {
					
					p.closeInventory();
					p.sendMessage(KITAPI.prefix+" §7Kit Snail selecionado, boa sorte ;)");
					Manager.sopas(p);
					p.getInventory().setArmorContents(null);
					p.getInventory().setItem(0, Manager.createiItem(Material.STONE_SWORD, "§aEspada"));
					KITAPI.setKit(p, KITS.SNAIL);
					KITAPI.contadorArena.add(p.getName());
					Manager.teleportArena(p);
				}
					
				}
			if(e.getCurrentItem().getType()== Material.SNOW_BALL) {
				if(e.getClick().isLeftClick()) {
					
					p.closeInventory();
					p.sendMessage(KITAPI.prefix+" §7Kit Switcher selecionado, boa sorte ;)");
					Manager.sopas(p);
					p.getInventory().setArmorContents(null);
					p.getInventory().setItem(0, Manager.createiItem(Material.STONE_SWORD, "§aEspada"));
					p.getInventory().setItem(1, Manager.createiItem(Material.SNOW_BALL, "§aSwitcher"));
					KITAPI.setKit(p, KITS.SWHITCHER);
					KITAPI.contadorArena.add(p.getName());
					Manager.teleportArena(p);
				}
					
				}
			if(e.getCurrentItem().getType()== Material.BOWL) {
				if(e.getClick().isLeftClick()) {
					
					p.closeInventory();
					p.sendMessage(KITAPI.prefix+" §7Kit QuickDropper selecionado, boa sorte ;)");
					Manager.sopas(p);
					p.getInventory().setArmorContents(null);
					p.getInventory().setItem(0, Manager.createiItem(Material.STONE_SWORD, "§aEspada"));
					KITAPI.setKit(p, KITS.QUICKDROPPER);
					KITAPI.contadorArena.add(p.getName());
					Manager.teleportArena(p);
				}
					
				}
			if(e.getCurrentItem().getType()== Material.FISHING_ROD) {
				if(e.getClick().isLeftClick()) {
					
					p.closeInventory();
					p.sendMessage(KITAPI.prefix+" §7Kit FisherMan selecionado, boa sorte ;)");
					Manager.sopas(p);
					p.getInventory().setArmorContents(null);
					p.getInventory().setItem(0, Manager.createiItem(Material.STONE_SWORD, "§aEspada"));
					p.getInventory().setItem(1, Manager.createiItem(Material.FISHING_ROD, "§aVara"));
					KITAPI.setKit(p, KITS.FISHERMAN);
					KITAPI.contadorArena.add(p.getName());
					Manager.teleportArena(p);
				}
					
				}
			if(e.getCurrentItem().getType()== Material.IRON_BOOTS) {
				if(e.getClick().isLeftClick()) {
					
					p.closeInventory();
					p.sendMessage(KITAPI.prefix+" §7Kit Stomper selecionado, boa sorte ;)");
					Manager.sopas(p);
					p.getInventory().setArmorContents(null);
					p.getInventory().setItem(0, Manager.createiItem(Material.STONE_SWORD, "§aEspada"));
					KITAPI.setKit(p, KITS.STOMPER);
					KITAPI.contadorArena.add(p.getName());
					Manager.teleportArena(p);
				}
					
				}
			if(e.getCurrentItem().getType()== Material.DIAMOND_BOOTS) {
				if(e.getClick().isLeftClick()) {
					
					p.closeInventory();
					p.sendMessage(KITAPI.prefix+" §7Kit Anti Stomper selecionado, boa sorte ;)");
					Manager.sopas(p);
					p.getInventory().setArmorContents(null);
					p.getInventory().setItem(0, Manager.createiItem(Material.STONE_SWORD, "§aEspada"));
					KITAPI.setKit(p, KITS.ANTISTOMPER);
					KITAPI.contadorArena.add(p.getName());
					Manager.teleportArena(p);
				}
					
				}
			if(e.getCurrentItem().getType()== Material.ANVIL) {
				if(e.getClick().isLeftClick()) {
					
					p.closeInventory();
					p.sendMessage(KITAPI.prefix+" §7Kit Anchor selecionado, boa sorte ;)");
					Manager.sopas(p);
					p.getInventory().setArmorContents(null);
					p.getInventory().setItem(0, Manager.createiItem(Material.STONE_SWORD, "§aEspada"));
					KITAPI.setKit(p, KITS.ANCHOR);
					KITAPI.contadorArena.add(p.getName());
					Manager.teleportArena(p);
				}
				
					
				}
			if(e.getCurrentItem().getTypeId() == 420) {
				if(e.getClick().isLeftClick()) {
					
					p.closeInventory();
					p.sendMessage(KITAPI.prefix+" §7Kit Grappler selecionado, boa sorte ;)");
					Manager.sopas(p);
					p.getInventory().setArmorContents(null);
					p.getInventory().setItem(0, Manager.createiItem(Material.STONE_SWORD, "§aEspada"));
					p.getInventory().setItem(1, Manager.createitemID(420, 0, "§aLaço"));
					KITAPI.setKit(p, KITS.GRAPPLER);
					KITAPI.contadorArena.add(p.getName());
					Manager.teleportArena(p);
				}
					
				}
			if(e.getCurrentItem().getType()== Material.WATER_BUCKET) {
				if(e.getClick().isLeftClick()) {
					
					p.closeInventory();
					p.sendMessage(KITAPI.prefix+" §7Kit Poseidon selecionado, boa sorte ;)");
					Manager.sopas(p);
					p.getInventory().setArmorContents(null);
					p.getInventory().setItem(0, Manager.createiItem(Material.STONE_SWORD, "§aEspada"));
					KITAPI.setKit(p, KITS.POSEIDON);
					p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 99*99*99, 1));
					KITAPI.contadorArena.add(p.getName());
					Manager.teleportArena(p);
				}
				}
			if(e.getCurrentItem().getType()== Material.REDSTONE) {
				if(e.getClick().isLeftClick()) {
					
					p.closeInventory();
					p.sendMessage(KITAPI.prefix+" §7Kit Urgal selecionado, boa sorte ;)");
					Manager.sopas(p);
					p.getInventory().setArmorContents(null);
					p.getInventory().setItem(0, Manager.createiItem(Material.STONE_SWORD, "§aEspada"));
					p.getInventory().setItem(1, Manager.createiItem(Material.REDSTONE, "§aUrgal"));
					KITAPI.setKit(p, KITS.URGAL);
					KITAPI.contadorArena.add(p.getName());
					Manager.teleportArena(p);
				}
				
				}
			if(e.getCurrentItem().getType()== Material.LAVA_BUCKET) {
				if(e.getClick().isLeftClick()) {
					
					p.closeInventory();
					p.sendMessage(KITAPI.prefix+" §7Kit Magma selecionado, boa sorte ;)");
					Manager.sopas(p);
					p.getInventory().setArmorContents(null);
					p.getInventory().setItem(0, Manager.createiItem(Material.STONE_SWORD, "§aEspada"));
					p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 99*99*99, 1));
					KITAPI.setKit(p, KITS.MAGMA);
					KITAPI.contadorArena.add(p.getName());
					Manager.teleportArena(p);
				}
				}
			
			
			e.setCancelled(true);
		}
	}
}
