
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/common/head_link.jsp" %>
    <title>Final Exam</title>
</head>
<body>
<!-- Header -->
<%@ include file="/common/header.jsp"%>
<!-- end -->

<!-- Navigation -->
<%@ include file="/common/navigation.jsp"%>
<!-- end -->

<!-- Body page -->
<div class="row container-fluid padding">
    <div class="col-12 col-sm-3 col-md-3 col-lg-3" style="background-color: white">

        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <button type="button" class="btn btn-outline-info btn-sm btn-block">
                    <a class="nav-link" href="#">Link 1</a>
                </button>
            </li>
            <hr class="my-4" width="97%">
            <li class="nav-item">
                <button type="button" class="btn btn-outline-info btn-sm btn-block">
                    <a class="nav-link" href="#">Link 2</a>
                </button>
            </li>
            <hr class="my-4" width="97%">
            <li class="nav-item">
                <button type="button" class="btn btn-outline-info btn-sm btn-block">
                    <a class="nav-link" href="#">Link 3</a>
                </button>
            </li>
            <hr class="my-4" width="97%">
            <li class="nav-item">
                <button type="button" class="btn btn-outline-info btn-sm btn-block">
                    <a class="nav-link" href="#">Link 4</a>
                </button>
            </li>
            <hr class="my-4" width="97%">
            <li class="nav-item">
                <button type="button" class="btn btn-outline-info btn-sm btn-block">
                    <a class="nav-link" href="#">Link 5</a>
                </button>
            </li>
        </ul>
    </div>
    <div class="col-12 col-sm-9 col-md-9 col-lg-9">

        <!-- Carousel -->
        <div id="slides" class="carousel slide" data-ride="carousel">
            <ul class="carousel-indicators">
                <li data-target="#slides" data-slide-to="0" class="active"></li>
                <li data-target="#slides" data-slide-to="1"></li>
                <li data-target="#slides" data-slide-to="2"></li>
                <li data-target="#slides" data-slide-to="3"></li>
            </ul>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img class="img-fluid" src="./all/image/view_1.jpg"/>
                    <div class="carousel-caption">
                        <h2 class="display-2">Final Exam</h2>
                        <h4>Hà Duy Nam - C0224G1</h4>
                        <button type="button" class="btn btn-outline-info btn-lg" style="color:red">
                            <a class="nav-link" href="/products">See more...</a>
                        </button>
                    </div>
                </div>
                <div class="carousel-item">
                    <img class="img-fluid" src="./all/image/view_2.jpg">
                </div>
                <div class="carousel-item">
                    <img class="img-fluid" src="./all/image/view_3.jpg">
                </div>
                <div class="carousel-item">
                    <img class="img-fluid" src="./all/image/view_4.jpg">
                </div>
            </div>

            <!-- Controls -->
            <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
        <!-- End carousel -->
    </div>
</div>
<!-- End body -->

<!-- Footer -->
<%@ include file="/common/footer.jsp"%>
<%@ include file="/common/foot_script.jsp"%>
<!-- end -->
</body>
</html>