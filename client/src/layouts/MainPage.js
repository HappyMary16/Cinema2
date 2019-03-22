import React from 'react';
import { Route, Switch } from 'react-router-dom';

import AdminMenu from '../components/admin/AdminMenu';
import AddUser from '../components/admin/users/AddUser';
import UserList from '../components/admin/users/UserList';
import AdminList from '../components/admin/users/AdminList';
import UserCard from '../components/admin/users/UserCard';
import UpdateUser from '../components/admin/users/UpdateUser';
import LanguageList from '../components/admin/films/data/language/LanguageList';
import StudioList from '../components/admin/films/data/studio/StudioList';
import CountryList from '../components/admin/films/data/country/CountryList';
import GenreList from "../components/admin/films/data/genre/GenreList";
import ActorList from "../components/admin/films/data/person/ActorList";
import DirectorList from "../components/admin/films/data/person/DirectorList";

export default () => (
    <div className='container'>
        <Switch>
            <Route exact path='/' component={AdminMenu}/>
            <Route path='/add_user' component={AddUser}/>
            <Route path='/user_list' component={UserList}/>
            <Route path='/admin_list' component={AdminList}/>
            <Route path='/user_card' component={UserCard}/>
            <Route path='/user_update' component={UpdateUser}/>
            <Route path='/language_list' component={LanguageList}/>
            <Route path='/studio_list' component={StudioList}/>
            <Route path='/country_list' component={CountryList}/>
            <Route path='/genre_list' component={GenreList}/>
            <Route path='/actor_list' component={ActorList}/>
            <Route path='/director_list' component={DirectorList}/>
        </Switch>
    </div>
)