# Token

@(Token)(JWT)(HTTPS)

### 什么是token

Token是服务端生成的一串字符串，以作客户端进行请求的一个令牌，服务端根据令牌获取客户端的身份信息。

### 为什么要用token

互联网时代信息安全验证放在首要的地位，对于敏感的信息（如账号密码等等）明文的出现次数越少越好。

我都知道，HTTP协议是一种无状态的协议，这就意味着当我们向应用服务端提供了用户名和密码进行用户认真后，下次请求还是要再进行用户认证，而且服务端又不知道发起请求是谁。按照这个思维，假如每个请求都带有敏感信息，即使进行加密，但是这就增加暴露频率，并且服务端频繁对每个请求的身份信息进行数据查询验证，这是个很大的开销，显然不是我们想要的结果。

为了我们登录后让服务端“记住”我，下次发出请求服务端识别哪个用户发送的，这时token令牌就能解决http无状态的问题，这时候你会觉得SESSION不也一样吗？别急，下面会说到。token就像我们的身份证，客户端一旦得到服务端响应的token后本地缓存，之后每次请求带上token就行了，重要的是开发者可以在token上自定义信息（如UUID），并且是加密的，服务端就减少数据查询验证身份的开销了。

### 与传统的SESSION有什么区别

如果您还不了解session，请先自行百度学习，这里我简单介绍下：

> session 是一种HTTP存储机制，目的是为无状态的HTTP提供的持久机制。

*   session只提供一种简单的认证ID，即JSESSIONID，用户数据只保存在服务端上，因此JSESSIONID尤为重要需要严格保密，这导致了session的弊端：如果web服务器做了负载均衡，那么下一个操作请求到了另一台服务器的时候session会丢失。
*   session：用户数据保存在服务端；token：数据可以保存在自身上或者服务端。
*   session更加适合在浏览器上应用，对于开发API接口token是不错的选择。
*   一旦服务器挂了sessionid在服务端内存中映射信息丢失了，token具有自带性，状态还存在。
*   token安全性好，有签名能防止信息篡改、监听、重放攻击。
*   token能进行授权操作，session不可以。

### token身份验证流程

*   客户端使用用户名和密码请求登录验证
*   服务端接受请求，进行身份验证
*   验证成功后，服务端会签发一个 Token，再把这个 Token 发送给客户端
*   客户端收到 Token 后把它存起来
*   客户端每次向服务端请求时候就带上 Token
*   服务端收到 Token 后，去验证 Token ，如果验证通过，执行业务逻辑

通过这下面这个图片加深您对 Token 流程的理解吧

### 服务端中跟Token有关的问题

*   或许你们会想到，Token具有自带性，用户的在线状态不可能存在Token中，那怎么知道用户是否在线呢？
其实服务端中每个Token可以与UUID形成映射对存储在服务器上面，当用户注销操作时，删除UUID与Token的键值对，所以查询不到表示下线了
*   如何存查删 Token ？
我们可以把Token信息缓存在内存中，比存在数据库中的好处是读取速度快，开销小，坏处是一旦断点数据全没了，不过token重新认证操作获取就有一个了。基于缓存内存中，memcached、redis，KV方式很适合对token查询的需求。

# JWT(Json Web Token)

### 官网地址：**[https://jwt.io/](https://jwt.io/)**

### jwt github：**[https://github.com/jwtk/jjwt](https://github.com/jwtk/jjwt)**

### 什么是JWT(Json Web Token)

> Json web token (JWT), 是为了在网络应用环境间传递声明而执行的一种基于JSON的开放标准。该token被设计为紧凑且安全的，特别适用于分布式站点的单点登录（SSO）场景。JWT的声明一般被用来在身份提供者和服务提供者间传递被认证的用户身份信息，以便于从资源服务器获取资源，也可以增加一些额外的其它业务逻辑所必须的声明信息，该token也可直接被用于认证，也可被加密。也就是说JWT是Token的一种表述性声明规范。
> 
> 如果你不清楚JSON请自行学习

### JWT长什么样子

> eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI3OHNhd2RmZjUiLCJzdWIiOiJ4aWFvdGlhbnRpYW4iLCJpYXQiOjE0OTgwMzE0NDIsImlzcyI6IjEyMi4xMTQuMjE0LjE0NyIsImV4cCI6MTQ5ODAzMjY0Mn0.0h_kDhyZLhnt8TRgbLsOnVT8eOUAqgFTEZP-XgIGuA

### JWT的结构

JWT包含了三个部分，分别用`.`分割开来，分别是：

*   Header 头部
*   Payload 负载
*   Signature 签名

### Header 头部

header 头部定义了两个

# HTTPS(未完成)

*   ### SSL

在网络层面上token明文传输的话会非常的危险，所以建议一定要使用HTTPS，并且把token放在post body里。