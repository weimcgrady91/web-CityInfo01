<%@ page import="com.wei.cityinfo.model.Info" %>
<%@ page import="com.wei.cityinfo.model.Type" %>
<%@ page import="java.util.List" %>
<%@ page import="com.wei.cityinfo.util.DateUtils" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    List<Type> typeList = (List<Type>) session.getAttribute("typeList");
    Info info = (Info) request.getAttribute("infoDetail");
%>
<html>
<head>
    <title>都市信息网-查看详细内容</title>
    <base href="<%=basePath%>">
    <link type="text/css" rel="stylesheet" href="../../css/style.css">
</head>
<body>
<center>
    <table width="670" border="0" cellspacing="0" cellpadding="0" style="margin-top:5px">
        <tr height="30">
            <td style="text-indent:5px" valign="bottom"><font color="#004790"><b>■查看详细信息</b></font></td>
        </tr>
        <tr height="1">
            <td></td>
        </tr>
        <tr bgcolor="#FAFCF5">
            <td style="border:1px solid">
                <table border="0" width="100%" cellspacing="0" cellpadding="2">
                    <% if (info == null) { %>
                    <tr height="100">
                        <td align="center" colspan="2" style="border:1px solid">★★★ 查看信息详细内容出错！★★★</td>
                    </tr>
                    <% } else { %>
                    <tr height="40">
                        <td width="20%" style="text-indent:20px">信息类别：</td>
                        <td><%=typeList.get(info.getType() - 1).getTypeIntro()%>
                        </td>
                    </tr>
                    <tr height="40">
                        <td style="text-indent:20px">发布时间：</td>
                        <td><%=DateUtils.dateToString(info.getDate())%>
                        </td>
                    </tr>
                    <tr height="40">
                        <td style="text-indent:20px">信息标题：</td>
                        <td><%=info.getTitle()%>
                        </td>
                    </tr>
                    <tr height="40">
                        <td colspan="2" style="text-indent:20px">信息内容：</td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <table border="1" width="630" cellspacing="0" cellpadding="10" rules="none"
                                   frame="below" style="word-break:break-all" bordercolor="lightgrey"
                                   bordercolorlight="lightgrey" bordercolordark="white">
                                <tr height="200" bgcolor="white">
                                    <td colspan="3" valign="top" style="border:1px solid"><%=info.getContent()%>
                                    </td>
                                </tr>
                                <tr height="20" align="center">
                                    <td>联系电话：<%=info.getPhone()%>
                                    </td>
                                    <td>联系人：<%=info.getLinkman()%>
                                    </td>
                                    <td>E-mial：<%=info.getEmail()%>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr height="63">
                        <td align="center" colspan="2"><a href="javascript:window.history.back(-1)">返回</a></td>
                    </tr>
                    <% }%>
                </table>
            </td>
        </tr>
    </table>
    <br>
</center>
</body>
</html>
