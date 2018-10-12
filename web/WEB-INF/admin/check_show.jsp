<%@ page import="com.wei.cityinfo.util.DateUtils" %>
<%@ page import="com.wei.cityinfo.model.Info" %>
<%@ page import="com.wei.cityinfo.model.Type" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    Info info = (Info) request.getAttribute("info");
    List<Type> typeList = (List<Type>) session.getAttribute("typeList");
    String result = (String) request.getAttribute("result");
%>
<html>
<head>
    <title>后台-付费设置</title>
    <base href="<%=basePath%>">
</head>
<body>
<center>
    <br>
    <%
        if (info == null && result == null) {
            out.print("没有找到相关信息");
            return;
        } else if (result != null) {
            out.print(result);
            return;
        }
    %>
    <form action="<%=basePath%>admin/check" method="post">
        <input type="hidden" name="id" value="${requestScope.info.id}">
        <input type="hidden" name="action" value="setMoney">
        <table border="0" width="645" cellpadding="10" cellspacing="0" style="word-break:break-all">
            <tr height="30">
                <td style="text-indent:5px"><b>审核设置 [ID值：${requestScope.info.id}]</b></td>
            </tr>
            <tr height="30" bgcolor="#F9F9F9">
                <td colspan="3" align="center" style="text-indent:5px">信息详细内容</td>
            </tr>
            <tr height="30">
                <td width="25%" style="text-indent:10px">信息类别：</td>
                <td>【<%=typeList.get(info.getType() - 1).getTypeIntro()%>】</td>
                <td>付费状态：&nbsp;&nbsp;${requestScope.info.payfor==1?"★ 已付费":"● 未付费"}</td>
            </tr>
            <tr height="30">
                <td style="text-indent:10px">发布时间：</td>
                <td><%=DateUtils.dateToString(info.getDate())%>
                </td>
                <td>审核状态：&nbsp;&nbsp;${requestScope.info.state==1?"★ 已审核":"● 未审核"}</td>
            </tr>
            <tr height="30">
                <td style="text-indent:10px">信息标题：</td>
                <td colspan="2">${requestScope.info.title}</td>
            </tr>
            <tr height="40" bgcolor="#F9F9F9">
                <td style="text-indent:10px">信息内容：</td>
                <td align="right">
                    <%
                        if (info.getState().equals("1")) {
                    %>
                    <input type="submit" value="√设为审核" disabled="false">
                    <%
                    } else {
                    %>
                    <input type="submit" value="√设为审核" onclick="confirm('确定审核通过吗?')">
                    <%
                        }
                    %>
                </td>
            </tr>
            <tr height="5">
                <td></td>
            </tr>
            <tr>
                <td colspan="3" style="border:1px solid">
                    <table border="0" width="630" cellspacing="0" cellpadding="10" style="word-break:break-all">
                        <tr height="130">
                            <td colspan="3" valign="top"><textarea type="text" rows="12" cols="85"
                                                                   disabled="false">${requestScope.info.content}</textarea>
                            </td>
                        </tr>
                        <tr height="30" align="center">
                            <td>联系电话：${requestScope.info.phone}</td>
                            <td>联系人：${requestScope.info.linkman}</td>
                            <td>E-mial：${requestScope.info.email}</td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>