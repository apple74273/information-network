import java.util.Scanner;

public class Main{
	double min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Main main = new Main();
		Scanner sc = new Scanner (System.in);
		int[][] map = new int[9][9];
		for (int i=0; i<13; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			a--;
			b--;
			map[a][b]=c;
			map[b][a]=c;
		}
		boolean[] answer = new boolean[9];
		boolean[] visit = new boolean[9];
		visit[0]=true;
		answer = main.dfs (map, 0, 0, answer, visit);
		
		for (int i=0; i<9; i++) {
			if (answer[i]) {
				System.out.println(i);
			}
		}
		
	}
	
	boolean[] dfs (int[][] map, int nowPlace, double distance, boolean[] answer, boolean[] visit) {
		if (nowPlace==8) {
			if (distance<min) {
				min=distance;
				for (int i=0; i<9; i++) {
					if (visit[i]) {
						answer[i]=true;
					} else {
						answer[i]=false;
					}
				}
				
			}
			return answer;
		}
		
		for (int i=0; i<9; i++) {
			if (map[nowPlace][i]!=0&&!visit[i]) {
				visit[i]=true;
				answer = dfs(map, i, distance+(double)1/map[nowPlace][i], answer, visit);
				visit[i]=false;
			}
		}
		
		
		return answer;
	}
}