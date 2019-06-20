

# Memo - 后端接口说明文档



## 服务端可用性测试

### API

```json
/avail
```

### 请求方法: GET/POST

### 响应体格式

```json
{
    "success": <integer>,
    "message": <string>
}
```

>   说明：success 为 0 时代表响应失败， 1则为响应成功

### 示范

```json
{
    "success": 1,
    "message": "Server is avail."
}
```



## 用户注册

### API
```json
/user/add
```
### 请求方法: POST

### 请求体格式

```json
{
	"account": <string>,
    "password": <string>
}
```

### 示范

```json
{
	"account": "user1",
    "password": "user1"
}
```

### 响应体格式

```json
{
    "success": <integer>,
    "message": <string>,
    "data": <map>
}
```

>   说明：success 为 0 时代表响应失败， 1则为响应成功

### 示范

```json
{
    "success": 1,
    "message": "Add user success.",
    "data": {
        "userId": 1,
        "account": "user1"
    }
}
```



## 用户登录

### API

```json
/user/login
```

### 请求方法: POST

### 请求体格式

```json
{
	"account": <string>,
    "password": <string>
}
```

### 示范

```json
{
	"account": "user1",
    "password": "user1"
}
```

### 响应体格式

```json
{
    "success": <integer>,
    "message": <string>,
    "data": <map>
}
```

>   说明：success 为 0 时代表响应失败， 1则为响应成功

### 示范

```json
{
    "success": 1,
    "message": "user1 login success.",
    "data": {
        "userId": 1,
        "account": "user1"
    }
}
```



##  用户退出

### API

```json
/user/logout
```

### 请求方法: POST

### 请求体格式

```json
{
	<empty>
}
```

### 示范

```json
{
	
}
```

### 响应体格式

```json
{
    "success": <integer>,
    "message": <string>
}
```

>   说明：success 为 0 时代表响应失败， 1则为响应成功

### 示范

```json
{
    "success": 1,
    "message": "user1 logout."
}
```



## 查询备忘录 

### API

```json
/memo/query/all?userid=<integer>
```

### 请求方法: GET

### 示范

```json
/memo/query/all?userid=1
```

### 响应体格式

```json
{
    "success": <integer>,
    "message": <string>,
    "data": <array>
}
```

>   说明：success 为 0 时代表响应失败， 1则为响应成功

### 示范

```json
{
    "success": 1,
    "message": "Query all memos success.",
    "data": [
        {
            "id": 2,
            "userId": 1,
            "content": "测试备忘录修改了内容",
            "createTime": "2019-05-27 11:49:23",
            "updateTime": "2019-05-27 11:49:23"
        },
        {
            "id": 1,
            "userId": 1,
            "content": "第一个测试备忘录修改了内容",
            "createTime": "2019-05-26 20:42:48",
            "updateTime": "2019-05-26 20:56:22"
        }
    ]
}
```



##新建备忘录 

### API

```json
/memo/add
```

### 请求方法: POST

### 请求体格式

```json
{
    "userId": <integer>
	"content": <string>
}
```

### 示范

```json
{
	"userId": 1
	"content": "我的第一个备忘录。"
}
```

### 响应体格式

```json
{
    "success": <integer>,
    "message": <string>,
    "data": <map>
}
```

>   说明：success 为 0 时代表响应失败， 1则为响应成功

### 示范

```json
{
    "success": 1,
    "message": "Add memo success.",
    "data": {
        "memoId": 1,
        "memoCreateTime": "2019-05-27 16:03:13"
    }
}
```



## 更新备忘录 

### API

```json
/memo/update
```

### 请求方法: POST

### 请求体格式

```json
{
    "memoId": <integer>
	"content": <string>
}
```

### 示范

```json
{
	"memoId": 1
	"content": "修改备忘录。"
}
```

### 响应体格式

```json
{
    "success": <integer>,
    "message": <string>,
    "data": <map>
}
```

>   说明：success 为 0 时代表响应失败， 1则为响应成功

### 示范

```json
{
    "data": {
        "memoId": 1,
        "memoCreateTime": "2019-05-26 21:07:46",
        "memoUpdateTime": "2019-05-27 16:20:44"
    },
    "success": 1,
    "message": "Update memo success."
}
```



## 删除备忘录 

### API

```json
/memo/delete/{memoId}
```

### 请求方法: GET

### 示范

```json
/memo/delete/1
```

### 响应体格式

```json
{
    "success": <integer>,
    "message": <string>
}
```

>   说明：success 为 0 时代表响应失败， 1则为响应成功

### 示范

```json
{
    "success": 1,
    "message": "Delete memo 1 success."
}
```

