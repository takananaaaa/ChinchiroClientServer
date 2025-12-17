package client.doundaryClass;
import client.controlClass.*;

public class SignUpScreen extends Screen {

    public SignUpScreen(ClientController controller) {
        super(controller);
    }

    public void onSignUpButtonPressed(String id, String pass) {

        if (!validateInput(id) || !validateInput(pass)) {
            showMessage("入力が不正です");
            return;
        }

        controller.serverNetwork.sendSignUpRequest(id, pass);
        ResponseMessage resp = controller.serverNetwork.receiveSignUpResponse();

        if (resp.isSuccess()) {
            showMessage("登録成功");
            controller.transitionToLoginScreen();
        } else {
            showMessage("登録失敗");
        }
    }

    public boolean validateInput(String input) {
        return input != null && input.length() >= 3;
    }

    public void showSignUpScreen() {
        System.out.println("=== 新規登録画面 ===");
    }
}
