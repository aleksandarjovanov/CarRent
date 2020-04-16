import React, {useEffect, useState} from "react";
import {useHistory} from "react-router-dom";

const EditHistory = (props) => {

    const [his, setHis] = useState({});

    useEffect(() =>{
        setHis(props.singleHistory)
    },[]);

    const history = useHistory();

    const onFormSubmit = (e) => {
        e.preventDefault();
        props.onSubmit(his);
    };

    const handleOnChange = (e) => {
        const paramName = e.target.name;
        const paramValue = e.target.value;
        setHis({...his, [paramName] : paramValue}); //ova mi dozvoluva da pisuvam vo inputite, react e glup i ne bi mi dozvolil bez ova
    };

    const goBack = () => {
        history.push("/carHistories/list");
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
                                <label className="col-lg-3 control-label">Registration Date:</label>
                                <div className="col-lg-8">
                                    <input onChange={handleOnChange} className="form-control" type="text" name={"registrationDate"} value={his.registrationDate}/>
                                </div>
                            </div>
                            <div className="form-group">
                                <label className="col-lg-3 control-label">Breaks Status:</label>
                                <div className="col-lg-8">
                                    <input className="form-control" onChange={handleOnChange} type="text" name={"breaksStatus"} value={his.breaksStatus}/>
                                </div>
                            </div>
                            <div className="form-group">
                                <label className="col-lg-3 control-label">Front Glass Status:</label>
                                <div className="col-lg-8">
                                    <input className="form-control" type="text" onChange={handleOnChange} name={"frontGlassStatus"} value={his.frontGlassStatus}/>
                                </div>
                            </div>
                            <div className="form-group">
                                <label className="col-lg-3 control-label">Km Distance Passed:</label>
                                <div className="col-lg-8">
                                    <input className="form-control" type="number" onChange={handleOnChange} name={"kmDistancePassed"} value={his.kmDistancePassed}/>
                                </div>
                            </div>

                            <div className="form-group">
                                <label className="col-md-3 control-label">Wheels Status:</label>
                                <div className="col-md-8">
                                    <input className="form-control" onChange={handleOnChange} type="text" name={"wheelsStatus"} value={his.wheelsStatus}/>
                                </div>
                            </div>
                            <div className="form-group">
                                <label className="col-md-3 control-label">Engine Status:</label>
                                <div className="col-md-8">
                                    <input className="form-control" onChange={handleOnChange} type="text" name={"engineStatus"} value={his.engineStatus}/>
                                </div>
                            </div>
                            <div className="form-group">
                                <label className="col-md-3 control-label">Details Description:</label>
                                <div className="col-md-8">
                                    <input className="form-control" onChange={handleOnChange} type="text" name={"detailsDescription"} value={his.detailsDescription}/>
                                </div>
                            </div>
                            <div className="form-group">
                                <label className="col-md-3 control-label"> </label>
                                <div className="col-md-8">
                                    <input type="submit" className="btn btn-warning" value="Save Changes"/>
                                    <span> </span>
                                    <input type="button" onClick={goBack} className="btn btn-dark" value="Cancel"/>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default EditHistory;