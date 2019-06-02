package com.flywithxinxin.memo.dao;

import com.flywithxinxin.memo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoDao extends JpaRepository<Memo, Integer> {
    List<Memo> findMemosByUserIdOrderByCreateTimeDesc(Integer userId);
    Memo findMemoById(Integer memoId);
}
