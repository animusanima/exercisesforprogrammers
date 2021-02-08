package issues;

public interface IIssue {
    String getQuestion();
    void setQuestion(String question);
    String getSolution();
    void setSolution(String solution);
    IIssue getFollowUpIssueOnYes();
    void setFollowUpIssueOnYes(IIssue issue);
    IIssue getFollowUpIssueOnNo();
    void setFollowUpIssueOnNo(IIssue issue);
}
