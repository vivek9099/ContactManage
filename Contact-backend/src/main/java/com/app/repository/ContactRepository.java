package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Contact;

public interface ContactRepository extends JpaRepository<Contact,Long>{

}
