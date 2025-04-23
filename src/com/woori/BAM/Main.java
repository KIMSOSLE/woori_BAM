package com.woori.BAM;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		System.out.println("== 프로그램 시작 ==");
		Scanner sc = new Scanner(System.in);
		
		int id = 1;
		// 저장을 위한 변수이기 때문에 반복문 밖에 선언
		// 반복문 내 선언 시 매번 초기화됨
		while (true) {
			System.out.printf("명령어) ");
			String cmd = sc.nextLine().trim(); // 공백제거를 위해 trim() 함수 사용

			if (cmd.length() == 0) {
				// 문자열의 길이가 0인지 확인 즉, cmd가 빈 문자열("")인지 검사
				// 사용자가 아무 명령어를 입력하지 않았다면
				System.out.println("명령어를 입력해 주세요.");
				continue; // 아래쪽에 있는 출력이 실행되지 않도록 기다리기 위해 사용
			}
			
			if (cmd.equals("article list")) {
				System.out.println("게시글이 없습니다.");
			} 
			else if (cmd.equals("article write")) {
				System.out.print("제목 : ");
				String title = sc.nextLine().trim();
				System.out.print("내용 : ");
				String body = sc.nextLine().trim();
				System.out.println(id + "번 글이 생성되었습니다.");
				id++;
			}
			else {
				System.out.println("존재하지 않는 명령어 입니다.");
			}
			
			if (cmd.equals("exit")) {
				break;
			}
		}
		sc.close();
		System.out.println("== 프로그램 종료 ==");
	}
}