package com.flywithxinxin.memo.service;

import com.flywithxinxin.memo.dao.MemoDao;
import com.flywithxinxin.memo.entity.Memo;
import com.flywithxinxin.memo.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MemoService {

    @Autowired
    MemoDao memoDao;

    public Memo getMemoById(Integer memoId){
        return memoDao.findMemoById(memoId);
    }

    public List<Memo> listAllMemo(Integer userId) {
        List<Memo> memos = memoDao.findMemosByUserIdOrderByCreateTimeDesc(userId);
        return memos;
    }

    public Map<String, Object> insertMemo(Integer userId, Integer sessionUserId, String content) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map1 = new HashMap<>();
        if (!Objects.equals(userId, sessionUserId)) {
            map.put("success", 0);
            map.put("message", "Please try logout and login again.");
            return map;
        }
        Memo memo = new Memo();
        memo.setUserId(userId);
        memo.setContent(content);
        memo.setCreateTime(new Date());
        memo.setUpdateTime(new Date());
        Memo result;
        result = memoDao.saveAndFlush(memo);
        if (result == null) {
            map.put("success", 0);
            map.put("message", "Add memo default.");
            map.put("data", map1);
        } else {
            map.put("success", 1);
            map.put("message", "Add memo success.");
            map1.put("memoId", result.getId());
            String createTime = DateTimeUtil.formatDateTimeNew(result.getCreateTime());
            map1.put("memoCreateTime", createTime);
            map.put("data", map1);
        }
        return map;
    }

    public Map<String, Object> updateMemo(Memo memo, String content) {
        Map<String, Object> map = new HashMap<>();
        if (memo == null){
            map.put("success", 0);
            map.put("message", "Update memo default.");
            return map;
        }
        memo.setContent(content);
        memo.setUpdateTime(new Date());
        Memo result;
        result = memoDao.saveAndFlush(memo);
        if (result == null) {
            map.put("success", 0);
            map.put("message", "Update memo default.");
        } else {
            map.put("success", 1);
            map.put("message", "Update memo success.");
            Map<String, Object> map1 = new HashMap<>();
            map1.put("memoId", result.getId());
            String createTime = DateTimeUtil.formatDateTimeNew(result.getCreateTime());
            String updateTime = DateTimeUtil.formatDateTimeNew(result.getUpdateTime());
            map1.put("memoCreateTime", createTime);
            map1.put("memoUpdateTime", updateTime);
            map.put("data", map1);
        }
        return map;
    }

    public Map<String, Object> deleteMemo(Integer memoId) {
        Map<String, Object> map = new HashMap<>();
        Memo memo = memoDao.findMemoById(memoId);
        if (memo == null) {
            map.put("success", 0);
            map.put("message", "Delete memo " + memoId + " default.");
        } else {
            memoDao.deleteById(memoId);
            map.put("success", 1);
            map.put("message", "Delete memo " + memoId + " success.");
        }
        return map;
    }
}
