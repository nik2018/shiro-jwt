package club.nogn.shirojwt.util;

import org.springframework.context.annotation.Bean;
import org.springframework.util.DigestUtils;

/**
 * @author 16225
 * @Title: encryptionhelper
 * @ProjectName shiro-jwt
 * @Description: TODO
 * @date 2018/11/910:08
 */
public class EncryptionHelper {
    private  String salt = "niknogn";
    public  String encrypt(String psw){
        String mix = salt+psw;
        String Encryptedpsw = DigestUtils.md5DigestAsHex(mix.getBytes());
        return Encryptedpsw;
    }
}
