import React, {useState, useEffect} from 'react';
import SingleCar from "./SingleCar";
import "../../../myStyle/carStyle.css";

const ListCars = (props) => {


    const singleCar = props.cars.map((car) => {

        return(
            <SingleCar onDetails={props.onDetails} rating={props.rating} single={car} key={car.id} />
        );
    });

    return (
        <div className="row">
            {singleCar}
        </div>

    );

};

export default ListCars;