package application;

import issues.IIssue;
import org.apache.commons.collections4.CollectionUtils;
import repositories.DemoIssueRepository;
import services.ITroubleShootingService;
import services.TroubleShootingService;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class TroubleShootingApp {
    public static void main(String[] args) {
        ITroubleShootingService service = new TroubleShootingService();
        service.setRepository(new DemoIssueRepository());
        service.loadIssues();

        List<IIssue> issues = service.getIssues();
        IIssue currentIssue = null;
        if (!CollectionUtils.isEmpty(issues)) {
            currentIssue = getStartingIssue(service.getIssues());
        }

        printMessage("Troubleshooting car issues");
        Scanner scanner = new Scanner(System.in);
        while (currentIssue != null) {
            printQuestion(currentIssue);

            currentIssue = getFollowUpIssueFromAnswer(currentIssue, getAnswer(scanner));
            if (currentIssue == null) continue;

            if (isSolution(currentIssue)) {
                printMessage(currentIssue.getSolution());
                break;
            }
        }
    }

    private static String getAnswer(Scanner scanner) {
        return scanner.next();
    }

    private static IIssue getStartingIssue(List<IIssue> issues) {
        return issues.get(0);
    }

    private static boolean isSolution(IIssue currentIssue) {
        return currentIssue.getFollowUpIssueOnYes() == null || currentIssue.getFollowUpIssueOnNo() == null;
    }

    private static IIssue getFollowUpIssueFromAnswer(IIssue currentIssue, String answer) {
        if (answer.toLowerCase(Locale.ROOT).equals("y") || answer.toLowerCase(Locale.ROOT).equals("yes")) {
            return currentIssue.getFollowUpIssueOnYes();
        } else if (answer.toLowerCase(Locale.ROOT).equals("n") || answer.toLowerCase(Locale.ROOT).equals("no")) {
            return currentIssue.getFollowUpIssueOnNo();
        } else {
            printMessage("Invalid input. Accepted inputs are y or yes and n or no");
            return null;
        }
    }

    private static void printQuestion(IIssue currentIssue) {
        if (currentIssue != null) {
            System.out.print(currentIssue.getQuestion());
        }
    }

    private static void printMessage(String s) {
        System.out.println(s);
    }
}