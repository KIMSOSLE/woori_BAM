package networkTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static void main(String[] args) {
        int port = 9999; // 서버 포트

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("서버 연결 완료! 클라이언트 대기 중...");
            
            // 클라이언트 연결 받기
            Socket clientSocket = serverSocket.accept();
            System.out.println("클라이언트가 연결되었습니다.");

            // 클라이언트로부터 메시지 받기
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String clientMessage = in.readLine();
            System.out.println("클라이언트 :  " + clientMessage);

            // 클라이언트에게 응답 보내기
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("네, 안녕하세요");

            // 클라이언트 소켓 닫기
            clientSocket.close();
            System.out.println("서버 종료");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
