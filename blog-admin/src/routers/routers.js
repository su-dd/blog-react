import {
  homeRouterConfig, 
  articleManageConfig, 
  userManageConfig, 
  markManageConfig,
  seriesManageConfig
} from "@/routers/routerConfig";

let routerConfig = [];

routerConfig.push(homeRouterConfig);
routerConfig.push(articleManageConfig);
routerConfig.push(userManageConfig);
routerConfig.push(markManageConfig);
routerConfig.push(seriesManageConfig);

export default routerConfig;