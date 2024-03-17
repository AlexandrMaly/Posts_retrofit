package org.example.app.controller;

import org.example.app.entity.User;
import org.example.app.model.UserModel;
import org.example.app.utils.AppStarter;
import org.example.app.utils.Constants;
import org.example.app.view.UserByIdView;
import retrofit2.Response;

import java.util.Optional;

public class UserByIdController {

    UserModel model;
    UserByIdView view;

    public UserByIdController(UserModel model, UserByIdView view) {
        this.model = model;
        this.view = view;
    }

    public void getUserById() {
        view.getOutput(readUserById(
                Integer.parseInt(view.getData())
        ));
        AppStarter.startApp();

    }

    private String readUserById(int id) {
        Optional<Response<User>> optional = model.fetchPostById(id);

        if (optional.isEmpty()) {
            return Constants.NO_DATA_MSG;
        } else {
            User post = optional.get().body();
            return "User: id " + post.getId() + "\n" + "Title: " + post.getTitle() +
                    "\n" + "Body: " + post.getBody();
        }
    }
}

