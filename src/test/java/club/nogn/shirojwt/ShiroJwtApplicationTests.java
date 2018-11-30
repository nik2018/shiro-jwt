package club.nogn.shirojwt;

import club.nogn.shirojwt.mapper.UserMapper;
import club.nogn.shirojwt.pojo.UserEntity;
import club.nogn.shirojwt.util.EncryptionHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShiroJwtApplicationTests {

	@Test
	public void contextLoads() {
	}
	@Autowired
	private UserMapper userMapper;
//	@Test
//	public void testUsermapper(){
//		UserEntity userEntity = new UserEntity();
//		userEntity.setUsername("nik");
//		UserEntity userEntity1 = userMapper.selectOne(userEntity);
//		System.out.println(userEntity1.toString());
//
//
//	}
	@Test
	public void testencryptionhelper(){
		EncryptionHelper e = new EncryptionHelper();
		String s1 = e.encrypt("nik");
		String s2 = e.encrypt("nik");
		System.out.println(s1 +"\n"+ s2);
	}
}
