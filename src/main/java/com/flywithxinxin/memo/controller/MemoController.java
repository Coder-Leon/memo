package com.flywithxinxin.memo.controller;

import com.flywithxinxin.memo.entity.Memo;
import com.flywithxinxin.memo.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/memo")
@CrossOrigin
public class MemoController {

    @Autowired
    MemoService memoService;

    @GetMapping("/query/all")
    public Map<String, Object> queryAllMemo(@RequestParam Integer userid, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        Integer userSessionId = (Integer) session.getAttribute("userId");
        if (Objects.equals(userid, userSessionId)) {
            List<Memo> list = memoService.listAllMemo(userid);
            map.put("success", 1);
            map.put("message", "Query all memos success.");
            map.put("data", list);
        } else {
            map.put("success", 0);
            map.put("message", "Query default.");
        }
        return map;
    }

    @PostMapping("/insert")
    public Map<String, Object> insertMemo(@RequestBody Map<String, Object> body, HttpSession session) {
        Integer sessionUserId = (Integer) session.getAttribute("userId");
        Integer userId = (Integer) body.get("userId");
        String content = (String) body.get("content");
        return memoService.insertMemo(userId, sessionUserId, content);
    }

    @PostMapping("/update")
    public Map<String, Object> updateMemo(@RequestBody Map<String, Object> body) {
        Integer memoId = (Integer) body.get("memoId");
        Memo memo = memoService.getMemoById(memoId);
        String content = (String) body.get("content");
        return memoService.updateMemo(memo, content);
    }

    @GetMapping("/delete/{memoId}")
    public Map<String, Object> deleteMemo(@PathVariable Integer memoId) {
        return memoService.deleteMemo(memoId);
    }
}
