package scott.interview;

import java.util.*;

public class SocialGraphPrinter {

    private Set<Member> printSocialGraphAtLevel(int level, Collection<Member> friends) {
        // Using a set because if friends are friends with the same people, then I don't think i have to print that out.
        //
        Set<Member> nextLevelFriends = new HashSet<Member>();
        if (friends != null) {
            System.out.println("Level " + level);
            // For each friend, print the friend and save the next level friends that are unique.
            //
            for (Member friend : friends) {
                // Print the level friend out.
                //
                System.out.println(friend);
                // If this friend has friends, save them for later.
                //
                if (friend.getFriends() != null && friend.getFriends().size() > 0) {
                    nextLevelFriends.addAll(friend.getFriends());
                }
            }
        }
        // Return the next level friends
        //
        return nextLevelFriends;
    }

    void printSocialGraph (Member m) {
        if (m == null) {
            System.out.println("Null people have no friends.");
            return;
        }

        System.out.println("Printing Social Graph for " + m);

        // Start at level 1
        //
        int level = 1;

        if (m.getFriends() != null) {
            // Collect the first level.
            //
            Set<Member> nextLevelFriends = printSocialGraphAtLevel(level, m.getFriends());
            level++;
            while(nextLevelFriends.size() > 0) {
                // Print and Collect the next levels
                //
                nextLevelFriends = printSocialGraphAtLevel(level, nextLevelFriends);
                level++;
            }
        }
    }
}
