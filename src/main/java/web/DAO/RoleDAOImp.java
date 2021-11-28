package web.DAO;

import org.springframework.stereotype.Repository;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class RoleDAOImp implements RoleDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("FROM Role", Role.class).getResultList();
    }

    @Override
    public Role getRoleById(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public Role getRoleByName(String role) {
        return entityManager.createQuery("FROM Role WHERE role=:role", Role.class)
                            .setParameter("role", role)
                            .getSingleResult();
    }

    @Override
    public void addRole(Role role) {
        System.out.println(role);
        entityManager.persist(role);
    }

    @Override
    public void updateRole(Role role) {
        // заложен но не реализован
    }

    @Override
    public void removeRoleById(Long id) {
        // заложен но не реализован
    }
}
