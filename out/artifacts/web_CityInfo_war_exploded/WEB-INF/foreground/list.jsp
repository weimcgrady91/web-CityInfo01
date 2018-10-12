<%@ page import="com.wei.cityinfo.model.Info" %>
<%@ page import="com.wei.cityinfo.util.DateUtils" %>
<%@ page import="java.util.List" %>
<%@ page import="com.wei.cityinfo.model.Type" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Info> infoList = (List<Info>) request.getAttribute("infoList");
    Type type = (Type) request.getAttribute("infoType");
    List<Type> typeList = (List<Type>) session.getAttribute("typeList");
    String pageIndicator = (String) request.getAttribute("pageIndicator");
%>
<html>
<head><title>查看信息列表</title></head>
<body>
<center>
    <table border="0" width="670" cellspacing="0" cellpadding="0" style="margin-top:5px" rules="rows">
        <%
            if (type != null) {
        %>
        <tr height="30">
            <td style="text-indent:5px" valign="bottom">
                <font color="#004790"><b>■最新<%=type.getTypeIntro()%>
                </b>『免费专区』</font>
            </td>
        </tr>
        <%
            }
        %>
        <%
            if(infoList==null){
                return;
            }
            for (int i = 0; i < infoList.size(); i++) {
        %>
        <tr>
            <td align="center" style="border:1px solid" bgcolor="#F0F0F0">
                <table border="0" width="655" cellpadding="3" style="word-break:break-all">
                    <tr height="30">
                        <td colspan="2">【<%=typeList.get(infoList.get(i).getType() - 1).getTypeIntro()%>】</td>
                        <td align="right">发布时间：『<%=DateUtils.dateToString(infoList.get(i).getDate())%>』&nbsp;</td>
                    </tr>
                    <tr height="80">
                        <td colspan="3"><%=infoList.get(i).getContent()%>
                        </td>
                    </tr>
                    <tr height="30" align="center">
                        <td>联系电话：<%=infoList.get(i).getPhone()%>
                        </td>
                        <td>联系人：<%=infoList.get(i).getLinkman()%>
                        </td>
                        <td>E-mail：<%=infoList.get(i).getEmail()%>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <%
            }
        %>


        <tr height="1">
            <td></td>
        </tr>

        <tr height="30">
            <td align="center">
                <% if (pageIndicator != null)%>
                <%=pageIndicator%>
            </td>
        </tr>
    </table>


    <br>
</center>
</body>
</html>
