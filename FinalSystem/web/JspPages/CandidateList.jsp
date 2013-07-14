<%@page import="Model.CandiRegister"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>    <html class="lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>    <html class="lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html> <!--<![endif]-->
<head>
	<title>Candidates List</title>
	
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

	<!-- DataTables -->
	<link rel="stylesheet" media="screen" href="theme/scripts/DataTables/media/css/DT_bootstrap.css" />

	<!-- JQuery v1.8.2 -->
	<script src="theme/scripts/jquery-1.8.2.min.js"></script>
	
	<!-- Modernizr -->
	<script src="theme/scripts/modernizr.custom.76094.js"></script>
	
	<!-- MiniColors -->
	<link rel="stylesheet" media="screen" href="theme/scripts/jquery-miniColors/jquery.miniColors.css" />
	
	<!-- Theme -->
	<link rel="stylesheet" href="theme/css/style.min.css?1359188932" />
	
	
	
	<!-- LESS 2 CSS -->
	<script src="theme/scripts/less-1.3.3.min.js"></script>
	
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<body>
	
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
							<strong>Adrian Demian</strong>
							<em>Content Manager</em>
						</span>
                                            </div>
					<ul class="topnav hidden-phone">
						<li>
							<a href="login.html" class="logout glyphicons lock"><i></i><span>Logout</span></a>
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
									 <li class="glyphicons home"><a href="AdminDash.jsp"><i></i><span>Dashboard</span></a></li>
                                            				
                                                                        <li class="hasSubmenu2">
										<a data-toggle="collapse" class="glyphicons show_thumbnails_with_lines" href="#menu_Settings"><i></i><span>Election Settings</span></a>
										<ul class="collapse" id="menu_Settings">
										<li class=""><a href="ProvinceDetails.jsp" class="glyphicons show_thumbnails"><i></i><span>Create Provinces</span></a></li>
                                                                                        <li class=""><a href="AddDistricDetails.jsp" class="glyphicons show_big_thumbnails"><i></i><span>Create Districts</span></a></li>
                                                                                        <li class=""><a href="AddPollingDivisionDetails.jsp" class="glyphicons cart_in"><i></i><span>Create Polling Divisions</span></a></li>
                                                                                        <li class=""><a href="ElectionTypes.jsp" class="glyphicons list"><i></i><span>Create Election Types</span></a></li> 	
										</ul>
									</li>
                                                                        <!-- User Registration --> 
                                                                         <li class="hasSubmenu2">
										<a data-toggle="collapse" class="glyphicons show_thumbnails_with_lines" href="#menu_Registrations"><i></i><span>User Registrations</span></a>
										<ul class="collapse" id="menu_Registrations">
										    <li  class=""><a href="Adminregister.jsp"><i></i><span>Create Administrator</span></a></li>
                                                                                    <li class=""><a href="VoterRegistration.jsp" class="glyphicons show_big_thumbnails"><i></i><span>Create Voter</span></a></li>
                                                                                    <li class=""><a href="voterList.jsp" class="glyphicons show_big_thumbnails"><i></i><span>Voter List</span></a></li>
                                                                                        
                                                                                    <li class=""><a href="SecatryRegister.jsp" class="glyphicons cart_in"><i></i><span>Create Sectary</span></a></li>
                                                                                    <li class=""><a href="SecatryList.jsp" class="glyphicons cart_in"><i></i><span>Sectary List</span></a></li>
                                                                                        
                                                                                    <li class=""><a href="CandidateRegistration.jsp" class="glyphicons list"><i></i><span>Create Candidate</span></a></li>
                                                                                    <li class="glyphicons charts currentScroll active"><a href="CandidateList.jsp" class="glyphicons list"><i></i><span>Candidate List</span></a></li> 
										</ul>
									</li>
                                                                        <!--Reports -->
                                                                          <li class="hasSubmenu2">
										<a data-toggle="collapse" class="glyphicons show_thumbnails_with_lines" href="#menu_Reports"><i></i><span>Reports</span></a>
										<ul class="collapse" id="menu_Reports">
											 <li class=""><a href="CandidateRpt.jsp" class="glyphicons show_thumbnails"><i></i><span>Candidates Report</span></a></li>
                                                                                    <li class=""><a href="politicalparydetailRpt.jsp" class="glyphicons show_big_thumbnails"><i></i><span>Political Party Report</span></a></li>
                                                                                    <li class=""><a href="PollingDivision_Province.jsp" class="glyphicons show_big_thumbnails"><i></i><span>polling Division Reports</span></a></li>
                                                                                    
										</ul>
									</li>
								</ul>
							</div>
							<span class="navarrow hide">
								<span class="glyphicons circle_arrow_down"><i></i></span>
							</span>
						</div>
					</div>
					<div class="span10 col main-right">
						<div class="rrow scroll-y" id="mainYScroller">
							<div class="inner topRight"><ul class="breadcrumb">
	<li><a href="index.html" class="glyphicons home"><i></i> BootAdmin</a></li>
	<li class="divider"></li>
	<li>Tables</li>
	<li class="divider"></li>
	<li>Enhanced Tables</li>
</ul><br />

<h2 class="glyphicons show_thumbnails"><i></i> Enhanced Tables</h2>
<div class="separator"></div>


<div class="relativeWrap">
<div class="widget widget-gray widget-gray-white">
	<div class="widget-head">
		<h4 class="heading">Candidate List</h4>
	</div>
	<div class="widget-body">
		<table cellpadding="0" cellspacing="0" border="0" class="dynamicTable table table-striped table-bordered table-primary table-condensed">
			<thead>
				<tr>
					<th>Candidate Code</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Political Party</th>
					<th>Voting Number</th>
				</tr>
			</thead>
			<tbody>
                             <%
                                ResultSet insertreslt=null;
                                CandiRegister candidetails=new CandiRegister();
                                insertreslt=candidetails.GetCandidateList();
                                if(insertreslt!=null){
                                    while(insertreslt.next())
                                    {%>
				<tr class="gradeX">
					<td class="left"><%= insertreslt.getString(1)%></td>
                                        <td class="left"><a href="#" onclick="editview();"><%= insertreslt.getString(2)%></a></td>
                                        <td class="left"><%= insertreslt.getString(3)%></td>
                                        <td class="left"><%= insertreslt.getString(5)%></td>
                                        <td class="left"><%= insertreslt.getString(6)%></td>
				</tr>
				 <% }
              }
            else{%>
            <tr class="center">
                
            </tr>
            <%}   %>
			</tbody>
		</table>
	</div>
</div>
</div>
<br />							</div>
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
	
	
	
	<!-- Resize Script -->
	<script src="theme/scripts/jquery.ba-resize.js"></script>
	
	<!-- Uniform -->
	<script src="theme/scripts/pixelmatrix-uniform/jquery.uniform.min.js"></script>
	
	
	<!-- DataTables -->
	<script src="theme/scripts/DataTables/media/js/jquery.dataTables.min.js"></script>
	<script src="theme/scripts/DataTables/media/js/DT_bootstrap.js"></script>

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