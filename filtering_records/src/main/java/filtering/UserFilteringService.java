package filtering;

import enums.PredicateType;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
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
        if (CollectionUtils.isEmpty(users)) {
            return Collections.emptyList();
        }

        if (predicates == null || type == null) {
            return users;
        }

        List<Map<String, String>> results = new ArrayList<>();
        Predicate<Map<String, String>> filterPredicate = null;

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

        if (filterPredicate != null)
            results = users.stream().filter(filterPredicate).collect(Collectors.toList());

        return results;
    }

    @Override
    public List<Map<String, String>> filterUsers(List<Map<String, String>> users, Predicate<Map<String, String>> predicate) {
        if (CollectionUtils.isEmpty(users)) {
            return Collections.emptyList();
        }

        if (predicate == null) {
            return users;
        }
        return users.stream().filter(predicate).collect(Collectors.toList());
    }
}
