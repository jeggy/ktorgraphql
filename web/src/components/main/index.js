import React from 'react';
import QueryComponent from '../query';
import logo from "../../assets/logo.svg";
import './main.css';

export default () => (
    <div className="App">
        <header className="App-header">
            <img src={logo} className="App-logo" alt="logo"/>
            <QueryComponent />
        </header>
    </div>
);
