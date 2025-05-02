package networkTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleClient {
    public static void main(String[] args) {
        String serverIP = "127.0.0.1"; // localhost
        int port = 9999;

        try (Socket socket = new Socket(serverIP, port)) {
        	
            // 서버에 데이터 보내기
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("안녕하세요");

            // 서버로부터 응답 받기
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverResponse = in.readLine();
            System.out.println("서버 응답: " + serverResponse);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}