package ru.churakova.PP312springboot.dao;


import org.springframework.stereotype.Repository;
import ru.churakova.PP312springboot.models.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getUsers() {

        TypedQuery<User> query = entityManager.createQuery("select u from User u", User.class);
        return query.getResultList();
    }

    @Override
    public void saveUser(User user) {

        entityManager.merge(user);
    }

    @Override
    public User getUser(int id) {
        User user = entityManager.find(User.class, id);

        return user;
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(getUser(id));
    }
}
