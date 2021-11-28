package web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

import javax.annotation.PostConstruct;

@Component
public class InitDB {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public InitDB(UserService userService, RoleService roleService){
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void init(){
        //RoleBase init
        roleService.addRole(new Role("ROLE_USER"));
        roleService.addRole(new Role("ROLE_ADMIN"));

        //init user Alice
        User user = new User("ALICE", "ALICEPASS");
        user.getRoleSet().add(roleService.getRoleByName("ROLE_USER"));
        userService.addUser(user);

        //init user Bob
        user = new User("BOB", "BOBPASS");
        user.getRoleSet().add(roleService.getRoleByName("ROLE_USER"));
        userService.addUser(user);

        //init user Carl
        user = new User("CARL", "CARLPASS");
        user.getRoleSet().add(roleService.getRoleByName("ROLE_USER"));
        userService.addUser(user);

        //init user Admin
        user = new User("ADMIN", "ADMIN");
        user.getRoleSet().add(roleService.getRoleByName("ROLE_USER"));
        user.getRoleSet().add(roleService.getRoleByName("ROLE_ADMIN"));
        userService.addUser(user);
    }

}
