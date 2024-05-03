package Test_0418;

import java.awt.EventQueue;

//Main 클래스는 프로그램의 진입점입니다.
public class Main {
 public static void main(String[] args) {
     // EventQueue.invokeLater()을 사용하여 GUI를 생성하고 표시합니다.
     EventQueue.invokeLater(() -> {
         try {
             // GUIManager의 인스턴스를 생성하고 GUI를 표시합니다.
             GUIManager guiManager = GUIManager.getInstance();
             guiManager.show();
         } catch (Exception e) {
             e.printStackTrace();
         }
     });
   }
}