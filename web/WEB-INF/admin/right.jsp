<%@ page language="java" contentType="text/html; charset=GBK" %>
<%@ page import="java.util.Map,java.util.TreeMap" %>
<%@ page import="com.wei.cityinfo.model.Type" %>
<%@ page import="java.util.List" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    List<Type> typeList = (List<Type>) session.getAttribute("typeList");
%>
<%
    Map checkState = new TreeMap();
    checkState.put("1", "已审核");
    checkState.put("0", "未审核");
    checkState.put("all", "全部");
    Map payforState = new TreeMap();
    payforState.put("1", "已付费");
    payforState.put("0", "未付费");
    payforState.put("all", "全部");
    request.setAttribute("checkState", checkState);
    request.setAttribute("payforState", payforState);
%>
<html>
<head><title>后台-侧栏</title></head>
<body background="<%=basePath%>images/back.gif">
<center>
    <table border="0" width="220" height="100%" cellspacing="0" cellpadding="0" style="margin-top:7px">
        <!-- 显示方式 -->
        <tr height="30" bgcolor="#F0F0F0">
            <td style="text-indent:5px;border:1px solid"><font color="#004790"><b>■显示方式</b></font></td>
        </tr>
        <tr height="1">
            <td></td>
        </tr>
        <form action="<%=basePath%>admin/list" method="post">
            <tr>
                <td align="center" valign="top" style="border:1px solid">
                    <table border="0" width="220" height="150" rules="all" cellspacing="0">
                        <tr>
                            <td align="center" colspan="2">
                                <fieldset style="height: 60px;width: 210px">
                                    <legend>★付费状态</legend>
                                    <br>
                                    <input type="radio" name="charge" value="1">${requestScope.payforState["1"]}
                                    <input type="radio" name="charge" value="0">${requestScope.payforState["0"]}
                                    <%--<input type="radio" name="charge" value="all">${requestScope.checkState["all"]}--%>
                                </fieldset>
                                <fieldset style="height:60px;width:210px">
                                    <legend>★审核状态</legend>
                                    <br>
                                    <input type="radio" name="state" value="1">${requestScope.checkState["1"]}
                                    <input type="radio" name="state" value="0">${requestScope.checkState["0"]}
                                    <%--<input type="radio" name="state" value="all">${requestScope.checkState["all"]}--%>
                                </fieldset>
                            </td>
                        </tr>
                        <tr align="center" height="30" bgcolor="lightgrey">
                            <td>
                                信息类别：
                                <%
                                    if (typeList != null) {
                                %>
                                <select name="typeSign">
                                    <%
                                        for (int i = 0; i < typeList.size(); i++) {
                                    %>
                                    <option value="<%=typeList.get(i).getTypeSign()%>"><%=typeList.get(i).getTypeIntro()%>
                                    </option>
                                    <%
                                            }
                                        }
                                    %>
                                </select>
                                <input type="submit" value="显示">
                            </td>
                        </tr>

                    </table>
                </td>
            </tr>
        </form>
        <tr height="5">
            <td></td>
        </tr>
        <!-- 设置已付费信息 -->
        <tr height="30" bgcolor="#F0F0F0">
            <td style="text-indent:5px" style="border:1px solid"><font color="#004790"><b>■付费设置</b></font></td>
        </tr>
        <tr height="1">
            <td></td>
        </tr>
        <form action="<%=basePath%>admin/setMoney" method="post">
            <tr>
                <td align="center" valign="top" style="border:1px solid">
                    <table border="0" width="220" height="80" cellspacing="0" rules="none">
                        <tr height="25">
                            <td align="center" valign="bottom">请输入要设为已付费状态的信息ID：</td>
                        </tr>
                        <tr height="40">
                            <td align="center">
                                <input type="text" name="id" size="24"/>
                                <input type="submit" value="查询"/>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </form>
        <tr height="5">
            <td></td>
        </tr>
        <tr height="30" bgcolor="#F0F0F0">
            <td style="text-indent:5px;border:1px solid"><font color="#004790"><b>■日历</b></font></td>
        </tr>
        <tr height="1">
            <td></td>
        </tr>
        <!-- 日历 -->
        <tr height="130">
            <td valign="top" style="border:1px solid">
                <jsp:include page="../../calendar.jsp"/>
            </td>
        </tr>
    </table>
</center>
</body>
</html>