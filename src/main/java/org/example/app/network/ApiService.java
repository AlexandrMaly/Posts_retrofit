package org.example.app.network;

import org.example.app.entity.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface ApiService {
    @GET("posts")
    Call<List<User>> getPosts();

    @GET("posts/{id}")
    Call<User> getPostById(@Path("id") int id);
}
