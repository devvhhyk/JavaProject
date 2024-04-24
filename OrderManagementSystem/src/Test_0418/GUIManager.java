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

// GUIManager 클래스는 GUI를 관리하고 생성합니다.
public class GUIManager {
    private static GUIManager instance;

    private JFrame frame; // JFrame 객체
    private JPanel pan_1; // JPanel 객체
    private JPanel pan_2; // JPanel 객체
    private JPanel detailMenuPanel; // 상세 메뉴를 표시할 JPanel 객체

    private GUIManager() {
        initialize(); // GUI 초기화 메서드 호출
    }

    // GUIManager의 인스턴스를 반환합니다.
    public static synchronized GUIManager getInstance() {
        if (instance == null) {
            instance = new GUIManager();
        }
        return instance;
    }

    // GUI를 표시합니다.
    public void show() {
        frame.setVisible(true);
    }

    // GUI를 초기화합니다.
    private void initialize() {
        // JFrame 객체 생성
        frame = new JFrame();
        frame.setBounds(100, 100, 1600, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setLayout(new GridBagLayout()); // GridBagLayout 설정

        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.fill = GridBagConstraints.BOTH;
        gbc1.weightx = 0.6;
        gbc1.weighty = 1.0;
        gbc1.gridx = 0;
        gbc1.gridy = 0;

        // JPanel 객체 생성 및 추가
        pan_1 = new JPanel();
        pan_1.setBackground(Color.black);
        pan_1.setLayout(null);
        frame.getContentPane().add(pan_1, gbc1);

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.fill = GridBagConstraints.BOTH;
        gbc2.weightx = 0.4;
        gbc2.weighty = 1.0;
        gbc2.gridx = 1;
        gbc2.gridy = 0;

        // JPanel 객체 생성 및 추가
        pan_2 = new JPanel();
        pan_2.setBackground(Color.lightGray);
        pan_2.setLayout(null);
        frame.getContentPane().add(pan_2, gbc2);
        
        // 메뉴를 나타내는 JPanel 객체 생성 및 추가
        JPanel menuPanel = new JPanel();
        menuPanel.setBounds(60, 30, 850, 300);
        menuPanel.setBackground(Color.gray);
        menuPanel.setLayout(null);
        pan_1.add(menuPanel);
        
        // 처리된 메뉴를 나타내는 JPanel 객체 생성 및 추가
        JPanel processedMenuPanel = new JPanel();
        processedMenuPanel.setBounds(60, 380, 850, 400);
        processedMenuPanel.setBackground(Color.WHITE);
        processedMenuPanel.setLayout(null);
        pan_1.add(processedMenuPanel);

        // 두 번째 버튼(상세보기 버튼) 생성
        JButton detailButton = new JButton("상세");
        detailButton.setBounds(700, 40, 50, 40); // 위치와 크기 설정
        detailButton.setFont(new Font("맑은 고딕", Font.PLAIN, 8)); // 폰트 크기 설정
        menuPanel.add(detailButton); // menuPanel에 추가

        // 두 번째 버튼(상세보기 버튼) 생성
        JButton detailButton2 = new JButton("상세");
        detailButton2.setBounds(700, 130, 50, 40); // 위치와 크기 설정
        detailButton2.setFont(new Font("맑은 고딕", Font.PLAIN, 8)); // 폰트 크기 설정
        menuPanel.add(detailButton2); // menuPanel에 추가
        

        // 두 번째 버튼(상세보기 버튼) 생성
        JButton detailButton3 = new JButton("상세");
        detailButton3.setBounds(700, 220, 50, 40); // 위치와 크기 설정
        detailButton3.setFont(new Font("맑은 고딕", Font.PLAIN, 8)); // 폰트 크기 설정
        menuPanel.add(detailButton3); // menuPanel에 추가
        

        // 두 번째 버튼(상세보기 버튼) 생성
        JButton detailButton4 = new JButton("상세");
        detailButton4.setBounds(700, 310, 50, 40); // 위치와 크기 설정
        detailButton4.setFont(new Font("맑은 고딕", Font.PLAIN, 8)); // 폰트 크기 설정
        menuPanel.add(detailButton4); // menuPanel에 추가
        
        Font f = new Font("맑은 고딕", Font.BOLD, 16);

        // 메시지를 나타내는 JLabel 객체 생성 및 추가
        JLabel messageLbl = new JLabel(" 1번주문 : 포카칩 오리지널;2개;6000@콜라;1개;3000@신라면;1개;3000");
        messageLbl.setBounds(30, 20, 730, 80);
        messageLbl.setBackground(Color.yellow);
        messageLbl.setFont(f);
        messageLbl.setOpaque(true);
        menuPanel.add(messageLbl);
        
        JLabel messageLbl2 = new JLabel(" 2번주문 : 홈런볼;2개;6000@떡볶이;1개;3000");
        messageLbl2.setBounds(30, 110, 730, 80);
        messageLbl2.setBackground(Color.yellow);
        messageLbl2.setFont(f);
        messageLbl2.setOpaque(true);
        menuPanel.add(messageLbl2);
        
        JLabel messageLbl3 = new JLabel(" 3번주문 : 콘칩;2개;6000@떡볶이;1개;1000@왕꿈틀이;1개;3000");
        messageLbl3.setBounds(30, 200, 730, 80);
        messageLbl3.setBackground(Color.yellow);
        messageLbl3.setFont(f);
        messageLbl3.setOpaque(true);
        menuPanel.add(messageLbl3);
        
        JLabel messageLbl4 = new JLabel(" 4번주문 : 도도한나쵸 치즈맛;2개;6000@떡볶이;1개;3000@콘칩;2개;6000@떡볶이;1개;1000@왕꿈틀이;1개;3000");
        messageLbl4.setBounds(30, 290, 730, 80);
        messageLbl4.setBackground(Color.yellow);
        messageLbl4.setFont(f);
        messageLbl4.setOpaque(true);
        menuPanel.add(messageLbl4);
        
        // 메뉴 패널을 감싸는 JScrollPane 생성
        JScrollPane scrollPane = new JScrollPane(menuPanel);
        scrollPane.setBounds(60, 30, 850, 300); // 기존 크기 유지
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        pan_1.add(scrollPane);

        // 스크롤이 항상 활성화되도록 설정
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(20, 10));

        // 메시지 라벨들의 높이 합산
        int totalHeight = messageLbl.getHeight() + messageLbl2.getHeight() + messageLbl3.getHeight() + messageLbl4.getHeight();

        // 스크롤 패널의 높이 설정
        int scrollPaneHeight = 400; // 원하는 높이로 설정하십시오

        // 메뉴 패널이 스크롤 패널의 크기를 초과하는지 확인하고 스크롤이 필요한 경우에만 스크롤 패널의 크기를 조정합니다.
        if (totalHeight > scrollPaneHeight) {
            // 스크롤이 필요한 경우에는 스크롤 패널의 크기를 메뉴 패널의 크기로 설정합니다.
            menuPanel.setPreferredSize(new Dimension(0, totalHeight));
        } else {
            // 스크롤이 필요하지 않은 경우에는 스크롤 패널의 크기를 기존 설정값으로 유지합니다.
            menuPanel.setPreferredSize(new Dimension(0, scrollPaneHeight));
        }
        
        // "상세" 버튼의 액션 리스너 등록
        detailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDetailMenu(messageLbl.getText());
            }
        });

        // "상세" 버튼의 액션 리스너 등록
        detailButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDetailMenu(messageLbl2.getText());
            }
        });

        // "상세" 버튼의 액션 리스너 등록
        detailButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDetailMenu(messageLbl3.getText());
            }
        });

        // "상세" 버튼의 액션 리스너 등록
        detailButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDetailMenu(messageLbl4.getText());
            }
        });
        
        // 클라이언트 메시지 핸들러 생성 및 메시지 수신 기능 실행
        ClientMessageHandler cmHandler = new ClientMessageHandler();
        cmHandler.messageReceived(frame, messageLbl);
    }
    
    // 상세 메뉴를 표시하는 메서드
    private void showDetailMenu(String message) {
        // 현재 라벨의 텍스트를 가져옴
        String labelText = message;
        
        // "1번주문" 이후의 문자열을 가져옴
        String itemsStr = labelText.substring(labelText.indexOf(":") + 1).trim();
        
        // "@" 기준으로 분할하여 배열에 저장
        String[] items = itemsStr.split("@");
        
        // 배열의 각 문자열에 대해 ';'을 공백으로 대체
        for (int i = 0; i < items.length; i++) {
            items[i] = items[i].replace(";", "     ");
        }
        
        // 상세 메뉴 패널 초기화
        detailMenuPanel = new JPanel();
        detailMenuPanel.setBounds(65, 70, 500, 600);
        detailMenuPanel.setBackground(Color.blue);
        detailMenuPanel.setLayout(null);
        pan_2.add(detailMenuPanel);
        
        // 상세 메뉴 패널에 각 항목을 표시할 JLabel 생성 및 추가
        int y = 30; // 시작 Y 위치
        for (String item : items) {
        	JLabel detailLabel = new JLabel(item.trim()); // 앞뒤 공백 제거
            detailLabel.setBounds(30, y, 400, 30); // 위치와 크기 설정
            detailLabel.setBackground(Color.LIGHT_GRAY);
            detailLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
            detailLabel.setOpaque(true);
            
            detailMenuPanel.add(detailLabel); // 상세 메뉴 패널에 추가
            y += 40; // 다음 항목의 Y 위치 조정
        }
        
        // 변경된 내용을 적용하기 위해 디테일 메뉴 패널 다시 그리기
        detailMenuPanel.revalidate();
        detailMenuPanel.repaint();
        
        // 완료 버튼을 생성하고 처리합니다.
        JButton completeButton = new JButton("완료");
        completeButton.setBounds(185, 550, 100, 30);
        detailMenuPanel.add(completeButton); // detailMenuPanel에 완료 버튼 추가
        
        completeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				detailMenuPanel.removeAll(); // 상세 메뉴 패널에 있는 모든 컴포넌트를 제거합니다.
		        
		        // 변경 사항을 반영하기 위해 패널을 다시 그립니다.
		        detailMenuPanel.revalidate();
		        detailMenuPanel.repaint();
			}
		});
        
        
    }
    
   
   

    
}
