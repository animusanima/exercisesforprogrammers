package easy_rules;

import issues.IIssue;
import issues.Issue;
import org.jeasy.rules.annotation.*;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.testng.annotations.Test;

@Test
public class EasyRulesTest {

    public void should_retrieve_yes_issue() {
        Facts facts = new Facts();
        facts.put("answer", "yes");

        IIssue yesIssue = new Issue("Yes");
        YesRule issueRule = new YesRule(yesIssue);

        Rules rules = new Rules();
        rules.register(issueRule);

        RulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.fire(rules, facts);
    }

    public void should_retrieve_no_issue() {
        Facts facts = new Facts();
        facts.put("answer", "no");

        IIssue noIssue = new Issue("No");
        NoRule issueRule = new NoRule(noIssue);

        Rules rules = new Rules();
        rules.register(issueRule);

        RulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.fire(rules, facts);
    }

    @Rule
    public static class YesRule {
        private IIssue issue;

        public YesRule(IIssue issue) {
            this.issue = issue;
        }

        @Condition
        public boolean validAnswer(@Fact("answer") String answer) {
            return answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y");
        }

        @Action
        public void processAnswer() {
            System.out.print(issue.getSolution());
            issue = issue.getFollowUpIssueOnYes();
        }
    }

    @Rule
    public static class NoRule {
        private IIssue issue;

        public NoRule(IIssue issue) {
            this.issue = issue;
        }

        @Condition
        public boolean validAnswer(@Fact("answer") String answer) {
            return answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n");
        }

        @Action
        public void processAnswer() {
            System.out.print(issue.getSolution());
            issue = issue.getFollowUpIssueOnNo();
        }
    }

}
