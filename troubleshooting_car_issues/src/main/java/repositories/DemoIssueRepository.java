package repositories;

import issues.IIssue;
import issues.Issue;

import java.util.ArrayList;
import java.util.List;

public class DemoIssueRepository implements IIssueRepository {
    @Override
    public List<IIssue> loadIssues() {
        List<IIssue> issues = new ArrayList<>();

        issues.add(new IssueBuilder().withQuestion("Is the car silent when you turn the key?")
                .withFollowUpYesIssue(new Issue("Are the battery cables corroded?", "The battery cables may be damages.",
                        new Issue("Replace cables and try again."),
                        new Issue("Clean terminals and try again starting.")))
                .withFollowUpNoIssue(new IssueBuilder().withQuestion("Does the car make a clicking noise?")
                        .withFollowUpYesIssue(new Issue("Replace the battery."))
                        .withFollowUpNoIssue(new IssueBuilder().withQuestion("Does the car crank up but fail to start?")
                                .withFollowUpYesIssue(new Issue("Check spark and plug connections."))
                                .withFollowUpNoIssue(new IssueBuilder().withQuestion("Does the engine start and then die?")
                                        .withFollowUpNoIssue(new Issue("Get it in for service."))
                                        .withFollowUpYesIssue(new IssueBuilder().withQuestion("Does your car have fuel injection?")
                                                .withFollowUpYesIssue(new Issue("Get it in for service."))
                                                .withFollowUpNoIssue(new Issue("Check to ensure the choke is opening and closing."))
                                                .build())
                                        .build())
                                .build())
                        .build())
                .build());
        return issues;
    }

    private class IssueBuilder {

        private String question;
        private String solution;
        private IIssue followUpYesIssue;
        private IIssue followUpNoIssue;

        public IssueBuilder withQuestion(String question) {
            this.question = question;
            return this;
        }

        public IssueBuilder withSolution(String solution) {
            this.solution = solution;
            return this;
        }

        public IssueBuilder withFollowUpYesIssue(IIssue followUpYesIssue) {
            this.followUpYesIssue = followUpYesIssue;
            return this;
        }

        public IssueBuilder withFollowUpNoIssue(IIssue followUpNoIssue) {
            this.followUpNoIssue = followUpNoIssue;
            return this;
        }

        public IIssue build() {
            return new Issue(this.question, this.solution, this.followUpNoIssue, this.followUpYesIssue);
        }

    }
}