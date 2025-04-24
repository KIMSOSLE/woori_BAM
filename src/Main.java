import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("총 학생 수 : ");
		int num = sc.nextInt();

		String[] names = new String[num];
		int[] scores = new int[num];
		String[] grades = new String[num];

		for (int i = 0; i < num; i++) {
			System.out.println("이름 : ");
			names[i] = sc.nextLine();

			System.out.println("점수 : ");
			scores[i] = sc.nextInt();

			int score = num;
			switch (score / 10) {
			case 10:
			case 9:
				System.out.println("등급 : A");
				break;
			case 8:
				System.out.println("등급 : B");
				break;
			default:
				System.out.println("등급 : C");
			}
		}
		sc.close();
	}

}
