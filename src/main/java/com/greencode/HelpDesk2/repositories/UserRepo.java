package com.greencode.HelpDesk2.repositories;

import com.greencode.HelpDesk2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
