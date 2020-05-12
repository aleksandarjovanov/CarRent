import React, {useState, useEffect} from 'react';
import {MDBBtn, MDBDataTable, MDBIcon} from 'mdbreact';
import "../../../myStyle/carStyle.css"

const RenterCars = (props) => {



    const data = {
        columns: [
            {
                label: 'ID',
                field: 'id',
                sort: 'asc',
                width: 150
            },
            {
                label: 'Mark',
                field: 'mark',
                sort: 'asc',
                width: 270
            },
            {
                label: 'Model',
                field: 'model',
                sort: 'asc',
                width: 200
            },
            {
                label: 'Plate',
                field: 'plate',
                sort: 'asc',
                width: 100
            },
            {
                label: 'Color',
                field: 'color',
                sort: 'asc',
                width: 150
            },
            {
                label: 'Product. Year',
                field: 'yearOfProduction',
                sort: 'asc',
                width: 100
            },
            {
                label: 'Day cost',
                field: 'costPerDay',
                sort: 'asc',
                width: 100
            },
            {
                label: 'Rating',
                field: 'rating',
                sort: 'asc',
                width: 100
            },
            {
                label: 'Action',
                field: 'action',
                sort: 'asc',
                width: 100
            }
        ],
        rows: [

            ...props.cars.map((car) => ({
                    id: car.id,
                    mark: car.mark,
                    model: car.model,
                    plate: car.plate,
                    color: car.color,
                    yearOfProduction: car.yearOfProduction,
                    costPerDay: car.costPerDay,
                    rating: car.rating,
                    action:(
                        <div>
                            <MDBBtn id={car.id} onClick={() => props.carEdit(car.id,"edit")} color="info" outline size="sm"><MDBIcon icon="magic" className="mr-1" />Edit</MDBBtn>
                            <MDBBtn onClick={() => props.onDeleteCar(car.id)} color="danger" size="sm"><MDBIcon icon="trash" className="mr-1" />Delete</MDBBtn>
                            <MDBBtn onClick={() => props.carDetails(car.id, "details")} color="success" size="sm"><MDBIcon icon="far fa-file-alt" className="mr-1" />Details</MDBBtn>
                        </div>
                    ),

                })

            )
        ]
    };


    return(
        <div id="dasCars" className="app">
            <h2 className="text-center" style={{color: "rgb(60,64,68)"}}>А list of <b>cars</b> that you own!</h2>
            <p className="text-center" id="car-paragraph" style={{color: "rgb(112,120,128)"}}>All of the cars that are
                listed down are legal, with a license obtained from the state.<br/>.</p>
            <div id="ccc1">

                <MDBDataTable
                    responsive
                    striped
                    hover
                    data={data}
                />
                <MDBBtn onClick={() => props.pushAdd()} color="success" size="md"><MDBIcon icon="plus" className="mr-1" />Create Car</MDBBtn>
            </div>

        </div>
    );
};

export default RenterCars;