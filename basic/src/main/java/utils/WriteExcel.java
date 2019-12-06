package utils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteExcel {
    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";
    private static String path = Path.deskTop()+"test.xlsx";
    
    public static void main(String[] args) {
        
        List<String> list2 = new ArrayList<String>();
        list2.add("sunjian");
        list2.add("sunjian2");
        list2.add("sunjian3");
        list2.add("sunjian4");
        list2.add("sunjian5");
        list2.add("sunjian6");
        
        writeExcel(list2, list2.size(), path);
    }
    
    /**
     * 写入Excel方法
     * @param dataList 写入的数�?
     * @param cloumnCount 写入的�?�列�?
     * @param finalXlsxPath Excel的路�?
     */
    public static void writeExcel(List<String> dataList, int cloumnCount,String finalXlsxPath){
        OutputStream out = null;
        Row row = null;
        InputStream in = null;
        try {
            // 获取Excel文件
            File file = new File(finalXlsxPath);
            Workbook workBook = getWorkbok(file);//判断是哪个版本的Excel
            Sheet sheet = workBook.getSheetAt(0);//第一个sheet对象
            
            System.out.println(file.length());
            in = new FileInputStream(file);
            if (in.available() == 0) {				
            	row = sheet.createRow(sheet.getLastRowNum());//行对�?
            	System.out.println("1111111111");
			}else {				
				row = sheet.createRow(sheet.getLastRowNum());//行对�?
				System.out.println("2222222222");
			}
            
            /**
             * �?Excel中写新数�?
             */
            for (int k = 0; k < cloumnCount; k++) {
            	row.createCell(k).setCellValue(dataList.get(k));
            }
            // 创建文件输出流，准备输出电子表格：这个必须有，否则你在sheet上做的任何操作都不会有效
            out =  new FileOutputStream(finalXlsxPath);
            workBook.write(out);
            System.out.println("数据写入完成现在�?-->>"+(sheet.getLastRowNum()+1)+"行数据�??");
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                if(out != null){
                    out.flush();
                    out.close();
                }
                if(in != null)
                	in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 判断Excel的版�?,获取Workbook
     * @param file
     * @return
     * @throws IOException
     */
    public static Workbook getWorkbok(File file) throws IOException{
    	Workbook wb = null;
        FileInputStream in = new FileInputStream(file);
        if(file.getName().endsWith(EXCEL_XLS)){     //Excel&nbsp;2003
            wb = new HSSFWorkbook(in);
        }else if(file.getName().endsWith(EXCEL_XLSX)){    // Excel 2007/2010
            wb = new XSSFWorkbook(in);
        }
        return wb;
    }
}