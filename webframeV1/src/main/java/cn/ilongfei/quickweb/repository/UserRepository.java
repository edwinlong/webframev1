package cn.ilongfei.quickweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cn.ilongfei.quickweb.model.User;

public interface UserRepository extends JpaRepository<User,Long>{
	public User findByAccount(String account);
	
	//Page<User> findByUsername(String username, Pageable pageable);

    /*public List<User> findByRealName(String realname);

    @Query("select u from User u where u.email = ?")
    public List<User> findByEmail(String email);*/

    /*@Query("select u from User u where u.firstname = :name or u.lastname = :name")
    public List<User> findByFirstnameOrLastname(@Param("name") String name);*/
}
