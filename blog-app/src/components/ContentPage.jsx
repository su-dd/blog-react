import React, {useState, useEffect} from "react";
import { Breadcrumb } from "antd";
import Https from "@/utils/https";
import usls from "@/utils/urls";

const ContentPage = () => {
    const [person, setPerson] = useState([]);

    useEffect(() => {
        Https.get(usls.people)
        .then((response) => {
          console.log("response: ");
          console.log(response);
          setPerson(response.data._embedded.people);
        })
        .catch((error) => {
          console.log("error: ");
          console.log(error);
        })
      });

    return (
        <div>
            <div className="site-layout-background">
                Bill is a cat.
                {person.map((item, key) => (
                    <div>this is {item.lastName + " " + item.firstName}</div>
                ))}
            </div>
        </div>
    );
};

export default ContentPage;