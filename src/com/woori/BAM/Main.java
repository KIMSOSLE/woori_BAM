package com.woori.BAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Article> articles = new ArrayList<>();
	static int lastArticleId = 1;

	public static void main(String[] args) {
		System.out.println("== 프로그램 시작 ==");
		Scanner sc = new Scanner(System.in);

		makeTestData(); // 중요★ 해당 메서드가 만들어지는 위치는? static 메서드일 수 밖에 없는 이유는?

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

				Article article = new Article(lastArticleId, title, body, Util.getDateStr(), 0);
				articles.add(article);

				System.out.println(lastArticleId + "번 글이 생성되었습니다.");
				lastArticleId++;

			} else if (cmd.equals("article list")) {
				if (articles.size() == 0) {
					System.out.println("존재하는 게시글이 없습니다.");
					continue;
				}

				System.out.printf("번호     |      제목      |      내용      |         날짜/시간         |     조회수\n");
				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);
					System.out.printf("%d        |     %s      |     %s      |    %s    |       %d\n", article.id,
							article.title, article.body, article.regDate, article.viewCnt);
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

				foundArticle.viewCnt++; // 위 null 검증 통과했으므로 조회수 1 증가시킴

				System.out.println("번호 : " + foundArticle.id);
				System.out.printf("날짜/시간 : " + foundArticle.regDate);
				System.out.println("\n제목 : " + foundArticle.title);
				System.out.println("내용 : " + foundArticle.body);
				System.out.println("조회수 : " + foundArticle.viewCnt);

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

				System.out.println("수정할 제목 : ");
				String title = sc.nextLine().trim();
				System.out.println("수정할 내용 : ");
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

	private static void makeTestData() {
		// 1단계 → 객체 생성
//		Article articles1 = new Article(lastArticleId, "제목1", "내용1", Util.getDateStr(), 10);
//		articles.add(articles1);
//		lastArticleId++;

		// 2단계 → 후위연산자 사용, 한 줄로 최적화
//		articles.add(new Article(lastArticleId++, "제목1", "내용1", Util.getDateStr(), 10));

		// 3단계 → 반복문
		for (int i = 1; i <= 5; i++) {
			articles.add(new Article(lastArticleId++, "제목" + i, "내용" + i, Util.getDateStr(), i * 10));
		}
	}
}

class Article {
	int id;
	String title;
	String body;
	String regDate;
	int viewCnt;

	public Article(int id, String title, String body, String regDate, int viewCnt) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.regDate = regDate;
		this.viewCnt = viewCnt;
	}
}
