import React from 'react';
import {useHistory} from "react-router-dom";

const SingleClient = (props) => {

    const history = useHistory();

    const handleClick = (e) => {

        history.push(`/clients/${props.single.id}`)
    };


    return (

            <tr onClick={handleClick}>
                <td className="column1">{props.single.id}</td>
                <td className="column2">{props.single.name}</td>
                <td className="column3">{props.single.sex}</td>
                <td className="column4">{props.single.age}</td>
                <td className="column5">{props.single.driverLicenceNumber}</td>
                <td className="column6">{props.single.crimeRecord+""}</td>
            </tr>

    );
}

export default SingleClient;