package Controller;

import DAO.MealkitDAOImplement;
import DTO.MealkitDTO;
import Service.ScanService;

public class UpdateScene extends Scene {
    @Override
    public int update() {

        Long MealID = null;

        System.out.println();
        System.out.println("*** 밀키트 상품 정보 업데이트 ***");
        System.out.println("==========================================");
        System.out.println("메뉴>");
        System.out.println("1. 상품 이름 변경");
        System.out.println("2. 카테고리 변경");
        System.out.println("3. 상품 가격 변경");
        System.out.println("4. 상품 정보 변경");
        System.out.println("5. 전체 정보 변경");

        int i = ScanService.scanner.nextInt();

        switch (i) {
            // 이름 변경
            case 1 : {
                System.out.print("변경할 상품 번호 입력 : ");
                MealID = ScanService.scanner.nextLong();
                ScanService.scanner.nextLine();

                MealkitDTO mealkitDTO = new MealkitDTO(MealkitDAOImplement.getInstance().findById(MealID));

                System.out.print("변경할 이름 입력 : ");
                String mealName =  ScanService.scanner.nextLine();
                mealkitDTO.setMealName(mealName);

                MealkitDAOImplement.getInstance().updateName(mealkitDTO);
            }
            break;

            // 카테고리 변경
            case 2 : {
                System.out.print("변경할 상품 번호 입력 : ");
                MealID = ScanService.scanner.nextLong();
                ScanService.scanner.nextLine();

                MealkitDTO mealkitDTO = new MealkitDTO(MealkitDAOImplement.getInstance().findById(MealID));

                System.out.print("변경할 카테고리 입력 : ");
                String MealCategory = ScanService.scanner.nextLine();
                mealkitDTO.setMealCategory(MealCategory);

                MealkitDAOImplement.getInstance().updateCategory(mealkitDTO);
            }
            break;

            // 가격 변경
            case 3 : {
                System.out.print("변경할 상품 번호 입력 : ");
                MealID = ScanService.scanner.nextLong();
                ScanService.scanner.nextLine();

                MealkitDTO mealkitDTO = new MealkitDTO(MealkitDAOImplement.getInstance().findById(MealID));

                System.out.print("변경할 가격 입력 : ");
                int MealPrice = ScanService.scanner.nextInt();
                mealkitDTO.setMealPrice(MealPrice);

                MealkitDAOImplement.getInstance().updatePrice(mealkitDTO);
            }
            break;

            // 설명 변경
            case 4 : {
                System.out.print("변경할 상품 번호 입력 : ");
                MealID = ScanService.scanner.nextLong();
                ScanService.scanner.nextLine();

                MealkitDTO mealkitDTO = new MealkitDTO(MealkitDAOImplement.getInstance().findById(MealID));

                System.out.print("변경할 상품정보 입력 : ");
                String MealInfo = ScanService.scanner.nextLine();
                mealkitDTO.setMealInfo(MealInfo);

                MealkitDAOImplement.getInstance().updateInfo(mealkitDTO);
            }
            break;

            // 상품 정보 전체 변경
            case 5 : {
                System.out.print("변경할 상품 번호 입력 : ");
                MealID = ScanService.scanner.nextLong();
                ScanService.scanner.nextLine();

                MealkitDTO mealkitDTO = new MealkitDTO(MealkitDAOImplement.getInstance().findById(MealID));

                // 이름
                System.out.print("변경할 이름 입력 : ");
                String mealName =  ScanService.scanner.nextLine();
                mealkitDTO.setMealName(mealName);

                // 카테고리
                System.out.print("변경할 카테고리 입력 : ");
                String MealCategory =  ScanService.scanner.nextLine();
                mealkitDTO.setMealCategory(MealCategory);

                // 가격
                System.out.print("변경할 가격 입력 : ");
                int MealPrice = ScanService.scanner.nextInt();
                ScanService.scanner.nextLine();
                mealkitDTO.setMealPrice(MealPrice);

                // 상품정보
                System.out.print("변경할 상품 정보 입력 : ");
                String MealInfo =  ScanService.scanner.nextLine();
                mealkitDTO.setMealInfo(MealInfo);

                MealkitDAOImplement.getInstance().updateAll(mealkitDTO);
            }
            break;

        }
        return 0;
    }
}
