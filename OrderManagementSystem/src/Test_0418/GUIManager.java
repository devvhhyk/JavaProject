package Test_0418;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class GUIManager {
    private static GUIManager instance;

    private JFrame frame;
    private JPanel Left_panel;
    private JPanel Right_panel;
    private JPanel menuPanel;
    private JPanel detailMenuPanel;
    private JPanel processedMenuPanel;
    private JLabel messageLbl;
    private JLabel messageLabel;
    private JButton completeButton;
    private JButton detailButton;

    private GUIManager() {
        initialize();
    }

    public static synchronized GUIManager getInstance() {
        if (instance == null) {
            instance = new GUIManager();
        }
        return instance;
    }

    public void show() {
        frame.setVisible(true);
    }

    private void initialize() {
    	// 프레임 초기화
        frame = new JFrame();
        frame.setBounds(100, 100, 1600, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setLayout(new GridBagLayout());

        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.fill = GridBagConstraints.BOTH;
        gbc1.weightx = 0.6;
        gbc1.weighty = 1.0;
        gbc1.gridx = 0;
        gbc1.gridy = 0;

        // 왼쪽 패널 생성
        Left_panel = new JPanel();
        Left_panel.setBackground(Color.black);
        Left_panel.setLayout(null);
        frame.getContentPane().add(Left_panel, gbc1);

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.fill = GridBagConstraints.BOTH;
        gbc2.weightx = 0.4;
        gbc2.weighty = 1.0;
        gbc2.gridx = 1;
        gbc2.gridy = 0;

        // 오른쪽 패널 생성
        Right_panel = new JPanel();
        Right_panel.setBackground(Color.lightGray);
        Right_panel.setLayout(null);
        frame.getContentPane().add(Right_panel, gbc2);

        // 왼쪽 패널에 추가할 메뉴패널 생성
        menuPanel = new JPanel();
        menuPanel.setBounds(25, 20, 800, 390);
        menuPanel.setBackground(Color.gray);
        menuPanel.setLayout(null);
        
        // 메뉴패널에 추가할 스크롤 패널 생성
        JScrollPane scrollPane = new JScrollPane(menuPanel);
        scrollPane.setBounds(25, 20, 800, 390);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(20, 10));
        Left_panel.add(scrollPane);
        
        // 왼쪽 패널에 추가할 처리된 메뉴 패널 생성
        processedMenuPanel = new JPanel();
        processedMenuPanel.setBounds(25, 440, 800, 400);
        processedMenuPanel.setBackground(Color.WHITE);
        processedMenuPanel.setLayout(null);
        Left_panel.add(processedMenuPanel);
        
        // 처리된 메뉴 패널에 추가할 스크롤 패널 생성
        scrollPane = new JScrollPane(processedMenuPanel);
        scrollPane.setBounds(25, 440, 800, 400);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(20, 10));
        Left_panel.add(scrollPane);

        // messageLbl 초기화
        messageLbl = new JLabel();

        ClientMessageHandler cmHandler = new ClientMessageHandler();
        cmHandler.messageReceived(frame, messageLbl);
    }
    
    // ClientMessageHandler 클래스 내부에서 메시지를 받아오는 메서드
    public void messageReceived(String message) {
        GUIManager.getInstance().processSocketMessage(message);
    }

    public void processSocketMessage(String message) {
        
		// 메시지를 보여줄 라벨 생성
    	CreateOrderPanel cop = new CreateOrderPanel(menuPanel,message,detailMenuPanel,Right_panel,messageLabel,processedMenuPanel,Left_panel, completeButton, detailButton);
    	cop.creating();
    	
    	Left_panel.revalidate();
        Left_panel.repaint();
        Right_panel.revalidate();
        Right_panel.repaint();
    }
}
