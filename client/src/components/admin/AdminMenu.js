import React, {Component} from 'react';

import '../../style/AdminMenu.css'

class AdminMenu extends Component {
    constructor(props) {
        super(props);

        this.state = {
            users: []
        }
    }

    render() {
        return (
            <div id="sidebar">
                <ul id="navbar">
                    <li><a href="/user_list">Users</a></li>
                    <li><a href="/admin_list">Admins</a></li>
                    <li><a href="/film_list">Films</a></li>
                    <ul>
                        <li><a href="/language_list">Languages</a></li>
                        <li><a href="/genre_list">Genres</a></li>
                        <li><a href="/studio_list">Studios</a></li>
                        <li><a href="/country_list">Countries</a></li>
                        <li><a href="/actor_list">Actors</a></li>
                        <li><a href="/director_list">Directors</a></li>
                    </ul>
                    <li><a href="/hall_list">Halls</a></li>
                    <li><a href="/seance_list">Seances</a></li>
                    {/*<li><a href="/">To cinema</a></li>*/}
                </ul>
            </div>
        );
    }
}

export default AdminMenu;