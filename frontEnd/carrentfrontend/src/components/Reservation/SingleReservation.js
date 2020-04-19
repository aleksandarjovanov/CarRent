import React from 'react';

const SingleReservation = (props) => {

    return (

        <tr >
            <td className="column1">{props.single.id}</td>
            <td className="column2">{props.single.client.id}</td>
            <td className="column2">{props.single.car.id}</td>
            <td className="column3">{props.single.from}</td>
            <td className="column4">{props.single.to}</td>
            <td className="column4">{props.single.comment}</td>
        </tr>

    );
}

export default SingleReservation;