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

public class CreateProcessPanel {
	String message;
	JPanel Right_panel;
	JPanel processedMenuPanel;
	int DEFAULT_SIZE;
    
    public CreateProcessPanel(
			String message, 
			JPanel Right_panel, 
			JPanel processedMenuPanel,
			int DEFAULT_SIZE
    ) {
		this.message = message;
		this.Right_panel = Right_panel;
		this.processedMenuPanel = processedMenuPanel;
		this.DEFAULT_SIZE = DEFAULT_SIZE;
    }

	public void proCreating() {
		// 처리 패널에 추가할 메시지 라벨 생성
		JLabel processOfmessageLabel = new JLabel(message);
		processOfmessageLabel.setBounds(35, 10, 750, 80);
		processOfmessageLabel.setBackground(Color.yellow);
		processOfmessageLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		processOfmessageLabel.setOpaque(true);
		processOfmessageLabel.setLayout(null);
		processedMenuPanel.add(processOfmessageLabel);
    
		int posY = 10; // 초기 Y 위치 설정

		// 메뉴 패널의 컴포넌트 배열을 리스트로 변환
		List<Component> components = Arrays.asList(processedMenuPanel.getComponents());

		// 컴포넌트를 역순으로 반복하여 추가
		for (int i = components.size() - 1; i >= 0; i--) {
		    Component component = components.get(i);
		    component.setLocation(component.getX(), posY); // 현재 위치 posY에 컴포넌트 이동
		    posY += 90; // 다음 컴포넌트의 Y 위치 설정
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
			processedMenuPanel.setPreferredSize(new Dimension(0, DEFAULT_SIZE));
			processedMenuPanel.repaint();
		}
    
		// 메시지 패널에 들어갈 상세 버튼 생성
		JButton detailButton = new JButton("상세");
		detailButton.setBounds(680, 20, 50, 40);
		detailButton.setFont(new Font("맑은 고딕", Font.PLAIN, 8));
		processOfmessageLabel.add(detailButton);
    
		detailButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CreateProcessDetailPanel cpdp = new CreateProcessDetailPanel(message, Right_panel);
				cpdp.proCreating();
			}	
		});
    
		// 변경된 내용을 적용하기 위해 JScrollPane의 크기를 다시 설정
		// processedMenuPanel의 부모 컨테이너인 JScrollPane 가져오기 (processedMenuPanel의 부모는 JView포트이므로 조상을 가져와야 JScroll을 가져올 수 있음)
		scrollPane = (JScrollPane) processedMenuPanel.getParent().getParent();
    
		scrollPane.revalidate(); // 변경된 크기를 적용
		scrollPane.repaint(); // 다시 그리기
    
		processedMenuPanel.repaint();
	}
}