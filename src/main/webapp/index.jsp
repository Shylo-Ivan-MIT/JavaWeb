<%-- 
    Document   : home_page
    Created on : 10 ????. 2021 ?., 20:13:35
    Author     : ??????????
--%>
<%@page import="java.util.List"%>
<%@page import="org.obrii.mit.dp2021.shyloivan.DataProccesing"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <title>Table page</title>

    <body style="background-color:lightpink; margin: auto;">
        <div style="margin: auto;">
        <h1>Welcome to the Table!</h1>
        <p>Here you can leave some information, change, delete or add entirely new users.</p>
        <%List<Data> dataList = (List<Data>) request.getAttribute("data");%>
                    <table class="styled-table">
                        <thead>
                            <tr>
                                <th>id</th>
                                <th>name</th>
                                <th>age</th>
                                <th>email</th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <%for (Data data : dataList) {%>
                        <tr>
                            <td><%=data.getId()%></td>
                            <td><%=data.getName()%></td>
                            <td><%=data.getAge()%></td>
                            <td><%=data.getEmail()%></td>
                            <td>
                                <form action="update.jsp" method="post">
                                    <input type="hidden" name="id" value="<%=data.getId()%>">
                                    <input type="hidden" name="name" value="<%=data.getName()%>">
                                    <input type="hidden" name="age" value="<%=data.getAge()%>">
                                    <input type="hidden" name="email" value="<%=data.getEmail()%>">
                                    <input type="submit" value="Update">
                                </form>
                            </td>
                            <td>
                                <form action="<%=request.getContextPath()%>/form" method="get">
                                    <input type="hidden" name="id" value="<%=data.getId()%>">
                                    <input type="submit" value="Delete">
                                </form>
                            </td>
                        </tr>
                       <%}%>
                       <tr>
                           <td colspan="4">
                               <form action= "<%=request.getContextPath()%>/" method="get">
                                    <input type="text" name="search">
                                    <input type="submit" value="search data">
                               </form>
                           </td>
                            <td colspan="3">
                                <form action="create.jsp" methd="get">
                                    <input type="submit" value="SAVE" >
                                </form>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                                     
                
            </div>
		</div>
	</div>
    </body>
</html>
