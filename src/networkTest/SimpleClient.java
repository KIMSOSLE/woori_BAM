package networkTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleClient {
	public static void main(String[] args) {
		String serverIP = "127.0.0.1"; // 서버주소 (localhost = 내 컴퓨터)
		int port = 9999; // 서버의 대기 중인 포트 번호

		try (Socket socket = new Socket(serverIP, port)) { // IP + 포트 → 서버와 TCP 연결 → 성공 시 socket 객체를 통해 데이터 주고 받음
			// 서버에 메시지 전송 (요청 1)
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // 중요
			out.println("안녕하세요");

			// 서버 응답 수신
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String serverResponse = in.readLine();
			System.out.println("서버 응답: " + serverResponse);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}