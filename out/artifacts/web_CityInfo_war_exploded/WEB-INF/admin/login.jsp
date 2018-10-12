<%@ page language="java" contentType="text/html; charset=gb2312" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
<head>
    <title>管理员登录</title>
    <base href="<%=basePath%>">
    <link type="text/css" rel="stylesheet" href="<%=basePath%>css/style.css">
</head>
<body bgcolor="#E7ECEF">
<center>
    <form action="<%=basePath%>admin/login" method="post">
        <table border="0" cellspacing="0" cellpadding="0" style="margin-top:130px">
            <tr>
                <td><img src="<%=basePath%>images/logon_top.gif"></td>
            </tr>
            <tr height="180">
                <td background="<%=basePath%>images/logon_middle.gif" align="center" valign="top">
                    <table border="0" width="90%" cellspacing="0" cellpadding="0">
                        <tr height="30">
                            <td align="right" width="40%">用户名：&nbsp;&nbsp;</td>
                            <td style="text-indent:5px"><input type="text" name="username" size="30"></td>
                        </tr>
                        <tr height="30">
                            <td align="right">密&nbsp;&nbsp;码：&nbsp;&nbsp;</td>
                            <td style="text-indent:5px"><input type="text" name="password" size="30"></td>
                        </tr>
                        <tr height="60">
                            <td></td>
                            <td>
                                <input type="submit" value="登录">
                                <input type="reset" value="重置">
                                <a href="<%=basePath%>index">[返回首页]</a>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td><img src="<%=basePath%>images/logon_end.gif"></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>