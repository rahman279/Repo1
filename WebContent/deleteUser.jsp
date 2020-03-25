<html>
<body bgcolor = "orange">

<form method = "post">

enter user to be deleted : <input type = "text" name = "user">&nbsp&nbsp
<input type = "hidden" name = "option" value = "delete">
<input type = "submit" value = "deleteUser" formaction = "AddOrDeleteAction.jsp"><br/><br/>
<input type = "button" value = "Go Back" onclick = "goBack()">


</form>

<script>

function goBack(){
	history.back();
}

</script>

</body>
</html>