package controller;

import dto.UserDto;
import service.*;

public class SceneController {
    private static SceneController instance = null;

    public static SceneController getInstance()
    {
        if(instance == null)
            instance = new SceneController();

        return instance;
    }

    private Scene sceneState = null;

    private UserService userService = null;
    private SceneController() {
        userService = new UserService();
        UserDto userDTO = new UserDto();
        userService.create(userDTO);
        userDTO.setIntel(100);
        userDTO.setWealth(100);
        userDTO.setSociability(100);
        userDTO.setMorality(100);
        userDTO.setArtistry(100);
        userDTO.setPTSD(100);
        userService.updateuser(userDTO);
    }
    public int turn = 5;

    public int getTurn() {return turn; }

    public void setTurn(int turn) { this.turn = turn; }

    public void setScene(int Id) {
        switch (Id) {
            case 0:
                sceneState = new MenuController();
                break;

            case 1:
                System.out.println("                                            학교에 갑니다.");
                this.sceneState = new EducationCenterService();
                break;

            case 2:
                System.out.println("                                          아르바이트를 갑니다.");
                this.sceneState = new ParttimeJobService();
                break;

            case 3:
                System.out.println("                                           파티에 참석합니다.");
                this.sceneState = new PartyService();
                break;

            case 4:
                System.out.println("                                             외출을 합니다.");
                this.sceneState = new OutService();
                break;

            case 5:

                System.out.println("                                           상태확인을 합니다.");
                this.sceneState = new StatusController();
                break;

            case 6:
                sceneState = new IntroController();
                break;

        }
        this.sceneState.initialize();
    }
    public  void turnRender(){
        try {
            Thread.sleep(1000);
            System.out.println("                                    ༻✦༺ 　༺༻현재" + SceneController.getInstance().getTurn() +"턴 남았습니다.༺༻　༻✦༺");
            Thread.sleep(1000);
            System.out.println("                                 ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺");
            System.out.println("\n");
            System.out.println("                                 ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺");

        } catch (InterruptedException e) {e.printStackTrace();}
    }

    public void update() {
        int result = sceneState.update();
        if(result == -1) {
            turn++;
            turnRender();
        }else if(result == 1){
            turn++;
        }else if(result == 0){
            turnRender();
        }
    }

    public void render(){
        sceneState.render();
    }
}