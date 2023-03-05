package console;

import entity.RoleEnum;
import entity.User;
import validator.RoleValidator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static console.ConsoleReader.readLine;
import static console.ConsoleReader.readString;
import static console.ConsoleWriter.write;

public class RoleController {
    private static Map<Integer, RoleEnum> ROLE_TABLE;

    static {
        ROLE_TABLE = Map.of(1, RoleEnum.USER,
                2, RoleEnum.CUSTOMER,
                3, RoleEnum.ADMIN,
                4, RoleEnum.PROVIDER,
                5, RoleEnum.SUPER_ADMIN);
    }

    public Set<RoleEnum> inputRoles() {
        write("Enter number role separated by spase");
        Set<RoleEnum> collect = new HashSet<>();
        boolean isValid=false;
        for (Map.Entry<Integer, RoleEnum> entry : ROLE_TABLE.entrySet()) {
            write(entry.getKey().toString() + " " + entry.getValue().toString());
        }
        do {
            String[] s = readLine().split(" ");
                        try {
                collect = Arrays.stream(s)
                        .map(t -> ROLE_TABLE.get(Integer.parseInt(t)))
                        .collect(Collectors.toSet());
            } catch (NumberFormatException e) {
                write("Invalid role number");
                continue;
            }
            isValid = RoleValidator.isValidRoles(collect);
            if (!isValid) {
                write(" Invalid role set up");}
        }while (!isValid);

        return collect;
    }
}
