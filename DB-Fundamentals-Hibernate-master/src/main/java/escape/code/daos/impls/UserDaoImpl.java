package escape.code.daos.impls;

import com.google.inject.Inject;
import escape.code.daos.UserDao;
import escape.code.models.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

import static escape.code.utils.Messages.INCORRECT_PASSWORD;
import static escape.code.utils.Messages.USER_EXIST;
import static escape.code.utils.Messages.USER_NOT_FOUND;

/**
 * Data access object responsible for connection with user database
 */
public class UserDaoImpl implements UserDao {

    @Inject
    private EntityManager entityManager;

    /**
     * Gets current logged in user by given username and password
     *
     * @param username - tipped username
     * @param password - tipped password
     * @return - corresponding user
     * @throws IllegalArgumentException when username is null or password is incorrect
     */
    @Override
    public User getLogedUser(String username, String password) {
        User user = this.getUserByName(username);
        if (user == null) {
            throw new IllegalArgumentException(USER_NOT_FOUND);
        } else if (!user.getPassword().equals(password)) {
            throw new IllegalArgumentException(INCORRECT_PASSWORD);
        }
        return user;
    }

    /**
     * Persists new registered user in DB
     *
     * @param user - registered user
     * @throws IllegalArgumentException when username is already taken
     */
    public void create(User user) {
        User currentUser = this.getUserByName(user.getName());
        if (currentUser != null) {
            throw new IllegalArgumentException(USER_EXIST);
        }
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(user);
        this.entityManager.getTransaction().commit();
    }

    /**
     * Updates user's status
     *
     * @param user - current logged in user
     */
    @Override
    public void updateUser(User user) {
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(user);
        this.entityManager.getTransaction().commit();
    }

    /**
     * Gets user from database by given username
     *
     * @param userName - given username as string
     * @return - corresponding user or null if there in no registered user with that username
     */
    @SuppressWarnings("unchecked")
    private User getUserByName(String userName) {
        Query query = this.entityManager.createQuery("SELECT user FROM User AS user WHERE user.name=:name");
        query.setParameter("name", userName);
        List<User> users = query.getResultList();
        if (users.size() == 0) {
            return null;
        }
        return users.get(0);
    }
}
