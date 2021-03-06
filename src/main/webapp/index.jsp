<%-- 
    Document   : home_page
    Created on : 10 ????. 2021 ?., 20:13:35
    Author     : ??????????
--%>

<%@page import="org.obrii.mit.dp2021.shyloivan.dbproject.DataClass"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <title>Table page</title>

    <body style="background-color:blue; margin: auto;">
        <div style="margin: auto;">
        <h1>Welcome to the Table!</h1>
        <p>Here you can leave some information, change, delete or add entirely new users.</p>
        <%List<DataClass> dataList = (List<DataClass>) request.getAttribute("data");%>
                    <table class="">
                        <thead>
                            <tr>
                                <th>id</th>
                                <th>name</th>
                                <th>age</th>
                                <th>update</th>
                                <th>delete</th>
                                
                            </tr>
                        </thead>
                        <tbody>
                            <%for(DataClass data:dataList) { %>
                        <tr>
                            <td><%=data.getId()%></td>
                            <td><%=data.getName()%></td>
                            <td><%=data.getAge()%></td>
                            <td>
                                <form action="form_update.jsp" method="post">
                                    <input type="hidden" name="id" value="<%=data.getId()%>">
                                    <input type="hidden" name="name" value="<%=data.getName()%>">
                                    <input type="hidden" name="age" value="<%=data.getAge()%>">
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
                       <% } %>
                       <tr>
                           <td colspan="4">
                          <form action= "<%=request.getContextPath()%>/Data" method="get">
                              <input class="table_btn" type="text" name="search">
                              <input class="table_btn" type="submit" value="Search">
                          </form>
                      </td>
                            <td colspan="3">
                                <form action="form.jsp" method="get">
                                    <input type="submit" value="SAVE" >
                                </form>
                            </td>
                        </tr>
                        </tbody>
                    </table>
            </div>
		
    </body>
</html>
