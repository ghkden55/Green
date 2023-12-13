package controller;

import Utility.ScanManager;
import java.util.Scanner;

public class MainUpdateController {
    Scanner scanner = new Scanner(System.in);

    public void initialize() {
        ScanManager.Initialize();
        SceneController.getInstance().setScene(6);
    }

    public void render() {
        SceneController.getInstance().render();
    }

    public void update() {
        SceneController.getInstance().update();
    }

}