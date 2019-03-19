import React from 'react';
import { Route, Switch } from 'react-router-dom';
import UserList from '../components/admin/users/UserList'
import AddUser from '../components/admin/users/AddUser'
import AdminMenu from "../components/admin/AdminMenu";
import AdminList from "../components/admin/users/AdminList";
import UserCard from "../components/admin/users/UserCard";
import UpdateUser from "../components/admin/users/UpdateUser";

export default () => (
    <div className='container'>
        <Switch>
            <Route exact path="/" component={AdminMenu}/>
            <Route path="/add_user" component={AddUser}/>
            <Route path="/user_list" component={UserList}/>
            <Route path="/admin_list" component={AdminList}/>
            <Route path="/user_card" component={UserCard}/>
            <Route path="/user_update" component={UpdateUser}/>
        </Switch>
    </div>
)