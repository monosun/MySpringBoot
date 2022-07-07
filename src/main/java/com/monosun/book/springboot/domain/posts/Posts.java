package com.monosun.book.springboot.domain.posts;

import com.monosun.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//lombook
@Getter
@NoArgsConstructor
//JPA
@Entity  //posts table
public class Posts extends BaseTimeEntity {

    @Id  //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK Rule auto_increment
    private Long id;

    @Column(length=500,nullable = false)//VARCHAR(500) not null
    private String title;

    @Column(columnDefinition = "TEXT",nullable = false)//TEXT type not null
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title =title;
        this.content=content;
        this.author=author;
    }

    public void update(String title,String content){
        this.title=title;
        this.content=content;
    }

}
