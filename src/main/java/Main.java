import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, SQLException {
        System.out.println("Ingrese el nombre de la ciudad a eliminar");
        Scanner scannerEliminar = new Scanner(System.in);
        String EliminarInput = scannerEliminar.nextLine();


        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/develop?user=root";

        Connection connection = DriverManager.getConnection(url);

        CallableStatement cs = connection.prepareCall("{call eliminar_ciudad1 (?)}");
        cs.setString(1,EliminarInput);

        int filasActualizadas = cs.executeUpdate();

        System.out.println("Filas Actualizadass: " + filasActualizadas);

        System.out.println("");
        System.out.println("-------------------------Todo Salio-------------------------");

    }
}
