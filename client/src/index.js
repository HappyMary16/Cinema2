import React from 'react';
import ReactDOM from 'react-dom';
import MainPage from "./layouts/MainPage";
import { createBrowserHistory } from 'history';
import { Router, Route, Link } from 'react-router-dom';

const history = createBrowserHistory();


ReactDOM.render(
    <Router history={history}>
        <MainPage />
    </Router>
    , document.getElementById('root'));


