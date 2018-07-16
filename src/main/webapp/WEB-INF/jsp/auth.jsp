<%--
  Created by IntelliJ IDEA.
  User: julien
  Date: 27.06.18
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="html" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authentification</title>
</head>
<body>
<s:fielderror name="invalid"/>
<s:form class="form-group" action="login" method="post">

    <table width="400" border="1 floralwhite solid" align="center"
           cellpadding="0" cellspacing="0">
        <tr>
            <td>
                <table border="0" cellspacing="2"
                       cellpadding="1" width="100%">
                    <tr bgcolor="#eaeac8">
                        <td align="left" colspan="2">Authentification utilisateur</td>
                    </tr>

                    <tr>
                        <td colspan="2"><p>&nbsp;</p></td>
                    </tr>

                    <tr align="center">
                        <td><s:textfield class="form-control" key="email" label="Email utilisateur" required="true"/></td>
                    </tr>

                    <tr align="center">
                        <td><s:password class="form-control" key="password" label="Mot de Passe" required="true"/></td>
                    </tr>
<!--
                    <tr align="center">
                        <td align="right">Login As:</td>
                        <td>
                            <s:select list="actionErrors" class="form-control" property="usertype">
                                <option>---------------Login As---------------</option>
                                <option value="Buyer">Buyer</option>
                                <option value="Seller">Seller</option>
                                <option value="Guest">Guest</option>
                            </s:select>
                        </td>
                    </tr>
-->
                    <tr>
                        <td colspan="2"><p>&nbsp;</p></td>
                    </tr>

                    <tr>
                        <td align="center" colspan="2"><s:submit class="form-control" value="Identifiez-vous!"/> </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</s:form>

</body>
</html>
