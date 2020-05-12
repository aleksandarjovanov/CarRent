import React from "react";
import {useHistory} from "react-router-dom";
import CarHistories from "./CarHistories";

const CarDetails = (props) => {

    const history = useHistory();

    const goBack = () => {
        history.push("/dashboard/renter/cars")
    };

    return(
        <div>
            <div className="container" id="profil-container">
                <h2 className="text-center hb">Car details</h2>
                <p className="text-center fb">Car informations and HISTORIES.</p>
                <div className="row">
                    <div className="col profil-col"><img id="profil-img" style={{height: "410px", marginTop: "15px"}} src={props.single.imgLink}/></div>
                    <div className="col profil-col">
                        <p className="text-center fb"><strong>ID</strong>: {props.single.id}</p>
                        <p className="text-center fb"><strong>Mark</strong>: {props.single.mark}</p>
                        <p className="text-center fb"><strong>Model</strong>: {props.single.model}</p>
                        <p className="text-center fb"><strong>Plate</strong>: {props.single.plate}</p>
                        <p className="text-center fb"><strong>Color</strong>: {props.single.color}</p>
                        <p className="text-center fb"><strong>Year Of Production</strong>: {props.single.yearOfProduction}</p>
                        <p className="text-center fb"><strong>Daily cost</strong>: {props.single.costPerDay}</p>
                        <p className="text-center fb"><strong>Rating</strong>: {props.single.rating}</p>
                        <button onClick={() => goBack()} className="btn btn-dark" type="button"><i
                            className="fas fa-arrow-alt-circle-left"></i>&nbsp;Back
                        </button>
                    </div>
                </div>
            </div>
            <CarHistories carId={props.single.id} pushAddHis={props.pushAddHis} carHis={props.carHis} onDelete={props.onDeleteHis}/>
        </div>
    );
};

export default CarDetails;