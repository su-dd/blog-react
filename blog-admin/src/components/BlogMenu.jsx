import React from "react";
import { Menu } from "antd";
import { Link } from "react-router-dom";

import {
  homeRoute, 
  articleManageRoute, 
  userManageRoute, 
  markManageRoute,
  seriesManageRoute
} from "@/routers/routers";

const BlogMenu = () => {
    return (
    <Menu theme="dark" mode="inline" defaultSelectedKeys={['1']}>
        <Menu.Item key="1">
          <Link to={homeRoute.path}>主页</Link>
        </Menu.Item>
        <Menu.Item key="2">
          <Link to={userManageRoute.path}>用户管理</Link>
        </Menu.Item>
        <Menu.Item key="3">
          <Link to={seriesManageRoute.path}>系列管理</Link>
        </Menu.Item>
        <Menu.Item key="4">
          <Link to={markManageRoute.path}>标记管理</Link>
        </Menu.Item>
        <Menu.Item key="5">
          <Link to={articleManageRoute.path}>文章编辑</Link>
        </Menu.Item>
    </Menu>
    );
}

export default BlogMenu;