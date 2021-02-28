package user_sorting_service;

import java.util.List;
import java.util.Map;

public interface IUserSortingService {
    List<Map<String, String>> sortUsers(List<Map<String, String>> users, String field);
}
