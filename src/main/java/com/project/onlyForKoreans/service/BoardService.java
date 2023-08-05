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
        System.out.println("@@Service");
//        System.out.println("country.getId():"+country.getId()+ " " + country.getId());

//        Optional<Country> existingCountry = countryRepository.findById(country.getId());
//        Country countryEntity = existingCountry.orElse(country);
//        System.out.println("countryEntity: " + countryEntity);

//        Optional<Category> existingCategory = categoryRepository.findById(category.getId());
//        Category categoryEntity = existingCategory.orElse(category);
//        System.out.println("categoryEntity: " + categoryEntity);



//        Country countryEntity = new Country(country.getName());
//        System.out.println("countryEntity:"+countryEntity);
//        countryRepository.save(country);
//
//        Category categoryEntity = new Category(category.getName());
//        System.out.println("categoryEntity:"+categoryEntity);
//
//        categoryRepository.save(category);
//        Optional<Category> category = categoryRepository.findById((int) boardDto.getCategory().getId());

//        Optional<Category> category = categoryRepository.findById(boardDto.getCategory().getId());
//        Optional<Country> country = countryRepository.findById((int) boardDto.getCountry().getId());


        System.out.println("category:" +category + " country:" + country);

        Board board = Board.builder()
            .title(boardDto.getTitle())
            .content(boardDto.getContent())
            .user(user)
            .country(country.get())
            .category(category.get())
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

    public List<Board> list() {
        System.out.println("@@@SERVICEHEREEE");
        return boardRepository.findAll();
    }
}
