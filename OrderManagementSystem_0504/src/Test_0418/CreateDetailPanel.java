package Test_0418;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CreateDetailPanel {
	JPanel menuPanel;
	String message;
	JPanel Right_panel;
	JLabel messageLabel;
	JPanel processedMenuPanel;
	int DEFAULT_SIZE;
    
    public CreateDetailPanel(
    		JPanel menuPanel,
			String message,
			JPanel Right_panel,
			JLabel messageLabel, 
			JPanel processedMenuPanel,
			int DEFAULT_SIZE
    		) {
    	this.menuPanel = menuPanel;
		this.message = message;
		this.Right_panel = Right_panel;
		this.messageLabel = messageLabel;
		this.processedMenuPanel = processedMenuPanel;
		this.DEFAULT_SIZE = DEFAULT_SIZE;
    }
    
    public void Creating() {
        // 현재 라벨의 텍스트를 가져옴
        String labelText = message;

        // "@" 기준으로 분할하여 배열에 저장
        String[] items = labelText.split("@");

        // 배열의 각 문자열에 대해 ';'을 공백으로 대체
        for (int i = 0; i < items.length; i++) {
            items[i] = items[i].replace(";", "        ");
        }

        // 오른쪽 패널에 추가할 상세 메뉴 패널 생성
        JPanel detailMenuPanel = new JPanel();
        detailMenuPanel.setBounds(60, 80, 500, 650);
        detailMenuPanel.setBackground(Color.blue);
        detailMenuPanel.setLayout(null);
        
        Right_panel.add(detailMenuPanel); // 오른쪽 패널에 상세 메뉴 패널 추가

        // 상세 메뉴 패널에 각 항목을 표시할 JLabel 생성 및 추가
        int y = 35; // 시작 Y 위치

        for (String item : items) {
            JLabel detailLabel = new JLabel(item.trim()); // 앞뒤 공백 제거
            detailLabel.setBounds(30, y, 400, 35); // 위치와 크기 설정
            detailLabel.setBackground(Color.LIGHT_GRAY);
            detailLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
            detailLabel.setOpaque(true); // JLabel의 배경색이 표시되도록 설정

            detailMenuPanel.add(detailLabel); // 상세 메뉴 패널에 상세 라벨 추가
            y += 40; // 다음 항목의 Y 위치 조정
        }
        
        // 변경된 내용을 적용하기 위해 디테일 메뉴 패널 다시 그리기
        detailMenuPanel.revalidate();
        detailMenuPanel.repaint();
        
        CreateCompleteAction cca = new CreateCompleteAction(detailMenuPanel, Right_panel, menuPanel, messageLabel, DEFAULT_SIZE, message, processedMenuPanel);
        cca.Creating();
    }
}