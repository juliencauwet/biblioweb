<%--
  Created by IntelliJ IDEA.
  User: julien
  Date: 27.06.18
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title><s:property value="book.title"/></title>
</head>
<body>

<!--description du livre + nombre d'exemplaires disponible -->

<p><s:property value="book.title" /> de <s:property value="book.authorFirstName" />   <s:property value="book.authorName" /></p>

<!-- formulaire d'emprunt -->

<s:form class="form-group" action="borrowThisBook" method="post">
    <s:label>Empruntez <s:property value="book.title"/> id n°<s:property value="book.id"/> </s:label>
    <s:hidden name="bookId" value="%{book.id}"/>

    <input class="form-control" type="date" name="startDate" value="Date de départ">
    <s:submit class="form-control" value="Emprunter" />
</s:form>

<!-- message visible après requête pour savoir si la réservation a bien été effectuée ou si ce n'est pas possible-->
    <s:property value="message"/>
<!-- lien visible uniquement pour les admins pour connaitre la liste des utilisateurs qui l'ont emprunté -->

</body>
</html>
