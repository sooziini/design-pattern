import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PasswordDAOImpl implements PasswordDAO {
    final static String DB_FILE_NAME = "password.db";
    final static String DB_TABLE_NAME = "password";

    Connection connection = null;
    ResultSet rs = null;
    Statement statement = null;

    public PasswordDAOImpl() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:"+DB_FILE_NAME);
            statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // create table
            final String table = " (url text PRIMARY KEY, id text, password text)";
            statement.executeUpdate("DROP TABLE IF EXISTS "+DB_TABLE_NAME);
            statement.executeUpdate("CREATE TABLE "+DB_TABLE_NAME+table);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(PasswordInfo p) {
        try {
            String fmt = "INSERT INTO %s VALUES ('%s', '%s', '%s')";
            String q = String.format(fmt, DB_TABLE_NAME, p.getUrl(), p.getId(), p.getPassword());

            statement.execute(q);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<PasswordInfo> findAll() {
        ArrayList<PasswordInfo> pw = new ArrayList<>();
        try {
            rs = statement.executeQuery("SELECT * FROM "+DB_TABLE_NAME);
            while (rs.next()) {
                pw.add(new PasswordInfo(rs.getString("url"),
                        rs.getString("id"),
                        rs.getString("password")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pw;
    }

    @Override
    public PasswordInfo findByKey(String url) {
        PasswordInfo pw = null;
        try {
            String fmt = "SELECT * FROM %s WHERE url = '%s'";
            String q = String.format(fmt, DB_TABLE_NAME, url);
            rs = statement.executeQuery(q);
            if (rs.next()) {
                pw = new PasswordInfo(rs.getString("url"),
                        rs.getString("id"),
                        rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pw;
    }

    @Override
    public void update(PasswordInfo p) {
        PasswordInfo pw = findByKey(p.getUrl());
        if (pw != null) {
            try {
                String fmt = "UPDATE %s SET id='%s', password='%s' WHERE url='%s'";
                String q = String.format(fmt, DB_TABLE_NAME, p.getId(), p.getPassword(), p.getUrl());

                statement.execute(q);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String url) {
        try {
            String fmt = "DELETE FROM %s WHERE url='%s'";
            String q = String.format(fmt, DB_TABLE_NAME, url);

            statement.execute(q);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(PasswordInfo p) {
        delete(p.getUrl());
    }
}
