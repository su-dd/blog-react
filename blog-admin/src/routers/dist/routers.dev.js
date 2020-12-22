"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports["default"] = void 0;

var _routerConfig = require("@/routers/routerConfig");

var routerConfig = [];
routerConfig.push(_routerConfig.homeRouterConfig);
routerConfig.push(_routerConfig.articleManageConfig);
routerConfig.push(_routerConfig.userManageConfig);
routerConfig.push(_routerConfig.markManageConfig);
routerConfig.push(_routerConfig.seriesManageConfig);
var _default = routerConfig;
exports["default"] = _default;