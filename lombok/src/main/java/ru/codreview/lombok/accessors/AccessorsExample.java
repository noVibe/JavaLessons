package lombok.accessors;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(fluent = true)
public class AccessorsExample {

    String stringField;
    int intField;

    public static void main(String[] args) {
        AccessorsExample example = new AccessorsExample();
        example.stringField("s")
                .intField(1);
    }
}
