// 处理axios的跨域问题
const {createProxyMiddleware} = require('http-proxy-middleware');
module.exports = function (app) {
    app.use(createProxyMiddleware('/baidu', {
        target: "https://news.baidu.com/",
        pathRewrite: {'^/baidu': ''},
        changeOrigin: true
    }));
    app.use(createProxyMiddleware('/api', {
        target: "http://127.0.0.1:8080/",
        pathRewrite: {'^/api': ''},
        changeOrigin: true
    }));
};