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
    <title>����</title>
</head>
<body>
<center>
    <table border="0" width="225" height="100%" cellspacing="0" cellpadding="0">
        <tr height="30">
            <td style="text-indent:5px" valign="bottom"><font color="#004790"><b>������</b></font></td>
        </tr>
        <tr height="215">
            <td valign="top" background="<%=basePath%>images/leftD.jpg">
                <jsp:include page="../../calendar.jsp"/>
            </td>
        </tr>
        <tr height="30">
            <td style="text-indent:5px" valign="bottom"><font color="#004790"><b>����Ϣ��������</b></font></td>
        </tr>
        <tr height="103">
            <td align="center" valign="top" background="<%=basePath%>images/leftS.jpg">
                <form action="<%=basePath%>search" method="post">
                    <table border="0" width="99%" height="100%" cellspacing="0">
                        <tr height="10">
                            <td colspan="3"></td>
                        </tr>
                        <tr>
                            <td align="right" width="70">�ؼ��֣�</td>
                            <td colspan="2" width="200">
                                <input type="text" name="searchKey" size="21"/>
                            </td>
                        </tr>
                        <tr>
                            <td align="right">��&nbsp;&nbsp;����</td>
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
                                <input type="submit" value="����">
                            </td>
                        </tr>
                        <tr>
                            <td align="right">�������ͣ�</td>
                            <td colspan="2">
                                <input type="radio" name="accurate" value="true">ȫ��ƥ��<input type="radio" name="accurate"
                                                                                            value="false" checked>ģ������
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