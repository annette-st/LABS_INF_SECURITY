import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum AccessTypes {
    COMPLETE_BAN, GRANT_RIGHTS, RECORDING, WRITING_AND_TRANSFER_OF_RIGHTS, READING, READING_AND_TRANSFER_OF_RIGHTS,
    WRITING, READING_AND_WRITING, FULL_ACCESS;

    private static final List<AccessTypes> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static AccessTypes randomAccessType()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
