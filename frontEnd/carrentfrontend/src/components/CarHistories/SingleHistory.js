import React from 'react';


const SingleHistory = (props) => {

    return (

        <tr onClick={() => props.costumeTest(props.single.id, "edit")} >
            <td className="column1">{props.single.id}</td>
            <td className="column2">{props.single.registrationDate}</td>
            <td className="column2">{props.single.breaksStatus}</td>
            <td className="column3">{props.single.frontGlassStatus}</td>
            <td className="column4">{props.single.wheelsStatus}</td>
            <td className="column4">{props.single.engineStatus}</td>
            <td className="column4">{props.single.kmDistancePassed}</td>
            <td className="column4">{props.single.detailsDescription}</td>
        </tr>

    );
}

export default SingleHistory;