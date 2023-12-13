package controller;

//import Manager.GameManager;
import Utility.ScanManager;

public class MenuController extends Scene {

    @Override
    public void initialize() {}

    @Override
    public int update() {
        int id = ScanManager.Scan();
        //GameManager.getInstance().getUser().turnUp();
        SceneController.getInstance().setScene(id);
        return 1;
    }

    @Override
    public void render() {
        System.out.println("                                           메뉴를 선택해주세요!");
        System.out.println("                                 ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺");
        System.out.println("                                              1. 학교");
        System.out.println("                                              2. 알바");
        System.out.println("                                              3. 파티");
        System.out.println("                                              4. 외출");
        System.out.println("                                              5. 상태");
    }
}