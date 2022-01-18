package writers.types;
import writers.Write;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Driver;
import java.util.List;

public class SQLWriter implements Write {
    static final String DB_URL = "Server=localhost\\SQLEXPRESS04;Database=master;Trusted_Connection=True;";
    static final String USER = "sa";
    static final String PASS = "petel123";


    @Override
    public void write(List<String[]> data, String path, List<String> keys) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost//SQLEXPRESS04:1433;user=sa;password=petel123;DataBaseName=master");){
            conn.setAutoCommit(true);
            createTable(path, keys);
            String insertQuery;
            PreparedStatement stmt;
            for (String[] string: data) {
                insertQuery = getInsertString(path, keys);
                stmt = conn.prepareStatement(insertQuery);
                int i = 1;
                for (String s: string) {
                    stmt.setString(i, s);
                }
                stmt.executeUpdate();
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTable(String tableName, List<String> keys) {
        try ( Connection conn = DriverManager.getConnection(DB_URL, USER, PASS) ){
            Statement stmt = conn.createStatement();
            String createTable = "CREATE TABLE" + tableName + "(";
            for (String key: keys) {
                createTable += key + "VARCHAR(255),";
            }
            createTable = removeLastChar(createTable);
            createTable += ")";
            stmt.executeUpdate(createTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private String getInsertString(String tableName, List<String> keys) {
        String sql = "INSERT INTO" + tableName + "(";
        for (String key: keys) {
            sql += key + ",";
        }
        sql = removeLastChar(sql);
        sql += ")";
        sql += "VALUES" + "(";
        for (String key: keys) {
            sql += "?,";
        }
        sql = removeLastChar(sql);
        sql += ")";
        return sql;
    }

    private String removeLastChar(String s) {
        return s.substring(0, s.length() - 1);
    }
}
