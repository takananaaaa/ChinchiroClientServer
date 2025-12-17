package client.controlClass;

import client.communication.ClientCommunication;
import client.doundaryClass.*;

public class ClientController {

    /* ネットワーク */
    protected ClientCommunication serverNetwork;

    /* 現在表示中の画面 */
    protected Screen currentScreen;

    /* 全画面 */
    protected LoginScreen loginScreen;
    protected SignUpScreen signUpScreen;
    protected HomeScreen homeScreen;
    protected BattleScreen battleScreen;
    protected ResultScreen resultScreen;

    /****************************************
     * コンストラクタ
     ****************************************/
    public ClientController(ClientCommunication network) {
        this.serverNetwork = network;

        // 各画面の生成
        loginScreen  = new LoginScreen(this);
        signUpScreen = new SignUpScreen(this);
        homeScreen   = new HomeScreen(this);
        battleScreen = new BattleScreen(this);
        resultScreen = new ResultScreen(this);

        // 初期画面
        currentScreen = loginScreen;
        loginScreen.showLoginScreen();
    }

    /****************************************
     * 画面遷移
     ****************************************/
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

    /****************************************
     * ログアウト
     ****************************************/
    public void executeLogout() {
    }

    /****************************************
     * マッチング開始
     ****************************************/
    public void notifyStartMatching() {
    }

    /****************************************
     * バトル関連
     ****************************************/
    public void sendBattleInfo() {
    }

    public void updateBattleStatus() {
    }

    public void handleScreenTransition() {
    }
}
