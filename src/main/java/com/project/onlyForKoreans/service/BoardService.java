package com.project.onlyForKoreans.service;

import com.project.onlyForKoreans.dto.BoardDto;
import com.project.onlyForKoreans.model.*;
import com.project.onlyForKoreans.repository.*;
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

    @Autowired
    private BookmarkRepository bookmarkRepository;

    @Autowired
    private UserRepository userRepository;

    // 글 작성
    @Transactional
    public Board write(BoardDto boardDto, User user, Optional<Country> country, Optional<Category> category){
//        System.out.println("category:" +category + " country:" + country);
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

//        System.out.println("board:"+board);
        Board boardInfo = boardRepository.save(board);
        return boardInfo;
    }

    // 글 삭제
    @Transactional
    public void delete(Long id){
        boardRepository.deleteById(id);
    }

    // 글 수정
    public void edit(Long id, Board requestBoard){
        Board board = boardRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("글 찾기 실패: 아이디 찾기 실패");
                });
        board.setTitle(requestBoard.getTitle());
        board.setContent(requestBoard.getContent());

        boardRepository.save(board);
    }


    //북마크 등록, 삭제
    public String bookmarkBoth(Long boardId, Long userId) {
        System.out.println("Service");
        Board board = boardRepository.findById(boardId)
                .orElseThrow(()->{
                    return new IllegalArgumentException("글 상세보기 실패: 아이디 찾기 실패");
                });
        User user = userRepository.findById(userId)
                .orElseThrow(()->{
                    return new IllegalArgumentException("유저 찾기 실패: 아이디 찾기 실패");
                });
        Bookmark bookmark = new Bookmark();
        bookmark.setBoard(board);
        bookmark.setUser(user);

        if(bookmarkRepository.findUserAndBoard(boardId, userId).isEmpty()){
            System.out.println("add bookmark");
            addBookmark(bookmark);
        } else{
            deleteBookmark(boardId, userId);

        }
        return null;
//        Bookmark bookmark = bookmarkRepository.
    }


    //북마크 등록
    public void addBookmark(Long boardId, Long userId){
        Board board = boardRepository.findById(boardId)
                .orElseThrow(()->{
                    return new IllegalArgumentException("글 찾기 실패: Fail to find board id");
                });

        User user = userRepository.findById(userId)
                .orElseThrow(()->{
                      return new IllegalArgumentException("회원 찾기 실패: Fail to find user id");
                });

        Bookmark bookmark = new Bookmark();
        bookmark.setBoard(board);
        bookmark.setUser(user);

        if(bookmarkRepository.findUserAndBoard(boardId, userId).isEmpty()){
            // 북마크에 값이 없다면 저장
            addBookmark(bookmark);
        }
//        else{
            //북마크에 값이 이미 있다면 삭제
//            bookmarkRepository.deleteByBoardAndUser(boardId, userId);
//            deleteBookmark(boardId, userId);
//        }
    }

    //즐겨찾기 삭제
    @Transactional
    public void deleteBookmark(Long boardId, Long userId){
        System.out.println("delete");
        bookmarkRepository.deleteByBoardAndUser(boardId, userId);
    }

    //즐겨찾기 등록
    @Transactional
    public void addBookmark(Bookmark bookmark){
        System.out.println("add");
        bookmarkRepository.save(bookmark);
    }


    public List<Country> findCountry() {
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

    @Transactional
    public void updateCount(Long id, BoardDto boardDto){
        Board board = boardRepository.findById(id).orElseThrow(()->
                new IllegalStateException("해당 게시물이 존재하지 않습니다."));
        board.setCount(board.getCount());
    }

    public String bookmark(Long id) {
            Board board = boardRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("글 상세보기 실패: 아이디 찾기 실패");
                });

        return null;
//        Bookmark bookmark = bookmarkRepository.
    }


}
