
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.toolkit.Sequence;
import com.reapal.model.User;
import com.reapal.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;
import java.util.Random;

/**
 * Created by baiyu on 2016/11/14.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/application.xml","classpath:spring/spring-provider.xml"})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testInsert() {
        Sequence sequence = new Sequence();
        User user = new User(sequence.nextId(),"jack-cooper",new Random().nextInt(80));
        boolean insert = userService.insert(user);
        System.out.println("insert = " + insert);
    }

    @Test
    public void test() {
        User u = new User();
        u.setName("jack-cooper");
        List<User> users = userService.selectList(new EntityWrapper<User>(u));
        System.out.println("=========================== " + userService.selectList(new EntityWrapper<User>(u)));
        System.out.println("******************************= " + userService.selectCount(new EntityWrapper<User>(null)));
    }

}
