package com.mealti.demo.repository;

import com.mealti.demo.domain.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(User user){
        em.persist(user);
    }

    public User findOne(Long id){
        return em.find(User.class, id);
    }

    public List<User> findAll(){
        return em.createQuery("select m from User m",User.class)
                .getResultList();
    }

    public List<User> findByEmail(String email){
        return em.createQuery("select m from User m where m.email = :email", User.class)
                .setParameter("email",email)
                .getResultList();
    }


}
