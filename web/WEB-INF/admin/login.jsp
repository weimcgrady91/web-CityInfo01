<%@ page language="java" contentType="text/html; charset=gb2312" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
<head>
    <title>����Ա��¼</title>
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
                            <td align="right" width="40%">�û�����&nbsp;&nbsp;</td>
                            <td style="text-indent:5px"><input type="text" name="username" size="30"></td>
                        </tr>
                        <tr height="30">
                            <td align="right">��&nbsp;&nbsp;�룺&nbsp;&nbsp;</td>
                            <td style="text-indent:5px"><input type="text" name="password" size="30"></td>
                        </tr>
                        <tr height="60">
                            <td></td>
                            <td>
                                <input type="submit" value="��¼">
                                <input type="reset" value="����">
                                <a href="<%=basePath%>index">[������ҳ]</a>
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