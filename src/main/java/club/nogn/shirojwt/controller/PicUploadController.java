package club.nogn.shirojwt.controller;

import club.nogn.shirojwt.util.UploadUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 16225
 * @Title: PicuploadController
 * @ProjectName shiro-jwt
 * @Description: TODO
 * @date 2018/11/1815:10
 */
@Controller
public class PicUploadController {
    //商品的图片上传

    @RequestMapping("/pic/upload")
    public Map<String, Object> upload(@RequestParam(value="uploadFile") MultipartFile file) throws Exception{

        //获取文件后缀
        String subfix = StringUtils.substringAfterLast(file.getOriginalFilename(), ".");

        //资源的路径地址
//        String path = System.getProperty("user.dir")+"/src/main/resources/";
        String path = System.getProperty("user.dir")+"\\src\\main\\resources\\";
        System.out.println(path);
        //执行文件上传
//        String[] uploadinfos = UploadUtil.upload("D:\\idea_U\\idea wp\\taotao_iit01\\taotao-manager\\src\\main\\resources\\tracker.conf", file.getBytes(), subfix);
        String[] uploadinfos = UploadUtil.upload(path+"tracker.conf", file.getBytes(), subfix);

        for (String string : uploadinfos) {
            System.out.println(string);
        }
        /****
         * error   	0标识成功，1失败
         * url		成功后文件访问地址
         * height	高度
         * width	宽度
         *
         *   group1
         M00/00/00/wKjjg1u7fxeABGSgAABff0_4hIY949.jpg
         http://192.168.227.131/group1/M00/00/00/wKjjg1u7fxeABGSgAABff0_4hIY949.jpg
         */
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("error", 0);
        //map.put("url", "http://192.168.227.131/"+uploadinfos[0]+"/"+uploadinfos[1]); //这里就是图片的路径地址，其实就是ip +返回值
        map.put("url", "http://39.108.217.230/"+uploadinfos[0]+"/"+uploadinfos[1]); //这里就是图片的路径地址，其实就是ip +返回值
        map.put("height", 100);
        map.put("width", 100);

        return map;
    }
}
