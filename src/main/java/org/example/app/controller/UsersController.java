package org.example.app.controller;

import org.example.app.entity.User;
import org.example.app.model.UserModel;
import org.example.app.utils.AppStarter;
import org.example.app.utils.Constants;
import org.example.app.view.UsersView;
import retrofit2.Response;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class UsersController {

    UserModel model;
    UsersView view;

    public UsersController(UserModel model, UsersView view) {
        this.model = model;
        this.view = view;
    }

    public void getUser() {
        view.getOutput(readUser());
        AppStarter.startApp();
    }

    private String readUser() {
        Optional<Response<List<User>>> optional = model.fetchPosts();
        if (optional.isEmpty()) {
            return Constants.NO_DATA_MSG;
        } else {
            List<User> posts = optional.get().body();

            StringBuilder stringBuilder = new StringBuilder();
            AtomicInteger cnt = new AtomicInteger(0);
            String str;

            for (User post : posts) {
                str = cnt.incrementAndGet() + ") User: id " + post.getId() + "\n" + "Title: "
                        + post.getTitle() + "\n" + "Body: " + post.getBody() + "\n";
                stringBuilder.append(str);
            }
            return stringBuilder.toString();
        }
    }
}


