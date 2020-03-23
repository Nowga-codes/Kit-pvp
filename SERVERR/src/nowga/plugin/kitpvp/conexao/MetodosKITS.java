package nowga.plugin.kitpvp.conexao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class MetodosKITS extends Connect{

	public static boolean containsPlayers(Player p) {
		try {
			stm = connection.prepareStatement("SELECT * FROM `kits` WHERE `player` = ?");
			stm.setString(1, p.getName());
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				return true;
			}
			
			return false;
		} catch (SQLException e) {
			return false;
		}
			
	}
	
	
	
	public static boolean containsKIT(Player p, String kit) {
		if (containsPlayers(p) == true) {
			try {
				stm = connection.prepareStatement("SELECT * FROM `kits` WHERE `player` = ?");
				stm.setString(1, p.getName());
				ResultSet rs = stm.executeQuery();
				
				while (rs.next()) {
					if(rs.getBoolean(kit)== true)return true;	
					
				}
				
			} catch (SQLException e) {
				return false;
			}
			return false;
		}else {
			return false;
		}
	}
	
	public static void comprarKIT(Player p, String kit) {
		if (containsPlayers(p) == true) {
			try {
				stm = connection.prepareStatement("UPDATE `kits` SET `"+kit+"` = ? WHERE `player` = ?");
				stm.setBoolean(1, true);
				stm.setString(2, p.getName());
				stm.executeUpdate();
				Bukkit.getConsoleSender().sendMessage("CRIADO!");
			} catch (SQLException e) {
		}
		}else {
			return;
		}
	}
	

	public static void RegisterKITS(Player p) {
		if (containsPlayers(p) == true) {
			return;
		}else {
			try {
				stm = connection.prepareStatement("INSERT INTO `kits`(`player`,`Stomper`, `AntiStomper`, `Anchor`, `Fisherman`, `Grappler`, `Poseidon`, `Urgal`, `QuickDropper`, `Magma`) VALUES (?,?,?,?,?,?,?,?,?,?)");
				stm.setString(1, p.getName());
				stm.setBoolean(2, false);
				stm.setBoolean(3, false);
				stm.setBoolean(4, false);
				stm.setBoolean(5, false);
				stm.setBoolean(6, false);
				stm.setBoolean(7, false);
				stm.setBoolean(8, false);
				stm.setBoolean(9, false);
				stm.setBoolean(10, false);
				stm.executeUpdate();
				Bukkit.getConsoleSender().sendMessage("§6CRIADOO");
			} catch (SQLException e) {
				e.printStackTrace();
				Bukkit.getConsoleSender().sendMessage("§6NÂO CRIADOO");
			}
		}
	}
	
}
