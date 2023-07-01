package com.project.onlyForKoreans.service;

import com.project.onlyForKoreans.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;


    @Transactional
    public void delete(int id){
        boardRepository.deleteById(id);
    }

}
