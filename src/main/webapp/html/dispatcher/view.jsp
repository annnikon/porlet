<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>

<portlet:defineObjects />

This is the <b>Dispatcher</b> portlet in View mode.

<div class="container">
    <H1>All Departments</H1>

    <p style="color:darkslategrey;">${status}</p>
    <br/>
    <c:if test="${not empty departments}">
        <table class="table table-striped">
            <caption>Our departments</caption>
            <thead>
            <th>Name</th>
            <th>Info</th>
            <th>Actions</th>
            </thead>
            <tbody>
            <c:forEach items="${departments}" var="department">
                <tr>
                    <td>${department.name}</td>
                    <td>${department.info}</td>
                    <td>&nbsp;&nbsp;<a class="btn btn-danger"
                                       href="/task3/departments?action=delete&id=${department.id}">Delete</a></td>
                    <td>&nbsp;&nbsp;<a class="btn btn-warning"
                                       href="/task3/departments?action=edit&id=${department.id}">Edit</a></td>
                    <td>&nbsp;&nbsp;<a class="btn btn-primary"
                                       href="/task3/employees?action=list&department=${department.name}">Show
                        employees</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </c:if>


    <c:if test="${empty departments}">
        <caption> There are no any departments</caption>
    </c:if>

    <a class="btn btn-success" href="/task3/departments?action=edit">Add new department</a>


</div>