import React from "react";
import {useHistory} from "react-router-dom"
import CarHistories from "../../Dashboard/DashboardRenter/CarHistories";

const CarReservation = (props) => {

    const history = useHistory();

    const goBack = () => {
        history.push("/rota/cars/list")
    };
    const onFormSubmit = (e) => {
        e.preventDefault();

        const newRes = {
            "from": e.target.from.value,
            "to": e.target.to.value,
            "comment": e.target.comment.value,
        };
        props.onCreate(newRes, props.match.params.id);
    };

    const carTermines = props.termines.map((term) => {

        return(
            <li className="list-group-item border-top-0 border-left-0 border-right-0" key={term.id} style={{textAlign: "center", backgroundColor: "rgb(232,232,241)"}}><span><strong>{term.availableFrom + " ---TO--- " + term.availableTo}</strong></span></li>
        );
    });

    return(
        <div>
            <div>
                <div className="container" id="reservation-con">
                    <div className="row">
                        <div className="col-4 profil-col"><img id="profil-img" style={{height: "410px", marginTop: "15px"}} src={props.car.imgLink}/></div>
                        <div className="col-4 profil-col">
                            <p className="text-center fb"><strong>ID</strong>: {props.car.id}</p>
                            <p className="text-center fb"><strong>Mark</strong>: {props.car.mark}</p>
                            <p className="text-center fb"><strong>Model</strong>: {props.car.model}</p>
                            <p className="text-center fb"><strong>Plate</strong>: {props.car.plate}</p>
                            <p className="text-center fb"><strong>Color</strong>: {props.car.color}</p>
                            <p className="text-center fb"><strong>Year Of Production</strong>: {props.car.yearOfProduction}</p>
                            <p className="text-center fb"><strong>Daily cost</strong>: {props.car.costPerDay}</p>
                            <p className="text-center fb"><strong>Rating</strong>: {props.car.rating}</p>
                        </div>
                        <div className="col-4 profil-col">
                            <h4 style={{textAlign: "center", marginBottom: "20px"}}><strong>List of available <b>time intervals:</b></strong></h4>
                            <ul className="list-group" style={{marginBottom: "20px",borders: "none", color: "#5593a6"}}>
                                {carTermines}
                            </ul>
                            <form onSubmit={onFormSubmit} className="form-horizontal" role="form">
                                <div className="form-group">
                                    <label className="col-md-3 control-label">From:</label>
                                    <div className="col-md-8">
                                        <input className="form-control"  type="date" name={"from"} />
                                    </div>
                                </div>
                                <div className="form-group">
                                    <label className="col-md-3 control-label">To:</label>
                                    <div className="col-md-8">
                                        <input className="form-control"  type="date" name={"to"} />
                                    </div>
                                </div>
                                <div className="form-group">
                                    <label className="col-md-3 control-label">Comment:</label>
                                    <div className="col-md-8">
                                        <input className="form-control"  type="text" name={"comment"} />
                                    </div>
                                </div>
                                <p style={{color: "red"}}>{props.msg}</p>
                                <div className="form-group">
                                    <label className="col-md-3 control-label"> </label>
                                    <div className="col-md-8">
                                        <input type="submit" className="btn btn-success" value="Submit"/>
                                        <span> </span>
                                        <input onClick={goBack} type="button" className="btn btn-dark" value="Cancel"/>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    );
};

export default CarReservation
