<%@ page import="com.wei.cityinfo.model.Info" %>
<%@ page import="com.wei.cityinfo.model.Type" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    List<Map<Type, List<Info>>> hotCharge = (List<Map<Type, List<Info>>>) session.getAttribute("hotCharge");
    List<Map<Type, List<Info>>> hotNormal = (List<Map<Type, List<Info>>>) session.getAttribute("hotNormal");
%>
<html>
<head><title>首页</title></head>
<body>
<center>
    <!-- 缴费专区 -->
    <table border="0" width="670" cellspacing="0" cellpadding="5">
        <tr height="35">
            <td style="text-indent: 5px" valign="bottom"><font color="#004790"><b>■推荐信息</b>『缴费专区』</font></td>
        </tr>
        <tr bgcolor="#FAFCF5">
            <td style="border:1px solid">
                <table border="0" width="100%" cellspacing="0" cellpadding="0">
                    <%
                        if (hotCharge == null && hotCharge.size() == 0) {
                    %>
                    <tr height="30">
                        <td align="center" style="border:1px solid">★★★ 缴费后，您发布信息就可在这里显示！★★★</td>
                    </tr>
                    <tr>
                        <%
                        } else {
                            for (int i = 0; i < hotCharge.size(); i++) {
                                if (i % 2 != 1) {
                        %>
                    </tr>
                    <tr>
                        <%
                            }
                            Iterator<Map.Entry<Type, List<Info>>> iterator = hotCharge.get(i).entrySet().iterator();
                            while (iterator.hasNext()) {
                                Map.Entry<Type, List<Info>> entry = iterator.next();
                        %>
                        <td>
                            『<b><%=entry.getKey().getTypeIntro()%>
                        </b>』
                            <a href="<%=basePath%>infoDetail?id=<%=entry.getValue().get(0).getId()%>"><%=entry.getValue().get(0).getTitle()%>
                            </a>
                        </td>
                        <%
                                    }
                                }
                            }
                        %>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
    <!-- 广告 -->
    <table border="0" width="670" cellspacing="0" cellpadding="0" style="margin-top: 1px">
        <tr>
            <td align="center"><img src="<%=basePath%>images/pcard2.jpg"></td>
        </tr>
    </table>
    <!-- 免费专区 -->
    <table border="0" width="670" cellspacing="2" cellpadding="0">
        <tr height="35">
            <td colspan="2" style="text-indent: 5px" valign="bottom"><font color="#004790"><b>■最新信息</b>『免费专区』</font>
            </td>
        </tr>
        <%
            if (hotNormal == null) {
        %>
        <tr height="30">
            <td align="center" style="border: 1px solid">★★★ 在这里显示免费发布的信息！★★★</td>
        </tr>
        <%
        } else {
        %>
            <tr>
        <%
            for (int i = 0; i < hotNormal.size(); i++) {
                if (i % 2 != 1) {
                    %>
                </tr><tr>
                <%
                }
                Iterator<Map.Entry<Type, List<Info>>> iterator = hotNormal.get(i).entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<Type, List<Info>> entry = iterator.next();
        %>
        <td>
            <table border="1" cellspacing="0" cellpadding="0" width="332" height="160" rules="none"
                   bordercolor="lightgrey" bordercolorlight="lightgrey" bordercolordark="white">
                <tr bgcolor="#00B48F" height="30" width="80">
                    <td style="text-indent: 10px"><b><font color="white">▲<%=entry.getKey().getTypeIntro()%>
                    </font></b></td>
                </tr>
                <%
                    for (int j = 0; j < entry.getValue().size(); j++) {
                %>
                <tr bgcolor="#FAFCF5">
                    <td style="text-indent: 3px">
                        ★ <a
                            href="<%=basePath%>infoDetail?id=<%=entry.getValue().get(j).getId()%>"><%=entry.getValue().get(j).getTitle()%>
                    </a>
                    </td>
                </tr>
                <%
                    }
                %>
                <tr height="20" bgcolor="#FAFCF5">
                    <td align="right">
                        <a href="<%=basePath%>infoList?typeSign=<%=entry.getKey().getTypeSign()%>">更多...</a>&nbsp;&nbsp;
                    </td>
                </tr>
            </table>
        </td>
        <%
                    }

                }
            }
        %>
            </tr>
    </table>
    <br>
</center>
</body>
</html>