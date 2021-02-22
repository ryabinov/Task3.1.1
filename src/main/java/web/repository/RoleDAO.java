package web.repository;

import web.models.Role;


public interface RoleDAO {

    void save(Role role);

    void delete(Role role);

    Role getById(Long id);

    Role getRoleByName(String rolename);

    Role createRoleIfNotFound(String name, long id);

}
