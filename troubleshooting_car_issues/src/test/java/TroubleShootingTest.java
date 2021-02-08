import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.ITroubleShootingService;
import services.TroubleShootingService;
import issues.IIssue;
import issues.Issue;

import static org.assertj.core.api.Assertions.assertThat;

@Test
public class TroubleShootingTest {

    private ITroubleShootingService service = new TroubleShootingService();
    private IIssue issue;

    @BeforeMethod
    public void init() {
        service = new TroubleShootingService();
        issue = new Issue();
    }

    public void should_be_possible_to_add_troubleshooting_topic() {
        service.addIssue(issue);
        assertThat(service.getIssues().size()).isEqualTo(1);
    }

    public void should_retrieve_issue_description() {
        issue.setQuestion("Is the car silent after starting the motor?");
        assertThat(issue.getQuestion()).isEqualTo("Is the car silent after starting the motor?");
    }

    public void should_retrieve_issue_solution() {
        issue.setSolution("Turn the motor off and on again");
        assertThat(issue.getSolution()).isEqualTo("Turn the motor off and on again");
    }

    public void should_be_possible_to_set_follow_up_issue() {
        issue.setQuestion("Is the car silent when you turn the keys?");

        IIssue followUpYes = new Issue();
        followUpYes.setQuestion("Are the battery terminals corroded?");
        followUpYes.setSolution("Change battery cables");
        followUpYes.setFollowUpIssueOnYes(null);
        followUpYes.setFollowUpIssueOnNo(null);

        IIssue followUpNo = new Issue();
        followUpNo.setQuestion("Is the oil filled up?");
        followUpNo.setSolution("Refill oil");
        followUpNo.setFollowUpIssueOnYes(null);
        followUpNo.setFollowUpIssueOnNo(null);

        issue.setFollowUpIssueOnYes(followUpYes);
        issue.setFollowUpIssueOnNo(followUpNo);

        assertThat(issue.getFollowUpIssueOnYes()).isEqualTo(followUpYes);
        assertThat(issue.getFollowUpIssueOnNo()).isEqualTo(followUpNo);
    }

}