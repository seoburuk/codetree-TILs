import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt(); // Number of users in chat room
        int m = sc.nextInt(); // Number of message 
        int p = sc.nextInt(); // The specific message number we are intresed in 
        char[] messages = new char[m];
        int[] unread = new int[m];

        for(int i = 0; i < m; i++) {
            messages[i] = sc.next().charAt(0); // The user who sent message
            unread[i] = sc.nextInt(); // Number of users who havent read message
        }
        Set<Character> possibleUnread = new HashSet<>();
        for(char c = 'A'; c < 'A'+n; c++) {
            possibleUnread.add(c);
        }
        for(int i = p-1; i < m; i++) { // pth 
            possibleUnread.remove(messages[i]);
        }
        List<Character> resultList = new ArrayList<>(possibleUnread);
        Collections.sort(resultList);
        if(resultList.size() == 0) {
            System.out.print("None");
        } else {
            for(char c : resultList) {
                System.out.print(c + " ");
            }
        }
    }
}