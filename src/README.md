#Java Socket应用

#####根据网络通信的不同层次，Java提供的网络功能有四大类

1. InetAddress：用于标记网络上的硬件资源。
   实际上用于标识IP地址相关的信息。
2. URL： 统一资源定位符，通过URL可以直接读取或者写入网络上的数据。
   由（协议名：资源名）的形式组成。Java中的net包提供了URL类来表示URL。
   URL的openStream()方法可以得到指定资源的输入流。
3. Sockets： 使用TCP协议十下网络通信的Socket相关的类。
   TCP协议是面向连接的，可靠有序的，以*字节流*的形式发送数据的。
   客户端的Socket类，服务端的ServerSocket类。
4. Datagram： 使用UDP协议，将数据保存在数据报中，通过网络进行通信。

