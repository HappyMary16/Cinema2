import React, {Component} from 'react';
import axios from 'axios';

import AdminMenu from "../AdminMenu";
import '../../../style/DataForm.css'

class AddFilm extends Component {
    constructor(props) {
        super(props);

        this.state = {
            id: '',
            title: '',
            description: '',
            year: '',
            minAge: '',
            duration: '',
            genres: {},
            directors: {},
            actors: {},
            studios: {},
            countries: {},
            language: '',
            firstSeance: '',
            lastSeance: '',
            smallPoster: '',
            bigPoster: '',
            trailerLink: ''
        }
    }

    titleChangeHandler = (name) => {
        this.setState({title: name})
    };

    descriptionChangeHandler = (name) => {
        this.setState({description: name})
    };

    yearChangeHandler = (name) => {
        this.setState({year: name})
    };

    minAgeChangeHandler = (name) => {
        this.setState({minAge: name})
    };

    durationChangeHandler = (name) => {
        this.setState({duration: name})
    };

    genresChangeHandler = (name) => {
        //create list from string
        this.setState({genres: name})
    };

    directorsChangeHandler = (name) => {
        //create list from string
        this.setState({directors: name})
    };

    actorsChangeHandler = (name) => {
        //create list from string
        this.setState({actors: name})
    };

    studiosChangeHandler = (name) => {
        //create list from string
        this.setState({studios: name})
    };

    countriesChangeHandler = (name) => {
        //create list from string
        this.setState({countries: name})
    };

    languageChangeHandler = (name) => {
        console.log(name);
        this.setState({language: name})
    };

    firstSeanceChangeHandler = (name) => {
        console.log(name);
        this.setState({firstSeance: name})
    };

    lastSeanceChangeHandler = (name) => {
        console.log(name);
        this.setState({lastSeance: name})
    };

    smallPosterChangeHandler = (name) => {
        console.log(name);
        this.setState({smallPoster: name})
    };

    bigPosterChangeHandler = (name) => {
        console.log(name);
        this.setState({bigPoster: name})
    };

    trailerLinkChangeHandler = (name) => {
        console.log(name);
        this.setState({trailerLink: name})
    };

    addUserHandler = () => {
        let user = {
            title: this.state.title,
            description: this.state.description,
            minAge: this.state.minAge,
            genres: this.state.genres,
            directors: this.state.directors,
            actors: this.state.actors,
            studios: this.state.studios,
            countries: this.state.countries,
            duration: this.state.duration,
            language: this.state.language,
            firstSeance: this.state.firstSeance,
            lastSeance: this.state.lastSeance,
            smallPoster: this.state.countries,
            bigPoster: this.state.bigPoster,
            trailerLink: this.state.trailerLink,
            year: this.state.year
        };
        const ADD_USER_URL = "http://localhost:8080/genres/add";
        console.log(this.state.roleId);
        axios.post(ADD_USER_URL, user)
            .then("1" === this.state.roleId
                ? this.props.history.push("/admin_list")
                : this.props.history.push("/user_list"));
    };

    render() {
        return (
            <div className="wrapper">
                <AdminMenu/>
            <div className="userForm" id="content">
                <p><input type="text" placeholder="firstName"
                          onChange={e => this.firstNameChangeHandler(e.target.value)}/></p>
                <p><input type="text" placeholder="lastName"
                          onChange={e => this.lastNameChangeHandler(e.target.value)}/></p>
                <p><input type="text" placeholder="login" onChange={e => this.loginChangeHandler(e.target.value)}/></p>
                <p><input type="text" placeholder="password"
                          onChange={e => this.passwordChangeHandler(e.target.value)}/></p>
                <p><input type="text" placeholder="phone" onChange={e => this.phoneChangeHandler(e.target.value)}/></p>
                <p><input type="text" placeholder="email" onChange={e => this.emailChangeHandler(e.target.value)}/></p>
                <p><select placeholder="roleId" onChange={e => this.roleChangeHandler(e.target.value)}>
                    <option value="1">Admin</option>
                    <option value="2">User</option>
                </select></p>
                <p>
                    <button type="submit" onClick={this.addUserHandler}>Add user</button>
                </p>
            </div>
            </div>
        );
    }
}

export default AddFilm;