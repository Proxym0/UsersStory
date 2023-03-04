package storage;

import entity.User;
import org.postgresql.jdbc.PgConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static storage.JDBCConstanta.*;

public class JDBCUsersStorage {



    public void save(User user) {
        try (Connection connection = DriverManager.getConnection(URL, NAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into table_users values (default,?,?,?,?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastname());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, NAME, PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select *from table_users");
            while (resultSet.next()) {
                String name = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("number_phone");
                User user = new User(name, lastname, email, phone);
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new ArrayList<>(users);
    }

    public Optional<User> findByName(String name) {
        try (Connection connection = DriverManager.getConnection(URL, NAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from table_users where firstname=?");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String lastname = resultSet.getString("lastname");
            String email = resultSet.getString("email");
            String numberPhone = resultSet.getString("number_phone");
            return Optional.of(new User(name, lastname, email, numberPhone));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<User> findByLastname(String lastname) {
        try (Connection connection = DriverManager.getConnection(URL, NAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement("select *from table_users where lastname=?");
            preparedStatement.setString(1, lastname);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String numberPhone = resultSet.getString("number_phone");
            return Optional.of(new User(name, lastname, email, numberPhone));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<User> findByEmail(String email) {
        try (Connection connection = DriverManager.getConnection(URL, NAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement("select *from table_users where email=?");
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String name = resultSet.getString("name");
            String lastname = resultSet.getString("lastname");
            String numberPhone = resultSet.getString("number_phone");
            return Optional.of(new User(name, lastname, email, numberPhone));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<User> findByPhone(String phone) {
        try (Connection connection = DriverManager.getConnection(URL, NAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement("select *from table_users where number_phone=?");
            preparedStatement.setString(1, phone);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String name = resultSet.getString("name");
            String lastname = resultSet.getString("lastname");
            String email = resultSet.getString("email");
            return Optional.of(new User(name, lastname, email, phone));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAll() {
        try (Connection connection = DriverManager.getConnection(URL, NAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from table_users");
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteByName(String name) {
        try (Connection connection = DriverManager.getConnection(URL, NAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from table_users where firstname=?");
            preparedStatement.setString(1, name);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteByLastname(String lastname) {
        try (Connection connection = DriverManager.getConnection(URL, NAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from table_users where lastname=?");
            preparedStatement.setString(1, lastname);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteByEmail(String email) {
        try (Connection connection = DriverManager.getConnection(URL, NAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement("delete  from table_users where email=?");
            preparedStatement.setString(1, email);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteByPhone(String phone) {
        try (Connection connection = DriverManager.getConnection(URL, NAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from table_users where number_phone=?");
            preparedStatement.setString(1, phone);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}



