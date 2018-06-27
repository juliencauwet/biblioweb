<%--
  Created by IntelliJ IDEA.
  User: julien
  Date: 14.06.18
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<!-- Liste des ouvrages en fonction des critères recherchés das le formulaire
      avec lien sur le titre qui emmène vers la description du livre -->

<div class="container-fluid">

    <div class="row">
        <div class="col-md-3">
            <s:a action="getAllBooks">Afficher tous les livres</s:a><br />
            <br />
            <s:form class="form" action="findBookByTitle">
                <s:textfield class="form-control" key="title"/>
                <s:submit class="form-control" value="Chercher"/>
            </s:form>


        </div>

        <div class="col-md-9">
            <table class="table">
                <s:iterator value="books">
                    <tr>
                        <td><s:property value="authorFirstName"/></td>
                        <td><s:property value="authorName"/></td>
                        <td><s:property value="title"/></td>
                    </tr>
                </s:iterator>
            </table>
        </div>


</div>
</div>

</body>
</html>