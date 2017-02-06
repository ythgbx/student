package net.bus.web.controller;

import org.apache.poi.xwpf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;

import org.apache.poi.*;

/**
 * Created by rc452 on 2016/12/20.
 */
@Controller
@RequestMapping("/docx")
public class DocxController {

    @Autowired
    HttpServletRequest request;
    @Autowired
    HttpSession session;
    @Autowired
    HttpServletResponse response;

    /**
     * XWPFParagraph：代表一个段落。
     * XWPFRun：代表具有相同属性的一段文本。
     * XWPFTable：代表一个表格。
     * XWPFTableRow：表格的一行。
     * XWPFTableCell：表格对应的一个单元格。
     * XWPFDocument：整个文档 文档包含表格和段落 表格中又包含行 行中有单元格 单元格里有段落 段落里有文本段一层一层去取
     * 拿到文本判断后进行替换就行了
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Object DocxProcess(){
        String fileName = session.getServletContext().getRealPath("/resources/upload/学生个人建档申请表.docx");
        File file = new File(fileName);
        if(file.exists()){
            response.setContentType("application/octet-stream");
            response.addHeader("Content-Disposition",
                    "attachment; filename=" + "aaa.docx");

            try {
                XWPFDocument document = new XWPFDocument(new FileInputStream(file));
                for (XWPFParagraph p : document.getParagraphs()) {
                    List<XWPFRun> runs = p.getRuns();
                    if (runs != null) {
                        for (XWPFRun r : runs) {
                            String text = r.getText(0);
                            if (text != null && text.contains("$name")) {
                                text = text.replace("$name", "若尘");
                                r.setText(text, 0);
                            }
                        }
                    }
                }
                for (XWPFTable tbl : document.getTables()) {
                    for (XWPFTableRow row : tbl.getRows()) {
                        for (XWPFTableCell cell : row.getTableCells()) {
                            for (XWPFParagraph p : cell.getParagraphs()) {
                                for (XWPFRun r : p.getRuns()) {
                                    String text = r.getText(0);
                                    if (text.contains("$name")) {
                                        text = text.replace("$name", "若尘");
                                        r.setText(text,0);
                                    }
                                }
                            }
                        }
                    }
                }
                document.write(response.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return "aaa";
    }
}
