<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生管理</title>
</head>
<body>
<a href="/studentAdd.html">添加</a><br/>
<form method="post" action="/student/list2">
    学生姓名：<input type="text" name="name" />&nbsp;
    年龄：<input type="text" name="age" />&nbsp;
    <input type="submit" value="搜索"/>
</form>
<table>
    <tr>
        <th>编号</th>
        <th>学生姓名</th>
        <th>年龄</th>
        <th>操作</th>
    </tr>
	<#list studentList as student>
		<tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td>
                <a href="/student/preUpdate/${student.id}">修改</a>
                <a href="/student/delete?id=${student.id}">删除</a>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>