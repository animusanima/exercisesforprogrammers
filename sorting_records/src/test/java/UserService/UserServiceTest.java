package UserService;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import user_sorting_service.IUserSortingService;
import user_sorting_service.UserSortingService;
import utils.UserDataUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@Test
public class UserServiceTest {

    private IUserSortingService service;

    private List<Map<String, String>> users;

    @BeforeMethod
    public void init() {
        service = new UserSortingService();
        createUsers();
    }

    private void createUsers() {
        users = new ArrayList<>();
        users.add(UserDataUtils.withInformation("John", "Johnson", "Manager", "31.12.2016"));
        users.add(UserDataUtils.withInformation("Tou", "Xiong", "Software Engineer", "05.10.2016"));
        users.add(UserDataUtils.withInformation("Michaela", "Michaelson", "District Manager", "19.12.2015"));
        users.add(UserDataUtils.withInformation("Jake", "Jacobson", "Programmer", null));
        users.add(UserDataUtils.withInformation("Jacquelyn", "Jackson", "DBA", null));
        users.add(UserDataUtils.withInformation("Sally", "Weber", "Web Developer", "18.12.2015"));
    }

    @Test
    public void should_sort_user_by_first_name() {
        List<Map<String, String>> sortedUsers = service.sortUsers(users, "first");
        assertThat(sortedUsers.get(0).get("first")).isEqualTo("Jacquelyn");
        assertThat(sortedUsers.get(sortedUsers.size() - 1).get("first")).isEqualTo("Tou");
    }

    @Test
    public void should_sort_user_by_last_name() {
        List<Map<String, String>> sortedUsers = service.sortUsers(users, "last");
        assertThat(sortedUsers.get(0).get("last")).isEqualTo("Jackson");
        assertThat(sortedUsers.get(sortedUsers.size() - 1).get("last")).isEqualTo("Xiong");
    }

    @Test
    public void should_sort_user_by_position() {
        List<Map<String, String>> sortedUsers = service.sortUsers(users, "position");
        Map<String, String> firstUser = sortedUsers.get(0);
        Map<String, String> lastUser = sortedUsers.get(sortedUsers.size() - 1);

        assertThat(firstUser.get("position")).isEqualTo("DBA");
        assertThat(lastUser.get("position")).isEqualTo("Web Developer");
    }

    @Test
    public void should_sort_user_by_separation_date() {
        List<Map<String, String>> sortedUsers = service.sortUsers(users, "separationDate");
        Map<String, String> firstUser = sortedUsers.get(0);
        Map<String, String> lastUser = sortedUsers.get(sortedUsers.size() - 1);

        assertThat(firstUser.get("separationDate")).isEqualTo("");
        assertThat(firstUser.get("first")).isEqualTo("Jake");
        assertThat(firstUser.get("last")).isEqualTo("Jacobson");

        assertThat(lastUser.get("separationDate")).isEqualTo("31.12.2016");
        assertThat(lastUser.get("first")).isEqualTo("John");
        assertThat(lastUser.get("last")).isEqualTo("Johnson");
    }

}