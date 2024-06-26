<%-- 
    Document   : updateRecruitment
    Created on : Sep 9, 2021, 4:01:17 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="property" uri="http://www.springframework.org/tags"%>

<c:if test="${msg != null}">
    <div id="toast">
        <div id="toast_main">
            <div class="toast_icon">
                <i class="fa fa-exclamation-triangle" aria-hidden="true"></i>
            </div>
            <div class="toast_body">
                <h3 class="toast_title">THÔNG BÁO!</h3>
                <div class="toast_message">${msg}</div>
            </div>
            <div class="toast_close" onclick="removeToast();">
                <i class="fa fa-times" aria-hidden="true"></i>
            </div>
        </div>
    </div>
</c:if>
<!-- ======= JOBS Section ======= -->
<section id="job" class="job">
    <!-- SEARCH SECTION -->
    <div class="container">
        <form action="">
            <div class="search input-group mb-3">
                <input type="text" name="kw" class="form-control" placeholder="Search">
                <div class="input-group-append">
                    <button class="btn-search" type="submit">Go</button>
                </div>
            </div>
        </form>
    </div>
    <c:set value="${recruitments}" var="list" />
    <div class="container">
        <!-- JOB SECTION -->
        <div class="row pb-4">
            <c:forEach var="r" items="${list.pageList}">
                <div class="col-md-12 col-lg-6 d-flex align-items-stretch mb-5 mb-lg-0 pb-4">
                    <div class="icon-box" id="reId${r.idRecruitment}">
                        <div class="box2">
                            <h4 class="title"><a href="<c:url value="/employer/recruitment/update/${r.idRecruitment}"/>">${r.title}</a></h4>
                                <c:url value="/employer/manage" var="id">
                                    <c:param name="idRe" value="${r.idRecruitment}"></c:param>
                                </c:url>
                            <div class="manage">
                                <a href="<c:url value="/employer/recruitment/update/${r.idRecruitment}"/>" target="_blank">Update</a>
                                <a href="#"onclick="deleteRecruitment(${r.idRecruitment})">Delete</a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="add"> 
            <a href="<c:url value="/employer/recruitment/new"/>">
                <i class="fa fa-file-o" aria-hidden="true"></i>&nbsp;&nbsp;ADD NEW RECRUITMENT >>
            </a>
        </div>
        <!-- CLASSIFY THE PAGINATION BY THE CONDITIONS -->
        <nav class="pagi">
            <ul class="pagination pagination-lg justify-content-center">
                <c:forEach begin="1" end="${list.pageCount}" step="1" varStatus="i">
                    <li class="page-item">
                        <a class="page-link" href="
                           <c:url value="/employer/manage"/>?page=${i.index}">${i.index}</a>
                    </li>
                </c:forEach>
            </ul>
        </nav>
    </div>
</section><!-- End Our Services Section -->

<a href="#" class="back-to-top"><i class="icofont-simple-up"></i></a>
