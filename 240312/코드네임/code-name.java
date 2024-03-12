import java.util.Scanner;

public class Main {
    static class Agent {
        String id;
        int score;

        public Agent(String id, int score) {
            this.id = id;
            this.score = score;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Agent[] agents = new Agent[5];

        // 입력 받기
        for (int i = 0; i < 5; i++) {
            String id = sc.next();
            int score = sc.nextInt();
            agents[i] = new Agent(id, score);
        }

        // 점수가 제일 낮은 요원 찾기
        Agent lowestAgent = agents[0];
        for (int i = 1; i < agents.length; i++) {
            if (agents[i].score < lowestAgent.score) {
                lowestAgent = agents[i];
            }
        }

        // 결과 출력
        System.out.println(lowestAgent.id + " " + lowestAgent.score);
    }
}