<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <p>This is login.jsp</p>
</head>
<%--标签<label>这是一个标签</label>就是标签的意思。它的for属性是某一个标签的id值，意思是当单击这个label标签时，
    页面会自动把焦点转移到标签id为它for属性的值的标签上。即用户单击这个label标签的作用跟用户单击其相对应的标签作用是一样的。
    比如用户名标签，用户单击用户名的label标签，那么input中id为username的标签就会被选中，用户可以直接在其中输入信息。
    input中的placeholder属性，为提醒用户的作用，如上图中的请输入用户名一样，起到提示的作用。--%>
<body>
    <form action="" method="get">
    <label for="username">用户名</label>
    <input type="text" id="username" name="username" placeholder="Jack">
    <label for="password">用户名</label>
    <input type="password" name="pwd" id="password" placeholder="Input password">
    <br>
    <label>sex：</label>
    <input type="radio" name="sex" value="0" checked>男
    <input type="radio" name="sex"value="1">女
    <br>
    <label>fruit：</label>
    apple<input type="checkbox" name="apple" >
    orange <input type="checkbox" name="orange" checked>
    <br>
    <input type="submit" value="submit">
    </form>
</body>
</html>