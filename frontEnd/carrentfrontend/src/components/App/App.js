import React from 'react';
import Header from "../Header/Header";
import ListClients from "../Client/ListClient";
import './App.css';

function App() {
  return (
    <div className="App">
      <Header/>
      <ListClients/>
    </div>
  );
}

export default App;
