package issues;

public class Issue implements IIssue {
    String question;
    String solution;
    IIssue followUpIssueOnYes;
    IIssue followUpIssueOnNo;

    public Issue() {
        this.question = null;
        this.solution = null;
        this.followUpIssueOnNo = null;
        this.followUpIssueOnYes = null;
    }

    public Issue(String solution) {
        this.solution = solution;
    }

    public Issue(String question, String solution, IIssue followUpNo, IIssue followUpYes) {
        this.question = question;
        this.solution = solution;
        this.followUpIssueOnNo = followUpNo;
        this.followUpIssueOnYes = followUpYes;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String getSolution() {
        return solution;
    }

    @Override
    public void setSolution(String solution) {
        this.solution = solution;
    }

    @Override
    public IIssue getFollowUpIssueOnYes() {
        return followUpIssueOnYes;
    }

    @Override
    public void setFollowUpIssueOnYes(IIssue issue) {
        this.followUpIssueOnYes = issue;
    }

    @Override
    public IIssue getFollowUpIssueOnNo() {
        return followUpIssueOnNo;
    }

    @Override
    public void setFollowUpIssueOnNo(IIssue issue) {
        this.followUpIssueOnNo = issue;
    }
}