package com.woori.BAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("== 프로그램 시작 ==");
		Scanner sc = new Scanner(System.in);

		int lastArticleId = 1; // 게시글 번호, 마지막 게시글 번호의 의미로 수정
		List<Article> articles = new ArrayList<>();

		while (true) {
			System.out.printf("명령어) ");
			String cmd = sc.nextLine().trim();

			if (cmd.length() == 0) {
				System.out.println("명령어를 입력해 주세요.");
				continue;
			}
			if (cmd.equals("article write")) {
				System.out.printf("제목 : ");
				String title = sc.nextLine().trim();
				System.out.printf("내용 : ");
				String body = sc.nextLine().trim();

				Article article = new Article(lastArticleId, title, body);
				articles.add(article);

				System.out.println(lastArticleId + "번 글이 생성되었습니다.");
				lastArticleId++;

			} else if (cmd.equals("article list")) {
				if (articles.size() == 0) {
					System.out.println("존재하는 게시글이 없습니다.");
					continue;
				} 
				System.out.printf("번호    |     제목\n");
				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);
					System.out.printf("%d      |     %s\n", article.id, article.title);
				}
			} else if (cmd.startsWith("article detail ")) { // 입력된 번호는 cmdBits[2] 위치
				String[] cmdBits = cmd.split(" "); // split 문자열 자를 때 사용
				
//				boolean articleChk = false; // 참 거짓 체크. 객체지향프로그래밍 위한 준비
				// 객체로 대체 (변수 vs 객체) 변수 1개, 객체(번호, 제목, 내용)
				
				Article foundArticle = null; // null 검증 (객체지향프로그래밍)
				// 개발자가 고민해야 할 영역. (ex. try catch문)
				
				int id = Integer.parseInt(cmdBits[2]); // 재정의. 가독성↑, 재활용↑
				
				for (Article article : articles) {
					if (article.id == id) { // 문자로 된 숫자를 숫자로 바꿔줌
//						articleChk = true;
						foundArticle = article;
						break;
					}
				}
//				if (articleChk == false) {
				if (foundArticle == null) {
					System.out.println(id + "번 게시글이 존재하지 않습니다.");
					continue; // 매우 중요! 아래에서 NumllPointException 발생되지 않도록 조치
				}
				System.out.println("번호 : " + foundArticle.id);
				System.out.println("날짜 : ~~~");
				System.out.println("제목 : " + foundArticle.title);
				System.out.println("내용 : " + foundArticle.body);
				// 출력문 위치 바꾼 이유 : 재활용을 위한 준비. 공통으로 사용하는 메소드 만듦

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