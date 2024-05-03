package Test_0418;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CreateOrderPanel {
	JPanel menuPanel;
	String message;
	JPanel Right_panel;
	JLabel messageLabel;
	JPanel processedMenuPanel;
	int DEFAULT_SIZE;

	public CreateOrderPanel(
			JPanel menuPanel,
			String message, 
			JPanel Right_panel,
			JLabel messageLabel, 
			JPanel processedMenuPanel,
			int DEFALT_SIZE
			) {
		this.menuPanel = menuPanel;
		this.message = message;
		this.Right_panel = Right_panel;
		this.messageLabel = messageLabel;
		this.processedMenuPanel = processedMenuPanel;
		this.DEFAULT_SIZE = DEFALT_SIZE;
	}
	
	public void Creating() {
		// 메뉴 패널에 추가할 메시지 라벨 생성
		messageLabel = new JLabel(message);
		messageLabel.setBounds(30, 10, 750, 80);
		messageLabel.setBackground(Color.yellow);
		messageLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		messageLabel.setOpaque(true);
		messageLabel.setLayout(null);
		menuPanel.add(messageLabel); // 메뉴 패널에 메시지 라벨 추가
		
		int posY = 10; // 초기 Y 위치 설정

		// 메뉴 패널의 컴포넌트 배열을 리스트로 변환
		List<Component> components = Arrays.asList(menuPanel.getComponents());

		// 컴포넌트를 역순으로 반복하여 추가
		for (int i = components.size() - 1; i >= 0; i--) {
		    Component component = components.get(i);
		    component.setLocation(component.getX(), posY); // 현재 위치 posY에 컴포넌트 이동
		    posY += 90; // 다음 컴포넌트의 Y 위치 설정
		}
		
		// menuPanel의 부모의 부모 컨테이너인 JScrollPane 가져오기
		// (부모는 JViewport이기에 그의 부모인 JScrollPane을 가져오기 위해선 조상을 가져와야 한다)
		JScrollPane scrollPane = (JScrollPane) menuPanel.getParent().getParent();

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
		JButton detailButton = new JButton("상세");
		detailButton.setBounds(680, 20, 50, 40);
		detailButton.setFont(new Font("맑은 고딕", Font.PLAIN, 8));
		messageLabel.add(detailButton); // 메시지 라벨에 상세 버튼 추가
      
		detailButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 상세 버튼이 클릭된 경우 상세 패널 생성
				CreateDetailPanel cdp = new CreateDetailPanel(menuPanel, message, Right_panel, messageLabel, processedMenuPanel, DEFAULT_SIZE);
				cdp.Creating();
			}
		});
	}
}