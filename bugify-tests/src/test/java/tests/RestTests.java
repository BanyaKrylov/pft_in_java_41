package tests;

import model.Issue;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

/**
 * Created by ivan8 on 06.07.2017.
 */
public class RestTests extends TestBase {

  @Test
  public void testCreateIssue() throws IOException {
    skipIfNotFixed(1);
    Set<Issue> oldIssues = rest.getIssue();
    Issue newIssue = new Issue().withSubject("Test issue 2").withDescription("New test description");
    int issueId = rest.createIssue(newIssue);
    Set<Issue> newIssues = rest.getIssue();
    oldIssues.add(newIssue.withId(issueId));
    assertEquals(newIssues, oldIssues);
  }

}
