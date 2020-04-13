import React from 'react';
import '../Client/Style/ClientDetails.css';

const RenterDetails = (props) => {


    const followersList = props.followers.map((client) => {

        return(
            <div className="forMargin"><p className="followersList" key={client.id} >{client.firstName + " " + client.lastName}</p><br/></div>

        );
    });


    return (
        <div className="card">
            <div className="cardKid1"><img src={props.renter.imgUrl} alt="John" style={{width:"100%"}}/></div>
            <div className="cardKid2">
                <h1>{props.renter.firstName}</h1>
                <p className="title">Renting the best cars!</p>
                <p>Last Name: {props.renter.lastName}</p>
                <p>Embg: {props.renter.embg}</p>
                <p>Age: {props.renter.age}</p>
                <p>Gender: {props.renter.sex}</p>
                <h4>Followers:</h4>
                <div>{followersList}</div>
                <p>
                    <button onClick={() => props.onEdit(props.renter.id, "edit")} className="button1">Edit</button>
                </p>
                <p>
                    <button onClick={() => props.onDelete(props.renter.id)} className="button2">Delete</button>
                </p>
            </div>
        </div>

    );
};

export default RenterDetails;