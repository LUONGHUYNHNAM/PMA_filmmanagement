package com.huynhnam.pma_filmanagement.service.iservice;




import com.huynhnam.pma_filmanagement.dto.RegisterDTO;
import com.huynhnam.pma_filmanagement.model.User;

import java.util.List;

public interface IUserService {

    List<User> findAllUsers();
    User findById(Integer id);
    User findByEmail(String email);
    User findByPhoneNumber(String phoneNumber);
    User addUser(User user);
    User updateUser(User user);
    void deleteUser(User user);

    User registerDTOToUser(RegisterDTO registerDTO);

}
