<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	
<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>Index</title>
	<s:head />
</head>
<body>
    <header>
    <!--lien vers authentification (auth.jsp)-->
        <s:a action="authentification">Authentification</s:a>
    </header>

    <hr />
    <!-- lien vers les configurations de l'appli uniquement visible par les admin -->

    <s:a action="configuration">Configuration</s:a>

    <hr />
    <br />
	<!-- formulaire pour la recherche de livre par titre ou auteur
	     avec bouton qui mène vers une page qui liste les ouvrages possibles (booklist.jsp)-->


    <s:form class="form-group" action="findBookByTitle" method="post">
        <s:textfield class="form-control" name="title" key="title" label="Titre de l'ouvrage" />
        <s:submit class="form-control" />
    </s:form>



    <!-- formulaire visible uniquement pour les admins pour savoir les livres avec les retards (booklist.jsp) -->

    <!-- formulaire pour rechercher un utilisateur uniquement visible par les admins (userlist.jsp)-->

	<s:form action="helloWorld">
		<s:textfield label="What is your name?" name="name" />
		<s:textfield label="What is the date?" name="dateNow" />
		<s:submit />
	</s:form>

</body>
</html>
	