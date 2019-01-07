# 现有API
## 用户相关
* 登陆:
```
 /login
method = POST
username = ?
password = ?
return redirect:/index
```
* 获取登陆界面
```
/login
method : GET
return loginhtml.html
```
* 注册:
```
/register
method = POST
username = ?
password = ?
return redirect:/index
```
* 获取注册页面:
```
/register
method : GET
return register.html
```

## 文章相关
* 发布:
```
/write
method = POST
title = ?
context = ?
hascomment = ?[default = false]
return redirect:/index
```
* 获取发布界面
```
/write
method = GET
return postarticle.html
```
* 获取文章:
```
/article/{id}
method = GET
return read.html
```
* 修改文章:
 - 获得修改的文章(通过id)
```
/edit/{id}
method = GET
return editarticle.html
```
 - 上传修改的文章
```
/edit
method = POST
articleid = autofill
postdate = autofill
title = ?
context  = ?
hascomment = ?
return redirect:/article/{id}
```
* 删除已发布的文章
```
/deletearticle/{id}
method = GET
return redirect:/index
```
## 评论相关
* 发布评论
```
/postcomment
method = POST
return redirect:/article/{id}
```