package com.example.demo.board;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long Id;
    private  String title;
    private  String text;
    @OneToMany(targetEntity = Reply.class)
    private  List<Reply> replyId;

}
