package filtering;

import enums.PredicateType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UserFilteringService implements IUserFilteringService {
    public UserFilteringService() {
    }

    @SafeVarargs
    @Override
    public final List<Map<String, String>> filterUsers(List<Map<String, String>> users, PredicateType type, Predicate<Map<String, String>>... predicates) {
        List<Map<String, String>> results = new ArrayList<>();
        Predicate<Map<String, String>> filterPredicate = null;
        if (predicates != null) {
            if (predicates.length > 0) {
                filterPredicate = predicates[0];
                for (Predicate<Map<String, String>> predicate : predicates) {
                    switch (type) {
                        case OR:
                            filterPredicate = filterPredicate.or(predicate);
                            break;
                        case AND:
                            filterPredicate = filterPredicate.and(predicate);
                            break;
                    }
                }
            }
        }

        if (filterPredicate != null)
            results = users.stream().filter(filterPredicate).collect(Collectors.toList());

        return results;
    }

    @Override
    public List<Map<String, String>> filterUsers(List<Map<String, String>> users, Predicate<Map<String, String>> predicate) {
        List<Map<String, String>> results = new ArrayList<>();

        if (predicate != null)
            results = users.stream().filter(predicate).collect(Collectors.toList());

        return results;
    }
}
