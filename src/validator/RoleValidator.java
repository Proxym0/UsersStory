package validator;

import entity.RoleEnum;

import java.util.Set;

public class RoleValidator {

    public static boolean isValidRoles(Set<RoleEnum> roleEnums){
        if(roleEnums.isEmpty()||roleEnums.size()>2){
            return  false;
        }
        if(roleEnums.size()==1){
            return  true;
        }
        int sum=0;
        for (RoleEnum role:roleEnums) {
            sum=sum+role.getLevel();
        }
        return sum == 3;
    }
}
