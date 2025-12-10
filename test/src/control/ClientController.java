package control;

import communication.ClientNetwork;
import doundary.*;

import java.util.List;

public class ClientController {

     public ClientNetwork serverNetwork;
     private Screen currentScreen;

     // 各画面を保持（任意）
     private LoginScreen loginScreen;
     private SignUpScreen signUpScreen;
     private HomeScreen homeScreen;
     private BattleScreen battleScreen;
     private ResultScreen resultScreen;

     public ClientController(ClientNetwork serverNetwork) {
          this.serverNetwork = serverNetwork;

          // 画面インスタンスを生成
          loginScreen = new LoginScreen(this);
          signUpScreen = new SignUpScreen(this);
          homeScreen = new HomeScreen(this);
          battleScreen = new BattleScreen(this);
          resultScreen = new ResultScreen(this);

          // 初期画面
          currentScreen = loginScreen;
          currentScreen.showLoginScreen();
     }

     /**************************************
      * 画面遷移処理
      **************************************/
     public void transitionToLoginScreen() {
          currentScreen = loginScreen;
          loginScreen.showLoginScreen();
     }

     public void transitionToSignUpScreen() {
          currentScreen = signUpScreen;
          signUpScreen.showSignUpScreen();
     }

     public void transitionToHomeScreen() {
          currentScreen = homeScreen;
          homeScreen.showHomeScreen();
     }

     public void transitionToBattleScreen() {
          currentScreen = battleScreen;
          battleScreen.showBattleScreen();
     }

     public void transitionToResultScreen() {
          currentScreen = resultScreen;
          resultScreen.showResultScreen();
     }

     /**************************************
      * ログアウト処理
      **************************************/
     public void executeLogout() {
          String sessionID = SessionManager.getInstance().getSessionID();
          serverNetwork.sendLogoutRequest(sessionID);
          ResponseMessage resp = serverNetwork.receiveLogoutResponse();

          if (resp.isSuccess()) {
               transitionToLoginScreen();
          } else {
               homeScreen.showMessage("ログアウトに失敗しました。");
          }
     }

     /**************************************
      * マッチング開始処理
      **************************************/
     public void notifyStartMatching() {
          serverNetwork.sendMatchRequest();
          ResponseMessage resp = serverNetwork.receiveMatchResponse();

          if (resp.isSuccess()) {
               transitionToBattleScreen();
          } else {
               homeScreen.showMessage("マッチングに失敗");
          }
     }


     public void updateBattleStatus() {
     }

     public void sendBattleInfo() {
     }


     public void handleScreenTransition() {
     }
}
