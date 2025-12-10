package doundary;

import control.ClientController;

public class LoginScreen extends Screen {
    private ClientController controller;

    public LoginScreen(ClientController controller) {
        this.controller = controller;
    }

    public void onLoginButtonPressed(String id, String pass) {
        controller.serverNetwork.sendLoginRequest(id, pass);
        ResponseMessage resp = controller.serverNetwork.receiveLoginResponse();

        if (resp.isSuccess()) {
            controller.transitionToHomeScreen();
        } else {
            showMessage("ログイン失敗");
        }
    }

    public void onSignUpButtonPressed() {
        controller.transitionToSignUpScreen();
    }
}
