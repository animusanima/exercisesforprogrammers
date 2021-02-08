package services;

import issues.IIssue;
import repositories.IIssueRepository;

import java.util.List;

public interface ITroubleShootingService {
    void addIssue(IIssue issue);
    void addIssues(List<IIssue> issues);
    List<IIssue> getIssues();

    void setRepository(IIssueRepository repository);
    void loadIssues();
}