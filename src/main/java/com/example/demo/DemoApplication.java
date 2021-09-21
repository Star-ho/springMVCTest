package com.example.demo;

import com.example.demo.board.Board;
import com.example.demo.data.BoardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(BoardRepository repo){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Board board=new Board();
                board.setText("asdasd");
                repo.save(board);

            }
        };
    }

}
