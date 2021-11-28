package web.service;

import web.model.Role;

import java.util.List;

public interface RoleService {

    public List<Role> getAllRoles();
    public Role getRoleById(Long id);
    public Role getRoleByName(String role);
    public void addRole(Role role);
    public void updateRole(Role role);
    public void removeRoleById(Long id);

}
