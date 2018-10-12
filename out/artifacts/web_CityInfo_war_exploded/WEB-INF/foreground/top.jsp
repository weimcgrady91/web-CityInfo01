<%@ page import="com.wei.cityinfo.model.Type" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    List<Type> typeList = (List<Type>) session.getAttribute("typeList");
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>页眉</title>
</head>
<body>
<center>
    <table border="0" width="100%" cellspacing="0" cellpadding="0">
        <!-- 顶部菜单 -->
        <tr height="20">
            <td style="text-indent:10px" valign="bottom">
                <a href="<%=basePath%>add" style="color:gray">[发布信息]</a>
                <a href="<%=basePath%>admin/login" style="color:gray">[进入后台]</a>
            </td>
            <td align="right" valign="bottom">
                <a href="#" style="color:gray"
                   onclick="this.style.behavior='url(#default#homepage)';this.setHomePage('http://localhost:8080/CityInfo');">设为主页
                    -</a>
                <a href="javascript:window.external.AddFavorite('http://localhost:8080/CityInfo','都市供求信息网')"
                   style="color:gray">收藏本页 -</a>
                <a href="mailto:weiqunhz0516@gmail.com" style="color:gray">联系我们</a>
                &nbsp;
            </td>
        </tr>
        <!-- 导航菜单 -->
        <tr height="56">
            <td align="center" width="220" background="<%=basePath%>images/logo.gif"></td>
            <td align="right" background="<%=basePath%>images/menu.gif">
                <%
                    if (typeList == null || typeList.size() == 0) {
                        out.print("没有信息类别可显示！");
                    } else {
                %>
                <table border="0" width="600">
                    <tr align="center">
                        <td width="100">
                            <a href="<%=basePath%>index" style="color:white">首&nbsp;&nbsp;&nbsp;&nbsp;页</a>
                        </td>
                        <%
                            for (int i = 0; i < typeList.size(); i++) {
                                if (i == 5) {
                        %>
                    </tr>
                    <tr align="center">
                            <%
                                }
                                Type type = typeList.get(i);
                        %>
                        <td width="100">
                            <a href="<%=basePath%>infoList?typeSign=<%=type.getTypeSign()%>"
                               style="color:white"><%=type.getTypeIntro()%>
                            </a>
                        </td>
                            <%
                            }
                        %>
                    <tr/>
                </table>
                <%
                    }
                %>
            </td>
        </tr>
    </table>
    <table border="0" width="100%" height="112" cellspacing="0" cellpadding="0" style="margin-top:1px">
        <tr>
            <td align="center"><img src="<%=basePath%>images/pcard1.jpg"></td>
        </tr>
    </table>
</center>
</body>
</html>