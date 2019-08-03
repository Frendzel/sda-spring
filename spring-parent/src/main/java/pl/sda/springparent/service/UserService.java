package pl.sda.springparent.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.springparent.dto.UserDto;
import pl.sda.springparent.mapper.UserMapper;
import pl.sda.springparent.monitoring.CalculateInvocationTime;
import pl.sda.springparent.repository.UserRepository;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private UserMapper userMapper = UserMapper.INSTANCE;

    @CalculateInvocationTime
    public List<UserDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(user -> userMapper.userModelToUserDto(user))
                .peek(userDto -> log.info("Mapping: {}", userDto.toString()))
                .collect(toList());
    }
}
