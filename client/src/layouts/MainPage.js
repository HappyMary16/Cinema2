import React from 'react';
import { Route, Switch } from 'react-router-dom';
import UserList from '../components/UserList'
import AddUser from '../components/AddUser'

export default () => (
    <div className='container'>
        <Switch>
            <Route exact path="/" component={UserList}/>
            <Route path="/add_user" component={AddUser}/>
        </Switch>
    </div>
)