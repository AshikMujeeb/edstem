package com.example.edstem.Repository;

import com.example.edstem.Entity.UserTypes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTypeRepository  extends JpaRepository<UserTypes, String> {
}
