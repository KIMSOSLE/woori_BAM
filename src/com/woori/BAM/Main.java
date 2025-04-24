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

		while (true) {
			System.out.printf("명령어) ");
			String cmd = sc.nextLine().trim();

			if (cmd.length() == 0) {
				System.out.println("명령어를 입력해 주세요.");
				continue;
			}
			// List 메서드 중 size() 이용 (Data 유무를 개체의 갯수(크기)로 변환)
			if (cmd.equals("article list")) {
				if (articles.size() == 0) {
					System.out.println("존재하는 게시글이 없습니다.");
					continue;
				}
				// 배열을 사용해 get() 이용 (객체를 리턴 받음)
				System.out.printf("번호    |    제목\n");
				for (int i = articles.size() -1; i >= 0; i--) {
					// article은 articles.get()으로 받은 객체를 재사용하기 위해 저장 용도로 사용
					Article article = articles.get(i);
					System.out.printf("%d       |     %s\n", article.id, article.title);
				}
			} else if (cmd.equals("article write")) {
				System.out.print("제목 : ");
				String title = sc.nextLine().trim();
				System.out.print("내용 : ");
				String body = sc.nextLine().trim();

				Article article = new Article(id, title, body); // 최적화 작업 : 생성자를 이용해 초기화, 인자를 통해 생성자 호출
				// 진짜 저장은 아래의 문장을 통해서 진행
				articles.add(article); // List 구조인 ArrayList 객체 articles에 저장

				System.out.println(id + "번 글이 생성되었습니다.");
				id++;
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