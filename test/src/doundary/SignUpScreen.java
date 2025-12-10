package doundary;

import control.ClientController;

public class SignUpScreen extends Screen {

    private ClientController controller;

    public SignUpScreen(ClientController controller) {
        this.controller = controller;
    }

    public void onSignUpButtonPressed(String id, String pass) {

        // 入力チェック
        if (!validateInput(id) || !validateInput(pass)) {
            showMessage("ID または パスワード が無効です");
            return;
        }

        // サーバへ新規登録を要求
        controller.serverNetwork.sendSignUpRequest(id, pass);
        ResponseMessage resp = controller.serverNetwork.receiveSignUpResponse();

        // 結果判定
        if (resp.isSuccess()) {
            showMessage("登録成功！ログイン画面へ移動します");
            controller.transitionToLoginScreen();
        } else {
            showMessage("登録失敗： " + resp.getErrorMessage());
        }
    }

    public boolean validateInput(String input) {
        return (input != null && input.length() >= 3);
    }


    public void showMessage(String message) {
        System.out.println("[SignUpScreen] " + message);
    }


    public void showSignUpScreen() {
        System.out.println("=== 新規登録画面を表示 ===");
    }
}
