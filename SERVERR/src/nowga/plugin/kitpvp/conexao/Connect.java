package nowga.plugin.kitpvp.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.bukkit.Bukkit;


public class Connect {
  
	private static String url,user,password,urlLocal, userLocal, passwordLocal;
	public static Connection connection;
	public static PreparedStatement stm;
	
	public static void open() {
	
		//Usar quando for testar pls no localhost
		url = "jdbc:mysql://localhost:3306/thundermc";
		user = "root";
		password = "";
		
		try {
			connection = DriverManager.getConnection(url, user, password);
	
			Bukkit.getConsoleSender().sendMessage("§cABRIU");
			createTable();
			createTableLogin();
			createTableKits();
			createTableWarps();
			MotodosPunir.createTableBans();
			MotodosPunir.createTableBansIP();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Bukkit.getConsoleSender().sendMessage("§cNAO ABRIU");
		}
		
	}
	
	public static void createTable() {
		if(connection == null) {
			Bukkit.getConsoleSender().sendMessage("§cNAO ABRIU TABLE");
			return;
		}
			try {
				stm= connection.prepareStatement("CREATE TABLE IF NOT EXISTS `jogadores`(`player` VARCHAR(25), `kills` INT NOT NULL, `deaths` INT NOT NULL, `coins` INT NOT NULL, `xp` INT NOT NULL, `ip` VARCHAR(25), `wins` INT NOT NULL, `loses` INT NOT NULL)");
				stm.executeUpdate();
				Bukkit.getConsoleSender().sendMessage("§a A tabela Jogadores foi carregada com sucesso!");
			} catch (SQLException e) {
				e.printStackTrace();
				Bukkit.getConsoleSender().sendMessage("§7 Não foi possível criar a tabela!");
			}
		
	}
	public static void createTableLogin() {
		if(connection == null) {
			Bukkit.getConsoleSender().sendMessage("§cNAO ABRIU TABLE");
			return;
		}
			try {
				stm= connection.prepareStatement("CREATE TABLE IF NOT EXISTS `login`(`player` VARCHAR(25), `senha` VARCHAR(25))");
				stm.executeUpdate();
				Bukkit.getConsoleSender().sendMessage("§a A tabela Login foi carregada com sucesso!");
			} catch (SQLException e) {
				e.printStackTrace();
				Bukkit.getConsoleSender().sendMessage("§7 Não foi possível criar a tabela!");
			}
		
	}
	public static void createTableKits() {
		if(connection == null) {
			Bukkit.getConsoleSender().sendMessage("§cNAO ABRIU TABLE");
			return;
		}
			try {
				stm= connection.prepareStatement("CREATE TABLE IF NOT EXISTS `kits`(`player` VARCHAR(25), `Stomper` BOOLEAN, `AntiStomper` BOOLEAN, `Anchor` BOOLEAN"
						+ ", `Fisherman` BOOLEAN, `Grappler` BOOLEAN, `Poseidon` BOOLEAN, `Urgal` BOOLEAN, `QuickDropper` BOOLEAN, `Magma` BOOLEAN)");
				stm.executeUpdate();
				Bukkit.getConsoleSender().sendMessage("§a A tabela Kits foi carregada com sucesso!");
			} catch (SQLException e) {
				e.printStackTrace();
				Bukkit.getConsoleSender().sendMessage("§7 Não foi possível criar a tabela!");
			}
		
	}
	public static void createTableWarps() {
		if(connection == null) {
			Bukkit.getConsoleSender().sendMessage("§cNAO ABRIU TABLE");
			return;
		}

			try {
				stm= connection.prepareStatement("CREATE TABLE IF NOT EXISTS `warps`(`warp` VARCHAR(25), `x` DOUBLE, `y` DOUBLE, `z` DOUBLE, `yaw` FLOAT, `pitch` FLOAT)");
				stm.executeUpdate();
				Bukkit.getConsoleSender().sendMessage("§a A tabela Warps foi carregada com sucesso!");
			} catch (SQLException e) {
				e.printStackTrace();
				Bukkit.getConsoleSender().sendMessage("§7 Não foi possível criar a tabela!");
			}
		
	}
	
}
