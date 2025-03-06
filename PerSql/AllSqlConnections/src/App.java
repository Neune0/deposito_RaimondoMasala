import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}

// la classe va instanziata, per otterene la connesione al db e poi si può usare
// il metodo getConnection per ottenere la connessione
class ConnectToSql {
    private String url = "jdbc:mysql://localhost:3306/";
    private String user = "root";
    private String password = "root";
    private Connection connection = null;
    private String dbName;

    public ConnectToSql(String dbName) {
        this.dbName = dbName;
        url += dbName;
        // qui faccio la vera e propria connessione al db usando driverManager
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Errore nella connessione al db");
        }
    }

    public void disconnect() throws SQLException {
        connection.close();
    }

    public Connection getConnection() {
        return connection;
    }
}

class Utente {
    private int id;
    private String nome;
    private int lastIndex = 0;

    // Costruttore che prende un ResultSet, usando gli indici delle colonne
    public Utente(ResultSet rs) throws SQLException {
        // Indici delle colonne (1-based, quindi "id" è alla posizione 1, "nome" è alla posizione 2)
        this.id = rs.getInt(1);    // id è nella prima colonna
        this.nome = rs.getString(2); // nome è nella seconda colonna
    }

    public Utente(String nome) {
        this.nome = nome;
    }

    // Getter e Setter
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Utente{id=" + id + ", nome='" + nome + "'}";
    }
}

class ReadOnlySQL {
    private Connection connection;

    public ReadOnlySQL(Connection connection) {
        this.connection = connection;
    }

    // Metodo generico getAll che restituisce un ArrayList di oggetti di tipo T
    public <T> ArrayList<T> getAll(Class<T> clazz, String tableName) throws SQLException {
        ArrayList<T> resultList = new ArrayList<>();
        String query = "SELECT * FROM " + tableName; // Query per ottenere tutti i dati dalla tabella
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            // Assumiamo che la classe T abbia un costruttore che prende un ResultSet
            while (resultSet.next()) {
                T instance = clazz.getDeclaredConstructor(ResultSet.class).newInstance(resultSet);
                resultList.add(instance);
            }
        } catch (Exception e) {
            throw new SQLException("Errore durante il recupero dei dati: " + e.getMessage(), e);
        }
        return resultList;
    }
}
