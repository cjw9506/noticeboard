package example.noticeboard.controller;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PostForm {

    private String title;
    private String content;
    private String author;
}
