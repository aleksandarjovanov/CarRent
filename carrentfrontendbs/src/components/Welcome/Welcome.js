import React, {useEffect, useState} from 'react';
import Login from "./Login";
import {BrowserRouter as Router, useHistory, Switch, Route} from 'react-router-dom';
import SignUpClient from "./SignUpClient";
import authenticationService from "../../API/Authentication/axiosAuthenticationService";
import clientsService from "../../API/axiosIngredientService";
import rentersService from "../../API/axiosRentersService";
import SignUpRenter from "./SignUpRenter";
import Landing from "./Landing";
import authHeader from "../../API/Authentication/AuthenticationHeader";

const Welcome = (props) => {

    const[message, setMessage] = useState('');
    const[registerMsg, setRegisterMsg] = useState('');
    const[link, setLink] = useState('');
    const[text, setText] = useState('');
    const[marker, setMarker] = useState('visible');
    const[color, setColor] = useState('red');

    const pushToC = () => {
        history.push("/home/signUpClient");
    };

    const pushToR = () => {
        history.push("/home/signUpRenter");
    };


    const createClient = (client) => {
        authenticationService.registerClient(client).then((response)=>{
            const succ = response.data.message;
            setRegisterMsg(succ);
            setLink("/home");
            setText("Go ahead and Log-In");
            setMarker("hidden");
            setColor("green");
        },
        error => {
            const responseMessage = (error.response && error.response.data && error.response.data.message) || error.message || error.toString();
            setRegisterMsg(responseMessage);
            setLink("/home/signUpClient");
            setText("Please try again...");
            setMarker("visible");
            setColor("red");
        });
    };

    const createRenter = (renter) => {
        authenticationService.registerRenter(renter).then((response)=>{
                const succ = response.data.message;
                setRegisterMsg(succ);
                setLink("/home");
                setText("Go ahead and Log-In");
                setMarker("hidden");
                setColor("green");
            },
            error => {
                const responseMessage = (error.response && error.response.data && error.response.data.message) || error.message || error.toString();
                setRegisterMsg(responseMessage);
                setLink("/home/signUpClient");
                setText("Please try again...");
                setMarker("visible");
                setColor("red");
            });
    };


    const loginUser = (credentials) => {
        authenticationService.signInUser(credentials).then((response)=>{
                localStorage.setItem("user", JSON.stringify(response.data));
                history.push("/rota/cars/list");
                history.go();
        },
        error => {
            const responseMessage = (error.response && error.response.data && error.response.data.message) || error.message || error.toString();
            setMessage(responseMessage);
        });
    };


    const history = useHistory();

    return (
        <div className="App">
            <Login onLogin={loginUser} message={message}/>
            <Route path={"/home/"} exact render={(props) => <Landing {...props} pushC={pushToC} pushR={pushToR}/>} />
            <Route path={"/home/signUpClient"} exact render={(props) => <SignUpClient {...props} color={color} marker={marker} link={link} text={text} registerMsg={registerMsg} onCreate={createClient}/>} />
            <Route path={"/home/signUpRenter"} exact render={(props) => <SignUpRenter {...props} color={color} marker={marker} link={link} text={text} registerMsg={registerMsg} onCreate={createRenter}/>} />

        </div>
    );
};

export default Welcome;