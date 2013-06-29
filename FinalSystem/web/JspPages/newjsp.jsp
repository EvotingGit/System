<%-- 
    Document   : newjsp
    Created on : Jun 25, 2013, 10:01:10 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="../test" method="get">
            <table>
                <tr>
                 <td>
                         <div style="padding-bottom: 11px;"> 
                         <div class="fileupload fileupload-new" data-provides="fileupload">
			<div class="fileupload-new thumbnail" style="width: 200px; height: 150px;"><img src="http://www.placehold.it/200x150/EFEFEF/AAAAAA&text=no+image" /></div>
			<div class="fileupload-preview fileupload-exists thumbnail" style="max-width: 200px; max-height: 150px; line-height: 20px;"></div>
			<div>
			<span class="btn btn-file"><span class="fileupload-new">Select image</span><span class="fileupload-exists">Change</span>
                        <input type="file" name="image" /></span>
		    	<a href="#" class="btn fileupload-exists" data-dismiss="fileupload">Remove</a>
			</div>
			</div>
                      </div>
                    </td>
                </tr>
            </table>
            <input type="submit" value="click" />
            <input type="submit" value="view" />
        </form>
    </body>
</html>
