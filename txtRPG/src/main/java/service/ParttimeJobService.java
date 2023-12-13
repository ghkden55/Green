package service;

import controller.Scene;
import controller.SceneController;
import domain.User;
import dto.UserDto;

import java.util.Scanner;

public class ParttimeJobService extends Scene {
    private String farm = "농장";
    private String silverTown = "양로원";
    private String background = "뒷골목";
    private String mainMenu = "메인";
    UserService userService = null;

    private int input() {
        int num = 0;
        menuTxt();

        try {
            System.out.print("                                            알바 종류 입력 : ");
            num = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("                                      에러");
        }
        return num;
    }

    public void menuTxt() {
        User user = userService.findById(1L);
        System.out.println("                                   ༻✦༺ 　༻알바 장소를 선택해 주세요༺　༻✦༺");
        System.out.println("                                     ༻✦༺ 　༺༻ 보유 골드: " + user.getWealth() + "༺༻ 　༻✦༺");
        System.out.println("                                              1. " + farm);
        System.out.println("                                              2. " + silverTown);
        System.out.println("                                              3. " + background);
        System.out.println("                                              4. " + mainMenu);
        System.out.println("                                 ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺");
    }

    public void renderTxt(){
        if(sceneName != mainMenu) {
            try {
                System.out.println("                                 ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺");
                System.out.println("                                        " + sceneName + " 을(를) 선택하셨습니다.");
                Thread.sleep(1000);
                System.out.print("                                        돈 +" + sceneWealth + " 스트레스 +" + scenePTSD);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            try {
                System.out.println("                                 ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺");
                System.out.println("                                        " + sceneName + " 을(를) 선택하셨습니다.");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        if(sceneName ==  silverTown){
            System.out.println(" 도덕성 +"+sceneMorality);
        }else if(sceneName ==  background){
            System.out.println(" 도덕성 -"+sceneMorality);
        }else if(sceneName == farm) {
            System.out.print("\n");
        }else{}
        System.out.println("                                 ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺");
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
            if(0 < i && i < 5) {
                break;
            } else {
                System.out.println("                                         잘 못 입력하셨습니다");
                i = input();
            }
        }
        UserDto userDTO = new UserDto();
        User user = userService.findById(1L);

        switch (i) {
            case 1:
                sceneName =  farm;
                sceneWealth = 10;
                scenePTSD = 7;
                //BD set
                userDTO.setWealth(user.getWealth() + sceneWealth);
                userDTO.setPTSD(user.getPTSD() + scenePTSD);
                userDTO.setIntel(user.getIntel());
                userDTO.setMorality(user.getMorality());
                userDTO.setSociability(user.getSociability());
                userDTO.setArtistry(user.getArtistry());

                //DB updateuser
                userService.updateuser(userDTO);

                renderTxt();
                return 0;


            case 2:
                sceneName =  silverTown;
                sceneWealth = 3;
                scenePTSD = 3;
                sceneMorality = 5;

                //BD set
                userDTO.setWealth(user.getWealth() + sceneWealth);
                userDTO.setPTSD(user.getPTSD() + scenePTSD);
                userDTO.setIntel(user.getIntel());
                userDTO.setMorality(user.getMorality());
                userDTO.setSociability(user.getSociability() + sceneMorality);
                userDTO.setArtistry(user.getArtistry());

                //DB updateuser
                userService.updateuser(userDTO);

                renderTxt();

                return 0;

            case 3:
                sceneName =  background;
                sceneWealth = 30;
                scenePTSD = 5;
                sceneMorality = 10;

                //BD set
                userDTO.setWealth(user.getWealth() + sceneWealth);
                userDTO.setPTSD(user.getPTSD() + scenePTSD);
                userDTO.setIntel(user.getIntel());
                userDTO.setMorality(user.getMorality());
                userDTO.setSociability(user.getSociability() + sceneMorality);
                userDTO.setArtistry(user.getArtistry());

                //DB updateuser
                userService.updateuser(userDTO);

                renderTxt();

                return 0;

            case 4:
                sceneName = mainMenu;
                return -1;

        }
        return 0;
    }

    @Override
    public void render() {}
}