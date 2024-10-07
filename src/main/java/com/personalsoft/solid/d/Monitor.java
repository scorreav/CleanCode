package com.personalsoft.solid.d;

public class Monitor {

    private final String origin;
    private IInfo iInfo;

    public Monitor(String origin, IInfo iInfo) {
        this.origin = origin;
        this.iInfo = iInfo;
    }

    public void show() {
        var infoByFile = new InfoByFile(this.origin);
        var posts = iInfo.lecturaJson();

        posts.forEach(post -> System.out.println(post.getTittle()));
    }
}
