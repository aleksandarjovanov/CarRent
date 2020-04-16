import React from 'react';
import '../Client/Style/ClientDetails.css';

const CarDetails = (props) => {


    const carTermines = props.termines.map((term) => {

        return(
            <div className="forMargin" key={term.id}><p className="followersList" >{term.availableFrom + " --- " + term.availableTo}</p><br/></div>
        );
    });


    return (
        <div className="card">
            <div className="cardKid1"><img src={props.car.imgLink} alt="John" style={{width:"100%"}}/></div>
            <div className="cardKid2">
                <h1>{props.car.plate}</h1>
                <p className="title">Renting the best cars!</p>
                <p>Mark: {props.car.mark}</p>
                <p>Model: {props.car.model}</p>
                <p>Year: {props.car.yearOfProduction}</p>
                <p>Color: {props.car.color}</p>
                <p>Cost: {props.car.costPerDay}</p>
                <p>Rating: {props.car.rating}</p>
                <h4>Free Renting Terms:</h4>
                <div>{carTermines}</div>
                <p>
                    <button onClick={() => props.onEdit(props.car.id, "edit")} className="button1">Edit</button>
                </p>
                <p>
                    <button onClick={() => props.onDelete(props.car.id)} className="button2">Delete</button>
                </p>
            </div>
        </div>

    );
};

export default CarDetails;