package com.inti.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Role;
import com.inti.service.interfaces.IRoleService;

@RestController
@CrossOrigin
public class RoleController {
	@Autowired
	IRoleService roleService;

	@GetMapping("/roles")
	public List<Role> findAll() {
		return roleService.findAll();
	}

	@GetMapping("/roles/{idRole}")
	public Role findOne(@PathVariable("idRole") Long id) {
		return roleService.findOne(id);
	}

	@PostMapping("/roles")
	public Role saveRole(@RequestBody Role role) {
		return roleService.save(role);
	}

	@DeleteMapping("/roles/{idRole}")
	public void deleteRole(@PathVariable("idRole") Long id) {
		roleService.delete(id);
	}

	@PutMapping("/roles/{idRole}")
	public Role updateRoleWithPut(@PathVariable("idRole") Long id, @RequestBody Role role) { //
		Role currentRole = roleService.findOne(id);
		currentRole.setLibelle(role.getLibelle());
		return roleService.save(currentRole);
	}

	@PatchMapping("/roles/{idRole}")
	public Role updateRoleWithPatch(@PathVariable("idRole") Long id, @RequestBody Role role) {
		Role currentRole = roleService.findOne(id);
		currentRole.setLibelle(role.getLibelle());
		return roleService.save(currentRole);
	}
}
