package pontta.teste.crud.service;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import pontta.teste.crud.dto.UserDTO;
import pontta.teste.crud.mapper.UserMapper;
import pontta.teste.crud.model.User;
import pontta.teste.crud.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        User savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Usuario nao encontrado"));
        return userMapper.toDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Usuario nao encontrado"));
        user.setName(userDTO.name());
        user.setEmail(userDTO.email());
        user.setDateOfBirth(userDTO.dateOfBirth());
        User savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


}
