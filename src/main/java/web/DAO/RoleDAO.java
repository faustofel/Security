package web.DAO;

import web.model.Role;

import java.util.List;

public interface RoleDAO {

    public List<Role> getAllRoles();
    public Role getRoleById(Long id);
    public Role getRoleByName(String role);
    public void addRole(Role role);
    public void updateRole(Role role);
    public void removeRoleById(Long id);

}
