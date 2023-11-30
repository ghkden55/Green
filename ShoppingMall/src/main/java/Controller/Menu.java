package Controller;

import Service.ScanService;

public class Menu extends Scene{
    @Override
    public int update() {
//        int id = ScanService.scanner.nextInt();
        MainController mainController = new MainController();
        mainController.setScene();
        return 0;
    }


    public void render() {
        System.out.println();
        System.out.println("*** 밀키트 관리프로그램 ***");
        System.out.println("==========================================");
        System.out.println("메뉴>");
        System.out.println("1. 제품 추가");
        System.out.println("2. 제품 검색");
        System.out.println("3. 제품 수정");
        System.out.println("4. 제품 삭제");
        System.out.println("0. 종료");
        System.out.println("==========================================");
        System.out.print("선택>> ");

    }
}


