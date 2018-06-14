package com.woostar.tender.common.excel;

import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import cn.afterturn.easypoi.excel.export.styler.AbstractExcelExportStyler;
import cn.afterturn.easypoi.excel.export.styler.IExcelExportStyler;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;

/**
 * @author huangs
 * @createtime 2018-06-12
 * @description
 */
public class MyExcelExportStylerImpl extends AbstractExcelExportStyler implements IExcelExportStyler {

    public MyExcelExportStylerImpl(Workbook workbook) {
        super.createStyles(workbook);
    }

    @Override
    public CellStyle getTitleStyle(short color) {
        return null;
    }

    @Override
    public CellStyle getHeaderStyle(short color) {
        CellStyle cellStyle = this.workbook.createCellStyle();
        // 字体
        Font font = this.workbook.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 12);
        cellStyle.setFillForegroundColor(color);
        cellStyle.setFont(font);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        // 水平垂直居中
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        return cellStyle;
    }

    @Override
    public CellStyle getStyles(boolean noneStyler, ExcelExportEntity entity) {
        CellStyle cellStyle = this.workbook.createCellStyle();
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        if (noneStyler) {
            cellStyle.setFillBackgroundColor(HSSFColor.GREEN.index);
        } else {
            cellStyle.setFillBackgroundColor(HSSFColor.BLUE.index);
        }
        return cellStyle;
    }
}
