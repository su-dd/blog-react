import React from "react";
import BasicLayout from "@/layout/BasicLayout";
import HeaderPage  from "@/components/HeaderPage";
import ContentPage from "@/components/ContentPage";

const Home = () => {
    return (
        <BasicLayout headerDiv={<HeaderPage/>} contentDiv={<ContentPage/>}/>
    );
};

export default Home;