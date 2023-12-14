package Controller;

import DAO.MealkitDAOImplement;
import OBJ.Mealkit;
import Service.ScanService;

public class ReadScene extends Scene{

    public ReadScene(){

    }

    @Override
    public int update() {
        System.out.println();
        System.out.println("*** 밀키트 상품검색 ***");
        System.out.println("==========================================");
        System.out.println("메뉴>");
        System.out.println("1. 전체 검색");
        System.out.println("2. 카테고리 검색");
        System.out.println("3. 상품이름 검색");
        System.out.println("4. 가격별 검색");

        int i = ScanService.scanner.nextInt();

        switch (i){
            case 1 : {
                // ** 전체 검색
                for (Mealkit mealkit : MealkitDAOImplement.getInstance().findAll()) {
                    System.out.println("---------------------------");
                    System.out.println(
                            mealkit.getMealID() + ", " +
                                mealkit.getMealName() + ", " +
                                mealkit.getMealCategory() + ", " +
                                mealkit.getMealPrice() + ", " +
                                mealkit.getMealInfo());
                }
            }
                break;
            case 2 :{
                // ** 카테고리 검색
                System.out.print("카테고리 입력: ");
                ScanService.scanner.nextLine();
                String mealCategory = ScanService.scanner.nextLine();

                //Mealkit mealkit = MealkitDAOImplement.getInstance().findbyCategory(mealCategory);
                for (Mealkit mealkit : MealkitDAOImplement.getInstance().findbyCategory(mealCategory)) {
                    System.out.println("---------------------------");
                    System.out.println(
                            mealkit.getMealID() + ", " +
                                    mealkit.getMealName() + ", " +
                                    mealkit.getMealCategory() + ", " +
                                    mealkit.getMealPrice() + ", " +
                                    mealkit.getMealInfo());

                }

            }
            break;
            case 3 : {
                // ** 상품명 검색
                System.out.println("상품명 입력: ");
                ScanService.scanner.nextLine();
                String mealName = ScanService.scanner.nextLine();

                //Mealkit mealkit = MealkitDAOImplement.getInstance().findbyName(mealName);
                for (Mealkit mealkit : MealkitDAOImplement.getInstance().findbyName(mealName)) {
                    System.out.println("---------------------------");
                    System.out.println(
                            mealkit.getMealID() + ", " +
                                    mealkit.getMealName() + ", " +
                                    mealkit.getMealCategory() + ", " +
                                    mealkit.getMealPrice() + ", " +
                                    mealkit.getMealInfo());
                }
            }
            break;
            case 4 : {
                //** 상품 가격 검색
                System.out.println("상품가격 입력: ");
                ScanService.scanner.nextLine();
                int mealPrice = ScanService.scanner.nextInt();

                //Mealkit mealkit = MealkitDAOImplement.getInstance().findbyPrice(mealPrice);
                for (Mealkit mealkit : MealkitDAOImplement.getInstance().findbyPrice(mealPrice)) {
                    System.out.println("---------------------------");
                    System.out.println(
                            mealkit.getMealID() + ", " +
                            mealkit.getMealName() + ", " +
                                    mealkit.getMealCategory() + ", " +
                                    mealkit.getMealPrice() + ", " +
                                    mealkit.getMealInfo());
                }
            }
            break;
        }
        return 0;
    }
}
