package console;

import entity.Phone;
import entity.RoleEnum;
import entity.User;
import service.UserService;
import storage.JDBCUsersStorage;
import validator.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import static console.ConsoleReader.readInt;
import static console.ConsoleReader.readString;
import static console.ConsoleWriter.write;
import static validator.Validator.isValidNumberPhone;


public class ConsoleApplication {
    JDBCUsersStorage jdbcUsersStorage = new JDBCUsersStorage();
    RoleController roleController = new RoleController();
    UserService userService = new UserService();

    public void run() {
        while (true) {
            write("Hello User enter operation");
            write("1 - createUser, 2 - findUser, 3 - deleteUser, 4 - Exit");
            switch (readInt()) {
                case 1:
                    create();
                    continue;

                case 2:
                    write("Select search criteria\n" +
                            "1.Find by name. \n" +
                            "2.Find by last name \n" +
                            "3.Find by mail.\n" +
                            "4.Find by phone number.");
                    switch (readInt()) {
                        case 1:
                            write(jdbcUsersStorage.findByName(readString()).toString());
                            continue;
                        case 2:
                            write(String.valueOf(jdbcUsersStorage.findByLastname(readString())));
                            continue;
                        case 3:
                            write(String.valueOf(jdbcUsersStorage.findByEmail(readString())));
                            continue;
                        case 4:
                            write(String.valueOf(jdbcUsersStorage.findByPhone(readString())));
                    }

                case 3:
                    write("1.Find by name and delete the user.\n" +
                            "2.Find by last name and delete the user.\n" +
                            "3.Find by mail and delete the user.\n" +
                            "4.Find by phone number and delete the user.");
                    switch (readInt()) {
                        case 1:
                            jdbcUsersStorage.deleteByName(readString());
                            write("User delete!!!");
                            continue;
                        case 2:
                            jdbcUsersStorage.deleteByLastname(readString());
                            write("User delete!!!");
                            continue;
                        case 3:
                            jdbcUsersStorage.deleteByEmail(readString());
                            write("User delete!!!");
                            continue;
                        case 4:
                            jdbcUsersStorage.deleteByPhone(readString());
                            write("User delete!!!");
                            continue;
                    }

                case 4:
                    return;
                case 5:

            }

        }

    }

    public void create() {

        String firstname = userInput("Inter name", "Invalid name", Validator::isValidUsername);
        String lastname = userInput("Inter lastname", "Invalid name", Validator::isValidLastname);
        String email = userInput("Inter email", "Invalid mail", Validator::isValidEmail);
        String phone = userInput("Inter numbers", "Invalid number", Validator::isValidNumberPhone);
        String numberPhone = Arrays.toString(phone.toCharArray());
        Set<RoleEnum> roleEnums = roleController.inputRoles();
        userService.create(firstname, lastname, email, numberPhone,roleEnums);
    }

    private String userInput(String message, String inputInvalidMessage, Predicate<String> validator) {
        write(message);
        boolean isValid;
        String input;
        do {
            input = readString();
            isValid = validator.test(input);
            if (!isValid) {
                write(inputInvalidMessage);
            }
        }
        while (!isValid);
        return input;
    }
//    public List<Phone> addPhone(Phone phone) {
//        List<Phone> phones = new ArrayList<>();
//        String ph = String.valueOf(phones.add(phone));
//        String[] arrNumber = ph.split(" ");
//
//        for (String number : arrNumber) {
//            Phone phone1 = new Phone(number);
//            phones.add(phone1);
//        }
//        return phones;
//    }


}
