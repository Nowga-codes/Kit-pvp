package nowga.plugin.kitpvp.conexao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import nowga.plugin.kitpvp.warps.CreateWarp;

public class MetodosWarps extends Connect{
	
	public static boolean containsWarp(String warp) {
		try {
			stm = connection.prepareStatement("SELECT * FROM `warps` WHERE `warp` = ?");
			stm.setString(1, warp);
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				return true;
			}
			
			return false;
		} catch (SQLException e) {
			return false;
		}
			
	}
	

	 public static void deleteWarp(String warpName) {
		 if (containsWarp(warpName) == true) {
		 try {
	        	stm= connection.prepareStatement("DELETE FROM `warps` WHERE `warp`= '"+warpName+"';");
	        	stm.executeUpdate();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		 }
	 }
	
	public static void setWarp(String warpName, Double x, Double y, Double z, float yaw, float pitch) {

			try {
				stm = connection.prepareStatement("INSERT INTO `warps`(`warp`,`x`,`y`,`z`,`yaw`, `pitch`) VALUES (?,?,?,?,?,?)");
				stm.setString(1, warpName);
				stm.setDouble(2, x);
				stm.setDouble(3, y);
				stm.setDouble(4, z);
				stm.setFloat(5, yaw);
				stm.setFloat(6, pitch);
				stm.executeUpdate();
				Bukkit.getConsoleSender().sendMessage("§6CRIADOO");
			} catch (SQLException e) {
				e.printStackTrace();
				Bukkit.getConsoleSender().sendMessage("§6NÂO CRIADOO");
			}
		}
	public static void teleportWarpName(Player p, String warpName) {
		if (containsWarp(warpName) == true) {
			try {
				stm = connection.prepareStatement("SELECT * FROM `warps` WHERE `warp` = ?");
				stm.setString(1, warpName);
				ResultSet rs = stm.executeQuery();
				
				while (rs.next()) {
					double x= rs.getDouble("x");
					double y= rs.getDouble("y");
					double z= rs.getDouble("z");
					float yaw= rs.getFloat("yaw");
					float pitch= rs.getFloat("pitch");
					
					p.teleport(new Location(p.getWorld(), x, y, z, yaw, pitch));
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}else {
			
		}
	}
	
	public static double getWarpXYZ(String warpName, String coluna) {
		if (containsWarp(warpName) == true) {
			try {
				stm = connection.prepareStatement("SELECT * FROM `warps` WHERE `warp` = ?");
				stm.setString(1, warpName);
				ResultSet rs = stm.executeQuery();
				
				while (rs.next()) {
					return rs.getDouble(coluna);
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}else {
			
		}
		return 0;
	}
	
	public static void getWarps( Player p) {
	
			try {
				stm = connection.prepareStatement("SELECT `warp` FROM `warps`");
				ResultSet rs = stm.executeQuery();
				
				while (rs.next()) {
					p.sendMessage("§f      "+rs.getString("warp"));
				}
				
			} catch (SQLException e) {
				
			}
			
		}
	
}
