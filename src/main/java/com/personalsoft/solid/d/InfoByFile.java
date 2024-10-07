package com.personalsoft.solid.d;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class InfoByFile implements IInfo {

    private final String path;

    public InfoByFile(String path){
        this.path = path;
    }

    @Override
    public List<Post> lecturaJson() {
        try {
            File file = new File(path);
            var fr = new FileReader(file);
            var br = new BufferedReader(fr);

            List<Post> posts = new ArrayList<>();
            var post = new Gson().fromJson(br.readLine(), Post.class);
            posts.add(post);

            fr.close();
            br.close();

            return posts;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
