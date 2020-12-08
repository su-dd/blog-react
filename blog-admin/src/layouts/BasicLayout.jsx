import React, {useState, useEffect} from "react";
import { createBrowserHistory } from "history";

import BlogMenu from "@/components/BlogMenu";
import BlogHeader from "@/components/BlogHeader";
import routers from "@/routers/routers";

import {
  BrowserRouter,
  Switch,
  Route,
  Link
} from "react-router-dom";

import { Layout } from "antd";
const { Header, Footer, Sider, Content } = Layout;


const history = createBrowserHistory();

const BasicLayout = () => {

  const RouteWithSubRoutes = (route) => {
    return (
      <Route
        path={route.path}
        render={props => (
          // pass the sub-routes down to keep nesting
          <route.component {...props} routes={route.routes} />
        )}
      />
    );
  }

  return (
    <Layout>
      <BrowserRouter history={history}>
        <Sider
          breakpoint="lg"
          collapsedWidth="0"
          onBreakpoint={broken => {
            console.log(broken);
          }}
          onCollapse={(collapsed, type) => {
            console.log(collapsed, type);
          }}
        >
          <div className="logo" />
          <BlogMenu/>
        </Sider>
        <Layout>
          <Header className="site-layout-sub-header-background" style={{ padding: 0, background: '#fff' }}>
            <BlogHeader></BlogHeader>
          </Header>
          <Content style={{ margin: '24px 16px 0' }}>
            <div className="site-layout-background" style={{ padding: 24, minHeight: 360 }}>
              <Switch>
                {routers.map((route, i) => (
                  <RouteWithSubRoutes key={i} {...route} />
                ))}
              </Switch>
            </div>
          </Content>
          <Footer style={{ textAlign: 'center' }}>Ant Design ©2018 Created by Ant UED</Footer>
        </Layout>
      </BrowserRouter>
    </Layout>
    );
}

export default BasicLayout;
