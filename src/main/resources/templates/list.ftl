<!DOCTYPE html>
<html>
    <head>
        <title>List</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/style.css" />
        </head>
    <body>
        <h2>Plassering og tilstand av bysykler på sykkelstativer</h2>
        
        <table>
            <tr> 
                <th>Sykkelstativ</th>  
                <th>Tilgjenlig Låser</th>
                <th>Ledige Sykler</th>
            </tr>        

            <#list stations as station>
            	<#list availabilities as available>
            		<#if station.id == available.id>
                <tr>
                    <td>${station.title}</td>
                    <td>${available.bikes}</td> 
                    <td>${available.locks}</td>
                </tr>
                  </#if>
               </#list>  
            </#list>        
        </table>               
    </body>
</html>