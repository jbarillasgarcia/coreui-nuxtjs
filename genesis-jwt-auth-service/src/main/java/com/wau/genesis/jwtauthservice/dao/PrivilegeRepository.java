package com.wau.genesis.jwtauthservice.dao;

import com.wau.genesis.core.model.ApplicationPrivilegeEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Josue Barillas (jbarillas)
 */
@Repository
public interface PrivilegeRepository extends CrudRepository<ApplicationPrivilegeEntity, Integer> {

    public ApplicationPrivilegeEntity findByName(String name);

    @Query(
            value = "SELECT pri.id, pri.name, pri.description"
            + " FROM application_user AS usr,"
            + " application_authority_rel_user AS aru,"
            + " application_authority AS aut,"
            + " application_privilege_rel_authority AS pra,"
            + " application_privilege AS pri"
            + " WHERE 1 = 1"
            + " AND usr.id = aru.user"
            + " AND aru.authority = aut.id"
            + " AND aut.id = pra.authority"
            + " AND pra.privilege = pri.id"
            + " AND usr.username = ?1"
            + " UNION"
            + " SELECT pri.id, pri.name, pri.description"
            + " FROM application_user AS usr,"
            + " application_privilege_rel_user AS pru,"
            + " application_privilege AS pri"
            + " WHERE usr.id = pru.user"
            + " AND pru.privilege = pri.id"
            + " AND usr.username = ?1",
            nativeQuery = true
    )
    public List<ApplicationPrivilegeEntity> findAllByUsername(String username);
    
    @Query(
            value = "SELECT pri.id, pri.name, pri.description"
            + " FROM application_user AS usr,"
            + " application_privilege_rel_user AS pru,"
            + " application_privilege AS pri"
            + " WHERE usr.id = pru.user"
            + " AND pru.privilege = pri.id"
            + " AND usr.username = ?1",
            nativeQuery = true
    )
    public List<ApplicationPrivilegeEntity> findByUsername(String username);

}
