package com.project.onlyForKoreans.service;

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
    public void write(Board board, User user, Country country, Category category){
        System.out.println("@@Service");
        System.out.println("board:" + board + " user:" +user + " country:" +country + " category:" +category);
        board.setTitle(board.getTitle());
        board.setContent(board.getContent());
        board.setCount(0);
        board.setUser(user);
        board.setCountry(country);
        board.setCategory(category);
        boardRepository.save(board);
    }

    public List<Country> findCountry(){
        return countryRepository.findAll();
    }

    public List<Category> findCategory(){
        return categoryRepository.findAll();
    }
}
