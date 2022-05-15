package pl.sda.partyorganising.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.sda.partyorganising.entity.UserEntity;

import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserRepositoryIT {

    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldDoCrudOperations() {
        //given
        UserEntity userEntity = new UserEntity("testLogin", "testpassword","test@test.com", "testNick", Set.of());
        //when
        userRepository.saveAndFlush(userEntity);
        Optional<UserEntity> userEntityFromDb = userRepository.findById(userEntity.getId());
        //then
        assertThat(userEntityFromDb.isPresent()).isTrue();
        assertThat(userEntityFromDb.get()).usingRecursiveComparison().isEqualTo(userEntity);

        //given
        userEntity.setNickName("newTestNick");
        //when
        userRepository.saveAndFlush(userEntity);
        userEntityFromDb = userRepository.findById(userEntity.getId());
        //then
        assertThat(userEntityFromDb.isPresent()).isTrue();
        assertThat(userEntityFromDb.get().getNickName()).isEqualTo("newTestNick");

        //when
        userRepository.delete(userEntity);
        userEntityFromDb = userRepository.findById(userEntity.getId());
        //then
        assertThat(userEntityFromDb.isEmpty()).isTrue();
    }
}