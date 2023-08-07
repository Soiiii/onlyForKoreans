package com.project.onlyForKoreans.service;

import com.project.onlyForKoreans.dto.BoardDto;
import com.project.onlyForKoreans.model.Board;
import com.project.onlyForKoreans.model.Category;
import com.project.onlyForKoreans.model.Country;
import com.project.onlyForKoreans.model.User;
import com.project.onlyForKoreans.repository.BoardRepository;
import com.project.onlyForKoreans.repository.CategoryRepository;
import com.project.onlyForKoreans.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public void delete(int id){
        boardRepository.deleteById(id);
    }

    
    @Transactional
    public Board write(BoardDto boardDto, User user, Optional<Country> country, Optional<Category> category){
        System.out.println("category:" +category + " country:" + country);


        Board board = Board.builder()
            .title(boardDto.getTitle())
            .content(boardDto.getContent())
            .user(user)
            .country(country.get())
            .category(category.get())
             .build();

//        if (board.getCreate_at() == null) {
//            System.out.println("??");
//            board.setCreate_at(new Timestamp(System.currentTimeMillis()));
//        }
//        // Save or update the board entity in the database
//        board.setUpdate_at(new Timestamp(System.currentTimeMillis()));

        System.out.println("board:"+board);
        Board boardInfo = boardRepository.save(board);
        return boardInfo;
    }

    public List<Country> findCountry(){
        return countryRepository.findAll();
    }

    public List<Category> findCategory(){
        return categoryRepository.findAll();
    }
    public List<Board> list() {
        return boardRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Page<Board> list(Pageable pageable){
        return boardRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Board details(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("글 상세보기 실패: 아이디 찾기 실패");
                });
    }


}
