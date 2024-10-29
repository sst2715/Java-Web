# Web 应用开发应知应会

## 目录结构
- **动态资源**与**静态资源**
    - 动态资源：根据请求生成的内容，如用户个人主页。
    - 静态资源：存储在服务器的固定内容，如 HTML 文件。

- **常用 Java EE 服务器**
    - Apache Tomcat
    - JBoss/WildFly
    - GlassFish
    - WebLogic

- **Tomcat 部署项目方式**
    - WAR 包部署
    - 解压部署
    - 使用管理界面部署

- **Tomcat 目录结构**
    - `bin`: 启动、关闭脚本
    - `conf`: 配置文件
    - `logs`: 日志文件
    - `webapps`: 部署应用目录
    - `work`: 编译的 JSP 文件

## Servlet
- **Servlet**：服务器端 Java 组件，用于处理 HTTP 请求。
- **执行原理**：
    1. 客户端请求到达服务器。
    2. 服务器定位并调用 Servlet。
    3. Servlet 处理请求并返回响应。

### Servlet 生命周期
- **方法**：
    - `init()`: 初始化 Servlet。
    - `service()`: 处理请求。
    - `destroy()`: 清理资源。

## HTTP & Request
- **无状态性**：每个请求独立，服务器不保存状态。
- **请求行示例**：`GET /index.html HTTP/1.1`
- **常用请求头**：
    - `User-Agent`: 浏览器信息
    - `Accept`: 可接受的内容类型

### Request 原理
- 使用 `HttpServletRequest` 对象获取请求信息。
- 常用 API：`getHeader()`, `getParameter()`。

### 中文乱码处理
- 使用 `request.setCharacterEncoding("UTF-8")`。

### 转发与重定向
- 转发：`RequestDispatcher.forward()`
- 重定向：`response.sendRedirect()`

## Response
- **HTTP 响应格式**：状态行 + 响应头 + 响应体。
- **常用响应头**：`Content-Type`, `Cache-Control`。
- **Response 对象的作用**：生成并返回 HTTP 响应。

## Cookie & Session
- **会话管理技术**：用于跟踪用户会话状态。
- **Cookie 操作步骤**：创建、发送、接收、删除。
- **Session 实现原理**：存储在服务器，通过 Session ID 识别用户。

## AJAX
- **定义**：异步 JavaScript 和 XML，允许异步请求。
- **优缺点**：
    - 优点：提升用户体验，减少页面刷新。
    - 缺点：兼容性问题，调试复杂。

### XMLHttpRequest
- **目的**：与服务器进行异步交互。
- **主要属性和方法**：`readyState`, `status`, `open()`, `send()`。

## Filter & Listener
- **三大组件**：Servlet、JSP、Filter。
- **Filter 生命周期**：
    - 初始化
    - 处理请求
    - 销毁

### 在线用户监听
- 使用 `HttpSessionListener` 实现用户登录状态的监听。

## 贡献
欢迎对本项目进行贡献和反馈！

## 许可证
该项目遵循 MIT 许可证。
