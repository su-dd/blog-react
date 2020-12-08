import React from "react";
import { Menu } from "antd";
import { Link } from "react-router-dom";

import {
  homeRouterConfig, 
  articleManageConfig, 
  userManageConfig, 
  markManageConfig,
  seriesManageConfig
} from "@/routers/routerConfig";

const BlogMenu = () => {
    return (
    <Menu theme="dark" mode="inline" defaultSelectedKeys={['1']}>
        <Menu.Item key="1">
          <Link to={homeRouterConfig.path}>主页</Link>
        </Menu.Item>
        <Menu.Item key="2">
          <Link to={userManageConfig.path}>用户管理</Link>
        </Menu.Item>
        <Menu.Item key="3">
          <Link to={seriesManageConfig.path}>系列管理</Link>
        </Menu.Item>
        <Menu.Item key="4">
          <Link to={markManageConfig.path}>标记管理</Link>
        </Menu.Item>
        <Menu.Item key="5">
          <Link to={articleManageConfig.path}>文章编辑</Link>
        </Menu.Item>
    </Menu>
    );
}

export default BlogMenu;