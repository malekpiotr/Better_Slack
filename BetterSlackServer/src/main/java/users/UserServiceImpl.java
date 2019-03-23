package users;

import java.util.Optional;

public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void register(String username, String password) {
        Optional<User> foundUser = userRepository.find(username);
        if(foundUser.isPresent()){
            throw new IllegalStateException("users.User with " + username + " already exist!");
        }
        if(!User.isUsernameValid(username)){
            throw new IllegalStateException("Valid username should have " +
                    "a lenght between " + User.MIN_USERNAME_LENGHT +
                    " and " + User.MAX_USERNAME_LENGHT);
        }

        User user = new User(username, password);
        userRepository.add(user);
    }
}
