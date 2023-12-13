package service;

import controller.Scene;
import controller.SceneController;
import domain.*;
import dto.UserDto;

import java.util.Scanner;

public class OutService extends Scene {
    private String bookStore = "서점";
    private String goldBar = "금거래소";
    private String artMuseum = "미술관";
    private String generalStore = "잡화점";
    private String mainMenu = "메인";

    private int goomonBook = 3;
    private int ssenBook = 5;
    private int majorBook = 7;
    private int silver = 3;
    private int gold = 5;
    private int diamond = 7;
    private int artMuseum_1 = 3;
    private int artMuseum_2 = 5;
    private int artMuseum_3 = 7;
    private int eclipse = -3;
    private int puremilkyMacaroon = -5;
    private int makGookSu = -7;

    private int erasePTSD = -1;
    private int eraseWealth = -5;

    int[][] intArray =new int[][]
            {
                    {1,2,3},
                    {1,2,3},
                    {1,2,3},
                    {1,2,3},
            };
    UserService userService = null;

    public void menuTxt(){
        User user = userService.findById(1L);
        System.out.println("                                   ༻✦༺ 　༺༻매장을 선택해 주세요༺༻　༻✦༺");
        System.out.println("                              ༻✦༺　༺༻ 보유 골드: " + user.getWealth() + " 필요 골드: " + eraseWealth + " ༺༻　༻✦༺");
        System.out.println("                                              1. "+bookStore);
        System.out.println("                                              2. "+goldBar);
        System.out.println("                                              3. "+artMuseum);
        System.out.println("                                              4. "+generalStore);
        System.out.println("                                              5. "+mainMenu);
        System.out.println("                                ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺");
    }

    private int input(){
        int num = 0;
        menuTxt();

        try {
            System.out.print("                                          외출 장소 입력 : ");
            num = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("                                              에러");
        }
        return num;
    }

    public int randItem(int id) {
        double dl = Math.random();
        int ra = (int)(dl * 3);
        return intArray[id - 1][ra];
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
            if(0 < i && i < 6)
                break;
            else {
                System.out.println("                                         잘 못 입력하셨습니다");
                i = input();
            }
        }
        UserDto userDTO = new UserDto();
        User user = userService.findById(1L);

        if(user.getWealth() > 4 ) {
            switch (i) {
                case 1:
                    sceneName = bookStore;
                    try {
                        System.out.println("                                ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺");
                        System.out.println("                                          "+sceneName+" 을(를) 선택하셨습니다.");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {e.printStackTrace();}


                    switch (randItem(i)) {
                        case 1:
                            getGoomonBook();
                            System.out.println("                                        서점에서 구몬책을 구매하셨습니다.");
                            System.out.println("                                           지성 +" + goomonBook + " 스트레스 " + erasePTSD + " 돈 " + eraseWealth);
                            System.out.println("                                 ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺");
                            break;
                        case 2:
                            getSsenBook();
                            System.out.println("                                        서점에서 쎈수학을 구매하셨습니다.");
                            System.out.println("                                           지성 +" + ssenBook + " 스트레스 " + erasePTSD + " 돈 " + eraseWealth);
                            System.out.println("                                 ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺");
                            break;
                        case 3:
                            getMajorBook();
                            System.out.println("                                        서점에서 전공 서적을 구매하셨습니다.");
                            System.out.println("                                           지성 +" + majorBook + " 스트레스 " + erasePTSD + " 돈 " + eraseWealth);
                            System.out.println("                                 ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺");
                            break;
                    }
                    break;

                case 2:
                    sceneName = goldBar;
                    try {
                        System.out.println("                                ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺");
                        System.out.println("                                          "+sceneName+" 을(를) 선택하셨습니다.");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {e.printStackTrace();}
                    switch (randItem(i)) {
                        case 1:
                            getSilver();
                            System.out.println("                                        금거래소에서 은을 구매하셨습니다.");
                            System.out.println("                                          사교성 +" + silver + " 스트레스 " + erasePTSD + " 돈 " + eraseWealth);
                            System.out.println("                                ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺");
                            break;
                        case 2:
                            getGold();
                            System.out.println("                                        금거래소에서 금을 구매하셨습니다.");
                            System.out.println("                                          사교성 +" + gold + " 스트레스 " + erasePTSD + " 돈 " + eraseWealth);
                            System.out.println("                                ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺");
                            break;
                        case 3:
                            getDiamond();
                            System.out.println("                                     금거래소에서 다이아몬드를 구매하셨습니다.");
                            System.out.println("                                         사교성 +" + diamond + " 스트레스 " + erasePTSD + " 돈 " + eraseWealth);
                            System.out.println("                                ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺");
                            break;
                    }
                    break;

                case 3:
                    sceneName = artMuseum;
                    try {
                        System.out.println("                                ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺");
                        System.out.println("                                          "+sceneName+" 을(를) 선택하셨습니다.");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {e.printStackTrace();}
                    switch (randItem(i)) {
                        case 1:
                            getArtMuseum_1();
                            System.out.println("                                           미술관 주위를 구경합니다.");
                            System.out.println("                                         예술성 +" + artMuseum_1 + " 스트레스 " + erasePTSD + " 돈 " + eraseWealth);
                            System.out.println("                                ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺");
                            break;
                        case 2:
                            getArtMuseum_2();
                            System.out.println("                                             미술관 내부를 구경합니다.");
                            System.out.println("                                          예술성 +" + artMuseum_2 + " 스트레스 " + erasePTSD + " 돈 " + eraseWealth);
                            System.out.println("                                ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺");
                            break;
                        case 3:
                            getArtMuseum_3();
                            System.out.println("                                              미술품을 관람합니다.");
                            System.out.println("                                           예술성 +" + artMuseum_3 + " 스트레스 " + erasePTSD + " 돈 " + eraseWealth);
                            System.out.println("                                ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺");
                            break;
                    }
                    break;

                case 4:
                    sceneName = generalStore;
                    try {
                        System.out.println("                                ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺");
                        System.out.println("                                          "+sceneName+" 을(를) 선택하셨습니다.");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {e.printStackTrace();}
                    switch (randItem(i)) {
                        case 1:
                            getEclipse();
                            System.out.println("                                      잡화점에서 이클립스를 구매하셨습니다.");
                            System.out.println("                                           스트레스 " + (eclipse+erasePTSD) + " 돈 " + eraseWealth);
                            System.out.println("                                ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺");
                            break;
                        case 2:
                            getPureMilkyMacaroon();
                            System.out.println("                                    잡화점에서 순수우유마카롱을 구매하셨습니다.");
                            System.out.println("                                           스트레스 " + (puremilkyMacaroon+erasePTSD) + " 돈 " + eraseWealth);
                            System.out.println("                                ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺");
                            break;
                        case 3:
                            getMakGookSu();
                            System.out.println("                                        잡화점에서 막국수를 구매하셨습니다.");
                            System.out.println("                                           스트레스 " + (makGookSu+erasePTSD) + " 돈 " + eraseWealth);
                            System.out.println("                                ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺");
                            break;
                    }
                    break;

                case 5:
                    sceneName = mainMenu;
                    System.out.println("                                 ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺");
                    System.out.println("                                         "+sceneName + "를 선택하셨습니다.");
                    System.out.println("                                 ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺");
                    break;
            }

        } else {
            System.out.println("                                                            소지 골드가 부족합니다.");
        }
        SceneController.getInstance().setScene(0);
        return 0;
    }

    @Override
    public void render() {}

    public void getGoomonBook() {
        UserDto userDTO = new UserDto();
        User user = userService.findById(1L);

        userDTO.setIntel(user.getIntel() + goomonBook );
        userDTO.setPTSD(user.getPTSD() + erasePTSD );
        userDTO.setWealth(user.getWealth() + eraseWealth);
        userDTO.setMorality(user.getMorality());
        userDTO.setSociability(user.getSociability());
        userDTO.setArtistry(user.getArtistry());

        userService.updateuser(userDTO);

    }

    public void getSsenBook() {
        UserDto userDTO = new UserDto();
        User user = userService.findById(1L);

        userDTO.setIntel(user.getIntel() + ssenBook);
        userDTO.setPTSD(user.getPTSD() + erasePTSD);
        userDTO.setWealth(user.getWealth() + eraseWealth);
        userDTO.setMorality(user.getMorality());
        userDTO.setSociability(user.getSociability());
        userDTO.setArtistry(user.getArtistry());

        userService.updateuser(userDTO);

    }

    public void getMajorBook() {
        UserDto userDTO = new UserDto();
        User user = userService.findById(1L);

        userDTO.setIntel(user.getIntel() + majorBook);
        userDTO.setPTSD(user.getPTSD() + erasePTSD);
        userDTO.setWealth(user.getWealth() + eraseWealth);
        userDTO.setMorality(user.getMorality());
        userDTO.setSociability(user.getSociability());
        userDTO.setArtistry(user.getArtistry());

        userService.updateuser(userDTO);

    }

    public void getSilver() {
        UserDto userDTO = new UserDto();
        User user = userService.findById(1L);

        userDTO.setSociability(user.getSociability() + silver);
        userDTO.setIntel(user.getIntel() );
        userDTO.setPTSD(user.getPTSD() + erasePTSD );
        userDTO.setWealth(user.getWealth() + eraseWealth);
        userDTO.setMorality(user.getMorality() );
        userDTO.setArtistry(user.getArtistry());

        userService.updateuser(userDTO);

    }

    public void getGold() {
        UserDto userDTO = new UserDto();
        User user = userService.findById(1L);

        userDTO.setSociability(user.getSociability() + gold);
        userDTO.setIntel(user.getIntel() );
        userDTO.setPTSD(user.getPTSD() + erasePTSD);
        userDTO.setWealth(user.getWealth() + eraseWealth);
        userDTO.setMorality(user.getMorality() );
        userDTO.setArtistry(user.getArtistry());

        userService.updateuser(userDTO);

    }

    public void getDiamond() {
        UserDto userDTO = new UserDto();
        User user = userService.findById(1L);

        userDTO.setSociability(user.getSociability() + diamond);
        userDTO.setIntel(user.getIntel() );
        userDTO.setPTSD(user.getPTSD() + erasePTSD);
        userDTO.setWealth(user.getWealth() + eraseWealth);
        userDTO.setMorality(user.getMorality() );
        userDTO.setArtistry(user.getArtistry());

        userService.updateuser(userDTO);

    }

    public void getArtMuseum_1() {
        UserDto userDTO = new UserDto();
        User user = userService.findById(1L);

        userDTO.setArtistry(user.getArtistry() + artMuseum_1);
        userDTO.setIntel(user.getIntel() );
        userDTO.setPTSD(user.getPTSD() + erasePTSD);
        userDTO.setWealth(user.getWealth() + eraseWealth);
        userDTO.setMorality(user.getMorality() );
        userDTO.setSociability(user.getSociability());

        userService.updateuser(userDTO);

    }

    public void getArtMuseum_2() {
        UserDto userDTO = new UserDto();
        User user = userService.findById(1L);

        userDTO.setArtistry(user.getArtistry() + artMuseum_2);
        userDTO.setIntel(user.getIntel());
        userDTO.setPTSD(user.getPTSD() + erasePTSD);
        userDTO.setWealth(user.getWealth() +eraseWealth);
        userDTO.setMorality(user.getMorality());
        userDTO.setSociability(user.getSociability());

        userService.updateuser(userDTO);

    }

    public void getArtMuseum_3() {
        UserDto userDTO = new UserDto();
        User user = userService.findById(1L);

        userDTO.setArtistry(user.getArtistry() + artMuseum_3);
        userDTO.setIntel(user.getIntel() );
        userDTO.setPTSD(user.getPTSD() + erasePTSD);
        userDTO.setWealth(user.getWealth() + eraseWealth);
        userDTO.setMorality(user.getMorality() );
        userDTO.setSociability(user.getSociability());

        userService.updateuser(userDTO);

    }

    public void getEclipse() {
        UserDto userDTO = new UserDto();
        User user = userService.findById(1L);

        userDTO.setPTSD(user.getPTSD() + eclipse);
        userDTO.setIntel(user.getIntel() );
        userDTO.setPTSD(user.getPTSD() + erasePTSD);
        userDTO.setWealth(user.getWealth() + eraseWealth);
        userDTO.setMorality(user.getMorality() );
        userDTO.setSociability(user.getSociability());
        userDTO.setArtistry(user.getArtistry() );

        userService.updateuser(userDTO);

    }

    public void getPureMilkyMacaroon() {
        UserDto userDTO = new UserDto();
        User user = userService.findById(1L);

        userDTO.setPTSD(user.getPTSD() + puremilkyMacaroon);
        userDTO.setIntel(user.getIntel() );
        userDTO.setPTSD(user.getPTSD() + erasePTSD);
        userDTO.setWealth(user.getWealth() + eraseWealth);
        userDTO.setMorality(user.getMorality() );
        userDTO.setSociability(user.getSociability());
        userDTO.setArtistry(user.getArtistry() );

        userService.updateuser(userDTO);

    }

    public void getMakGookSu() {
        UserDto userDTO = new UserDto();
        User user = userService.findById(1L);

        userDTO.setPTSD(user.getPTSD() + makGookSu);
        userDTO.setIntel(user.getIntel() );
        userDTO.setPTSD(user.getPTSD() + erasePTSD);
        userDTO.setWealth(user.getWealth() + eraseWealth);
        userDTO.setMorality(user.getMorality() );
        userDTO.setSociability(user.getSociability());
        userDTO.setArtistry(user.getArtistry() );

        userService.updateuser(userDTO);

    }
}