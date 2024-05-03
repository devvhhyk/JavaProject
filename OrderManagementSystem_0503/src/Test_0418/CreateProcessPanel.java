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

public class CreateProcessPanel {
	JPanel menuPanel;
	String message;
	JPanel detailMenuPanel;
	JPanel Right_panel;
	JLabel messageLabel;
	JPanel processedMenuPanel;
	JPanel Left_panel;
	JButton completeButton;
	JButton detailButton;
	private int DEFAULT_SIZE = 380;
    
    public CreateProcessPanel(
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

	public void proCreating() {
	// 처리 패널에 추가할 메시지 라벨 생성
    messageLabel = new JLabel(message);
    messageLabel.setBounds(35, 10, 750, 80);
    messageLabel.setBackground(Color.yellow);
    messageLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
    messageLabel.setOpaque(true);
    messageLabel.setLayout(null);
    processedMenuPanel.add(messageLabel);
    
    int posY = 10;
    
    // 기존의 메뉴 패널 요소들을 한 칸씩 아래로 이동(새롭게 들어온 처리된 메뉴의 메시지 패널이 위에 뜨게 됨)
    for (Component component : processedMenuPanel.getComponents()) {
  	  	component.setLocation(component.getX(), posY);
  	  	posY += 90; // 다음 라벨의 Y 위치 설정
    }
    
    // processedMenuPanel의 부모 컨테이너인 JScrollPane 가져오기
    JScrollPane scrollPane = (JScrollPane)processedMenuPanel.getParent().getParent();
    
    // 처리 메뉴 패널이 스크롤 패널의 크기를 초과하는지 확인하고 스크롤이 필요한 경우에만 스크롤 패널의 크기를 조정
    if(posY > DEFAULT_SIZE) {
    	// 스크롤이 필요한 경우에는 스크롤 패널의 크기를 처리 메뉴 패널의 크기로 설정
    	processedMenuPanel.setPreferredSize(new Dimension(0, posY));
    	processedMenuPanel.repaint();
    	scrollPane.revalidate();
    } else {
    	// 스크롤이 필요하지 않은 경우에는 스크롤 패널의 크기를 기존 설정값으로 유지
    	processedMenuPanel.setPreferredSize(new Dimension(0,DEFAULT_SIZE));
    	processedMenuPanel.repaint();
    }
    
    detailButton = new JButton("상세");
    detailButton.setBounds(680, 20, 50, 40);
    detailButton.setFont(new Font("맑은 고딕", Font.PLAIN, 8));
    messageLabel.add(detailButton);
    
    detailButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
    	  CreateProcessDetailPanel cpdp = new CreateProcessDetailPanel(menuPanel, message, detailMenuPanel, Right_panel, messageLabel, processedMenuPanel, Left_panel, completeButton);
    	  cpdp.Creating();
    	  System.out.println(cpdp);
      }	
    });
    
    // 변경된 내용을 적용하기 위해 JScrollPane의 크기를 다시 설정
    scrollPane = (JScrollPane) processedMenuPanel.getParent().getParent(); // processedMenuPanel의 부모 컨테이너인 JScrollPane 가져오기
    
    scrollPane.revalidate(); // 변경된 크기를 적용
    scrollPane.repaint(); // 다시 그리기
    
    processedMenuPanel.repaint();
	}
}