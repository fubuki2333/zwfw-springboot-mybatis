package gov.shenyang.zwfw.controller;

import gov.shenyang.zwfw.dto.FileDTO;
import gov.shenyang.zwfw.provider.UCloudProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName:FileController
 * Package:life.majiang.community.controller
 * Description:
 *
 * @Date:2020/1/20 上午 11:36
 * @Author:gaochenyu2020@163.com
 */
@Controller
public class FileController {

    @Autowired
    private UCloudProvider uCloudProvider;

    @RequestMapping("/files/upload")
    @ResponseBody
    public FileDTO upload(HttpServletRequest request) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("file");
        try {
            String fileName = uCloudProvider.upload(file.getInputStream(), file.getContentType(), file.getOriginalFilename());
            FileDTO fileDTO = new FileDTO();
            fileDTO.setSuccess(1);
            fileDTO.setMessage("上传成功");
            fileDTO.setUrl(fileName);
            return fileDTO;
        } catch (Exception e) {
            FileDTO fileDTO = new FileDTO();
            fileDTO.setSuccess(0);
            fileDTO.setMessage("上传失败");
            return fileDTO;
        }
    }
}
