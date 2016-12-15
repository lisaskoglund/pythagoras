<%-- 
    Document   : index
    Created on : 2016-dec-14, 16:19:02
    Author     : lisanoren
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="index.css"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Facilitate</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script>
            var $totArea = 0;
            $(document).ready(function () {
                $.get("http://localhost:8080/Pythagoras/rest/facilities", function (table, status) {
                    $("table.table").append(
                            "<tr><td><b>Namn</b></td><td><b>Area</b></td><td><b>Byggnadsnamn</b></td></tr>"
                            );
                    $.each(table, function (index, row) {
                        $("table.table").append(
                                "<tr><td>" + row.floorName + "</td><td>" + row.area + "</td><td>" + row.buildingName + "</td></tr>"
                                );
                        $totArea = $totArea + parseFloat(row.area);
                    });
                    $("table.table").append(
                            "<tr><td></td><td>" + $totArea + "</td></tr>");
                });
            });
        </script>
    </head>
    <table class="table">

    </table>
</html>
