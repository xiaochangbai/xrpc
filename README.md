## Introduce
 `XRPC(X Remote Procedure Call)`，Based on netty and high-performance RPC framework, it can be seamlessly integrated with spring framework


## Core Technology
- Transport Layer： Netty、Protobuf
- Application Layer： JDK Dynamic Agent
- Registration Center： Zookeeper


## TODO LIST：
* [ ] 优化Netty长连接，引入连接池。
* [ ] 代理层引入Cglib。
* [ ] 注册中心引入Nacos。
* [ ] 添加后台监控功能。



## Quick Start

首先需要安装 `Zookeeper` 并保证网络通畅，更多详情请参见`demo`项目。