package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Role;
import com.inti.repositories.RoleRepository;
import com.inti.service.interfaces.IRoleService;

@Service
public class RoleService implements IRoleService {

	@Autowired
	RoleRepository roleRepository;

	@Override
	public List<Role> findAll() {

		return roleRepository.findAll();
	}

	@Override
	public Role findOne(Long id) {

		return roleRepository.findById(id).get();
	}

	@Override
	public Role save(Role role) {

		return roleRepository.save(role);
	}

	@Override
	public void delete(Long id) {
		roleRepository.deleteById(id);
	}

}
