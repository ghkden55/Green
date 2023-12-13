import controller.MainUpdateController;
import controller.SceneController;
import controller.EndingController;
import controller.Scene;

public class Main {
    public static void main(String[] args) {

        MainUpdateController main = new MainUpdateController();
        main.initialize();

        while(SceneController.getInstance().turn > 0)
        {
            int mainTurn = SceneController.getInstance().turn;
            mainTurn--;
            SceneController.getInstance().setTurn(mainTurn);
            main.render();
            main.update();
        }

        Scene e = new EndingController();
        e.render();

    }
}