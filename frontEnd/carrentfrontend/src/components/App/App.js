import React from 'react';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import Header from "../Header/Header";
import ListClients from "../Client/ListClient";
import ClientDetails from "../Client/ClientDetails"
import './App.css';

function App() {
  return (
      <Router>
        <div className="App">
          <Header/>

          <Switch>
              <Route path={"/clients"} exact component={ListClients}/>
              <Route path={"/clients/:id"} exact component={ClientDetails}/>
          </Switch>

        </div>
      </Router>
  );
}

export default App;
