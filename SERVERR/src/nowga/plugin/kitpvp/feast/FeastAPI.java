package nowga.plugin.kitpvp.feast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import nowga.plugin.kitpvp.Config;
import nowga.plugin.kitpvp.Main;

public class FeastAPI {

	public static boolean feastStatus= true;
	public static Config config= new Config("feast.yml");
	static BukkitTask task;
	
	static boolean enquanto;
	
	public static ArrayList<ItemStack> itens= new ArrayList<ItemStack>() ;
	
	static ItemStack espadaFerro= new ItemStack(Material.IRON_SWORD);
	static ItemStack bota= new ItemStack(Material.LEATHER_BOOTS);
	static ItemStack capacete= new ItemStack(Material.LEATHER_HELMET);
	@SuppressWarnings("deprecation")
	static ItemStack instantDamage= new ItemStack(373,1,(short)16460);
	@SuppressWarnings("deprecation")
	static ItemStack encantamentoKnock= new ItemStack(403);
	
	public static void registerItensFeast() {
		itens.add(espadaFerro);
		itens.add(bota);
		itens.add(capacete);
		itens.add(instantDamage);
		itens.add(encantamentoKnock);
	}
	
	public static void setFeastLocation(Location bau1, Location bau2, Location bau3, Location bau4, Location bau5, Location bau6,
			Location bau7, Location bau8, Location bau9, Location bau10) {
		
		
		config.set("Bau1.X", bau1.getX());
		config.set("Bau1.Y", bau1.getY());
		config.set("Bau1.Z", bau1.getZ());
		
		config.set("Bau2.X", bau2.getX());
		config.set("Bau2.Y", bau2.getY());
		config.set("Bau2.Z", bau2.getZ());
		
		config.set("Bau3.X", bau3.getX());
		config.set("Bau3.Y", bau3.getY());
		config.set("Bau3.Z", bau3.getZ());
		
		config.set("Bau4.X", bau4.getX());
		config.set("Bau4.Y", bau4.getY());
		config.set("Bau4.Z", bau4.getZ());
		
		config.set("Bau5.X", bau5.getX());
		config.set("Bau5.Y", bau5.getY());
		config.set("Bau5.Z", bau5.getZ());
		
		config.set("Bau6.X", bau6.getX());
		config.set("Bau6.Y", bau6.getY());
		config.set("Bau6.Z", bau6.getZ());
		
		config.set("Bau7.X", bau7.getX());
		config.set("Bau7.Y", bau7.getY());
		config.set("Bau7.Z", bau7.getZ());
		
		config.set("Bau8.X", bau8.getX());
		config.set("Bau8.Y", bau8.getY());
		config.set("Bau8.Z",bau8.getZ());
		
		config.set("Bau9.X", bau9.getX());
		config.set("Bau9.Y", bau9.getY());
		config.set("Bau9.Z", bau9.getZ());
		
		config.set("Bau10.X", bau10.getX());
		config.set("Bau10.Y", bau10.getY());
		config.set("Bau10.Z", bau10.getZ());
		config.saveConfig();
		
	}
	
	public static void startCooldownFeast() {
		
		if(feastStatus == false)return;
		new BukkitRunnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		}.runTaskTimerAsynchronously(Main.plugin, 0, 20*300);
	}
	
	public static void setItensBau() {
		Double x1= (Double) config.get("Bau1.X");
		Double y1= (Double) config.get("Bau1.Y");
		Double z1= (Double) config.get("Bau1.Z");
		
		/*/
		 * Double x2= (Double) config.get("Bau2.X");
		Double y2= (Double) config.get("Bau2.Y");
		Double z2= (Double) config.get("Bau2.Z");

		Double x3= (Double) config.get("Bau3.X");
		Double y3= (Double) config.get("Bau3.Y");
		Double z3= (Double) config.get("Bau3.Z");
		
		Double x4= (Double) config.get("Bau4.X");
		Double y4= (Double) config.get("Bau4.Y");
		Double z4= (Double) config.get("Bau4.Z");
		
		Double x5= (Double) config.get("Bau5.X");
		Double y5= (Double) config.get("Bau5.Y");
		Double z5= (Double) config.get("Bau5.Z");
		
		Double x6= (Double) config.get("Bau6.X");
		Double y6= (Double) config.get("Bau6.Y");
		Double z6= (Double) config.get("Bau6.Z");
		
		Double x7= (Double) config.get("Bau7.X");
		Double y7= (Double) config.get("Bau7.Y");
		Double z7= (Double) config.get("Bau7.Z");
		
		Double x8= (Double) config.get("Bau8.X");
		Double y8= (Double) config.get("Bau8.Y");
		Double z8= (Double) config.get("Bau8.Z");
		
		Double x9= (Double) config.get("Bau9.X");
		Double y9= (Double) config.get("Bau9.Y");
		Double z9= (Double) config.get("Bau9.Z");
		
		Double x10= (Double) config.get("Bau10.X");
		Double y10= (Double) config.get("Bau10.Y");
		Double z10= (Double) config.get("Bau10.Z");
		
		 */
		
		
		try {
			
			
			Block bau1 = Bukkit.getWorld("world").getBlockAt(new Location(Bukkit.getWorld("world"), x1, y1, z1));
			
			 
			Chest chest1= (Chest) bau1.getState();
			
		enquanto= true;
		      int contagem= 7;
						while (chest1.getInventory().getContents().length== 0) {
							
							try {
								
								if(enquanto== true) {
									contagem ++;
									if(contagem == 7) {
										return;
									}
									
								Bukkit.broadcastMessage("VIADOO");
								Random r= new Random();
								int a= r.nextInt(itens.size());
								
								
								chest1.getInventory().addItem(itens.get(a));	
								
								}
							} catch (Exception e) {
							e.printStackTrace();
							}

						}
					
						
			chest1.update();
		} catch (Exception e) {
			// TODO: handle exception
		}
			
		
	}
	public static void setItensChest(Chest chest) {
	
	        task=	new BukkitRunnable() {
	        	
			int itensQuantia= 0;
			@Override
			public void run() {
				// TODO Auto-generated method stub
				itensQuantia ++;
				
				Random r= new Random();
				int a= r.nextInt(itens.size());
				
				if(itensQuantia ==7) {
					task.cancel();
				}
				
				chest.getInventory().addItem(itens.get(a));
				
			}
		}.runTaskTimerAsynchronously(Main.plugin, 0, 10);
		
		
	}
	
}
