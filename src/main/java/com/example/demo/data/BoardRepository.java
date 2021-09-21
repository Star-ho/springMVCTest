package com.example.demo.data;

import com.example.demo.board.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board,Long> {
}
