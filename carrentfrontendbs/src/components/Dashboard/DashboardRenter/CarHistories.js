import React from "react";
import {MDBBtn, MDBDataTable, MDBIcon} from "mdbreact";

const CarHistories = (props) => {


    const data = {
        columns: [
            {
                label: 'ID',
                field: 'id',
                sort: 'asc',
                width: 150
            },
            {
                label: 'Registration Date',
                field: 'registrationDate',
                sort: 'asc',
                width: 100
            },
            {
                label: 'Breaks Status',
                field: 'breaksStatus',
                sort: 'asc',
                width: 100
            },
            {
                label: 'FrontGlass Status',
                field: 'frontGlassStatus',
                sort: 'asc',
                width: 100
            },
            {
                label: 'Wheels Status',
                field: 'wheelsStatus',
                sort: 'asc',
                width: 100
            },
            {
                label: 'Engine Status',
                field: 'engineStatus',
                sort: 'asc',
                width: 100
            },
            {
                label: 'kmDistance Passed',
                field: 'kmDistancePassed',
                sort: 'asc',
                width: 100
            },
            {
                label: 'Description',
                field: 'detailsDescription',
                sort: 'asc',
                width: 100
            },
            {
                label: 'Action',
                field: 'action',
                sort: 'asc',
                width: 330
            }
        ],
        rows: [

            ...props.carHis.map((his) => ({
                    id: his.id,
                    registrationDate: his.registrationDate,
                    breaksStatus: his.breaksStatus,
                    frontGlassStatus: his.frontGlassStatus,
                    wheelsStatus: his.wheelsStatus,
                    engineStatus: his.engineStatus,
                    kmDistancePassed: his.kmDistancePassed,
                    detailsDescription: his.detailsDescription,
                    action:(
                        <div>
                            <MDBBtn onClick={() => props.onDelete(his.id)} color="danger" size="sm"><MDBIcon icon="trash" className="mr-1" />Delete</MDBBtn>
                        </div>
                    )
                })

            )
        ]
    };


    return(
        <div id="dasCars" className="app">
            <h2 className="text-center" style={{color: "rgb(60,64,68)"}}>А complete list of <b>car histories</b> this car!</h2>
            <p className="text-center" id="car-paragraph" style={{color: "rgb(112,120,128)"}}>All of the renters that are
                listed down are legal, with a license obtained from the state.<br/>Go ahead, follow some of them and see the results.</p>
            <div id="ccc1">

                <MDBDataTable
                    responsive
                    striped
                    hover
                    data={data}
                />
                <MDBBtn onClick={() => props.pushAddHis(props.carId)} color="success" size="md"><MDBIcon icon="plus" className="mr-1" />Create Car History</MDBBtn>
            </div>

        </div>
    );
};

export default CarHistories;