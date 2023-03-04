package service;

import entity.User;
import storage.InFileUsersStorage;
import storage.JDBCUsersStorage;

public class UserService {
    JDBCUsersStorage storage=new JDBCUsersStorage();
    InFileUsersStorage inFileUsersStorage=new InFileUsersStorage();

    public void create(String name,String lastname,String email,String phone){
        User user=new User(name,lastname,email,phone);
        storage.save(user);
        inFileUsersStorage.save(user);
    }
}
