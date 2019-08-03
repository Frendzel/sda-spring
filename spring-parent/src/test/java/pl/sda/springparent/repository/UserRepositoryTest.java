package pl.sda.springparent.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.sda.springparent.dao.UserModel;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void testRepo() {
        //given
        UserModel userModel = new UserModel();
        userModel.setEmail("mail");
        userModel.setFirstName("mail");
        userModel.setGender("mail");
        userModel.setIpAddress("mail");
        userModel.setLastName("mail");
        //when
        userRepository.save(userModel);
        //then
        //TODO
    }

}