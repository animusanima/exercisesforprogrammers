package services;

import issues.IIssue;
import repositories.IIssueRepository;

import java.util.ArrayList;
import java.util.List;

public class TroubleShootingService implements ITroubleShootingService {

    private List<IIssue> issues;
    private IIssueRepository repository;

    public TroubleShootingService() {
        issues = new ArrayList<>();
    }

    @Override
    public void addIssue(IIssue issue) {
        issues.add(issue);
    }

    @Override
    public void addIssues(List<IIssue> issues) {
        this.issues.addAll(issues);
    }

    @Override
    public List<IIssue> getIssues() {
        return issues;
    }

    @Override
    public void loadIssues() {
        this.issues = repository.loadIssues();
    }

    public void setRepository(IIssueRepository repository) {
        this.repository = repository;
    }
}
