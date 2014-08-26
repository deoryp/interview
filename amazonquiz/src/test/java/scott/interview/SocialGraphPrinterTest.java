package scott.interview;

import org.junit.Test;

import java.util.ArrayList;
import java.util.UUID;

public class SocialGraphPrinterTest {

    private Member makeRandomFriendGraph(int level, int group) {
        Member m = new Member();
        m.setName(UUID.randomUUID().toString());
        m.setEmail(m.getName() + "@email.com");
        m.setFriends(new ArrayList<Member>());
        if (level > 0) {
            for (int i = 0; i < group; i++) {
                m.getFriends().add(makeRandomFriendGraph(level - 1, group));
            }
        }
        return m;
    }

    private Member makeKnownGraph() {
        Member scott = new Member();
        scott.setName("Scott");
        scott.setEmail("scott@email.com");
        scott.setFriends(new ArrayList<Member>());
        {
            Member m = new Member();
            m.setName("Joe");
            m.setEmail("joe@email.com");
            m.setFriends(new ArrayList<Member>());
            scott.getFriends().add(m);
        }
        {
            Member m = new Member();
            m.setName("Hank");
            m.setEmail("hank@email.com");
            m.setFriends(new ArrayList<Member>());
            scott.getFriends().add(m);
        }
        {
            Member m = new Member();
            m.setName("Sally");
            m.setEmail("sally@email.com");
            m.setFriends(new ArrayList<Member>());
            scott.getFriends().add(m);
        }

        return scott;
    }

    @Test
    public void testPrintSocialGraph() throws Exception {
        Member m = makeKnownGraph();
        SocialGraphPrinter printer = new SocialGraphPrinter();
        printer.printSocialGraph(m);
    }

    @Test
    public void testPrintSocialGraph_random() throws Exception {
        Member m = makeRandomFriendGraph(5, 3);
        SocialGraphPrinter printer = new SocialGraphPrinter();
        printer.printSocialGraph(m);
    }
}