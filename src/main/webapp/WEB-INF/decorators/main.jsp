<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title><decorator:title default="Struts Starter"/></title>
    <link href="<s:url value='/styles/main.css'/>" rel="stylesheet" type="text/css" media="all"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link href="<s:url value='/styles/main.css'/>" rel="stylesheet" type="text/css" media="all"/>

    <script language="JavaScript" type="text/javascript" src="<s:url value='/struts/niftycorners/nifty.js'/>"></script>
	<script language="JavaScript" type="text/javascript">
        window.onload = function(){
            if(!NiftyCheck()) {
                return;
            }
            // perform niftycorners rounding
            // eg.
            // Rounded("blockquote","tr bl","#ECF1F9","#CDFFAA","smooth border #88D84F");
        }
    </script>
    <decorator:head/>
</head>

<header>
    <h3>Hello <s:property value="#session['user'].email" /> </h3>
    <s:a action="logout">Déconnexion</s:a>

</header>
<body id="page-home">
<div class="container-fluid">
    <div id="page">
        <div id="header" class="clearfix">
            <h4>Bienvenue sur Biblioweb : Gestion de votre bibliothèque à distance!</h4>
            <hr />
        </div>
        
        <div id="content" class="clearfix">
            <div id="main">
            	<decorator:body/>
                <hr />
            </div>
            
            <div id="admins">

                <ul>
                    <li><s:a action="index">Page d'accueil</s:a></li>
                    <li><s:a action="book">Livres</s:a></li>
                    <li><s:a action="getAllAppUsers">Utilisateurs</s:a></li>
                    <li><s:a action="admin">Administrateurs</s:a></li>
                    <li><s:a action="configuration">Configuration</s:a></li>
                    <li><s:a action="currentBorrowings">Emprunts</s:a></li>
                </ul>
            </div>

        </div>
        
        <div id="footer" class="clearfix">

        </div>
        
    </div>
    
    <div id="extra1">&nbsp;</div>
    <div id="extra2">&nbsp;</div>
</div>
</body>
</html>
