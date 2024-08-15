import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); // Number of users
        int m = sc.nextInt(); // Number of messages
        int p = sc.nextInt(); // Specific message number to check
        
        // Arrays to store message sender and unread count
        char[] senders = new char[m];
        int[] unread = new int[m];
        
        // Read the input
        for (int i = 0; i < m; i++) {
            senders[i] = sc.next().charAt(0); // Sender of the message
            unread[i] = sc.nextInt(); // Number of people who have not read the message
        }
        
        // Set of all possible users
        Set<Character> allUsers = new HashSet<>();
        for (char c = 'A'; c < 'A' + n; c++) {
            allUsers.add(c);
        }
        
        // Set of users who have definitely read the p-th message
        Set<Character> readBy = new HashSet<>();
        
        // Process each message
        for (int i = 0; i < m; i++) {
            if (i < p - 1) {
                // For messages before the p-th message, mark who must have read them
                readBy.add(senders[i]);
            } else if (i == p - 1) {
                // The p-th message itself
                // Everyone except the unread count has read it
                int numUnread = unread[i];
                if (numUnread > 0) {
                    Set<Character> unreadUsers = new HashSet<>(allUsers);
                    unreadUsers.remove(senders[i]);
                    // Track possible unread users for this message
                    // Possible unread users will be those who did not read the p-th message
                    readBy = unreadUsers;
                }
            }
        }
        
        // Determine possible users who may not have read the p-th message
        Set<Character> possibleUnread = new HashSet<>(allUsers);
        possibleUnread.removeAll(readBy);
        
        // Prepare the result
        List<Character> resultList = new ArrayList<>(possibleUnread);
        Collections.sort(resultList);
        
        // Print the result
        if (resultList.isEmpty()) {
            System.out.print("None");
        } else {
            for (char c : resultList) {
                System.out.print(c + " ");
            }
        }
    }
}