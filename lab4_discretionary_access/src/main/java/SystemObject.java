import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
public class SystemObject {
    private int id;
    private String name;

    public SystemObject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
