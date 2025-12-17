package client.doundaryClass;
import client.controlClass.ClientController;

public class LoginScreen extends Screen {

    public LoginScreen(ClientController controller) {
        super(controller);
    }

    public void onLoginButtonPressed(String id, String pass) {

        if (!validateInput(id) || !validateInput(pass)) {
            showMessage("ID または パスワードが不正です");
            return;
        }

        controller.serverNetwork.sendLoginRequest(id, pass);
        ResponseMessage resp = controller.serverNetwork.receiveLoginResponse();

        if (resp.isSuccess()) {
            //    SessionManager.getInstance().setSessionID(resp.getSessionID());
            controller.transitionToHomeScreen();
        } else {
            showMessage("ログイン失敗");
        }
    }

    public void onSignUpButtonPressed() {
        controller.transitionToSignUpScreen();
    }

    public boolean validateInput(String input) {
        return input != null && input.length() >= 3;
    }

    public void showLoginScreen() {
        System.out.println("=== ログイン画面 ===");
    }
}
