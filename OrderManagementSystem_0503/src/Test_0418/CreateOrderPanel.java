package Test_0418;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CreateOrderPanel {
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

	public CreateOrderPanel(
			JPanel menuPanel,
			String message, 
			JPanel detailMenuPanel,
			JPanel Right_panel,
			JLabel messageLabel, 
			JPanel processedMenuPanel,
			JPanel Left_panel,
			JButton completeButton,
			JButton detailButton
			) {
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
	
	public void creating() {
		// 메뉴 패널에 추가할 메시지 라벨 생성
		messageLabel = new JLabel(message);
		messageLabel.setBounds(30, 10, 750, 80);
		messageLabel.setBackground(Color.yellow);
		messageLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		messageLabel.setOpaque(true);
		messageLabel.setLayout(null);
		menuPanel.add(messageLabel);
		
		int posY = 10; // 초기 Y 위치 설정

		// 기존의 메뉴 패널 요소들을 한 칸씩 아래로 이동(새로운 메뉴의 메시지 패널이 위에 뜨게 됨)
		for (Component component : menuPanel.getComponents()) {
		    component.setLocation(component.getX(), posY);
		    posY += 90; // 다음 메시지 라벨의 Y 위치 설정
		}

		JScrollPane scrollPane = (JScrollPane) menuPanel.getParent().getParent(); // menuPanel의 부모 컨테이너인 JScrollPane 가져오기

		// 메뉴 패널이 스크롤 패널의 크기를 초과하는지 확인하고 스크롤이 필요한 경우에만 스크롤 패널의 크기를 조정
		if (posY > DEFAULT_SIZE) {
		    // 스크롤이 필요한 경우에는 스크롤 패널의 크기를 메뉴 패널의 크기로 설정
		    menuPanel.setPreferredSize(new Dimension(0, posY));
		    menuPanel.repaint();
		    scrollPane.revalidate();
		} else {
		    // 스크롤이 필요하지 않은 경우에는 스크롤 패널의 크기를 기존 설정값으로 유지
		    menuPanel.setPreferredSize(new Dimension(0, DEFAULT_SIZE));
		    menuPanel.repaint();
		}
      
		// 메시지라벨에 추가할 상세버튼 생성
		detailButton = new JButton("상세");
		detailButton.setBounds(680, 20, 50, 40);
		detailButton.setFont(new Font("맑은 고딕", Font.PLAIN, 8));
		messageLabel.add(detailButton);
      
      detailButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	// ActionEvent.getSource()를 사용하여 이벤트를 발생시킨 컴포넌트 확인
            JButton button = (JButton) e.getSource();
            if (button == detailButton) {
                // 상세 버튼이 클릭된 경우 상세 패널 생성
                CreateDetailPanel cdp = new CreateDetailPanel(menuPanel,message,detailMenuPanel,Right_panel,messageLabel,processedMenuPanel,Left_panel, completeButton, detailButton);
                cdp.Creating();
            }
        }
    });
	}
}
