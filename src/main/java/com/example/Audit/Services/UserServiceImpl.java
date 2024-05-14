package com.example.Audit.Services;
import com.example.Audit.Entity.User;
import com.example.Audit.Repo.UserRepository;
import com.example.Audit.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUser(int id) {
        return userRepository.findById(id).orElse(null);
    }
}
