package com.woori.BAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.woori.BAM.dto.Article;
import com.woori.BAM.uil.Util;

public class App {
	
	// 전역변수 → this (자기 자신 의미, 객체)
	List<Article> articles; // List 타입의 articles
	int lastArticleId;
	
	// 생성자를 통해 초기화 (기존 static 코드 제거 상태)
	App() {
		articles = new ArrayList<>(); // 데이터의 구조 = ArrayList 형태의 객체 생성
		lastArticleId = 1;            // 객체 객수 정할 필요X, 사용할 때마다 증가
	}

	void run() {
		System.out.println("== 프로그램 시작 ==");
		Scanner sc = new Scanner(System.in);

		makeTestData();

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
					System.out.printf("%d        |     %s      |     %s      |    %s    |       %d\n", article.getId(),
							article.getTitle(), article.getBody(), article.getRegDate(), article.getViewCnt());
				}

			} else if (cmd.startsWith("article detail ")) {
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
					if (article.getId() == id) {
						foundArticle = article;
						break;
					}
				}

				if (foundArticle == null) {
					System.out.println(id + "번 게시글이 존재하지 않습니다.");
					continue;
				}

				foundArticle.setViewCnt(foundArticle.getViewCnt() + 1);

				System.out.println("번호 : " + foundArticle.getId());
				System.out.printf("날짜/시간 : " + foundArticle.getRegDate());
				System.out.println("\n제목 : " + foundArticle.getTitle());
				System.out.println("내용 : " + foundArticle.getBody());
				System.out.println("조회수 : " + foundArticle.getViewCnt());

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
					if (article.getId() == id) {
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
					if (article.getId() == id) {
						foundArticle = article;
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

				foundArticle.setTitle(title);
				foundArticle.setBody(body);

				System.out.println(id + "번 게시글이 수정 되었습니다.");
			}

			else {
				System.out.println("존재하지 않는 명령어 입니다.");
			}
		}

		sc.close();
		System.out.println("== 프로그램 종료 ==");
	}

	private void makeTestData() {
		for (int i = 1; i <= 5; i++) {
			articles.add(new Article(lastArticleId++, "제목" + i, "내용" + i, Util.getDateStr(), i * 10));
		}
	}
}