package com.ll.jigumiyak.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    public Board getBoard(Long id) {
        Optional<Board> board = this.boardRepository.findById(id);
        if(board.isPresent()) {
            return board.get();
        } else {
            return null;
        }
    }
    public void create(String subject, String content) {
        Board b = new Board();
        b.setSubject(subject);
        b.setContent(content);
        b.setCreateDate(LocalDateTime.now());
        this.boardRepository.save(b);

    }
}
