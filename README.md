<h2>RPC(Remote Procedure Call)学习实战项目</h2>
<h2>@desc: 仅用于个人学习、了解RPC</h2>
<h2>@date: 2021/01/11 周一</h2>
<hr/><br/>

<h3><b>技术组成：</b></h3>
<table>
    <thead>
        <tr>
            <td></td>
            <td>版本一</td>
            <td>版本二</td>
            <td>版本三</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>传输层</td>
            <td>Netty4</td>
            <td>*</td>
            <td>*</td>
        </tr>
        <tr>
            <td>编码层</td>
            <td>Kryo</td>
            <td>*</td>
            <td>*</td>
        </tr>
        <tr>
            <td>应用层</td>
            <td>JDK动态代理</td>
            <td>*</td>
            <td>*</td>
        </tr>
        <tr>
            <td>服务注册与发现</td>
            <td>手动注册+guava缓存</td>
            <td>注解+zookeeper</td>
            <td>*</td>
        </tr>
        <tr>
            <td>其他</td>
            <td>*</td>
            <td>*</td>
            <td>*</td>
        </tr>
    </tbody>
</table>