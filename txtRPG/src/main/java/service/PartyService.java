package service;
import controller.Scene;
import controller.SceneController;
import domain.User;
import dto.UserDto;

import java.util.Scanner;

public class PartyService extends Scene {
    private String homeParty = "홈파티";
    private String villageParty = "마을잔치";
    private String kingdomParty = "왕궁파티";
    private String mainMenu = "메인";

    UserService userService = null;


    public void menuTxt(){
        System.out.println("                                   ༻✦༺ 　༻파티 종류를 선택해 주세요༺　༻✦༺");
        System.out.println("                                              1. "+homeParty);
        System.out.println("                                              2. "+villageParty);
        System.out.println("                                              3. "+kingdomParty);
        System.out.println("                                              4. "+mainMenu);
        System.out.println("                                 ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺");
    }

    private int input(){
        int num = 0;
        menuTxt();

        try {
            System.out.print("                                          파티 종류 입력 : ");
            num = scanner.nextInt();
        }catch (Exception e){
            System.out.println("                                              에러");
        }

        return num;
    }

    public void renderTxt() {

        try {
            System.out.println("                                 ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺");
            System.out.println("                                       "+sceneName+" 을(를) 선택하셨습니다.");
            Thread.sleep(1000);
            System.out.println("                                       돈 -" + sceneWealth + " 사교성 +" + sceneSociability + " 스트레스 +" + scenePTSD);
            System.out.println("                                 ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize() {
        scanner = new Scanner(System.in);
        userService = new UserService();
    }

    @Override
    public int update() {
        SceneController.getInstance().setScene(0);

        int i = input();

        while(true) {
            if(0 < i && i < 5)
                break;
            else {
                System.out.println("                                         잘 못 입력하셨습니다");
                i = input();
            }
        }
        UserDto userDto = new UserDto();
        User user = userService.findById(1L);

        switch (i) {
            case 1:
                if(user.getWealth()-5>0){
                    sceneName =  homeParty;
                    sceneWealth = 5;
                    sceneSociability = 3;
                    scenePTSD = 2;

                    userDto.setWealth(user.getWealth() - sceneWealth);
                    userDto.setPTSD(user.getPTSD() + scenePTSD);
                    userDto.setIntel(user.getIntel());
                    userDto.setMorality(user.getMorality());
                    userDto.setSociability(user.getSociability() + sceneSociability);
                    userDto.setArtistry(user.getArtistry());
                    userService.updateuser(userDto);
                    renderTxt();
                    return 0;
                }
                else{
                    System.out.println("                                          소지 골드가 부족합니다.");
                    return -1;
                }

            case 2:
                if(user.getWealth()-10>0){
                    sceneName =  villageParty;
                    sceneWealth = 10;
                    sceneSociability = 5;
                    scenePTSD = 2;

                    userDto.setWealth(user.getWealth() - sceneWealth);
                    userDto.setPTSD(user.getPTSD() + scenePTSD);
                    userDto.setIntel(user.getIntel());
                    userDto.setMorality(user.getMorality());
                    userDto.setSociability(user.getSociability() + sceneSociability);
                    userDto.setArtistry(user.getArtistry());
                    userService.updateuser(userDto);
                    renderTxt();
                    return 0;
                }
                else{
                    System.out.println("                                          소지 골드가 부족합니다.");
                    return -1;
                }


            case 3:
                if(user.getWealth()-15>0){
                    sceneName =  kingdomParty;
                    sceneWealth = 15;
                    sceneSociability = 7;
                    scenePTSD = 2;

                    userDto.setWealth(user.getWealth() - sceneWealth);
                    userDto.setPTSD(user.getPTSD() + scenePTSD);
                    userDto.setIntel(user.getIntel());
                    userDto.setMorality(user.getMorality());
                    userDto.setSociability(user.getSociability() + sceneSociability);
                    userDto.setArtistry(user.getArtistry());
                    userService.updateuser(userDto);
                    renderTxt();
                    return 0;
                }
                else{
                    System.out.println("                                          소지 골드가 부족합니다.");
                    return -1;
                }

            case 4:
                sceneName = mainMenu;
                System.out.println("                                 ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺");
                System.out.println("                                         "+sceneName + "를 선택하셨습니다.");
                System.out.println("                                 ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺");

                return -1;
        }

        return 0;
    }

    @Override
    public void render() {


    }
}