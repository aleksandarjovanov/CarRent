import React from 'react';
import { Redirect, Route } from 'react-router-dom';
import authenticationService from "../../API/Authentication/axiosAuthenticationService";



const RouteAuthenticated = (props) => {
    if (!authenticationService.isAuthenticated()) {
        return <Redirect to="/home" />;
    }

    return <Route component={props.component} path={props.path} />;
};

export default RouteAuthenticated;