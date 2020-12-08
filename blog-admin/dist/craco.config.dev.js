"use strict";

function _defineProperty(obj, key, value) { if (key in obj) { Object.defineProperty(obj, key, { value: value, enumerable: true, configurable: true, writable: true }); } else { obj[key] = value; } return obj; }

var CracoLessPlugin = require("craco-less");

var path = require('path');

var pathResolve = function pathResolve(pathUrl) {
  return path.join(__dirname, pathUrl);
};

var FastRefreshCracoPlugin = require('craco-fast-refresh');

module.exports = _defineProperty({
  webpack: {
    alias: {
      '@@': pathResolve('.'),
      '@': pathResolve('src'),
      '@assets': pathResolve('src/assets'),
      '@common': pathResolve('src/common'),
      '@components': pathResolve('src/components'),
      '@hooks': pathResolve('src/hooks'),
      '@pages': pathResolve('src/pages'),
      '@store': pathResolve('src/store'),
      '@utils': pathResolve('src/utils')
    },
    configure: function configure(webpackConfig, _ref) {
      var env = _ref.env,
          paths = _ref.paths;
      //ts和less编译后的文件
      webpackConfig.output.path = path.resolve(__dirname, "dist"); //public中的文件

      paths.appBuild = path.resolve(__dirname, "dist");
      return webpackConfig;
    }
  },
  babel: {
    plugins: [['import', {
      libraryName: 'antd',
      style: true
    }], ["@babel/plugin-proposal-decorators", {
      legacy: true
    }]]
  },
  plugins: [{
    plugin: FastRefreshCracoPlugin
  }]
}, "plugins", [{
  plugin: CracoLessPlugin,
  options: {
    lessLoaderOptions: {
      lessOptions: {
        modifyVars: {
          // 全局主色
          '@primary-color': '#1890ff',
          // 链接色
          '@link-color': '#1890ff',
          // 成功色
          '@success-color': '#52c41a',
          // 警告色
          '@warning-color': '#faad14',
          // 错误色
          '@error-color': '#f5222d',
          // 主字号
          '@font-size-base': '14px',
          // 标题色
          '@heading-color': 'rgba(0, 0, 0, 0.85)',
          // 主文本色
          '@text-color': 'rgba(0, 0, 0, 0.65)',
          // 次文本色
          '@text-color-secondary': 'rgba(0, 0, 0, 0.45)',
          // 失效色
          '@disabled-color': 'rgba(0, 0, 0, 0.25)',
          // 组件/浮层圆角
          '@border-radius-base': '2px',
          // 边框色
          '@border-color-base': '#d9d9d9',
          // 浮层阴影
          '@box-shadow-base': '0 3px 6px -4px rgba(0, 0, 0, 0.12), 0 6px 16px 0 rgba(0, 0, 0, 0.08),  0 9px 28px 8px rgba(0, 0, 0, 0.05)'
        },
        javascriptEnabled: true
      }
    }
  }
}]);