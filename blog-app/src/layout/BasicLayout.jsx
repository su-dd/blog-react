import HeaderPage from "../components/HeaderPage";
import SiderPage from "../components/SiderPage";
import ContextPage from "../components/ContextPage";

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
        <Layout style={{ minHeight: '100vh' }}>
            <Sider collapsible collapsed={collapsed} onCollapse= {onCollapse}>
                <SiderPage />
            </Sider>
            <Layout className="site-layout">
                <Header className="site-layout-background" style={{ padding: 0 }} >
                    <HeaderPage />
                </Header>
                <Content style={{ margin: '0 16px' }}>
                    <ContextPage />
                </Content>
                <Footer style={{ textAlign: 'center' }}>Ant Design ©2018 Created by Ant UED</Footer>
            </Layout>
        </Layout>
    );
};

export default BasicLayout;