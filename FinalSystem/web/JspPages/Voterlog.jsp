<%@page import="java.sql.ResultSet"%>
<%@page import="Model.PollingDivisionRegister"%>
<!DOCTYPE html>
<html>
<head>
	<title>Voter Login </title>
	
	<!-- Meta -->
	<meta charset="utf-8" />
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

	<!-- JQuery v1.8.2 -->
	<script src="theme/scripts/jquery-1.8.2.min.js"></script>
	
	<!-- Modernizr -->
	<script src="theme/scripts/modernizr.custom.76094.js"></script>
	
	<!-- MiniColors -->
	<link rel="stylesheet" media="screen" href="theme/scripts/jquery-miniColors/jquery.miniColors.css" />
	
	<!-- Theme -->
	<link rel="stylesheet" href="theme/css/style.min.css?1358876495" />
        
        <!-- ColorPicker -->
	<link rel="stylesheet" media="screen" href="theme/scripts/farbtastic/farbtastic.css" />

        <!-- LESS 2 CSS -->
	<script src="theme/scripts/less-1.3.3.min.js"></script>
	
	
	
	<!-- LESS 2 CSS -->
	<script src="theme/scripts/less-1.3.3.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" >
    function submitlogin()
    {       //validation part
               loginBtn.click();  
    }
</script>

</head>
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
						<img src="#" class="avatar" alt="Profile" />
						<span class="info hidden-phone">
							<strong>Adrian Demian</strong>
							<em>Content Manager</em>
						</span>
					</div>
					<ul class="notif">
						<li><a href="" class="glyphicons chat btn" rel="tooltip" data-placement="bottom" data-original-title="7 new chat message(s)"><i></i><span>7</span></a></li>
						<li><a href="" class="glyphicons shopping_cart btn" rel="tooltip" data-placement="bottom" data-original-title="1 new product(s)"><i></i><span>1</span></a></li>
						<li><a href="" class="glyphicons user_add btn" rel="tooltip" data-placement="bottom" data-original-title="4 new member(s)"><i></i><span>4</span></a></li>
						<li><a href="" class="glyphicons envelope btn" rel="tooltip" data-placement="bottom" data-original-title="3 new email(s)"><i></i><span>3</span></a></li>
					</ul>
										<ul class="topnav hidden-phone">
						<li>
							<div class="btn-group">
								<a href="#" class="btn-inverse dropdown-toggle" data-toggle="dropdown">
								<img src="theme/images/lang/en.png" align="absmiddle" />
								<span class="caret"></span></a>
						    	<ul class="dropdown-menu pull-right">
						      		<li class="active"><a href="?page=index&lang=en" title="English"><img src="theme/images/lang/en.png" align="absmiddle" /> English</a></li>
						      		<li><a href="?page=index&lang=ro" title="Romanian"><img src="theme/images/lang/ro.png" align="absmiddle" /> Romanian</a></li>
						      		<li><a href="?page=index&lang=it" title="Italian"><img src="theme/images/lang/it.png" align="absmiddle" /> Italian</a></li>
						      		<li><a href="?page=index&lang=fr" title="French"><img src="theme/images/lang/fr.png" align="absmiddle" /> French</a></li>
						    	</ul>
						  	</div>
						</li>
												<li>
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
						</li>
																		<li>
							<a href="login.html" class="logout glyphicons lock"><i></i><span>Logout</span></a>
						</li>
											</ul>
				</div>
			</div>
		</div>
   <div class="middle_main">

   <div class="user_log">
   
      <div class="login-box main-content">
      <header><h2>Login</h2></header>
    	<section>
             <% if(session.getAttribute("Login")=="Error"){%>
                          <div class="message act-danger">Login Fails, Try Again please</div>
                            <% session.setAttribute("Login",null); 
                            }
                            if(session.getAttribute("Login")=="Sucess"){%>
                            <div class="message act-success">Voter Login Successfully</div><%
                            session.setAttribute("Login",null); 
                            } 
                            if(session.getAttribute("VoteSucess")=="Error"){%>
                            <div class="message act-success">You are already voted</div><%
                            session.setAttribute("VoteSucess",null); 
                            } %> 
                            
    		<form  name="votelogform" action="../VotersLogin_Servlet" method="post" class="clearfix">
			<p>
				<input type="text"   class="full"  name="ElctioncrdNo" required="required" placeholder="Election Card No" />
			</p>
			<p>
				<input type="text"  class="full"  name="Nicno" required="required" placeholder="NIC No" />
			</p>
                        <p>
			<%
                    try {
                          PollingDivisionRegister pollingDiv=new PollingDivisionRegister();
                          ResultSet rslts=pollingDiv.LoadPollingDivCombo();%>
                           <select name="pollid" class="full"  class="selectpicker">
                           <% while(rslts.next())
                           { %>  
                                <option value="<%= rslts.getString(1)%>"><%= rslts.getString(2)%></option>
                           <%}
                      }
                    catch(Exception exception1)
                    {
                         exception1.printStackTrace();
                    }%>
                     </select> 
                 
			</p>
			<p class="clearfix">
				<button class="button button-gray fr" onclick="submitlogin();" type="Submit" name="loginBtn" id="loginBtn"> Login</button>
			</p>
		</form>
                     <ul><li><strong><a onclick="loadhelp();" >HELP!</a></strong></li></ul>
    	</section>
    </div>
   
   
   
   
   
   
   
   
   
   </div>
   
   
   
   
   
   
   
   
   </div>     
	

					
		
		<!-- Sticky Footer -->
		<div id="footer">
	      	<div class="wrap">
	      		<p>Nalin Costa</p>
	      	</div>
	    </div>
		
	</div>
	
	<!-- Cubiq iScroll -->
	<!--[if gte IE 9]><!-->
	<script src="theme/scripts/cubiq-iscroll/src/iscroll.js"></script>
	
	<script type="text/javascript">
	var scrollers = [];
	var mainYScroller;
	
	$(function()
	{
		//document.addEventListener('touchmove', function(e){ e.preventDefault(); });
		var xScrollers = document.getElementsByClassName("scroll-x");
	    for (var i = 0; i < xScrollers.length; i++)
			scrollers.push(new iScroll(xScrollers[i], { 
				vScroll: false, 
				hideScrollbar: true,
				onBeforeScrollStart: function (e) {
					var target = e.target;
					while (target.nodeType != 1) target = target.parentNode;

					if (target.tagName != 'SELECT' && target.tagName != 'INPUT' && target.tagName != 'TEXTAREA')
						e.preventDefault();
				} 
			}));

		var yScrollers = $('.scroll-y').not('#mainYScroller');
	    $.each(yScrollers, function(i,v)
		{
	    	var scroller = new iScroll($(v).attr('id'),
	    	{
		    	hScroll: false, 
		    	hideScrollbar: true,
		    	onBeforeScrollStart: function (e) 
		    	{
					var target = e.target;
					while (target.nodeType != 1) target = target.parentNode;
					
					if (target.tagName != 'SELECT' && 
						target.tagName != 'INPUT' && 
						target.tagName != 'TEXTAREA' &&
						$(target).parents('table-responsive').size() == 0)
						e.preventDefault();
				}
		    });
	    	scrollers.push(scroller);
		});

	    mainYScroller = new iScroll('mainYScroller',
    	{
	    	zoom: true,
	    	hScroll: false, 
	    	hideScrollbar: true,
	    	onBeforeScrollStart: function (e) 
	    	{
				var target = e.target;
				while (target.nodeType != 1) target = target.parentNode;

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
					e.preventDefault();
			},
			onScrollEnd: function()
			{
				//if (mainYScroller.enabled == false) mainYScroller.enable();
			}
	    });
	    scrollers['mainYScroller'] = mainYScroller;
	});
	</script>
	<!--<![endif]-->
	
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
	
	
	<!--<script type="text/javascript" src="https://www.google.com/jsapi"></script>-->

	<!--  Flot (Charts) JS -->
	<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="theme/scripts/flot/excanvas.min.js"></script><![endif]-->
	<script src="theme/scripts/flot/jquery.flot.js" type="text/javascript"></script>
	<script src="theme/scripts/flot/jquery.flot.pie.js" type="text/javascript"></script>
	<script src="theme/scripts/flot/jquery.flot.tooltip.js" type="text/javascript"></script>
	<script src="theme/scripts/flot/jquery.flot.selection.js"></script>
	<script src="theme/scripts/flot/jquery.flot.resize.js" type="text/javascript"></script>
	<script src="theme/scripts/flot/jquery.flot.orderBars.js" type="text/javascript"></script>
	
		
	<script>
	var charts = 
	{
		// init all charts
		init: function()
		{
						// mark weekends on the website traffic main graph
			this.website_traffic_graph.options.markings = this.utility.weekendAreas;

			// init website traffic main graph
			this.website_traffic_graph.init();

			// init website traffic toolbar
			this.utility.website_traffic_toolbar();

			// init website traffic overview graph
			this.website_traffic_overview.init();

			// connect website traffic graphs
			this.utility.website_traffic_connect();

			// init traffic sources pie
			this.traffic_sources_pie.init();
											},

		// utility class
		utility:
		{
			chartColors: [ "#da4c4c", "#444", "#777", "#999", "#DDD", "#EEE" ],
			chartBackgroundColors: ["#fff", "#fff"],

			applyStyle: function(that)
			{
				that.options.colors = charts.utility.chartColors;
				that.options.grid.backgroundColor = { colors: charts.utility.chartBackgroundColors };
				that.options.grid.borderColor = charts.utility.chartColors[0];
				that.options.grid.color = charts.utility.chartColors[0];
			},
			
						// connect website_traffic_graph with website_traffic_overview
			website_traffic_connect: function()
			{
				$("#placeholder").bind("plotselected", function (event, ranges) 
				{
			        // do the zooming // rewrite chart object
			        charts.website_traffic_graph.plot = $.plot(
						$("#placeholder"), 
						[{ data: charts.website_traffic_graph.d1, label: "Visitors" }, { data: charts.website_traffic_graph.d2, label: "Conversions" }],
						$.extend(true, {}, charts.website_traffic_graph.options, {
			            	xaxis: { min: ranges.xaxis.from, max: ranges.xaxis.to }
						})
					);

			        // don't fire event on the overview to prevent eternal loop
			        charts.website_traffic_overview.plot.setSelection(ranges, true);

			     	// enable website traffic clear selection button
			    	$('#websiteTrafficClear').prop('disabled', false);
			    });
			    
			    $("#overview").bind("plotselected", function (event, ranges) 
				{
					// set selection
			    	charts.website_traffic_graph.plot.setSelection(ranges);

			    	// enable website traffic clear selection button
			    	$('#websiteTrafficClear').prop('disabled', false);
			    });
			},

			website_traffic_toolbar: function()
			{
				// clear selection button
				$("#websiteTrafficClear").click(function()
				{
					charts.utility.website_traffic_clear();
				});

				// last 24 hours button
				$('#websiteTraffic24Hours').click(function()
				{
					charts.website_traffic_graph.plot.setSelection(
					{
						xaxis: 
						{
							from: 1358640000000,
							to: 1358726400000						}
					});
				});

				// last 7 days button
				$('#websiteTraffic7Days').click(function()
				{
					charts.website_traffic_graph.plot.setSelection(
					{
						xaxis: 
						{
							from: 1358121600000,
							to: 1358726400000						}
					});
				});

				// last 14 days button
				$('#websiteTraffic14Days').click(function()
				{
					charts.website_traffic_graph.plot.setSelection(
					{
						xaxis: 
						{
							from: 1357516800000,
							to: 1358726400000						}
					});
				});
			},
			
			// clear selection on website traffic charts
			website_traffic_clear: function()
			{
				// disable clear button
				$('#websiteTrafficClear').prop('disabled', true);
				
				// clear selection on website traffic main chart / rewrite chart object
				charts.website_traffic_graph.plot = $.plot(
					$("#placeholder"), 
					[{ data: charts.website_traffic_graph.d1, label: "Visitors" }, { data: charts.website_traffic_graph.d2, label: "Conversions" }],
					charts.website_traffic_graph.options
				);

				// clear selection on website traffic overview chart
				charts.website_traffic_overview.plot.clearSelection();
			},
			
			// helper for returning the weekends in a period
			weekendAreas: function(axes)
			{
				var markings = [];
		        var d = new Date(axes.xaxis.min);
		        // go to the first Saturday
		        d.setUTCDate(d.getUTCDate() - ((d.getUTCDay() + 1) % 7))
		        d.setUTCSeconds(0);
		        d.setUTCMinutes(0);
		        d.setUTCHours(0);
		        var i = d.getTime();
		        do {
		            // when we don't set yaxis, the rectangle automatically
		            // extends to infinity upwards and downwards
		            markings.push({ xaxis: { from: i, to: i + 2 * 24 * 60 * 60 * 1000 } });
		            i += 7 * 24 * 60 * 60 * 1000;
		        } while (i < axes.xaxis.max);
		
		        return markings;
			},
						
			// generate random number for charts
			randNum: function()
			{
				return (Math.floor( Math.random()* (1+40-20) ) ) + 20;
			}
		},

				// main website traffic chart
		website_traffic_graph:
		{
			// data
			d1: [[1356220800000, 3438],[1356307200000, 2777],[1356393600000, 3527],[1356480000000, 2879],[1356566400000, 3129],[1356652800000, 3786],[1356739200000, 2351],[1356825600000, 3936],[1356912000000, 2710],[1356998400000, 3313],[1357084800000, 3100],[1357171200000, 3128],[1357257600000, 3156],[1357344000000, 3805],[1357430400000, 3708],[1357516800000, 3426],[1357603200000, 3259],[1357689600000, 3645],[1357776000000, 3095],[1357862400000, 3119],[1357948800000, 2829],[1358035200000, 2733],[1358121600000, 3844],[1358208000000, 2981],[1358294400000, 3772],[1358380800000, 3380],[1358467200000, 3192],[1358553600000, 3925],[1358640000000, 3683],[1358726400000, 3440]],
			d2: [[1356220800000, 677],[1356307200000, 541],[1356393600000, 539],[1356480000000, 588],[1356566400000, 435],[1356652800000, 681],[1356739200000, 509],[1356825600000, 493],[1356912000000, 630],[1356998400000, 494],[1357084800000, 630],[1357171200000, 638],[1357257600000, 413],[1357344000000, 669],[1357430400000, 460],[1357516800000, 689],[1357603200000, 525],[1357689600000, 684],[1357776000000, 559],[1357862400000, 612],[1357948800000, 421],[1358035200000, 576],[1358121600000, 421],[1358208000000, 563],[1358294400000, 489],[1358380800000, 636],[1358467200000, 645],[1358553600000, 494],[1358640000000, 509],[1358726400000, 439]],

			// will hold the chart object
			plot: null,
			
			// chart options
			options:
			{
		        xaxis: { mode: "time", tickLength: 5 },
		        selection: { mode: "x" },
		        grid: { 
			        markingsColor: "rgba(0,0,0, 0.02)",
			        backgroundColor : { },
					borderColor : "#f1f1f1",
					borderWidth: 1,
					color : "#DA4C4C",
					hoverable : true,
					clickable: true
			    },
		        series : {
					lines : {
						show : true,
						fill: true
					},
					points : {
						show : true
					}
				},
				colors: [],
				tooltip: true,
				tooltipOpts: {
					content: "%x: <strong>%y %s</strong>",
					dateFormat: "%y-%0m-%0d",
					shifts: {
						x: 10,
						y: 20
					},
					defaultTheme: false
				},
				legend: {
			        show: true,
			        noColumns: 2
			    }
		    },

		 	// initialize
			init: function()
			{
				// apply styling
				charts.utility.applyStyle(this);
				
				// first correct the timestamps - they are recorded as the daily
			    // midnights in UTC+0100, but Flot always displays dates in UTC
			    // so we have to add one hour to hit the midnights in the plot
			    for (var i = 0; i < this.d1.length; ++i)
			    {
			    	this.d1[i][0] += 60 * 60 * 1000;
			    	this.d2[i][0] += 60 * 60 * 1000;
			    }

				// create the chart object
			    this.plot = $.plot(
					$("#placeholder"), 
					[{ data: this.d1, label: "Visitors" }, { data: this.d2, label: "Conversions" }], 
					this.options
				);
			}
		},

		// website traffic overview chart
		website_traffic_overview: 
		{
			// data
			d1: [[1356220800000, 3438],[1356307200000, 2777],[1356393600000, 3527],[1356480000000, 2879],[1356566400000, 3129],[1356652800000, 3786],[1356739200000, 2351],[1356825600000, 3936],[1356912000000, 2710],[1356998400000, 3313],[1357084800000, 3100],[1357171200000, 3128],[1357257600000, 3156],[1357344000000, 3805],[1357430400000, 3708],[1357516800000, 3426],[1357603200000, 3259],[1357689600000, 3645],[1357776000000, 3095],[1357862400000, 3119],[1357948800000, 2829],[1358035200000, 2733],[1358121600000, 3844],[1358208000000, 2981],[1358294400000, 3772],[1358380800000, 3380],[1358467200000, 3192],[1358553600000, 3925],[1358640000000, 3683],[1358726400000, 3440]],
			d2: [[1356220800000, 677],[1356307200000, 541],[1356393600000, 539],[1356480000000, 588],[1356566400000, 435],[1356652800000, 681],[1356739200000, 509],[1356825600000, 493],[1356912000000, 630],[1356998400000, 494],[1357084800000, 630],[1357171200000, 638],[1357257600000, 413],[1357344000000, 669],[1357430400000, 460],[1357516800000, 689],[1357603200000, 525],[1357689600000, 684],[1357776000000, 559],[1357862400000, 612],[1357948800000, 421],[1358035200000, 576],[1358121600000, 421],[1358208000000, 563],[1358294400000, 489],[1358380800000, 636],[1358467200000, 645],[1358553600000, 494],[1358640000000, 509],[1358726400000, 439]],

			// will hold the chart object
			plot: null,

			// chart options
			options: 
			{
		        series: {
		            bars: {
						show: true,
	                    lineWidth: 10,
	                    align: "left"
					},
	                shadowSize: 0
		        },
		        xaxis: { ticks: [], mode: "time" },
		        yaxis: { ticks: [], min: 0, autoscaleMargin: 0.1 },
		        selection: { mode: "x" },
		        grid: {
		        	borderColor : "#DA4C4C",
		        	borderWidth: 1,
		        	minBorderMargin: 0,
		        	axisMargin: 0,
		        	labelMargin: 0,
		        	margin: 0,
		        	backgroundColor : {}
			    },
			    colors: [],
			    legend: {
			        show: false
			    }
		    },

			// initialize
			init: function()
			{
				// apply styling
				charts.utility.applyStyle(this);
				
				// first correct the timestamps - they are recorded as the daily
			    // midnights in UTC+0100, but Flot always displays dates in UTC
			    // so we have to add one hour to hit the midnights in the plot
			    for (var i = 0; i < this.d1.length; ++i)
			    {
			    	this.d1[i][0] += 60 * 60 * 1000;
			    	this.d2[i][0] += 60 * 60 * 1000;
			    }

			    // create chart object
			    this.plot = $.plot(
					$("#overview"), 
					[{ data: this.d1, label: "Visitors" }, { data: this.d2, label: "Conversions" }], 
					this.options
				);
			}
		},

		traffic_sources_pie: 
		{
			// data
			data: [
				{ label: "organic",  data: 60 },
				{ label: "direct",  data: 22.1 },
				{ label: "referral",  data: 16.9 },
				{ label: "cpc",  data: 1 }
			],
			
			// chart object
			plot: null,
			
			// chart options
			options: {
				series: {
		            pie: {
		                show: true,
		                redraw: true,
		                radius: 1,
		                tilt: 0.6,
		                label: {
		                    show: true,
		                    radius: 1,
		                    formatter: function(label, series){
		                        return '<div style="font-size:8pt;text-align:center;padding:5px;color:#fff;">'+Math.round(series.percent)+'%</div>';
		                    },
		                    background: { opacity: 0.8 }
		                }
		            }
		        },
		        legend: {
		            show: true
		        },
		        colors: [],
		        grid: { hoverable: true },
		        tooltip: true,
				tooltipOpts: {
					content: "<strong>%y% %s</strong>",
					dateFormat: "%y-%0m-%0d",
					shifts: {
						x: 10,
						y: 20
					},
					defaultTheme: false
				}
			},
			
			// initialize
			init: function()
			{
				// apply styling
				charts.utility.applyStyle(this);
				
				this.plot = $.plot($("#pie"), this.data, this.options);
			}
		},

		// traffic sources dataTables
		// we are now using Google Charts instead of Flot
		traffic_sources_dataTables:
		{
			// tables data
			data: 
			{
				tableSources:  
				{
					data: null,
					init: function()
					{
						var data = new google.visualization.DataTable();
				        data.addColumn('string', 'Source');
				        data.addColumn('string', 'Medium');
				        data.addColumn('number', 'Visits');
				        data.addColumn('number', 'Pg.Views');
				        data.addColumn('string', 'avg.time');

				        data.addRows(7);
				        data.setCell(0, 0, 'google', null, {'style': 'text-align: center;'});
				        data.setCell(0, 1, 'organic', null, {'style': 'text-align: center;'});
				        data.setCell(0, 2, 89, null, {'style': 'text-align: center;'});
				        data.setCell(0, 3, 299, null, {'style': 'text-align: center;'});
				        data.setCell(0, 4, '00:01:48', null, {'style': 'text-align: center;'});
				        data.setCell(1, 0, '(direct)', null, {'style': 'text-align: center;'});
				        data.setCell(1, 1, '(none)', null, {'style': 'text-align: center;'});
				        data.setCell(1, 2, 14, null, {'style': 'text-align: center;'});
				        data.setCell(1, 3, 34, null, {'style': 'text-align: center;'});
				        data.setCell(1, 4, '00:03:15', null, {'style': 'text-align: center;'});
				        data.setCell(2, 0, 'yahoo', null, {'style': 'text-align: center;'});
				        data.setCell(2, 1, 'organic', null, {'style': 'text-align: center;'});
				        data.setCell(2, 2, 3, null, {'style': 'text-align: center;'});
				        data.setCell(2, 3, 3, null, {'style': 'text-align: center;'});
				        data.setCell(2, 4, '00:00:00', null, {'style': 'text-align: center;'});
				        data.setCell(3, 0, 'ask', null, {'style': 'text-align: center;'});
				        data.setCell(3, 1, 'organic', null, {'style': 'text-align: center;'});
				        data.setCell(3, 2, 1, null, {'style': 'text-align: center;'});
				        data.setCell(3, 3, 3, null, {'style': 'text-align: center;'});
				        data.setCell(3, 4, '00:01:34', null, {'style': 'text-align: center;'});
				        data.setCell(4, 0, 'bing', null, {'style': 'text-align: center;'});
				        data.setCell(4, 1, 'organic', null, {'style': 'text-align: center;'});
				        data.setCell(4, 2, 1, null, {'style': 'text-align: center;'});
				        data.setCell(4, 3, 1, null, {'style': 'text-align: center;'});
				        data.setCell(4, 4, '00:00:00', null, {'style': 'text-align: center;'});
				        data.setCell(5, 0, 'conduit', null, {'style': 'text-align: center;'});
				        data.setCell(5, 1, 'organic', null, {'style': 'text-align: center;'});
				        data.setCell(5, 2, 1, null, {'style': 'text-align: center;'});
				        data.setCell(5, 3, 1, null, {'style': 'text-align: center;'});
				        data.setCell(5, 4, '00:00:00', null, {'style': 'text-align: center;'});
				        data.setCell(6, 0, 'google', null, {'style': 'text-align: center;'});
				        data.setCell(6, 1, 'cpc', null, {'style': 'text-align: center;'});
				        data.setCell(6, 2, 1, null, {'style': 'text-align: center;'});
				        data.setCell(6, 3, 1, null, {'style': 'text-align: center;'});
				        data.setCell(6, 4, '00:00:00', null, {'style': 'text-align: center;'});

				        this.data = data;
				        return data;
					}
				},
				tableReffering:
				{
					data: null,
					init: function()
					{
						var data = new google.visualization.DataTable();
						data.addColumn('string', 'Source');
				        data.addColumn('number', 'Pg.Views');
				        data.addColumn('string', 'avg.time');
				        data.addColumn('string', 'Exits');
				        
						data.addRows(6);
						data.setCell(0, 0, 'google.ro');
						data.setCell(0, 1, 14, null, {'style': 'text-align: center;'});
						data.setCell(0, 2, '00:05:51', null, {'style': 'text-align: center;'});
						data.setCell(0, 3, '3', null, {'style': 'text-align: center;'});
						data.setCell(1, 0, 'search.sweetim.com');
						data.setCell(1, 1, 5, null, {'style': 'text-align: center;'});
						data.setCell(1, 2, '00:03:29', null, {'style': 'text-align: center;'});
						data.setCell(1, 3, '1', null, {'style': 'text-align: center;'});
						data.setCell(2, 0, 'start.funmoods.com');
						data.setCell(2, 1, 5, null, {'style': 'text-align: center;'});
						data.setCell(2, 2, '00:01:02', null, {'style': 'text-align: center;'});
						data.setCell(2, 3, '1', null, {'style': 'text-align: center;'});
						data.setCell(3, 0, 'google.md');
						data.setCell(3, 1, 2, null, {'style': 'text-align: center;'});
						data.setCell(3, 2, '00:03:56', null, {'style': 'text-align: center;'});
						data.setCell(3, 3, '1', null, {'style': 'text-align: center;'});
						data.setCell(4, 0, 'searchmobileonline.com');
						data.setCell(4, 1, 2, null, {'style': 'text-align: center;'});
						data.setCell(4, 2, '00:02:21', null, {'style': 'text-align: center;'});
						data.setCell(4, 3, '1', null, {'style': 'text-align: center;'});
						data.setCell(5, 0, 'google.com');
						data.setCell(5, 1, 1, null, {'style': 'text-align: center;'});
						data.setCell(5, 2, '00:00:00', null, {'style': 'text-align: center;'});
						data.setCell(5, 3, '1', null, {'style': 'text-align: center;'});
						
						this.data = data;
						return data;
					}
				}
			},
			
			// chart
			chart: 
			{
				tableSources: null,
				tableReffering: null
			},
			
			// options
			options: 
			{
				tableSources: 
				{
					page: 'enable',
					pageSize: 6,
					allowHtml: true,
					cssClassNames: {
						headerRow: 'tableHeaderRow',
						tableRow: 'tableRow',
						selectedTableRow: 'selectedTableRow',
						hoverTableRow: 'hoverTableRow'
					},
					width: '100%',
					alternatingRowStyle: false,
					pagingSymbols: { prev: '<span class="btn btn-inverse">prev</btn>', next: '<span class="btn btn-inverse">next</span>' }
				},
				
				tableReffering:
				{
					page: 'enable',
					pageSize: 6,
					allowHtml: true,
					cssClassNames: {
						headerRow: 'tableHeaderRow',
						tableRow: 'tableRow',
						selectedTableRow: 'selectedTableRow',
						hoverTableRow: 'hoverTableRow'
					},
					width: '100%',
					alternatingRowStyle: false,
					pagingSymbols: { prev: '<span class="btn btn-inverse">prev</btn>', next: '<span class="btn btn-inverse">next</span>' }
				}
			},
			
			// initialize
			init: function()
			{
				// data
				charts.traffic_sources_dataTables.data.tableSources.init();
				charts.traffic_sources_dataTables.data.tableReffering.init();
				
				// charts
				charts.traffic_sources_dataTables.drawTableSources();
				charts.traffic_sources_dataTables.drawTableReffering();
			},

			// draw Traffic Sources Table
			drawTableSources: function()
			{
				this.chart.tableSources = new google.visualization.Table(document.getElementById('dataTableSources'));
				this.chart.tableSources.draw(this.data.tableSources.data, this.options.tableSources);
			},

			// draw Refferals Table
			drawTableReffering: function()
			{
				this.chart.tableReffering = new google.visualization.Table(document.getElementById('dataTableReffering'));
				this.chart.tableReffering.draw(this.data.tableReffering.data, this.options.tableReffering);
			}
		}
							};

	$(function()
	{
		// initialize charts
		charts.init();
	});
	</script>
	
	
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
	
	<script>
	//Load the Visualization API and the piechart package.
	google.load('visualization', '1.0', {'packages':['table', 'corechart']});
	
	// Set a callback to run when the Google Visualization API is loaded.
	google.setOnLoadCallback(charts.traffic_sources_dataTables.init);
	</script>

</body>
</html>