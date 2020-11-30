import React from "react";
import { Layout } from 'antd';
const { Header, Content} = Layout;

const BasicLayout = (props) => {
    return (
        <Layout className="site-layout">
            <Header className="site-layout-header">
                {props.headerDiv}
            </Header>
            <Content  className="site-layout-content">
                {props.contentDiv}
            </Content>
        </Layout>
    );
};

export default BasicLayout;