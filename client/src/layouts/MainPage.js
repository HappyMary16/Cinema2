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
import AddPerson from "../components/admin/films/data/person/AddPerson";
import FilmList from "../components/admin/films/FilmList";
import AddFilm from "../components/admin/films/AddFilm";
import UpdateFilm from "../components/admin/films/UpdateFilm";
import FilmCard from "../components/admin/films/FilmCard";
import HallList from "../components/admin/halls/HallList";
import AddHall from "../components/admin/halls/AddHall";
import UpdateHall from "../components/admin/halls/UpdateHall";
import HallCard from "../components/admin/halls/HallCard";
import SeanceLIst from "../components/admin/seances/SeanceLIst";
import AddSeance from "../components/admin/seances/AddSeance";
import SeanceCard from "../components/admin/seances/SeanceCard";
import UpdateSeance from "../components/admin/seances/UpdateSeance";

export default () => (
    <div className='container'>
        <Switch>
            <Route exact path='/' component={AdminMenu}/>

            <Route path='/add_user' component={AddUser}/>
            <Route path='/user_list' component={UserList}/>
            <Route path='/admin_list' component={AdminList}/>
            <Route path='/user_card' component={UserCard}/>
            <Route path='/user_update' component={UpdateUser}/>

            <Route path='/film_list' component={FilmList}/>
            <Route path='/add_film' component={AddFilm}/>
            <Route path='/film_update' component={UpdateFilm}/>
            <Route path='/film_card' component={FilmCard}/>

            <Route path='/language_list' component={LanguageList}/>
            <Route path='/studio_list' component={StudioList}/>
            <Route path='/country_list' component={CountryList}/>
            <Route path='/genre_list' component={GenreList}/>
            <Route path='/actor_list' component={ActorList}/>
            <Route path='/director_list' component={DirectorList}/>
            <Route path='/add_person' component={AddPerson}/>

            <Route path='/hall_list' component={HallList}/>
            <Route path='/add_hall' component={AddHall}/>
            <Route path='/hall_update' component={UpdateHall}/>
            <Route path='/hall_card' component={HallCard}/>

            <Route path='/seance_list' component={SeanceLIst}/>
            <Route path='/add_seance' component={AddSeance}/>
            <Route path='/seance_update' component={UpdateSeance}/>
            <Route path='/seance_card' component={SeanceCard}/>
        </Switch>
    </div>
)