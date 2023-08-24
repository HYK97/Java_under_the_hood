package java8.date;

import java.time.*;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Set;

public class DateTest {
    public static void main(String[] args) {
        //dayOfWeeks();
        localAndOffset();
    }

    private static void dayOfWeeks() {
        DayOfWeek dayOfWeek = DayOfWeek.MONDAY;
        Locale[] availableLocales = Locale.getAvailableLocales();
        for (Locale loc : availableLocales) {
            System.out.print(loc + " ");
            System.out.print(dayOfWeek.getDisplayName(TextStyle.FULL, loc) + " ");
            System.out.print(dayOfWeek.getDisplayName(TextStyle.NARROW, loc) + " ");
            System.out.print(dayOfWeek.getDisplayName(TextStyle.SHORT, loc) + " ");
            System.out.println();
        }
    }

    private static void localAndOffset() {
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        for (String loc : availableZoneIds) {
            System.out.println(LocalDateTime.now(ZoneId.of(loc)));
            System.out.println(OffsetDateTime.now(ZoneId.of(loc)));
            System.out.println(ZonedDateTime.now(ZoneId.of(loc)));
        }
    }
}
