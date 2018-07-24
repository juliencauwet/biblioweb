<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: julien
  Date: 18.07.18
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Emprunt n° <s:property value="id" /> </title>

</head>
<body>
<s:a action="extendThisBorrowing">Prolongez cet emprunt</s:a>
<s:property value="message" />
</body>
</html>
