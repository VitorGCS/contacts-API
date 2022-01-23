package com.webApp.demo.webApp.repository;

import com.webApp.demo.webApp.entity.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactInfoRep extends JpaRepository<ContactInfo, Integer>{
}
