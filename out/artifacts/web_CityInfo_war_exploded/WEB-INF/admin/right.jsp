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
    checkState.put("1", "�����");
    checkState.put("0", "δ���");
    checkState.put("all", "ȫ��");
    Map payforState = new TreeMap();
    payforState.put("1", "�Ѹ���");
    payforState.put("0", "δ����");
    payforState.put("all", "ȫ��");
    request.setAttribute("checkState", checkState);
    request.setAttribute("payforState", payforState);
%>
<html>
<head><title>��̨-����</title></head>
<body background="<%=basePath%>images/back.gif">
<center>
    <table border="0" width="220" height="100%" cellspacing="0" cellpadding="0" style="margin-top:7px">
        <!-- ��ʾ��ʽ -->
        <tr height="30" bgcolor="#F0F0F0">
            <td style="text-indent:5px;border:1px solid"><font color="#004790"><b>����ʾ��ʽ</b></font></td>
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
                                    <legend>�︶��״̬</legend>
                                    <br>
                                    <input type="radio" name="charge" value="1">${requestScope.payforState["1"]}
                                    <input type="radio" name="charge" value="0">${requestScope.payforState["0"]}
                                    <%--<input type="radio" name="charge" value="all">${requestScope.checkState["all"]}--%>
                                </fieldset>
                                <fieldset style="height:60px;width:210px">
                                    <legend>�����״̬</legend>
                                    <br>
                                    <input type="radio" name="state" value="1">${requestScope.checkState["1"]}
                                    <input type="radio" name="state" value="0">${requestScope.checkState["0"]}
                                    <%--<input type="radio" name="state" value="all">${requestScope.checkState["all"]}--%>
                                </fieldset>
                            </td>
                        </tr>
                        <tr align="center" height="30" bgcolor="lightgrey">
                            <td>
                                ��Ϣ���
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
                                <input type="submit" value="��ʾ">
                            </td>
                        </tr>

                    </table>
                </td>
            </tr>
        </form>
        <tr height="5">
            <td></td>
        </tr>
        <!-- �����Ѹ�����Ϣ -->
        <tr height="30" bgcolor="#F0F0F0">
            <td style="text-indent:5px" style="border:1px solid"><font color="#004790"><b>����������</b></font></td>
        </tr>
        <tr height="1">
            <td></td>
        </tr>
        <form action="<%=basePath%>admin/setMoney" method="post">
            <tr>
                <td align="center" valign="top" style="border:1px solid">
                    <table border="0" width="220" height="80" cellspacing="0" rules="none">
                        <tr height="25">
                            <td align="center" valign="bottom">������Ҫ��Ϊ�Ѹ���״̬����ϢID��</td>
                        </tr>
                        <tr height="40">
                            <td align="center">
                                <input type="text" name="id" size="24"/>
                                <input type="submit" value="��ѯ"/>
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
            <td style="text-indent:5px;border:1px solid"><font color="#004790"><b>������</b></font></td>
        </tr>
        <tr height="1">
            <td></td>
        </tr>
        <!-- ���� -->
        <tr height="130">
            <td valign="top" style="border:1px solid">
                <jsp:include page="../../calendar.jsp"/>
            </td>
        </tr>
    </table>
</center>
</body>
</html>