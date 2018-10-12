<%@ page language="java" contentType="text/html; charset=GBK" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

    String mainPage = (String) request.getAttribute("mainPage");
    if (mainPage == null || mainPage.equals("")) {
        mainPage = "default.jsp";
    }
%>

<html>
<head>
    <title>ºóÌ¨Ê×Ò³</title>
    <base href="<%=basePath%>">
    <link type="text/css" rel="stylesheet" href="<%=basePath%>css/style.css">
</head>
<body>
<center>
    <table border="0" cellpadding="0" cellspacing="0" width="688" height="100%">
        <tr height="20">
            <td><img src="<%=basePath%>images/default_t.jpg"></td>
        </tr>
        <tr>
            <td background="<%=basePath%>images/default_m.jpg" valign="top">
                <jsp:include page="<%=mainPage%>"/>
            </td>
        </tr>
        <tr height="26">
            <td><img src="<%=basePath%>images/default_e.jpg"></td>
        </tr>
    </table>
</center>
</body>
</html>