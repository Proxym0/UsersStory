package storage;

import entity.RoleEnum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static storage.JDBCConstanta.*;

public class JDBCRoleStorage {

    public void save(RoleEnum roleEnum) {


        try (Connection connection = DriverManager.getConnection(URL, NAME, PASSWORD)){

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
