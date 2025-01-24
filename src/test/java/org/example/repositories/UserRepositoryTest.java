package org.example.repositories;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class UserRepositoryTest {

    @Test
    void returnAUSeerModel() throws Exception {
        var user = UserRepository.createUser("Tim buttons",
                "1234@gmail.com", "12323dfs",
                "Java", "TUTOR", 1);
        var name = user.getFullName();

        assertNotNull(name);
    }


    @Test
//    TODO: Fix this test. Pass even if user not returned
    void returnUserByEmailPassword() throws Exception {
        var user = UserRepository.returnUserByEmailPassword("1234@gmail.com", "12323dfs");
        var name = user.getFullName();
        assertNotNull(name);
    }
}