import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/*
 POI 다운로드
 jakarta.apache.org에서 poi-bin-4.1.2-20200217.zip 다운로드
 
 poi-4.1.2.jar, commons-math3-3.6.1.jar Build Path설정한다.
*/

//순서->workbook생성->sheet->row->cell->IO
public class WriteExcel {

	public WriteExcel() {

	}

	public void start() {
		// 엑셀로 쓰기
		// 1. workbook 객체 생성
		HSSFWorkbook workbook = new HSSFWorkbook();

		// 2. sheet 객체 생성
		HSSFSheet sheet1 = workbook.createSheet("회원목록");
		HSSFSheet sheet2 = workbook.createSheet();

		// 3. row 객체
		HSSFRow row1 = sheet1.createRow(0);

		HSSFCell cell = row1.createCell(0);
		cell.setCellValue("번호");

		row1.createCell(1).setCellValue("이름");
		row1.createCell(2).setCellValue("연락처");

		String data[][] = { { "1", "홍길동", "010-1111-1111" }, { "2", "강길동", "010-2222-2222" },
				{ "3", "최길동", "010-3333-33333" } };
		// 			1~ 				3
		for (int i = 1; i < data.length; i++) {
			HSSFRow row = sheet1.createRow(i);
			//			 0~2
			for (int j = 0; j < data[i-1].length; j++) {
				HSSFCell cell2 = row.createCell(j);
				if (j == 0) {
					cell2.setCellValue((Integer.parseInt(data[i - 1][j])));
				} else {
					cell2.setCellValue(data[i - 1][j]);
				}
			}
		}

		/////////////////////////////////////////
		// 5. 파일로 쓰기
		try {
			File f = new File("D://javaFolder/member.xls");
			FileOutputStream fos = new FileOutputStream(f);
			
			workbook.write(fos);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("엑셀로 쓰기가 완료되었습니다.");
	}

	public static void main(String[] args) {
		new WriteExcel().start();
	}

}
