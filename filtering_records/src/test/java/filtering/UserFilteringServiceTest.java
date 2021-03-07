package filtering;

import enums.PredicateType;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UserDataUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

@Test
public class UserFilteringServiceTest {

    private UserFilteringService service;
    private List<Map<String, String>> users;

    @BeforeMethod
    public void init() throws IOException, URISyntaxException {
        service = new UserFilteringService();
        createUsers();
    }

    private void createUsers() throws IOException, URISyntaxException{
        users = new ArrayList<>();

        URL file = getClass().getClassLoader().getResource("userData.csv");
        if (file != null) {
            BufferedReader reader = Files.newBufferedReader(Paths.get(file.toURI()));
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(reader);
            for (CSVRecord record : records) {
                String first = record.get("first");
                String last = record.get("last");
                String position = record.get("position");
                String separationDate = record.get("separationDate");

                users.add(UserDataUtils.withInformation(first, last, position, separationDate));
            }
        }
    }

    @Test
    public void filterByNameOrLastName() {
        String value = "Jac";

        Predicate<Map<String, String>> firstNamePredicate = map -> map.get("first").toLowerCase().startsWith(value.toLowerCase());
        Predicate<Map<String, String>> lastNamePredicate = map -> map.get("last").toLowerCase().startsWith(value.toLowerCase());

        List<Map<String, String>> result = service.filterUsers(users, PredicateType.OR, firstNamePredicate, lastNamePredicate);
        sortUsersByFirstName(result);

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).get("first")).isEqualTo("Jacquelyn");
        assertThat(result.get(0).get("last")).isEqualTo("Jackson");
    }

    @Test
    public void filterByNameAndLastName() {
        String value = "Jac";

        Predicate<Map<String, String>> firstNamePredicate = map -> map.get("first").toLowerCase().startsWith(value.toLowerCase());
        Predicate<Map<String, String>> lastNamePredicate = map -> map.get("last").toLowerCase().startsWith(value.toLowerCase());

        List<Map<String, String>> result = service.filterUsers(users, PredicateType.AND, firstNamePredicate, lastNamePredicate);

        sortUsersByFirstName(result);

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).get("first")).isEqualTo("Jacquelyn");
        assertThat(result.get(0).get("last")).isEqualTo("Jackson");
    }

    @Test
    public void filterByPosition() {
        String value = "Man";

        Predicate<Map<String, String>> positionPredicate = map -> map.get("position").toLowerCase().startsWith(value.toLowerCase());

        List<Map<String, String>> result = service.filterUsers(users, positionPredicate);

        sortUsersByFirstName(result);

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).get("first")).isEqualTo("John");
        assertThat(result.get(0).get("last")).isEqualTo("Johnson");
    }

    @Test
    public void filterBySeparationDateOlderSixMonths() {
        long sixMonths = 6;
        int fourEntries = 4;

        Predicate<Map<String, String>> separationDatePredicate = map -> {
            String separation = map.get("separationDate");
            if (!StringUtils.isEmpty(separation)) {
                LocalDate today = LocalDate.now();
                LocalDate separationDate = LocalDate.parse(separation, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                long monthsDifference = ChronoUnit.MONTHS.between(YearMonth.from(separationDate), YearMonth.from(today));
                return monthsDifference >= sixMonths;
            }
            return false;
        };

        List<Map<String, String>> result = service.filterUsers(users, separationDatePredicate);
        sortUsersByFirstName(result);

        assertThat(result.size()).isEqualTo(fourEntries);
    }

    private void sortUsersByFirstName(List<Map<String, String>> result) {
        result.sort(Comparator.comparing(u -> u.get("first")));
    }
}