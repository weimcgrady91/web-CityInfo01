<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String mainPage = (String) request.getAttribute("mainPage");
    if (mainPage == null || mainPage.equals("")) {
        mainPage = "index_default.jsp";
    }
%>

<html>
<head>
    <title>都市信息网</title>
    <base href="<%=basePath%>">
    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body background="images/back.gif">
<center>
    <table border="0" width="920" cellspacing="0" cellpadding="0" bgcolor="white">
        <tr>
            <td colspan="2">
                <jsp:include page="index_top.jsp"/>
            </td>
        </tr>
        <tr>
            <td width="230" valign="top" align="center">
                <jsp:include page="index_left.jsp"/>
            </td>
            <td width="690" height="800" align="center" valign="top" bgcolor="#FFFFFF">
                <jsp:include page="<%=mainPage%>"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <%@ include file="end.jsp" %>
            </td>
        </tr>
    </table>
</center>
</body>
</html>