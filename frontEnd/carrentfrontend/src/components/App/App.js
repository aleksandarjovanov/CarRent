import React from 'react';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import Header from "../Header/Header";
import Clients from "../Client/Clients";
import './App.css';
import Renters from "../Renter/Renters";

function App() {
  return (
      <Router>
        <div className="App">
          <Header/>

            <Switch>
              <Route path={"/clients"} component={Clients}/>
              <Route path={"/renters"} component={Renters}/>
            </Switch>

        </div>
      </Router>
  );
}

export default App;
