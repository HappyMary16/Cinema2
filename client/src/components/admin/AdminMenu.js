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
                    {/*<li><a href="/admin/films">Films</a></li>*/}
                    {/*<ul>*/}
                        {/*<li><a href="/admin/films/genres">Genres</a></li>*/}
                        {/*<li><a href="/admin/films/studios">Studios</a></li>*/}
                        {/*<li><a href="/admin/films/countries">Countries</a></li>*/}
                        {/*<li><a href="/admin/films/actors">Actors</a></li>*/}
                        {/*<li><a href="/admin/films/directors">Directors</a></li>*/}
                    {/*</ul>*/}
                    {/*<li><a href="/admin/halls">Halls</a></li>*/}
                    {/*<li><a href="/admin/seances">Seances</a></li>*/}
                    {/*<li><a href="/">To cinema</a></li>*/}
                </ul>
            </div>
        );
    }
}

export default AdminMenu;