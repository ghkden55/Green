package domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class User {
    private int Intel;
    private int Wealth;
    private int Sociability;
    private int Morality;
    private int Artistry;
    private int PTSD;
    private Long ID;

    public User(){}

    @Builder
    public User(Long ID, int Intel, int Wealth, int Sociability, int Morality, int Artistry, int PTSD) {
        this.ID = ID;
        this.Intel = Intel;
        this.Wealth = Wealth;
        this.Sociability=Sociability;
        this.Morality=Morality;
        this.Artistry=Artistry;
        this.PTSD=PTSD;
    }

/*
    public int turnUp(){
        int turn = SceneManager.getInstance().getTurn();
        turn +=1;
        SceneManager.getInstance().setTurn(turn);
        return 0;
    }


    public  void turnRender(){
        try {
            Thread.sleep(1000);
            System.out.println("                                    ༻✦༺ 　༺༻현재" + SceneManager.getInstance().getTurn() +"턴 남았습니다.༺༻　༻✦༺");
            Thread.sleep(1000);
            System.out.println("                                 ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺");
            System.out.println("\n");
            System.out.println("                                 ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺");

        } catch (InterruptedException e) {e.printStackTrace();}
    }*/

    public void render(){
        System.out.println("                                 ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺ 　༻✧༺　༻✦༺ ༻✦༺");
        System.out.println("                                              골드 : " + getWealth());
        System.out.println("                                              지성 : " + Intel);
        System.out.println("                                              스트레스 : " + getPTSD());
        System.out.println("                                              도덕성 : " + getMorality());
        System.out.println("                                              사교성 : "+ getSociability());
        System.out.println("                                              예술성 : " + getArtistry());
        System.out.println("                                 ༻✦༺ 　༻✧༺　༻✦༺  ༻✦༺ 　༻✧༺　༻✦༺ ༻✦༺");
    }
}