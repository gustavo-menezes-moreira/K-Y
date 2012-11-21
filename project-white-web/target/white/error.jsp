<%@ page contentType="application/json" pageEncoding="UTF-8"%>
<%@ page import="java.lang.String" %>
<%! String errorReason = null; %>
<%
	errorReason = (String)request.getAttribute("javax.servlet.error.message");

	if( errorReason != null && errorReason.length() > 0 && errorReason.charAt(0) != '[' ) {
		errorReason = "\"" + errorReason + "\"";
	}
%>
{
   "status":"<%=request.getAttribute("javax.servlet.error.status_code") %>",
   "reason":<%=errorReason %>
}