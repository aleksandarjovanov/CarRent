import React from 'react';

const SingleClient = (props) => {

    return (

            <tr onClick={() => props.onDetails(props.single.id)}>
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