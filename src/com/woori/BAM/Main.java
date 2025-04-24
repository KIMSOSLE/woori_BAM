package com.woori.BAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		System.out.println("== 프로그램 시작 ==");
		Scanner sc = new Scanner(System.in);

		int id = 1;
		List<Article> articles = new ArrayList<>();
		// List 인터페이스 - ArryList 구현 클레스

		while (true) {
			System.out.printf("명령어) ");
			String cmd = sc.nextLine().trim();

			if (cmd.length() == 0) {
				System.out.println("명령어를 입력해 주세요.");
				continue;
			}

			if (cmd.equals("article list")) {
				System.out.println("게시글이 없습니다.");
			} else if (cmd.equals("article write")) {
				System.out.print("제목 : ");
				String title = sc.nextLine().trim();
				System.out.print("내용 : ");
				String body = sc.nextLine().trim();
				
//				Article article = new Article(); // 최적화 X, // article은 지역변수 즉, 저장되지 않음
				Article article = new Article(id, title, body); // 최적화 작업 : 생성자를 이용해 초기화, 인자를 통해 생성자 호출
				
//				article.id = id;
//				article.title = title;
//				article.body = body;

				// 진짜 저장은 아래의 문장을 통해서 진행
				articles.add(article); // List 구조인 ArrayList 객체 articles에 저장
				
				// 최적화2
//				articles.add(new Article(id, title, body));

				System.out.println(id + "번 글이 생성되었습니다.");
				id++;
			} else if (cmd.equals("test")) { // 명령어 test로 articles 저장된 내용 확인
				for (int i = 0; i < articles.size(); i++) {
					System.out.println(articles.get(i).id);
					System.out.println(articles.get(i).title);
					System.out.println(articles.get(i).body);
				}
			} else {
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

class Article {
	int id;
	String title;
	String body;

	public Article(int id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
	}
}