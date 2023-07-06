<%@page import="java.util.List"%>
<%@page import="edu.videojuego.pojo.Personaje"%>
<!doctype html>
<html lang="en" data-bs-theme="dark">
	<head>
		<%@include file="head.jsp" %>	
		<title>Listado</title>
	</head>
	
	<body>
		<!-- ACA VA EL NAVBAR  -->
		<%@include file="navbar.jsp" %> 
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
		<main>
			<div class="container">
				<section class="border rounded-3 bg-danger p-3">
					<h1 class="border rounded-3 text-center p-2">PERSONAJES</h1>
					<div class="bg-primary" id="mensajes"></div>
					<table class="table border rounded-3 p-2">
					  <thead>
					    <tr>
					      <th scope="col">ID</th>
					      <th scope="col">NOMBRE</th>
					      <th scope="col">EDAD</th>
					      <th scope="col">CLASE</th>
                          <th scope="col">PICK RATE</th>
					      <th scope="col">&nbsp;</th>
					    </tr>
					  </thead>
					  <% 
					  	//codigo java
					  	//obtener el listado desde el request
					  	//se guardo bajo el nombre de "listado"
					  	List<Personaje> listado = (List<Personaje>)request.getAttribute("listado");
					  %>
					  <tbody>
					   <!-- ESTO SE REPITE TANTA CANDTIDAD DE VECES COMO ARTICULOS TENGA -->
					   <%
					   	for(Personaje unPersonaje : listado) {
					   %>
					    <tr>
					      <th scope="row"> <%=unPersonaje.getId()%> </th>
					      <td><%=unPersonaje.getNombre() %></td>
                          <td><%=unPersonaje.getEdad() %></td>
					      <td><%=unPersonaje.getClase() %></td>
					      <td><%=unPersonaje.getPickrate() %></td>
								<td>
									<a
									  class="btn btn-danger"
										href="<%=request.getContextPath()%>/api/DeleteController?id=<%=unPersonaje.getId()%>"
										role="button"
										onclick="show_confirm()";
									>
										Eliminar
									</a>
								</td>
					    </tr>
					   <%
					   	}
					   %>
					  </tbody>
					</table>
				</section>
			</div>
		</main>
		<script>
			function confirmarEliminado() {
				let text = "Confirmar Borrado!\nElija aceptar o cancelar";
				if (confirm(text) == true) {
					text = "Item Eliminado";
				} else {
					text = "OperaciÃ³n Cancelada";
				}
				alert(text);
			}
			function show_confirm() {
				var retVal = confirm("Do you want to continue ?");
        if (retVal == true)
        {
            alert("User wants to continue!");
            return true;
        } 
        else
        {
            alert("User does not want to continue!");
            return false;
        }
			}
		</script> 
	</body>	
</html>