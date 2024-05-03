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
	JPanel detailMenuPanel;
	JPanel Right_panel;
	JLabel messageLabel;
	JPanel processedMenuPanel;
	JPanel Left_panel;
	JButton completeButton;
	JButton detailButton;
	private int DEFAULT_SIZE = 370;
    
    public CreateDetailPanel(
    		JPanel menuPanel,
			String message, 
			JPanel detailMenuPanel,
			JPanel Right_panel,
			JLabel messageLabel, 
			JPanel processedMenuPanel,
			JPanel Left_panel,
			JButton completeButton,
			JButton detailButton
    		) { // 변경: 생성자에 메시지 라벨 추가
    	this.menuPanel = menuPanel;
		this.message = message;
		this.detailMenuPanel = detailMenuPanel;
		this.Right_panel = Right_panel;
		this.messageLabel = messageLabel;
		this.processedMenuPanel = processedMenuPanel;
		this.Left_panel = Left_panel;
		this.completeButton = completeButton;
		this.detailButton = detailButton;
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
            detailLabel.setOpaque(true); // JLabel의 배경색이 표시되도록 설정

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
        		
        		menuPanel.remove(messageLabel); // 메뉴 패널의 메시지 라벨 삭제
        		
        		// 메뉴 패널의 컴포넌트들을 재배치
                int posY = 10;
                for(int i = menuPanel.getComponentCount() - 1; i >= 0; i--) {
                	menuPanel.getComponent(i).setLocation(menuPanel.getComponent(i).getX(), posY);
                	posY += 90;
                }
                
                // 변경된 내용을 적용하기 위해 JScrollPane의 크기를 다시 설정
                JScrollPane scrollPane = (JScrollPane) menuPanel.getParent().getParent(); // menuPanel의 부모 컨테이너인 JScrollPane 가져오기
                
                if(posY > DEFAULT_SIZE) {
                	menuPanel.setPreferredSize(new Dimension(menuPanel.getWidth(), posY));
                } else {
                	menuPanel.setPreferredSize(new Dimension(menuPanel.getWidth(), DEFAULT_SIZE));
                }
                
                menuPanel.repaint();
                scrollPane.revalidate();
                
        		// 완료버튼 클릭시 처리화면에 메시지 패널 새로 그려넣기
        		CreateProcessPanel cpp = new CreateProcessPanel(menuPanel,message,detailMenuPanel,Right_panel,messageLabel,processedMenuPanel,Left_panel, completeButton, detailButton);
        		cpp.proCreating();
        		
                scrollPane.revalidate(); // 변경된 크기를 적용
                scrollPane.repaint(); // 다시 그리기

                menuPanel.repaint(); // 변경 사항을 적용
        		
        		// 변경 사항을 반영하기 위해 패널을 다시 그리기
        		Right_panel.revalidate();
        		Right_panel.repaint();
        	}
        });
    }
}

