<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="com.wei.cityinfo.model.Condition" %>
<%@ page import="java.util.List" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    List<Condition> conditions = (List<Condition>) session.getAttribute("searchConditions");
%>
<html>
<head>
    <title>侧栏</title>
</head>
<body>
<center>
    <table border="0" width="225" height="100%" cellspacing="0" cellpadding="0">
        <tr height="30">
            <td style="text-indent:5px" valign="bottom"><font color="#004790"><b>■日历</b></font></td>
        </tr>
        <tr height="215">
            <td valign="top" background="<%=basePath%>images/leftD.jpg">
                <jsp:include page="../../calendar.jsp"/>
            </td>
        </tr>
        <tr height="30">
            <td style="text-indent:5px" valign="bottom"><font color="#004790"><b>■信息快速搜索</b></font></td>
        </tr>
        <tr height="103">
            <td align="center" valign="top" background="<%=basePath%>images/leftS.jpg">
                <form action="<%=basePath%>search" method="post">
                    <table border="0" width="99%" height="100%" cellspacing="0">
                        <tr height="10">
                            <td colspan="3"></td>
                        </tr>
                        <tr>
                            <td align="right" width="70">关键字：</td>
                            <td colspan="2" width="200">
                                <input type="text" name="searchKey" size="21"/>
                            </td>
                        </tr>
                        <tr>
                            <td align="right">条&nbsp;&nbsp;件：</td>
                            <td>
                                <select name="condition">
                                    <%
                                        for (Condition condition : conditions) {
                                    %>
                                    <option value="<%=condition.getName()%>"><%=condition.getDes()%>
                                    </option>
                                    <%
                                        }
                                    %>
                                </select
                            </td>
                            <td>
                                <input type="submit" value="搜索">
                            </td>
                        </tr>
                        <tr>
                            <td align="right">搜索类型：</td>
                            <td colspan="2">
                                <input type="radio" name="accurate" value="true">全字匹配<input type="radio" name="accurate"
                                                                                            value="false" checked>模糊搜索
                            </td>
                        </tr>
                        <tr height="10">
                            <td colspan="3"></td>
                        </tr>

                    </table>
                </form>
            </td>
        </tr>
    </table>
</center>
</body>
</html>