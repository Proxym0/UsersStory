package service;

import entity.RoleEnum;
import entity.User;
import storage.InFileUsersStorage;
import storage.JDBCUsersStorage;

import java.util.Set;

public class UserService {
    JDBCUsersStorage storage=new JDBCUsersStorage();
    InFileUsersStorage inFileUsersStorage=new InFileUsersStorage();

    public void create(String name, String lastname, String email, String phone, Set<RoleEnum> roleEnums){
        User user=new User(name,lastname,email,phone);
        user.setRole(roleEnums);
        storage.save(user);
        inFileUsersStorage.save(user);

    }
}
