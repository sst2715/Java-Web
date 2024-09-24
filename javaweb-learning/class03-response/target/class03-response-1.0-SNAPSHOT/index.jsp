<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>响应不同类型的资源文件</title>
  <style>
    ul li{
      list-style: none;
      float:left;
      margin-top: 40px;
    }
     ul li a{
       padding: 20px 50px;
       height: 40px;
       background-color:darkblue;
       color: aliceblue;
       box-sizing: border-box;
       margin-right: 10px;
       font-size: 16px;
       text-decoration:none;
     }
     ul li a:hover{
       background: firebrick;;
     }
  </style>
</head>
<body>
<h1><%= "设置不同类型的资源" %></h1>
<h2><%= "返回不同类型的资源" %></h2>
<br/>
  <ul>
    <li>
      <a href="responseType?type=img">返回图片</a>
    </li>
    <li>
      <a href="responseType?type=pdf">返回pdf</a>
    </li>
    <li>
      <a href="responseType?type=mp4">返回mp4</a>
    </li>
    <li>
      <a href="responseType?type=word">返回word</a>
    </li>
    <li>
      <a href="responseType?type=json">返回json</a>
    </li>
    <li>
      <a href="responseType?type=html">返回html</a>
    </li>
    </ul>
</body>
</html>