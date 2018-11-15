package com.crosscode.ConsumerDB.demo.consumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crosscode.ConsumerDB.bean.IPRepository;
import com.crosscode.ConsumerDB.bean.IpAddress;

@Service
public class ConsumeService {

	@Autowired
	IPRepository iprepo;

	public List<IpAddress> getUser(){
		System.out.println("===========================================");
		for(IpAddress ap:(List<IpAddress>)iprepo.findAll())
		{
			System.out.println("Ip address is:-"+ap.getIP());
		}
		System.out.println("===========================================");
		return (List<IpAddress>) iprepo.findAll();
	}
}
