# My—RPC

## 基于Java原生BIO和动态代理的远程调用

RPC（远程过程调用），是一种计算机通信协议。它允许客户端的程序，通过网络远程调用另一台计算机的程序，并且程序员无需考虑这个交互过程。

RPC的基本原理：客户端和服务端都有一个公共的接口，而服务端有这个接口的实现类。 客户端需要远程调用这个接口，需要通过网络传输告诉服务器需要调用什么，而服务端根据客户端的请求调用这个接口的实现类，并将结果返回给客户端。



###  序列化接口参数

Java对象需要进行序列化的情况：

a）当你想把的内存中的对象保存到一个文件中或者数据库中时候；
b）当你想用[套接字](http://zhidao.baidu.com/search?word=套接字&fr=qb_search_exp&ie=utf8)在网络上传送对象的时候；
c）当你想通过RMI传输对象的时候；

对于公共接口，我们传递一个Java对象作为参数，它需要从客户端发送给服务端。 在网络传输的过程中，Java对象信息必须变成二进制流进行传输。因此我们将这个对象进行序列化，使用 `Serializable`接口。 



###  动态代理

**动态代理就是通过运行时加载到内存的被代理类，动态的创建一个代理类及其对象。 通过代理类调用被代理类的同名方法**

## 使用netty实现网络传输，并使用json进行简单序列化

### netty的简单介绍

netty是一个异步的、事件驱动的网络应用程序开源框架。 它是基于NIO的，封装了Java的NIO。
netty是同步非阻塞的， 由主从Reactor多线程模型改进而来的。

### 为什么说Netty性能高
-  IO线程模型：同步非阻塞， 基于Reactor模式实现的，解决了传统同步阻塞IO多个客户端带来的问题。 可以充分利用资源做更多的事。

-  高性能序列化协议：用户Netty可以自定义编解码的协议，也可以实现很多的高性能的协议，比如可以使用Google Protobuf进行序列化。

-  实现内存零拷贝。1.Netty 的接收和发送 ByteBuffer 采用 DIRECT BUFFERS，使用堆外直接内存进行 Socket 读写，不需要进行字节缓冲区的二次拷贝。如果使用传统的堆内存（HEAP BUFFERS）进行 Socket 读写，JVM 会将堆内存 Buffer 拷贝一份到直接内存中，然后才写入 Socket 中。相比于堆外直接内存，消息在发送过程中多了一次缓冲区的内存拷贝。
   2.Netty 的文件传输采用了 transferTo 方法，它可以直接将文件缓冲区的数据发送到目标 Channel，避免了传统通过循环 write 方式导致的内存拷贝问题。


