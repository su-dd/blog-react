

解决办法：

1、安装`http-proxy-middleware`

```
npm install http-proxy-middleware -S
```

2、在`src`目录下创建`setupProxy.js`,加入以下代码

```js
// 处理axios的跨域问题
const {createProxyMiddleware} = require('http-proxy-middleware');
module.exports = function (app) {
    app.use(createProxyMiddleware('/api', {
        target: "http://127.0.0.1:8080/",
        pathRewrite: {'^/api': ''},
        changeOrigin: true
    }));
};
```