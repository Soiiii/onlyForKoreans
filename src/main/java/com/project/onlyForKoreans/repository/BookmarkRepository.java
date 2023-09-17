package com.project.onlyForKoreans.repository;

import com.project.onlyForKoreans.model.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark, Integer> {

}
