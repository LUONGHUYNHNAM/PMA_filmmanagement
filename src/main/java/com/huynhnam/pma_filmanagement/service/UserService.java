package com.huynhnam.pma_filmanagement.service;

import com.huynhnam.pma_filmanagement.dto.RegisterDTO;
import com.huynhnam.pma_filmanagement.model.User;
import com.huynhnam.pma_filmanagement.repository.RoleRepository;
import com.huynhnam.pma_filmanagement.repository.UserRepository;
import com.huynhnam.pma_filmanagement.service.iservice.IUserService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<User> findAllUsers() {
        return  userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public User findByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber).orElse(null);
    }

    @Override
    public User addUser(User user) {
        // 1. Kiểm tra sdt đã tồn tại hay chưa //
        User existingUser = userRepository.findByPhoneNumber(user.getPhoneNumber()).orElse(null);
        User saveUser = userRepository.findByEmail(user.getEmail()).orElse(null);
        if(existingUser == null && saveUser == null) {
            // 3. Thêm user : Return User vua them
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public User updateUser(User user) {
        // 1. Kiểm tra sự tồn tại của user
        User existingUser = userRepository.findById(user.getUserId()).orElse(null);
        if (existingUser != null) {
            return userRepository.save(user);
        }else
            return null;
    }

    @Override
    public void deleteUser(User user) {
        // 1. Kiểm tra sự tồn tại của user
        userRepository.findById(user.getUserId()).ifPresent(userRepository::delete);
    }

    @Override
    public User registerDTOToUser(RegisterDTO registerDTO) {
        User user = User.builder()
                .fullname(registerDTO.getFullName())
                .email(registerDTO.getEmail())
                .address(registerDTO.getAddress())
                .phoneNumber(registerDTO.getPhone())
                .password(registerDTO.getPassword())
                .gender(false)
                .day_of_birth(new Date())
                .role(roleRepository.findById(2).orElse(null))
                .build();
        return user;
    }

}
