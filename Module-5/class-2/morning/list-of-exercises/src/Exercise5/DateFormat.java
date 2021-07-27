package Exercise5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

public final class DateFormat {
    private static HashSet<Integer> fullMonths;
    private static HashSet<Integer> smallerMonths;
    private static DateFormat format = null;

    private DateFormat() {
        fullMonths = new HashSet<>();
        smallerMonths = new HashSet<>();
        fullMonths.addAll(Arrays.asList(1, 3, 5, 7, 8, 10, 12));
        smallerMonths.addAll(Arrays.asList(4, 6, 9, 11));
    }

    public static DateFormat getInstance() {
        if (Objects.isNull(format))
            format = new DateFormat();
        return format;
    }

    public int monthLastDay(int month) {
        if (month <= 0 || month > 12)
            return -1;
        if(fullMonths.contains(month))
            return 31;
        if (smallerMonths.contains(month))
            return 30;
        return 28;
    }
}