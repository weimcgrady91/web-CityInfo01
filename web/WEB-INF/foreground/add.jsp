<%@ page import="com.wei.cityinfo.model.Type" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    List<Type> typeList = (List<Type>) session.getAttribute("typeList");
%>
<html>
<head>
    <title>发布信息</title>
    <script type="text/javascript" src="<%=basePath%>js/InputCheck.js"></script>
</head>
<body>
<center>
    <table border="0" cellpadding="0" cellspacing="0" width="688" height="100%">
        <tr height="20">
            <td><img src="<%=basePath%>images/default_t.jpg"></td>
        </tr>
        <tr>
            <td background="<%=basePath%>images/default_m.jpg" valign="top" align="center">
                <form action="<%=basePath%>add" method="post">
                    <table border="0" width="650" height="300" rules="all" cellspacing="0">
                        <tr height="30">
                            <td style="text-indent:10px"><font color="#004790"><b>■发布信息</b></font></td>
                        </tr>
                        <tr>
                            <td align="center">
                                <table border="0" width="650" rules="all" cellspacing="8">
                                    <tr>
                                        <td width="20%" style="text-indent:10px">信息类别：</td>
                                        <td>
                                            <select name="typeSign">
                                                <%
                                                    for (Type type : typeList) {
                                                %>
                                                <option value="<%=type.getTypeSign()%>"><%=type.getTypeIntro()%>
                                                </option>
                                                <%
                                                    }
                                                %>
                                            </select>
                                        </td>
                                        <td align="right"><font color="#7F7F7F">[信息标题最多不得超过 40 个字符]&nbsp;&nbsp;</font>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="3"><s2:fielderror><s2:param
                                                value="%{'typeError'}"/></s2:fielderror></td>
                                    </tr>
                                    <tr>
                                        <td style="text-indent:10px">信息标题：</td>
                                        <td colspan="2">
                                            <input type="text" name="title" maxlength="40">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="3"><s2:fielderror><s2:param
                                                value="%{'titleError'}"/></s2:fielderror></td>
                                    </tr>
                                    <tr>
                                        <td style="text-indent:10px">信息内容：</td>
                                        <td>
                                            <font color="#7F7F7F">
                                                已用：<input type="text" name="ContentUse" value="0" size="4" disabled
                                                          style="text-align:center;border:0;"> 个&nbsp;&nbsp;
                                                剩余：<input type="text" name="ContentRem" value="500" size="4" disabled
                                                          style="text-align:center;border:0;"> 个
                                            </font>
                                        </td>
                                        <td align="right"><font color="#7F7F7F">[信息内容最多不得超过 500 个字符]&nbsp;&nbsp;</font>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="3"><s2:fielderror><s2:param
                                                value="%{'contentError'}"/></s2:fielderror></td>
                                    </tr>
                                    <tr>
                                        <td colspan="3" align="center">
                                            <textarea id="content" name="content" rows="12" cols="85"
                                                      onkeydown="check(content,ContentUse,ContentRem,500)"
                                                      onkeyup="check(content,ContentUse,ContentRem,500)"
                                                      onchange="check(content,ContentUse,ContentRem,500)"></textarea>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="text-indent:10px">联系电话：</td>
                                        <td colspan="2">
                                            <input type="text" name="phone" size="45">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="3"><s2:fielderror><s2:param
                                                value="%{'phoneError'}"/></s2:fielderror></td>
                                    </tr>
                                    <tr>
                                        <td style="text-indent:10px">联 系 人：</td>
                                        <td colspan="2">
                                            <input type="text" name="linkman" size="50">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="3"><s2:fielderror><s2:param
                                                value="%{'linkmanError'}"/></s2:fielderror></td>
                                    </tr>
                                    <tr>
                                        <td style="text-indent:10px">E - mail：</td>
                                        <td colspan="2">
                                            <input type="text" name="email" size="55">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="3"><s2:fielderror><s2:param
                                                value="%{'emailError'}"/></s2:fielderror></td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <tr align="center" height="50">
                            <td>
                                <input type="submit" value="发布">
                                <input type="reset" value="重置">
                            </td>
                        </tr>
                    </table>
                </form>
            </td>
        </tr>
        <tr height="26">
            <td><img src="<%=basePath%>images/default_e.jpg"></td>
        </tr>
    </table>
</center>
</body>
</html>
