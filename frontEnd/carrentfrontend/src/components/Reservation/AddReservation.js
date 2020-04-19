import React from "react";
import {useHistory} from "react-router-dom";

const AddReservation = (props) => {

    const history = useHistory();

    const onFormSubmit = (e) => {
        e.preventDefault();

        const newRes = {
            "from": e.target.from.value,
            "to": e.target.to.value,
            "comment": e.target.comment.value,
        };
        props.onCreate(newRes);
    };

    const goBack = () => {
        history.push("/reservations/list")
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

                        <h3>Personal info</h3>

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

export default AddReservation;