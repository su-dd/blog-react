import HeaderPage from "../components/HeaderPage";
import SiderPage from "../components/SiderPage";
import ContentPage from "../components/ContentPage";
import "./BasicLayout.less";

import React, { useState } from "react";
import { Layout } from 'antd';
const { Header, Content, Footer, Sider } = Layout;


const BasicLayout = () => {
    const [collapsed, setCollapsed] = useState(false);

    const onCollapse = collapsed => {
        console.log(collapsed);
        setCollapsed(collapsed);
    };

    return (
        <Layout className="site-layout" style={{ minHeight: '100vh' }}>
            <Sider className="site-layout-sider" collapsible collapsed={collapsed} onCollapse= {onCollapse}>
                <SiderPage />
            </Sider>
            <Layout className="site-layout2">
                <Header className="site-layout-header" style={{ padding: 0 }} >
                    <HeaderPage />
                </Header>
                <Content  className="site-layout-content" style={{ margin: '0 16px' }}>
                    <ContentPage />
                </Content>
                <Footer style={{ textAlign: 'center' }}>Ant Design ©2018 Created by Ant UED</Footer>
            </Layout>
        </Layout>
    );
};

export default BasicLayout;