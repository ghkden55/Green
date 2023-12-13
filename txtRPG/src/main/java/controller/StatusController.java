package controller;

import domain.User;
import service.UserService;

import java.util.Scanner;

public class StatusController extends Scene {

    UserService userService = null;

    @Override
    public void initialize() {
        scanner = new Scanner(System.in);
        userService = new UserService();
    }

    @Override
    public int update() {
        SceneController.getInstance().setScene(0);
        return -1;
    }

    @Override
    public void render() {
        User user = userService.findById(1L);
        System.out.println("                                 ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺ 　༻✧༺　༻✦༺ ༻✦༺");
        System.out.println("                                              골드 : " + user.getWealth());
        System.out.println("                                              지성 : " + user.getIntel());
        System.out.println("                                              스트레스 : " + user.getPTSD());
        System.out.println("                                              도덕성 : " + user.getMorality());
        System.out.println("                                              사교성 : " + user.getSociability());
        System.out.println("                                              예술성 : " + user.getArtistry());
        System.out.println("                                 ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺ 　༻✧༺　༻✦༺ ༻✦༺");
    }
}