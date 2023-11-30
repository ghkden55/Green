import Controller.MainController;

public class Main {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        while (true){
            mainController.setScene();
//            mainController.render();
            mainController.update();

        }

    }
}