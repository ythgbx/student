package net.bus.web.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import net.bus.web.aspect.Auth;
import net.bus.web.common.config.RString;
import net.bus.web.controller.dto.BaseResult;
import net.bus.web.controller.dto.IResult;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Edifi_000 on 2016-08-08.
 */
@Controller
@RequestMapping("/file")
public class FileUploadController {

    @Autowired
    private HttpServletRequest _request;

    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ApiOperation(value = "文件上传", httpMethod = "POST", response = BaseResult.class, notes = "文件上传（文件查看路径为 your-website/upload/abc.png）")
    public IResult upload(@ApiParam(required = true, name = "file", value = "文件")@RequestParam("file") MultipartFile file) {
        BaseResult result = new BaseResult();
        if(!file.isEmpty()){
            String dir = _request.getSession().getServletContext().getRealPath("/resources/upload");//设定文件保存的目录
            String fileName = file.getOriginalFilename();//得到上传时的文件名
            if(checkExt(fileName)){
                String fileExt = fileName.substring(fileName.lastIndexOf("."),fileName.length());// 获得文件后缀名
                fileName = UUID.randomUUID().toString()+fileExt;
                try {
                    FileUtils.writeByteArrayToFile(new File(dir, fileName), file.getBytes());
                } catch (IOException ex) {
                    result.setResult("error");
                    result.setError(ex.getMessage());
                }
                System.out.println("upload over. " + fileName);
                result.setResult("success");
                result.setContent(fileName);
            }else{
                result.setResult("failed");
                result.setContent(RString.FILE_UPLOAD_FAILED_EXT);
            }
        }else{
            result.setResult("failed");
            result.setContent(RString.FILE_UPLOAD_FAILED_EMPTY_FILE);
        }
        return result;
    }

    private  boolean checkExt(String fileName){
        boolean flag=false;
        String suffixList="xls,xlsx,jpg,gif,png,ico,bmp,jpeg";
        //获取文件后缀
        String suffix=fileName.substring(fileName.lastIndexOf(".")+1, fileName.length());

        if(suffixList.contains(suffix.trim().toLowerCase())){
            flag=true;
        }
        return flag;
    }
}
