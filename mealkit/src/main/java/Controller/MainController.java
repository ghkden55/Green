package Controller;

import DAO.MealkitDAOImplement;
import Service.ScanService;

import java.util.Scanner;

public class MainController extends Scene{

    private Scene sceneState = null;

    public MainController() {
        MealkitDAOImplement.getInstance().createTable();
    }

    public void setScene() {
        Menu menu = new Menu();
        menu.render();

        int id = ScanService.scanner.nextInt();

        switch (id) {
            case 0: {
                System.exit(0);
                break;
            }
            case 1: {
                System.out.println("상품 추가");
                sceneState = new CreateScene();
                break;
            }
            case 2: {
                System.out.println("상품 검색");
                sceneState = new ReadScene();
                break;
            }
            case 3: {
                System.out.println("상품 수정");
                sceneState = new UpdateScene();
                break;
            }

            case 4: {
                System.out.println("상품 삭제");
                sceneState = new DeleteScene();
                break;
            }
        }
    }

    @Override
    public int update() {
        sceneState.update();
        return 0;
    }

}
