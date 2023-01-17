
 <!DOCTYPE html>   
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>


<html>

<head>
    <!-- <meta http-equiv="refresh" content="0, url =${pageContext.request.contextPath}/ServletControlador "> -->
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="./css/styles.css"/>
    <script> language ="JavaScript", type="text/javascript", src="cssScript.js" </script>
    

      <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous"/> 
      <script src="http://code.jquery.com/jquery-latest.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/4.1.2/chart.min.js" integrity="sha512-fYE9wAJg2PYbpJPxyGcuzDSiMuWJiw58rKa9MWQICkAqEO+xeJ5hg5qPihF8kqa7tbgJxsmgY0Yp51+IMrSEVg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <title>Document</title>
    <c:set var = "anno" value = "1997" scope="application"  /> 
    <c:set  var ="mees" value = "1"  scope="application"  />
    <c:set var = "proc" value = "2" scope = "application" />
   
</head>
<body>
    <%@ include file = 'enc.jsp' %>
    <div class="cont-all">
        <div class="cont-fechas"> 
        <div class="con_per">
         <div class="lbl-fech">
             <p>Periodo :</p>
         </div>
   
         <div class="fechas-sel" id="fechas-sel">
             <select name="sel_mesini" id="sel_mesini" class = "sel_mesini f-date" >
                 <option value="1">Ene</option>
                 <option value="2">Feb</option>
                 <option value="3">Mar</option>
                 <option value="4">Abr</option>
                 <option value="5">May</option>
                 <option value="6">Jun</option>
                 <option value="7">Jul</option>
                 <option value="8">Ago</option>
                 <option value="9">Sep</option>
                 <option value="10">Oct</option>
                 <option value="11">Nov</option>
                 <option value="12">Dic</option>
             </select>    
             <select name="sel_anoini" id="sel_anoini" class = "sel_anoini f-date" >
                 <option value="2006">2006</option>
                 <option value="2007">2007</option>
                 <option value="2008">2008</option>
                 <option value="2009">2009</option>
              </select>
             
                         
             <select name="sel_mesfin" id="sel_mesfin" class = "sel_mesfin f-date" >
                 <option value="1">Ene</option>
                 <option value="2">Feb</option>
                 <option value="3">Mar</option>
                 <option value="4">Abr</option>
                 <option value="5">May</option>
                 <option value="6">Jun</option>
                 <option value="7">Jul</option>
                 <option value="8">Ago</option>
                 <option value="9">Sep</option>
                 <option value="10">Oct</option>
                 <option value="11">Nov</option>
                 <option value="12">Dic</option>  
             </select>
             <select name="sel_anofin" id="sel_anofin" class = "sel_anofin f-date" >
                 
                 <option value="2006">2006</option>
                 <option value="2007">2007</option>
                 <option value="2008">2008</option>
                 <option value="2009">2009</option>
             </select>
         </div>
       </div>
     </div>
     <div class="cont">
         <div class="cont_fill" id="cont_fill">
             <div class="tag primero">
             <div class="lab-cons col-d">
                 <label>Consultores:</label>
              </div>
             </div>
             <div class="bxlis-all bxlis segundo" id="bxlis-all">
                 <select name="consults" id="list-cons" class="list" size="8" multiple>
                     <c:forEach items="${consultors}" var="consts" >
                         <option value= <c:out value="${consts.co_usuario}"/>>
                             <c:out value="${consts.no_usuario}"></c:out>
                         </option>
                     </c:forEach>
                 </select>
             </div>
             <div class="btn-addsub tercero ">
         
                 <button id = "btn_add" class="btn_add" onclick="move(1)">>></button><br>
                 <button id = "btn_rem" class="btn_rem" onclick="move(2)"> &lt&lt </button> 
             
            </div>
             <div class="bxlis-sel  bxlis cuarto " id="bxlis-sel" >
                 <select name="sel_consl" id="list_sel" class = "list" size="8" multiple></select>
             </div>
            
             <div class="btn-data col-d quinto" id="btn-data">
               <!-- <button class="btn btn-primary"><i class="bi bi-list-columns-reverse"></i>  Relatório</button> -->
                 <!-- 
                 <input type="submit" value="Gráfico " class="btn_graph btn_acc" id="btn_graph" disabled="">
                 <input type="submit" value="Pizza " class="btn_pizza btn_acc" id="btn_pizza" disabled=""> -->
                 <input type="submit" id="submit" value="Relatório" class="btn_relatorio btn_acc" >
                 <!-- <button  id="submit" class="btn_relatorio btn_acc bi bi bi-list-check"  >Relatório</button> -->
                 <button class="btn_graph btn_acc bi bi-bar-chart-fill" id="btn_graph" >Gráfico</button>
                 <button class="btn_pizza btn_acc bi bi-pie-chart-fill" id="btn_pizza"onclick="grafica()">Pizza</button>
              </div>       
             
         </div>  
     </div>
     <div class="dat-lis">
     <section class="link_data" id="link_data">
         <div class="tab_dat">
         <div class="sec-data" id="sec-data">
                
         </div>
         <div class="graf_dat"></div>
         </div>
       <canvas class="graf-pic" width="400" height="300"></canvas>
     </section> 
   </div>
  </div> 
</body>
<script src ="js/managedom" ></script>
</html>

