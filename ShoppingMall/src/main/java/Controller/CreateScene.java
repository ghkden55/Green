package Controller;

import DAO.MealkitDAOImplement;
import DTO.MealkitDTO;
import Service.ScanService;

public class CreateScene extends Scene {


    @Override
    public int update() {
        MealkitDTO mealkitDTO = new MealkitDTO();

        System.out.println();
        System.out.println("*** 밀키트 상품 정보 등록 ***");
        System.out.println("==========================================");

        System.out.print("밀키트 이름 입력: ");
        ScanService.scanner.nextLine();
        String mealName = ScanService.scanner.nextLine();
        mealkitDTO.setMealName(mealName);
        System.out.println();

        System.out.print("밀키트 카테고리 입력: ");
        String mealCategory = ScanService.scanner.nextLine();
        mealkitDTO.setMealCategory(mealCategory);
        System.out.println();

        System.out.println("!숫자만 입력해주세요!");
        System.out.print("밀키트 가격 입력: ");
        int mealPrice = ScanService.scanner.nextInt();
        ScanService.scanner.nextLine();
        mealkitDTO.setMealPrice(mealPrice);
        System.out.println();

        System.out.print("밀키트 상품정보 입력: ");
        String mealInfo = ScanService.scanner.nextLine();
        mealkitDTO.setMealInfo(mealInfo);

        MealkitDAOImplement.getInstance().create(mealkitDTO);

        return 0;
    }
}