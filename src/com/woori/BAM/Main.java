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

			if (cmd.equals("exit")) {
				break;
			}

			if (cmd.length() == 0) {
				System.out.println("명령어를 입력해 주세요.");
				continue;
			}

			if (cmd.equals("article write")) {
				System.out.printf("제목 : ");
				String title = sc.nextLine().trim();
				System.out.printf("내용 : ");
				String body = sc.nextLine().trim();
				
//				// 회원가입, 게시글 수정 등 공통 모듈 만드는 것 → 메서드 작성
//				Util.getDateStr();
//				LocalDateTime now = LocalDateTime.now(); // 현재 날짜와 시간
//				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // 날짜와 시간 포맷 지정
//				String formatedNow = now.format(formatter); // 문자열로 변환
//				String regDate = formatedNow; // 재활용 용도

				Article article = new Article(lastArticleId, title, body, Util.getDateStr());
				articles.add(article);

				System.out.println(lastArticleId + "번 글이 생성되었습니다.");
				lastArticleId++;

			} else if (cmd.equals("article list")) {
				if (articles.size() == 0) {
					System.out.println("존재하는 게시글이 없습니다.");
					continue;
				}

				System.out.printf("번호    |     제목    |     내용    |         날짜/시간\n");
				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);
					System.out.printf("%d       |     %s     |     %s     |     %s\n", article.id, article.title, article.body, article.regDate);
				}

			} else if (cmd.startsWith("article detail ")) {
				String[] cmdBits = cmd.split(" ");

				Article foundArticle = null; // null 검증 (객체지향프로그래밍)

				int id = 0;

				try {
					id = Integer.parseInt(cmdBits[2]);
				} catch (NumberFormatException e) {
					System.out.println("숫자로 입력해주세요.");
					continue;
				} catch (Exception e) {
				}

				for (Article article : articles) {
					if (article.id == id) {
						foundArticle = article;
						break;
					}
				}
				
				
				if (foundArticle == null) {
					System.out.println(id + "번 게시글이 존재하지 않습니다.");
					continue;
				}
				System.out.println("번호 : " + foundArticle.id);
				System.out.printf("날짜/시간 : " + foundArticle.regDate);
				System.out.println("\n제목 : " + foundArticle.title);
				System.out.println("내용 : " + foundArticle.body);

			} else if (cmd.startsWith("article delete ")) {
				String[] cmdBits = cmd.split(" ");
				Article foundArticle = null;
				int id = 0;

				try {
					id = Integer.parseInt(cmdBits[2]);
				} catch (NumberFormatException e) {
					System.out.println("숫자로 입력해주세요.");
					continue;
				} catch (Exception e) {
				}

				int foundIndex = -1; // null과 같은 개념, -1로 초기화

				for (Article article : articles) {
					if (article.id == id) {
						foundArticle = article;
						break;
					}
				}

				if (foundArticle == null) {
					System.out.println(id + "번 게시글이 존재하지 않습니다.");
					continue;
				}
				articles.remove(foundArticle);
				System.out.println(id + "번 게시글이 삭제 되었습니다.");

			} else if (cmd.startsWith("article modify ")) {
				String[] cmdBits = cmd.split(" ");
				Article foundArticle = null;
				int id = 0;

				try {
					id = Integer.parseInt(cmdBits[2]);
				} catch (NumberFormatException e) {
					System.out.println("숫자로 입력해주세요.");
					continue;
				} catch (Exception e) {
				}

				for (Article article : articles) {
					if (article.id == id) {
						foundArticle = article; // 주소 복사
						break;
					}
				}

				if (foundArticle == null) {
					System.out.println(id + "번 게시글이 존재하지 않습니다.");
					continue;
				}
				
				System.out.println("수정할 제목 : " );
				String title = sc.nextLine().trim();
				System.out.println("수정할 내용 : " );
				String body = sc.nextLine().trim();
				
				foundArticle.title = title; // 수정된 값을 객체에 저장 → 수정
				foundArticle.body = body;
				
				System.out.println(id + "번 게시글이 수정 되었습니다.");
			}

			else {
				System.out.println("존재하지 않는 명령어 입니다.");
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
	String regDate;

	public Article(int id, String title, String body, String regDate) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.regDate = regDate;
	}
}