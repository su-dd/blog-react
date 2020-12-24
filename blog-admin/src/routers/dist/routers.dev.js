"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.routers = void 0;

var _routerConfig = require("@/routers/routerConfig");

var routers = [].push(_routerConfig.homeRouterConfig).push(_routerConfig.articleManageConfig).push(_routerConfig.userManageConfig).push(_routerConfig.markManageConfig).push(_routerConfig.seriesManageConfig);
exports.routers = routers;