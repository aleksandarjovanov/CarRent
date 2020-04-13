import React from 'react';

const SingleRenter = (props) => {

    return (

        <tr onClick={() => props.onDetails(props.single.id, "details")} >
            <td className="column1">{props.single.id}</td>
            <td className="column2">{props.single.firstName}</td>
            <td className="column2">{props.single.lastName}</td>
            <td className="column3">{props.single.sex}</td>
            <td className="column4">{props.single.age}</td>
        </tr>

    );
}

export default SingleRenter;