package pontta.teste.crud.mapper;


import org.springframework.stereotype.Component;
import pontta.teste.crud.dto.UserDTO;
import pontta.teste.crud.model.User;

@Component
public class UserMapper {

    public UserDTO toDTO(User user) {
        return new UserDTO(user.getId(), user.getEmail(), user.getName(), user.getDateOfBirth());
    }

    public User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.id());
        user.setEmail(userDTO.email());
        user.setName(userDTO.name());
        user.setDateOfBirth(userDTO.dateOfBirth());
        return user;
    }
}
