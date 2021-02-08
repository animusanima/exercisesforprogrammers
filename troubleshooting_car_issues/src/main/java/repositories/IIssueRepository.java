package repositories;

import issues.IIssue;

import java.util.List;

public interface IIssueRepository {
    List<IIssue> loadIssues();
}
