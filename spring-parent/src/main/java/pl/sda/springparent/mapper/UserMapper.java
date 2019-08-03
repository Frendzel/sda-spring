package pl.sda.springparent.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.sda.springparent.dao.UserModel;
import pl.sda.springparent.dto.UserDto;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserModel userDtoToUserModel(UserDto userDto);

    UserDto userModelToUserDto(UserModel userModel);

}
