import React from 'react';

const Login = (props) => {

    const onFormSubmit = (e) => {
        e.preventDefault();

        const credentials = {
            "username": e.target.username.value,
            "password": e.target.password.value,
        };
        props.onLogin(credentials);
    };


    return(
        <nav className="navbar navbar-light navbar-expand-md" style={{padding: "15px"}}>
            <div className="container-fluid"><a className="navbar-brand" href="#"
                                                style={{fontSize: "22px", fontFamily: "Aclonica, sans-serif"}}
            ><em>Car Rent
                Management System</em></a>

                <div className="collapse navbar-collapse" id="navcol-1" style={{fontSize: "18px"}}>

                    <form onSubmit={onFormSubmit} className="form-inline ml-auto">
                        <ul className="nav navbar-nav ml-auto">
                            <li id="errorMessageHolder" className="nav-item" role="presentation">
                                <p style={{margin: "8px", opacity: "0.90", color: "red"}}>{props.message}</p>
                            </li>
                            <li className="nav-item" role="presentation">
                                <p style={{margin: "8px", opacity: "0.90"}}>Username:&nbsp;</p>
                            </li>
                            <li className="nav-item" role="presentation"><input
                                className="border rounded border-info form-control" type="text"
                                style={{width: "130px", padding: "7px"}} name={"username"} placeholder="username"/></li>
                            <li className="nav-item" role="presentation">
                                <p style={{margin: "8px", opacity: "0.90"}}>Password:</p>
                            </li>
                            <li className="nav-item" role="presentation"><input
                                className="border rounded border-info form-control" type="password"
                                style={{width: "130px", height: "40px", padding: "7px"}} name={"password"} placeholder="password"/>
                            </li>
                            <li className="nav-item" role="presentation">
                                <button className="btn btn-primary bg-info border-info" style={{padding: "10px 15px 10px 15px", margin: "0px 4px 0px 8px"}} type="submit">Log in</button>
                            </li>
                        </ul>
                    </form>
                </div>
            </div>
        </nav>
    );

};

export default Login;