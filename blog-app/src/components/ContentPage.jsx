import React, {useState, useEffect} from "react";
import { Breadcrumb } from "antd";
const axios = require('axios').default;

const ContentPage = () => {
    const [person, setPerson] = useState([]);
    // const [instance, setInstance] = useState({});

    useEffect(() => {

        let headers = new Headers();
        // headers.append('Content-Type', 'application/json');
        // headers.append('Accept', 'application/json');
        headers.append('Access-Control-Allow-Origin', 'http://localhost:3000');
        headers.append('Access-Control-Allow-Credentials', 'true');
        // headers.append('GET', 'POST', 'OPTIONS');
        // headers.append('Authorization', 'Basic ' + base64.encode(username + ":" + password));
        let instance = axios.create({
            baseURL: "http://localhost:8080",
            timeout: 1000,
            headers:  headers
        });

        instance.get('/people')
        .then(function(response){
            console.log("response:" + response);
        })
        .catch(function(error){
            console.log("error:" + error);
        });
    });

    return (
        <div>
            <Breadcrumb style={{ margin: '16px 0' }}>
                <Breadcrumb.Item>User</Breadcrumb.Item>
                <Breadcrumb.Item>Bill</Breadcrumb.Item>
            </Breadcrumb>
            <div className="site-layout-background">
                Bill is a cat.
            </div>
        </div>
    );
};

export default ContentPage;