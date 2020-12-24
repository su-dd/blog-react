import React, { useState, useEffect } from "react";
import { createBrowserHistory } from "history";

import BlogMenu from "@/components/BlogMenu";
import BlogHeader from "@/components/BlogHeader";
import { routers, loginPageRoute } from "@@/src/routers/routers";

import
  {
    BrowserRouter,
    Switch,
    Route,
    Redirect
  } from "react-router-dom";

import { Layout } from "antd";
const { Header, Footer, Sider, Content } = Layout;


const history = createBrowserHistory();

const BasicLayout = () =>
{
  const [token, setToken] = useState(false);

  const RouteWithSubRoutes = (item) =>
  {
    return (
      <Route
        path={item.path}
        render={props => (
          ! item.auth ?
            (<item.component {...props} routes={item.routes} />)
            : (token ? <item.component {...props} routes={item.routes} />
              : <Redirect to={{
                pathname: loginPageRoute.path ,
                state: { from: props.location }}}/>)
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
          onBreakpoint={broken =>
          {
            console.log(broken);
          }}
          onCollapse={(collapsed, type) =>
          {
            console.log(collapsed, type);
          }}
        >
          <div className="logo" />
          <BlogMenu />
        </Sider>
        <Layout>
          <Header className="site-layout-sub-header-background" style={{ padding: 0, background: '#fff' }}>
            <BlogHeader></BlogHeader>
          </Header>
          <Content style={{ margin: '24px 16px 0' }}>
            <div className="site-layout-background" style={{ padding: 24, minHeight: 360 }}>
              <Switch>
                {routers.map((item, i) => (
                  <RouteWithSubRoutes key={i} {...item} />
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
