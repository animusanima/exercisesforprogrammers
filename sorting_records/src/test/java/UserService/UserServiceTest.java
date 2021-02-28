package UserService;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import user_sorting_service.IUserSortingService;
import user_sorting_service.UserSortingService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@Test
public class UserServiceTest {

    private IUserSortingService service;

    @BeforeMethod
    public void init() {
        service = new UserSortingService();
    }

    @Test
    public void should_sort_user_by_default() {
        List<Map<String, String>> users = new ArrayList<>();
        users.add(of("John", "Johnson", "Manager", "31.12.2016"));
        users.add(of("Tou", "Xiong", "Software Engineer", "05.10.2016"));
        users.add(of("Michaela", "Michaelson", "District Manager", "19.12.2015"));
        users.add(of("Jake", "Jacobson", "Programmer", null));
        users.add(of("Jacquelyn", "Jackson", "DBA", null));
        users.add(of("Sally", "Weber", "Web Developer", "18.12.2015"));

        List<Map<String, String>> sortedUsers = service.sortUsers(users, "first");
        assertThat(sortedUsers.get(0).get("first")).isEqualTo("Jacquelyn");
    }

    private static Map<String, String> of(String first, String last, String position, String separationDate) {
        Map<String, String> user = new HashMap<>();
        user.put("first", first);
        user.put("last", last);
        user.put("position", position);
        user.put("separationDate", separationDate);
        return user;
    }

}