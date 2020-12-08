const CracoLessPlugin = require("craco-less");
const path = require('path')
const pathResolve = pathUrl => path.join(__dirname, pathUrl)

module.exports = {
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
    }
  },
  babel: {
    plugins: [
      ['import', { libraryName: 'antd', style: true }],
      ["@babel/plugin-proposal-decorators", { legacy: true }],
    ]
  },
  plugins: [
    {
      plugin: CracoLessPlugin,
      options: {
        lessLoaderOptions: {
          lessOptions: {
            modifyVars: {
               '@primary-color': '#1DA57A',
               '@link-color': '#1DA57A',
               '@border-radius-base': '2px',
               '@heading-color': 'rgba(255, 255, 255, 0.85)', // 标题色
              },
            javascriptEnabled: true,
          },
        },
      },
    },
  ],
};