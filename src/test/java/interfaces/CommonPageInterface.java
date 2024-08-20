package interfaces;

public interface CommonPageInterface {

    enum Elements {
        // Define elements of the page here
        UP,
        BOTTOM
    }

    LoginPageInterface initLoginPageView();

}
