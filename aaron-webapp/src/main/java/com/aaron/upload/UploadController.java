package com.aaron.upload;

import com.aaron.util.FileUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Locale;

/**
 * 文件上传下载
 * Creator:aaron_yong
 * Date:2017/3/20
 * Time:7:31
 */
@Controller
@RequestMapping("file")
public class UploadController {

    @RequestMapping(value = "/singleUpload.do", method = RequestMethod.POST)
    public String singleUpload(@RequestParam("file")MultipartFile file) throws IOException {
        if(!file.isEmpty()){

                //FileUtils.copyInputStreamToFile(file.getInputStream(),new File("f:/temp/",System.currentTimeMillis()+file.getOriginalFilename()));
                throw new MaxUploadSizeExceededException(1000L);

        }
        return "web/file/success";
    }

    @RequestMapping(value = "multiUpload.do",method = RequestMethod.POST)
    public String mutilUpload(MultipartRequest request){
        Iterator<String> filenames=request.getFileNames();//获得所有的文件名
        while(filenames.hasNext()){
            String filename=filenames.next();
            MultipartFile file=request.getFile(filename);
            if(!file.isEmpty()){
                try {
                    FileUtils.copyInputStreamToFile(file.getInputStream(),new File("F:/temp/",file.getOriginalFilename()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "web/file/success";
    }

    @RequestMapping(value = "/singleUploadPage",method = RequestMethod.GET)
    public String singleUploadPage(){
        return "web/file/singlefile_upload";
    }

    @RequestMapping(value = "/multiUploadPage",method = RequestMethod.GET)
    public String multiUploadPage(){
        return "web/file/multifile_upload";
    }

    /**
     * 上传图片超出最大值时, 弹出的异常
     * @param ex
     * @return
     * @throws IOException
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ModelAndView handlerException(Exception ex,HttpServletResponse response) throws IOException {
        String notice = "error";
        if (ex instanceof MaxUploadSizeExceededException) {
            notice = "文件大小不超过"
                    + FileUtil.getFileMB(((MaxUploadSizeExceededException) ex)
                    .getMaxUploadSize());
        } else {
            notice = "上传文件出现错误,错误信息:" + ex.getMessage();
        }
        System.out.println(notice);
        return new ModelAndView("web/file/singlefile_upload").addObject("error",notice);
    }
     /*@ExceptionHandler(IOException.class)
    public ModelAndView handleIOException(Locale locale,MessageSource messageSource) {
        ModelAndView modelAndView = new ModelAndView("web/file/singlefile_upload");
                modelAndView.addObject("error",messageSource.getMessage("upload. io.exception", null, locale));
        return modelAndView;
    }*/
}





