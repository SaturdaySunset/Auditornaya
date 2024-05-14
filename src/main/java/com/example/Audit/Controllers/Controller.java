package com.example.Audit.Controllers;

import com.example.Audit.Entity.User;
import com.example.Audit.Services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
public class Controller {

    private final UserService userService;

    public Controller(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUser(id);
    }

    @PostMapping
    public User getUserByJson(@RequestBody(required = false) UserRequest userRequest) {
        if (userRequest != null && userRequest.getId() != null) {
            return userService.getUser(userRequest.getId());
        } else {
            // Обработка ошибки, если userRequest пустой или не содержит id
            return null;
        }
    }

    static class UserRequest {
        private Integer id;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }
}
