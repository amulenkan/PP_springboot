package ru.churakova.PP312springboot.dao;

import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import ru.churakova.PP312springboot.models.User;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getUsers() {

        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public void saveUser(User user) {

        entityManager.merge(user);
    }

    @Override
    public User getUser(Integer id) {
        User user = entityManager.find(User.class, id);

        return user;
    }

    @Override
    public void deleteUser(Integer id) {
        entityManager.remove(getUser(id));
    }
}
