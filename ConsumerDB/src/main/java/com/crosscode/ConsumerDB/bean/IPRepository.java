package com.crosscode.ConsumerDB.bean;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPRepository extends JpaRepository<IpAddress,String>{

}
