import React from "react";
import {useHistory} from "react-router-dom";

const AddCarHis = (props) => {

    const history = useHistory();

    const onFormSubmit = (e) => {
        e.preventDefault();

        const newHis = {
            "registrationDate": e.target.registrationDate.value,
            "breaksStatus": e.target.breaksStatus.value,
            "frontGlassStatus": e.target.frontGlassStatus.value,
            "wheelsStatus": e.target.wheelsStatus.value,
            "engineStatus": e.target.engineStatus.value,
            "kmDistancePassed": e.target.kmDistancePassed.value,
            "detailsDescription": e.target.detailsDescription.value
        };
        props.onAdd(newHis, props.match.params.id);
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

                        <h3>Car History info</h3>

                        <form onSubmit={onFormSubmit} className="form-horizontal" role="form">
                            <div className="form-group">
                                <label className="col-lg-3 control-label">Registration Date:</label>
                                <div className="col-lg-8">
                                    <input  className="form-control" type="text" name={"registrationDate"} />
                                </div>
                            </div>
                            <div className="form-group">
                                <label className="col-lg-3 control-label">Breaks Status:</label>
                                <div className="col-lg-8">
                                    <input className="form-control"  type="text" name={"breaksStatus"} />
                                </div>
                            </div>
                            <div className="form-group">
                                <label className="col-lg-3 control-label">Front Glass Status:</label>
                                <div className="col-lg-8">
                                    <input className="form-control" type="text"  name={"frontGlassStatus"} />
                                </div>
                            </div>
                            <div className="form-group">
                                <label className="col-lg-3 control-label">Wheels Status:</label>
                                <div className="col-lg-8">
                                    <input className="form-control" type="text" name={"wheelsStatus"} />
                                </div>
                            </div>
                            <div className="form-group">
                                <label className="col-md-3 control-label">Engine Status:</label>
                                <div className="col-md-8">
                                    <input className="form-control"  type="text" name={"engineStatus"} />
                                </div>
                            </div>
                            <div className="form-group">
                                <label className="col-md-3 control-label">km Distance Passed:</label>
                                <div className="col-md-8">
                                    <input className="form-control"  type="number" name={"kmDistancePassed"} />
                                </div>
                            </div>
                            <div className="form-group">
                                <label className="col-md-3 control-label">Details Description:</label>
                                <div className="col-md-8">
                                    <input className="form-control"  type="text" name={"detailsDescription"} />
                                </div>
                            </div>

                            <div className="form-group">
                                <label className="col-md-3 control-label"> </label>
                                <div className="col-md-8">
                                    <input type="submit" className="btn btn-warning" value="Save Changes"/>
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

export default AddCarHis;