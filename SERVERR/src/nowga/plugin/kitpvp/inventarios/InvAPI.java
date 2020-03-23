package nowga.plugin.kitpvp.inventarios;

import java.util.ArrayList;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import nowga.plugin.kitpvp.warps.WarpAPI;

public class InvAPI {


     //KITS PADRÃO
	public static ItemStack kitPvP= item(Material.STONE_SWORD, "§a§lKIT:§7 PvP", "§7Sem habilidades.");
	public static ItemStack kitViper= item(Material.SPIDER_EYE, "§a§lKIT:§7 Viper", "§7Ao golpear inimigo ele sera envenenado.");
	public static ItemStack kitKangaroo= item(Material.FIREWORK, "§a§lKIT:§7 Kangaroo", "§7Use boost jump para alcançar os oponentes.");
	public static ItemStack kitSnail= item(Material.SOUL_SAND, "§a§lKIT:§7 Snail", "§7Ao golpear inimigo ele recebe-ra lentidão.");
	public static ItemStack kitThor= item(Material.WOOD_AXE, "§a§lKIT:§7 Thor", "§7Solte um raio em seu oponente.");
	public static ItemStack kitSwitcher= item(Material.SNOW_BALL, "§a§lKIT:§7 Switcher", "§7Troque de lugar com seu oponente.");
	
	//KITS DA COMPRADOS
	public static ItemStack kitAnchor= item(Material.ANVIL, "§a§lKIT:§7 Anchor", "§7Não tome knockback.");
	public static ItemStack kitStomper= item(Material.IRON_BOOTS, "§a§lKIT:§7 Stomper", "§7Ao cair de um lugar alto, da um dano extremo nos inimigos por perto.");
	public static ItemStack kitAntiStomper= item(Material.DIAMOND_BOOTS, "§a§lKIT:§7 AntiStomper", "§7Não sofra dano de stomper.");
	public static ItemStack kitFisherman= item(Material.FISHING_ROD, "§a§lKIT:§7 Fisherman", "§7Puxe seus inimigos até você.");
	public static ItemStack kitGrappler= item(Material.LEASH, "§a§lKIT:§7 Grappler", "§7Se movimente mais rapido com esse laço.");
	public static ItemStack kitPoseidon= item(Material.WATER_BUCKET, "§a§lKIT:§7 Poseidon", "§7Fique mais forte na agua.");
	public static ItemStack kitUrgal= item(Material.REDSTONE, "§a§lKIT:§7 Urgal", "§7Você recebe forças inimaginaveis.");
	public static ItemStack kitQuickDropper= item(Material.BOWL, "§a§lKIT:§7 QuickDropper", "§7Dropa a sopa automaticamente após utiliza-la.");
	public static ItemStack kitMagma= item(Material.LAVA_BUCKET, "§a§lKIT:§7 Magma", "§7Não tome dano de lava e tenha chance de queimar o oponente.");
	public static ItemStack kitGladiator= item(Material.IRON_PLATE, "§a§lKIT:§7 Gladiator", "§7Prenda você e seu oponente em uma arena flutuante.");
	
	
	//KITS LOJA
	public static ItemStack kitAnchorLOJA= itemLojaID(145, 0, "§a§lKIT:§7 Anchor", "§7Não tome knockback.", 7500);
	public static ItemStack kitStomperLOJA= itemLojaID(309, 0, "§a§lKIT:§7 Stomper", "§7Ao cair de um lugar alto, da um dano extremo nos inimigos por perto.", 12000);
	public static ItemStack kitAntiStomperLOJA= itemLojaID(313, 0, "§a§lKIT:§7 AntiStomper", "§7Não sofra dano de stomper.", 6000);
	public static ItemStack kitFishermanLOJA= itemLojaID(346, 0, "§a§lKIT:§7 Fisherman", "§7Puxe seus inimigos até você.", 7000);
	public static ItemStack kitGrapplerLOJA= itemLojaID(420, 0, "§a§lKIT:§7 Grappler", "§7Se movimente mais rapido com esse laço.", 8500);
	public static ItemStack kitPoseidonLOJA= itemLojaID(326, 0, "§a§lKIT:§7 Poseidon", "§7Fique mais forte na agua.", 5000);
	public static ItemStack kitUrgalLOJA= itemLojaID(331, 0, "§a§lKIT:§7 Urgal", "§7Você recebe forças inimaginaveis.", 9000);
	public static ItemStack kitQuickDropperLOJA= itemLojaID(281, 0, "§a§lKIT:§7 QuickDropper", "§7Dropa a sopa automaticamente após utiliza-la.", 4000);
	public static ItemStack kitMagmaLOJA= itemLojaID(327, 0, "§a§lKIT:§7 Magma", "§7Não tome dano de lava e tenha chance de queimar o oponente.", 5000);
	public static ItemStack kitGladiatorLOJA= itemLojaID(101, 0, "§a§lKIT:§7 Gladiator", "§7Prenda você e seu oponente em uma arena flutuante.", 100000);

	public static ItemStack kitAnchorCOMPRADOLOJA= itemLojaCOMPRADOID(145, 0, "§a§lKIT:§7 Anchor", "§7Não tome knockback.");
	public static ItemStack kitStomperCOMPRADOLOJA= itemLojaCOMPRADOID(309, 0, "§a§lKIT:§7 Stomper", "§7Ao cair de um lugar alto, da um dano extremo nos inimigos por perto.");
	public static ItemStack kitAntiStomperCOMPRADOLOJA= itemLojaCOMPRADOID(313, 0, "§a§lKIT:§7 AntiStomper", "§7Não sofra dano de stomper.");
	public static ItemStack kitFishermanCOMPRADOLOJA= itemLojaCOMPRADOID(346, 0, "§a§lKIT:§7 Fisherman", "§7Puxe seus inimigos até você.");
	public static ItemStack kitGrapplerCOMPRADOLOJA= itemLojaCOMPRADOID(420, 0, "§a§lKIT:§7 Grappler", "§7Se movimente mais rapido com esse laço.");
	public static ItemStack kitPoseidonCOMPRADOLOJA= itemLojaCOMPRADOID(326, 0, "§a§lKIT:§7 Poseidon", "§7Fique mais forte na agua.");
	public static ItemStack kitUrgalCOMPRADOLOJA= itemLojaCOMPRADOID(331, 0, "§a§lKIT:§7 Urgal", "§7Você recebe forças inimaginaveis.");
	public static ItemStack kitQuickDropperCOMPRADOLOJA= itemLojaCOMPRADOID(281, 0, "§a§lKIT:§7 QuickDropper", "§7Dropa a sopa automaticamente após utiliza-la.");
	public static ItemStack kitMagmaCOMPRADOLOJA= itemLojaCOMPRADOID(327, 0, "§a§lKIT:§7 Magma", "§7Não tome dano de lava e tenha chance de queimar o oponente.");
	public static ItemStack kitGladiatorCOMPRADOLOJA= itemLojaCOMPRADOID(101, 0, "§a§lKIT:§7 Gladiator", "§7Prenda você e seu oponente em uma arena flutuante.");
	
	public static ItemStack itemWarp(Material material, String name, String descricao, ArrayList<String> warp) {
		ItemStack i= new ItemStack(material);
		ItemMeta imeta= i.getItemMeta();
		imeta.setDisplayName(name);
		ArrayList<String> lore= new ArrayList<String>();
		lore.add("");
		lore.add(descricao);
		lore.add("");
		lore.add("§aJogadores: §7" +warp.size());
		imeta.setLore(lore);
		i.setItemMeta(imeta);
		return i;
	}
	
	public static ItemStack item(Material material, String name, String descricao) {
		ItemStack i= new ItemStack(material);
		ItemMeta imeta= i.getItemMeta();
		imeta.setDisplayName(name);
		ArrayList<String> lore= new ArrayList<String>();
		lore.add("");
		lore.add(descricao);
		imeta.setLore(lore);
		i.setItemMeta(imeta);
		
		return i;
	}
	public static ItemStack itemID(int id, int idshort, String name, String descricao) {

		@SuppressWarnings("deprecation")
		ItemStack i= new ItemStack(id, 1,(short) idshort);
		ItemMeta imeta= i.getItemMeta();
		imeta.setDisplayName(name);
		ArrayList<String> lore= new ArrayList<String>();
		lore.add("");
		lore.add(descricao);
		imeta.setLore(lore);
		i.setItemMeta(imeta);
		
		return i;
	}
	public static ItemStack itemLojaID(int id, int idshort, String name, String descricao, int valor) {
		
		@SuppressWarnings("deprecation")
		ItemStack i= new ItemStack(id, 1,(short) idshort);
		ItemMeta imeta= i.getItemMeta();
		imeta.setDisplayName(name);
		ArrayList<String> lore= new ArrayList<String>();
		lore.add("");
		lore.add(descricao);
		lore.add("");
		lore.add("§7Preço: §a"+valor);
		imeta.setLore(lore);
		i.setItemMeta(imeta);
		
		return i;
	}
public static ItemStack itemLojaCOMPRADOID(int id, int idshort, String name, String descricao) {
		
		@SuppressWarnings("deprecation")
		ItemStack i= new ItemStack(id, 1,(short) idshort);
		ItemMeta imeta= i.getItemMeta();
		imeta.setDisplayName(name);
		ArrayList<String> lore= new ArrayList<String>();
		lore.add("");
		lore.add(descricao);
		lore.add("");
		lore.add("§c§lCOMPRADO!");
		imeta.setLore(lore);
		i.setItemMeta(imeta);
		
		return i;
	}
	
}
