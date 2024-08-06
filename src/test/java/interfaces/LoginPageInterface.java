package interfaces;

public interface LoginPageInterface {

    enum Elements {
        USERNAME_FIELD,
        PASSWORD_FIELD,
        LOGIN_BUTTON
    }

    void enterUsername(String username);
}
