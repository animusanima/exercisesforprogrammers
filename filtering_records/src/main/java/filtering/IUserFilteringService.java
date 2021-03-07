package filtering;

import enums.PredicateType;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public interface IUserFilteringService {
    List<Map<String, String>> filterUsers(List<Map<String, String>> users, PredicateType type, Predicate<Map<String, String>>[] predicates);
    List<Map<String, String>> filterUsers(List<Map<String, String>> users, Predicate<Map<String, String>> predicate);
}