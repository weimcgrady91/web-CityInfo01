<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>城市供求信息网</title>
    <script type="text/javascript">
      function del(msg) {
          confirm("aaaaa");
          alert(msg);
          document.forms[0].action='ccc/admin/delete';
          document.forms[0].submit();
      }
    </script>
  </head>
  <body>
  城市供求信息网
  <form action="#">
    <input type="button" onclick="del('aa')" value='提交'>
  </form>
  </body>
</html>
