
<%--
  Created by IntelliJ IDEA.
  User: julien
  Date: 27.06.18
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Espace Administrateurs</title>
</head>
<body>

<!-- formulaire pour l'ajout d'un livre avec confirmation/ erreur d'enregistrement du livre -->

    <h4>Enregistrement d'un livre</h4>
    <s:form class="form-group" method="post" action="addBook">
        <s:textfield key="authorName" label = "Nom de l'auteur" class="form-control"/>
        <s:textfield key="authorFirstName" label = "Prénom de l'auteur" class="form-control"/>
        <s:textfield key="title" label = "Titre du livre" class="form-control"/>
        <s:textfield key="number" class="Nombre" />
        <s:submit class="form-control" />
    </s:form >

<hr />
<!-- lien vers les configurations de l'appli uniquement visible par les admin -->

<s:a action="configuration">Configuration</s:a>

<hr />

<!-- lien visible uniquement pour les admins pour savoir les livres avec les retards (booklist.jsp) -->



<!-- formulaire pour rechercher un utilisateur uniquement visible par les admins (userlist.jsp)-->

<s:form class="form-group" action="helloWorld">
    <s:textfield class="form-control" label="What is your name?" name="name" />
    <s:textfield class="form-control" label="What is the date?" name="dateNow" />
    <br />
    <s:submit class="form-control"/>
</s:form>

</body>
</html>
