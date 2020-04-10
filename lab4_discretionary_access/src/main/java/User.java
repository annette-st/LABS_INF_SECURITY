import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;

@Getter
@Setter
@Builder
@ToString
public class User {

    private int id;
    private String name;
    private Role role;
    private HashMap<SystemObject, AccessTypes> objectsRoles;

    public User(int id, String name, Role role, HashMap<SystemObject, AccessTypes> objectsRoles) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.objectsRoles = objectsRoles;
    }

}
