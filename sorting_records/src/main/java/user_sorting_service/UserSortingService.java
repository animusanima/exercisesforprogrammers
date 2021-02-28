package user_sorting_service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class UserSortingService implements IUserSortingService {
    @Override
    public List<Map<String, String>> sortUsers(List<Map<String, String>> users, String field) {
        Comparator<Map<String, String>> comparator = Comparator.comparing(u -> u.get(field));
        users.sort(comparator);
        return users;
    }
}
