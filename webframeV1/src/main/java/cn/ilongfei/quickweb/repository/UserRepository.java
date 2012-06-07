package cn.ilongfei.quickweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cn.ilongfei.quickweb.model.User;

public interface UserRepository extends JpaRepository<User,Long>{
	public User findByUsername(String username);
	
	//Page<User> findByUsername(String username, Pageable pageable);

    public List<User> findByLastname(String lastname);

    @Query("select u from User u where u.firstname = ?")
    public List<User> findByFirstname(String firstname);

    @Query("select u from User u where u.firstname = :name or u.lastname = :name")
    public List<User> findByFirstnameOrLastname(@Param("name") String name);
}
