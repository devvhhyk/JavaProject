package Test_0418;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CreateCompleteAction {
	JPanel detailMenuPanel;
	JPanel Right_panel;
	JPanel menuPanel;
	JLabel messageLabel;
	int DEFAULT_SIZE;
	String message;
	JPanel processedMenuPanel;
	
	public CreateCompleteAction(
			JPanel detailMenuPanel,
			JPanel Right_panel,
			JPanel menuPanel,
			JLabel messageLabel,
			int DEFAULT_SIZE,
			String message,
			JPanel processedMenuPanel
			) {
		this.detailMenuPanel = detailMenuPanel;
		this.Right_panel = Right_panel;
		this.menuPanel = menuPanel;
		this.messageLabel = messageLabel;
		this.DEFAULT_SIZE = DEFAULT_SIZE;
		this.message = message;
		this.processedMenuPanel = processedMenuPanel;
	}
	
	public void Creating() {
		// 완료 버튼 생성
        JButton completeButton = new JButton("완료");
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
        		CreateProcessPanel cpp = new CreateProcessPanel(message, Right_panel, processedMenuPanel, DEFAULT_SIZE);
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