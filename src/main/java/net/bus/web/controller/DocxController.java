package net.bus.web.controller;

import org.apache.poi.xwpf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Object DocxProcess(){
        String fileName = session.getServletContext().getRealPath("/resources/upload/学生个人建档申请表.docx");
//        File file = new File(fileName);
//        System.out.println(String.valueOf(file.exists()));
//        System.out.println(request.getServletPath());
        Path file = Paths.get(fileName);
        if(Files.exists(file)){
            response.setContentType("application/octet-stream");
            response.addHeader("Content-Disposition",
                    "attachment; filename=" + "aaa.docx");

            try {
                XWPFDocument document = new XWPFDocument(new FileInputStream(file.toFile()));
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
