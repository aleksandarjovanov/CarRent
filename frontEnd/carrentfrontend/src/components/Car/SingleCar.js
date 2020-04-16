import React from 'react';

const SingleCar = (props) => {

    return (

        <tr onClick={() => props.onDetails(props.single.id, "details")} >
            <td className="column1">{props.single.id}</td>
            <td className="column2">{props.single.mark}</td>
            <td className="column2">{props.single.model}</td>
            <td className="column3">{props.single.plate}</td>
            <td className="column4">{props.single.yearOfProduction}</td>
            <td className="column4">{props.single.costPerDay}</td>
        </tr>

    );
}

export default SingleCar;