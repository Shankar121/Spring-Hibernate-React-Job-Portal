<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
<title>Test App</title>
<script>
var reactBaseUrl="<c:url value='/'/>";
</script>
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/bootstrap-4.0.0-dist/css/bootstrap.min.css"/>">
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/select2/dist/css/select2.min.css"/>">
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.3.1.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/bootstrap-4.0.0-dist/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/select2/dist/js/select2.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/react/react.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/react/react-dom.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/react/Babel.js"/>"></script>
<script type="text/babel" src="<c:url value="/resources/react/components/MainComponent.js"/>"></script>
<script type="text/babel" src="<c:url value="/resources/react/components/JobComponent.js"/>"></script>
<script type="text/babel" src="<c:url value="/resources/react/components/AppComponent.js"/>"></script>
<script type="text/babel" src="<c:url value="/resources/react/components/ApplyComponent.js"/>"></script>
</head>
<body>
<div id="mainComponent"></div>
</body>
<script type="text/babel">
ReactDOM.render(<App />, 
                  document.getElementById('mainComponent')
                  );

</script>
</html>
