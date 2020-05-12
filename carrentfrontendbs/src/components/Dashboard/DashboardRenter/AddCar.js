import React from "react";
import {useHistory} from "react-router-dom";

const AddCar = (props) => {

    const history = useHistory();

    const onFormSubmit = (e) => {
        e.preventDefault();

        const newCar = {
            "mark": e.target.mark.value,
            "model": e.target.model.value,
            "plate": e.target.plate.value,
            "yearOfProduction": e.target.yearOfProduction.value,
            "costPerDay": e.target.costPerDay.value,
            "imgLink": e.target.imgLink.value,
            "rating": 0,
            "color": e.target.color.value
        };
        props.onAdd(newCar);
    };

    const goBack = () => {
        history.push("/dashboard/renter/cars")
    };

    return(
        <div style={{margin: "60px"}}>
            <div className="container">
                <br/>
                <hr/>
                <div className="row">

                    <div className="col-md-3">
                        <div className="text-center">

                        </div>
                    </div>


                    <div className="col-md-9 personal-info">

                        <h3>Car info</h3>

                        <form onSubmit={onFormSubmit} className="form-horizontal" role="form">
                            <div className="form-group">
                                <label className="col-lg-3 control-label">Mark:</label>
                                <div className="col-lg-8">
                                    <input  className="form-control" type="text" name={"mark"} />
                                </div>
                            </div>
                            <div className="form-group">
                                <label className="col-lg-3 control-label">Model:</label>
                                <div className="col-lg-8">
                                    <input className="form-control"  type="text" name={"model"} />
                                </div>
                            </div>
                            <div className="form-group">
                                <label className="col-lg-3 control-label">Plate:</label>
                                <div className="col-lg-8">
                                    <input className="form-control" type="text"  name={"plate"} />
                                </div>
                            </div>
                            <div className="form-group">
                                <label className="col-lg-3 control-label">Year Of Production:</label>
                                <div className="col-lg-8">
                                    <input className="form-control" type="number" name={"yearOfProduction"} />
                                </div>
                            </div>
                            <div className="form-group">
                                <label className="col-md-3 control-label">Cost:</label>
                                <div className="col-md-8">
                                    <input className="form-control"  type="number" name={"costPerDay"} />
                                </div>
                            </div>
                            <div className="form-group">
                                <label className="col-md-3 control-label">Color:</label>
                                <div className="col-md-8">
                                    <input className="form-control"  type="text" name={"color"} />
                                </div>
                            </div>
                            <div className="form-group">
                                <label className="col-md-3 control-label">Img URL:</label>
                                <div className="col-md-8">
                                    <input className="form-control"  type="text" name={"imgLink"} />
                                </div>
                            </div>

                            <div className="form-group">
                                <label className="col-md-3 control-label"> </label>
                                <div className="col-md-8">
                                    <input type="submit" className="btn btn-success" value="Add Car"/>
                                    <span> </span>
                                    <input onClick={goBack} type="button" className="btn btn-dark" value="Cancel"/>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default AddCar;