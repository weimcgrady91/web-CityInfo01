<%@ page import="com.wei.cityinfo.model.Type" %>
<%@ page import="java.util.List" %>
<%@ page import="com.wei.cityinfo.model.Info" %>
<%@ page import="com.wei.cityinfo.util.DateUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    List<Type> typeList = (List<Type>) session.getAttribute("typeList");
    String result = (String) request.getAttribute("result");
    String checkMsg = (String) request.getAttribute("checkMsg");
    List<Info> infoList = (List<Info>) request.getAttribute("infoList");
    String pageIndicator = (String) request.getAttribute("pageIndicator");
%>
<html>
<head>
    <title>后台-查看信息列表</title>
    <script type="text/javascript">
        function deleteInfo(msg) {
            if (confirm(msg)) {
                document.forms[0].action = '<%=basePath%>admin/delete';
                document.forms[0].submit();
            }
        }
    </script>
</head>
<body>
<center>
    <table border="0" width="650" cellspacing="0" cellpadding="0">
        <%
            if (checkMsg != null) {
        %>
        <tr height="1">
            <td></td>
        </tr>
        <tr height="200" bgcolor="#F9F9F9">
            <td colspan="8" align="center" style="border:1px solid"><font color="red"><b>★★<%=checkMsg%>★★</b></font>
            </td>
        </tr>
        <%
                return;
            }
        %>

        <%
            if (result != null) {
        %>
        <tr height="1">
            <td></td>
        </tr>
        <tr height="200" bgcolor="#F9F9F9">
            <td colspan="8" align="center" style="border:1px solid"><font color="red"><b>★★<%=result%>★★</b></font>
            </td>
        </tr>
        <%
                return;
            }
        %>

        <%
            if (infoList == null || infoList.size() == 0) {
        %>
        <tr height="1">
            <td></td>
        </tr>
        <tr height="200" bgcolor="#F9F9F9">
            <td colspan="8" align="center" style="border:1px solid"><font color="red"><b>★★对不起，未找到符合条件的信息！★★</b></font>
            </td>
        </tr>

        <%
                return;
            }
        %>

        <tr height="30">
            <td style="text-indent:8px">审核[]</td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td colspan="2" align="center" style="border:1px solid">
                <table border="0" width="100%" cellspacing="0" cellpadding="0">
                    <tr align="center" height="30" bgcolor="#F0F0F0">
                        <td width="7%"><b>序号</b></td>
                        <td width="8%"><b>信息ID</b></td>
                        <td width="35%"><b>信息标题</b></td>
                        <td width="20%"><b>发布时间</b></td>
                        <td width="8%"><b>付费</b></td>
                        <td width="8%"><b>审核</b></td>
                        <td width="14%" colspan="2"><b>操作</b></td>
                    </tr>
                    <%
                        for(int i=0;i<infoList.size();i++) {
                            if(i%2==0){ %>
                             <tr height="30">
                            <% } else { %>
                             <tr height="30" bgcolor="#F9F9F9">
                            <% } %>
                    <td align="center"><b></b></td>
                    <td style="text-indent:10px"><%=infoList.get(i).getId()%></td>
                    <td style="text-indent:5px">
                        <a href="#"><%=infoList.get(i).getTitle()%></a></td>
                    <td align="center"><%=DateUtils.dateToString(infoList.get(i).getDate())%></td>
                    <td align="center">
                        <%
                            if(infoList.get(i).getPayfor().equals("1")) {
                                %>是<%
                            } else {
                                %>否<%
                            }

                        %>
                    </td>
                    <td align="center">
                        <%
                            if(infoList.get(i).getState().equals("1")) {
                                %>是<%
                            } else {
                            %>否<%
                        }
                        %>
                    </td>
                    <td align="center"><a href="<%=basePath%>admin/check?id=<%=infoList.get(i).getId()%>">√审核</a></td>
                    <td align="center"><a href="<%=basePath%>admin/delete?id=<%=infoList.get(i).getId()%>" onclick="deleteInfo('确认删除吗?')">×删除</a></td>
                </tr>
                    <%
                        }
                    %>
                </table>
            </td>
        </tr>
        <tr height="8">
            <td></td>
        </tr>
        <tr>
            <td align="center" colspan="2">
               <%=pageIndicator%>
            </td>
        </tr>
    </table>
</center>
</body>
</html>