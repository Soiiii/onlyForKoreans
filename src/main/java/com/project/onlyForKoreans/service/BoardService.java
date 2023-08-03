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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public Board write(BoardDto boardDto, User user, Country country, Category category){
        System.out.println("@@Service");
//        Country countryEntity = new Country(country.getName());
//        System.out.println("countryEntity:"+countryEntity);
//        countryRepository.save(country);

//        Category categoryEntity = new Category(category.getName());
//        System.out.println("categoryEntity:"+categoryEntity);

//        categoryRepository.save(category);

//        Optional<Category> category = categoryRepository.findById(scheduleDto.getCategory().getCategory_id());

        Board board = Board.builder()
            .title(boardDto.getTitle())
            .content(boardDto.getContent())
            .user(user)
            .country(country)
            .category(category)
            .build();
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
}
