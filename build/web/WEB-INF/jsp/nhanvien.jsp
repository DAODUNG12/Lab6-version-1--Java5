<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
	<title>Spring MVC - Databinding - Hibernate</title>
        <base href="${pageContext.servletContext.contextPath}/">
</head>
<body>
    <h2>Quản lý nhân viên</h2>
   
    <form:form action="nhanvien.htm" modelAttribute="nhanvien">
        <div>Mã NV</div>
        <form:input path="manv" readonly="true"/>
        <div>Họ và tên</div>
        <form:input path="hoten"/>

        <div>Đia chi</div>
        <form:input path="diachi"/>

        <div>Gioi tinh</div>
        <form:select path="gioitinh">
                <form:option value="true">Nam</form:option>
                <form:option value="false">Nu</form:option>
        </form:select>

        <div>
            <button name="btnInsert">Thêm</button>
            <button name="btnUpdate">Cập nhật</button>         
        </div>
    </form:form>
    <br>            
    
        
    <table border="1">
        <tr>
            <td>MaNV</td>
            <td>Ho Ten</td>
            <td>Dia chi</td>
            <td>Gioi tinh</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        <c:forEach var="rows" items="${listStudent}">
            <form action="student/delete.htm">
            <tr>
                <td>${rows.manv}</td>
                <td>${rows.hoten}</td>
                <td>${rows.diachi}</td>
                <td>${rows.gioitinh}</td>
                <c:url var="edit" value="student/edit.htm">
                    <c:param name="txtMasv" value="${rows.manv}"/>
                    <c:param name="txtName" value="${rows.hoten}"/>
                    <c:param name="txtMark" value="${rows.diachi}"/>
                    <c:param name="txtMajor" value="${rows.gioitinh}"/>
                </c:url>
                <td><a href="${edit}">Edit</a></td>
                <td>
                    <input type="hidden" name="txtMasv" value="${rows.manv}"/>
                    <input type="submit" name="action" value="Delete"/>
                </td>
            </tr>
            </form>
        </c:forEach>    
    </table>
</body>
</html>
