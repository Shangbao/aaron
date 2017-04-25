<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<!-- sidebar menu -->
<div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
<c:if test="${menuTree.success eq true}">
    <c:forEach items="${menuTree.children}" var="rootMap">
    <div class="menu_section">
    <h3>${rootMap.menu.menuName}</h3>
        <c:if test="${rootMap.hasChild eq true}">
        <ul class="nav side-menu">
            <c:forEach items="${rootMap.children}" var="childMap">
                <li><a><i class="${childMap.menu.icon}"></i>${childMap.menu.menuName}<span class="fa fa-chevron-down"></span></a>
                <c:if test="${childMap.hasChild eq true}">
                    <ul class="nav child_menu ">
                        <c:forEach items="${childMap.children}" var="grandChildMap">
                            <li id="${grandChildMap.id}"><a href="<c:url value="${grandChildMap.url}?menuId=${grandChildMap.id}"/>">${grandChildMap.menuName}</a></li>
                        </c:forEach>
                    </ul>
                </c:if>
             </c:forEach>
        </ul>
        </c:if>
    </div>
    </c:forEach>
</c:if>
</div>
<!-- /sidebar menu -->

</body>
</html>
