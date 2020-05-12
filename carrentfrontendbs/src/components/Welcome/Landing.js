import React from "react";

const Landing = (props) => {

    return (
        <div>
            <div className="main-container">
                <div id="promo">
                    <div className="jumbotron">
                        <h1>&nbsp;Created by car fans!</h1>
                        <p>Car Rent management system is a small platform for renting cars, id dolor id nibh ultricies
                            vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam.Nullam id dolor
                            id nibh ultricies vehicula ut id elit. Cras justo
                            odio, dapibus ac facilisis in, egestas eget quam. Cras justo odio, dapibus ac facilisis in,
                            egestas eget quam.Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio,
                            dapibus ac facilisis in, egestas eget quam.Nullam
                            id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in,
                            egestas eget quam.</p>
                    </div>
                </div>
            </div>
            <div>
                <div className="home-container">
                    <h1 id="create-account">Creating an account is fast &amp; easy!</h1>
                    <div className="row">
                        <div className="col-md-6 cl6"><i className="fa fa-user"></i>
                            <h3><strong>Sign up as client</strong></h3>
                            <p>Creating an account as a client is easier then ever. It provides multiple privilages from
                                choosing the best suitetd car for you, to rating and rewiev a car.</p>
                            <button onClick={() => props.pushC()} className="btn btn-primary bg-info border-info" type="button">Sign up as client</button>
                        </div>
                        <div
                            className="col-md-6 cl7"><i className="fa fa-key"></i>
                            <h3><strong>Sign up as renter</strong></h3>
                            <p>Creating an account as a renter is easier then ever. It provides multiple privilages from
                                renting you're cars to clients from around the world, to earn a lot of money.</p>
                            <button onClick={() => props.pushR()} className="btn btn-primary bg-info border-info" type="button">Sign up as renter</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Landing;