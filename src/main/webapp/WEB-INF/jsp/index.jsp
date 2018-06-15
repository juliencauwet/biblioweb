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
	<s:form action="helloWorld">
		<s:textfield label="What is your name?" name="name" />
		<s:textfield label="What is the date?" name="dateNow" />
		<s:submit />
	</s:form>

    <table class="table">
        <s:iterator value="books">
            <tr>
                <td><s:property value="authorFirstName"/></td>
                <td><s:property value="authorName"/></td>
                <td><s:property value="title"/></td>
            </tr>
        </s:iterator>
    </table>


</body>
</html>
	