<%@page import="Model.Testmd"%>
<%@page import="Model.DistricRegister"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="Model.ProvinceRegister"%>
<%@page import="org.jfree.data.jdbc.JDBCPieDataset"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="org.jfree.chart.ChartFactory" %>
<%@ page import="org.jfree.chart.ChartUtilities" %>

<%@ page import="org.jfree.chart.JFreeChart" %>
<%@ page import="org.jfree.chart.plot.PlotOrientation"%>
<%@ page import="org.jfree.data.*" %>
<%@ page import="org.jfree.data.jdbc.JDBCCategoryDataset"%>
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>    <html class="lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>    <html class="lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html> <!--<![endif]-->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<head>
	<title> Online Election Voting </title>
	
	<!-- Meta -->
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0" />
	<meta name="apple-mobile-web-app-capable" content="yes" />
	<meta name="apple-mobile-web-app-status-bar-style" content="black" />
	
	<!-- Bootstrap -->
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
	<link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" />
	
	<!-- Bootstrap Extended -->
	<link href="bootstrap/extend/jasny-bootstrap/css/jasny-bootstrap.min.css" rel="stylesheet" />
	<link href="bootstrap/extend/jasny-bootstrap/css/jasny-bootstrap-responsive.min.css" rel="stylesheet" />
	<link href="bootstrap/extend/bootstrap-wysihtml5/css/bootstrap-wysihtml5-0.0.2.css" rel="stylesheet" />
	
	<!-- JQueryUI v1.9.2 -->
	<link rel="stylesheet" href="theme/scripts/jquery-ui-1.9.2.custom/css/smoothness/jquery-ui-1.9.2.custom.min.css" />
	
	<!-- Glyphicons -->
	<link rel="stylesheet" href="theme/css/glyphicons.css" />
	
	<!-- Bootstrap Extended -->
	<link rel="stylesheet" href="bootstrap/extend/bootstrap-select/bootstrap-select.css" />
	<link rel="stylesheet" href="bootstrap/extend/bootstrap-toggle-buttons/static/stylesheets/bootstrap-toggle-buttons.css" />
	
	<!-- Uniform -->
	<link rel="stylesheet" media="screen" href="theme/scripts/pixelmatrix-uniform/css/uniform.default.css" />

	<!-- ColorPicker -->
	<link rel="stylesheet" media="screen" href="theme/scripts/farbtastic/farbtastic.css" />

	<!-- JQuery v1.8.2 -->
	<script src="theme/scripts/jquery-1.8.2.min.js"></script>
	
	<!-- Modernizr -->
	<script src="theme/scripts/modernizr.custom.76094.js"></script>
	
	<!-- MiniColors -->
	<link rel="stylesheet" media="screen" href="theme/scripts/jquery-miniColors/jquery.miniColors.css" />
	
	<!-- Theme -->
	<link rel="stylesheet" href="theme/css/style.min.css?1359188899" />
	
        <!-- DataTables -->
	<link rel="stylesheet" media="screen" href="theme/scripts/DataTables/media/css/DT_bootstrap.css" />

	
	
	<!-- LESS 2 CSS -->
	<script src="theme/scripts/less-1.3.3.min.js"></script>
	
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<body>
         
    
    
    
	<% 
   /*String username="";
   String usertype="";
 * 
   String userid=session.getAttribute("userid").toString();
    if(session.getAttribute("username")== null){
            out.println("<script type='text/javascript'>alert('You are Unautherized User, You cannot Access this page.');</script>");
            response.sendRedirect("404.html");
      } 
   else {
        username=session.getAttribute("username").toString();
        usertype=session.getAttribute("usrtype").toString();
   }*/
   %>
	<!-- Start Content -->
	<div class="container-fluid left-menu">
		
		<div class="navbar main">
			<div class="innerpx">
				<button type="button" class="btn btn-navbar hidden-desktop hidden-tablet">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<div class="positionWrapper">
					<span class="line"></span>
										<div class="profile">
						<img src="http://www.placehold.it/38x38/232323" class="avatar" alt="Profile" />
						<span class="info hidden-phone">
							<strong>username</strong>
							<em>usertype</em>
						</span>
					</div>
					<!--<ul class="notif">
						<li><a href="" class="glyphicons chat btn" rel="tooltip" data-placement="bottom" data-original-title="7 new chat message(s)"><i></i><span>7</span></a></li>
						<li><a href="" class="glyphicons shopping_cart btn" rel="tooltip" data-placement="bottom" data-original-title="1 new product(s)"><i></i><span>1</span></a></li>
						<li><a href="" class="glyphicons user_add btn" rel="tooltip" data-placement="bottom" data-original-title="4 new member(s)"><i></i><span>4</span></a></li>
						<li><a href="" class="glyphicons envelope btn" rel="tooltip" data-placement="bottom" data-original-title="3 new email(s)"><i></i><span>3</span></a></li>
					</ul>-->
										<ul class="topnav hidden-phone">
						<!--<li>
							<div class="btn-group">
								<a href="#" class="btn-inverse dropdown-toggle" data-toggle="dropdown">
								<img src="theme/images/lang/en.png" align="absmiddle" />
								<span class="caret"></span></a>
						    	<ul class="dropdown-menu pull-right">
						      		<li class="active"><a href="?page=form_elements&lang=en" title="English"><img src="theme/images/lang/en.png" align="absmiddle" /> English</a></li>
						      		<li><a href="?page=form_elements&lang=ro" title="Romanian"><img src="theme/images/lang/ro.png" align="absmiddle" /> Romanian</a></li>
						      		<li><a href="?page=form_elements&lang=it" title="Italian"><img src="theme/images/lang/it.png" align="absmiddle" /> Italian</a></li>
						      		<li><a href="?page=form_elements&lang=fr" title="French"><img src="theme/images/lang/fr.png" align="absmiddle" /> French</a></li>
						      		<li><a href="?page=form_elements&lang=pl" title="Polish"><img src="theme/images/lang/pl.png" align="absmiddle" /> Polish</a></li>
						    	</ul>
						  	</div>
						</li>-->
					<!--							<li>
							<a href="#themer" data-toggle="collapse" class="logout glyphicons eyedropper"><i></i><span>Themer</span></a>
							<div id="themer" class="collapse">
								<div class="wrapper">
									<h4>Themer <span>color &amp; layout options</span></h4>
									<ul>
										<li>Theme: <select id="themer-theme" class="pull-right"></select><div class="clearfix"></div></li>
										<li>Primary Color: <input type="minicolors" data-default="#ffffff" data-slider="hue" data-textfield="false" data-position="left" id="themer-primary-cp" /><div class="clearfix"></div></li>
										<li class="advanced">Header Color: <input type="minicolors" data-slider="hue" data-default="#ffffff" data-textfield="false" data-position="left" id="themer-header-cp" /><div class="clearfix"></div></li>
										<li class="advanced">Menu Color: <input type="minicolors" data-slider="hue" data-default="#ffffff" data-textfield="false" data-position="left" id="themer-menu-cp" /><div class="clearfix"></div></li>
										<li>
											<span class="link" id="themer-custom-reset">reset theme</span>
											<span class="pull-right"><label>advanced <input type="checkbox" value="1" id="themer-advanced-toggle" /></label></span>
										</li>
									</ul>
																		<hr class="separator" />
									<ul>
										<li>Menu position: <select id="themer-menu-position" class="pull-right"></select><div class="clearfix"></div></li>
										<li>Menu size: <select id="themer-menu-size" class="pull-right"></select><div class="clearfix"></div></li>
									</ul>
																		<div id="themer-getcode" class="hide">
										<hr class="separator" />
										<button class="btn btn-primary btn-small pull-right btn-icon glyphicons download" id="themer-getcode-less"><i></i>Get LESS</button>
										<button class="btn btn-inverse btn-small pull-right btn-icon glyphicons download" id="themer-getcode-css"><i></i>Get CSS</button>
										<div class="clearfix"></div>
									</div>
								</div>
							</div>
						</li>-->
																		<li>
                                                                                                                                                    <a href="SignOut.jsp" class="logout glyphicons lock"><i></i><span>Logout</span></a>
						</li>
											</ul>
				</div>
			</div>
		</div>
	
		<div class="row-fluid rrow main">
			<div class="span12 main col" role="main">
				<div class="row-fluid rrow">
					<div class="span2 col main-left hide hidden-phone menu-large">
						<div class="rrow scroll-y-left">
							<div class="iScrollWrapper">
								<ul>
									<li class="glyphicons home"><a href="index.html"><i></i><span>Dashboard</span></a></li>
									<li class="glyphicons coins"><a href="finances.html"><i></i><span>Finances</span></a></li>
									<li class="hasSubmenu2">
										<a data-toggle="collapse" class="glyphicons shopping_cart" href="#menu_ecommerce"><i></i><span>Online Shop</span></a>
										<ul class="collapse" id="menu_ecommerce">
											<li class=""><a href="products.html" class="glyphicons show_thumbnails"><i></i><span>Products</span></a></li>
											<!-- <li class=""><a href="categories.html" class="glyphicons show_big_thumbnails"><i></i><span>Categories</span></a></li> -->
											<li class=""><a href="product_edit.html" class="glyphicons cart_in"><i></i><span>Add product</span></a></li>
											<!-- <li class=""><a href="orders.html" class="glyphicons list"><i></i><span>Orders</span></a></li> -->
										</ul>
									</li>
									<li class="glyphicons sort"><a href="pages.html"><i></i><span>Site Pages</span></a></li>
									<li class="glyphicons picture"><a href="gallery.html"><i></i><span>Photo Gallery</span></a></li>
									<li class="glyphicons adress_book"><a href="bookings.html"><i></i><span>Bookings</span></a></li>
									<li class="glyphicons charts"><a href="charts.html"><i></i><span>Charts</span></a></li>
									<li class="glyphicons cogwheels"><a href="ui.html"><i></i><span>UI Elements</span></a></li>
									
									<!--<li class="hasSubmenu2">
										<a data-toggle="collapse" class="glyphicons table" href="#menu_tables"><i></i><span>Tables</span></a>
										<ul class="collapse" id="menu_tables">
											<li class=""><a href="tables.html" class="glyphicons show_thumbnails"><i></i><span>Classic Tables</span></a></li>
											<li class=""><a href="tables_themed.html" class="glyphicons show_thumbnails"><i></i><span>Themed Tables</span></a></li>
											<li class=""><a href="tables_enhanced.html" class="glyphicons show_thumbnails"><i></i><span>Enhanced Tables</span></a></li>
										</ul>
									</li>
									<li class="glyphicons calendar"><a href="calendar.html"><i></i><span>Calendar</span></a></li>-->
								</ul>
							</div>
							<span class="navarrow hide">
								<span class="glyphicons circle_arrow_down"><i></i></span>
							</span>
						</div>
					</div>
					<div class="span10 col main-right">
						<div class="rrow scroll-y" id="mainYScroller">
							 
                           <!--  our GK start-->
                              <div class="middle_main">
   <%

 //String query="SELECT * FROM msc_app.chart_test";
/*JDBCCategoryDataset dataset=new JDBCCategoryDataset("jdbc:mysql://localhost:3306/msc_app",
"com.mysql.jdbc.Driver","root","");*/
  
//dataset.executeQuery( query);
    
    //JFreeChart chart = ChartFactory .createPieChart("Latest 3 batches student registrations as relative portion", dataset, true, true, false);
        
//dataset.executeQuery( query);
/*JFreeChart chart = ChartFactory .createBarChart3D(
"Batchwise Student Registrations",
"Batch",
"Student Amount",
dataset,
PlotOrientation.VERTICAL,true, true, false);*/

try
{

 JDBCCategoryDataset dataset=null;
   Testmd axc=new Testmd();
   String abc="";
   dataset=axc.Barchart();
    ResultSet  xx=(ResultSet)dataset;
    while(xx.next()){
        abc=xx.getString(1);
    }
 JFreeChart chart = ChartFactory.createBarChart3D("Batchwise Student Registrations","Batch",abc,dataset,PlotOrientation.VERTICAL,true, true, false);
 ChartUtilities.saveChartAsJPEG(new File("D:/Software/JAVA/New folder (2)/images/chart2.jpg"), chart, 600, 600);
Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler D:/Software/JAVA/New folder (2)/images/chart2.jpg");
response.sendRedirect("Adminlogin.jsp");
%>

<center>
    <img src="images/chart2.jpg" width="800" height="550" border="8">
</center>
<%


}
catch (Exception e)
{
System.out.println("Problem in creating chart.");
}
%>

   </div> 	

     <!--  our GK end-->


						</div>
					</div>
				</div>
			</div>

		<!-- End Content -->
		</div>
		
		<!-- Sticky Footer -->
		<div id="footer" class="hide">
	      	<div class="wrap">
	      		<ul>
	      				      			<li class="active"><span data-toggle="menu-position" data-menu-position="left-menu" class="glyphicons circle_arrow_left" title=""><i></i></span></li>
	      			<li><span data-toggle="menu-position" data-menu-position="right-menu" class="glyphicons circle_arrow_right" title=""><i></i></span></li>
	      			<li><span data-toggle="menu-position" data-menu-position="top-menu" class="glyphicons circle_arrow_top" title=""><i></i></span></li>
	      			<li class="divider"></li>
	      			<li class="active"><span data-toggle="menu-size" data-menu-size="0" class="glyphicons show_big_thumbnails text" title=""><i></i><span class="hidden-phone">Large menus</span></span></li>
	      			<li><span data-toggle="menu-size" data-menu-size="1" class="glyphicons show_thumbnails text" title=""><i></i><span class="hidden-phone">Small menus</span></span></li>
	      				      			<li><a href="documentation.html" class="glyphicons circle_question_mark text" title=""><i></i><span class="hidden-phone">Documentation</span></a></li>
	      		</ul>
	      	</div>
	    </div>
		
	</div>
	
	<!-- Cubiq iScroll -->
	<!--[if gte IE 9]><!-->
	<script src="theme/scripts/cubiq-iscroll/src/iscroll.js"></script>
	<!--<![endif]-->
	
	<!--[if lt IE 9]>
	<script src="theme/scripts/cubiq-iscroll/src/iscroll-ie.js"></script>
	<![endif]-->
	
	<script type="text/javascript">
	var scrollers = [];
	var mainYScroller;
	
	$(function()
	{
		//document.addEventListener('touchmove', function(e){ e.preventDefault(); });
		var xScrollers = $(".scroll-x");
	    for (var i = 0; i < xScrollers.length; i++)
			scrollers.push(new iScroll(xScrollers[i], { 
				vScroll: false, 
				hideScrollbar: true,
				useTransform: $('html').is('.lt-ie9') ? false : true,
				onBeforeScrollStart: function (e) 
				{
					var target;
					if (!e) var e = window.event;
					if (e.target) target = e.target;
					else if (e.srcElement) target = e.srcElement;
					if (target.nodeType == 3) target = target.parentNode;

					if (target.tagName != 'SELECT' && target.tagName != 'INPUT' && target.tagName != 'TEXTAREA')
					{
						if (e.preventDefault) e.preventDefault();
						else e.returnValue = false;
					}
				} 
			}));

		var yScrollers = $('.scroll-y').not('#mainYScroller');
	    $.each(yScrollers, function(i,v)
		{
	    	var scroller = new iScroll($(v).attr('id'),
	    	{
		    	hScroll: false, 
		    	hideScrollbar: true,
		    	useTransform: $('html').is('.lt-ie9') ? false : true,
		    	onBeforeScrollStart: function (e) 
		    	{
		    		var target;
					if (!e) var e = window.event;
					if (e.target) target = e.target;
					else if (e.srcElement) target = e.srcElement;
					if (target.nodeType == 3) target = target.parentNode;
					
					if (target.tagName != 'SELECT' && 
						target.tagName != 'INPUT' && 
						target.tagName != 'TEXTAREA' &&
						$(target).parents('table-responsive').size() == 0)
					{
						if (e.preventDefault) e.preventDefault();
						else e.returnValue = false;
					}
				}
		    });
	    	scrollers.push(scroller);
		});

	    mainYScroller = new iScroll('mainYScroller',
    	{
	    	zoom: true,
	    	hScroll: false, 
	    	hideScrollbar: true,
	    	useTransform: $('html').is('.lt-ie9') ? false : true,
	    	onBeforeScrollStart: function (e) 
	    	{
	    		var target;
				if (!e) var e = window.event;
				if (e.target) target = e.target;
				else if (e.srcElement) target = e.srcElement;
				if (target.nodeType == 3) target = target.parentNode;

				if ($('input:focus, textarea:focus').length) $('input:focus, textarea:focus').blur();

				if ($(target).parents('.table-responsive').size() > 0 ||
					$(target).parents('.google-visualization-table-table').size() > 0 ||
					$(target).parents('#calendar').size() > 0 ||
					$(target).is('.btn'))
					{
						return true;
					}
					
				if (target.tagName != 'SELECT' && 
					target.tagName != 'INPUT' && 
					target.tagName != 'TEXTAREA')
				{
					if (e.preventDefault) e.preventDefault();
					else e.returnValue = false;
				}
			},
			onScrollEnd: function()
			{
				//if (mainYScroller.enabled == false) mainYScroller.enable();
			}
	    });
	    scrollers['mainYScroller'] = mainYScroller;
	});
	</script>
	
	<!-- JQueryUI v1.9.2 -->
	<script src="theme/scripts/jquery-ui-1.9.2.custom/js/jquery-ui-1.9.2.custom.min.js"></script>
	
	<!-- JQueryUI Touch Punch -->
	<!-- small hack that enables the use of touch events on sites using the jQuery UI user interface library -->
	<script src="theme/scripts/jquery-ui-touch-punch/jquery.ui.touch-punch.min.js"></script>
	
	<!-- MiniColors -->
	<script src="theme/scripts/jquery-miniColors/jquery.miniColors.js"></script>
	
	<!-- Themer -->
	<script>
	var themerPrimaryColor = '#DA4C4C',
		themerHeaderColor = '#393D41',
		themerMenuColor = '#232628';
	</script>
	<script src="theme/scripts/jquery.cookie.js"></script>
	<script src="theme/scripts/themer.js"></script>
	
	<!-- ColorPicker -->
	<script src="theme/scripts/farbtastic/farbtastic.js" type="text/javascript"></script>

	
	
	<!-- Resize Script -->
	<script src="theme/scripts/jquery.ba-resize.js"></script>
	
	<!-- Uniform -->
	<script src="theme/scripts/pixelmatrix-uniform/jquery.uniform.min.js"></script>
	
	<!-- Bootstrap Script -->
	<script src="bootstrap/js/bootstrap.min.js"></script>
	
	<!-- Bootstrap Extended -->
	<script src="bootstrap/extend/bootstrap-select/bootstrap-select.js"></script>
	<script src="bootstrap/extend/bootstrap-toggle-buttons/static/js/jquery.toggle.buttons.js"></script>
	<script src="bootstrap/extend/bootstrap-hover-dropdown/twitter-bootstrap-hover-dropdown.min.js"></script>
	<script src="bootstrap/extend/jasny-bootstrap/js/jasny-bootstrap.min.js" type="text/javascript"></script>
	<script src="bootstrap/extend/jasny-bootstrap/js/bootstrap-fileupload.js" type="text/javascript"></script>
	<script src="bootstrap/extend/bootbox.js" type="text/javascript"></script>
	<script src="bootstrap/extend/bootstrap-wysihtml5/js/wysihtml5-0.3.0_rc2.min.js" type="text/javascript"></script>
	<script src="bootstrap/extend/bootstrap-wysihtml5/js/bootstrap-wysihtml5-0.0.2.js" type="text/javascript"></script>
	
	<!-- Custom Onload Script -->
	<script src="theme/scripts/load.js"></script>
	
</body>
</html>