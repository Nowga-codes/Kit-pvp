package nowga.plugin.kitpvp.conexao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class MetodosLogin extends Connect{

	public static boolean containsPlayers(Player p) {
		try {
			stm = connection.prepareStatement("SELECT * FROM `login` WHERE `player` = ?");
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
	public static String getSenha(Player p) {
		if (containsPlayers(p) == true) {
			try {
				stm = connection.prepareStatement("SELECT * FROM `login` WHERE `player` = ?");
				stm.setString(1, p.getName());
				ResultSet rs = stm.executeQuery();
				
				while (rs.next()) {
					return rs.getString("senha");
				}
				
			} catch (SQLException e) {
				return "";
			}
			return "";
		}else {
			return "";
		}
	}
	
	
	public static void playerRegister(Player p, String senha) {
		if (containsPlayers(p) == true) {
			return;
		}else {
			try {
				stm = connection.prepareStatement("INSERT INTO `login`(`player`,`senha`) VALUES (?,?)");
				stm.setString(1, p.getName());
				stm.setString(2, senha);
				stm.executeUpdate();
				Bukkit.getConsoleSender().sendMessage("§6CRIADOO");
			} catch (SQLException e) {
				e.printStackTrace();
				Bukkit.getConsoleSender().sendMessage("§6NÂO CRIADOO");
			}
		}
	}
	
	public static void trocarSenha(Player p, String senhaNova) {
		if (containsPlayers(p) == true) {
			try {
				stm = connection.prepareStatement("UPDATE `login` SET `senha` = ? WHERE `player` = ?");
				stm.setString(1, senhaNova);
				stm.setString(2, p.getName());
				stm.executeUpdate();
				Bukkit.getConsoleSender().sendMessage("CRIADO!");
			} catch (SQLException e) {
		}
		}else {
			return;
		}
	}
	
}
