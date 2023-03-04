package storage;

import entity.User;


import java.io.FileWriter;
import java.io.IOException;

public class InFileUsersStorage {
    public void save(User user) {
        try (FileWriter fileWriter = new FileWriter("story", true)){
            fileWriter.write(String.valueOf(user));
            fileWriter.write('\n');
            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}