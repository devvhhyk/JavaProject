package Test_0418;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CreateProcessDetailPanel {
	JPanel menuPanel;
	String message;
	JPanel detailMenuPanel;
	JPanel Right_panel;
	JLabel messageLabel;
	JPanel processedMenuPanel;
	JPanel Left_panel;
	JButton completeButton;
    
    public CreateProcessDetailPanel(
    		JPanel menuPanel,
			String message, 
			JPanel detailMenuPanel,
			JPanel Right_panel,
			JLabel messageLabel, 
			JPanel processedMenuPanel,
			JPanel Left_panel,
			JButton completeButton
    		) { // 변경: 생성자에 메시지 라벨 추가
    	this.menuPanel = menuPanel;
		this.message = message;
		this.detailMenuPanel = detailMenuPanel;
		this.Right_panel = Right_panel;
		this.messageLabel = messageLabel;
		this.processedMenuPanel = processedMenuPanel;
		this.Left_panel = Left_panel;
		this.completeButton = completeButton;
    }
    
    public void Creating() {
    	 // 현재 라벨의 텍스트를 가져옴
        String labelText = message;

        // "@" 기준으로 분할하여 배열에 저장
        String[] items = labelText.split("@");

        // 배열의 각 문자열에 대해 ';'을 공백으로 대체
        for (int i = 0; i < items.length; i++) {
            items[i] = items[i].replace(";", "          ");
        }

        // 상세 메뉴 패널 초기화
        detailMenuPanel = new JPanel();
        detailMenuPanel.setBounds(60, 80, 500, 650);
        detailMenuPanel.setBackground(Color.blue);
        detailMenuPanel.setLayout(null);
        
        Right_panel.add(detailMenuPanel);

        // 상세 메뉴 패널에 각 항목을 표시할 JLabel 생성 및 추가
        int y = 35; // 시작 Y 위치
        for (String item : items) {
            JLabel detailLabel = new JLabel(item.trim()); // 앞뒤 공백 제거
            detailLabel.setBounds(30, y, 400, 35); // 위치와 크기 설정
            detailLabel.setBackground(Color.LIGHT_GRAY);
            detailLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
            detailLabel.setOpaque(true);

            detailMenuPanel.add(detailLabel); // 상세 메뉴 패널에 추가
            y += 40; // 다음 항목의 Y 위치 조정
        }
        
        // 변경된 내용을 적용하기 위해 디테일 메뉴 패널 다시 그리기
        detailMenuPanel.revalidate();
        detailMenuPanel.repaint();
        
        completeButton = new JButton("완료");
        completeButton.setBounds(185, 550, 100, 30);
        detailMenuPanel.add(completeButton); // detailMenuPanel에 완료 버튼 추가
        
        // 완료 버튼의 액션 리스너를 정의합니다.
        completeButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        	
        		Right_panel.removeAll(); // 상세 메뉴 패널 자체를 제거
        		
        		// 변경 사항을 반영하기 위해 패널을 다시 그리기
        		Right_panel.revalidate();
        		Right_panel.repaint();
        	}
        });
    }
}