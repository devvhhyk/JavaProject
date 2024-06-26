package Test_0418;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.io.*;
import java.net.*;

// 클라이언트로부터 메시지를 처리하는 클래스
public class ClientMessageHandler {

    // 서버로부터 메시지를 수신하고 처리하는 메서드
    public void messageReceived(JFrame frame, JLabel messageLbl) {
    	new Thread(new Runnable() {
    		@Override
            public void run() {
                try {
                    // 서버 소켓 생성 및 대기
                    ServerSocket serverSocket = new ServerSocket(1233);
                    while (true) { // 클라이언트와 연결될 때까지 기다림
                        // 클라이언트 소켓 연결
                        Socket clientSocket = serverSocket.accept();

                        // 클라이언트로부터 데이터를 읽고 쓰기 위한 스트림 생성
                        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

                        // 클라이언트로부터 메시지 수신
                        String message = reader.readLine();

                        // JLabel에 메시지 설정
                        messageLbl.setText(message);

                        // 메시지 다이얼로그로 표시
                        JOptionPane.showMessageDialog(frame, message);
                        GUIManager instance = GUIManager.getInstance();
                        instance.processSocketMessage(message);
                        
                        // 클라이언트 소켓 닫기
                        clientSocket.close();
                    }
                } catch (Exception e) {
                    // 예외 처리
                    e.printStackTrace();
                }
            }
        }).start();
    }

	public void messageReceived(GUIManager guiManager) {
		// TODO Auto-generated method stub
		
	}
}