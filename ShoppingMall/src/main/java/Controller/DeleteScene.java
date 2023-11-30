package Controller;

import DAO.MealkitDAOImplement;
import Service.ScanService;

public class DeleteScene extends Scene{
    public DeleteScene() {
    }

    @Override
    public int update() {
        System.out.print("삭제할 밀키트 번호 입력 : ");
        Long Id = ScanService.scanner.nextLong();
        ScanService.scanner.nextLine();

        MealkitDAOImplement.getInstance().delete(Id);
        return 0;
    }
}
