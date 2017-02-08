
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
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


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/application.xml","classpath:spring/spring-provider.xml"})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testInsert() {
        Sequence sequence = new Sequence();
        for(int i =0 ;i < 2000; i++) {
            User user = new User(null, "jack-cooper", new Random().nextInt(80));
            boolean insert = userService.insert(user);
        }
    }

    @Test
    public void testSelect() {
        User u = new User();
        u.setAge(33);
        List<User> users = userService.selectList(new EntityWrapper<User>(u));
        System.out.println("=========================== " + userService.selectList(new EntityWrapper<User>(u)));
        System.out.println("******************************= " + userService.selectCount(new EntityWrapper<User>(null)));
    }

    @Test
    public void testUpdate(){
        User u = new User();
        u.setId(0l);
        u.setName("bbb");
        u.setAge(99);
        userService.updateById(u);
    }

    @Test
    public void testSlectByPage(){
        User u = new User();
        u.setId(0l);
        u.setName("bbb");
        u.setAge(99);
        Page<User> page = new Page<User>();
        Page<User> userPage = userService.selectPage(page);
        System.out.println("userPage = " + userPage);
        System.out.println("userPage = " + userPage.getRecords());
    }


    @Test
    public void testSlectByLike(){
        List<User> users = userService.selectList(
                new EntityWrapper<User>().like("name", "oo")
//                        .and("age={0}", "10")
                        .orderBy("id")
        );
        System.out.println("users = " + users);
        System.out.println("size = " + users.size());
    }

    @Test
    public void testSlectBetween(){
        List<User> users = userService.selectList(
                new EntityWrapper<User>().like("name", "oo")
                        .between("age", "10","20")
                        .orderBy("id")
        );
        System.out.println("users = " + users);
        System.out.println("size = " + users.size());
    }

    @Test
    public void testSlectIn(){
        List<User> users = userService.selectList(
                new EntityWrapper<User>().like("name", "oo")
                        .in("age", new String[]{"10","11"})
                        .orderBy("id")
        );
        System.out.println("users = " + users);
        System.out.println("size = " + users.size());
    }

}
